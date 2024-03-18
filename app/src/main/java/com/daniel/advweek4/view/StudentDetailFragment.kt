package com.daniel.advweek4.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.daniel.advweek4.R
import com.daniel.advweek4.databinding.FragmentStudentDetailBinding
import com.daniel.advweek4.model.Student
import com.daniel.advweek4.viewmodel.DetailViewModel
import com.daniel.advweek4.viewmodel.ListViewModel


class StudentDetailFragment : Fragment() {
    private lateinit var detailViewModel: DetailViewModel
    private lateinit var binding: FragmentStudentDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStudentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        detailViewModel = ViewModelProvider(this).get(DetailViewModel::class.java)

        detailViewModel.studentLD.observe(viewLifecycleOwner, Observer { student ->
            updateUI(student)
        })

        detailViewModel.fetch()
    }

    private fun updateUI(student: Student) {
        binding.textInputLayout1.editText?.setText(student.id)
        binding.textInputLayout2.editText?.setText(student.name)
        binding.textInputLayout3.editText?.setText(student.dob)
        binding.textInputLayout4.editText?.setText(student.phone)
    }
}