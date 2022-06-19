package com.company;

import RSA.Decrypt;
import RSA.Encrypt;
import RSA.GenerateKey;
import files.ReadFile;
import models.Keys;
import models.Message;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    static Keys keys = new Keys();
    static Message message = new Message();
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.println("Digite o texto que deseja encriptar no arquivo sms.txt \n NOTA: De preferencia escrever em 1 linha\n\n\n");
        menuOp();
        for (;;){
            int x = input.nextInt();
            if (x==5) break;
            menu(x, input);
        }
    }

    static void menu(int op, Scanner in) throws IOException {
        switch (op){
            case 1:
                GenerateKey generateKey = new GenerateKey();
                keys.n = generateKey.getN();
                keys.d = generateKey.getD();
                keys.e = generateKey.getE();
                System.out.println("Chaves geradas com sucesso");
                break;
            case 2:
                if (keys.n == null && keys.e == null){
                    System.out.println("Insire as chaves manualmente");
                    System.out.println("N: ");
                    keys.n = new BigInteger(String.valueOf(in.nextInt()));
                    System.out.println("E: ");
                    keys.e = new BigInteger(String.valueOf(in.nextInt()));
                }
                Encrypt encrypt = new Encrypt(keys.n, keys.e);
                ReadFile readFile = new ReadFile();
                String smsFile = ReadFile.read();
                message.content = encrypt.encryptor(smsFile);
                System.out.println("Texto encriptado com sucesso");
                break;

            case 3:
                Decrypt decrypt = new Decrypt(keys.d, keys.n);
                message.content = decrypt.decifarad(message.content);
                System.out.println("Texto decifrado com sucesso");

                break;
            case 4:
                System.out.println(message.content == null ? "" : message.content);
                break;
            default:
                menuOp();
                break;
        }
    }
    static void menuOp(){
         System.out.println("1->gerar chaves \n 2 ->encriptar o texto que esta em sms.txt \n 3->decriptar o texto recem encriptado \n 4-> imprimir a mensagem \n 5 -> terminar");
    }
}
