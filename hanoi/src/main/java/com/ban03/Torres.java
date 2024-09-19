
package com.ban03;

import java.util.Stack;

import javafx.animation.TranslateTransition;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class Torres {
    private int len, indice = 0;
    private Stack<Rectangle> A, B, C;

    public Torres(int len, Rectangle[] discos) {
        this.len = len;
        this.A = new Stack<Rectangle>();
        this.B = new Stack<Rectangle>();
        this.C = new Stack<Rectangle>();
        for (Rectangle disco : discos) {
            A.push(disco);
        }
    }

    public boolean getC() {
        return this.C.size() != this.len;
    }

    public void torres() {
        /*
         * PAR
         * A - B
         * A - C
         * B - C
         * 
         * NON
         * A - C
         * A - B
         * B - C
         */
        if (indice == 3) {
            indice = 0;
        }
        indice++;
        switch (indice) {
            case 1:
                if (this.len % 2 == 0) {
                    even();
                } else {
                    odd();
                }
                break;
            case 2:
                if (this.len % 2 == 0) {
                    even();
                } else {
                    odd();
                }
                break;

            case 3:
                bToC();
                break;

            default:
                break;
        }
    }

    public void even() {
        switch (indice) {
            case 1:
                aToB();
                break;

            case 2:
                aToC();
                break;

            default:
                break;
        }
    }

    public void odd() {
        switch (indice) {
            case 1:
                aToC();
                break;

            case 2:
                aToB();
                break;

            default:
                break;
        }
    }

    public void aToB() {
        if (!A.isEmpty()) {
            if (!B.isEmpty()) {
                if (B.peek().getWidth() > A.peek().getWidth()) {
                    B.add(A.pop());
                    animatedPlacement(B, A, 200);
                } else {
                    A.add(B.pop());
                    animatedPlacement(A, B, -200);
                }
            } else {
                B.add(A.pop());
                animatedPlacement(B, A, 200);
            }
        } else {
            if (!B.isEmpty()) {
                A.add(B.pop());
                animatedPlacement(A, B, -200);
            }
        }
    }

    public void aToC() {
        if (!A.isEmpty()) {
            if (!C.isEmpty()) {
                if (C.peek().getWidth() > A.peek().getWidth()) {
                    C.add(A.pop());
                    animatedPlacement(C, A, 400);
                } else {
                    A.add(C.pop());
                    animatedPlacement(A, C, -400);
                }
            } else {
                C.add(A.pop());
                animatedPlacement(C, A, 400);
            }
        } else {
            if (!C.isEmpty() && C.size() != len) {
                A.add(C.pop());
                animatedPlacement(A, C, -400);
            }
        }
    }

    public void bToC() {
        if (!B.isEmpty()) {
            if (!C.isEmpty()) {
                if (C.peek().getWidth() > B.peek().getWidth()) {
                    C.add(B.pop());
                    animatedPlacement(C, B, 200);
                } else {
                    B.add(C.pop());
                    animatedPlacement(B, C, -200);
                }
            } else {
                C.add(B.pop());
                animatedPlacement(C, B, 200);
            }
        } else {
            if (!C.isEmpty() && C.size() != len) {
                B.add(C.pop());
                animatedPlacement(B, C, -200);
            }
        }
    }

    public void animatedPlacement(Stack<Rectangle> pilaMover, Stack<Rectangle> pilainicial, int desplazamiento) {
        TranslateTransition movement = new TranslateTransition(Duration.millis(500), pilaMover.peek());
        movement.setByX(desplazamiento);
        movement.setByY(pilaMover.peek().getHeight() * ((pilainicial.size() + 1) - pilaMover.size()));
        movement.play();
        movement.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                torres();
            }
        });
    }
}