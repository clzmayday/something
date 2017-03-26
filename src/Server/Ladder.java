package Server;

public class Ladder{
	public void ladder(int position){
		if(position == 2){
			position = position+36;
		}
		else if(position == 7){
			position = position+9;
		}
		else if(position == 12){
			position = position+37;
		}
		else if(position ==36){
			position = position+18;
		}
		else if(position ==25){
			position = position+62;
		}
		else if(position ==22){
			position = position+38;
		}
		else if(position ==74){
			position = position+18;
		}
		else if(position ==79){
			position = position+21;
		}
		else if(position ==52){
			position = position+15;
		}
	}
}
