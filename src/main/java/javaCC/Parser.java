package javaCC;/* Generated By:JavaCC: Do not edit this line. Parser.java */
import CTL_formula.*;

public class Parser implements ParserConstants {
    public static void main(String[] args) {
        try {
            Parser parseur = new Parser(System.in);
            parseur.mainNT();
            System.out.println("CTL formula accepted !");
        } catch (TokenMgrError e) {
            System.out.println("Error - The label must be in miniscule !");
        } catch (ParseException e) {
            System.out.println("Error - This is not a CTL formula !");
        }
    }

  static final public CTL_Formula mainNT() throws ParseException {
    CTL_Formula f;
    f = ctl();
    jj_consume_token(EOL);
                       {if (true) return f;}
    throw new Error("Missing return statement in function");
  }

  static final public CTL_Formula ctl() throws ParseException {
    CTL_Formula f1, f2;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case LABEL:
    case 12:
    case 19:
    case 20:
    case 21:
    case 22:
      f1 = proposition();
                              {if (true) return f1;}
      break;
    case 5:
      jj_consume_token(5);
      f1 = proposition();
                              {if (true) return new EX(f1);}
      break;
    case 6:
      jj_consume_token(6);
      f1 = proposition();
                              {if (true) return new NOT(new EX(new NOT(f1)));}
      break;
    case 7:
      jj_consume_token(7);
      f1 = proposition();
                              {if (true) return new EU(new Atomic("TRUE"), f1);}
      break;
    case 8:
      jj_consume_token(8);
      f1 = proposition();
                              {if (true) return new AU(new Atomic("TRUE"), f1);}
      break;
    case 9:
      jj_consume_token(9);
      f1 = proposition();
                              {if (true) return new NOT(new AU(new Atomic("TRUE"), f1));}
      break;
    case 10:
      jj_consume_token(10);
      f1 = proposition();
                              {if (true) return new NOT(new EU(new Atomic("TRUE"), f1));}
      break;
    case 11:
      jj_consume_token(11);
      jj_consume_token(12);
      f1 = proposition();
      jj_consume_token(13);
      f2 = proposition();
      jj_consume_token(14);
                                                          {if (true) return new EU(f1, f2);}
      break;
    case 15:
      jj_consume_token(15);
      jj_consume_token(12);
      f1 = proposition();
      jj_consume_token(13);
      f2 = proposition();
      jj_consume_token(14);
                                                          {if (true) return new AU(f1, f2);}
      break;
    default:
      jj_la1[0] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  static final public CTL_Formula proposition() throws ParseException {
    CTL_Formula f1, f2;
    f1 = term();
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 16:
      case 17:
      case 18:
        ;
        break;
      default:
        jj_la1[1] = jj_gen;
        break label_1;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 16:
        jj_consume_token(16);
        f2 = term();
                              {if (true) return new AND(f1, f2);}
        break;
      case 17:
        jj_consume_token(17);
        f2 = term();
                              {if (true) return new NOT(new AND(new NOT(f1), new NOT(f2)));}
        break;
      case 18:
        jj_consume_token(18);
        f2 = term();
                              {if (true) return new NOT(new AND(f1, new NOT(f2)));}
        break;
      default:
        jj_la1[2] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
         {if (true) return f1;}
    throw new Error("Missing return statement in function");
  }

  static final public CTL_Formula term() throws ParseException {
    CTL_Formula f;
    Token t;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 12:
      jj_consume_token(12);
      f = ctl();
      jj_consume_token(14);
                                {if (true) return f;}
      break;
    case 19:
      jj_consume_token(19);
      f = term();
                                {if (true) return new NOT(f);}
      break;
    case 20:
      jj_consume_token(20);
                                {if (true) return new Atomic("TRUE");}
      break;
    case 21:
      jj_consume_token(21);
                                {if (true) return new NOT (new Atomic("TRUE"));}
      break;
    case LABEL:
      t = jj_consume_token(LABEL);
                                {if (true) return new Atomic(t.image);}
      break;
    case 22:
      jj_consume_token(22);
                                {if (true) return new Atomic("EXIT");}
      break;
    default:
      jj_la1[3] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  static private boolean jj_initialized_once = false;
  /** Generated Token Manager. */
  static public ParserTokenManager token_source;
  static SimpleCharStream jj_input_stream;
  /** Current token. */
  static public Token token;
  /** Next token. */
  static public Token jj_nt;
  static private int jj_ntk;
  static private int jj_gen;
  static final private int[] jj_la1 = new int[4];
  static private int[] jj_la1_0;
  static {
      jj_la1_init_0();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x789fe8,0x70000,0x70000,0x781008,};
   }

  /** Constructor with InputStream. */
  public Parser(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public Parser(java.io.InputStream stream, String encoding) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser.  ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new ParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 4; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 4; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public Parser(java.io.Reader stream) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new ParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 4; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 4; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public Parser(ParserTokenManager tm) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 4; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(ParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 4; i++) jj_la1[i] = -1;
  }

  static private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }


/** Get the next Token. */
  static final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  static final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  static private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  static private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  static private int[] jj_expentry;
  static private int jj_kind = -1;

  /** Generate ParseException. */
  static public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[23];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 4; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 23; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  static final public void enable_tracing() {
  }

  /** Disable tracing. */
  static final public void disable_tracing() {
  }

}
