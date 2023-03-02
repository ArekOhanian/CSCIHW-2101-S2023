package HW1;
// Make a method that accepts a string an integer and a char and will return the string with the char
// replaced at the integer given
// charReplace("I MAKE BREAD",2,'T')
// EX: I MAKE BREAD, 2, T
//     I TAKE BREAD
// remember computer counting starts at 0:
// HELLO
// 01234
public class Replace {
    String s = "Duck";
    int x = 0;
    char z = 'F';
    public String charReplace(String s, int x, char z) {
    s = this.s;
    x = this.x;
    z = this.z;
    String first = this.s.substring(0, this.x);
    String last = this.s.substring(this.x + 1, this.s.length());
    String result = first + this.z + last;
    return result;
    }

}
