package practise;



public class UserInput {

    public static class TextInput {
        public TextInput() {
            this.ch = new StringBuilder();
        }

        protected   StringBuilder ch;

        public void add(char c){
            this.ch.append(c);
        }
        public String getValue(){
            return this.ch.toString();
        }
    }

    public static class NumericInput extends TextInput{


        public NumericInput() {
            super();

        }
        @Override
        public void add(char c){
            if (Character.isDigit(c)) this.ch.append(c);
        }
    }

    public static void main(String[] args) {
        TextInput input = new NumericInput();
        input.add('1');
        input.add('a');
        input.add('0');
        System.out.println(input.getValue());
    }
}