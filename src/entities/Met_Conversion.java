package entities;

public class Met_Conversion {
	private double coin;
	
	public double getCoin() {
		return coin;
	}
	public void setCoin(double coin) {
		this.coin = coin;
	}
	
	public double dolarAeuro() {
		return 0.94*this.coin;
	}
	public double euroAdolar() {
		return 1.06*this.coin;
	}
	public double rubloAdolar() {
		return 0.014*this.coin;
	}
	public double dolarArublo() {
		return 68.36*this.coin;
	}
	
	public double Menu_conversion(int option) {
		double result =0;
		switch (option) {
		case 1: 
			result = this.dolarAeuro();
		break;
		case 2: 
			result = this.euroAdolar();
		break;
		case 3: 
			result = this.rubloAdolar();
		break;
		case 4: {
			result = this.dolarArublo();
		}
		default:
			System.out.println("no options ");
		}
		return result;
	}
}
