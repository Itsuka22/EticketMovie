package com.handoyo.eticketkotlin.sign

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.*
import com.handoyo.eticketkotlin.R

import com.handoyo.eticketkotlin.MainActivity
import java.util.*


class SignInActivity : AppCompatActivity() {

    lateinit var iUsername:String
    lateinit var iPassword:String

    lateinit var mDatabase: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        mDatabase = FirebaseDatabase.getInstance().getReference("User")

        val btnMasuk:Button=findViewById(R.id.btn_masuk)
        val etUsername:EditText=findViewById(R.id.et_username)
        val etPassword:EditText=findViewById(R.id.et_password)

        btnMasuk.setOnClickListener {
            iUsername = etUsername.text.toString()
            iPassword = etPassword.text.toString()

            if (iUsername.equals("")){
                etUsername.error = "Silahkan tulis Username Anda"
                etUsername.requestFocus()
            } else if (iPassword.equals("")){
                etPassword.error = "Silahkan tulis Password Anda"
                etPassword.requestFocus()
            } else {
                pushLogin(iUsername, iPassword)
            }

            val btnDaftar:Button=findViewById(R.id.btn_daftarakun)
            btnDaftar.setOnClickListener {
                var goSignUp = Intent (this@SignInActivity, SignUpActivity::class.java )
                startActivity(goSignUp)
            }


        }
    }

    private fun pushLogin(iUsername: String, iPassword: String) {
        mDatabase.child(iUsername).addValueEventListener(object : ValueEventListener{
            override fun onCancelled(databaseError:DatabaseError) {
                Toast.makeText(this@SignInActivity , databaseError.message,
                    Toast.LENGTH_LONG).show()
            }

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                var user   = dataSnapshot.getValue(User::class.java)
                    if (user == null){
                        Toast.makeText(this@SignInActivity , "User tidak ditemukan",
                            Toast.LENGTH_LONG).show()
                    } else {
                        if (user.password.equals(iPassword)){
                            var intent = Intent(this@SignInActivity, MainActivity::class.java)
                            startActivity(intent)
                        } else {
                            Toast.makeText(this@SignInActivity , "Password anda salah",
                                Toast.LENGTH_LONG).show()
                        }


                    }

            }



        })
    }
}