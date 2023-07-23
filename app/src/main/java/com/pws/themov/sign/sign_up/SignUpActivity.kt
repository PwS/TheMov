package com.pws.themov.sign.sign_up

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.pws.themov.databinding.ActivitySignUpBinding
import com.pws.themov.sign.models.User

class SignUpActivity : AppCompatActivity() {

    private lateinit var sUserName: String
    private lateinit var sPassword: String
    private lateinit var sName: String
    private lateinit var sEmail: String

    private lateinit var mFirebaseDatabaseReference: DatabaseReference
    private lateinit var mFirebaseInstance: FirebaseDatabase

    private lateinit var binding: ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mFirebaseInstance = FirebaseDatabase.getInstance()
        mFirebaseDatabaseReference = mFirebaseInstance.getReference("User")


        binding.btnSignup.setOnClickListener {
            sUserName = binding.etUsername.text.toString()
            sPassword = binding.etPassword.text.toString()
            sName = binding.etName.text.toString()
            sEmail = binding.etEmail.text.toString()


            if (sUserName == "") {
                binding.etUsername.error = "Silahkan Isi Username Anda"
                binding.etUsername.requestFocus()
            } else if (sPassword == "") {
                binding.etPassword.error = "Silahkan Isi Password Anda"
                binding.etPassword.requestFocus()
            } else if (sName == "") {
                binding.etName.error = "Silahkan Isi Nama Anda"
                binding.etName.requestFocus()
            } else if (sEmail == "") {
                binding.etEmail.error = "Silahkan Isi Email Anda"
                binding.etEmail.requestFocus()
            } else {
                saveUser(sUserName, sPassword, sName, sEmail)
            }

        }

    }

    private fun saveUser(sUserName: String, sPassword: String, sName: String, sEmail: String) {
        val user = User()
        user.userName = sUserName
        user.password = sPassword
        user.name = sName
        user.email = sEmail

        checkUserName(sUserName, user)
    }

    private fun checkUserName(sUserName: String, dataUser: User) {
        mFirebaseDatabaseReference.child(sUserName)
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    val existingUser = dataSnapshot.getValue(User::class.java)

                    if (existingUser != null) {
                        return Toast.makeText(
                            this@SignUpActivity,
                            "User sudah digunakan",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    ///If User Not Exists , Create the Data


                    mFirebaseDatabaseReference.child(sUserName).setValue(dataUser)
                    val intent = Intent(
                        this@SignUpActivity,
                        SignUpPhotoScreenActivity::class.java
                    ).putExtra("data", dataUser.name)
                    startActivity(intent)
                }

                override fun onCancelled(error: DatabaseError) {
                    Toast.makeText(this@SignUpActivity, "Error ${error.message}", Toast.LENGTH_LONG)
                        .show()
                }
            })
    }
}