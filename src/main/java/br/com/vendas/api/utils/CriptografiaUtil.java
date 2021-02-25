/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vendas.api.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author sleandro
 */
public class CriptografiaUtil {

    public static String encriptografarSenha(String senha) throws NoSuchAlgorithmException {
        // Criptografando a senha do novo Usuário
        MessageDigest md = MessageDigest.getInstance("MD5"); // or "SHA -1"
        md.update(senha.getBytes());
        BigInteger hash = new BigInteger(1, md.digest());
        String senhaCriptografada = hash.toString(16);
        while (senhaCriptografada.length() < 32) { // 40 for SHA -1
            senhaCriptografada = "0" + senhaCriptografada;
        }

        return senhaCriptografada;
    }

}
