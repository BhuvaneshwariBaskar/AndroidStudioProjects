package com.example.quizify

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.RecyclerView
import com.example.quizify.databinding.ActivityLoginBinding
import com.example.quizify.databinding.ActivityQuanBinding

class QuanActivity : AppCompatActivity() {
    private lateinit var binding: ActivityQuanBinding
    var quansTopics: ArrayList<QuansTopics> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityQuanBinding.inflate(layoutInflater)
        val view: View = binding.getRoot()
        setContentView(view)
        quansTopics.add(QuansTopics("Hello"))
        quansTopics.add(QuansTopics("Hello1"))
        quansTopics.add(QuansTopics("Hello2"))
        quansTopics.add(QuansTopics("Hello3"))
        quansTopics.add(QuansTopics("Hello4"))
        quansTopics.add(QuansTopics("Hello5"))
        var recyclerView:RecyclerView=binding.quansRecycle

        var topicAdapter = QuansTopicAdapter(this,R.layout.fragment_quans_topic,quansTopics)

        var quansdata=QuansTopics("")
//        val quansTopicFragment=QuansTopicFragment()
//        val fragmentManager: FragmentManager=supportFragmentManager
//        val fragmentTransaction:FragmentTransaction=fragmentManager.beginTransaction()
//        fragmentTransaction.replace(R.id.activity_quan,quansTopicFragment).commit()
    }
}