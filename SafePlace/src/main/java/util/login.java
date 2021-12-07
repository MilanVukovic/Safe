package util;

public class login {

	public static void main(String[] args) {
		
	String passinput;
	String userinput;
	userinput = txtUser.getText();
	passinput = txtPass.getText();

	if(passinput.equals("pw") && userinput.equals("un") ){
		lblDisplay.setText("Credentials Accepted.");
	}
	else{
		lblDisplay.setText("Please try again.");
	}     
}
}