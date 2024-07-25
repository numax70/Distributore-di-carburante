/*
 *  Progettare e realizzare una classe Car(automobile) con le proprietà seguenti.
Un’automobile ha una determinata resa del carburante (misurata in miglia/galloni
o in litri/chilometri: scegliete il sistema che preferite) e una certa quantità
di carburante nel serbatoio. La resa è specificata dal costruttore e il livello
iniziale del carburante è a zero. Fornire questi metodi: un metodo drive per
simulare il percorso di un’automobile per una certa distanza, riducendo il
livello di carburante nel serbatoio; un metodo getGas, per ispezionare il
livello corrente del carburante; un metodo addGas per far rifornimento. 
Consigli:
S’invita a porre particolare attenzione al metodo drive(double km), che calcola
il livello di carburante dopo un certo percorso. 
 * */
import java.util.Scanner;
public class Car {
	private double resa;
	private double gasAmount;
	private double serbatoio;
	
	public Car() {
		resa=0;
		gasAmount=0;
		serbatoio = 0;
	}
	
	public Car(double resa, double serbatoio, double gasAmount) {
		this.resa=resa;
		this.serbatoio = serbatoio;
		this.gasAmount = gasAmount;
	}

	public double getResa() {
		return resa;
	}

	public void setResa(double resa) {
		this.resa = resa;
	}

	public double getSerbatoio() {
		return serbatoio;
	}

	public void setSerbatoio(double serbatoio) {
		this.serbatoio = serbatoio;
	}

	public double getGasAmount() {
		return gasAmount;
	}

	public void setGasAmount(double gasAmount) {
		this.gasAmount = gasAmount;
	}
	
	public void drive(Double km) {
		//simulare il percorso di un’automobile per una certa distanza riducendo il
		//livello di carburante nel serbatoio
		Double consumoCarburante = km/resa;
		if(consumoCarburante>gasAmount) {
			System.out.println("Non puoi percorrere " + km + " Km, con " + gasAmount + " Litri di carburante. Prima effettua un rifornimento");
		}else {
			gasAmount-=consumoCarburante;
			System.out.println("Hai percorso " + km + " Km con " + consumoCarburante + " Litri");
			System.out.println("Quantità carburante ancora presente nel serbatoio " + gasAmount + " Litri");
		}
		
		
		
	}
	
	public void addGas(Double gas) {
		//per far rifornimento
		boolean vero=true;
		
		while(gas>serbatoio){
			System.out.println("La quantità da inserire " + gas + " Litri, supera la capienza: " + serbatoio + " Litri" );
			gas=stringToDouble("Inserisci litri (digita zero per uscire ): ");
			
		}
		while(vero) {
			if((gas+gasAmount)>serbatoio) {
				System.out.println("Serbatoio pieno, la sua capacità attuale è: " + (serbatoio-gasAmount) + " Litri");
				System.out.println("La quantità da inserire: " + gas + " Litri, supera la capacità di contenimento del serbatoio " + (serbatoio-gasAmount) + " Litri");
				gas=stringToDouble("Inserisci litri gas o digita zero per uscire: ");
			}else {
				vero=false;	
			}
			
			
		}
		if(gas<=serbatoio && gasAmount<serbatoio) {
			gasAmount+=gas;
			System.out.println("Quantità inserita: " + (gas) + " Litri");
			System.out.println("Nuova Disponibilità serbatoio: " + (gasAmount) + " Litri");
			
		}else {
			System.out.println("Serbatoio già pieno!!");
		}
		
	}
	
	
	public int stringToInt(String a) {
		boolean check;
		int number=0;
		do {
			check=true;
			Scanner input = new Scanner(System.in);
			System.out.print(a);
			String s = input.nextLine();
			try {
				number = Integer.parseInt(s);
			}catch(Exception e) {
				check=false;
				System.out.println("Inserisci un intero!!");
			}
		}while(!check);
		return number;
	}
	
	public Double stringToDouble(String a) {
		boolean check;
		double number=0;
		do {
			check=true;
			Scanner input = new Scanner(System.in);
			System.out.print(a);
			String s = input.nextLine();
			try {
				number = Double.parseDouble(s);
			}catch(Exception e) {
				check=false;
				System.out.println("Inserisci un intero!!");
			}
		}while(!check);
		return number;
	}
	
	
}
