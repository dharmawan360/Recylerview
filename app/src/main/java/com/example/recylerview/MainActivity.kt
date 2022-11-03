package com.example.recylerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.recyclerview.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "Universitas Baik Laku"

        val grpTampilam = findViewById<RadioGroup>(R.id.grpTampilan)
        val rvProdi = findViewById<RecyclerView>(R.id.rvprodi)

        rvProdi.layoutManager = LinearLayoutManager(this@MainActivity)
        val listProdi = arrayListOf(
            prodi("#FF7F00","S1","Teknik Informatika","Fakultas Teknologi Informasi",arrayOf(
                "Cyber Security","Programming Expert","Artificial Intelegent"
            )),
            prodi("#0000FF","S1","Sistem Informasi","Fakultas Teknologi Informasi",arrayOf(
                "Sistem Enterprise","Digitalpreneurship","Data Science"
            )),
            prodi("#B2FFFF","S1","Sistem Komputer","Fakultas Teknologi Informasi",arrayOf(
                "Embedded System & Internet Things","Robotics"
            )),
            prodi("#FFFF00","D3","Manajemen Informatika","Fakultas Teknologi Informasi",arrayOf(
                "Mobile Application  Development","Interactive Digital Design","Network Enginerring"
            )),
            prodi("#4B3621","D3","Komputerisasi Akuntasi","Fakultas Teknologi Informasi",arrayOf(
                "Accounting Information System","Digital Business"
            )),
            prodi("#000000","S2","Ilmu Komputer","Fakultas Teknologi Informasi",arrayOf(
                "Teknologi Sistem Informasi","Rekayasa Komputasi Terapan"
            )),
            prodi("#006B3C","S1","Manajemen","Fakultas Ekonomi dan bisnis",arrayOf(
                "Corporate Finance and Capital Markets","Marketing & Digital Business","Strategic Human Resource Management","Internasional Business Management"
                ,"Renewable Energy and Natural Resource Management"
            )),
            prodi("#FFFF99","S1","Akuntansi","Fakultas Ekonomi dan bisnis",arrayOf(
                "Managerial Accounting","Audit Assurance","Tax Accounting","Business Analytics",
                "Corporate Governance and CSR"
            )),
            prodi("#7F1734","S1","Manajemen Bencana","Fakultas Ekonomi dan bisnis"),
            prodi("#B03060","D3","Sekretari","Fakultas Ekonomi dan bisnis"),
            prodi("#353839","S2","Manajemen","Fakultas Ekonomi dan bisnis",arrayOf(
                "Marketing Management","Financial Management","Human Resource Management","Management Information Systems",
                "Education Management"
            )),
            prodi("#32127A","S2","Akuntansi","Fakultas Ekonomi dan bisnis",arrayOf(
                "Akuntansi Keuangan","Akuntansi Manajemen","Audit","Perpajakan",
                "Sistem Informasi Akuntansi"
            )),
            prodi("#01796F","S1","Teknik Arsitektur","Fakultas Teknik",arrayOf(
                "Eco-Smart Real Estate","Smart Interior"
            )),
            prodi("#536878","S1","Teknik Elektro","Fakultas Teknik",arrayOf(
                "Telekomunikasi dan  Multimedia","Kontrol dan Otomasi Industri"
            )),
            prodi("#00FFFE","S1","Hubungan Internasional","Fakultas Ilmu Sosial dan Politik",arrayOf(
                "Ekonomi Politik Internasional","Diplomasi","Studi Kawasan"
            )),
            prodi("#00A86B","S1","Kriminologi","Fakultas Ilmu Sosial dan Politik",arrayOf(
                "Kriminologi Cyber","Kriminologi Jurnalistik","Manajemen Security"
            )),
            prodi("#F8DE7E","S1","Ilmu Komunikasi","Fakultas Komunikasi dan Desain Kreatif",arrayOf(
                "Broadcast Jounalism","Public Relation","Tourism Communication","Digital Media & Advertising"
            )),
            prodi("#727472","S1","Desain Komuniikasi Visual","Fakultas Komunikasi dan Desain Kreatif",arrayOf(
                "Game Development","Animation","Graphic Design"
            )),
            prodi("#FF0000","S2","Ilmu Komunikasi","Fakultas Komunikasi dan Desain Kreatif",arrayOf(
                "Corporate Public Relations","Marketing Communications","Media Industry Communications"
            ))
        )
        rvProdi.adapter = AdapterProdi(listProdi,"List",this@MainActivity)
        grpTampilam.setOnCheckedChangeListener{_, checkedId->
            val rdProdi = findViewById<RadioButton>(checkedId)
            val mode = "${rdProdi.text}"
            rvProdi.layoutManager = when(mode){
                "List" -> LinearLayoutManager(this@MainActivity)
                "Grid" -> GridLayoutManager(this@MainActivity,2)
                else -> StaggeredGridLayoutManager(2,LinearLayoutManager.VERTICAL)
            }
            val adapter = AdapterProdi(listProdi,mode,this@MainActivity)
            rvProdi.adapter = adapter
        }


    }
}