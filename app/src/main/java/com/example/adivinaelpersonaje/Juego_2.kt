package com.example.adivinaelpersonaje

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import com.google.android.material.bottomsheet.BottomSheetDialog
import org.json.JSONObject
import java.util.*

class Juego_2 : Activity() {
    // variables para los componentes de la vista
    var msj = arrayOfNulls<TextView>(10)
    private  var CurrentPlayerID: Int = -1
    lateinit var env:EditText
    private var SocketO: String = ""
    var imb00: ImageButton? = null
    var imb01: ImageButton? = null
    var imb02: ImageButton? = null
    var imb03: ImageButton? = null
    var imb04: ImageButton? = null
    var imb05: ImageButton? = null
    var imb06: ImageButton? = null
    var imb07: ImageButton? = null
    var imb08: ImageButton? = null
    var imb09: ImageButton? = null
    var imb10: ImageButton? = null
    var imb11: ImageButton? = null
    var imb12: ImageButton? = null
    var imb13: ImageButton? = null
    var imb14: ImageButton? = null
    var imb15: ImageButton? = null
    var imb16: ImageButton? = null
    var imb17: ImageButton? = null
    var imb18: ImageButton? = null
    var imb19: ImageButton? = null
    var imb20: ImageButton? = null
    var imb21: ImageButton? = null
    var imb22: ImageButton? = null
    var imb23: ImageButton? = null
    var imbp: ImageButton? = null
    var tablero = arrayOfNulls<ImageButton>(24)
    lateinit var botonReiniciar: Button
    lateinit var botonSalir: Button
    lateinit var e: String
    lateinit var eO: String
    var per: TextView? = null
    var nom = arrayOf(
        "Gato",
        "Perro",
        "Caracol",
        "Conejo",
        "Aguila",
        "Mariposa",
        "Pez",
        "Cotorro",
        "Dragon",
        "Unicornio",
        "Fenix",
        "Pegaso",
        "Fauno",
        "Minotauro",
        "Kraken",
        "Centauro",
        "Tiburon",
        "Delfin",
        "Pez Globo",
        "Pez Espada",
        "Ballena",
        "Mantarraya",
        "Medusa",
        "Cangrejo"
    )

    //imagenes
    lateinit var imagenes: IntArray
    var fondo = 0
    var p = 0
    var pO = 0

    //variables del juego
    var arrayDesordenado: ArrayList<Int?>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.juego_2)
        e = intent.getStringExtra("personaje").toString()
        eO = intent.getStringExtra("personajeO").toString()
        pO = eO.toInt()
        p = e.toInt()
        val str: String? = intent.getStringExtra("currentid")
        CurrentPlayerID = str.toString().toInt()
        SocketO = intent.getStringExtra("socket_o").toString()
        init()


        println("El personaje del oponente es :"+pO)

        val chat = findViewById<Button>(R.id.chat)
        chat.setOnClickListener {
            val bottom1 = BottomSheetDialog(
                this@Juego_2
            )
            val bott = LayoutInflater.from(applicationContext)
                .inflate(
                    R.layout.emergente,
                    findViewById<LinearLayout>(R.id.bottomcontainer)
                )
            msj[0] = bott.findViewById(R.id.msg1)
            msj[1] = bott.findViewById(R.id.msg2)
            msj[2] = bott.findViewById(R.id.msg3)
            msj[3] = bott.findViewById(R.id.msg4)
            msj[4] = bott.findViewById(R.id.msg5)
            msj[5] = bott.findViewById(R.id.msg6)
            msj[6] = bott.findViewById(R.id.msg7)
            msj[7] = bott.findViewById(R.id.msg8)
            msj[8] = bott.findViewById(R.id.msg9)
            msj[9] = bott.findViewById(R.id.msg10)
            bott.findViewById<View>(R.id.gchat).setOnClickListener {
                Toast.makeText(this@Juego_2, "Cerrando chat", Toast.LENGTH_SHORT).show()
                bottom1.dismiss()
            }
            bott.findViewById<View>(R.id.enviar).setOnClickListener {
                env = bott.findViewById(R.id.enviado)
                msj[8]?.setText(msj[6]?.text)
                msj[6]?.setText(msj[4]?.text)
                msj[4]?.setText(msj[2]?.text)
                msj[2]?.setText(msj[0]?.text)
                msj[0]?.setText(env.text)
            }
            bottom1.setContentView(bott)
            bottom1.show()
        }
        val mSocket = SocketHandler.getSocket()
        val data = JSONObject();
        data.put("socketIDO",SocketO);


    }

    private fun cargarTablero() {
        imb00 = findViewById(R.id.boton00)
        imb01 = findViewById(R.id.boton01)
        imb02 = findViewById(R.id.boton02)
        imb03 = findViewById(R.id.boton03)
        imb04 = findViewById(R.id.boton04)
        imb05 = findViewById(R.id.boton05)
        imb06 = findViewById(R.id.boton06)
        imb07 = findViewById(R.id.boton07)
        imb08 = findViewById(R.id.boton08)
        imb09 = findViewById(R.id.boton09)
        imb10 = findViewById(R.id.boton10)
        imb11 = findViewById(R.id.boton11)
        imb12 = findViewById(R.id.boton12)
        imb13 = findViewById(R.id.boton13)
        imb14 = findViewById(R.id.boton14)
        imb15 = findViewById(R.id.boton15)
        imb16 = findViewById(R.id.boton16)
        imb17 = findViewById(R.id.boton17)
        imb18 = findViewById(R.id.boton18)
        imb19 = findViewById(R.id.boton19)
        imb20 = findViewById(R.id.boton20)
        imb21 = findViewById(R.id.boton21)
        imb22 = findViewById(R.id.boton22)
        imb23 = findViewById(R.id.boton23)
        imbp = findViewById(R.id.personaje)
        per = findViewById(R.id.textView2)
        tablero[0] = imb00
        tablero[1] = imb01
        tablero[2] = imb02
        tablero[3] = imb03
        tablero[4] = imb04
        tablero[5] = imb05
        tablero[6] = imb06
        tablero[7] = imb07
        tablero[8] = imb08
        tablero[9] = imb09
        tablero[10] = imb10
        tablero[11] = imb11
        tablero[12] = imb12
        tablero[13] = imb13
        tablero[14] = imb14
        tablero[15] = imb15
        tablero[16] = imb16
        tablero[17] = imb17
        tablero[18] = imb18
        tablero[19] = imb19
        tablero[20] = imb20
        tablero[21] = imb21
        tablero[22] = imb22
        tablero[23] = imb23
    }

    private fun cargarBotones() {
        botonReiniciar = findViewById(R.id.botonJuegoReiniciar)
        botonSalir = findViewById(R.id.botonJuegoSalir)
        botonReiniciar.setOnClickListener(View.OnClickListener { reset() })
        botonSalir.setOnClickListener(View.OnClickListener { finish() })
    }

    private fun reset() {
        for (i in tablero.indices) {
            tablero[i]!!.scaleType = ImageView.ScaleType.CENTER_CROP
            tablero[i]!!.setImageResource(imagenes[arrayDesordenado!![i]!!])
            tablero[i]!!.isEnabled = true
            //tablero[i].setImageResource(fondo);
        }
    }

    private fun cargarImagenes() {
        imagenes = intArrayOf(
            R.drawable.la0,
            R.drawable.la1,
            R.drawable.la2,
            R.drawable.la3,
            R.drawable.la4,
            R.drawable.la5,
            R.drawable.la6,
            R.drawable.la7,
            R.drawable.la8,
            R.drawable.la9,
            R.drawable.la10,
            R.drawable.la11,
            R.drawable.la12,
            R.drawable.la13,
            R.drawable.la14,
            R.drawable.la15,
            R.drawable.la16,
            R.drawable.la17,
            R.drawable.la18,
            R.drawable.la19,
            R.drawable.la20,
            R.drawable.la21,
            R.drawable.la22,
            R.drawable.la23
        )
        fondo = R.drawable.fondo
    }

    private fun barajar(longitud: Int): ArrayList<Int?> {
        val result = ArrayList<Int?>()
        for (i in 0 until longitud) {
            result.add(i)
        }
        Collections.shuffle(result)
        // System.out.println(Arrays.toString(result.toArray()));
        return result
    }

    private fun init() {
        cargarTablero()
        cargarBotones()
        cargarImagenes()
        println(e)
        arrayDesordenado = barajar(imagenes.size)
        imbp!!.isEnabled = false
        for (i in tablero.indices) {
            tablero[i]!!.scaleType = ImageView.ScaleType.CENTER_CROP
            tablero[i]!!.setImageResource(imagenes[arrayDesordenado!![i]!!])
            //tablero[i].setImageResource(fondo);
        }
        imbp!!.scaleType = ImageView.ScaleType.CENTER_CROP
        imbp!!.setImageResource(imagenes[p])
        per!!.text = "Personaje " + nom[p]
        for (i in tablero.indices) {
            tablero[i]!!.isEnabled = true
            tablero[i]!!.setOnClickListener { /*if(!bloqueo)
                        comprobar(j, tablero[j]);*/
                val aux = tablero[i]
                aux!!.scaleType = ImageView.ScaleType.CENTER_CROP
                aux.setImageResource(fondo)
                aux.isEnabled = false
            }
        }
    }
}