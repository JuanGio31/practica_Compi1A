package com.mycompany.practica1compiladores.view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SequentialAnimationExample extends JPanel {
    private static final int SQUARE_SIZE = 30;
    private static final int SPEED = 5;
    
    private Square[] squares;
    private int currentSquareIndex = 0;
    private Timer animationTimer;

    public SequentialAnimationExample() {
        // Definir las posiciones iniciales y finales de los cuadrados
        squares = new Square[] {
            new Square(50, 50, 200, 50),
            new Square(50, 100, 200, 100),
            new Square(50, 150, 200, 150),
            new Square(50, 200, 200, 200)
        };

        // Crear un temporizador para la animación
        animationTimer = new Timer(20, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentSquareIndex < squares.length) {
                    Square currentSquare = squares[currentSquareIndex];
                    
                    // Calcular el desplazamiento
                    currentSquare.updatePosition();
                    
                    // Repaint para actualizar la posición del cuadrado
                    repaint();
                    
                    // Si la animación del cuadrado actual ha terminado
                    if (currentSquare.isAtTarget()) {
                        currentSquareIndex++;
                        // Detener la animación si no hay más cuadrados para animar
                        if (currentSquareIndex >= squares.length) {
                            animationTimer.stop();
                        }
                    }
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Dibuja todos los cuadrados en sus posiciones actuales
        g.setColor(Color.RED);
        for (Square square : squares) {
            g.fillRect(square.x, square.y, SQUARE_SIZE, SQUARE_SIZE);
        }
    }

    public void startAnimation() {
        currentSquareIndex = 0; // Reiniciar el índice de los cuadrados
        animationTimer.start();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Animación Secuencial de Cuadrados");
        SequentialAnimationExample panel = new SequentialAnimationExample();
        JButton playButton = new JButton("Play");

        // Acción del botón Play
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.startAnimation();
            }
        });

        // Configuración del panel y el botón
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(playButton);
        
        frame.setLayout(new BorderLayout());
        frame.add(panel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);
        
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    // Clase para representar un cuadrado
    private class Square {
        private int x, y, targetX, targetY;
        private final int speed = SPEED;

        public Square(int startX, int startY, int endX, int endY) {
            this.x = startX;
            this.y = startY;
            this.targetX = endX;
            this.targetY = endY;
        }

        public void updatePosition() {
            int dx = targetX - x;
            int dy = targetY - y;
            double distance = Math.sqrt(dx * dx + dy * dy);
            
            if (distance > 0) {
                double moveX = (dx / distance) * speed;
                double moveY = (dy / distance) * speed;
                x += moveX;
                y += moveY;
            }
        }

        public boolean isAtTarget() {
            return Math.abs(targetX - x) < speed && Math.abs(targetY - y) < speed;
        }
    }
}
