    package com.example.dinningcallapp_project

    import android.content.Intent
    import android.os.Bundle
    import android.view.View
    import androidx.appcompat.app.AppCompatActivity
    import com.example.dinningcallapp_project.databinding.ActivityMainBinding

    class MainActivity : AppCompatActivity() {

        //view binding step 1)
        private var binding:ActivityMainBinding? = null
        override fun onCreate(savedInstanceState: Bundle?) {

            super.onCreate(savedInstanceState)

            //view binding step 2)
            binding = ActivityMainBinding.inflate(layoutInflater)

            //view binding step 3)
            // added setContentView function
            setContentView(binding?.root)



        }

        fun onClick(v: View) {
            when (v.id) {
                binding?.Sign?.id -> {
                    val intent = Intent(this, Sign1Activity::class.java)
                    startActivity(intent)
                }
            }
        }
    }