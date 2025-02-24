import java.io.IOException;
import java.net.URI;

class Handler implements URLHandler {
    public String handleRequest(URI url) {
        String fin_string = "";
        if (url.getPath().contains("/add")) {
            String[] parameters = url.getQuery().split("=");
            if (parameters[0].equals("s")) {
                fin_string += (parameters[1]).toString();
                return String.format(parameters[1]);
            }
        }
        return "404 Not Found!";
    }
}

class SearchEngine {
    public static void main(String[] args) throws IOException {
        if(args.length == 0){
            System.out.println("Missing port number! Try any number between 1024 to 49151");
            return;
        }

        int port = Integer.parseInt(args[0]);

        Server.start(port, new Handler());
    }
}
