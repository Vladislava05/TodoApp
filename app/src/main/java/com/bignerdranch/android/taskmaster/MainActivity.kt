package com.bignerdranch.android.taskmaster



import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle



import androidx.recyclerview.widget.LinearLayoutManager
import com.bignerdranch.android.taskmaster.databinding.ActivityMainBinding



class MainActivity : AppCompatActivity() {

    private lateinit var todoAdapter:TodoAdapter
    private lateinit var binding: ActivityMainBinding
    private var todos: MutableList<Todo> = mutableListOf()
    private var dones: MutableList<Todo> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)




        todoAdapter = TodoAdapter(todos, dones)
        binding.rvTodoItems.adapter = todoAdapter
        binding.rvTodoItems.layoutManager = LinearLayoutManager(this)


        binding.btnAddTodo.setOnClickListener{
            NewTaskSheet().show(supportFragmentManager,"NewTaskTag")
            }
        supportFragmentManager.setFragmentResultListener("requestKey",this){ requestKey,bundle ->
            val newTodo=bundle.getSerializable("bundleKey") as Todo
            todos.add(newTodo)
            todoAdapter.notifyDataSetChanged()
        }

        binding.btnTodoDone.setOnClickListener{

            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
        binding.btnTodoDone.text="Done"+"(${dones.size.toString()})"
    }



}