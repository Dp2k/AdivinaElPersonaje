package com.example.adivinaelpersonaje


import io.socket.client.IO
import io.socket.client.Socket
import java.net.URISyntaxException

object SocketHandler {
    lateinit var  mSocket: Socket
//Holamamada
    @Synchronized
    fun setSocket(){
        try{
            mSocket = IO.socket("http://guesswho.danielpacheco.com.mx:3000")
        }catch(e: URISyntaxException){

        }
    }

    @Synchronized
    fun getSocket(): Socket {
        return  mSocket
    }
}