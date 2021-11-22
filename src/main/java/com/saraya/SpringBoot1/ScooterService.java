package com.saraya.SpringBoot1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

@Service //-> stereotype annotation and there are 4 : Controller, Repository, Service and Component
public class ScooterService {

	private static ArrayList<Scooter> scooters=new ArrayList<Scooter>();
	private static int count=10;
	
	static {
		scooters.add(new Scooter(1,2019,"Yamaha-Xmax","125","https://i.pinimg.com/originals/f2/5b/2f/f25b2f15ca6b24a4cb7a5e5f54b1fa08.jpg"));
		scooters.add(new Scooter(2,2017,"Honda","NSS125","https://sc01.alicdn.com/kf/HTB1pcG4acfrK1Rjy1Xdq6yemFXaj.jpg"));
		scooters.add(new Scooter(3,2021,"Honda-PCX","125","https://media.motoservices.com/media/cache/slider_lg/media/gallery/16520/16-yamaha-ec-01.jpg"));
		scooters.add(new Scooter(4,2021,"Hyundai","Elantra","https://images.caradisiac.com/images/7/9/9/3/187993/S1-le-scooter-chinois-futuriste-zeeho-cyber-en-europe-des-2022-661209.jpg"));
		scooters.add(new Scooter(5,2021,"Yamaha-XP","T-Max2350","https://moto-station.com/wp-content/uploads/ttesimages/scooters/nouveautes2008/Yamaha_500_T_Max_st4pz.jpg"));
		scooters.add(new Scooter(6,2020,"Honda-NSS","Forza","https://www.motomag.com/IMG/arton15668.jpg?1587548666"));
		scooters.add(new Scooter(7,2020,"Honda-XADV","750","https://thegoodlife.thegoodhub.com/wp-content/thumbnails/uploads/sites/2/2020/05/numerisation-tgl-43-scooters-2020-insert-niu-tt-width-690-height-442-crop-1-bgcolor-ffffff-except_gif-1-unveil-1.jpg"));
		scooters.add(new Scooter(8,2020,"Yamaha-XMax","300","https://cdn2.yamaha-motor.eu/prod/product-assets/2020/XMAX400ASP/2020-Yamaha-XMAX400ASP-EU-Tech_Kamo-Studio-001-03_Mobile.jpg"));
		scooters.add(new Scooter(9,2020,"KYMKO-SR","Max12","https://electricscooters.eu/i/2f/5c/bb/1319373c3dfbdd50c823197d1d.jpg"));
		scooters.add(new Scooter(10,2020,"BMW","C650","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRWKOrNFezlFMSS3nZmHG7bxQmtKKj9jrMxoYiLQUx7ipjNYyZqr-6P-QHkRyZ6TmfwKQM&usqp=CAU"));
	}
	
	public List<Scooter> getAllScooters(){
		return scooters;
	}
	public void addScooter(int year, String make, String model,String image) {
		scooters.add(new Scooter(++count,year,make,model,image));
	}
	public void deleteScooter(int id) {
		Iterator<Scooter> iterate=scooters.iterator();
		while(iterate.hasNext()) {
			Scooter scooter=iterate.next();
			if(scooter.getId()==id) {
				iterate.remove();
	}
	
}
}
	public Scooter findById(int id) {
	for(Scooter s:scooters) {
		if(s.getId()==id) {
			return s;
		}
	}
	return null;
}
	public void updateByScooter(Scooter s) {
		scooters.remove(s);
		scooters.add(s);
	}
}