<?php

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Description of ServicioProveedor
 *
 * @author Natalia
 */
class ServicioProveedor {
   
    function listaProveedores(){
        $url="http://localhost:35056/WebServiceMpit/webresources/entidades.pproproveedor";
        $ch= curl_init();
        curl_setopt($ch, CURLOPT_URL, $url);
    }
}
