        package com.example.javaoop;
        import android.util.Log;

        public  class Cat extends Animal {
            int age;
            String name;
            boolean man;
            static int numberOfLegs = 4;
            static int count = 0;

            String helloText;
            CatMode catMode;

            class CatMode{
                int loveMood;
                CatMode(){
                    if(Cat.this.age < 2){
                        loveMood = 100;
                    }else if(Cat.this.age >= 2 && Cat.this.age < 7){
                        loveMood = 50;
                    }else if(Cat.this.age >= 7){
                        loveMood = 20;
                    }
                }
            }


            public Cat() {
                this.name = "Jon Doy";
                this.age = 1;
                this.man = true;

                catMode = new CatMode();
            }

            public Cat(int age, String name) {
                this.age = age;
                this.name = name;
                this.man = true;
            }

            public void talk() {
                Log.i("talk", "Meow! I'm Cat. My name is " + name + ", and I'm " + age + " years old end is man " + man);
            }

            public static String whatsCatsLike() {
                return "I like playing jumping end sometime scratching";
            }


        }
