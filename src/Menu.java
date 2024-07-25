import java.util.Scanner;
public class Menu {
	
	public static void mainMenu() {
		
		System.out.println("\n##Menù principale##");
		System.out.println("1) - Verifica livello carburante;\n2) - Rifornimento;\n3) - Viaggio;\n4) - Esci;");
	}
	
	public static void operazioni(Car car) {
		Scanner input = new Scanner(System.in);
		int scelta=0;
		do {
			mainMenu();
			String a = "\nScegli: ";
			scelta = car.stringToInt(a);
						
			switch(scelta) {
				case 1:
					System.out.println("Livello carburante: " + car.getGasAmount() + " Litri");
					if(car.getGasAmount()==0) {
						System.out.println("Effettua un rifornimento");
					}
					break;
				case 2:
					if(car.getGasAmount()==0){
						String richiesta="Inserisci capienza serbatoio auto (Litri): ";
						Double capacita = car.stringToDouble(richiesta);
						while(capacita<=0) {
							System.out.println("La capacità del serbatoio non può essere minore/uguale a zero");
							richiesta="Inserisci capienza serbatoio auto (Litri): ";
							capacita = car.stringToDouble(richiesta);
						}
						car.setSerbatoio(capacita);
						String stringaResa="Inserisci resa (Km/L): ";
						int resa = car.stringToInt(stringaResa);
						while(resa<=0) {
							System.out.println("La resa non può essere minore/uguale a zero");
							stringaResa="Inserisci resa (Km/L): ";
							resa = car.stringToInt(stringaResa);
						}
						car.setResa(resa);
					}
					
					String b = "Inserisci litri: ";
					Double litri = car.stringToDouble(b);
					while(litri<0) {
						System.out.println("Non puoi inserire un valore negativo");
						b = "Inserisci litri: ";
						litri = car.stringToDouble(b);
					}
					car.addGas(litri);
					break;
				case 3:
					String c = "Inserisci distanza da percorrere: ";
					Double distanza = car.stringToDouble(c);
					while(distanza<0) {
						System.out.println("Non puoi inserire un valore negativo");
						c = "Inserisci distanza da percorrere: ";
						distanza = car.stringToDouble(c);
					}
					car.drive(distanza);
					break;
				case 4:
					System.out.println("Grazie per aver utilizzato il programma!!");
					break;
				default:
					System.out.println("Caso non previsto!!\n");
				
					
			}
		}while(scelta!=4);
		
	}
}
