package moving.text;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.Point;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class MovingText extends JPanel {
    private final URL PATH_1 = this.getClass().getResource("/applause6.wav");
    private final URL PATH_3 = this.getClass().getResource("/boo3.wav");
    
    private static DataLine.Info info;
    private static final int WINDOW_HEIGHT = 750;
    private static final int WINDOW_WIDTH = 1000;
    private static final int CENTER = WINDOW_WIDTH / 2;
    private static final int[] pointer3 = new int[] {0, 28, 56, 84, 112, 140, 168, 196, 224, 252};
    public static final JLabel MEMBER_1 = new JLabel("Atallabela Yosua");
    public static final JLabel MEMBER_2 = new JLabel("Ade Rizky");
    public static final JLabel MEMBER_3 = new JLabel("Joshua");
    public static final JLabel MEMBER_4 = new JLabel("Muhammad Isra");
    public static final JLabel MEMBER_5 = new JLabel("Muhammad Arif Isak");
    public static final JLabel MEMBER_6 = new JLabel("Yusuf Tigor Wibowo Pangaribuan");
    public static final JLabel MEMBER_7 = new JLabel("Agustinus Roya");
    public static final JLabel MEMBER_8 = new JLabel("Muhammad Ghazali Yazid");
    public static final JLabel MEMBER_9 = new JLabel("Muhammad Aldy");
    public static final JLabel MEMBER_10 = new JLabel("Brian Agustian");
    
    private static AudioFormat format;
    private static AudioInputStream sound;
    private static Clip audioClip;
    private static File VAWFile;
    private static int pointerMain = 0;
    private static int pointer1 = 0;
    private static int pointer2 = WINDOW_WIDTH + 30;
    private static int pointer4 = 0;
    
    private static String path2;
    private static String path4;
    
    public MovingText() {
        int width;
        
        this.setPreferredSize(new Dimension(MovingText.WINDOW_WIDTH, MovingText.WINDOW_HEIGHT));
        this.setLayout(null);
        
        width = MovingText.MEMBER_1.getFontMetrics(new Font("Comic Sans MS", Font.BOLD, 18)).stringWidth("Atallabela Yosua");
        
        try {
            MovingText.path2 = URLDecoder.decode(this.PATH_1.getPath(), "ASCII").replace('\\', '/');
            
            MovingText.path4 = URLDecoder.decode(this.PATH_3.getPath(), "ASCII").replace('\\', '/');
        } catch(UnsupportedEncodingException err) {
            System.out.println(err);
        }
        
        MovingText.MEMBER_1.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        MovingText.MEMBER_1.setForeground(Color.BLUE);
        MovingText.MEMBER_1.setLocation(new Point(-30, MovingText.pointer3[0]));
        MovingText.MEMBER_1.setSize(new Dimension(width, 18));
        
        width = MovingText.MEMBER_2.getFontMetrics(new Font("Courier New", Font.BOLD, 18)).stringWidth("Ade Rizky");
        
        MovingText.MEMBER_2.setFont(new Font("Courier New", Font.BOLD, 18));
        MovingText.MEMBER_2.setForeground(Color.GREEN);
        MovingText.MEMBER_2.setLocation(new Point(MovingText.WINDOW_WIDTH - width, MovingText.pointer3[1]));
        MovingText.MEMBER_2.setSize(new Dimension(width, 18));
        
        width = MovingText.MEMBER_3.getFontMetrics(new Font("Magneto", Font.BOLD, 18)).stringWidth("Joshua");
        
        MovingText.MEMBER_3.setFont(new Font("Magneto", Font.BOLD, 18));
        MovingText.MEMBER_3.setForeground(Color.RED);
        MovingText.MEMBER_3.setLocation(new Point(-30, MovingText.pointer3[2]));
        MovingText.MEMBER_3.setSize(new Dimension(width, 18));

        width = MovingText.MEMBER_4.getFontMetrics(new Font("Times New Roman", Font.BOLD, 18)).stringWidth("Muhammad Isra");

        MovingText.MEMBER_4.setFont(new Font("Times New Roman", Font.BOLD, 18));
        MovingText.MEMBER_4.setForeground(Color.MAGENTA);
        MovingText.MEMBER_4.setLocation(new Point(MovingText.WINDOW_WIDTH - width, MovingText.pointer3[3]));
        MovingText.MEMBER_4.setSize(new Dimension(width, 18));

        width = MovingText.MEMBER_5.getFontMetrics(new Font("Comic Sans MS", Font.BOLD, 18)).stringWidth("Muhammad Arif Isak");

        MovingText.MEMBER_5.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        MovingText.MEMBER_5.setForeground(new Color(175, 0, 0));
        MovingText.MEMBER_5.setLocation(new Point(-30, MovingText.pointer3[4]));
        MovingText.MEMBER_5.setSize(new Dimension(width, 18));

        width = MovingText.MEMBER_6.getFontMetrics(new Font("Courier New", Font.BOLD, 18)).stringWidth("Yusuf Tigor Wibowo Pangaribuan");

        MovingText.MEMBER_6.setFont(new Font("Courier New", Font.BOLD, 18));
        MovingText.MEMBER_6.setForeground(Color.ORANGE);
        MovingText.MEMBER_6.setLocation(new Point(MovingText.WINDOW_WIDTH - width, MovingText.pointer3[5]));
        MovingText.MEMBER_6.setSize(new Dimension(width, 18));

        width = MovingText.MEMBER_7.getFontMetrics(new Font("Magneto", Font.BOLD, 18)).stringWidth("Agustinus Roya");

        MovingText.MEMBER_7.setFont(new Font("Magneto", Font.BOLD, 18));
        MovingText.MEMBER_7.setForeground(new Color(0, 255, 128));
        MovingText.MEMBER_7.setLocation(new Point(-30, MovingText.pointer3[6]));
        MovingText.MEMBER_7.setSize(new Dimension(width, 18));

        width = MovingText.MEMBER_8.getFontMetrics(new Font("Times New Roman", Font.BOLD, 18)).stringWidth("Muhammad Ghazali Yazid");
        
        MovingText.MEMBER_8.setFont(new Font("Times New Roman", Font.BOLD, 18));
        MovingText.MEMBER_8.setForeground(new Color(0, 175, 255));
        MovingText.MEMBER_8.setLocation(new Point(MovingText.WINDOW_WIDTH - width, MovingText.pointer3[7]));
        MovingText.MEMBER_8.setSize(new Dimension(width, 18));
        
        width = MovingText.MEMBER_9.getFontMetrics(new Font("Comic Sans MS", Font.BOLD, 18)).stringWidth("Muhammad Aldy");
        
        MovingText.MEMBER_9.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        MovingText.MEMBER_9.setForeground(new Color(255, 0, 128));
        MovingText.MEMBER_9.setLocation(new Point(-30, MovingText.pointer3[8]));
        MovingText.MEMBER_9.setSize(new Dimension(width, 18));

        width = MovingText.MEMBER_10.getFontMetrics(new Font("Courier New", Font.BOLD, 18)).stringWidth("Brian Agustian");

        MovingText.MEMBER_10.setFont(new Font("Courier New", Font.BOLD, 18));
        MovingText.MEMBER_10.setForeground(new Color(255, 128, 0));
        MovingText.MEMBER_10.setLocation(new Point(MovingText.WINDOW_WIDTH - width, MovingText.pointer3[9]));
        MovingText.MEMBER_10.setSize(new Dimension(width, 18));

        this.add(MovingText.MEMBER_1);
        this.add(MovingText.MEMBER_2);
        this.add(MovingText.MEMBER_3);
        this.add(MovingText.MEMBER_4);
        this.add(MovingText.MEMBER_5);
        this.add(MovingText.MEMBER_6);
        this.add(MovingText.MEMBER_7);
        this.add(MovingText.MEMBER_8);
        this.add(MovingText.MEMBER_9);
        this.add(MovingText.MEMBER_10);

        new Timer(30, new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                if (MovingText.pointerMain == 0) {
                    MovingText.MEMBER_1.setLocation(new Point(MovingText.pointer1, MovingText.pointer3[0]));
                    MovingText.MEMBER_2.setLocation(new Point(MovingText.pointer2, MovingText.pointer3[1]));
                    MovingText.MEMBER_3.setLocation(new Point(MovingText.pointer1, MovingText.pointer3[2]));
                    MovingText.MEMBER_4.setLocation(new Point(MovingText.pointer2, MovingText.pointer3[3]));
                    MovingText.MEMBER_5.setLocation(new Point(MovingText.pointer1, MovingText.pointer3[4]));
                    MovingText.MEMBER_6.setLocation(new Point(MovingText.pointer2, MovingText.pointer3[5]));
                    MovingText.MEMBER_7.setLocation(new Point(MovingText.pointer1, MovingText.pointer3[6]));
                    MovingText.MEMBER_8.setLocation(new Point(MovingText.pointer2, MovingText.pointer3[7]));
                    MovingText.MEMBER_9.setLocation(new Point(MovingText.pointer1, MovingText.pointer3[8]));
                    MovingText.MEMBER_10.setLocation(new Point(MovingText.pointer2, MovingText.pointer3[9]));

                    if(MovingText.pointer1 > (MovingText.WINDOW_WIDTH + 30)) {
                        MovingText.pointer1 = -30;
                        MovingText.pointer2 = MovingText.WINDOW_WIDTH + 30;
                        MovingText.pointerMain = 1;
                    }
                    
                    ++MovingText.pointer1;
                    --MovingText.pointer2;
                } else if (MovingText.pointerMain == 1) {
                    ++MovingText.pointer1;

                    MovingText.MEMBER_1.setLocation(new Point(MovingText.pointer1, MovingText.pointer3[0]));
                    MovingText.MEMBER_3.setLocation(new Point(MovingText.pointer1, MovingText.pointer3[2]));
                    MovingText.MEMBER_5.setLocation(new Point(MovingText.pointer1, MovingText.pointer3[4]));
                    MovingText.MEMBER_7.setLocation(new Point(MovingText.pointer1, MovingText.pointer3[6]));
                    MovingText.MEMBER_9.setLocation(new Point(MovingText.pointer1, MovingText.pointer3[8]));

                    if(MovingText.pointer1 > (MovingText.WINDOW_WIDTH + 30)) {
                        MovingText.pointer1 = -30;
                        MovingText.pointerMain = 3;
                    }
                } else if (MovingText.pointerMain == 3){
                    --MovingText.pointer2;

                    MovingText.MEMBER_2.setLocation(new Point(MovingText.pointer2, MovingText.pointer3[1]));
                    MovingText.MEMBER_4.setLocation(new Point(MovingText.pointer2, MovingText.pointer3[3]));
                    MovingText.MEMBER_6.setLocation(new Point(MovingText.pointer2, MovingText.pointer3[5]));
                    MovingText.MEMBER_8.setLocation(new Point(MovingText.pointer2, MovingText.pointer3[7]));
                    MovingText.MEMBER_10.setLocation(new Point(MovingText.pointer2, MovingText.pointer3[9]));

                    if(MovingText.pointer2 <= MovingText.CENTER) {
                        MovingText.pointer2 = MovingText.WINDOW_WIDTH + 30;
                        MovingText.pointerMain = 4;
                    }
                } else if (MovingText.pointerMain == 4) {
                    ++MovingText.pointer4;
                    
                    MovingText.MEMBER_1.setLocation(new Point(MovingText.CENTER, MovingText.pointer3[0] + MovingText.pointer4));
                    MovingText.MEMBER_2.setLocation(new Point(MovingText.CENTER, MovingText.pointer3[1] + MovingText.pointer4));
                    MovingText.MEMBER_3.setLocation(new Point(MovingText.CENTER, MovingText.pointer3[2] + MovingText.pointer4));
                    MovingText.MEMBER_4.setLocation(new Point(MovingText.CENTER, MovingText.pointer3[3] + MovingText.pointer4));
                    MovingText.MEMBER_5.setLocation(new Point(MovingText.CENTER, MovingText.pointer3[4] + MovingText.pointer4));
                    MovingText.MEMBER_6.setLocation(new Point(MovingText.CENTER, MovingText.pointer3[5] + MovingText.pointer4));
                    MovingText.MEMBER_7.setLocation(new Point(MovingText.CENTER, MovingText.pointer3[6] + MovingText.pointer4));
                    MovingText.MEMBER_8.setLocation(new Point(MovingText.CENTER, MovingText.pointer3[7] + MovingText.pointer4));
                    MovingText.MEMBER_9.setLocation(new Point(MovingText.CENTER, MovingText.pointer3[8] + MovingText.pointer4));
                    MovingText.MEMBER_10.setLocation(new Point(MovingText.CENTER, MovingText.pointer3[9] + MovingText.pointer4));

                    if((MovingText.pointer3[0] + MovingText.pointer4) > (MovingText.WINDOW_HEIGHT + 18)) {
                        MovingText.pointer4 = 0;
                        MovingText.pointerMain = 0;
                    }
                }
            }
        }).start();

        new Timer(8000, new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                playSound1();
            }
        }).start();
        
        new Timer(4000, new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                playSound2();
            }
        }).start();

        this.playSound1();
    }
    
    public void playSound1() {
        try {
            MovingText.VAWFile = new File(MovingText.path2);
            
            MovingText.sound = AudioSystem.getAudioInputStream(MovingText.VAWFile);
            MovingText.format = MovingText.sound.getFormat();
            
            MovingText.info = new DataLine.Info(Clip.class, MovingText.format);
            MovingText.audioClip = (Clip) AudioSystem.getLine(MovingText.info);
            
            MovingText.audioClip.open(MovingText.sound);
            MovingText.audioClip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException err) {
            System.out.println(err);
        }
    }
    
    public void playSound2() {
        try {
            MovingText.VAWFile = new File(MovingText.path4);

            MovingText.sound = AudioSystem.getAudioInputStream(MovingText.VAWFile);
            MovingText.format = MovingText.sound.getFormat();

            MovingText.info = new DataLine.Info(Clip.class, MovingText.format);
            MovingText.audioClip = (Clip) AudioSystem.getLine(MovingText.info);

            MovingText.audioClip.open(MovingText.sound);
            MovingText.audioClip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException err) {
            System.out.println(err);
        }
    }

    public static void main(String[] args) {
        JFrame window = new JFrame();

        window.setBackground(Color.BLACK);
        window.setContentPane(new MovingText());
        window.pack();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}
