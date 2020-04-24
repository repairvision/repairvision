package org.sidiff.validation.laguage.fol.ide.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalFirstOrderLogicLexer extends Lexer {
    public static final int T__50=50;
    public static final int RULE_BOOLEAN=7;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int RULE_ID=5;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=8;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=9;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int RULE_STRING=4;
    public static final int RULE_SL_COMMENT=10;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_WS=11;
    public static final int RULE_SIGNED_INT=6;
    public static final int RULE_ANY_OTHER=12;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;

    // delegates
    // delegators

    public InternalFirstOrderLogicLexer() {;} 
    public InternalFirstOrderLogicLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalFirstOrderLogicLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "InternalFirstOrderLogic.g"; }

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFirstOrderLogic.g:11:7: ( 'domain' )
            // InternalFirstOrderLogic.g:11:9: 'domain'
            {
            match("domain"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__13"

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFirstOrderLogic.g:12:7: ( 'constraint' )
            // InternalFirstOrderLogic.g:12:9: 'constraint'
            {
            match("constraint"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__14"

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFirstOrderLogic.g:13:7: ( 'message' )
            // InternalFirstOrderLogic.g:13:9: 'message'
            {
            match("message"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__15"

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFirstOrderLogic.g:14:7: ( 'context' )
            // InternalFirstOrderLogic.g:14:9: 'context'
            {
            match("context"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__16"

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFirstOrderLogic.g:15:7: ( ':' )
            // InternalFirstOrderLogic.g:15:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFirstOrderLogic.g:16:7: ( '<' )
            // InternalFirstOrderLogic.g:16:9: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFirstOrderLogic.g:17:7: ( '>' )
            // InternalFirstOrderLogic.g:17:9: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFirstOrderLogic.g:18:7: ( '=' )
            // InternalFirstOrderLogic.g:18:9: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFirstOrderLogic.g:19:7: ( 'implies' )
            // InternalFirstOrderLogic.g:19:9: 'implies'
            {
            match("implies"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__21"

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFirstOrderLogic.g:20:7: ( 'xor' )
            // InternalFirstOrderLogic.g:20:9: 'xor'
            {
            match("xor"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__22"

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFirstOrderLogic.g:21:7: ( 'or' )
            // InternalFirstOrderLogic.g:21:9: 'or'
            {
            match("or"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__23"

    // $ANTLR start "T__24"
    public final void mT__24() throws RecognitionException {
        try {
            int _type = T__24;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFirstOrderLogic.g:22:7: ( 'and' )
            // InternalFirstOrderLogic.g:22:9: 'and'
            {
            match("and"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__24"

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFirstOrderLogic.g:23:7: ( 'not' )
            // InternalFirstOrderLogic.g:23:9: 'not'
            {
            match("not"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__25"

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFirstOrderLogic.g:24:7: ( '(' )
            // InternalFirstOrderLogic.g:24:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__26"

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFirstOrderLogic.g:25:7: ( ')' )
            // InternalFirstOrderLogic.g:25:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__27"

    // $ANTLR start "T__28"
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFirstOrderLogic.g:26:7: ( 'isEqual' )
            // InternalFirstOrderLogic.g:26:9: 'isEqual'
            {
            match("isEqual"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__28"

    // $ANTLR start "T__29"
    public final void mT__29() throws RecognitionException {
        try {
            int _type = T__29;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFirstOrderLogic.g:27:7: ( ',' )
            // InternalFirstOrderLogic.g:27:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__29"

    // $ANTLR start "T__30"
    public final void mT__30() throws RecognitionException {
        try {
            int _type = T__30;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFirstOrderLogic.g:28:7: ( 'isGreater' )
            // InternalFirstOrderLogic.g:28:9: 'isGreater'
            {
            match("isGreater"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__30"

    // $ANTLR start "T__31"
    public final void mT__31() throws RecognitionException {
        try {
            int _type = T__31;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFirstOrderLogic.g:29:7: ( 'isGreaterEqual' )
            // InternalFirstOrderLogic.g:29:9: 'isGreaterEqual'
            {
            match("isGreaterEqual"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__31"

    // $ANTLR start "T__32"
    public final void mT__32() throws RecognitionException {
        try {
            int _type = T__32;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFirstOrderLogic.g:30:7: ( 'isSmaller' )
            // InternalFirstOrderLogic.g:30:9: 'isSmaller'
            {
            match("isSmaller"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__32"

    // $ANTLR start "T__33"
    public final void mT__33() throws RecognitionException {
        try {
            int _type = T__33;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFirstOrderLogic.g:31:7: ( 'isSmallerEqual' )
            // InternalFirstOrderLogic.g:31:9: 'isSmallerEqual'
            {
            match("isSmallerEqual"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__33"

    // $ANTLR start "T__34"
    public final void mT__34() throws RecognitionException {
        try {
            int _type = T__34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFirstOrderLogic.g:32:7: ( 'isEmpty' )
            // InternalFirstOrderLogic.g:32:9: 'isEmpty'
            {
            match("isEmpty"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__34"

    // $ANTLR start "T__35"
    public final void mT__35() throws RecognitionException {
        try {
            int _type = T__35;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFirstOrderLogic.g:33:7: ( 'isInstanceOf' )
            // InternalFirstOrderLogic.g:33:9: 'isInstanceOf'
            {
            match("isInstanceOf"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__35"

    // $ANTLR start "T__36"
    public final void mT__36() throws RecognitionException {
        try {
            int _type = T__36;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFirstOrderLogic.g:34:7: ( 'isValueLiteralOf' )
            // InternalFirstOrderLogic.g:34:9: 'isValueLiteralOf'
            {
            match("isValueLiteralOf"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__36"

    // $ANTLR start "T__37"
    public final void mT__37() throws RecognitionException {
        try {
            int _type = T__37;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFirstOrderLogic.g:35:7: ( 'forAll' )
            // InternalFirstOrderLogic.g:35:9: 'forAll'
            {
            match("forAll"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__37"

    // $ANTLR start "T__38"
    public final void mT__38() throws RecognitionException {
        try {
            int _type = T__38;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFirstOrderLogic.g:36:7: ( 'in' )
            // InternalFirstOrderLogic.g:36:9: 'in'
            {
            match("in"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__38"

    // $ANTLR start "T__39"
    public final void mT__39() throws RecognitionException {
        try {
            int _type = T__39;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFirstOrderLogic.g:37:7: ( 'exists' )
            // InternalFirstOrderLogic.g:37:9: 'exists'
            {
            match("exists"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__39"

    // $ANTLR start "T__40"
    public final void mT__40() throws RecognitionException {
        try {
            int _type = T__40;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFirstOrderLogic.g:38:7: ( 'select' )
            // InternalFirstOrderLogic.g:38:9: 'select'
            {
            match("select"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__40"

    // $ANTLR start "T__41"
    public final void mT__41() throws RecognitionException {
        try {
            int _type = T__41;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFirstOrderLogic.g:39:7: ( '.' )
            // InternalFirstOrderLogic.g:39:9: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__41"

    // $ANTLR start "T__42"
    public final void mT__42() throws RecognitionException {
        try {
            int _type = T__42;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFirstOrderLogic.g:40:7: ( '::' )
            // InternalFirstOrderLogic.g:40:9: '::'
            {
            match("::"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__42"

    // $ANTLR start "T__43"
    public final void mT__43() throws RecognitionException {
        try {
            int _type = T__43;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFirstOrderLogic.g:41:7: ( 'getContainer' )
            // InternalFirstOrderLogic.g:41:9: 'getContainer'
            {
            match("getContainer"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__43"

    // $ANTLR start "T__44"
    public final void mT__44() throws RecognitionException {
        try {
            int _type = T__44;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFirstOrderLogic.g:42:7: ( 'getContainments' )
            // InternalFirstOrderLogic.g:42:9: 'getContainments'
            {
            match("getContainments"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__44"

    // $ANTLR start "T__45"
    public final void mT__45() throws RecognitionException {
        try {
            int _type = T__45;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFirstOrderLogic.g:43:7: ( 'getClosure' )
            // InternalFirstOrderLogic.g:43:9: 'getClosure'
            {
            match("getClosure"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__45"

    // $ANTLR start "T__46"
    public final void mT__46() throws RecognitionException {
        try {
            int _type = T__46;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFirstOrderLogic.g:44:7: ( 'size' )
            // InternalFirstOrderLogic.g:44:9: 'size'
            {
            match("size"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__46"

    // $ANTLR start "T__47"
    public final void mT__47() throws RecognitionException {
        try {
            int _type = T__47;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFirstOrderLogic.g:45:7: ( 'indexOf' )
            // InternalFirstOrderLogic.g:45:9: 'indexOf'
            {
            match("indexOf"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__47"

    // $ANTLR start "T__48"
    public final void mT__48() throws RecognitionException {
        try {
            int _type = T__48;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFirstOrderLogic.g:46:7: ( 'concatenate' )
            // InternalFirstOrderLogic.g:46:9: 'concatenate'
            {
            match("concatenate"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__48"

    // $ANTLR start "T__49"
    public final void mT__49() throws RecognitionException {
        try {
            int _type = T__49;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFirstOrderLogic.g:47:7: ( 'capitalize' )
            // InternalFirstOrderLogic.g:47:9: 'capitalize'
            {
            match("capitalize"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__49"

    // $ANTLR start "T__50"
    public final void mT__50() throws RecognitionException {
        try {
            int _type = T__50;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFirstOrderLogic.g:48:7: ( '$' )
            // InternalFirstOrderLogic.g:48:9: '$'
            {
            match('$'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__50"

    // $ANTLR start "RULE_BOOLEAN"
    public final void mRULE_BOOLEAN() throws RecognitionException {
        try {
            int _type = RULE_BOOLEAN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFirstOrderLogic.g:6988:14: ( ( 'true' | 'false' ) )
            // InternalFirstOrderLogic.g:6988:16: ( 'true' | 'false' )
            {
            // InternalFirstOrderLogic.g:6988:16: ( 'true' | 'false' )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='t') ) {
                alt1=1;
            }
            else if ( (LA1_0=='f') ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // InternalFirstOrderLogic.g:6988:17: 'true'
                    {
                    match("true"); 


                    }
                    break;
                case 2 :
                    // InternalFirstOrderLogic.g:6988:24: 'false'
                    {
                    match("false"); 


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_BOOLEAN"

    // $ANTLR start "RULE_SIGNED_INT"
    public final void mRULE_SIGNED_INT() throws RecognitionException {
        try {
            int _type = RULE_SIGNED_INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFirstOrderLogic.g:6990:17: ( ( '-' )? RULE_INT )
            // InternalFirstOrderLogic.g:6990:19: ( '-' )? RULE_INT
            {
            // InternalFirstOrderLogic.g:6990:19: ( '-' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='-') ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalFirstOrderLogic.g:6990:19: '-'
                    {
                    match('-'); 

                    }
                    break;

            }

            mRULE_INT(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SIGNED_INT"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFirstOrderLogic.g:6992:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // InternalFirstOrderLogic.g:6992:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // InternalFirstOrderLogic.g:6992:11: ( '^' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0=='^') ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalFirstOrderLogic.g:6992:11: '^'
                    {
                    match('^'); 

                    }
                    break;

            }

            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // InternalFirstOrderLogic.g:6992:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>='0' && LA4_0<='9')||(LA4_0>='A' && LA4_0<='Z')||LA4_0=='_'||(LA4_0>='a' && LA4_0<='z')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalFirstOrderLogic.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ID"

    // $ANTLR start "RULE_INT"
    public final void mRULE_INT() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:6994:19: ( ( '0' .. '9' )+ )
            // InternalFirstOrderLogic.g:6994:21: ( '0' .. '9' )+
            {
            // InternalFirstOrderLogic.g:6994:21: ( '0' .. '9' )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>='0' && LA5_0<='9')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalFirstOrderLogic.g:6994:22: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
            } while (true);


            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_INT"

    // $ANTLR start "RULE_STRING"
    public final void mRULE_STRING() throws RecognitionException {
        try {
            int _type = RULE_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFirstOrderLogic.g:6996:13: ( ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // InternalFirstOrderLogic.g:6996:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // InternalFirstOrderLogic.g:6996:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0=='\"') ) {
                alt8=1;
            }
            else if ( (LA8_0=='\'') ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // InternalFirstOrderLogic.g:6996:16: '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // InternalFirstOrderLogic.g:6996:20: ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )*
                    loop6:
                    do {
                        int alt6=3;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0=='\\') ) {
                            alt6=1;
                        }
                        else if ( ((LA6_0>='\u0000' && LA6_0<='!')||(LA6_0>='#' && LA6_0<='[')||(LA6_0>=']' && LA6_0<='\uFFFF')) ) {
                            alt6=2;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // InternalFirstOrderLogic.g:6996:21: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalFirstOrderLogic.g:6996:28: ~ ( ( '\\\\' | '\"' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);

                    match('\"'); 

                    }
                    break;
                case 2 :
                    // InternalFirstOrderLogic.g:6996:48: '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // InternalFirstOrderLogic.g:6996:53: ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )*
                    loop7:
                    do {
                        int alt7=3;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0=='\\') ) {
                            alt7=1;
                        }
                        else if ( ((LA7_0>='\u0000' && LA7_0<='&')||(LA7_0>='(' && LA7_0<='[')||(LA7_0>=']' && LA7_0<='\uFFFF')) ) {
                            alt7=2;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // InternalFirstOrderLogic.g:6996:54: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalFirstOrderLogic.g:6996:61: ~ ( ( '\\\\' | '\\'' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop7;
                        }
                    } while (true);

                    match('\''); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_STRING"

    // $ANTLR start "RULE_ML_COMMENT"
    public final void mRULE_ML_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_ML_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFirstOrderLogic.g:6998:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // InternalFirstOrderLogic.g:6998:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // InternalFirstOrderLogic.g:6998:24: ( options {greedy=false; } : . )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0=='*') ) {
                    int LA9_1 = input.LA(2);

                    if ( (LA9_1=='/') ) {
                        alt9=2;
                    }
                    else if ( ((LA9_1>='\u0000' && LA9_1<='.')||(LA9_1>='0' && LA9_1<='\uFFFF')) ) {
                        alt9=1;
                    }


                }
                else if ( ((LA9_0>='\u0000' && LA9_0<=')')||(LA9_0>='+' && LA9_0<='\uFFFF')) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalFirstOrderLogic.g:6998:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            match("*/"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ML_COMMENT"

    // $ANTLR start "RULE_SL_COMMENT"
    public final void mRULE_SL_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_SL_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFirstOrderLogic.g:7000:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // InternalFirstOrderLogic.g:7000:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // InternalFirstOrderLogic.g:7000:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>='\u0000' && LA10_0<='\t')||(LA10_0>='\u000B' && LA10_0<='\f')||(LA10_0>='\u000E' && LA10_0<='\uFFFF')) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalFirstOrderLogic.g:7000:24: ~ ( ( '\\n' | '\\r' ) )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

            // InternalFirstOrderLogic.g:7000:40: ( ( '\\r' )? '\\n' )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0=='\n'||LA12_0=='\r') ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalFirstOrderLogic.g:7000:41: ( '\\r' )? '\\n'
                    {
                    // InternalFirstOrderLogic.g:7000:41: ( '\\r' )?
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0=='\r') ) {
                        alt11=1;
                    }
                    switch (alt11) {
                        case 1 :
                            // InternalFirstOrderLogic.g:7000:41: '\\r'
                            {
                            match('\r'); 

                            }
                            break;

                    }

                    match('\n'); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SL_COMMENT"

    // $ANTLR start "RULE_WS"
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFirstOrderLogic.g:7002:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // InternalFirstOrderLogic.g:7002:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // InternalFirstOrderLogic.g:7002:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt13=0;
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( ((LA13_0>='\t' && LA13_0<='\n')||LA13_0=='\r'||LA13_0==' ') ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalFirstOrderLogic.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt13 >= 1 ) break loop13;
                        EarlyExitException eee =
                            new EarlyExitException(13, input);
                        throw eee;
                }
                cnt13++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_WS"

    // $ANTLR start "RULE_ANY_OTHER"
    public final void mRULE_ANY_OTHER() throws RecognitionException {
        try {
            int _type = RULE_ANY_OTHER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFirstOrderLogic.g:7004:16: ( . )
            // InternalFirstOrderLogic.g:7004:18: .
            {
            matchAny(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ANY_OTHER"

    public void mTokens() throws RecognitionException {
        // InternalFirstOrderLogic.g:1:8: ( T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | RULE_BOOLEAN | RULE_SIGNED_INT | RULE_ID | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt14=46;
        alt14 = dfa14.predict(input);
        switch (alt14) {
            case 1 :
                // InternalFirstOrderLogic.g:1:10: T__13
                {
                mT__13(); 

                }
                break;
            case 2 :
                // InternalFirstOrderLogic.g:1:16: T__14
                {
                mT__14(); 

                }
                break;
            case 3 :
                // InternalFirstOrderLogic.g:1:22: T__15
                {
                mT__15(); 

                }
                break;
            case 4 :
                // InternalFirstOrderLogic.g:1:28: T__16
                {
                mT__16(); 

                }
                break;
            case 5 :
                // InternalFirstOrderLogic.g:1:34: T__17
                {
                mT__17(); 

                }
                break;
            case 6 :
                // InternalFirstOrderLogic.g:1:40: T__18
                {
                mT__18(); 

                }
                break;
            case 7 :
                // InternalFirstOrderLogic.g:1:46: T__19
                {
                mT__19(); 

                }
                break;
            case 8 :
                // InternalFirstOrderLogic.g:1:52: T__20
                {
                mT__20(); 

                }
                break;
            case 9 :
                // InternalFirstOrderLogic.g:1:58: T__21
                {
                mT__21(); 

                }
                break;
            case 10 :
                // InternalFirstOrderLogic.g:1:64: T__22
                {
                mT__22(); 

                }
                break;
            case 11 :
                // InternalFirstOrderLogic.g:1:70: T__23
                {
                mT__23(); 

                }
                break;
            case 12 :
                // InternalFirstOrderLogic.g:1:76: T__24
                {
                mT__24(); 

                }
                break;
            case 13 :
                // InternalFirstOrderLogic.g:1:82: T__25
                {
                mT__25(); 

                }
                break;
            case 14 :
                // InternalFirstOrderLogic.g:1:88: T__26
                {
                mT__26(); 

                }
                break;
            case 15 :
                // InternalFirstOrderLogic.g:1:94: T__27
                {
                mT__27(); 

                }
                break;
            case 16 :
                // InternalFirstOrderLogic.g:1:100: T__28
                {
                mT__28(); 

                }
                break;
            case 17 :
                // InternalFirstOrderLogic.g:1:106: T__29
                {
                mT__29(); 

                }
                break;
            case 18 :
                // InternalFirstOrderLogic.g:1:112: T__30
                {
                mT__30(); 

                }
                break;
            case 19 :
                // InternalFirstOrderLogic.g:1:118: T__31
                {
                mT__31(); 

                }
                break;
            case 20 :
                // InternalFirstOrderLogic.g:1:124: T__32
                {
                mT__32(); 

                }
                break;
            case 21 :
                // InternalFirstOrderLogic.g:1:130: T__33
                {
                mT__33(); 

                }
                break;
            case 22 :
                // InternalFirstOrderLogic.g:1:136: T__34
                {
                mT__34(); 

                }
                break;
            case 23 :
                // InternalFirstOrderLogic.g:1:142: T__35
                {
                mT__35(); 

                }
                break;
            case 24 :
                // InternalFirstOrderLogic.g:1:148: T__36
                {
                mT__36(); 

                }
                break;
            case 25 :
                // InternalFirstOrderLogic.g:1:154: T__37
                {
                mT__37(); 

                }
                break;
            case 26 :
                // InternalFirstOrderLogic.g:1:160: T__38
                {
                mT__38(); 

                }
                break;
            case 27 :
                // InternalFirstOrderLogic.g:1:166: T__39
                {
                mT__39(); 

                }
                break;
            case 28 :
                // InternalFirstOrderLogic.g:1:172: T__40
                {
                mT__40(); 

                }
                break;
            case 29 :
                // InternalFirstOrderLogic.g:1:178: T__41
                {
                mT__41(); 

                }
                break;
            case 30 :
                // InternalFirstOrderLogic.g:1:184: T__42
                {
                mT__42(); 

                }
                break;
            case 31 :
                // InternalFirstOrderLogic.g:1:190: T__43
                {
                mT__43(); 

                }
                break;
            case 32 :
                // InternalFirstOrderLogic.g:1:196: T__44
                {
                mT__44(); 

                }
                break;
            case 33 :
                // InternalFirstOrderLogic.g:1:202: T__45
                {
                mT__45(); 

                }
                break;
            case 34 :
                // InternalFirstOrderLogic.g:1:208: T__46
                {
                mT__46(); 

                }
                break;
            case 35 :
                // InternalFirstOrderLogic.g:1:214: T__47
                {
                mT__47(); 

                }
                break;
            case 36 :
                // InternalFirstOrderLogic.g:1:220: T__48
                {
                mT__48(); 

                }
                break;
            case 37 :
                // InternalFirstOrderLogic.g:1:226: T__49
                {
                mT__49(); 

                }
                break;
            case 38 :
                // InternalFirstOrderLogic.g:1:232: T__50
                {
                mT__50(); 

                }
                break;
            case 39 :
                // InternalFirstOrderLogic.g:1:238: RULE_BOOLEAN
                {
                mRULE_BOOLEAN(); 

                }
                break;
            case 40 :
                // InternalFirstOrderLogic.g:1:251: RULE_SIGNED_INT
                {
                mRULE_SIGNED_INT(); 

                }
                break;
            case 41 :
                // InternalFirstOrderLogic.g:1:267: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 42 :
                // InternalFirstOrderLogic.g:1:275: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 43 :
                // InternalFirstOrderLogic.g:1:287: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 44 :
                // InternalFirstOrderLogic.g:1:303: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 45 :
                // InternalFirstOrderLogic.g:1:319: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 46 :
                // InternalFirstOrderLogic.g:1:327: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA14 dfa14 = new DFA14(this);
    static final String DFA14_eotS =
        "\1\uffff\3\41\1\46\3\uffff\5\41\3\uffff\3\41\1\uffff\1\41\1\uffff\1\41\1\37\1\uffff\1\37\1\uffff\3\37\2\uffff\1\41\1\uffff\3\41\5\uffff\2\41\1\115\1\41\1\117\2\41\3\uffff\5\41\1\uffff\1\41\1\uffff\1\41\5\uffff\13\41\1\uffff\1\147\1\uffff\1\150\1\151\25\41\3\uffff\4\41\1\u0083\1\41\1\u0086\17\41\1\u0086\2\41\1\uffff\2\41\1\uffff\1\u009a\15\41\1\u00a8\1\u00a9\1\u00aa\2\41\1\uffff\1\41\1\u00ae\2\41\1\u00b1\1\u00b2\1\u00b3\1\u00b4\4\41\1\u00b9\3\uffff\3\41\1\uffff\2\41\4\uffff\4\41\1\uffff\5\41\1\u00c9\1\u00cb\4\41\1\u00d0\1\41\1\u00d2\1\41\1\uffff\1\41\1\uffff\3\41\1\u00d9\1\uffff\1\u00da\1\uffff\6\41\2\uffff\2\41\1\u00e3\1\41\1\u00e5\3\41\1\uffff\1\41\1\uffff\1\41\1\u00eb\1\u00ec\2\41\2\uffff\1\41\1\u00f0\1\u00f1\2\uffff";
    static final String DFA14_eofS =
        "\u00f2\uffff";
    static final String DFA14_minS =
        "\1\0\1\157\1\141\1\145\1\72\3\uffff\1\155\1\157\1\162\1\156\1\157\3\uffff\1\141\1\170\1\145\1\uffff\1\145\1\uffff\1\162\1\60\1\uffff\1\101\1\uffff\2\0\1\52\2\uffff\1\155\1\uffff\1\156\1\160\1\163\5\uffff\1\160\1\105\1\60\1\162\1\60\1\144\1\164\3\uffff\1\162\1\154\1\151\1\154\1\172\1\uffff\1\164\1\uffff\1\165\5\uffff\1\141\1\143\1\151\1\163\1\154\1\155\1\162\1\155\1\156\1\141\1\145\1\uffff\1\60\1\uffff\2\60\1\101\2\163\2\145\1\103\1\145\1\151\1\164\1\145\1\141\1\164\1\141\1\151\1\165\1\160\1\145\1\141\1\163\1\154\1\170\3\uffff\1\154\1\145\1\164\1\143\1\60\1\154\1\60\1\156\1\162\1\170\1\164\1\141\1\147\1\145\1\141\1\164\1\141\1\154\1\164\1\165\1\117\1\154\1\60\1\163\1\164\1\uffff\1\156\1\157\1\uffff\1\60\1\141\1\164\1\145\1\154\1\145\1\163\1\154\1\171\1\164\1\154\1\141\1\145\1\146\3\60\1\164\1\163\1\uffff\1\151\1\60\1\156\1\151\4\60\2\145\1\156\1\114\1\60\3\uffff\1\141\1\165\1\156\1\uffff\1\141\1\172\4\uffff\2\162\1\143\1\151\1\uffff\1\151\1\162\2\164\1\145\2\60\1\145\1\164\1\156\1\145\1\60\1\145\1\60\1\161\1\uffff\1\161\1\uffff\1\117\2\145\1\60\1\uffff\1\60\1\uffff\2\165\1\146\2\162\1\145\2\uffff\2\141\1\60\1\141\1\60\1\156\2\154\1\uffff\1\154\1\uffff\1\164\2\60\1\117\1\163\2\uffff\1\146\2\60\2\uffff";
    static final String DFA14_maxS =
        "\1\uffff\2\157\1\145\1\72\3\uffff\1\163\1\157\1\162\1\156\1\157\3\uffff\1\157\1\170\1\151\1\uffff\1\145\1\uffff\1\162\1\71\1\uffff\1\172\1\uffff\2\uffff\1\57\2\uffff\1\155\1\uffff\1\156\1\160\1\163\5\uffff\1\160\1\126\1\172\1\162\1\172\1\144\1\164\3\uffff\1\162\1\154\1\151\1\154\1\172\1\uffff\1\164\1\uffff\1\165\5\uffff\1\141\1\164\1\151\1\163\1\154\1\161\1\162\1\155\1\156\1\141\1\145\1\uffff\1\172\1\uffff\2\172\1\101\2\163\2\145\1\103\1\145\1\151\1\164\1\145\1\141\1\164\1\141\1\151\1\165\1\160\1\145\1\141\1\163\1\154\1\170\3\uffff\1\154\1\145\1\164\1\143\1\172\1\157\1\172\1\156\1\162\1\170\1\164\1\141\1\147\1\145\1\141\1\164\1\141\1\154\1\164\1\165\1\117\1\154\1\172\1\163\1\164\1\uffff\1\156\1\157\1\uffff\1\172\1\141\1\164\1\145\1\154\1\145\1\163\1\154\1\171\1\164\1\154\1\141\1\145\1\146\3\172\1\164\1\163\1\uffff\1\151\1\172\1\156\1\151\4\172\2\145\1\156\1\114\1\172\3\uffff\1\141\1\165\1\156\1\uffff\1\141\1\172\4\uffff\2\162\1\143\1\151\1\uffff\1\151\1\162\2\164\1\145\2\172\1\145\1\164\1\156\1\145\1\172\1\145\1\172\1\161\1\uffff\1\161\1\uffff\1\117\1\145\1\155\1\172\1\uffff\1\172\1\uffff\2\165\1\146\2\162\1\145\2\uffff\2\141\1\172\1\141\1\172\1\156\2\154\1\uffff\1\154\1\uffff\1\164\2\172\1\117\1\163\2\uffff\1\146\2\172\2\uffff";
    static final String DFA14_acceptS =
        "\5\uffff\1\6\1\7\1\10\5\uffff\1\16\1\17\1\21\3\uffff\1\35\1\uffff\1\46\2\uffff\1\50\1\uffff\1\51\3\uffff\1\55\1\56\1\uffff\1\51\3\uffff\1\36\1\5\1\6\1\7\1\10\7\uffff\1\16\1\17\1\21\5\uffff\1\35\1\uffff\1\46\1\uffff\1\50\1\52\1\53\1\54\1\55\13\uffff\1\32\1\uffff\1\13\27\uffff\1\12\1\14\1\15\31\uffff\1\42\2\uffff\1\47\23\uffff\1\1\15\uffff\1\31\1\33\1\34\3\uffff\1\4\2\uffff\1\3\1\11\1\20\1\26\4\uffff\1\43\17\uffff\1\22\1\uffff\1\24\4\uffff\1\2\1\uffff\1\45\6\uffff\1\41\1\44\10\uffff\1\27\1\uffff\1\37\5\uffff\1\23\1\25\3\uffff\1\40\1\30";
    static final String DFA14_specialS =
        "\1\2\32\uffff\1\0\1\1\u00d5\uffff}>";
    static final String[] DFA14_transitionS = {
            "\11\37\2\36\2\37\1\36\22\37\1\36\1\37\1\33\1\37\1\25\2\37\1\34\1\15\1\16\2\37\1\17\1\27\1\23\1\35\12\30\1\4\1\37\1\5\1\7\1\6\2\37\32\32\3\37\1\31\1\32\1\37\1\13\1\32\1\2\1\1\1\21\1\20\1\24\1\32\1\10\3\32\1\3\1\14\1\12\3\32\1\22\1\26\3\32\1\11\2\32\uff85\37",
            "\1\40",
            "\1\43\15\uffff\1\42",
            "\1\44",
            "\1\45",
            "",
            "",
            "",
            "\1\52\1\54\4\uffff\1\53",
            "\1\55",
            "\1\56",
            "\1\57",
            "\1\60",
            "",
            "",
            "",
            "\1\65\15\uffff\1\64",
            "\1\66",
            "\1\67\3\uffff\1\70",
            "",
            "\1\72",
            "",
            "\1\74",
            "\12\75",
            "",
            "\32\41\4\uffff\1\41\1\uffff\32\41",
            "",
            "\0\76",
            "\0\76",
            "\1\77\4\uffff\1\100",
            "",
            "",
            "\1\102",
            "",
            "\1\103",
            "\1\104",
            "\1\105",
            "",
            "",
            "",
            "",
            "",
            "\1\106",
            "\1\107\1\uffff\1\110\1\uffff\1\112\11\uffff\1\111\2\uffff\1\113",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\3\41\1\114\26\41",
            "\1\116",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "\1\120",
            "\1\121",
            "",
            "",
            "",
            "\1\122",
            "\1\123",
            "\1\124",
            "\1\125",
            "\1\126",
            "",
            "\1\127",
            "",
            "\1\130",
            "",
            "",
            "",
            "",
            "",
            "\1\131",
            "\1\134\17\uffff\1\132\1\133",
            "\1\135",
            "\1\136",
            "\1\137",
            "\1\141\3\uffff\1\140",
            "\1\142",
            "\1\143",
            "\1\144",
            "\1\145",
            "\1\146",
            "",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "\1\152",
            "\1\153",
            "\1\154",
            "\1\155",
            "\1\156",
            "\1\157",
            "\1\160",
            "\1\161",
            "\1\162",
            "\1\163",
            "\1\164",
            "\1\165",
            "\1\166",
            "\1\167",
            "\1\170",
            "\1\171",
            "\1\172",
            "\1\173",
            "\1\174",
            "\1\175",
            "\1\176",
            "",
            "",
            "",
            "\1\177",
            "\1\u0080",
            "\1\u0081",
            "\1\u0082",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "\1\u0085\2\uffff\1\u0084",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "\1\u0087",
            "\1\u0088",
            "\1\u0089",
            "\1\u008a",
            "\1\u008b",
            "\1\u008c",
            "\1\u008d",
            "\1\u008e",
            "\1\u008f",
            "\1\u0090",
            "\1\u0091",
            "\1\u0092",
            "\1\u0093",
            "\1\u0094",
            "\1\u0095",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "\1\u0096",
            "\1\u0097",
            "",
            "\1\u0098",
            "\1\u0099",
            "",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "\1\u009b",
            "\1\u009c",
            "\1\u009d",
            "\1\u009e",
            "\1\u009f",
            "\1\u00a0",
            "\1\u00a1",
            "\1\u00a2",
            "\1\u00a3",
            "\1\u00a4",
            "\1\u00a5",
            "\1\u00a6",
            "\1\u00a7",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "\1\u00ab",
            "\1\u00ac",
            "",
            "\1\u00ad",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "\1\u00af",
            "\1\u00b0",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "\1\u00b5",
            "\1\u00b6",
            "\1\u00b7",
            "\1\u00b8",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "",
            "",
            "",
            "\1\u00ba",
            "\1\u00bb",
            "\1\u00bc",
            "",
            "\1\u00bd",
            "\1\u00be",
            "",
            "",
            "",
            "",
            "\1\u00bf",
            "\1\u00c0",
            "\1\u00c1",
            "\1\u00c2",
            "",
            "\1\u00c3",
            "\1\u00c4",
            "\1\u00c5",
            "\1\u00c6",
            "\1\u00c7",
            "\12\41\7\uffff\4\41\1\u00c8\25\41\4\uffff\1\41\1\uffff\32\41",
            "\12\41\7\uffff\4\41\1\u00ca\25\41\4\uffff\1\41\1\uffff\32\41",
            "\1\u00cc",
            "\1\u00cd",
            "\1\u00ce",
            "\1\u00cf",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "\1\u00d1",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "\1\u00d3",
            "",
            "\1\u00d4",
            "",
            "\1\u00d5",
            "\1\u00d6",
            "\1\u00d7\7\uffff\1\u00d8",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "",
            "\1\u00db",
            "\1\u00dc",
            "\1\u00dd",
            "\1\u00de",
            "\1\u00df",
            "\1\u00e0",
            "",
            "",
            "\1\u00e1",
            "\1\u00e2",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "\1\u00e4",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "\1\u00e6",
            "\1\u00e7",
            "\1\u00e8",
            "",
            "\1\u00e9",
            "",
            "\1\u00ea",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "\1\u00ed",
            "\1\u00ee",
            "",
            "",
            "\1\u00ef",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "",
            ""
    };

    static final short[] DFA14_eot = DFA.unpackEncodedString(DFA14_eotS);
    static final short[] DFA14_eof = DFA.unpackEncodedString(DFA14_eofS);
    static final char[] DFA14_min = DFA.unpackEncodedStringToUnsignedChars(DFA14_minS);
    static final char[] DFA14_max = DFA.unpackEncodedStringToUnsignedChars(DFA14_maxS);
    static final short[] DFA14_accept = DFA.unpackEncodedString(DFA14_acceptS);
    static final short[] DFA14_special = DFA.unpackEncodedString(DFA14_specialS);
    static final short[][] DFA14_transition;

    static {
        int numStates = DFA14_transitionS.length;
        DFA14_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA14_transition[i] = DFA.unpackEncodedString(DFA14_transitionS[i]);
        }
    }

    class DFA14 extends DFA {

        public DFA14(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 14;
            this.eot = DFA14_eot;
            this.eof = DFA14_eof;
            this.min = DFA14_min;
            this.max = DFA14_max;
            this.accept = DFA14_accept;
            this.special = DFA14_special;
            this.transition = DFA14_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | RULE_BOOLEAN | RULE_SIGNED_INT | RULE_ID | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA14_27 = input.LA(1);

                        s = -1;
                        if ( ((LA14_27>='\u0000' && LA14_27<='\uFFFF')) ) {s = 62;}

                        else s = 31;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA14_28 = input.LA(1);

                        s = -1;
                        if ( ((LA14_28>='\u0000' && LA14_28<='\uFFFF')) ) {s = 62;}

                        else s = 31;

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA14_0 = input.LA(1);

                        s = -1;
                        if ( (LA14_0=='d') ) {s = 1;}

                        else if ( (LA14_0=='c') ) {s = 2;}

                        else if ( (LA14_0=='m') ) {s = 3;}

                        else if ( (LA14_0==':') ) {s = 4;}

                        else if ( (LA14_0=='<') ) {s = 5;}

                        else if ( (LA14_0=='>') ) {s = 6;}

                        else if ( (LA14_0=='=') ) {s = 7;}

                        else if ( (LA14_0=='i') ) {s = 8;}

                        else if ( (LA14_0=='x') ) {s = 9;}

                        else if ( (LA14_0=='o') ) {s = 10;}

                        else if ( (LA14_0=='a') ) {s = 11;}

                        else if ( (LA14_0=='n') ) {s = 12;}

                        else if ( (LA14_0=='(') ) {s = 13;}

                        else if ( (LA14_0==')') ) {s = 14;}

                        else if ( (LA14_0==',') ) {s = 15;}

                        else if ( (LA14_0=='f') ) {s = 16;}

                        else if ( (LA14_0=='e') ) {s = 17;}

                        else if ( (LA14_0=='s') ) {s = 18;}

                        else if ( (LA14_0=='.') ) {s = 19;}

                        else if ( (LA14_0=='g') ) {s = 20;}

                        else if ( (LA14_0=='$') ) {s = 21;}

                        else if ( (LA14_0=='t') ) {s = 22;}

                        else if ( (LA14_0=='-') ) {s = 23;}

                        else if ( ((LA14_0>='0' && LA14_0<='9')) ) {s = 24;}

                        else if ( (LA14_0=='^') ) {s = 25;}

                        else if ( ((LA14_0>='A' && LA14_0<='Z')||LA14_0=='_'||LA14_0=='b'||LA14_0=='h'||(LA14_0>='j' && LA14_0<='l')||(LA14_0>='p' && LA14_0<='r')||(LA14_0>='u' && LA14_0<='w')||(LA14_0>='y' && LA14_0<='z')) ) {s = 26;}

                        else if ( (LA14_0=='\"') ) {s = 27;}

                        else if ( (LA14_0=='\'') ) {s = 28;}

                        else if ( (LA14_0=='/') ) {s = 29;}

                        else if ( ((LA14_0>='\t' && LA14_0<='\n')||LA14_0=='\r'||LA14_0==' ') ) {s = 30;}

                        else if ( ((LA14_0>='\u0000' && LA14_0<='\b')||(LA14_0>='\u000B' && LA14_0<='\f')||(LA14_0>='\u000E' && LA14_0<='\u001F')||LA14_0=='!'||LA14_0=='#'||(LA14_0>='%' && LA14_0<='&')||(LA14_0>='*' && LA14_0<='+')||LA14_0==';'||(LA14_0>='?' && LA14_0<='@')||(LA14_0>='[' && LA14_0<=']')||LA14_0=='`'||(LA14_0>='{' && LA14_0<='\uFFFF')) ) {s = 31;}

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 14, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}