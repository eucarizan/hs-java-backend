import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String camel = """
            Switching on the camera in the camel habitat...
             ___.-''''-.
            /___  @    |
            ',,,,.     |         _.'''''''._
                 '     |        /           \\
                 |     \\    _.-'             \\
                 |      '.-'                  '-.
                 |                               ',
                 |                                '',
                  ',,-,                           ':;
                       ',,| ;,,                 ,' ;;
                          ! ; !'',,,',',,,,'!  ;   ;:
                         : ;  ! !       ! ! ;  ;   :;
                         ; ;   ! !      ! !  ; ;   ;,
                        ; ;    ! !     ! !   ; ;
                        ; ;    ! !    ! !     ; ;
                       ;,,      !,!   !,!     ;,;
                       /_I      L_I   L_I     /_I
            Look at that! Our little camel is sunbathing!""";

        String lion = """
            Switching on the camera in the lion habitat...
                                                           ,w.
                                                         ,YWMMw  ,M  ,
                                    _.---.._   __..---._.'MMMMMw,wMWmW,
                               _.-""        '''           YP"WMMMMMMMMMb,
                            .-' __.'                   .'     MMMMW^WMMMM;
                _,        .'.-'"; `,       /`     .--""      :MMM[==MWMW^;
             ,mM^"     ,-'.'   /   ;      ;      /   ,       MMMMb_wMW"  @\\
            ,MM:.    .'.-'   .'     ;     `\\    ;     `,     MMMMMMMW `"=./`-,
            WMMm__,-'.'     /      _.\\      F'''-+,,   ;_,_.dMMMMMMMM[,_ / `=_}
            "^MP__.-'    ,-' _.--""   `-,   ;       \\  ; ;MMMMMMMMMMW^``; __|
                       /   .'            ; ;         )  )`{  \\ `"^W^`,   \\  :
                      /  .'             /  (       .'  /     Ww._     `.  `"
                     /  Y,              `,  `-,=,_{   ;      MMMP`""-,  `-._.-,
                    (--, )                `,_ / `) \\/"")      ^"      `-, -;"\\:
            The lion is roaring!""";

        String deer = """
            Switching on the camera in the deer habitat...
               /|       |\\
            `__\\       //__'
               ||      ||
             \\__`\\     |'__/
               `_\\   //_'
               _.,:---;,._
               \\_:     :_/
                 |@. .@|
                 |     |
                 ,\\.-./ \\
                 ;;`-'   `---__________-----.-.
                 ;;;                         \\_\\
                 ';;;                         |
                  ;    |                      ;
                   \\   \\     \\        |      /
                    \\_, \\    /        \\     |\\
                      |';|  |,,,,,,,,/ \\    \\ \\_
                      |  |  |           \\   /   |
                      \\  \\  |           |  / \\  |
                       | || |           | |   | |
                       | || |           | |   | |
                       | || |           | |   | |
                       |_||_|           |_|   |_|
                      /_//_/           /_/   /_/
            Our 'Bambi' looks hungry. Let's go to feed it!""";

        String goose = """
            Switching on the camera in the goose habitat...
            
                                                _
                                            ,-"" "".
                                          ,'  ____  `.
                                        ,'  ,'    `.  `._
               (`.         _..--.._   ,'  ,'        \\    \\
              (`-.\\    .-""        ""'   /          (  d _b
             (`._  `-"" ,._             (            `-(   \\
             <_  `     (  <`<            \\              `-._\\
              <`-       (__< <           :
               (__        (_<_<          ;
                `------------------------------------------
            The goose is staring intently at you... Maybe it's time to change the channel?""";

        String bat = """
            Switching on the camera in the bat habitat...
            _________________               _________________
             ~-.              \\  |\\___/|  /              .-~
                 ~-.           \\ / o o \\ /           .-~
                    >           \\  W  //           <
                   /             /~---~\\             \\
                  /_            |       |            _\\
                     ~-.        |       |        .-~
                        ;        \\     /        i
                       /___      /\\   /\\      ___\\
                            ~-. /  \\_/  \\ .-~
                               V         V
            This bat looks like it's doing fine.""";

        String rabbit = """
            Switching on the camera in the rabbit habitat...
                     ,
                    /|      __
                   / |   ,-~ /
                  Y :|  //  /
                  | jj /( .^
                  >-"~"-v"
                 /       Y
                jo  o    |
               ( ~T~     j
                >._-' _./
               /   "~"  |
              Y     _,  |
             /| ;-"~ _  l
            / l/ ,-"~    \\
            \\//\\/      .- \\
             Y        /    Y
             l       I     !
             ]\\      _\\    /"\\
            (" ~----( ~   Y.  )
            It looks like we will soon have more rabbits!""";

        String[] animals = {camel, lion, deer, goose, bat, rabbit};


        System.out.print("Please enter the number of the habitat you would like to view: > ");
        
        try (Scanner scanner = new Scanner(System.in)) {
            String input = scanner.nextLine();
    
            String out = "";
    
            while (!input.equals("exit")) {
                int num = Integer.parseInt(input);
    
                switch (num) {
                    case 0 -> out = animals[0];
                    case 1 -> out = animals[1];
                    case 2 -> out = animals[2];
                    case 3 -> out = animals[3];
                    case 4 -> out = animals[4];
                    case 5 -> out = animals[5];
                }
    
                System.out.println(out);
                System.out.print("Please enter the number of the habitat you would like to view: > ");
                input = scanner.nextLine();
            }
    
            System.out.println("See you later!");
        }
    }
}
