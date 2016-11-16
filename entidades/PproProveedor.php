<?php

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Description of PproProveedor
 *
 * @author Natalia
 */
class PproProveedor {
    private $idProveedor;
    private $provRazonSocail;
    private $provEstado;
    private $provPerId;
    function __construct() {
        
    }
    function getIdProveedor() {
        return $this->idProveedor;
    }

    function getProvRazonSocail() {
        return $this->provRazonSocail;
    }

    function getProvEstado() {
        return $this->provEstado;
    }

    function getProvPerId() {
        return $this->provPerId;
    }

    function setIdProveedor($idProveedor) {
        $this->idProveedor = $idProveedor;
    }

    function setProvRazonSocail($provRazonSocail) {
        $this->provRazonSocail = $provRazonSocail;
    }

    function setProvEstado($provEstado) {
        $this->provEstado = $provEstado;
    }

    function setProvPerId($provPerId) {
        $this->provPerId = $provPerId;
    }



}
