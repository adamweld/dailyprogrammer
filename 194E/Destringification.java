import java.util.Scanner;
public class Destringification {
  public static void err(int code) {
    System.out.print("Invalid String! ");
    switch (code) {
      case 0:
        System.out.print("(Must start with \")");
        break;
      case 1:
        System.out.print("(Improperly closed)");
        break;
    }
  }
  public static void err(char c) {
    System.out.print("Invalid String! ");
    System.out.print("(invalid escape, \\" + c + ")");
  }

  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);
    System.out.print("Enter string to check: ");
    String in = scan.nextLine(), out = "";
    int countQuote = 0;
    if(in.charAt(0) != '"') {
      err(0);
      return;
    }
    for(int i = 0; i < in.length(); i++) {
      char current = in.charAt(i);
      if(current == '"') {
        countQuote++;
      }
      else if(current == '\\') {
        switch(in.charAt(i+1)) {
          case 'b':
            out += "\b";
            i++;
            break;
          case 'f':
            out += "\f";
            i++;
            break;
          case 'n':
            out += "\n";
            i++;
            break;
          case 'r':
            out += "\r";
            i++;
            break;
          case 't':
            out += "\t";
            i++;
            break;
          case '"':
            out += "\"";
            i++;
            break;
          case '\'':
            out += "\'";
            i++;
            break;
          case '\\':
            out += "\\";
            i++;
            break;
          default:
            err(in.charAt(i+1));
            return;
        }
      } else {
        out += current;
      }
    }
    if(countQuote < 2 || countQuote % 2 != 0) {
      err(1);
      return;
    }
    System.out.println(out);
  }
}
