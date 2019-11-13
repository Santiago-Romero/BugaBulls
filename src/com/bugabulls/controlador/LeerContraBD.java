package com.bugabulls.controlador;

import java.io.*;
public class LeerContraBD {
	int vez=0;
	public String usuarioG="";
	public String contraG="";
	public LeerContraBD(){
		try{
                    FileReader fr= new FileReader("claveBD.txt");
                    BufferedReader br= new BufferedReader(fr);
                    String escrito ="";
			while((escrito=br.readLine())!=null){
				for(int i=0;i<escrito.length();i++){
					if(vez==0){
						usuarioG+=escrito.substring(i,i+1);
						if(escrito.substring(i,i+1).equals("*"))
						{
							usuarioG=usuarioG.substring(0,usuarioG.length()-1);
							vez++;
							}
						}
					if(vez==1){
						contraG+=escrito.substring(i,i+1);
						if(escrito.substring(i,i+1).equals("-")){
							contraG=contraG.substring(1,contraG.length()-1);
							}
						}
					}
				}
			}
		catch(Exception B){
			System.out.println(B);
		}
		vez=0;
		}
	}