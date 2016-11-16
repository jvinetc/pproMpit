<?php

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Description of PproPersona
 *
 * @author Natalia
 */
class PproPersona {

    private $perId;
    private $perDigito;
    private $perRut;
    private $perRutComp;
    private $perNombre;
    private $perApePaterno;
    private $perApeMaterno;
    private $perDireccion;
    private $perTelefono;
    function __construct() {
        
    }
    
    function getPerId() {
        return $this->perId;
    }

    function getPerDigito() {
        return $this->perDigito;
    }

    function getPerRut() {
        return $this->perRut;
    }

    function getPerRutComp() {
        return $this->perRutComp;
    }

    function getPerNombre() {
        return $this->perNombre;
    }

    function getPerApePaterno() {
        return $this->perApePaterno;
    }

    function getPerApeMaterno() {
        return $this->perApeMaterno;
    }

    function getPerDireccion() {
        return $this->perDireccion;
    }

    function getPerTelefono() {
        return $this->perTelefono;
    }

    function setPerId($perId) {
        $this->perId = $perId;
    }

    function setPerDigito($perDigito) {
        $this->perDigito = $perDigito;
    }

    function setPerRut($perRut) {
        $this->perRut = $perRut;
    }

    function setPerRutComp($perRutComp) {
        $this->perRutComp = $perRutComp;
    }

    function setPerNombre($perNombre) {
        $this->perNombre = $perNombre;
    }

    function setPerApePaterno($perApePaterno) {
        $this->perApePaterno = $perApePaterno;
    }

    function setPerApeMaterno($perApeMaterno) {
        $this->perApeMaterno = $perApeMaterno;
    }

    function setPerDireccion($perDireccion) {
        $this->perDireccion = $perDireccion;
    }

    function setPerTelefono($perTelefono) {
        $this->perTelefono = $perTelefono;
    }



}
