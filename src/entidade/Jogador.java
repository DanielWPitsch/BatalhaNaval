package entidade;


public class Jogador {
	
	Barco frota[] = new Barco[4];

	public Barco[] getFrota() {
		return frota;
	}

	public void setFrota(Barco[] frota1) {
		for(int x=0;x<4;x++){
			frota[x] = frota1[x]; 
		}
	}
	
	public int[][] getPolimorfo(Barco b){
		return b.getCoordenada();
	}

}
