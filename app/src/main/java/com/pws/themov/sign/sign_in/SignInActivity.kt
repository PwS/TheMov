package com.pws.themov.sign.sign_in

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.pws.themov.HomeActivity
import com.pws.themov.databinding.ActivitySignInBinding
import com.pws.themov.sign.models.User
import com.pws.themov.sign.sign_up.SignUpActivity
import com.pws.themov.sign.util.Preferences

class SignInActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignInBinding


    private lateinit var iUserName: String
    private lateinit var iPassword: String

    private lateinit var mDatabase: DatabaseReference
    private lateinit var preferences: Preferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mDatabase = FirebaseDatabase.getInstance().getReference("User")
        preferences = Preferences(this)

        ///If Already Read All OnBoarding Status , Then The OnBoarding Page will not Show again
        preferences.setValue("onBoarding", "1")


        if (preferences.getValue("statusLogin") == "1") {
            finishAffinity()

            val goHome = Intent(this@SignInActivity, HomeActivity::class.java)
            startActivity(goHome)

        }

        binding.btnSignIn.setOnClickListener {
            iUserName = binding.etUsername.text.toString()
            iPassword = binding.etPassword.text.toString()


            if (iUserName == "") {
                binding.etUsername.error = "Silahkan Tulis Username Anda"
                binding.etUsername.requestFocus()
            } else if (iPassword == "") {
                binding.etPassword.error = "Silahkan Tulis Password Anda"
                binding.etPassword.requestFocus()
            } else {
                pushLogin(iUserName, iPassword)
            }

        }

        binding.btnSignUp.setOnClickListener {
            val intent = Intent(this@SignInActivity, SignUpActivity::class.java)
            startActivity(intent)
        }

    }

    private fun pushLogin(iUserName: String, iPassword: String) {
        mDatabase.child(iUserName).addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val user = dataSnapshot.getValue(User::class.java)
                if (user == null) {
                    Toast.makeText(
                        this@SignInActivity,
                        "Username tidak ditemukan",
                        Toast.LENGTH_LONG
                    ).show()
                } else {

                    if (user.password == iPassword) {


                        preferences.setValue("name", user.name.toString())
                        preferences.setValue("userName", user.userName.toString())
                        preferences.setValue(
                            "urlPictureProfile",
                            user.urlPictureProfile.toString()
                        )
                        preferences.setValue("email", user.email.toString())
                        preferences.setValue("balance", user.balance.toString())
                        ///Status Login - 1 : Already Login , 2 : Not Login
                        preferences.setValue("statusLogin", "1")

                        val intent = Intent(this@SignInActivity, HomeActivity::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(
                            this@SignInActivity,
                            "Password Salah",
                            Toast.LENGTH_LONG
                        ).show()
                    }


                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
                Toast.makeText(
                    this@SignInActivity,
                    databaseError.message,
                    Toast.LENGTH_LONG
                ).show()
            }
        })
    }
}