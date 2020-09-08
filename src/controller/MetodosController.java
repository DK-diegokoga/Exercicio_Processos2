package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MetodosController {
		
	public MetodosController() {
		super();
	}
		public String xSO() {
			return System.getProperty("os.name");
		}
		public void Processos(String SO) {
			if(SO.contains("Windows")) {
				try {
					Process p = Runtime.getRuntime().exec("tasklist");//comando windows
					InputStream fluxo = p.getInputStream();
					InputStreamReader leitor = new InputStreamReader(fluxo);
					BufferedReader buffer = new BufferedReader(leitor);
					String linha = buffer.readLine();
					while(linha!=null) {
						System.out.println(linha);
						linha = buffer.readLine();
					}
				}catch(IOException e) {
					e.printStackTrace();
				}
			}else {
				try {
					Process p = Runtime.getRuntime().exec("ps -ef");//comando linux
					InputStream fluxo = p.getInputStream();
					InputStreamReader leitor = new InputStreamReader(fluxo);
					BufferedReader buffer = new BufferedReader(leitor);
					String linha = buffer.readLine();
					while(linha != null) {
						System.out.println(linha);
						linha = buffer.readLine();
					}
				}catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		public void KillPID(String SO, int PID) {
			if(SO.contains("Windows")) {
				try {
					Runtime.getRuntime().exec("taskkill /PID " + PID);//comando windows
				}catch (IOException e) {
					e.printStackTrace();
				}
			}else {
				try {
					Runtime.getRuntime().exec("kill -9" + PID);//comando linux
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
	
		}
		public void KillNAME(String SO, String NOME) {
			if(SO.contains("Windows")) {
				try {
					Runtime.getRuntime().exec("taskkill /IM " + NOME);
				}catch(IOException e) {
					e.printStackTrace();
				}
			}else {
				try {
					Runtime.getRuntime().exec("pkill" + NOME);
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
		}
}