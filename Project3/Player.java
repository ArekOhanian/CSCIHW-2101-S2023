public class Player {
    private int lives;

    // make a Player object with no parameter (default lives = 5)
    public Player(){
        lives = 3;
    }
    // make a player object with lives parameter
    public Player(int lives){
        this.lives = lives;
    }
    // make a method to get the lives 
    // return lives (int)
    public int getLives(){
        return lives;
    }
    // make a death method to subtract a life from the lives total (void)
    public void death(){
        lives--;
    }
}