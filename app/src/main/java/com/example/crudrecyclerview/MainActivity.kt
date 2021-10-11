package com.example.crudrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var inputNis : EditText
    private lateinit var inputNama : EditText
    private lateinit var jkLakiLaki : RadioButton
    private lateinit var jkPerempuan : RadioButton
    private lateinit var btnTambah : Button
    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inputNama = findViewById(R.id.txtInputNama)
        inputNis = findViewById(R.id.inputNIS)
        jkLakiLaki = findViewById(R.id.rbLakiLaki)
        jkPerempuan = findViewById(R.id.rbPerempuan)
        recyclerView = findViewById(R.id.listData)
        btnTambah = findViewById(R.id.btTambahData)
        // Membuat variabel kosong tipe array Mutabelist untk simpan data array
        // data array di simpan didata class siswaData
        val data = mutableListOf<siswaData>()
        viewManager = LinearLayoutManager(this)
        recyclerAdapter = SiswAdapter(data)
        recyclerView.adapter = recyclerAdapter
        recyclerView.layoutManager = viewManager
        // set OnclikListener untuk tombol tambah data
        btnTambah.setOnClickListener {
            //1. membuat variabel penyimpan data
            val nis = inputNis.text.toString()
            val nama = inputNama.text.toString()
            var jk = ""
            if (jkLakiLaki.isChecked){
                jk = "Laki-Laki"
            } else{
                jk = "Perempuan"
            }
            // simpan data ke array mutablelist
            val dataSiswa = siswaData(nis, nama, jk)
            data.add(dataSiswa)
            recyclerAdapter.notifyDataSetChanged()
        }
    }
}