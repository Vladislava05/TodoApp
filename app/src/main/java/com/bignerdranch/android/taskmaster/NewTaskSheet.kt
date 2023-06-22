package com.bignerdranch.android.taskmaster

import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult

import com.bignerdranch.android.taskmaster.databinding.FragmentNewTaskSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment



class NewTaskSheet() : BottomSheetDialogFragment(){

    private lateinit var binding: FragmentNewTaskSheetBinding
    private lateinit var todo: Todo




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNewTaskSheetBinding.inflate(inflater,container,false)

        return binding.root
    }

    override fun onViewCreated(view:View,savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
            todo = Todo(title="",description="",isChecked = false)
            binding.btnSave.setOnClickListener {
               todo.title=binding.title.text.toString()

               binding.title.setText("")
               binding.description.setText("")
               setFragmentResult("requestKey" , bundleOf("bundleKey" to todo))
                dismiss()

           }


    }




}