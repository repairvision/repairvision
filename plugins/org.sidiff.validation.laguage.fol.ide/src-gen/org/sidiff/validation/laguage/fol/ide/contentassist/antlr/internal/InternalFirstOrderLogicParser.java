package org.sidiff.validation.laguage.fol.ide.contentassist.antlr.internal;

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.DFA;
import org.sidiff.validation.laguage.fol.services.FirstOrderLogicGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalFirstOrderLogicParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'true'", "'false'", "'domain'", "'import'", "'constraint'", "'message'", "'context'", "':'", "'='", "'implies'", "'xor'", "'or'", "'and'", "'not('", "')'", "'isEqual('", "','", "'isGreater('", "'isGreaterEqual('", "'isSmaller('", "'isSmallerEqual('", "'isEmpty('", "'isInstanceOf('", "'forAll('", "'in'", "'exists('", "'('", "'.'", "'::'", "'getContainer('", "'getContainments('", "'getClosure('", "'concatenate('", "'capitalize('"
    };
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int RULE_ID=5;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=6;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int RULE_STRING=4;
    public static final int RULE_SL_COMMENT=8;
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
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__44=44;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;

    // delegates
    // delegators


        public InternalFirstOrderLogicParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalFirstOrderLogicParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalFirstOrderLogicParser.tokenNames; }
    public String getGrammarFileName() { return "InternalFirstOrderLogic.g"; }


    	private FirstOrderLogicGrammarAccess grammarAccess;

    	public void setGrammarAccess(FirstOrderLogicGrammarAccess grammarAccess) {
    		this.grammarAccess = grammarAccess;
    	}

    	@Override
    	protected Grammar getGrammar() {
    		return grammarAccess.getGrammar();
    	}

    	@Override
    	protected String getValueForTokenName(String tokenName) {
    		return tokenName;
    	}



    // $ANTLR start "entryRuleConstraintLibrary"
    // InternalFirstOrderLogic.g:53:1: entryRuleConstraintLibrary : ruleConstraintLibrary EOF ;
    public final void entryRuleConstraintLibrary() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:54:1: ( ruleConstraintLibrary EOF )
            // InternalFirstOrderLogic.g:55:1: ruleConstraintLibrary EOF
            {
             before(grammarAccess.getConstraintLibraryRule()); 
            pushFollow(FOLLOW_1);
            ruleConstraintLibrary();

            state._fsp--;

             after(grammarAccess.getConstraintLibraryRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleConstraintLibrary"


    // $ANTLR start "ruleConstraintLibrary"
    // InternalFirstOrderLogic.g:62:1: ruleConstraintLibrary : ( ( rule__ConstraintLibrary__Group__0 ) ) ;
    public final void ruleConstraintLibrary() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:66:2: ( ( ( rule__ConstraintLibrary__Group__0 ) ) )
            // InternalFirstOrderLogic.g:67:2: ( ( rule__ConstraintLibrary__Group__0 ) )
            {
            // InternalFirstOrderLogic.g:67:2: ( ( rule__ConstraintLibrary__Group__0 ) )
            // InternalFirstOrderLogic.g:68:3: ( rule__ConstraintLibrary__Group__0 )
            {
             before(grammarAccess.getConstraintLibraryAccess().getGroup()); 
            // InternalFirstOrderLogic.g:69:3: ( rule__ConstraintLibrary__Group__0 )
            // InternalFirstOrderLogic.g:69:4: rule__ConstraintLibrary__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ConstraintLibrary__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getConstraintLibraryAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleConstraintLibrary"


    // $ANTLR start "entryRuleConstraint"
    // InternalFirstOrderLogic.g:78:1: entryRuleConstraint : ruleConstraint EOF ;
    public final void entryRuleConstraint() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:79:1: ( ruleConstraint EOF )
            // InternalFirstOrderLogic.g:80:1: ruleConstraint EOF
            {
             before(grammarAccess.getConstraintRule()); 
            pushFollow(FOLLOW_1);
            ruleConstraint();

            state._fsp--;

             after(grammarAccess.getConstraintRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleConstraint"


    // $ANTLR start "ruleConstraint"
    // InternalFirstOrderLogic.g:87:1: ruleConstraint : ( ( rule__Constraint__Group__0 ) ) ;
    public final void ruleConstraint() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:91:2: ( ( ( rule__Constraint__Group__0 ) ) )
            // InternalFirstOrderLogic.g:92:2: ( ( rule__Constraint__Group__0 ) )
            {
            // InternalFirstOrderLogic.g:92:2: ( ( rule__Constraint__Group__0 ) )
            // InternalFirstOrderLogic.g:93:3: ( rule__Constraint__Group__0 )
            {
             before(grammarAccess.getConstraintAccess().getGroup()); 
            // InternalFirstOrderLogic.g:94:3: ( rule__Constraint__Group__0 )
            // InternalFirstOrderLogic.g:94:4: rule__Constraint__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Constraint__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getConstraintAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleConstraint"


    // $ANTLR start "entryRuleVariable"
    // InternalFirstOrderLogic.g:103:1: entryRuleVariable : ruleVariable EOF ;
    public final void entryRuleVariable() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:104:1: ( ruleVariable EOF )
            // InternalFirstOrderLogic.g:105:1: ruleVariable EOF
            {
             before(grammarAccess.getVariableRule()); 
            pushFollow(FOLLOW_1);
            ruleVariable();

            state._fsp--;

             after(grammarAccess.getVariableRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleVariable"


    // $ANTLR start "ruleVariable"
    // InternalFirstOrderLogic.g:112:1: ruleVariable : ( ( rule__Variable__Group__0 ) ) ;
    public final void ruleVariable() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:116:2: ( ( ( rule__Variable__Group__0 ) ) )
            // InternalFirstOrderLogic.g:117:2: ( ( rule__Variable__Group__0 ) )
            {
            // InternalFirstOrderLogic.g:117:2: ( ( rule__Variable__Group__0 ) )
            // InternalFirstOrderLogic.g:118:3: ( rule__Variable__Group__0 )
            {
             before(grammarAccess.getVariableAccess().getGroup()); 
            // InternalFirstOrderLogic.g:119:3: ( rule__Variable__Group__0 )
            // InternalFirstOrderLogic.g:119:4: rule__Variable__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Variable__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getVariableAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleVariable"


    // $ANTLR start "entryRuleFormula"
    // InternalFirstOrderLogic.g:128:1: entryRuleFormula : ruleFormula EOF ;
    public final void entryRuleFormula() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:129:1: ( ruleFormula EOF )
            // InternalFirstOrderLogic.g:130:1: ruleFormula EOF
            {
             before(grammarAccess.getFormulaRule()); 
            pushFollow(FOLLOW_1);
            ruleFormula();

            state._fsp--;

             after(grammarAccess.getFormulaRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleFormula"


    // $ANTLR start "ruleFormula"
    // InternalFirstOrderLogic.g:137:1: ruleFormula : ( ruleBinaryFormula ) ;
    public final void ruleFormula() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:141:2: ( ( ruleBinaryFormula ) )
            // InternalFirstOrderLogic.g:142:2: ( ruleBinaryFormula )
            {
            // InternalFirstOrderLogic.g:142:2: ( ruleBinaryFormula )
            // InternalFirstOrderLogic.g:143:3: ruleBinaryFormula
            {
             before(grammarAccess.getFormulaAccess().getBinaryFormulaParserRuleCall()); 
            pushFollow(FOLLOW_2);
            ruleBinaryFormula();

            state._fsp--;

             after(grammarAccess.getFormulaAccess().getBinaryFormulaParserRuleCall()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleFormula"


    // $ANTLR start "entryRuleBinaryFormula"
    // InternalFirstOrderLogic.g:153:1: entryRuleBinaryFormula : ruleBinaryFormula EOF ;
    public final void entryRuleBinaryFormula() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:154:1: ( ruleBinaryFormula EOF )
            // InternalFirstOrderLogic.g:155:1: ruleBinaryFormula EOF
            {
             before(grammarAccess.getBinaryFormulaRule()); 
            pushFollow(FOLLOW_1);
            ruleBinaryFormula();

            state._fsp--;

             after(grammarAccess.getBinaryFormulaRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleBinaryFormula"


    // $ANTLR start "ruleBinaryFormula"
    // InternalFirstOrderLogic.g:162:1: ruleBinaryFormula : ( ruleIff ) ;
    public final void ruleBinaryFormula() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:166:2: ( ( ruleIff ) )
            // InternalFirstOrderLogic.g:167:2: ( ruleIff )
            {
            // InternalFirstOrderLogic.g:167:2: ( ruleIff )
            // InternalFirstOrderLogic.g:168:3: ruleIff
            {
             before(grammarAccess.getBinaryFormulaAccess().getIffParserRuleCall()); 
            pushFollow(FOLLOW_2);
            ruleIff();

            state._fsp--;

             after(grammarAccess.getBinaryFormulaAccess().getIffParserRuleCall()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleBinaryFormula"


    // $ANTLR start "entryRuleIff"
    // InternalFirstOrderLogic.g:178:1: entryRuleIff : ruleIff EOF ;
    public final void entryRuleIff() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:179:1: ( ruleIff EOF )
            // InternalFirstOrderLogic.g:180:1: ruleIff EOF
            {
             before(grammarAccess.getIffRule()); 
            pushFollow(FOLLOW_1);
            ruleIff();

            state._fsp--;

             after(grammarAccess.getIffRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleIff"


    // $ANTLR start "ruleIff"
    // InternalFirstOrderLogic.g:187:1: ruleIff : ( ( rule__Iff__Group__0 ) ) ;
    public final void ruleIff() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:191:2: ( ( ( rule__Iff__Group__0 ) ) )
            // InternalFirstOrderLogic.g:192:2: ( ( rule__Iff__Group__0 ) )
            {
            // InternalFirstOrderLogic.g:192:2: ( ( rule__Iff__Group__0 ) )
            // InternalFirstOrderLogic.g:193:3: ( rule__Iff__Group__0 )
            {
             before(grammarAccess.getIffAccess().getGroup()); 
            // InternalFirstOrderLogic.g:194:3: ( rule__Iff__Group__0 )
            // InternalFirstOrderLogic.g:194:4: rule__Iff__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Iff__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getIffAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleIff"


    // $ANTLR start "entryRuleIf"
    // InternalFirstOrderLogic.g:203:1: entryRuleIf : ruleIf EOF ;
    public final void entryRuleIf() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:204:1: ( ruleIf EOF )
            // InternalFirstOrderLogic.g:205:1: ruleIf EOF
            {
             before(grammarAccess.getIfRule()); 
            pushFollow(FOLLOW_1);
            ruleIf();

            state._fsp--;

             after(grammarAccess.getIfRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleIf"


    // $ANTLR start "ruleIf"
    // InternalFirstOrderLogic.g:212:1: ruleIf : ( ( rule__If__Group__0 ) ) ;
    public final void ruleIf() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:216:2: ( ( ( rule__If__Group__0 ) ) )
            // InternalFirstOrderLogic.g:217:2: ( ( rule__If__Group__0 ) )
            {
            // InternalFirstOrderLogic.g:217:2: ( ( rule__If__Group__0 ) )
            // InternalFirstOrderLogic.g:218:3: ( rule__If__Group__0 )
            {
             before(grammarAccess.getIfAccess().getGroup()); 
            // InternalFirstOrderLogic.g:219:3: ( rule__If__Group__0 )
            // InternalFirstOrderLogic.g:219:4: rule__If__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__If__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getIfAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleIf"


    // $ANTLR start "entryRuleXor"
    // InternalFirstOrderLogic.g:228:1: entryRuleXor : ruleXor EOF ;
    public final void entryRuleXor() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:229:1: ( ruleXor EOF )
            // InternalFirstOrderLogic.g:230:1: ruleXor EOF
            {
             before(grammarAccess.getXorRule()); 
            pushFollow(FOLLOW_1);
            ruleXor();

            state._fsp--;

             after(grammarAccess.getXorRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleXor"


    // $ANTLR start "ruleXor"
    // InternalFirstOrderLogic.g:237:1: ruleXor : ( ( rule__Xor__Group__0 ) ) ;
    public final void ruleXor() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:241:2: ( ( ( rule__Xor__Group__0 ) ) )
            // InternalFirstOrderLogic.g:242:2: ( ( rule__Xor__Group__0 ) )
            {
            // InternalFirstOrderLogic.g:242:2: ( ( rule__Xor__Group__0 ) )
            // InternalFirstOrderLogic.g:243:3: ( rule__Xor__Group__0 )
            {
             before(grammarAccess.getXorAccess().getGroup()); 
            // InternalFirstOrderLogic.g:244:3: ( rule__Xor__Group__0 )
            // InternalFirstOrderLogic.g:244:4: rule__Xor__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Xor__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getXorAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleXor"


    // $ANTLR start "entryRuleOr"
    // InternalFirstOrderLogic.g:253:1: entryRuleOr : ruleOr EOF ;
    public final void entryRuleOr() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:254:1: ( ruleOr EOF )
            // InternalFirstOrderLogic.g:255:1: ruleOr EOF
            {
             before(grammarAccess.getOrRule()); 
            pushFollow(FOLLOW_1);
            ruleOr();

            state._fsp--;

             after(grammarAccess.getOrRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleOr"


    // $ANTLR start "ruleOr"
    // InternalFirstOrderLogic.g:262:1: ruleOr : ( ( rule__Or__Group__0 ) ) ;
    public final void ruleOr() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:266:2: ( ( ( rule__Or__Group__0 ) ) )
            // InternalFirstOrderLogic.g:267:2: ( ( rule__Or__Group__0 ) )
            {
            // InternalFirstOrderLogic.g:267:2: ( ( rule__Or__Group__0 ) )
            // InternalFirstOrderLogic.g:268:3: ( rule__Or__Group__0 )
            {
             before(grammarAccess.getOrAccess().getGroup()); 
            // InternalFirstOrderLogic.g:269:3: ( rule__Or__Group__0 )
            // InternalFirstOrderLogic.g:269:4: rule__Or__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Or__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getOrAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleOr"


    // $ANTLR start "entryRuleAnd"
    // InternalFirstOrderLogic.g:278:1: entryRuleAnd : ruleAnd EOF ;
    public final void entryRuleAnd() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:279:1: ( ruleAnd EOF )
            // InternalFirstOrderLogic.g:280:1: ruleAnd EOF
            {
             before(grammarAccess.getAndRule()); 
            pushFollow(FOLLOW_1);
            ruleAnd();

            state._fsp--;

             after(grammarAccess.getAndRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAnd"


    // $ANTLR start "ruleAnd"
    // InternalFirstOrderLogic.g:287:1: ruleAnd : ( ( rule__And__Group__0 ) ) ;
    public final void ruleAnd() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:291:2: ( ( ( rule__And__Group__0 ) ) )
            // InternalFirstOrderLogic.g:292:2: ( ( rule__And__Group__0 ) )
            {
            // InternalFirstOrderLogic.g:292:2: ( ( rule__And__Group__0 ) )
            // InternalFirstOrderLogic.g:293:3: ( rule__And__Group__0 )
            {
             before(grammarAccess.getAndAccess().getGroup()); 
            // InternalFirstOrderLogic.g:294:3: ( rule__And__Group__0 )
            // InternalFirstOrderLogic.g:294:4: rule__And__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__And__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getAndAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAnd"


    // $ANTLR start "entryRuleUnaryFormula"
    // InternalFirstOrderLogic.g:303:1: entryRuleUnaryFormula : ruleUnaryFormula EOF ;
    public final void entryRuleUnaryFormula() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:304:1: ( ruleUnaryFormula EOF )
            // InternalFirstOrderLogic.g:305:1: ruleUnaryFormula EOF
            {
             before(grammarAccess.getUnaryFormulaRule()); 
            pushFollow(FOLLOW_1);
            ruleUnaryFormula();

            state._fsp--;

             after(grammarAccess.getUnaryFormulaRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleUnaryFormula"


    // $ANTLR start "ruleUnaryFormula"
    // InternalFirstOrderLogic.g:312:1: ruleUnaryFormula : ( ruleNot ) ;
    public final void ruleUnaryFormula() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:316:2: ( ( ruleNot ) )
            // InternalFirstOrderLogic.g:317:2: ( ruleNot )
            {
            // InternalFirstOrderLogic.g:317:2: ( ruleNot )
            // InternalFirstOrderLogic.g:318:3: ruleNot
            {
             before(grammarAccess.getUnaryFormulaAccess().getNotParserRuleCall()); 
            pushFollow(FOLLOW_2);
            ruleNot();

            state._fsp--;

             after(grammarAccess.getUnaryFormulaAccess().getNotParserRuleCall()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleUnaryFormula"


    // $ANTLR start "entryRuleNot"
    // InternalFirstOrderLogic.g:328:1: entryRuleNot : ruleNot EOF ;
    public final void entryRuleNot() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:329:1: ( ruleNot EOF )
            // InternalFirstOrderLogic.g:330:1: ruleNot EOF
            {
             before(grammarAccess.getNotRule()); 
            pushFollow(FOLLOW_1);
            ruleNot();

            state._fsp--;

             after(grammarAccess.getNotRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleNot"


    // $ANTLR start "ruleNot"
    // InternalFirstOrderLogic.g:337:1: ruleNot : ( ( rule__Not__Group__0 ) ) ;
    public final void ruleNot() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:341:2: ( ( ( rule__Not__Group__0 ) ) )
            // InternalFirstOrderLogic.g:342:2: ( ( rule__Not__Group__0 ) )
            {
            // InternalFirstOrderLogic.g:342:2: ( ( rule__Not__Group__0 ) )
            // InternalFirstOrderLogic.g:343:3: ( rule__Not__Group__0 )
            {
             before(grammarAccess.getNotAccess().getGroup()); 
            // InternalFirstOrderLogic.g:344:3: ( rule__Not__Group__0 )
            // InternalFirstOrderLogic.g:344:4: rule__Not__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Not__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getNotAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleNot"


    // $ANTLR start "entryRulePredicate"
    // InternalFirstOrderLogic.g:353:1: entryRulePredicate : rulePredicate EOF ;
    public final void entryRulePredicate() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:354:1: ( rulePredicate EOF )
            // InternalFirstOrderLogic.g:355:1: rulePredicate EOF
            {
             before(grammarAccess.getPredicateRule()); 
            pushFollow(FOLLOW_1);
            rulePredicate();

            state._fsp--;

             after(grammarAccess.getPredicateRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePredicate"


    // $ANTLR start "rulePredicate"
    // InternalFirstOrderLogic.g:362:1: rulePredicate : ( ( rule__Predicate__Alternatives ) ) ;
    public final void rulePredicate() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:366:2: ( ( ( rule__Predicate__Alternatives ) ) )
            // InternalFirstOrderLogic.g:367:2: ( ( rule__Predicate__Alternatives ) )
            {
            // InternalFirstOrderLogic.g:367:2: ( ( rule__Predicate__Alternatives ) )
            // InternalFirstOrderLogic.g:368:3: ( rule__Predicate__Alternatives )
            {
             before(grammarAccess.getPredicateAccess().getAlternatives()); 
            // InternalFirstOrderLogic.g:369:3: ( rule__Predicate__Alternatives )
            // InternalFirstOrderLogic.g:369:4: rule__Predicate__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Predicate__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getPredicateAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePredicate"


    // $ANTLR start "entryRuleEquals"
    // InternalFirstOrderLogic.g:378:1: entryRuleEquals : ruleEquals EOF ;
    public final void entryRuleEquals() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:379:1: ( ruleEquals EOF )
            // InternalFirstOrderLogic.g:380:1: ruleEquals EOF
            {
             before(grammarAccess.getEqualsRule()); 
            pushFollow(FOLLOW_1);
            ruleEquals();

            state._fsp--;

             after(grammarAccess.getEqualsRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleEquals"


    // $ANTLR start "ruleEquals"
    // InternalFirstOrderLogic.g:387:1: ruleEquals : ( ( rule__Equals__Group__0 ) ) ;
    public final void ruleEquals() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:391:2: ( ( ( rule__Equals__Group__0 ) ) )
            // InternalFirstOrderLogic.g:392:2: ( ( rule__Equals__Group__0 ) )
            {
            // InternalFirstOrderLogic.g:392:2: ( ( rule__Equals__Group__0 ) )
            // InternalFirstOrderLogic.g:393:3: ( rule__Equals__Group__0 )
            {
             before(grammarAccess.getEqualsAccess().getGroup()); 
            // InternalFirstOrderLogic.g:394:3: ( rule__Equals__Group__0 )
            // InternalFirstOrderLogic.g:394:4: rule__Equals__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Equals__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getEqualsAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEquals"


    // $ANTLR start "entryRuleInequality"
    // InternalFirstOrderLogic.g:403:1: entryRuleInequality : ruleInequality EOF ;
    public final void entryRuleInequality() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:404:1: ( ruleInequality EOF )
            // InternalFirstOrderLogic.g:405:1: ruleInequality EOF
            {
             before(grammarAccess.getInequalityRule()); 
            pushFollow(FOLLOW_1);
            ruleInequality();

            state._fsp--;

             after(grammarAccess.getInequalityRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleInequality"


    // $ANTLR start "ruleInequality"
    // InternalFirstOrderLogic.g:412:1: ruleInequality : ( ( rule__Inequality__Alternatives ) ) ;
    public final void ruleInequality() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:416:2: ( ( ( rule__Inequality__Alternatives ) ) )
            // InternalFirstOrderLogic.g:417:2: ( ( rule__Inequality__Alternatives ) )
            {
            // InternalFirstOrderLogic.g:417:2: ( ( rule__Inequality__Alternatives ) )
            // InternalFirstOrderLogic.g:418:3: ( rule__Inequality__Alternatives )
            {
             before(grammarAccess.getInequalityAccess().getAlternatives()); 
            // InternalFirstOrderLogic.g:419:3: ( rule__Inequality__Alternatives )
            // InternalFirstOrderLogic.g:419:4: rule__Inequality__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Inequality__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getInequalityAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleInequality"


    // $ANTLR start "entryRuleGreater"
    // InternalFirstOrderLogic.g:428:1: entryRuleGreater : ruleGreater EOF ;
    public final void entryRuleGreater() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:429:1: ( ruleGreater EOF )
            // InternalFirstOrderLogic.g:430:1: ruleGreater EOF
            {
             before(grammarAccess.getGreaterRule()); 
            pushFollow(FOLLOW_1);
            ruleGreater();

            state._fsp--;

             after(grammarAccess.getGreaterRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleGreater"


    // $ANTLR start "ruleGreater"
    // InternalFirstOrderLogic.g:437:1: ruleGreater : ( ( rule__Greater__Group__0 ) ) ;
    public final void ruleGreater() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:441:2: ( ( ( rule__Greater__Group__0 ) ) )
            // InternalFirstOrderLogic.g:442:2: ( ( rule__Greater__Group__0 ) )
            {
            // InternalFirstOrderLogic.g:442:2: ( ( rule__Greater__Group__0 ) )
            // InternalFirstOrderLogic.g:443:3: ( rule__Greater__Group__0 )
            {
             before(grammarAccess.getGreaterAccess().getGroup()); 
            // InternalFirstOrderLogic.g:444:3: ( rule__Greater__Group__0 )
            // InternalFirstOrderLogic.g:444:4: rule__Greater__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Greater__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getGreaterAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleGreater"


    // $ANTLR start "entryRuleGreaterEqual"
    // InternalFirstOrderLogic.g:453:1: entryRuleGreaterEqual : ruleGreaterEqual EOF ;
    public final void entryRuleGreaterEqual() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:454:1: ( ruleGreaterEqual EOF )
            // InternalFirstOrderLogic.g:455:1: ruleGreaterEqual EOF
            {
             before(grammarAccess.getGreaterEqualRule()); 
            pushFollow(FOLLOW_1);
            ruleGreaterEqual();

            state._fsp--;

             after(grammarAccess.getGreaterEqualRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleGreaterEqual"


    // $ANTLR start "ruleGreaterEqual"
    // InternalFirstOrderLogic.g:462:1: ruleGreaterEqual : ( ( rule__GreaterEqual__Group__0 ) ) ;
    public final void ruleGreaterEqual() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:466:2: ( ( ( rule__GreaterEqual__Group__0 ) ) )
            // InternalFirstOrderLogic.g:467:2: ( ( rule__GreaterEqual__Group__0 ) )
            {
            // InternalFirstOrderLogic.g:467:2: ( ( rule__GreaterEqual__Group__0 ) )
            // InternalFirstOrderLogic.g:468:3: ( rule__GreaterEqual__Group__0 )
            {
             before(grammarAccess.getGreaterEqualAccess().getGroup()); 
            // InternalFirstOrderLogic.g:469:3: ( rule__GreaterEqual__Group__0 )
            // InternalFirstOrderLogic.g:469:4: rule__GreaterEqual__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__GreaterEqual__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getGreaterEqualAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleGreaterEqual"


    // $ANTLR start "entryRuleSmaller"
    // InternalFirstOrderLogic.g:478:1: entryRuleSmaller : ruleSmaller EOF ;
    public final void entryRuleSmaller() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:479:1: ( ruleSmaller EOF )
            // InternalFirstOrderLogic.g:480:1: ruleSmaller EOF
            {
             before(grammarAccess.getSmallerRule()); 
            pushFollow(FOLLOW_1);
            ruleSmaller();

            state._fsp--;

             after(grammarAccess.getSmallerRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleSmaller"


    // $ANTLR start "ruleSmaller"
    // InternalFirstOrderLogic.g:487:1: ruleSmaller : ( ( rule__Smaller__Group__0 ) ) ;
    public final void ruleSmaller() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:491:2: ( ( ( rule__Smaller__Group__0 ) ) )
            // InternalFirstOrderLogic.g:492:2: ( ( rule__Smaller__Group__0 ) )
            {
            // InternalFirstOrderLogic.g:492:2: ( ( rule__Smaller__Group__0 ) )
            // InternalFirstOrderLogic.g:493:3: ( rule__Smaller__Group__0 )
            {
             before(grammarAccess.getSmallerAccess().getGroup()); 
            // InternalFirstOrderLogic.g:494:3: ( rule__Smaller__Group__0 )
            // InternalFirstOrderLogic.g:494:4: rule__Smaller__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Smaller__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getSmallerAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSmaller"


    // $ANTLR start "entryRuleSmallerEqual"
    // InternalFirstOrderLogic.g:503:1: entryRuleSmallerEqual : ruleSmallerEqual EOF ;
    public final void entryRuleSmallerEqual() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:504:1: ( ruleSmallerEqual EOF )
            // InternalFirstOrderLogic.g:505:1: ruleSmallerEqual EOF
            {
             before(grammarAccess.getSmallerEqualRule()); 
            pushFollow(FOLLOW_1);
            ruleSmallerEqual();

            state._fsp--;

             after(grammarAccess.getSmallerEqualRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleSmallerEqual"


    // $ANTLR start "ruleSmallerEqual"
    // InternalFirstOrderLogic.g:512:1: ruleSmallerEqual : ( ( rule__SmallerEqual__Group__0 ) ) ;
    public final void ruleSmallerEqual() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:516:2: ( ( ( rule__SmallerEqual__Group__0 ) ) )
            // InternalFirstOrderLogic.g:517:2: ( ( rule__SmallerEqual__Group__0 ) )
            {
            // InternalFirstOrderLogic.g:517:2: ( ( rule__SmallerEqual__Group__0 ) )
            // InternalFirstOrderLogic.g:518:3: ( rule__SmallerEqual__Group__0 )
            {
             before(grammarAccess.getSmallerEqualAccess().getGroup()); 
            // InternalFirstOrderLogic.g:519:3: ( rule__SmallerEqual__Group__0 )
            // InternalFirstOrderLogic.g:519:4: rule__SmallerEqual__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__SmallerEqual__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getSmallerEqualAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSmallerEqual"


    // $ANTLR start "entryRuleIsEmpty"
    // InternalFirstOrderLogic.g:528:1: entryRuleIsEmpty : ruleIsEmpty EOF ;
    public final void entryRuleIsEmpty() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:529:1: ( ruleIsEmpty EOF )
            // InternalFirstOrderLogic.g:530:1: ruleIsEmpty EOF
            {
             before(grammarAccess.getIsEmptyRule()); 
            pushFollow(FOLLOW_1);
            ruleIsEmpty();

            state._fsp--;

             after(grammarAccess.getIsEmptyRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleIsEmpty"


    // $ANTLR start "ruleIsEmpty"
    // InternalFirstOrderLogic.g:537:1: ruleIsEmpty : ( ( rule__IsEmpty__Group__0 ) ) ;
    public final void ruleIsEmpty() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:541:2: ( ( ( rule__IsEmpty__Group__0 ) ) )
            // InternalFirstOrderLogic.g:542:2: ( ( rule__IsEmpty__Group__0 ) )
            {
            // InternalFirstOrderLogic.g:542:2: ( ( rule__IsEmpty__Group__0 ) )
            // InternalFirstOrderLogic.g:543:3: ( rule__IsEmpty__Group__0 )
            {
             before(grammarAccess.getIsEmptyAccess().getGroup()); 
            // InternalFirstOrderLogic.g:544:3: ( rule__IsEmpty__Group__0 )
            // InternalFirstOrderLogic.g:544:4: rule__IsEmpty__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__IsEmpty__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getIsEmptyAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleIsEmpty"


    // $ANTLR start "entryRuleIsInstanceOf"
    // InternalFirstOrderLogic.g:553:1: entryRuleIsInstanceOf : ruleIsInstanceOf EOF ;
    public final void entryRuleIsInstanceOf() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:554:1: ( ruleIsInstanceOf EOF )
            // InternalFirstOrderLogic.g:555:1: ruleIsInstanceOf EOF
            {
             before(grammarAccess.getIsInstanceOfRule()); 
            pushFollow(FOLLOW_1);
            ruleIsInstanceOf();

            state._fsp--;

             after(grammarAccess.getIsInstanceOfRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleIsInstanceOf"


    // $ANTLR start "ruleIsInstanceOf"
    // InternalFirstOrderLogic.g:562:1: ruleIsInstanceOf : ( ( rule__IsInstanceOf__Group__0 ) ) ;
    public final void ruleIsInstanceOf() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:566:2: ( ( ( rule__IsInstanceOf__Group__0 ) ) )
            // InternalFirstOrderLogic.g:567:2: ( ( rule__IsInstanceOf__Group__0 ) )
            {
            // InternalFirstOrderLogic.g:567:2: ( ( rule__IsInstanceOf__Group__0 ) )
            // InternalFirstOrderLogic.g:568:3: ( rule__IsInstanceOf__Group__0 )
            {
             before(grammarAccess.getIsInstanceOfAccess().getGroup()); 
            // InternalFirstOrderLogic.g:569:3: ( rule__IsInstanceOf__Group__0 )
            // InternalFirstOrderLogic.g:569:4: rule__IsInstanceOf__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__IsInstanceOf__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getIsInstanceOfAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleIsInstanceOf"


    // $ANTLR start "entryRuleQuantifier"
    // InternalFirstOrderLogic.g:578:1: entryRuleQuantifier : ruleQuantifier EOF ;
    public final void entryRuleQuantifier() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:579:1: ( ruleQuantifier EOF )
            // InternalFirstOrderLogic.g:580:1: ruleQuantifier EOF
            {
             before(grammarAccess.getQuantifierRule()); 
            pushFollow(FOLLOW_1);
            ruleQuantifier();

            state._fsp--;

             after(grammarAccess.getQuantifierRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleQuantifier"


    // $ANTLR start "ruleQuantifier"
    // InternalFirstOrderLogic.g:587:1: ruleQuantifier : ( ( rule__Quantifier__Alternatives ) ) ;
    public final void ruleQuantifier() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:591:2: ( ( ( rule__Quantifier__Alternatives ) ) )
            // InternalFirstOrderLogic.g:592:2: ( ( rule__Quantifier__Alternatives ) )
            {
            // InternalFirstOrderLogic.g:592:2: ( ( rule__Quantifier__Alternatives ) )
            // InternalFirstOrderLogic.g:593:3: ( rule__Quantifier__Alternatives )
            {
             before(grammarAccess.getQuantifierAccess().getAlternatives()); 
            // InternalFirstOrderLogic.g:594:3: ( rule__Quantifier__Alternatives )
            // InternalFirstOrderLogic.g:594:4: rule__Quantifier__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Quantifier__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getQuantifierAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleQuantifier"


    // $ANTLR start "entryRuleForAll"
    // InternalFirstOrderLogic.g:603:1: entryRuleForAll : ruleForAll EOF ;
    public final void entryRuleForAll() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:604:1: ( ruleForAll EOF )
            // InternalFirstOrderLogic.g:605:1: ruleForAll EOF
            {
             before(grammarAccess.getForAllRule()); 
            pushFollow(FOLLOW_1);
            ruleForAll();

            state._fsp--;

             after(grammarAccess.getForAllRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleForAll"


    // $ANTLR start "ruleForAll"
    // InternalFirstOrderLogic.g:612:1: ruleForAll : ( ( rule__ForAll__Group__0 ) ) ;
    public final void ruleForAll() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:616:2: ( ( ( rule__ForAll__Group__0 ) ) )
            // InternalFirstOrderLogic.g:617:2: ( ( rule__ForAll__Group__0 ) )
            {
            // InternalFirstOrderLogic.g:617:2: ( ( rule__ForAll__Group__0 ) )
            // InternalFirstOrderLogic.g:618:3: ( rule__ForAll__Group__0 )
            {
             before(grammarAccess.getForAllAccess().getGroup()); 
            // InternalFirstOrderLogic.g:619:3: ( rule__ForAll__Group__0 )
            // InternalFirstOrderLogic.g:619:4: rule__ForAll__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ForAll__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getForAllAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleForAll"


    // $ANTLR start "entryRuleExists"
    // InternalFirstOrderLogic.g:628:1: entryRuleExists : ruleExists EOF ;
    public final void entryRuleExists() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:629:1: ( ruleExists EOF )
            // InternalFirstOrderLogic.g:630:1: ruleExists EOF
            {
             before(grammarAccess.getExistsRule()); 
            pushFollow(FOLLOW_1);
            ruleExists();

            state._fsp--;

             after(grammarAccess.getExistsRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleExists"


    // $ANTLR start "ruleExists"
    // InternalFirstOrderLogic.g:637:1: ruleExists : ( ( rule__Exists__Group__0 ) ) ;
    public final void ruleExists() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:641:2: ( ( ( rule__Exists__Group__0 ) ) )
            // InternalFirstOrderLogic.g:642:2: ( ( rule__Exists__Group__0 ) )
            {
            // InternalFirstOrderLogic.g:642:2: ( ( rule__Exists__Group__0 ) )
            // InternalFirstOrderLogic.g:643:3: ( rule__Exists__Group__0 )
            {
             before(grammarAccess.getExistsAccess().getGroup()); 
            // InternalFirstOrderLogic.g:644:3: ( rule__Exists__Group__0 )
            // InternalFirstOrderLogic.g:644:4: rule__Exists__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Exists__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getExistsAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleExists"


    // $ANTLR start "entryRuleBooleanExpression"
    // InternalFirstOrderLogic.g:653:1: entryRuleBooleanExpression : ruleBooleanExpression EOF ;
    public final void entryRuleBooleanExpression() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:654:1: ( ruleBooleanExpression EOF )
            // InternalFirstOrderLogic.g:655:1: ruleBooleanExpression EOF
            {
             before(grammarAccess.getBooleanExpressionRule()); 
            pushFollow(FOLLOW_1);
            ruleBooleanExpression();

            state._fsp--;

             after(grammarAccess.getBooleanExpressionRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleBooleanExpression"


    // $ANTLR start "ruleBooleanExpression"
    // InternalFirstOrderLogic.g:662:1: ruleBooleanExpression : ( ( rule__BooleanExpression__Alternatives ) ) ;
    public final void ruleBooleanExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:666:2: ( ( ( rule__BooleanExpression__Alternatives ) ) )
            // InternalFirstOrderLogic.g:667:2: ( ( rule__BooleanExpression__Alternatives ) )
            {
            // InternalFirstOrderLogic.g:667:2: ( ( rule__BooleanExpression__Alternatives ) )
            // InternalFirstOrderLogic.g:668:3: ( rule__BooleanExpression__Alternatives )
            {
             before(grammarAccess.getBooleanExpressionAccess().getAlternatives()); 
            // InternalFirstOrderLogic.g:669:3: ( rule__BooleanExpression__Alternatives )
            // InternalFirstOrderLogic.g:669:4: rule__BooleanExpression__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__BooleanExpression__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getBooleanExpressionAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleBooleanExpression"


    // $ANTLR start "entryRuleBoolConstant"
    // InternalFirstOrderLogic.g:678:1: entryRuleBoolConstant : ruleBoolConstant EOF ;
    public final void entryRuleBoolConstant() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:679:1: ( ruleBoolConstant EOF )
            // InternalFirstOrderLogic.g:680:1: ruleBoolConstant EOF
            {
             before(grammarAccess.getBoolConstantRule()); 
            pushFollow(FOLLOW_1);
            ruleBoolConstant();

            state._fsp--;

             after(grammarAccess.getBoolConstantRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleBoolConstant"


    // $ANTLR start "ruleBoolConstant"
    // InternalFirstOrderLogic.g:687:1: ruleBoolConstant : ( ( rule__BoolConstant__Group__0 ) ) ;
    public final void ruleBoolConstant() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:691:2: ( ( ( rule__BoolConstant__Group__0 ) ) )
            // InternalFirstOrderLogic.g:692:2: ( ( rule__BoolConstant__Group__0 ) )
            {
            // InternalFirstOrderLogic.g:692:2: ( ( rule__BoolConstant__Group__0 ) )
            // InternalFirstOrderLogic.g:693:3: ( rule__BoolConstant__Group__0 )
            {
             before(grammarAccess.getBoolConstantAccess().getGroup()); 
            // InternalFirstOrderLogic.g:694:3: ( rule__BoolConstant__Group__0 )
            // InternalFirstOrderLogic.g:694:4: rule__BoolConstant__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__BoolConstant__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getBoolConstantAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleBoolConstant"


    // $ANTLR start "entryRuleTerm"
    // InternalFirstOrderLogic.g:703:1: entryRuleTerm : ruleTerm EOF ;
    public final void entryRuleTerm() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:704:1: ( ruleTerm EOF )
            // InternalFirstOrderLogic.g:705:1: ruleTerm EOF
            {
             before(grammarAccess.getTermRule()); 
            pushFollow(FOLLOW_1);
            ruleTerm();

            state._fsp--;

             after(grammarAccess.getTermRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTerm"


    // $ANTLR start "ruleTerm"
    // InternalFirstOrderLogic.g:712:1: ruleTerm : ( ( rule__Term__Alternatives ) ) ;
    public final void ruleTerm() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:716:2: ( ( ( rule__Term__Alternatives ) ) )
            // InternalFirstOrderLogic.g:717:2: ( ( rule__Term__Alternatives ) )
            {
            // InternalFirstOrderLogic.g:717:2: ( ( rule__Term__Alternatives ) )
            // InternalFirstOrderLogic.g:718:3: ( rule__Term__Alternatives )
            {
             before(grammarAccess.getTermAccess().getAlternatives()); 
            // InternalFirstOrderLogic.g:719:3: ( rule__Term__Alternatives )
            // InternalFirstOrderLogic.g:719:4: rule__Term__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Term__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getTermAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTerm"


    // $ANTLR start "entryRuleVariableRef"
    // InternalFirstOrderLogic.g:728:1: entryRuleVariableRef : ruleVariableRef EOF ;
    public final void entryRuleVariableRef() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:729:1: ( ruleVariableRef EOF )
            // InternalFirstOrderLogic.g:730:1: ruleVariableRef EOF
            {
             before(grammarAccess.getVariableRefRule()); 
            pushFollow(FOLLOW_1);
            ruleVariableRef();

            state._fsp--;

             after(grammarAccess.getVariableRefRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleVariableRef"


    // $ANTLR start "ruleVariableRef"
    // InternalFirstOrderLogic.g:737:1: ruleVariableRef : ( ( rule__VariableRef__Group__0 ) ) ;
    public final void ruleVariableRef() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:741:2: ( ( ( rule__VariableRef__Group__0 ) ) )
            // InternalFirstOrderLogic.g:742:2: ( ( rule__VariableRef__Group__0 ) )
            {
            // InternalFirstOrderLogic.g:742:2: ( ( rule__VariableRef__Group__0 ) )
            // InternalFirstOrderLogic.g:743:3: ( rule__VariableRef__Group__0 )
            {
             before(grammarAccess.getVariableRefAccess().getGroup()); 
            // InternalFirstOrderLogic.g:744:3: ( rule__VariableRef__Group__0 )
            // InternalFirstOrderLogic.g:744:4: rule__VariableRef__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__VariableRef__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getVariableRefAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleVariableRef"


    // $ANTLR start "entryRuleGet"
    // InternalFirstOrderLogic.g:753:1: entryRuleGet : ruleGet EOF ;
    public final void entryRuleGet() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:754:1: ( ruleGet EOF )
            // InternalFirstOrderLogic.g:755:1: ruleGet EOF
            {
             before(grammarAccess.getGetRule()); 
            pushFollow(FOLLOW_1);
            ruleGet();

            state._fsp--;

             after(grammarAccess.getGetRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleGet"


    // $ANTLR start "ruleGet"
    // InternalFirstOrderLogic.g:762:1: ruleGet : ( ( rule__Get__Group__0 ) ) ;
    public final void ruleGet() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:766:2: ( ( ( rule__Get__Group__0 ) ) )
            // InternalFirstOrderLogic.g:767:2: ( ( rule__Get__Group__0 ) )
            {
            // InternalFirstOrderLogic.g:767:2: ( ( rule__Get__Group__0 ) )
            // InternalFirstOrderLogic.g:768:3: ( rule__Get__Group__0 )
            {
             before(grammarAccess.getGetAccess().getGroup()); 
            // InternalFirstOrderLogic.g:769:3: ( rule__Get__Group__0 )
            // InternalFirstOrderLogic.g:769:4: rule__Get__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Get__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getGetAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleGet"


    // $ANTLR start "entryRuleGetContainer"
    // InternalFirstOrderLogic.g:778:1: entryRuleGetContainer : ruleGetContainer EOF ;
    public final void entryRuleGetContainer() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:779:1: ( ruleGetContainer EOF )
            // InternalFirstOrderLogic.g:780:1: ruleGetContainer EOF
            {
             before(grammarAccess.getGetContainerRule()); 
            pushFollow(FOLLOW_1);
            ruleGetContainer();

            state._fsp--;

             after(grammarAccess.getGetContainerRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleGetContainer"


    // $ANTLR start "ruleGetContainer"
    // InternalFirstOrderLogic.g:787:1: ruleGetContainer : ( ( rule__GetContainer__Group__0 ) ) ;
    public final void ruleGetContainer() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:791:2: ( ( ( rule__GetContainer__Group__0 ) ) )
            // InternalFirstOrderLogic.g:792:2: ( ( rule__GetContainer__Group__0 ) )
            {
            // InternalFirstOrderLogic.g:792:2: ( ( rule__GetContainer__Group__0 ) )
            // InternalFirstOrderLogic.g:793:3: ( rule__GetContainer__Group__0 )
            {
             before(grammarAccess.getGetContainerAccess().getGroup()); 
            // InternalFirstOrderLogic.g:794:3: ( rule__GetContainer__Group__0 )
            // InternalFirstOrderLogic.g:794:4: rule__GetContainer__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__GetContainer__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getGetContainerAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleGetContainer"


    // $ANTLR start "entryRuleGetContainment"
    // InternalFirstOrderLogic.g:803:1: entryRuleGetContainment : ruleGetContainment EOF ;
    public final void entryRuleGetContainment() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:804:1: ( ruleGetContainment EOF )
            // InternalFirstOrderLogic.g:805:1: ruleGetContainment EOF
            {
             before(grammarAccess.getGetContainmentRule()); 
            pushFollow(FOLLOW_1);
            ruleGetContainment();

            state._fsp--;

             after(grammarAccess.getGetContainmentRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleGetContainment"


    // $ANTLR start "ruleGetContainment"
    // InternalFirstOrderLogic.g:812:1: ruleGetContainment : ( ( rule__GetContainment__Group__0 ) ) ;
    public final void ruleGetContainment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:816:2: ( ( ( rule__GetContainment__Group__0 ) ) )
            // InternalFirstOrderLogic.g:817:2: ( ( rule__GetContainment__Group__0 ) )
            {
            // InternalFirstOrderLogic.g:817:2: ( ( rule__GetContainment__Group__0 ) )
            // InternalFirstOrderLogic.g:818:3: ( rule__GetContainment__Group__0 )
            {
             before(grammarAccess.getGetContainmentAccess().getGroup()); 
            // InternalFirstOrderLogic.g:819:3: ( rule__GetContainment__Group__0 )
            // InternalFirstOrderLogic.g:819:4: rule__GetContainment__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__GetContainment__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getGetContainmentAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleGetContainment"


    // $ANTLR start "entryRuleGetClosure"
    // InternalFirstOrderLogic.g:828:1: entryRuleGetClosure : ruleGetClosure EOF ;
    public final void entryRuleGetClosure() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:829:1: ( ruleGetClosure EOF )
            // InternalFirstOrderLogic.g:830:1: ruleGetClosure EOF
            {
             before(grammarAccess.getGetClosureRule()); 
            pushFollow(FOLLOW_1);
            ruleGetClosure();

            state._fsp--;

             after(grammarAccess.getGetClosureRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleGetClosure"


    // $ANTLR start "ruleGetClosure"
    // InternalFirstOrderLogic.g:837:1: ruleGetClosure : ( ( rule__GetClosure__Group__0 ) ) ;
    public final void ruleGetClosure() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:841:2: ( ( ( rule__GetClosure__Group__0 ) ) )
            // InternalFirstOrderLogic.g:842:2: ( ( rule__GetClosure__Group__0 ) )
            {
            // InternalFirstOrderLogic.g:842:2: ( ( rule__GetClosure__Group__0 ) )
            // InternalFirstOrderLogic.g:843:3: ( rule__GetClosure__Group__0 )
            {
             before(grammarAccess.getGetClosureAccess().getGroup()); 
            // InternalFirstOrderLogic.g:844:3: ( rule__GetClosure__Group__0 )
            // InternalFirstOrderLogic.g:844:4: rule__GetClosure__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__GetClosure__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getGetClosureAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleGetClosure"


    // $ANTLR start "entryRuleConcatenate"
    // InternalFirstOrderLogic.g:853:1: entryRuleConcatenate : ruleConcatenate EOF ;
    public final void entryRuleConcatenate() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:854:1: ( ruleConcatenate EOF )
            // InternalFirstOrderLogic.g:855:1: ruleConcatenate EOF
            {
             before(grammarAccess.getConcatenateRule()); 
            pushFollow(FOLLOW_1);
            ruleConcatenate();

            state._fsp--;

             after(grammarAccess.getConcatenateRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleConcatenate"


    // $ANTLR start "ruleConcatenate"
    // InternalFirstOrderLogic.g:862:1: ruleConcatenate : ( ( rule__Concatenate__Group__0 ) ) ;
    public final void ruleConcatenate() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:866:2: ( ( ( rule__Concatenate__Group__0 ) ) )
            // InternalFirstOrderLogic.g:867:2: ( ( rule__Concatenate__Group__0 ) )
            {
            // InternalFirstOrderLogic.g:867:2: ( ( rule__Concatenate__Group__0 ) )
            // InternalFirstOrderLogic.g:868:3: ( rule__Concatenate__Group__0 )
            {
             before(grammarAccess.getConcatenateAccess().getGroup()); 
            // InternalFirstOrderLogic.g:869:3: ( rule__Concatenate__Group__0 )
            // InternalFirstOrderLogic.g:869:4: rule__Concatenate__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Concatenate__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getConcatenateAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleConcatenate"


    // $ANTLR start "entryRuleCapitalize"
    // InternalFirstOrderLogic.g:878:1: entryRuleCapitalize : ruleCapitalize EOF ;
    public final void entryRuleCapitalize() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:879:1: ( ruleCapitalize EOF )
            // InternalFirstOrderLogic.g:880:1: ruleCapitalize EOF
            {
             before(grammarAccess.getCapitalizeRule()); 
            pushFollow(FOLLOW_1);
            ruleCapitalize();

            state._fsp--;

             after(grammarAccess.getCapitalizeRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleCapitalize"


    // $ANTLR start "ruleCapitalize"
    // InternalFirstOrderLogic.g:887:1: ruleCapitalize : ( ( rule__Capitalize__Group__0 ) ) ;
    public final void ruleCapitalize() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:891:2: ( ( ( rule__Capitalize__Group__0 ) ) )
            // InternalFirstOrderLogic.g:892:2: ( ( rule__Capitalize__Group__0 ) )
            {
            // InternalFirstOrderLogic.g:892:2: ( ( rule__Capitalize__Group__0 ) )
            // InternalFirstOrderLogic.g:893:3: ( rule__Capitalize__Group__0 )
            {
             before(grammarAccess.getCapitalizeAccess().getGroup()); 
            // InternalFirstOrderLogic.g:894:3: ( rule__Capitalize__Group__0 )
            // InternalFirstOrderLogic.g:894:4: rule__Capitalize__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Capitalize__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getCapitalizeAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleCapitalize"


    // $ANTLR start "entryRuleConstant"
    // InternalFirstOrderLogic.g:903:1: entryRuleConstant : ruleConstant EOF ;
    public final void entryRuleConstant() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:904:1: ( ruleConstant EOF )
            // InternalFirstOrderLogic.g:905:1: ruleConstant EOF
            {
             before(grammarAccess.getConstantRule()); 
            pushFollow(FOLLOW_1);
            ruleConstant();

            state._fsp--;

             after(grammarAccess.getConstantRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleConstant"


    // $ANTLR start "ruleConstant"
    // InternalFirstOrderLogic.g:912:1: ruleConstant : ( ( rule__Constant__Alternatives ) ) ;
    public final void ruleConstant() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:916:2: ( ( ( rule__Constant__Alternatives ) ) )
            // InternalFirstOrderLogic.g:917:2: ( ( rule__Constant__Alternatives ) )
            {
            // InternalFirstOrderLogic.g:917:2: ( ( rule__Constant__Alternatives ) )
            // InternalFirstOrderLogic.g:918:3: ( rule__Constant__Alternatives )
            {
             before(grammarAccess.getConstantAccess().getAlternatives()); 
            // InternalFirstOrderLogic.g:919:3: ( rule__Constant__Alternatives )
            // InternalFirstOrderLogic.g:919:4: rule__Constant__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Constant__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getConstantAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleConstant"


    // $ANTLR start "rule__Predicate__Alternatives"
    // InternalFirstOrderLogic.g:927:1: rule__Predicate__Alternatives : ( ( ruleEquals ) | ( ruleInequality ) | ( ruleIsEmpty ) | ( ruleIsInstanceOf ) );
    public final void rule__Predicate__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:931:1: ( ( ruleEquals ) | ( ruleInequality ) | ( ruleIsEmpty ) | ( ruleIsInstanceOf ) )
            int alt1=4;
            switch ( input.LA(1) ) {
            case 26:
                {
                alt1=1;
                }
                break;
            case 28:
            case 29:
            case 30:
            case 31:
                {
                alt1=2;
                }
                break;
            case 32:
                {
                alt1=3;
                }
                break;
            case 33:
                {
                alt1=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // InternalFirstOrderLogic.g:932:2: ( ruleEquals )
                    {
                    // InternalFirstOrderLogic.g:932:2: ( ruleEquals )
                    // InternalFirstOrderLogic.g:933:3: ruleEquals
                    {
                     before(grammarAccess.getPredicateAccess().getEqualsParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleEquals();

                    state._fsp--;

                     after(grammarAccess.getPredicateAccess().getEqualsParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalFirstOrderLogic.g:938:2: ( ruleInequality )
                    {
                    // InternalFirstOrderLogic.g:938:2: ( ruleInequality )
                    // InternalFirstOrderLogic.g:939:3: ruleInequality
                    {
                     before(grammarAccess.getPredicateAccess().getInequalityParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleInequality();

                    state._fsp--;

                     after(grammarAccess.getPredicateAccess().getInequalityParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalFirstOrderLogic.g:944:2: ( ruleIsEmpty )
                    {
                    // InternalFirstOrderLogic.g:944:2: ( ruleIsEmpty )
                    // InternalFirstOrderLogic.g:945:3: ruleIsEmpty
                    {
                     before(grammarAccess.getPredicateAccess().getIsEmptyParserRuleCall_2()); 
                    pushFollow(FOLLOW_2);
                    ruleIsEmpty();

                    state._fsp--;

                     after(grammarAccess.getPredicateAccess().getIsEmptyParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalFirstOrderLogic.g:950:2: ( ruleIsInstanceOf )
                    {
                    // InternalFirstOrderLogic.g:950:2: ( ruleIsInstanceOf )
                    // InternalFirstOrderLogic.g:951:3: ruleIsInstanceOf
                    {
                     before(grammarAccess.getPredicateAccess().getIsInstanceOfParserRuleCall_3()); 
                    pushFollow(FOLLOW_2);
                    ruleIsInstanceOf();

                    state._fsp--;

                     after(grammarAccess.getPredicateAccess().getIsInstanceOfParserRuleCall_3()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Predicate__Alternatives"


    // $ANTLR start "rule__Inequality__Alternatives"
    // InternalFirstOrderLogic.g:960:1: rule__Inequality__Alternatives : ( ( ruleGreater ) | ( ruleGreaterEqual ) | ( ruleSmaller ) | ( ruleSmallerEqual ) );
    public final void rule__Inequality__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:964:1: ( ( ruleGreater ) | ( ruleGreaterEqual ) | ( ruleSmaller ) | ( ruleSmallerEqual ) )
            int alt2=4;
            switch ( input.LA(1) ) {
            case 28:
                {
                alt2=1;
                }
                break;
            case 29:
                {
                alt2=2;
                }
                break;
            case 30:
                {
                alt2=3;
                }
                break;
            case 31:
                {
                alt2=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // InternalFirstOrderLogic.g:965:2: ( ruleGreater )
                    {
                    // InternalFirstOrderLogic.g:965:2: ( ruleGreater )
                    // InternalFirstOrderLogic.g:966:3: ruleGreater
                    {
                     before(grammarAccess.getInequalityAccess().getGreaterParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleGreater();

                    state._fsp--;

                     after(grammarAccess.getInequalityAccess().getGreaterParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalFirstOrderLogic.g:971:2: ( ruleGreaterEqual )
                    {
                    // InternalFirstOrderLogic.g:971:2: ( ruleGreaterEqual )
                    // InternalFirstOrderLogic.g:972:3: ruleGreaterEqual
                    {
                     before(grammarAccess.getInequalityAccess().getGreaterEqualParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleGreaterEqual();

                    state._fsp--;

                     after(grammarAccess.getInequalityAccess().getGreaterEqualParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalFirstOrderLogic.g:977:2: ( ruleSmaller )
                    {
                    // InternalFirstOrderLogic.g:977:2: ( ruleSmaller )
                    // InternalFirstOrderLogic.g:978:3: ruleSmaller
                    {
                     before(grammarAccess.getInequalityAccess().getSmallerParserRuleCall_2()); 
                    pushFollow(FOLLOW_2);
                    ruleSmaller();

                    state._fsp--;

                     after(grammarAccess.getInequalityAccess().getSmallerParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalFirstOrderLogic.g:983:2: ( ruleSmallerEqual )
                    {
                    // InternalFirstOrderLogic.g:983:2: ( ruleSmallerEqual )
                    // InternalFirstOrderLogic.g:984:3: ruleSmallerEqual
                    {
                     before(grammarAccess.getInequalityAccess().getSmallerEqualParserRuleCall_3()); 
                    pushFollow(FOLLOW_2);
                    ruleSmallerEqual();

                    state._fsp--;

                     after(grammarAccess.getInequalityAccess().getSmallerEqualParserRuleCall_3()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Inequality__Alternatives"


    // $ANTLR start "rule__Quantifier__Alternatives"
    // InternalFirstOrderLogic.g:993:1: rule__Quantifier__Alternatives : ( ( ruleForAll ) | ( ruleExists ) );
    public final void rule__Quantifier__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:997:1: ( ( ruleForAll ) | ( ruleExists ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==34) ) {
                alt3=1;
            }
            else if ( (LA3_0==36) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // InternalFirstOrderLogic.g:998:2: ( ruleForAll )
                    {
                    // InternalFirstOrderLogic.g:998:2: ( ruleForAll )
                    // InternalFirstOrderLogic.g:999:3: ruleForAll
                    {
                     before(grammarAccess.getQuantifierAccess().getForAllParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleForAll();

                    state._fsp--;

                     after(grammarAccess.getQuantifierAccess().getForAllParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalFirstOrderLogic.g:1004:2: ( ruleExists )
                    {
                    // InternalFirstOrderLogic.g:1004:2: ( ruleExists )
                    // InternalFirstOrderLogic.g:1005:3: ruleExists
                    {
                     before(grammarAccess.getQuantifierAccess().getExistsParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleExists();

                    state._fsp--;

                     after(grammarAccess.getQuantifierAccess().getExistsParserRuleCall_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Quantifier__Alternatives"


    // $ANTLR start "rule__BooleanExpression__Alternatives"
    // InternalFirstOrderLogic.g:1014:1: rule__BooleanExpression__Alternatives : ( ( ( rule__BooleanExpression__Group_0__0 ) ) | ( ruleUnaryFormula ) | ( ruleQuantifier ) | ( rulePredicate ) | ( ruleBoolConstant ) );
    public final void rule__BooleanExpression__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1018:1: ( ( ( rule__BooleanExpression__Group_0__0 ) ) | ( ruleUnaryFormula ) | ( ruleQuantifier ) | ( rulePredicate ) | ( ruleBoolConstant ) )
            int alt4=5;
            switch ( input.LA(1) ) {
            case 37:
                {
                alt4=1;
                }
                break;
            case 24:
                {
                alt4=2;
                }
                break;
            case 34:
            case 36:
                {
                alt4=3;
                }
                break;
            case 26:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
                {
                alt4=4;
                }
                break;
            case 11:
            case 12:
                {
                alt4=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // InternalFirstOrderLogic.g:1019:2: ( ( rule__BooleanExpression__Group_0__0 ) )
                    {
                    // InternalFirstOrderLogic.g:1019:2: ( ( rule__BooleanExpression__Group_0__0 ) )
                    // InternalFirstOrderLogic.g:1020:3: ( rule__BooleanExpression__Group_0__0 )
                    {
                     before(grammarAccess.getBooleanExpressionAccess().getGroup_0()); 
                    // InternalFirstOrderLogic.g:1021:3: ( rule__BooleanExpression__Group_0__0 )
                    // InternalFirstOrderLogic.g:1021:4: rule__BooleanExpression__Group_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__BooleanExpression__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getBooleanExpressionAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalFirstOrderLogic.g:1025:2: ( ruleUnaryFormula )
                    {
                    // InternalFirstOrderLogic.g:1025:2: ( ruleUnaryFormula )
                    // InternalFirstOrderLogic.g:1026:3: ruleUnaryFormula
                    {
                     before(grammarAccess.getBooleanExpressionAccess().getUnaryFormulaParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleUnaryFormula();

                    state._fsp--;

                     after(grammarAccess.getBooleanExpressionAccess().getUnaryFormulaParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalFirstOrderLogic.g:1031:2: ( ruleQuantifier )
                    {
                    // InternalFirstOrderLogic.g:1031:2: ( ruleQuantifier )
                    // InternalFirstOrderLogic.g:1032:3: ruleQuantifier
                    {
                     before(grammarAccess.getBooleanExpressionAccess().getQuantifierParserRuleCall_2()); 
                    pushFollow(FOLLOW_2);
                    ruleQuantifier();

                    state._fsp--;

                     after(grammarAccess.getBooleanExpressionAccess().getQuantifierParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalFirstOrderLogic.g:1037:2: ( rulePredicate )
                    {
                    // InternalFirstOrderLogic.g:1037:2: ( rulePredicate )
                    // InternalFirstOrderLogic.g:1038:3: rulePredicate
                    {
                     before(grammarAccess.getBooleanExpressionAccess().getPredicateParserRuleCall_3()); 
                    pushFollow(FOLLOW_2);
                    rulePredicate();

                    state._fsp--;

                     after(grammarAccess.getBooleanExpressionAccess().getPredicateParserRuleCall_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalFirstOrderLogic.g:1043:2: ( ruleBoolConstant )
                    {
                    // InternalFirstOrderLogic.g:1043:2: ( ruleBoolConstant )
                    // InternalFirstOrderLogic.g:1044:3: ruleBoolConstant
                    {
                     before(grammarAccess.getBooleanExpressionAccess().getBoolConstantParserRuleCall_4()); 
                    pushFollow(FOLLOW_2);
                    ruleBoolConstant();

                    state._fsp--;

                     after(grammarAccess.getBooleanExpressionAccess().getBoolConstantParserRuleCall_4()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BooleanExpression__Alternatives"


    // $ANTLR start "rule__BoolConstant__ValueAlternatives_1_0"
    // InternalFirstOrderLogic.g:1053:1: rule__BoolConstant__ValueAlternatives_1_0 : ( ( 'true' ) | ( 'false' ) );
    public final void rule__BoolConstant__ValueAlternatives_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1057:1: ( ( 'true' ) | ( 'false' ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==11) ) {
                alt5=1;
            }
            else if ( (LA5_0==12) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // InternalFirstOrderLogic.g:1058:2: ( 'true' )
                    {
                    // InternalFirstOrderLogic.g:1058:2: ( 'true' )
                    // InternalFirstOrderLogic.g:1059:3: 'true'
                    {
                     before(grammarAccess.getBoolConstantAccess().getValueTrueKeyword_1_0_0()); 
                    match(input,11,FOLLOW_2); 
                     after(grammarAccess.getBoolConstantAccess().getValueTrueKeyword_1_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalFirstOrderLogic.g:1064:2: ( 'false' )
                    {
                    // InternalFirstOrderLogic.g:1064:2: ( 'false' )
                    // InternalFirstOrderLogic.g:1065:3: 'false'
                    {
                     before(grammarAccess.getBoolConstantAccess().getValueFalseKeyword_1_0_1()); 
                    match(input,12,FOLLOW_2); 
                     after(grammarAccess.getBoolConstantAccess().getValueFalseKeyword_1_0_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BoolConstant__ValueAlternatives_1_0"


    // $ANTLR start "rule__Term__Alternatives"
    // InternalFirstOrderLogic.g:1074:1: rule__Term__Alternatives : ( ( ruleConstant ) | ( ruleVariableRef ) | ( ruleGetContainment ) | ( ruleGetContainer ) | ( ruleGetClosure ) | ( ruleConcatenate ) | ( ruleCapitalize ) );
    public final void rule__Term__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1078:1: ( ( ruleConstant ) | ( ruleVariableRef ) | ( ruleGetContainment ) | ( ruleGetContainer ) | ( ruleGetClosure ) | ( ruleConcatenate ) | ( ruleCapitalize ) )
            int alt6=7;
            switch ( input.LA(1) ) {
            case RULE_STRING:
            case RULE_INT:
            case 11:
            case 12:
                {
                alt6=1;
                }
                break;
            case RULE_ID:
                {
                alt6=2;
                }
                break;
            case 41:
                {
                alt6=3;
                }
                break;
            case 40:
                {
                alt6=4;
                }
                break;
            case 42:
                {
                alt6=5;
                }
                break;
            case 43:
                {
                alt6=6;
                }
                break;
            case 44:
                {
                alt6=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // InternalFirstOrderLogic.g:1079:2: ( ruleConstant )
                    {
                    // InternalFirstOrderLogic.g:1079:2: ( ruleConstant )
                    // InternalFirstOrderLogic.g:1080:3: ruleConstant
                    {
                     before(grammarAccess.getTermAccess().getConstantParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleConstant();

                    state._fsp--;

                     after(grammarAccess.getTermAccess().getConstantParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalFirstOrderLogic.g:1085:2: ( ruleVariableRef )
                    {
                    // InternalFirstOrderLogic.g:1085:2: ( ruleVariableRef )
                    // InternalFirstOrderLogic.g:1086:3: ruleVariableRef
                    {
                     before(grammarAccess.getTermAccess().getVariableRefParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleVariableRef();

                    state._fsp--;

                     after(grammarAccess.getTermAccess().getVariableRefParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalFirstOrderLogic.g:1091:2: ( ruleGetContainment )
                    {
                    // InternalFirstOrderLogic.g:1091:2: ( ruleGetContainment )
                    // InternalFirstOrderLogic.g:1092:3: ruleGetContainment
                    {
                     before(grammarAccess.getTermAccess().getGetContainmentParserRuleCall_2()); 
                    pushFollow(FOLLOW_2);
                    ruleGetContainment();

                    state._fsp--;

                     after(grammarAccess.getTermAccess().getGetContainmentParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalFirstOrderLogic.g:1097:2: ( ruleGetContainer )
                    {
                    // InternalFirstOrderLogic.g:1097:2: ( ruleGetContainer )
                    // InternalFirstOrderLogic.g:1098:3: ruleGetContainer
                    {
                     before(grammarAccess.getTermAccess().getGetContainerParserRuleCall_3()); 
                    pushFollow(FOLLOW_2);
                    ruleGetContainer();

                    state._fsp--;

                     after(grammarAccess.getTermAccess().getGetContainerParserRuleCall_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalFirstOrderLogic.g:1103:2: ( ruleGetClosure )
                    {
                    // InternalFirstOrderLogic.g:1103:2: ( ruleGetClosure )
                    // InternalFirstOrderLogic.g:1104:3: ruleGetClosure
                    {
                     before(grammarAccess.getTermAccess().getGetClosureParserRuleCall_4()); 
                    pushFollow(FOLLOW_2);
                    ruleGetClosure();

                    state._fsp--;

                     after(grammarAccess.getTermAccess().getGetClosureParserRuleCall_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalFirstOrderLogic.g:1109:2: ( ruleConcatenate )
                    {
                    // InternalFirstOrderLogic.g:1109:2: ( ruleConcatenate )
                    // InternalFirstOrderLogic.g:1110:3: ruleConcatenate
                    {
                     before(grammarAccess.getTermAccess().getConcatenateParserRuleCall_5()); 
                    pushFollow(FOLLOW_2);
                    ruleConcatenate();

                    state._fsp--;

                     after(grammarAccess.getTermAccess().getConcatenateParserRuleCall_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalFirstOrderLogic.g:1115:2: ( ruleCapitalize )
                    {
                    // InternalFirstOrderLogic.g:1115:2: ( ruleCapitalize )
                    // InternalFirstOrderLogic.g:1116:3: ruleCapitalize
                    {
                     before(grammarAccess.getTermAccess().getCapitalizeParserRuleCall_6()); 
                    pushFollow(FOLLOW_2);
                    ruleCapitalize();

                    state._fsp--;

                     after(grammarAccess.getTermAccess().getCapitalizeParserRuleCall_6()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Term__Alternatives"


    // $ANTLR start "rule__Constant__Alternatives"
    // InternalFirstOrderLogic.g:1125:1: rule__Constant__Alternatives : ( ( ( rule__Constant__Group_0__0 ) ) | ( ( rule__Constant__Group_1__0 ) ) | ( ruleBoolConstant ) );
    public final void rule__Constant__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1129:1: ( ( ( rule__Constant__Group_0__0 ) ) | ( ( rule__Constant__Group_1__0 ) ) | ( ruleBoolConstant ) )
            int alt7=3;
            switch ( input.LA(1) ) {
            case RULE_INT:
                {
                alt7=1;
                }
                break;
            case RULE_STRING:
                {
                alt7=2;
                }
                break;
            case 11:
            case 12:
                {
                alt7=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // InternalFirstOrderLogic.g:1130:2: ( ( rule__Constant__Group_0__0 ) )
                    {
                    // InternalFirstOrderLogic.g:1130:2: ( ( rule__Constant__Group_0__0 ) )
                    // InternalFirstOrderLogic.g:1131:3: ( rule__Constant__Group_0__0 )
                    {
                     before(grammarAccess.getConstantAccess().getGroup_0()); 
                    // InternalFirstOrderLogic.g:1132:3: ( rule__Constant__Group_0__0 )
                    // InternalFirstOrderLogic.g:1132:4: rule__Constant__Group_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Constant__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getConstantAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalFirstOrderLogic.g:1136:2: ( ( rule__Constant__Group_1__0 ) )
                    {
                    // InternalFirstOrderLogic.g:1136:2: ( ( rule__Constant__Group_1__0 ) )
                    // InternalFirstOrderLogic.g:1137:3: ( rule__Constant__Group_1__0 )
                    {
                     before(grammarAccess.getConstantAccess().getGroup_1()); 
                    // InternalFirstOrderLogic.g:1138:3: ( rule__Constant__Group_1__0 )
                    // InternalFirstOrderLogic.g:1138:4: rule__Constant__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Constant__Group_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getConstantAccess().getGroup_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalFirstOrderLogic.g:1142:2: ( ruleBoolConstant )
                    {
                    // InternalFirstOrderLogic.g:1142:2: ( ruleBoolConstant )
                    // InternalFirstOrderLogic.g:1143:3: ruleBoolConstant
                    {
                     before(grammarAccess.getConstantAccess().getBoolConstantParserRuleCall_2()); 
                    pushFollow(FOLLOW_2);
                    ruleBoolConstant();

                    state._fsp--;

                     after(grammarAccess.getConstantAccess().getBoolConstantParserRuleCall_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constant__Alternatives"


    // $ANTLR start "rule__ConstraintLibrary__Group__0"
    // InternalFirstOrderLogic.g:1152:1: rule__ConstraintLibrary__Group__0 : rule__ConstraintLibrary__Group__0__Impl rule__ConstraintLibrary__Group__1 ;
    public final void rule__ConstraintLibrary__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1156:1: ( rule__ConstraintLibrary__Group__0__Impl rule__ConstraintLibrary__Group__1 )
            // InternalFirstOrderLogic.g:1157:2: rule__ConstraintLibrary__Group__0__Impl rule__ConstraintLibrary__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__ConstraintLibrary__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ConstraintLibrary__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintLibrary__Group__0"


    // $ANTLR start "rule__ConstraintLibrary__Group__0__Impl"
    // InternalFirstOrderLogic.g:1164:1: rule__ConstraintLibrary__Group__0__Impl : ( 'domain' ) ;
    public final void rule__ConstraintLibrary__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1168:1: ( ( 'domain' ) )
            // InternalFirstOrderLogic.g:1169:1: ( 'domain' )
            {
            // InternalFirstOrderLogic.g:1169:1: ( 'domain' )
            // InternalFirstOrderLogic.g:1170:2: 'domain'
            {
             before(grammarAccess.getConstraintLibraryAccess().getDomainKeyword_0()); 
            match(input,13,FOLLOW_2); 
             after(grammarAccess.getConstraintLibraryAccess().getDomainKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintLibrary__Group__0__Impl"


    // $ANTLR start "rule__ConstraintLibrary__Group__1"
    // InternalFirstOrderLogic.g:1179:1: rule__ConstraintLibrary__Group__1 : rule__ConstraintLibrary__Group__1__Impl rule__ConstraintLibrary__Group__2 ;
    public final void rule__ConstraintLibrary__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1183:1: ( rule__ConstraintLibrary__Group__1__Impl rule__ConstraintLibrary__Group__2 )
            // InternalFirstOrderLogic.g:1184:2: rule__ConstraintLibrary__Group__1__Impl rule__ConstraintLibrary__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__ConstraintLibrary__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ConstraintLibrary__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintLibrary__Group__1"


    // $ANTLR start "rule__ConstraintLibrary__Group__1__Impl"
    // InternalFirstOrderLogic.g:1191:1: rule__ConstraintLibrary__Group__1__Impl : ( ( rule__ConstraintLibrary__DomainAssignment_1 ) ) ;
    public final void rule__ConstraintLibrary__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1195:1: ( ( ( rule__ConstraintLibrary__DomainAssignment_1 ) ) )
            // InternalFirstOrderLogic.g:1196:1: ( ( rule__ConstraintLibrary__DomainAssignment_1 ) )
            {
            // InternalFirstOrderLogic.g:1196:1: ( ( rule__ConstraintLibrary__DomainAssignment_1 ) )
            // InternalFirstOrderLogic.g:1197:2: ( rule__ConstraintLibrary__DomainAssignment_1 )
            {
             before(grammarAccess.getConstraintLibraryAccess().getDomainAssignment_1()); 
            // InternalFirstOrderLogic.g:1198:2: ( rule__ConstraintLibrary__DomainAssignment_1 )
            // InternalFirstOrderLogic.g:1198:3: rule__ConstraintLibrary__DomainAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__ConstraintLibrary__DomainAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getConstraintLibraryAccess().getDomainAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintLibrary__Group__1__Impl"


    // $ANTLR start "rule__ConstraintLibrary__Group__2"
    // InternalFirstOrderLogic.g:1206:1: rule__ConstraintLibrary__Group__2 : rule__ConstraintLibrary__Group__2__Impl rule__ConstraintLibrary__Group__3 ;
    public final void rule__ConstraintLibrary__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1210:1: ( rule__ConstraintLibrary__Group__2__Impl rule__ConstraintLibrary__Group__3 )
            // InternalFirstOrderLogic.g:1211:2: rule__ConstraintLibrary__Group__2__Impl rule__ConstraintLibrary__Group__3
            {
            pushFollow(FOLLOW_3);
            rule__ConstraintLibrary__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ConstraintLibrary__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintLibrary__Group__2"


    // $ANTLR start "rule__ConstraintLibrary__Group__2__Impl"
    // InternalFirstOrderLogic.g:1218:1: rule__ConstraintLibrary__Group__2__Impl : ( 'import' ) ;
    public final void rule__ConstraintLibrary__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1222:1: ( ( 'import' ) )
            // InternalFirstOrderLogic.g:1223:1: ( 'import' )
            {
            // InternalFirstOrderLogic.g:1223:1: ( 'import' )
            // InternalFirstOrderLogic.g:1224:2: 'import'
            {
             before(grammarAccess.getConstraintLibraryAccess().getImportKeyword_2()); 
            match(input,14,FOLLOW_2); 
             after(grammarAccess.getConstraintLibraryAccess().getImportKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintLibrary__Group__2__Impl"


    // $ANTLR start "rule__ConstraintLibrary__Group__3"
    // InternalFirstOrderLogic.g:1233:1: rule__ConstraintLibrary__Group__3 : rule__ConstraintLibrary__Group__3__Impl rule__ConstraintLibrary__Group__4 ;
    public final void rule__ConstraintLibrary__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1237:1: ( rule__ConstraintLibrary__Group__3__Impl rule__ConstraintLibrary__Group__4 )
            // InternalFirstOrderLogic.g:1238:2: rule__ConstraintLibrary__Group__3__Impl rule__ConstraintLibrary__Group__4
            {
            pushFollow(FOLLOW_5);
            rule__ConstraintLibrary__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ConstraintLibrary__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintLibrary__Group__3"


    // $ANTLR start "rule__ConstraintLibrary__Group__3__Impl"
    // InternalFirstOrderLogic.g:1245:1: rule__ConstraintLibrary__Group__3__Impl : ( ( rule__ConstraintLibrary__PackageImportAssignment_3 ) ) ;
    public final void rule__ConstraintLibrary__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1249:1: ( ( ( rule__ConstraintLibrary__PackageImportAssignment_3 ) ) )
            // InternalFirstOrderLogic.g:1250:1: ( ( rule__ConstraintLibrary__PackageImportAssignment_3 ) )
            {
            // InternalFirstOrderLogic.g:1250:1: ( ( rule__ConstraintLibrary__PackageImportAssignment_3 ) )
            // InternalFirstOrderLogic.g:1251:2: ( rule__ConstraintLibrary__PackageImportAssignment_3 )
            {
             before(grammarAccess.getConstraintLibraryAccess().getPackageImportAssignment_3()); 
            // InternalFirstOrderLogic.g:1252:2: ( rule__ConstraintLibrary__PackageImportAssignment_3 )
            // InternalFirstOrderLogic.g:1252:3: rule__ConstraintLibrary__PackageImportAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__ConstraintLibrary__PackageImportAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getConstraintLibraryAccess().getPackageImportAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintLibrary__Group__3__Impl"


    // $ANTLR start "rule__ConstraintLibrary__Group__4"
    // InternalFirstOrderLogic.g:1260:1: rule__ConstraintLibrary__Group__4 : rule__ConstraintLibrary__Group__4__Impl ;
    public final void rule__ConstraintLibrary__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1264:1: ( rule__ConstraintLibrary__Group__4__Impl )
            // InternalFirstOrderLogic.g:1265:2: rule__ConstraintLibrary__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ConstraintLibrary__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintLibrary__Group__4"


    // $ANTLR start "rule__ConstraintLibrary__Group__4__Impl"
    // InternalFirstOrderLogic.g:1271:1: rule__ConstraintLibrary__Group__4__Impl : ( ( rule__ConstraintLibrary__ConstraintsAssignment_4 )* ) ;
    public final void rule__ConstraintLibrary__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1275:1: ( ( ( rule__ConstraintLibrary__ConstraintsAssignment_4 )* ) )
            // InternalFirstOrderLogic.g:1276:1: ( ( rule__ConstraintLibrary__ConstraintsAssignment_4 )* )
            {
            // InternalFirstOrderLogic.g:1276:1: ( ( rule__ConstraintLibrary__ConstraintsAssignment_4 )* )
            // InternalFirstOrderLogic.g:1277:2: ( rule__ConstraintLibrary__ConstraintsAssignment_4 )*
            {
             before(grammarAccess.getConstraintLibraryAccess().getConstraintsAssignment_4()); 
            // InternalFirstOrderLogic.g:1278:2: ( rule__ConstraintLibrary__ConstraintsAssignment_4 )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==15) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalFirstOrderLogic.g:1278:3: rule__ConstraintLibrary__ConstraintsAssignment_4
            	    {
            	    pushFollow(FOLLOW_6);
            	    rule__ConstraintLibrary__ConstraintsAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

             after(grammarAccess.getConstraintLibraryAccess().getConstraintsAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintLibrary__Group__4__Impl"


    // $ANTLR start "rule__Constraint__Group__0"
    // InternalFirstOrderLogic.g:1287:1: rule__Constraint__Group__0 : rule__Constraint__Group__0__Impl rule__Constraint__Group__1 ;
    public final void rule__Constraint__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1291:1: ( rule__Constraint__Group__0__Impl rule__Constraint__Group__1 )
            // InternalFirstOrderLogic.g:1292:2: rule__Constraint__Group__0__Impl rule__Constraint__Group__1
            {
            pushFollow(FOLLOW_7);
            rule__Constraint__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Constraint__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraint__Group__0"


    // $ANTLR start "rule__Constraint__Group__0__Impl"
    // InternalFirstOrderLogic.g:1299:1: rule__Constraint__Group__0__Impl : ( 'constraint' ) ;
    public final void rule__Constraint__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1303:1: ( ( 'constraint' ) )
            // InternalFirstOrderLogic.g:1304:1: ( 'constraint' )
            {
            // InternalFirstOrderLogic.g:1304:1: ( 'constraint' )
            // InternalFirstOrderLogic.g:1305:2: 'constraint'
            {
             before(grammarAccess.getConstraintAccess().getConstraintKeyword_0()); 
            match(input,15,FOLLOW_2); 
             after(grammarAccess.getConstraintAccess().getConstraintKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraint__Group__0__Impl"


    // $ANTLR start "rule__Constraint__Group__1"
    // InternalFirstOrderLogic.g:1314:1: rule__Constraint__Group__1 : rule__Constraint__Group__1__Impl rule__Constraint__Group__2 ;
    public final void rule__Constraint__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1318:1: ( rule__Constraint__Group__1__Impl rule__Constraint__Group__2 )
            // InternalFirstOrderLogic.g:1319:2: rule__Constraint__Group__1__Impl rule__Constraint__Group__2
            {
            pushFollow(FOLLOW_8);
            rule__Constraint__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Constraint__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraint__Group__1"


    // $ANTLR start "rule__Constraint__Group__1__Impl"
    // InternalFirstOrderLogic.g:1326:1: rule__Constraint__Group__1__Impl : ( ( rule__Constraint__NameAssignment_1 ) ) ;
    public final void rule__Constraint__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1330:1: ( ( ( rule__Constraint__NameAssignment_1 ) ) )
            // InternalFirstOrderLogic.g:1331:1: ( ( rule__Constraint__NameAssignment_1 ) )
            {
            // InternalFirstOrderLogic.g:1331:1: ( ( rule__Constraint__NameAssignment_1 ) )
            // InternalFirstOrderLogic.g:1332:2: ( rule__Constraint__NameAssignment_1 )
            {
             before(grammarAccess.getConstraintAccess().getNameAssignment_1()); 
            // InternalFirstOrderLogic.g:1333:2: ( rule__Constraint__NameAssignment_1 )
            // InternalFirstOrderLogic.g:1333:3: rule__Constraint__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Constraint__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getConstraintAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraint__Group__1__Impl"


    // $ANTLR start "rule__Constraint__Group__2"
    // InternalFirstOrderLogic.g:1341:1: rule__Constraint__Group__2 : rule__Constraint__Group__2__Impl rule__Constraint__Group__3 ;
    public final void rule__Constraint__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1345:1: ( rule__Constraint__Group__2__Impl rule__Constraint__Group__3 )
            // InternalFirstOrderLogic.g:1346:2: rule__Constraint__Group__2__Impl rule__Constraint__Group__3
            {
            pushFollow(FOLLOW_3);
            rule__Constraint__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Constraint__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraint__Group__2"


    // $ANTLR start "rule__Constraint__Group__2__Impl"
    // InternalFirstOrderLogic.g:1353:1: rule__Constraint__Group__2__Impl : ( 'message' ) ;
    public final void rule__Constraint__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1357:1: ( ( 'message' ) )
            // InternalFirstOrderLogic.g:1358:1: ( 'message' )
            {
            // InternalFirstOrderLogic.g:1358:1: ( 'message' )
            // InternalFirstOrderLogic.g:1359:2: 'message'
            {
             before(grammarAccess.getConstraintAccess().getMessageKeyword_2()); 
            match(input,16,FOLLOW_2); 
             after(grammarAccess.getConstraintAccess().getMessageKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraint__Group__2__Impl"


    // $ANTLR start "rule__Constraint__Group__3"
    // InternalFirstOrderLogic.g:1368:1: rule__Constraint__Group__3 : rule__Constraint__Group__3__Impl rule__Constraint__Group__4 ;
    public final void rule__Constraint__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1372:1: ( rule__Constraint__Group__3__Impl rule__Constraint__Group__4 )
            // InternalFirstOrderLogic.g:1373:2: rule__Constraint__Group__3__Impl rule__Constraint__Group__4
            {
            pushFollow(FOLLOW_9);
            rule__Constraint__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Constraint__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraint__Group__3"


    // $ANTLR start "rule__Constraint__Group__3__Impl"
    // InternalFirstOrderLogic.g:1380:1: rule__Constraint__Group__3__Impl : ( ( rule__Constraint__MessageAssignment_3 ) ) ;
    public final void rule__Constraint__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1384:1: ( ( ( rule__Constraint__MessageAssignment_3 ) ) )
            // InternalFirstOrderLogic.g:1385:1: ( ( rule__Constraint__MessageAssignment_3 ) )
            {
            // InternalFirstOrderLogic.g:1385:1: ( ( rule__Constraint__MessageAssignment_3 ) )
            // InternalFirstOrderLogic.g:1386:2: ( rule__Constraint__MessageAssignment_3 )
            {
             before(grammarAccess.getConstraintAccess().getMessageAssignment_3()); 
            // InternalFirstOrderLogic.g:1387:2: ( rule__Constraint__MessageAssignment_3 )
            // InternalFirstOrderLogic.g:1387:3: rule__Constraint__MessageAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__Constraint__MessageAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getConstraintAccess().getMessageAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraint__Group__3__Impl"


    // $ANTLR start "rule__Constraint__Group__4"
    // InternalFirstOrderLogic.g:1395:1: rule__Constraint__Group__4 : rule__Constraint__Group__4__Impl rule__Constraint__Group__5 ;
    public final void rule__Constraint__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1399:1: ( rule__Constraint__Group__4__Impl rule__Constraint__Group__5 )
            // InternalFirstOrderLogic.g:1400:2: rule__Constraint__Group__4__Impl rule__Constraint__Group__5
            {
            pushFollow(FOLLOW_7);
            rule__Constraint__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Constraint__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraint__Group__4"


    // $ANTLR start "rule__Constraint__Group__4__Impl"
    // InternalFirstOrderLogic.g:1407:1: rule__Constraint__Group__4__Impl : ( 'context' ) ;
    public final void rule__Constraint__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1411:1: ( ( 'context' ) )
            // InternalFirstOrderLogic.g:1412:1: ( 'context' )
            {
            // InternalFirstOrderLogic.g:1412:1: ( 'context' )
            // InternalFirstOrderLogic.g:1413:2: 'context'
            {
             before(grammarAccess.getConstraintAccess().getContextKeyword_4()); 
            match(input,17,FOLLOW_2); 
             after(grammarAccess.getConstraintAccess().getContextKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraint__Group__4__Impl"


    // $ANTLR start "rule__Constraint__Group__5"
    // InternalFirstOrderLogic.g:1422:1: rule__Constraint__Group__5 : rule__Constraint__Group__5__Impl rule__Constraint__Group__6 ;
    public final void rule__Constraint__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1426:1: ( rule__Constraint__Group__5__Impl rule__Constraint__Group__6 )
            // InternalFirstOrderLogic.g:1427:2: rule__Constraint__Group__5__Impl rule__Constraint__Group__6
            {
            pushFollow(FOLLOW_10);
            rule__Constraint__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Constraint__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraint__Group__5"


    // $ANTLR start "rule__Constraint__Group__5__Impl"
    // InternalFirstOrderLogic.g:1434:1: rule__Constraint__Group__5__Impl : ( ( rule__Constraint__VariableAssignment_5 ) ) ;
    public final void rule__Constraint__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1438:1: ( ( ( rule__Constraint__VariableAssignment_5 ) ) )
            // InternalFirstOrderLogic.g:1439:1: ( ( rule__Constraint__VariableAssignment_5 ) )
            {
            // InternalFirstOrderLogic.g:1439:1: ( ( rule__Constraint__VariableAssignment_5 ) )
            // InternalFirstOrderLogic.g:1440:2: ( rule__Constraint__VariableAssignment_5 )
            {
             before(grammarAccess.getConstraintAccess().getVariableAssignment_5()); 
            // InternalFirstOrderLogic.g:1441:2: ( rule__Constraint__VariableAssignment_5 )
            // InternalFirstOrderLogic.g:1441:3: rule__Constraint__VariableAssignment_5
            {
            pushFollow(FOLLOW_2);
            rule__Constraint__VariableAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getConstraintAccess().getVariableAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraint__Group__5__Impl"


    // $ANTLR start "rule__Constraint__Group__6"
    // InternalFirstOrderLogic.g:1449:1: rule__Constraint__Group__6 : rule__Constraint__Group__6__Impl rule__Constraint__Group__7 ;
    public final void rule__Constraint__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1453:1: ( rule__Constraint__Group__6__Impl rule__Constraint__Group__7 )
            // InternalFirstOrderLogic.g:1454:2: rule__Constraint__Group__6__Impl rule__Constraint__Group__7
            {
            pushFollow(FOLLOW_11);
            rule__Constraint__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Constraint__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraint__Group__6"


    // $ANTLR start "rule__Constraint__Group__6__Impl"
    // InternalFirstOrderLogic.g:1461:1: rule__Constraint__Group__6__Impl : ( ':' ) ;
    public final void rule__Constraint__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1465:1: ( ( ':' ) )
            // InternalFirstOrderLogic.g:1466:1: ( ':' )
            {
            // InternalFirstOrderLogic.g:1466:1: ( ':' )
            // InternalFirstOrderLogic.g:1467:2: ':'
            {
             before(grammarAccess.getConstraintAccess().getColonKeyword_6()); 
            match(input,18,FOLLOW_2); 
             after(grammarAccess.getConstraintAccess().getColonKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraint__Group__6__Impl"


    // $ANTLR start "rule__Constraint__Group__7"
    // InternalFirstOrderLogic.g:1476:1: rule__Constraint__Group__7 : rule__Constraint__Group__7__Impl ;
    public final void rule__Constraint__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1480:1: ( rule__Constraint__Group__7__Impl )
            // InternalFirstOrderLogic.g:1481:2: rule__Constraint__Group__7__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Constraint__Group__7__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraint__Group__7"


    // $ANTLR start "rule__Constraint__Group__7__Impl"
    // InternalFirstOrderLogic.g:1487:1: rule__Constraint__Group__7__Impl : ( ( rule__Constraint__FormulaAssignment_7 ) ) ;
    public final void rule__Constraint__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1491:1: ( ( ( rule__Constraint__FormulaAssignment_7 ) ) )
            // InternalFirstOrderLogic.g:1492:1: ( ( rule__Constraint__FormulaAssignment_7 ) )
            {
            // InternalFirstOrderLogic.g:1492:1: ( ( rule__Constraint__FormulaAssignment_7 ) )
            // InternalFirstOrderLogic.g:1493:2: ( rule__Constraint__FormulaAssignment_7 )
            {
             before(grammarAccess.getConstraintAccess().getFormulaAssignment_7()); 
            // InternalFirstOrderLogic.g:1494:2: ( rule__Constraint__FormulaAssignment_7 )
            // InternalFirstOrderLogic.g:1494:3: rule__Constraint__FormulaAssignment_7
            {
            pushFollow(FOLLOW_2);
            rule__Constraint__FormulaAssignment_7();

            state._fsp--;


            }

             after(grammarAccess.getConstraintAccess().getFormulaAssignment_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraint__Group__7__Impl"


    // $ANTLR start "rule__Variable__Group__0"
    // InternalFirstOrderLogic.g:1503:1: rule__Variable__Group__0 : rule__Variable__Group__0__Impl rule__Variable__Group__1 ;
    public final void rule__Variable__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1507:1: ( rule__Variable__Group__0__Impl rule__Variable__Group__1 )
            // InternalFirstOrderLogic.g:1508:2: rule__Variable__Group__0__Impl rule__Variable__Group__1
            {
            pushFollow(FOLLOW_7);
            rule__Variable__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Variable__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Variable__Group__0"


    // $ANTLR start "rule__Variable__Group__0__Impl"
    // InternalFirstOrderLogic.g:1515:1: rule__Variable__Group__0__Impl : ( ( rule__Variable__TypeAssignment_0 ) ) ;
    public final void rule__Variable__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1519:1: ( ( ( rule__Variable__TypeAssignment_0 ) ) )
            // InternalFirstOrderLogic.g:1520:1: ( ( rule__Variable__TypeAssignment_0 ) )
            {
            // InternalFirstOrderLogic.g:1520:1: ( ( rule__Variable__TypeAssignment_0 ) )
            // InternalFirstOrderLogic.g:1521:2: ( rule__Variable__TypeAssignment_0 )
            {
             before(grammarAccess.getVariableAccess().getTypeAssignment_0()); 
            // InternalFirstOrderLogic.g:1522:2: ( rule__Variable__TypeAssignment_0 )
            // InternalFirstOrderLogic.g:1522:3: rule__Variable__TypeAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__Variable__TypeAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getVariableAccess().getTypeAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Variable__Group__0__Impl"


    // $ANTLR start "rule__Variable__Group__1"
    // InternalFirstOrderLogic.g:1530:1: rule__Variable__Group__1 : rule__Variable__Group__1__Impl ;
    public final void rule__Variable__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1534:1: ( rule__Variable__Group__1__Impl )
            // InternalFirstOrderLogic.g:1535:2: rule__Variable__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Variable__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Variable__Group__1"


    // $ANTLR start "rule__Variable__Group__1__Impl"
    // InternalFirstOrderLogic.g:1541:1: rule__Variable__Group__1__Impl : ( ( rule__Variable__NameAssignment_1 ) ) ;
    public final void rule__Variable__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1545:1: ( ( ( rule__Variable__NameAssignment_1 ) ) )
            // InternalFirstOrderLogic.g:1546:1: ( ( rule__Variable__NameAssignment_1 ) )
            {
            // InternalFirstOrderLogic.g:1546:1: ( ( rule__Variable__NameAssignment_1 ) )
            // InternalFirstOrderLogic.g:1547:2: ( rule__Variable__NameAssignment_1 )
            {
             before(grammarAccess.getVariableAccess().getNameAssignment_1()); 
            // InternalFirstOrderLogic.g:1548:2: ( rule__Variable__NameAssignment_1 )
            // InternalFirstOrderLogic.g:1548:3: rule__Variable__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Variable__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getVariableAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Variable__Group__1__Impl"


    // $ANTLR start "rule__Iff__Group__0"
    // InternalFirstOrderLogic.g:1557:1: rule__Iff__Group__0 : rule__Iff__Group__0__Impl rule__Iff__Group__1 ;
    public final void rule__Iff__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1561:1: ( rule__Iff__Group__0__Impl rule__Iff__Group__1 )
            // InternalFirstOrderLogic.g:1562:2: rule__Iff__Group__0__Impl rule__Iff__Group__1
            {
            pushFollow(FOLLOW_12);
            rule__Iff__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Iff__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Iff__Group__0"


    // $ANTLR start "rule__Iff__Group__0__Impl"
    // InternalFirstOrderLogic.g:1569:1: rule__Iff__Group__0__Impl : ( ruleIf ) ;
    public final void rule__Iff__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1573:1: ( ( ruleIf ) )
            // InternalFirstOrderLogic.g:1574:1: ( ruleIf )
            {
            // InternalFirstOrderLogic.g:1574:1: ( ruleIf )
            // InternalFirstOrderLogic.g:1575:2: ruleIf
            {
             before(grammarAccess.getIffAccess().getIfParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleIf();

            state._fsp--;

             after(grammarAccess.getIffAccess().getIfParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Iff__Group__0__Impl"


    // $ANTLR start "rule__Iff__Group__1"
    // InternalFirstOrderLogic.g:1584:1: rule__Iff__Group__1 : rule__Iff__Group__1__Impl ;
    public final void rule__Iff__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1588:1: ( rule__Iff__Group__1__Impl )
            // InternalFirstOrderLogic.g:1589:2: rule__Iff__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Iff__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Iff__Group__1"


    // $ANTLR start "rule__Iff__Group__1__Impl"
    // InternalFirstOrderLogic.g:1595:1: rule__Iff__Group__1__Impl : ( ( rule__Iff__Group_1__0 )* ) ;
    public final void rule__Iff__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1599:1: ( ( ( rule__Iff__Group_1__0 )* ) )
            // InternalFirstOrderLogic.g:1600:1: ( ( rule__Iff__Group_1__0 )* )
            {
            // InternalFirstOrderLogic.g:1600:1: ( ( rule__Iff__Group_1__0 )* )
            // InternalFirstOrderLogic.g:1601:2: ( rule__Iff__Group_1__0 )*
            {
             before(grammarAccess.getIffAccess().getGroup_1()); 
            // InternalFirstOrderLogic.g:1602:2: ( rule__Iff__Group_1__0 )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==19) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalFirstOrderLogic.g:1602:3: rule__Iff__Group_1__0
            	    {
            	    pushFollow(FOLLOW_13);
            	    rule__Iff__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

             after(grammarAccess.getIffAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Iff__Group__1__Impl"


    // $ANTLR start "rule__Iff__Group_1__0"
    // InternalFirstOrderLogic.g:1611:1: rule__Iff__Group_1__0 : rule__Iff__Group_1__0__Impl rule__Iff__Group_1__1 ;
    public final void rule__Iff__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1615:1: ( rule__Iff__Group_1__0__Impl rule__Iff__Group_1__1 )
            // InternalFirstOrderLogic.g:1616:2: rule__Iff__Group_1__0__Impl rule__Iff__Group_1__1
            {
            pushFollow(FOLLOW_12);
            rule__Iff__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Iff__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Iff__Group_1__0"


    // $ANTLR start "rule__Iff__Group_1__0__Impl"
    // InternalFirstOrderLogic.g:1623:1: rule__Iff__Group_1__0__Impl : ( () ) ;
    public final void rule__Iff__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1627:1: ( ( () ) )
            // InternalFirstOrderLogic.g:1628:1: ( () )
            {
            // InternalFirstOrderLogic.g:1628:1: ( () )
            // InternalFirstOrderLogic.g:1629:2: ()
            {
             before(grammarAccess.getIffAccess().getIffLeftAction_1_0()); 
            // InternalFirstOrderLogic.g:1630:2: ()
            // InternalFirstOrderLogic.g:1630:3: 
            {
            }

             after(grammarAccess.getIffAccess().getIffLeftAction_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Iff__Group_1__0__Impl"


    // $ANTLR start "rule__Iff__Group_1__1"
    // InternalFirstOrderLogic.g:1638:1: rule__Iff__Group_1__1 : rule__Iff__Group_1__1__Impl rule__Iff__Group_1__2 ;
    public final void rule__Iff__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1642:1: ( rule__Iff__Group_1__1__Impl rule__Iff__Group_1__2 )
            // InternalFirstOrderLogic.g:1643:2: rule__Iff__Group_1__1__Impl rule__Iff__Group_1__2
            {
            pushFollow(FOLLOW_11);
            rule__Iff__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Iff__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Iff__Group_1__1"


    // $ANTLR start "rule__Iff__Group_1__1__Impl"
    // InternalFirstOrderLogic.g:1650:1: rule__Iff__Group_1__1__Impl : ( '=' ) ;
    public final void rule__Iff__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1654:1: ( ( '=' ) )
            // InternalFirstOrderLogic.g:1655:1: ( '=' )
            {
            // InternalFirstOrderLogic.g:1655:1: ( '=' )
            // InternalFirstOrderLogic.g:1656:2: '='
            {
             before(grammarAccess.getIffAccess().getEqualsSignKeyword_1_1()); 
            match(input,19,FOLLOW_2); 
             after(grammarAccess.getIffAccess().getEqualsSignKeyword_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Iff__Group_1__1__Impl"


    // $ANTLR start "rule__Iff__Group_1__2"
    // InternalFirstOrderLogic.g:1665:1: rule__Iff__Group_1__2 : rule__Iff__Group_1__2__Impl ;
    public final void rule__Iff__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1669:1: ( rule__Iff__Group_1__2__Impl )
            // InternalFirstOrderLogic.g:1670:2: rule__Iff__Group_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Iff__Group_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Iff__Group_1__2"


    // $ANTLR start "rule__Iff__Group_1__2__Impl"
    // InternalFirstOrderLogic.g:1676:1: rule__Iff__Group_1__2__Impl : ( ( rule__Iff__RightAssignment_1_2 ) ) ;
    public final void rule__Iff__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1680:1: ( ( ( rule__Iff__RightAssignment_1_2 ) ) )
            // InternalFirstOrderLogic.g:1681:1: ( ( rule__Iff__RightAssignment_1_2 ) )
            {
            // InternalFirstOrderLogic.g:1681:1: ( ( rule__Iff__RightAssignment_1_2 ) )
            // InternalFirstOrderLogic.g:1682:2: ( rule__Iff__RightAssignment_1_2 )
            {
             before(grammarAccess.getIffAccess().getRightAssignment_1_2()); 
            // InternalFirstOrderLogic.g:1683:2: ( rule__Iff__RightAssignment_1_2 )
            // InternalFirstOrderLogic.g:1683:3: rule__Iff__RightAssignment_1_2
            {
            pushFollow(FOLLOW_2);
            rule__Iff__RightAssignment_1_2();

            state._fsp--;


            }

             after(grammarAccess.getIffAccess().getRightAssignment_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Iff__Group_1__2__Impl"


    // $ANTLR start "rule__If__Group__0"
    // InternalFirstOrderLogic.g:1692:1: rule__If__Group__0 : rule__If__Group__0__Impl rule__If__Group__1 ;
    public final void rule__If__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1696:1: ( rule__If__Group__0__Impl rule__If__Group__1 )
            // InternalFirstOrderLogic.g:1697:2: rule__If__Group__0__Impl rule__If__Group__1
            {
            pushFollow(FOLLOW_14);
            rule__If__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__If__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__If__Group__0"


    // $ANTLR start "rule__If__Group__0__Impl"
    // InternalFirstOrderLogic.g:1704:1: rule__If__Group__0__Impl : ( ruleXor ) ;
    public final void rule__If__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1708:1: ( ( ruleXor ) )
            // InternalFirstOrderLogic.g:1709:1: ( ruleXor )
            {
            // InternalFirstOrderLogic.g:1709:1: ( ruleXor )
            // InternalFirstOrderLogic.g:1710:2: ruleXor
            {
             before(grammarAccess.getIfAccess().getXorParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleXor();

            state._fsp--;

             after(grammarAccess.getIfAccess().getXorParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__If__Group__0__Impl"


    // $ANTLR start "rule__If__Group__1"
    // InternalFirstOrderLogic.g:1719:1: rule__If__Group__1 : rule__If__Group__1__Impl ;
    public final void rule__If__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1723:1: ( rule__If__Group__1__Impl )
            // InternalFirstOrderLogic.g:1724:2: rule__If__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__If__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__If__Group__1"


    // $ANTLR start "rule__If__Group__1__Impl"
    // InternalFirstOrderLogic.g:1730:1: rule__If__Group__1__Impl : ( ( rule__If__Group_1__0 )* ) ;
    public final void rule__If__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1734:1: ( ( ( rule__If__Group_1__0 )* ) )
            // InternalFirstOrderLogic.g:1735:1: ( ( rule__If__Group_1__0 )* )
            {
            // InternalFirstOrderLogic.g:1735:1: ( ( rule__If__Group_1__0 )* )
            // InternalFirstOrderLogic.g:1736:2: ( rule__If__Group_1__0 )*
            {
             before(grammarAccess.getIfAccess().getGroup_1()); 
            // InternalFirstOrderLogic.g:1737:2: ( rule__If__Group_1__0 )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==20) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalFirstOrderLogic.g:1737:3: rule__If__Group_1__0
            	    {
            	    pushFollow(FOLLOW_15);
            	    rule__If__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

             after(grammarAccess.getIfAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__If__Group__1__Impl"


    // $ANTLR start "rule__If__Group_1__0"
    // InternalFirstOrderLogic.g:1746:1: rule__If__Group_1__0 : rule__If__Group_1__0__Impl rule__If__Group_1__1 ;
    public final void rule__If__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1750:1: ( rule__If__Group_1__0__Impl rule__If__Group_1__1 )
            // InternalFirstOrderLogic.g:1751:2: rule__If__Group_1__0__Impl rule__If__Group_1__1
            {
            pushFollow(FOLLOW_14);
            rule__If__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__If__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__If__Group_1__0"


    // $ANTLR start "rule__If__Group_1__0__Impl"
    // InternalFirstOrderLogic.g:1758:1: rule__If__Group_1__0__Impl : ( () ) ;
    public final void rule__If__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1762:1: ( ( () ) )
            // InternalFirstOrderLogic.g:1763:1: ( () )
            {
            // InternalFirstOrderLogic.g:1763:1: ( () )
            // InternalFirstOrderLogic.g:1764:2: ()
            {
             before(grammarAccess.getIfAccess().getIfLeftAction_1_0()); 
            // InternalFirstOrderLogic.g:1765:2: ()
            // InternalFirstOrderLogic.g:1765:3: 
            {
            }

             after(grammarAccess.getIfAccess().getIfLeftAction_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__If__Group_1__0__Impl"


    // $ANTLR start "rule__If__Group_1__1"
    // InternalFirstOrderLogic.g:1773:1: rule__If__Group_1__1 : rule__If__Group_1__1__Impl rule__If__Group_1__2 ;
    public final void rule__If__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1777:1: ( rule__If__Group_1__1__Impl rule__If__Group_1__2 )
            // InternalFirstOrderLogic.g:1778:2: rule__If__Group_1__1__Impl rule__If__Group_1__2
            {
            pushFollow(FOLLOW_11);
            rule__If__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__If__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__If__Group_1__1"


    // $ANTLR start "rule__If__Group_1__1__Impl"
    // InternalFirstOrderLogic.g:1785:1: rule__If__Group_1__1__Impl : ( 'implies' ) ;
    public final void rule__If__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1789:1: ( ( 'implies' ) )
            // InternalFirstOrderLogic.g:1790:1: ( 'implies' )
            {
            // InternalFirstOrderLogic.g:1790:1: ( 'implies' )
            // InternalFirstOrderLogic.g:1791:2: 'implies'
            {
             before(grammarAccess.getIfAccess().getImpliesKeyword_1_1()); 
            match(input,20,FOLLOW_2); 
             after(grammarAccess.getIfAccess().getImpliesKeyword_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__If__Group_1__1__Impl"


    // $ANTLR start "rule__If__Group_1__2"
    // InternalFirstOrderLogic.g:1800:1: rule__If__Group_1__2 : rule__If__Group_1__2__Impl ;
    public final void rule__If__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1804:1: ( rule__If__Group_1__2__Impl )
            // InternalFirstOrderLogic.g:1805:2: rule__If__Group_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__If__Group_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__If__Group_1__2"


    // $ANTLR start "rule__If__Group_1__2__Impl"
    // InternalFirstOrderLogic.g:1811:1: rule__If__Group_1__2__Impl : ( ( rule__If__RightAssignment_1_2 ) ) ;
    public final void rule__If__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1815:1: ( ( ( rule__If__RightAssignment_1_2 ) ) )
            // InternalFirstOrderLogic.g:1816:1: ( ( rule__If__RightAssignment_1_2 ) )
            {
            // InternalFirstOrderLogic.g:1816:1: ( ( rule__If__RightAssignment_1_2 ) )
            // InternalFirstOrderLogic.g:1817:2: ( rule__If__RightAssignment_1_2 )
            {
             before(grammarAccess.getIfAccess().getRightAssignment_1_2()); 
            // InternalFirstOrderLogic.g:1818:2: ( rule__If__RightAssignment_1_2 )
            // InternalFirstOrderLogic.g:1818:3: rule__If__RightAssignment_1_2
            {
            pushFollow(FOLLOW_2);
            rule__If__RightAssignment_1_2();

            state._fsp--;


            }

             after(grammarAccess.getIfAccess().getRightAssignment_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__If__Group_1__2__Impl"


    // $ANTLR start "rule__Xor__Group__0"
    // InternalFirstOrderLogic.g:1827:1: rule__Xor__Group__0 : rule__Xor__Group__0__Impl rule__Xor__Group__1 ;
    public final void rule__Xor__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1831:1: ( rule__Xor__Group__0__Impl rule__Xor__Group__1 )
            // InternalFirstOrderLogic.g:1832:2: rule__Xor__Group__0__Impl rule__Xor__Group__1
            {
            pushFollow(FOLLOW_16);
            rule__Xor__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Xor__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Xor__Group__0"


    // $ANTLR start "rule__Xor__Group__0__Impl"
    // InternalFirstOrderLogic.g:1839:1: rule__Xor__Group__0__Impl : ( ruleOr ) ;
    public final void rule__Xor__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1843:1: ( ( ruleOr ) )
            // InternalFirstOrderLogic.g:1844:1: ( ruleOr )
            {
            // InternalFirstOrderLogic.g:1844:1: ( ruleOr )
            // InternalFirstOrderLogic.g:1845:2: ruleOr
            {
             before(grammarAccess.getXorAccess().getOrParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleOr();

            state._fsp--;

             after(grammarAccess.getXorAccess().getOrParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Xor__Group__0__Impl"


    // $ANTLR start "rule__Xor__Group__1"
    // InternalFirstOrderLogic.g:1854:1: rule__Xor__Group__1 : rule__Xor__Group__1__Impl ;
    public final void rule__Xor__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1858:1: ( rule__Xor__Group__1__Impl )
            // InternalFirstOrderLogic.g:1859:2: rule__Xor__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Xor__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Xor__Group__1"


    // $ANTLR start "rule__Xor__Group__1__Impl"
    // InternalFirstOrderLogic.g:1865:1: rule__Xor__Group__1__Impl : ( ( rule__Xor__Group_1__0 )* ) ;
    public final void rule__Xor__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1869:1: ( ( ( rule__Xor__Group_1__0 )* ) )
            // InternalFirstOrderLogic.g:1870:1: ( ( rule__Xor__Group_1__0 )* )
            {
            // InternalFirstOrderLogic.g:1870:1: ( ( rule__Xor__Group_1__0 )* )
            // InternalFirstOrderLogic.g:1871:2: ( rule__Xor__Group_1__0 )*
            {
             before(grammarAccess.getXorAccess().getGroup_1()); 
            // InternalFirstOrderLogic.g:1872:2: ( rule__Xor__Group_1__0 )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==21) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalFirstOrderLogic.g:1872:3: rule__Xor__Group_1__0
            	    {
            	    pushFollow(FOLLOW_17);
            	    rule__Xor__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

             after(grammarAccess.getXorAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Xor__Group__1__Impl"


    // $ANTLR start "rule__Xor__Group_1__0"
    // InternalFirstOrderLogic.g:1881:1: rule__Xor__Group_1__0 : rule__Xor__Group_1__0__Impl rule__Xor__Group_1__1 ;
    public final void rule__Xor__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1885:1: ( rule__Xor__Group_1__0__Impl rule__Xor__Group_1__1 )
            // InternalFirstOrderLogic.g:1886:2: rule__Xor__Group_1__0__Impl rule__Xor__Group_1__1
            {
            pushFollow(FOLLOW_16);
            rule__Xor__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Xor__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Xor__Group_1__0"


    // $ANTLR start "rule__Xor__Group_1__0__Impl"
    // InternalFirstOrderLogic.g:1893:1: rule__Xor__Group_1__0__Impl : ( () ) ;
    public final void rule__Xor__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1897:1: ( ( () ) )
            // InternalFirstOrderLogic.g:1898:1: ( () )
            {
            // InternalFirstOrderLogic.g:1898:1: ( () )
            // InternalFirstOrderLogic.g:1899:2: ()
            {
             before(grammarAccess.getXorAccess().getXorLeftAction_1_0()); 
            // InternalFirstOrderLogic.g:1900:2: ()
            // InternalFirstOrderLogic.g:1900:3: 
            {
            }

             after(grammarAccess.getXorAccess().getXorLeftAction_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Xor__Group_1__0__Impl"


    // $ANTLR start "rule__Xor__Group_1__1"
    // InternalFirstOrderLogic.g:1908:1: rule__Xor__Group_1__1 : rule__Xor__Group_1__1__Impl rule__Xor__Group_1__2 ;
    public final void rule__Xor__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1912:1: ( rule__Xor__Group_1__1__Impl rule__Xor__Group_1__2 )
            // InternalFirstOrderLogic.g:1913:2: rule__Xor__Group_1__1__Impl rule__Xor__Group_1__2
            {
            pushFollow(FOLLOW_11);
            rule__Xor__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Xor__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Xor__Group_1__1"


    // $ANTLR start "rule__Xor__Group_1__1__Impl"
    // InternalFirstOrderLogic.g:1920:1: rule__Xor__Group_1__1__Impl : ( 'xor' ) ;
    public final void rule__Xor__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1924:1: ( ( 'xor' ) )
            // InternalFirstOrderLogic.g:1925:1: ( 'xor' )
            {
            // InternalFirstOrderLogic.g:1925:1: ( 'xor' )
            // InternalFirstOrderLogic.g:1926:2: 'xor'
            {
             before(grammarAccess.getXorAccess().getXorKeyword_1_1()); 
            match(input,21,FOLLOW_2); 
             after(grammarAccess.getXorAccess().getXorKeyword_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Xor__Group_1__1__Impl"


    // $ANTLR start "rule__Xor__Group_1__2"
    // InternalFirstOrderLogic.g:1935:1: rule__Xor__Group_1__2 : rule__Xor__Group_1__2__Impl ;
    public final void rule__Xor__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1939:1: ( rule__Xor__Group_1__2__Impl )
            // InternalFirstOrderLogic.g:1940:2: rule__Xor__Group_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Xor__Group_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Xor__Group_1__2"


    // $ANTLR start "rule__Xor__Group_1__2__Impl"
    // InternalFirstOrderLogic.g:1946:1: rule__Xor__Group_1__2__Impl : ( ( rule__Xor__RightAssignment_1_2 ) ) ;
    public final void rule__Xor__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1950:1: ( ( ( rule__Xor__RightAssignment_1_2 ) ) )
            // InternalFirstOrderLogic.g:1951:1: ( ( rule__Xor__RightAssignment_1_2 ) )
            {
            // InternalFirstOrderLogic.g:1951:1: ( ( rule__Xor__RightAssignment_1_2 ) )
            // InternalFirstOrderLogic.g:1952:2: ( rule__Xor__RightAssignment_1_2 )
            {
             before(grammarAccess.getXorAccess().getRightAssignment_1_2()); 
            // InternalFirstOrderLogic.g:1953:2: ( rule__Xor__RightAssignment_1_2 )
            // InternalFirstOrderLogic.g:1953:3: rule__Xor__RightAssignment_1_2
            {
            pushFollow(FOLLOW_2);
            rule__Xor__RightAssignment_1_2();

            state._fsp--;


            }

             after(grammarAccess.getXorAccess().getRightAssignment_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Xor__Group_1__2__Impl"


    // $ANTLR start "rule__Or__Group__0"
    // InternalFirstOrderLogic.g:1962:1: rule__Or__Group__0 : rule__Or__Group__0__Impl rule__Or__Group__1 ;
    public final void rule__Or__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1966:1: ( rule__Or__Group__0__Impl rule__Or__Group__1 )
            // InternalFirstOrderLogic.g:1967:2: rule__Or__Group__0__Impl rule__Or__Group__1
            {
            pushFollow(FOLLOW_18);
            rule__Or__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Or__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Or__Group__0"


    // $ANTLR start "rule__Or__Group__0__Impl"
    // InternalFirstOrderLogic.g:1974:1: rule__Or__Group__0__Impl : ( ruleAnd ) ;
    public final void rule__Or__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1978:1: ( ( ruleAnd ) )
            // InternalFirstOrderLogic.g:1979:1: ( ruleAnd )
            {
            // InternalFirstOrderLogic.g:1979:1: ( ruleAnd )
            // InternalFirstOrderLogic.g:1980:2: ruleAnd
            {
             before(grammarAccess.getOrAccess().getAndParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleAnd();

            state._fsp--;

             after(grammarAccess.getOrAccess().getAndParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Or__Group__0__Impl"


    // $ANTLR start "rule__Or__Group__1"
    // InternalFirstOrderLogic.g:1989:1: rule__Or__Group__1 : rule__Or__Group__1__Impl ;
    public final void rule__Or__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1993:1: ( rule__Or__Group__1__Impl )
            // InternalFirstOrderLogic.g:1994:2: rule__Or__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Or__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Or__Group__1"


    // $ANTLR start "rule__Or__Group__1__Impl"
    // InternalFirstOrderLogic.g:2000:1: rule__Or__Group__1__Impl : ( ( rule__Or__Group_1__0 )* ) ;
    public final void rule__Or__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2004:1: ( ( ( rule__Or__Group_1__0 )* ) )
            // InternalFirstOrderLogic.g:2005:1: ( ( rule__Or__Group_1__0 )* )
            {
            // InternalFirstOrderLogic.g:2005:1: ( ( rule__Or__Group_1__0 )* )
            // InternalFirstOrderLogic.g:2006:2: ( rule__Or__Group_1__0 )*
            {
             before(grammarAccess.getOrAccess().getGroup_1()); 
            // InternalFirstOrderLogic.g:2007:2: ( rule__Or__Group_1__0 )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==22) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalFirstOrderLogic.g:2007:3: rule__Or__Group_1__0
            	    {
            	    pushFollow(FOLLOW_19);
            	    rule__Or__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

             after(grammarAccess.getOrAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Or__Group__1__Impl"


    // $ANTLR start "rule__Or__Group_1__0"
    // InternalFirstOrderLogic.g:2016:1: rule__Or__Group_1__0 : rule__Or__Group_1__0__Impl rule__Or__Group_1__1 ;
    public final void rule__Or__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2020:1: ( rule__Or__Group_1__0__Impl rule__Or__Group_1__1 )
            // InternalFirstOrderLogic.g:2021:2: rule__Or__Group_1__0__Impl rule__Or__Group_1__1
            {
            pushFollow(FOLLOW_18);
            rule__Or__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Or__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Or__Group_1__0"


    // $ANTLR start "rule__Or__Group_1__0__Impl"
    // InternalFirstOrderLogic.g:2028:1: rule__Or__Group_1__0__Impl : ( () ) ;
    public final void rule__Or__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2032:1: ( ( () ) )
            // InternalFirstOrderLogic.g:2033:1: ( () )
            {
            // InternalFirstOrderLogic.g:2033:1: ( () )
            // InternalFirstOrderLogic.g:2034:2: ()
            {
             before(grammarAccess.getOrAccess().getOrLeftAction_1_0()); 
            // InternalFirstOrderLogic.g:2035:2: ()
            // InternalFirstOrderLogic.g:2035:3: 
            {
            }

             after(grammarAccess.getOrAccess().getOrLeftAction_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Or__Group_1__0__Impl"


    // $ANTLR start "rule__Or__Group_1__1"
    // InternalFirstOrderLogic.g:2043:1: rule__Or__Group_1__1 : rule__Or__Group_1__1__Impl rule__Or__Group_1__2 ;
    public final void rule__Or__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2047:1: ( rule__Or__Group_1__1__Impl rule__Or__Group_1__2 )
            // InternalFirstOrderLogic.g:2048:2: rule__Or__Group_1__1__Impl rule__Or__Group_1__2
            {
            pushFollow(FOLLOW_11);
            rule__Or__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Or__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Or__Group_1__1"


    // $ANTLR start "rule__Or__Group_1__1__Impl"
    // InternalFirstOrderLogic.g:2055:1: rule__Or__Group_1__1__Impl : ( 'or' ) ;
    public final void rule__Or__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2059:1: ( ( 'or' ) )
            // InternalFirstOrderLogic.g:2060:1: ( 'or' )
            {
            // InternalFirstOrderLogic.g:2060:1: ( 'or' )
            // InternalFirstOrderLogic.g:2061:2: 'or'
            {
             before(grammarAccess.getOrAccess().getOrKeyword_1_1()); 
            match(input,22,FOLLOW_2); 
             after(grammarAccess.getOrAccess().getOrKeyword_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Or__Group_1__1__Impl"


    // $ANTLR start "rule__Or__Group_1__2"
    // InternalFirstOrderLogic.g:2070:1: rule__Or__Group_1__2 : rule__Or__Group_1__2__Impl ;
    public final void rule__Or__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2074:1: ( rule__Or__Group_1__2__Impl )
            // InternalFirstOrderLogic.g:2075:2: rule__Or__Group_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Or__Group_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Or__Group_1__2"


    // $ANTLR start "rule__Or__Group_1__2__Impl"
    // InternalFirstOrderLogic.g:2081:1: rule__Or__Group_1__2__Impl : ( ( rule__Or__RightAssignment_1_2 ) ) ;
    public final void rule__Or__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2085:1: ( ( ( rule__Or__RightAssignment_1_2 ) ) )
            // InternalFirstOrderLogic.g:2086:1: ( ( rule__Or__RightAssignment_1_2 ) )
            {
            // InternalFirstOrderLogic.g:2086:1: ( ( rule__Or__RightAssignment_1_2 ) )
            // InternalFirstOrderLogic.g:2087:2: ( rule__Or__RightAssignment_1_2 )
            {
             before(grammarAccess.getOrAccess().getRightAssignment_1_2()); 
            // InternalFirstOrderLogic.g:2088:2: ( rule__Or__RightAssignment_1_2 )
            // InternalFirstOrderLogic.g:2088:3: rule__Or__RightAssignment_1_2
            {
            pushFollow(FOLLOW_2);
            rule__Or__RightAssignment_1_2();

            state._fsp--;


            }

             after(grammarAccess.getOrAccess().getRightAssignment_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Or__Group_1__2__Impl"


    // $ANTLR start "rule__And__Group__0"
    // InternalFirstOrderLogic.g:2097:1: rule__And__Group__0 : rule__And__Group__0__Impl rule__And__Group__1 ;
    public final void rule__And__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2101:1: ( rule__And__Group__0__Impl rule__And__Group__1 )
            // InternalFirstOrderLogic.g:2102:2: rule__And__Group__0__Impl rule__And__Group__1
            {
            pushFollow(FOLLOW_20);
            rule__And__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__And__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__And__Group__0"


    // $ANTLR start "rule__And__Group__0__Impl"
    // InternalFirstOrderLogic.g:2109:1: rule__And__Group__0__Impl : ( ruleBooleanExpression ) ;
    public final void rule__And__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2113:1: ( ( ruleBooleanExpression ) )
            // InternalFirstOrderLogic.g:2114:1: ( ruleBooleanExpression )
            {
            // InternalFirstOrderLogic.g:2114:1: ( ruleBooleanExpression )
            // InternalFirstOrderLogic.g:2115:2: ruleBooleanExpression
            {
             before(grammarAccess.getAndAccess().getBooleanExpressionParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleBooleanExpression();

            state._fsp--;

             after(grammarAccess.getAndAccess().getBooleanExpressionParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__And__Group__0__Impl"


    // $ANTLR start "rule__And__Group__1"
    // InternalFirstOrderLogic.g:2124:1: rule__And__Group__1 : rule__And__Group__1__Impl ;
    public final void rule__And__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2128:1: ( rule__And__Group__1__Impl )
            // InternalFirstOrderLogic.g:2129:2: rule__And__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__And__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__And__Group__1"


    // $ANTLR start "rule__And__Group__1__Impl"
    // InternalFirstOrderLogic.g:2135:1: rule__And__Group__1__Impl : ( ( rule__And__Group_1__0 )* ) ;
    public final void rule__And__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2139:1: ( ( ( rule__And__Group_1__0 )* ) )
            // InternalFirstOrderLogic.g:2140:1: ( ( rule__And__Group_1__0 )* )
            {
            // InternalFirstOrderLogic.g:2140:1: ( ( rule__And__Group_1__0 )* )
            // InternalFirstOrderLogic.g:2141:2: ( rule__And__Group_1__0 )*
            {
             before(grammarAccess.getAndAccess().getGroup_1()); 
            // InternalFirstOrderLogic.g:2142:2: ( rule__And__Group_1__0 )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==23) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalFirstOrderLogic.g:2142:3: rule__And__Group_1__0
            	    {
            	    pushFollow(FOLLOW_21);
            	    rule__And__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

             after(grammarAccess.getAndAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__And__Group__1__Impl"


    // $ANTLR start "rule__And__Group_1__0"
    // InternalFirstOrderLogic.g:2151:1: rule__And__Group_1__0 : rule__And__Group_1__0__Impl rule__And__Group_1__1 ;
    public final void rule__And__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2155:1: ( rule__And__Group_1__0__Impl rule__And__Group_1__1 )
            // InternalFirstOrderLogic.g:2156:2: rule__And__Group_1__0__Impl rule__And__Group_1__1
            {
            pushFollow(FOLLOW_20);
            rule__And__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__And__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__And__Group_1__0"


    // $ANTLR start "rule__And__Group_1__0__Impl"
    // InternalFirstOrderLogic.g:2163:1: rule__And__Group_1__0__Impl : ( () ) ;
    public final void rule__And__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2167:1: ( ( () ) )
            // InternalFirstOrderLogic.g:2168:1: ( () )
            {
            // InternalFirstOrderLogic.g:2168:1: ( () )
            // InternalFirstOrderLogic.g:2169:2: ()
            {
             before(grammarAccess.getAndAccess().getAndLeftAction_1_0()); 
            // InternalFirstOrderLogic.g:2170:2: ()
            // InternalFirstOrderLogic.g:2170:3: 
            {
            }

             after(grammarAccess.getAndAccess().getAndLeftAction_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__And__Group_1__0__Impl"


    // $ANTLR start "rule__And__Group_1__1"
    // InternalFirstOrderLogic.g:2178:1: rule__And__Group_1__1 : rule__And__Group_1__1__Impl rule__And__Group_1__2 ;
    public final void rule__And__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2182:1: ( rule__And__Group_1__1__Impl rule__And__Group_1__2 )
            // InternalFirstOrderLogic.g:2183:2: rule__And__Group_1__1__Impl rule__And__Group_1__2
            {
            pushFollow(FOLLOW_11);
            rule__And__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__And__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__And__Group_1__1"


    // $ANTLR start "rule__And__Group_1__1__Impl"
    // InternalFirstOrderLogic.g:2190:1: rule__And__Group_1__1__Impl : ( 'and' ) ;
    public final void rule__And__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2194:1: ( ( 'and' ) )
            // InternalFirstOrderLogic.g:2195:1: ( 'and' )
            {
            // InternalFirstOrderLogic.g:2195:1: ( 'and' )
            // InternalFirstOrderLogic.g:2196:2: 'and'
            {
             before(grammarAccess.getAndAccess().getAndKeyword_1_1()); 
            match(input,23,FOLLOW_2); 
             after(grammarAccess.getAndAccess().getAndKeyword_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__And__Group_1__1__Impl"


    // $ANTLR start "rule__And__Group_1__2"
    // InternalFirstOrderLogic.g:2205:1: rule__And__Group_1__2 : rule__And__Group_1__2__Impl ;
    public final void rule__And__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2209:1: ( rule__And__Group_1__2__Impl )
            // InternalFirstOrderLogic.g:2210:2: rule__And__Group_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__And__Group_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__And__Group_1__2"


    // $ANTLR start "rule__And__Group_1__2__Impl"
    // InternalFirstOrderLogic.g:2216:1: rule__And__Group_1__2__Impl : ( ( rule__And__RightAssignment_1_2 ) ) ;
    public final void rule__And__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2220:1: ( ( ( rule__And__RightAssignment_1_2 ) ) )
            // InternalFirstOrderLogic.g:2221:1: ( ( rule__And__RightAssignment_1_2 ) )
            {
            // InternalFirstOrderLogic.g:2221:1: ( ( rule__And__RightAssignment_1_2 ) )
            // InternalFirstOrderLogic.g:2222:2: ( rule__And__RightAssignment_1_2 )
            {
             before(grammarAccess.getAndAccess().getRightAssignment_1_2()); 
            // InternalFirstOrderLogic.g:2223:2: ( rule__And__RightAssignment_1_2 )
            // InternalFirstOrderLogic.g:2223:3: rule__And__RightAssignment_1_2
            {
            pushFollow(FOLLOW_2);
            rule__And__RightAssignment_1_2();

            state._fsp--;


            }

             after(grammarAccess.getAndAccess().getRightAssignment_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__And__Group_1__2__Impl"


    // $ANTLR start "rule__Not__Group__0"
    // InternalFirstOrderLogic.g:2232:1: rule__Not__Group__0 : rule__Not__Group__0__Impl rule__Not__Group__1 ;
    public final void rule__Not__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2236:1: ( rule__Not__Group__0__Impl rule__Not__Group__1 )
            // InternalFirstOrderLogic.g:2237:2: rule__Not__Group__0__Impl rule__Not__Group__1
            {
            pushFollow(FOLLOW_22);
            rule__Not__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Not__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Not__Group__0"


    // $ANTLR start "rule__Not__Group__0__Impl"
    // InternalFirstOrderLogic.g:2244:1: rule__Not__Group__0__Impl : ( () ) ;
    public final void rule__Not__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2248:1: ( ( () ) )
            // InternalFirstOrderLogic.g:2249:1: ( () )
            {
            // InternalFirstOrderLogic.g:2249:1: ( () )
            // InternalFirstOrderLogic.g:2250:2: ()
            {
             before(grammarAccess.getNotAccess().getNotAction_0()); 
            // InternalFirstOrderLogic.g:2251:2: ()
            // InternalFirstOrderLogic.g:2251:3: 
            {
            }

             after(grammarAccess.getNotAccess().getNotAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Not__Group__0__Impl"


    // $ANTLR start "rule__Not__Group__1"
    // InternalFirstOrderLogic.g:2259:1: rule__Not__Group__1 : rule__Not__Group__1__Impl rule__Not__Group__2 ;
    public final void rule__Not__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2263:1: ( rule__Not__Group__1__Impl rule__Not__Group__2 )
            // InternalFirstOrderLogic.g:2264:2: rule__Not__Group__1__Impl rule__Not__Group__2
            {
            pushFollow(FOLLOW_11);
            rule__Not__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Not__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Not__Group__1"


    // $ANTLR start "rule__Not__Group__1__Impl"
    // InternalFirstOrderLogic.g:2271:1: rule__Not__Group__1__Impl : ( 'not(' ) ;
    public final void rule__Not__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2275:1: ( ( 'not(' ) )
            // InternalFirstOrderLogic.g:2276:1: ( 'not(' )
            {
            // InternalFirstOrderLogic.g:2276:1: ( 'not(' )
            // InternalFirstOrderLogic.g:2277:2: 'not('
            {
             before(grammarAccess.getNotAccess().getNotKeyword_1()); 
            match(input,24,FOLLOW_2); 
             after(grammarAccess.getNotAccess().getNotKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Not__Group__1__Impl"


    // $ANTLR start "rule__Not__Group__2"
    // InternalFirstOrderLogic.g:2286:1: rule__Not__Group__2 : rule__Not__Group__2__Impl rule__Not__Group__3 ;
    public final void rule__Not__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2290:1: ( rule__Not__Group__2__Impl rule__Not__Group__3 )
            // InternalFirstOrderLogic.g:2291:2: rule__Not__Group__2__Impl rule__Not__Group__3
            {
            pushFollow(FOLLOW_23);
            rule__Not__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Not__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Not__Group__2"


    // $ANTLR start "rule__Not__Group__2__Impl"
    // InternalFirstOrderLogic.g:2298:1: rule__Not__Group__2__Impl : ( ( rule__Not__NotAssignment_2 ) ) ;
    public final void rule__Not__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2302:1: ( ( ( rule__Not__NotAssignment_2 ) ) )
            // InternalFirstOrderLogic.g:2303:1: ( ( rule__Not__NotAssignment_2 ) )
            {
            // InternalFirstOrderLogic.g:2303:1: ( ( rule__Not__NotAssignment_2 ) )
            // InternalFirstOrderLogic.g:2304:2: ( rule__Not__NotAssignment_2 )
            {
             before(grammarAccess.getNotAccess().getNotAssignment_2()); 
            // InternalFirstOrderLogic.g:2305:2: ( rule__Not__NotAssignment_2 )
            // InternalFirstOrderLogic.g:2305:3: rule__Not__NotAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__Not__NotAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getNotAccess().getNotAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Not__Group__2__Impl"


    // $ANTLR start "rule__Not__Group__3"
    // InternalFirstOrderLogic.g:2313:1: rule__Not__Group__3 : rule__Not__Group__3__Impl ;
    public final void rule__Not__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2317:1: ( rule__Not__Group__3__Impl )
            // InternalFirstOrderLogic.g:2318:2: rule__Not__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Not__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Not__Group__3"


    // $ANTLR start "rule__Not__Group__3__Impl"
    // InternalFirstOrderLogic.g:2324:1: rule__Not__Group__3__Impl : ( ')' ) ;
    public final void rule__Not__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2328:1: ( ( ')' ) )
            // InternalFirstOrderLogic.g:2329:1: ( ')' )
            {
            // InternalFirstOrderLogic.g:2329:1: ( ')' )
            // InternalFirstOrderLogic.g:2330:2: ')'
            {
             before(grammarAccess.getNotAccess().getRightParenthesisKeyword_3()); 
            match(input,25,FOLLOW_2); 
             after(grammarAccess.getNotAccess().getRightParenthesisKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Not__Group__3__Impl"


    // $ANTLR start "rule__Equals__Group__0"
    // InternalFirstOrderLogic.g:2340:1: rule__Equals__Group__0 : rule__Equals__Group__0__Impl rule__Equals__Group__1 ;
    public final void rule__Equals__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2344:1: ( rule__Equals__Group__0__Impl rule__Equals__Group__1 )
            // InternalFirstOrderLogic.g:2345:2: rule__Equals__Group__0__Impl rule__Equals__Group__1
            {
            pushFollow(FOLLOW_24);
            rule__Equals__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Equals__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Equals__Group__0"


    // $ANTLR start "rule__Equals__Group__0__Impl"
    // InternalFirstOrderLogic.g:2352:1: rule__Equals__Group__0__Impl : ( 'isEqual(' ) ;
    public final void rule__Equals__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2356:1: ( ( 'isEqual(' ) )
            // InternalFirstOrderLogic.g:2357:1: ( 'isEqual(' )
            {
            // InternalFirstOrderLogic.g:2357:1: ( 'isEqual(' )
            // InternalFirstOrderLogic.g:2358:2: 'isEqual('
            {
             before(grammarAccess.getEqualsAccess().getIsEqualKeyword_0()); 
            match(input,26,FOLLOW_2); 
             after(grammarAccess.getEqualsAccess().getIsEqualKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Equals__Group__0__Impl"


    // $ANTLR start "rule__Equals__Group__1"
    // InternalFirstOrderLogic.g:2367:1: rule__Equals__Group__1 : rule__Equals__Group__1__Impl rule__Equals__Group__2 ;
    public final void rule__Equals__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2371:1: ( rule__Equals__Group__1__Impl rule__Equals__Group__2 )
            // InternalFirstOrderLogic.g:2372:2: rule__Equals__Group__1__Impl rule__Equals__Group__2
            {
            pushFollow(FOLLOW_25);
            rule__Equals__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Equals__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Equals__Group__1"


    // $ANTLR start "rule__Equals__Group__1__Impl"
    // InternalFirstOrderLogic.g:2379:1: rule__Equals__Group__1__Impl : ( ( rule__Equals__LeftAssignment_1 ) ) ;
    public final void rule__Equals__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2383:1: ( ( ( rule__Equals__LeftAssignment_1 ) ) )
            // InternalFirstOrderLogic.g:2384:1: ( ( rule__Equals__LeftAssignment_1 ) )
            {
            // InternalFirstOrderLogic.g:2384:1: ( ( rule__Equals__LeftAssignment_1 ) )
            // InternalFirstOrderLogic.g:2385:2: ( rule__Equals__LeftAssignment_1 )
            {
             before(grammarAccess.getEqualsAccess().getLeftAssignment_1()); 
            // InternalFirstOrderLogic.g:2386:2: ( rule__Equals__LeftAssignment_1 )
            // InternalFirstOrderLogic.g:2386:3: rule__Equals__LeftAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Equals__LeftAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getEqualsAccess().getLeftAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Equals__Group__1__Impl"


    // $ANTLR start "rule__Equals__Group__2"
    // InternalFirstOrderLogic.g:2394:1: rule__Equals__Group__2 : rule__Equals__Group__2__Impl rule__Equals__Group__3 ;
    public final void rule__Equals__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2398:1: ( rule__Equals__Group__2__Impl rule__Equals__Group__3 )
            // InternalFirstOrderLogic.g:2399:2: rule__Equals__Group__2__Impl rule__Equals__Group__3
            {
            pushFollow(FOLLOW_24);
            rule__Equals__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Equals__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Equals__Group__2"


    // $ANTLR start "rule__Equals__Group__2__Impl"
    // InternalFirstOrderLogic.g:2406:1: rule__Equals__Group__2__Impl : ( ',' ) ;
    public final void rule__Equals__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2410:1: ( ( ',' ) )
            // InternalFirstOrderLogic.g:2411:1: ( ',' )
            {
            // InternalFirstOrderLogic.g:2411:1: ( ',' )
            // InternalFirstOrderLogic.g:2412:2: ','
            {
             before(grammarAccess.getEqualsAccess().getCommaKeyword_2()); 
            match(input,27,FOLLOW_2); 
             after(grammarAccess.getEqualsAccess().getCommaKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Equals__Group__2__Impl"


    // $ANTLR start "rule__Equals__Group__3"
    // InternalFirstOrderLogic.g:2421:1: rule__Equals__Group__3 : rule__Equals__Group__3__Impl rule__Equals__Group__4 ;
    public final void rule__Equals__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2425:1: ( rule__Equals__Group__3__Impl rule__Equals__Group__4 )
            // InternalFirstOrderLogic.g:2426:2: rule__Equals__Group__3__Impl rule__Equals__Group__4
            {
            pushFollow(FOLLOW_23);
            rule__Equals__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Equals__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Equals__Group__3"


    // $ANTLR start "rule__Equals__Group__3__Impl"
    // InternalFirstOrderLogic.g:2433:1: rule__Equals__Group__3__Impl : ( ( rule__Equals__RightAssignment_3 ) ) ;
    public final void rule__Equals__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2437:1: ( ( ( rule__Equals__RightAssignment_3 ) ) )
            // InternalFirstOrderLogic.g:2438:1: ( ( rule__Equals__RightAssignment_3 ) )
            {
            // InternalFirstOrderLogic.g:2438:1: ( ( rule__Equals__RightAssignment_3 ) )
            // InternalFirstOrderLogic.g:2439:2: ( rule__Equals__RightAssignment_3 )
            {
             before(grammarAccess.getEqualsAccess().getRightAssignment_3()); 
            // InternalFirstOrderLogic.g:2440:2: ( rule__Equals__RightAssignment_3 )
            // InternalFirstOrderLogic.g:2440:3: rule__Equals__RightAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__Equals__RightAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getEqualsAccess().getRightAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Equals__Group__3__Impl"


    // $ANTLR start "rule__Equals__Group__4"
    // InternalFirstOrderLogic.g:2448:1: rule__Equals__Group__4 : rule__Equals__Group__4__Impl ;
    public final void rule__Equals__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2452:1: ( rule__Equals__Group__4__Impl )
            // InternalFirstOrderLogic.g:2453:2: rule__Equals__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Equals__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Equals__Group__4"


    // $ANTLR start "rule__Equals__Group__4__Impl"
    // InternalFirstOrderLogic.g:2459:1: rule__Equals__Group__4__Impl : ( ')' ) ;
    public final void rule__Equals__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2463:1: ( ( ')' ) )
            // InternalFirstOrderLogic.g:2464:1: ( ')' )
            {
            // InternalFirstOrderLogic.g:2464:1: ( ')' )
            // InternalFirstOrderLogic.g:2465:2: ')'
            {
             before(grammarAccess.getEqualsAccess().getRightParenthesisKeyword_4()); 
            match(input,25,FOLLOW_2); 
             after(grammarAccess.getEqualsAccess().getRightParenthesisKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Equals__Group__4__Impl"


    // $ANTLR start "rule__Greater__Group__0"
    // InternalFirstOrderLogic.g:2475:1: rule__Greater__Group__0 : rule__Greater__Group__0__Impl rule__Greater__Group__1 ;
    public final void rule__Greater__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2479:1: ( rule__Greater__Group__0__Impl rule__Greater__Group__1 )
            // InternalFirstOrderLogic.g:2480:2: rule__Greater__Group__0__Impl rule__Greater__Group__1
            {
            pushFollow(FOLLOW_24);
            rule__Greater__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Greater__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Greater__Group__0"


    // $ANTLR start "rule__Greater__Group__0__Impl"
    // InternalFirstOrderLogic.g:2487:1: rule__Greater__Group__0__Impl : ( 'isGreater(' ) ;
    public final void rule__Greater__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2491:1: ( ( 'isGreater(' ) )
            // InternalFirstOrderLogic.g:2492:1: ( 'isGreater(' )
            {
            // InternalFirstOrderLogic.g:2492:1: ( 'isGreater(' )
            // InternalFirstOrderLogic.g:2493:2: 'isGreater('
            {
             before(grammarAccess.getGreaterAccess().getIsGreaterKeyword_0()); 
            match(input,28,FOLLOW_2); 
             after(grammarAccess.getGreaterAccess().getIsGreaterKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Greater__Group__0__Impl"


    // $ANTLR start "rule__Greater__Group__1"
    // InternalFirstOrderLogic.g:2502:1: rule__Greater__Group__1 : rule__Greater__Group__1__Impl rule__Greater__Group__2 ;
    public final void rule__Greater__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2506:1: ( rule__Greater__Group__1__Impl rule__Greater__Group__2 )
            // InternalFirstOrderLogic.g:2507:2: rule__Greater__Group__1__Impl rule__Greater__Group__2
            {
            pushFollow(FOLLOW_25);
            rule__Greater__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Greater__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Greater__Group__1"


    // $ANTLR start "rule__Greater__Group__1__Impl"
    // InternalFirstOrderLogic.g:2514:1: rule__Greater__Group__1__Impl : ( ( rule__Greater__LeftAssignment_1 ) ) ;
    public final void rule__Greater__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2518:1: ( ( ( rule__Greater__LeftAssignment_1 ) ) )
            // InternalFirstOrderLogic.g:2519:1: ( ( rule__Greater__LeftAssignment_1 ) )
            {
            // InternalFirstOrderLogic.g:2519:1: ( ( rule__Greater__LeftAssignment_1 ) )
            // InternalFirstOrderLogic.g:2520:2: ( rule__Greater__LeftAssignment_1 )
            {
             before(grammarAccess.getGreaterAccess().getLeftAssignment_1()); 
            // InternalFirstOrderLogic.g:2521:2: ( rule__Greater__LeftAssignment_1 )
            // InternalFirstOrderLogic.g:2521:3: rule__Greater__LeftAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Greater__LeftAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getGreaterAccess().getLeftAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Greater__Group__1__Impl"


    // $ANTLR start "rule__Greater__Group__2"
    // InternalFirstOrderLogic.g:2529:1: rule__Greater__Group__2 : rule__Greater__Group__2__Impl rule__Greater__Group__3 ;
    public final void rule__Greater__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2533:1: ( rule__Greater__Group__2__Impl rule__Greater__Group__3 )
            // InternalFirstOrderLogic.g:2534:2: rule__Greater__Group__2__Impl rule__Greater__Group__3
            {
            pushFollow(FOLLOW_24);
            rule__Greater__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Greater__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Greater__Group__2"


    // $ANTLR start "rule__Greater__Group__2__Impl"
    // InternalFirstOrderLogic.g:2541:1: rule__Greater__Group__2__Impl : ( ',' ) ;
    public final void rule__Greater__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2545:1: ( ( ',' ) )
            // InternalFirstOrderLogic.g:2546:1: ( ',' )
            {
            // InternalFirstOrderLogic.g:2546:1: ( ',' )
            // InternalFirstOrderLogic.g:2547:2: ','
            {
             before(grammarAccess.getGreaterAccess().getCommaKeyword_2()); 
            match(input,27,FOLLOW_2); 
             after(grammarAccess.getGreaterAccess().getCommaKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Greater__Group__2__Impl"


    // $ANTLR start "rule__Greater__Group__3"
    // InternalFirstOrderLogic.g:2556:1: rule__Greater__Group__3 : rule__Greater__Group__3__Impl rule__Greater__Group__4 ;
    public final void rule__Greater__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2560:1: ( rule__Greater__Group__3__Impl rule__Greater__Group__4 )
            // InternalFirstOrderLogic.g:2561:2: rule__Greater__Group__3__Impl rule__Greater__Group__4
            {
            pushFollow(FOLLOW_23);
            rule__Greater__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Greater__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Greater__Group__3"


    // $ANTLR start "rule__Greater__Group__3__Impl"
    // InternalFirstOrderLogic.g:2568:1: rule__Greater__Group__3__Impl : ( ( rule__Greater__RightAssignment_3 ) ) ;
    public final void rule__Greater__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2572:1: ( ( ( rule__Greater__RightAssignment_3 ) ) )
            // InternalFirstOrderLogic.g:2573:1: ( ( rule__Greater__RightAssignment_3 ) )
            {
            // InternalFirstOrderLogic.g:2573:1: ( ( rule__Greater__RightAssignment_3 ) )
            // InternalFirstOrderLogic.g:2574:2: ( rule__Greater__RightAssignment_3 )
            {
             before(grammarAccess.getGreaterAccess().getRightAssignment_3()); 
            // InternalFirstOrderLogic.g:2575:2: ( rule__Greater__RightAssignment_3 )
            // InternalFirstOrderLogic.g:2575:3: rule__Greater__RightAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__Greater__RightAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getGreaterAccess().getRightAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Greater__Group__3__Impl"


    // $ANTLR start "rule__Greater__Group__4"
    // InternalFirstOrderLogic.g:2583:1: rule__Greater__Group__4 : rule__Greater__Group__4__Impl ;
    public final void rule__Greater__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2587:1: ( rule__Greater__Group__4__Impl )
            // InternalFirstOrderLogic.g:2588:2: rule__Greater__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Greater__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Greater__Group__4"


    // $ANTLR start "rule__Greater__Group__4__Impl"
    // InternalFirstOrderLogic.g:2594:1: rule__Greater__Group__4__Impl : ( ')' ) ;
    public final void rule__Greater__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2598:1: ( ( ')' ) )
            // InternalFirstOrderLogic.g:2599:1: ( ')' )
            {
            // InternalFirstOrderLogic.g:2599:1: ( ')' )
            // InternalFirstOrderLogic.g:2600:2: ')'
            {
             before(grammarAccess.getGreaterAccess().getRightParenthesisKeyword_4()); 
            match(input,25,FOLLOW_2); 
             after(grammarAccess.getGreaterAccess().getRightParenthesisKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Greater__Group__4__Impl"


    // $ANTLR start "rule__GreaterEqual__Group__0"
    // InternalFirstOrderLogic.g:2610:1: rule__GreaterEqual__Group__0 : rule__GreaterEqual__Group__0__Impl rule__GreaterEqual__Group__1 ;
    public final void rule__GreaterEqual__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2614:1: ( rule__GreaterEqual__Group__0__Impl rule__GreaterEqual__Group__1 )
            // InternalFirstOrderLogic.g:2615:2: rule__GreaterEqual__Group__0__Impl rule__GreaterEqual__Group__1
            {
            pushFollow(FOLLOW_24);
            rule__GreaterEqual__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__GreaterEqual__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GreaterEqual__Group__0"


    // $ANTLR start "rule__GreaterEqual__Group__0__Impl"
    // InternalFirstOrderLogic.g:2622:1: rule__GreaterEqual__Group__0__Impl : ( 'isGreaterEqual(' ) ;
    public final void rule__GreaterEqual__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2626:1: ( ( 'isGreaterEqual(' ) )
            // InternalFirstOrderLogic.g:2627:1: ( 'isGreaterEqual(' )
            {
            // InternalFirstOrderLogic.g:2627:1: ( 'isGreaterEqual(' )
            // InternalFirstOrderLogic.g:2628:2: 'isGreaterEqual('
            {
             before(grammarAccess.getGreaterEqualAccess().getIsGreaterEqualKeyword_0()); 
            match(input,29,FOLLOW_2); 
             after(grammarAccess.getGreaterEqualAccess().getIsGreaterEqualKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GreaterEqual__Group__0__Impl"


    // $ANTLR start "rule__GreaterEqual__Group__1"
    // InternalFirstOrderLogic.g:2637:1: rule__GreaterEqual__Group__1 : rule__GreaterEqual__Group__1__Impl rule__GreaterEqual__Group__2 ;
    public final void rule__GreaterEqual__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2641:1: ( rule__GreaterEqual__Group__1__Impl rule__GreaterEqual__Group__2 )
            // InternalFirstOrderLogic.g:2642:2: rule__GreaterEqual__Group__1__Impl rule__GreaterEqual__Group__2
            {
            pushFollow(FOLLOW_25);
            rule__GreaterEqual__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__GreaterEqual__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GreaterEqual__Group__1"


    // $ANTLR start "rule__GreaterEqual__Group__1__Impl"
    // InternalFirstOrderLogic.g:2649:1: rule__GreaterEqual__Group__1__Impl : ( ( rule__GreaterEqual__LeftAssignment_1 ) ) ;
    public final void rule__GreaterEqual__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2653:1: ( ( ( rule__GreaterEqual__LeftAssignment_1 ) ) )
            // InternalFirstOrderLogic.g:2654:1: ( ( rule__GreaterEqual__LeftAssignment_1 ) )
            {
            // InternalFirstOrderLogic.g:2654:1: ( ( rule__GreaterEqual__LeftAssignment_1 ) )
            // InternalFirstOrderLogic.g:2655:2: ( rule__GreaterEqual__LeftAssignment_1 )
            {
             before(grammarAccess.getGreaterEqualAccess().getLeftAssignment_1()); 
            // InternalFirstOrderLogic.g:2656:2: ( rule__GreaterEqual__LeftAssignment_1 )
            // InternalFirstOrderLogic.g:2656:3: rule__GreaterEqual__LeftAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__GreaterEqual__LeftAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getGreaterEqualAccess().getLeftAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GreaterEqual__Group__1__Impl"


    // $ANTLR start "rule__GreaterEqual__Group__2"
    // InternalFirstOrderLogic.g:2664:1: rule__GreaterEqual__Group__2 : rule__GreaterEqual__Group__2__Impl rule__GreaterEqual__Group__3 ;
    public final void rule__GreaterEqual__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2668:1: ( rule__GreaterEqual__Group__2__Impl rule__GreaterEqual__Group__3 )
            // InternalFirstOrderLogic.g:2669:2: rule__GreaterEqual__Group__2__Impl rule__GreaterEqual__Group__3
            {
            pushFollow(FOLLOW_24);
            rule__GreaterEqual__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__GreaterEqual__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GreaterEqual__Group__2"


    // $ANTLR start "rule__GreaterEqual__Group__2__Impl"
    // InternalFirstOrderLogic.g:2676:1: rule__GreaterEqual__Group__2__Impl : ( ',' ) ;
    public final void rule__GreaterEqual__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2680:1: ( ( ',' ) )
            // InternalFirstOrderLogic.g:2681:1: ( ',' )
            {
            // InternalFirstOrderLogic.g:2681:1: ( ',' )
            // InternalFirstOrderLogic.g:2682:2: ','
            {
             before(grammarAccess.getGreaterEqualAccess().getCommaKeyword_2()); 
            match(input,27,FOLLOW_2); 
             after(grammarAccess.getGreaterEqualAccess().getCommaKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GreaterEqual__Group__2__Impl"


    // $ANTLR start "rule__GreaterEqual__Group__3"
    // InternalFirstOrderLogic.g:2691:1: rule__GreaterEqual__Group__3 : rule__GreaterEqual__Group__3__Impl rule__GreaterEqual__Group__4 ;
    public final void rule__GreaterEqual__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2695:1: ( rule__GreaterEqual__Group__3__Impl rule__GreaterEqual__Group__4 )
            // InternalFirstOrderLogic.g:2696:2: rule__GreaterEqual__Group__3__Impl rule__GreaterEqual__Group__4
            {
            pushFollow(FOLLOW_23);
            rule__GreaterEqual__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__GreaterEqual__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GreaterEqual__Group__3"


    // $ANTLR start "rule__GreaterEqual__Group__3__Impl"
    // InternalFirstOrderLogic.g:2703:1: rule__GreaterEqual__Group__3__Impl : ( ( rule__GreaterEqual__RightAssignment_3 ) ) ;
    public final void rule__GreaterEqual__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2707:1: ( ( ( rule__GreaterEqual__RightAssignment_3 ) ) )
            // InternalFirstOrderLogic.g:2708:1: ( ( rule__GreaterEqual__RightAssignment_3 ) )
            {
            // InternalFirstOrderLogic.g:2708:1: ( ( rule__GreaterEqual__RightAssignment_3 ) )
            // InternalFirstOrderLogic.g:2709:2: ( rule__GreaterEqual__RightAssignment_3 )
            {
             before(grammarAccess.getGreaterEqualAccess().getRightAssignment_3()); 
            // InternalFirstOrderLogic.g:2710:2: ( rule__GreaterEqual__RightAssignment_3 )
            // InternalFirstOrderLogic.g:2710:3: rule__GreaterEqual__RightAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__GreaterEqual__RightAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getGreaterEqualAccess().getRightAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GreaterEqual__Group__3__Impl"


    // $ANTLR start "rule__GreaterEqual__Group__4"
    // InternalFirstOrderLogic.g:2718:1: rule__GreaterEqual__Group__4 : rule__GreaterEqual__Group__4__Impl ;
    public final void rule__GreaterEqual__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2722:1: ( rule__GreaterEqual__Group__4__Impl )
            // InternalFirstOrderLogic.g:2723:2: rule__GreaterEqual__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__GreaterEqual__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GreaterEqual__Group__4"


    // $ANTLR start "rule__GreaterEqual__Group__4__Impl"
    // InternalFirstOrderLogic.g:2729:1: rule__GreaterEqual__Group__4__Impl : ( ')' ) ;
    public final void rule__GreaterEqual__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2733:1: ( ( ')' ) )
            // InternalFirstOrderLogic.g:2734:1: ( ')' )
            {
            // InternalFirstOrderLogic.g:2734:1: ( ')' )
            // InternalFirstOrderLogic.g:2735:2: ')'
            {
             before(grammarAccess.getGreaterEqualAccess().getRightParenthesisKeyword_4()); 
            match(input,25,FOLLOW_2); 
             after(grammarAccess.getGreaterEqualAccess().getRightParenthesisKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GreaterEqual__Group__4__Impl"


    // $ANTLR start "rule__Smaller__Group__0"
    // InternalFirstOrderLogic.g:2745:1: rule__Smaller__Group__0 : rule__Smaller__Group__0__Impl rule__Smaller__Group__1 ;
    public final void rule__Smaller__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2749:1: ( rule__Smaller__Group__0__Impl rule__Smaller__Group__1 )
            // InternalFirstOrderLogic.g:2750:2: rule__Smaller__Group__0__Impl rule__Smaller__Group__1
            {
            pushFollow(FOLLOW_24);
            rule__Smaller__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Smaller__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Smaller__Group__0"


    // $ANTLR start "rule__Smaller__Group__0__Impl"
    // InternalFirstOrderLogic.g:2757:1: rule__Smaller__Group__0__Impl : ( 'isSmaller(' ) ;
    public final void rule__Smaller__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2761:1: ( ( 'isSmaller(' ) )
            // InternalFirstOrderLogic.g:2762:1: ( 'isSmaller(' )
            {
            // InternalFirstOrderLogic.g:2762:1: ( 'isSmaller(' )
            // InternalFirstOrderLogic.g:2763:2: 'isSmaller('
            {
             before(grammarAccess.getSmallerAccess().getIsSmallerKeyword_0()); 
            match(input,30,FOLLOW_2); 
             after(grammarAccess.getSmallerAccess().getIsSmallerKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Smaller__Group__0__Impl"


    // $ANTLR start "rule__Smaller__Group__1"
    // InternalFirstOrderLogic.g:2772:1: rule__Smaller__Group__1 : rule__Smaller__Group__1__Impl rule__Smaller__Group__2 ;
    public final void rule__Smaller__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2776:1: ( rule__Smaller__Group__1__Impl rule__Smaller__Group__2 )
            // InternalFirstOrderLogic.g:2777:2: rule__Smaller__Group__1__Impl rule__Smaller__Group__2
            {
            pushFollow(FOLLOW_25);
            rule__Smaller__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Smaller__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Smaller__Group__1"


    // $ANTLR start "rule__Smaller__Group__1__Impl"
    // InternalFirstOrderLogic.g:2784:1: rule__Smaller__Group__1__Impl : ( ( rule__Smaller__LeftAssignment_1 ) ) ;
    public final void rule__Smaller__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2788:1: ( ( ( rule__Smaller__LeftAssignment_1 ) ) )
            // InternalFirstOrderLogic.g:2789:1: ( ( rule__Smaller__LeftAssignment_1 ) )
            {
            // InternalFirstOrderLogic.g:2789:1: ( ( rule__Smaller__LeftAssignment_1 ) )
            // InternalFirstOrderLogic.g:2790:2: ( rule__Smaller__LeftAssignment_1 )
            {
             before(grammarAccess.getSmallerAccess().getLeftAssignment_1()); 
            // InternalFirstOrderLogic.g:2791:2: ( rule__Smaller__LeftAssignment_1 )
            // InternalFirstOrderLogic.g:2791:3: rule__Smaller__LeftAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Smaller__LeftAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getSmallerAccess().getLeftAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Smaller__Group__1__Impl"


    // $ANTLR start "rule__Smaller__Group__2"
    // InternalFirstOrderLogic.g:2799:1: rule__Smaller__Group__2 : rule__Smaller__Group__2__Impl rule__Smaller__Group__3 ;
    public final void rule__Smaller__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2803:1: ( rule__Smaller__Group__2__Impl rule__Smaller__Group__3 )
            // InternalFirstOrderLogic.g:2804:2: rule__Smaller__Group__2__Impl rule__Smaller__Group__3
            {
            pushFollow(FOLLOW_24);
            rule__Smaller__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Smaller__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Smaller__Group__2"


    // $ANTLR start "rule__Smaller__Group__2__Impl"
    // InternalFirstOrderLogic.g:2811:1: rule__Smaller__Group__2__Impl : ( ',' ) ;
    public final void rule__Smaller__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2815:1: ( ( ',' ) )
            // InternalFirstOrderLogic.g:2816:1: ( ',' )
            {
            // InternalFirstOrderLogic.g:2816:1: ( ',' )
            // InternalFirstOrderLogic.g:2817:2: ','
            {
             before(grammarAccess.getSmallerAccess().getCommaKeyword_2()); 
            match(input,27,FOLLOW_2); 
             after(grammarAccess.getSmallerAccess().getCommaKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Smaller__Group__2__Impl"


    // $ANTLR start "rule__Smaller__Group__3"
    // InternalFirstOrderLogic.g:2826:1: rule__Smaller__Group__3 : rule__Smaller__Group__3__Impl rule__Smaller__Group__4 ;
    public final void rule__Smaller__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2830:1: ( rule__Smaller__Group__3__Impl rule__Smaller__Group__4 )
            // InternalFirstOrderLogic.g:2831:2: rule__Smaller__Group__3__Impl rule__Smaller__Group__4
            {
            pushFollow(FOLLOW_23);
            rule__Smaller__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Smaller__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Smaller__Group__3"


    // $ANTLR start "rule__Smaller__Group__3__Impl"
    // InternalFirstOrderLogic.g:2838:1: rule__Smaller__Group__3__Impl : ( ( rule__Smaller__RightAssignment_3 ) ) ;
    public final void rule__Smaller__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2842:1: ( ( ( rule__Smaller__RightAssignment_3 ) ) )
            // InternalFirstOrderLogic.g:2843:1: ( ( rule__Smaller__RightAssignment_3 ) )
            {
            // InternalFirstOrderLogic.g:2843:1: ( ( rule__Smaller__RightAssignment_3 ) )
            // InternalFirstOrderLogic.g:2844:2: ( rule__Smaller__RightAssignment_3 )
            {
             before(grammarAccess.getSmallerAccess().getRightAssignment_3()); 
            // InternalFirstOrderLogic.g:2845:2: ( rule__Smaller__RightAssignment_3 )
            // InternalFirstOrderLogic.g:2845:3: rule__Smaller__RightAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__Smaller__RightAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getSmallerAccess().getRightAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Smaller__Group__3__Impl"


    // $ANTLR start "rule__Smaller__Group__4"
    // InternalFirstOrderLogic.g:2853:1: rule__Smaller__Group__4 : rule__Smaller__Group__4__Impl ;
    public final void rule__Smaller__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2857:1: ( rule__Smaller__Group__4__Impl )
            // InternalFirstOrderLogic.g:2858:2: rule__Smaller__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Smaller__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Smaller__Group__4"


    // $ANTLR start "rule__Smaller__Group__4__Impl"
    // InternalFirstOrderLogic.g:2864:1: rule__Smaller__Group__4__Impl : ( ')' ) ;
    public final void rule__Smaller__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2868:1: ( ( ')' ) )
            // InternalFirstOrderLogic.g:2869:1: ( ')' )
            {
            // InternalFirstOrderLogic.g:2869:1: ( ')' )
            // InternalFirstOrderLogic.g:2870:2: ')'
            {
             before(grammarAccess.getSmallerAccess().getRightParenthesisKeyword_4()); 
            match(input,25,FOLLOW_2); 
             after(grammarAccess.getSmallerAccess().getRightParenthesisKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Smaller__Group__4__Impl"


    // $ANTLR start "rule__SmallerEqual__Group__0"
    // InternalFirstOrderLogic.g:2880:1: rule__SmallerEqual__Group__0 : rule__SmallerEqual__Group__0__Impl rule__SmallerEqual__Group__1 ;
    public final void rule__SmallerEqual__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2884:1: ( rule__SmallerEqual__Group__0__Impl rule__SmallerEqual__Group__1 )
            // InternalFirstOrderLogic.g:2885:2: rule__SmallerEqual__Group__0__Impl rule__SmallerEqual__Group__1
            {
            pushFollow(FOLLOW_24);
            rule__SmallerEqual__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SmallerEqual__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SmallerEqual__Group__0"


    // $ANTLR start "rule__SmallerEqual__Group__0__Impl"
    // InternalFirstOrderLogic.g:2892:1: rule__SmallerEqual__Group__0__Impl : ( 'isSmallerEqual(' ) ;
    public final void rule__SmallerEqual__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2896:1: ( ( 'isSmallerEqual(' ) )
            // InternalFirstOrderLogic.g:2897:1: ( 'isSmallerEqual(' )
            {
            // InternalFirstOrderLogic.g:2897:1: ( 'isSmallerEqual(' )
            // InternalFirstOrderLogic.g:2898:2: 'isSmallerEqual('
            {
             before(grammarAccess.getSmallerEqualAccess().getIsSmallerEqualKeyword_0()); 
            match(input,31,FOLLOW_2); 
             after(grammarAccess.getSmallerEqualAccess().getIsSmallerEqualKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SmallerEqual__Group__0__Impl"


    // $ANTLR start "rule__SmallerEqual__Group__1"
    // InternalFirstOrderLogic.g:2907:1: rule__SmallerEqual__Group__1 : rule__SmallerEqual__Group__1__Impl rule__SmallerEqual__Group__2 ;
    public final void rule__SmallerEqual__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2911:1: ( rule__SmallerEqual__Group__1__Impl rule__SmallerEqual__Group__2 )
            // InternalFirstOrderLogic.g:2912:2: rule__SmallerEqual__Group__1__Impl rule__SmallerEqual__Group__2
            {
            pushFollow(FOLLOW_25);
            rule__SmallerEqual__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SmallerEqual__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SmallerEqual__Group__1"


    // $ANTLR start "rule__SmallerEqual__Group__1__Impl"
    // InternalFirstOrderLogic.g:2919:1: rule__SmallerEqual__Group__1__Impl : ( ( rule__SmallerEqual__LeftAssignment_1 ) ) ;
    public final void rule__SmallerEqual__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2923:1: ( ( ( rule__SmallerEqual__LeftAssignment_1 ) ) )
            // InternalFirstOrderLogic.g:2924:1: ( ( rule__SmallerEqual__LeftAssignment_1 ) )
            {
            // InternalFirstOrderLogic.g:2924:1: ( ( rule__SmallerEqual__LeftAssignment_1 ) )
            // InternalFirstOrderLogic.g:2925:2: ( rule__SmallerEqual__LeftAssignment_1 )
            {
             before(grammarAccess.getSmallerEqualAccess().getLeftAssignment_1()); 
            // InternalFirstOrderLogic.g:2926:2: ( rule__SmallerEqual__LeftAssignment_1 )
            // InternalFirstOrderLogic.g:2926:3: rule__SmallerEqual__LeftAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__SmallerEqual__LeftAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getSmallerEqualAccess().getLeftAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SmallerEqual__Group__1__Impl"


    // $ANTLR start "rule__SmallerEqual__Group__2"
    // InternalFirstOrderLogic.g:2934:1: rule__SmallerEqual__Group__2 : rule__SmallerEqual__Group__2__Impl rule__SmallerEqual__Group__3 ;
    public final void rule__SmallerEqual__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2938:1: ( rule__SmallerEqual__Group__2__Impl rule__SmallerEqual__Group__3 )
            // InternalFirstOrderLogic.g:2939:2: rule__SmallerEqual__Group__2__Impl rule__SmallerEqual__Group__3
            {
            pushFollow(FOLLOW_24);
            rule__SmallerEqual__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SmallerEqual__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SmallerEqual__Group__2"


    // $ANTLR start "rule__SmallerEqual__Group__2__Impl"
    // InternalFirstOrderLogic.g:2946:1: rule__SmallerEqual__Group__2__Impl : ( ',' ) ;
    public final void rule__SmallerEqual__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2950:1: ( ( ',' ) )
            // InternalFirstOrderLogic.g:2951:1: ( ',' )
            {
            // InternalFirstOrderLogic.g:2951:1: ( ',' )
            // InternalFirstOrderLogic.g:2952:2: ','
            {
             before(grammarAccess.getSmallerEqualAccess().getCommaKeyword_2()); 
            match(input,27,FOLLOW_2); 
             after(grammarAccess.getSmallerEqualAccess().getCommaKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SmallerEqual__Group__2__Impl"


    // $ANTLR start "rule__SmallerEqual__Group__3"
    // InternalFirstOrderLogic.g:2961:1: rule__SmallerEqual__Group__3 : rule__SmallerEqual__Group__3__Impl rule__SmallerEqual__Group__4 ;
    public final void rule__SmallerEqual__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2965:1: ( rule__SmallerEqual__Group__3__Impl rule__SmallerEqual__Group__4 )
            // InternalFirstOrderLogic.g:2966:2: rule__SmallerEqual__Group__3__Impl rule__SmallerEqual__Group__4
            {
            pushFollow(FOLLOW_23);
            rule__SmallerEqual__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SmallerEqual__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SmallerEqual__Group__3"


    // $ANTLR start "rule__SmallerEqual__Group__3__Impl"
    // InternalFirstOrderLogic.g:2973:1: rule__SmallerEqual__Group__3__Impl : ( ( rule__SmallerEqual__RightAssignment_3 ) ) ;
    public final void rule__SmallerEqual__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2977:1: ( ( ( rule__SmallerEqual__RightAssignment_3 ) ) )
            // InternalFirstOrderLogic.g:2978:1: ( ( rule__SmallerEqual__RightAssignment_3 ) )
            {
            // InternalFirstOrderLogic.g:2978:1: ( ( rule__SmallerEqual__RightAssignment_3 ) )
            // InternalFirstOrderLogic.g:2979:2: ( rule__SmallerEqual__RightAssignment_3 )
            {
             before(grammarAccess.getSmallerEqualAccess().getRightAssignment_3()); 
            // InternalFirstOrderLogic.g:2980:2: ( rule__SmallerEqual__RightAssignment_3 )
            // InternalFirstOrderLogic.g:2980:3: rule__SmallerEqual__RightAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__SmallerEqual__RightAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getSmallerEqualAccess().getRightAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SmallerEqual__Group__3__Impl"


    // $ANTLR start "rule__SmallerEqual__Group__4"
    // InternalFirstOrderLogic.g:2988:1: rule__SmallerEqual__Group__4 : rule__SmallerEqual__Group__4__Impl ;
    public final void rule__SmallerEqual__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2992:1: ( rule__SmallerEqual__Group__4__Impl )
            // InternalFirstOrderLogic.g:2993:2: rule__SmallerEqual__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__SmallerEqual__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SmallerEqual__Group__4"


    // $ANTLR start "rule__SmallerEqual__Group__4__Impl"
    // InternalFirstOrderLogic.g:2999:1: rule__SmallerEqual__Group__4__Impl : ( ')' ) ;
    public final void rule__SmallerEqual__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3003:1: ( ( ')' ) )
            // InternalFirstOrderLogic.g:3004:1: ( ')' )
            {
            // InternalFirstOrderLogic.g:3004:1: ( ')' )
            // InternalFirstOrderLogic.g:3005:2: ')'
            {
             before(grammarAccess.getSmallerEqualAccess().getRightParenthesisKeyword_4()); 
            match(input,25,FOLLOW_2); 
             after(grammarAccess.getSmallerEqualAccess().getRightParenthesisKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SmallerEqual__Group__4__Impl"


    // $ANTLR start "rule__IsEmpty__Group__0"
    // InternalFirstOrderLogic.g:3015:1: rule__IsEmpty__Group__0 : rule__IsEmpty__Group__0__Impl rule__IsEmpty__Group__1 ;
    public final void rule__IsEmpty__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3019:1: ( rule__IsEmpty__Group__0__Impl rule__IsEmpty__Group__1 )
            // InternalFirstOrderLogic.g:3020:2: rule__IsEmpty__Group__0__Impl rule__IsEmpty__Group__1
            {
            pushFollow(FOLLOW_24);
            rule__IsEmpty__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__IsEmpty__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IsEmpty__Group__0"


    // $ANTLR start "rule__IsEmpty__Group__0__Impl"
    // InternalFirstOrderLogic.g:3027:1: rule__IsEmpty__Group__0__Impl : ( 'isEmpty(' ) ;
    public final void rule__IsEmpty__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3031:1: ( ( 'isEmpty(' ) )
            // InternalFirstOrderLogic.g:3032:1: ( 'isEmpty(' )
            {
            // InternalFirstOrderLogic.g:3032:1: ( 'isEmpty(' )
            // InternalFirstOrderLogic.g:3033:2: 'isEmpty('
            {
             before(grammarAccess.getIsEmptyAccess().getIsEmptyKeyword_0()); 
            match(input,32,FOLLOW_2); 
             after(grammarAccess.getIsEmptyAccess().getIsEmptyKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IsEmpty__Group__0__Impl"


    // $ANTLR start "rule__IsEmpty__Group__1"
    // InternalFirstOrderLogic.g:3042:1: rule__IsEmpty__Group__1 : rule__IsEmpty__Group__1__Impl rule__IsEmpty__Group__2 ;
    public final void rule__IsEmpty__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3046:1: ( rule__IsEmpty__Group__1__Impl rule__IsEmpty__Group__2 )
            // InternalFirstOrderLogic.g:3047:2: rule__IsEmpty__Group__1__Impl rule__IsEmpty__Group__2
            {
            pushFollow(FOLLOW_23);
            rule__IsEmpty__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__IsEmpty__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IsEmpty__Group__1"


    // $ANTLR start "rule__IsEmpty__Group__1__Impl"
    // InternalFirstOrderLogic.g:3054:1: rule__IsEmpty__Group__1__Impl : ( ( rule__IsEmpty__TermAssignment_1 ) ) ;
    public final void rule__IsEmpty__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3058:1: ( ( ( rule__IsEmpty__TermAssignment_1 ) ) )
            // InternalFirstOrderLogic.g:3059:1: ( ( rule__IsEmpty__TermAssignment_1 ) )
            {
            // InternalFirstOrderLogic.g:3059:1: ( ( rule__IsEmpty__TermAssignment_1 ) )
            // InternalFirstOrderLogic.g:3060:2: ( rule__IsEmpty__TermAssignment_1 )
            {
             before(grammarAccess.getIsEmptyAccess().getTermAssignment_1()); 
            // InternalFirstOrderLogic.g:3061:2: ( rule__IsEmpty__TermAssignment_1 )
            // InternalFirstOrderLogic.g:3061:3: rule__IsEmpty__TermAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__IsEmpty__TermAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getIsEmptyAccess().getTermAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IsEmpty__Group__1__Impl"


    // $ANTLR start "rule__IsEmpty__Group__2"
    // InternalFirstOrderLogic.g:3069:1: rule__IsEmpty__Group__2 : rule__IsEmpty__Group__2__Impl ;
    public final void rule__IsEmpty__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3073:1: ( rule__IsEmpty__Group__2__Impl )
            // InternalFirstOrderLogic.g:3074:2: rule__IsEmpty__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__IsEmpty__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IsEmpty__Group__2"


    // $ANTLR start "rule__IsEmpty__Group__2__Impl"
    // InternalFirstOrderLogic.g:3080:1: rule__IsEmpty__Group__2__Impl : ( ')' ) ;
    public final void rule__IsEmpty__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3084:1: ( ( ')' ) )
            // InternalFirstOrderLogic.g:3085:1: ( ')' )
            {
            // InternalFirstOrderLogic.g:3085:1: ( ')' )
            // InternalFirstOrderLogic.g:3086:2: ')'
            {
             before(grammarAccess.getIsEmptyAccess().getRightParenthesisKeyword_2()); 
            match(input,25,FOLLOW_2); 
             after(grammarAccess.getIsEmptyAccess().getRightParenthesisKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IsEmpty__Group__2__Impl"


    // $ANTLR start "rule__IsInstanceOf__Group__0"
    // InternalFirstOrderLogic.g:3096:1: rule__IsInstanceOf__Group__0 : rule__IsInstanceOf__Group__0__Impl rule__IsInstanceOf__Group__1 ;
    public final void rule__IsInstanceOf__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3100:1: ( rule__IsInstanceOf__Group__0__Impl rule__IsInstanceOf__Group__1 )
            // InternalFirstOrderLogic.g:3101:2: rule__IsInstanceOf__Group__0__Impl rule__IsInstanceOf__Group__1
            {
            pushFollow(FOLLOW_24);
            rule__IsInstanceOf__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__IsInstanceOf__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IsInstanceOf__Group__0"


    // $ANTLR start "rule__IsInstanceOf__Group__0__Impl"
    // InternalFirstOrderLogic.g:3108:1: rule__IsInstanceOf__Group__0__Impl : ( 'isInstanceOf(' ) ;
    public final void rule__IsInstanceOf__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3112:1: ( ( 'isInstanceOf(' ) )
            // InternalFirstOrderLogic.g:3113:1: ( 'isInstanceOf(' )
            {
            // InternalFirstOrderLogic.g:3113:1: ( 'isInstanceOf(' )
            // InternalFirstOrderLogic.g:3114:2: 'isInstanceOf('
            {
             before(grammarAccess.getIsInstanceOfAccess().getIsInstanceOfKeyword_0()); 
            match(input,33,FOLLOW_2); 
             after(grammarAccess.getIsInstanceOfAccess().getIsInstanceOfKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IsInstanceOf__Group__0__Impl"


    // $ANTLR start "rule__IsInstanceOf__Group__1"
    // InternalFirstOrderLogic.g:3123:1: rule__IsInstanceOf__Group__1 : rule__IsInstanceOf__Group__1__Impl rule__IsInstanceOf__Group__2 ;
    public final void rule__IsInstanceOf__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3127:1: ( rule__IsInstanceOf__Group__1__Impl rule__IsInstanceOf__Group__2 )
            // InternalFirstOrderLogic.g:3128:2: rule__IsInstanceOf__Group__1__Impl rule__IsInstanceOf__Group__2
            {
            pushFollow(FOLLOW_25);
            rule__IsInstanceOf__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__IsInstanceOf__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IsInstanceOf__Group__1"


    // $ANTLR start "rule__IsInstanceOf__Group__1__Impl"
    // InternalFirstOrderLogic.g:3135:1: rule__IsInstanceOf__Group__1__Impl : ( ( rule__IsInstanceOf__TermAssignment_1 ) ) ;
    public final void rule__IsInstanceOf__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3139:1: ( ( ( rule__IsInstanceOf__TermAssignment_1 ) ) )
            // InternalFirstOrderLogic.g:3140:1: ( ( rule__IsInstanceOf__TermAssignment_1 ) )
            {
            // InternalFirstOrderLogic.g:3140:1: ( ( rule__IsInstanceOf__TermAssignment_1 ) )
            // InternalFirstOrderLogic.g:3141:2: ( rule__IsInstanceOf__TermAssignment_1 )
            {
             before(grammarAccess.getIsInstanceOfAccess().getTermAssignment_1()); 
            // InternalFirstOrderLogic.g:3142:2: ( rule__IsInstanceOf__TermAssignment_1 )
            // InternalFirstOrderLogic.g:3142:3: rule__IsInstanceOf__TermAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__IsInstanceOf__TermAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getIsInstanceOfAccess().getTermAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IsInstanceOf__Group__1__Impl"


    // $ANTLR start "rule__IsInstanceOf__Group__2"
    // InternalFirstOrderLogic.g:3150:1: rule__IsInstanceOf__Group__2 : rule__IsInstanceOf__Group__2__Impl rule__IsInstanceOf__Group__3 ;
    public final void rule__IsInstanceOf__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3154:1: ( rule__IsInstanceOf__Group__2__Impl rule__IsInstanceOf__Group__3 )
            // InternalFirstOrderLogic.g:3155:2: rule__IsInstanceOf__Group__2__Impl rule__IsInstanceOf__Group__3
            {
            pushFollow(FOLLOW_7);
            rule__IsInstanceOf__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__IsInstanceOf__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IsInstanceOf__Group__2"


    // $ANTLR start "rule__IsInstanceOf__Group__2__Impl"
    // InternalFirstOrderLogic.g:3162:1: rule__IsInstanceOf__Group__2__Impl : ( ',' ) ;
    public final void rule__IsInstanceOf__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3166:1: ( ( ',' ) )
            // InternalFirstOrderLogic.g:3167:1: ( ',' )
            {
            // InternalFirstOrderLogic.g:3167:1: ( ',' )
            // InternalFirstOrderLogic.g:3168:2: ','
            {
             before(grammarAccess.getIsInstanceOfAccess().getCommaKeyword_2()); 
            match(input,27,FOLLOW_2); 
             after(grammarAccess.getIsInstanceOfAccess().getCommaKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IsInstanceOf__Group__2__Impl"


    // $ANTLR start "rule__IsInstanceOf__Group__3"
    // InternalFirstOrderLogic.g:3177:1: rule__IsInstanceOf__Group__3 : rule__IsInstanceOf__Group__3__Impl rule__IsInstanceOf__Group__4 ;
    public final void rule__IsInstanceOf__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3181:1: ( rule__IsInstanceOf__Group__3__Impl rule__IsInstanceOf__Group__4 )
            // InternalFirstOrderLogic.g:3182:2: rule__IsInstanceOf__Group__3__Impl rule__IsInstanceOf__Group__4
            {
            pushFollow(FOLLOW_23);
            rule__IsInstanceOf__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__IsInstanceOf__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IsInstanceOf__Group__3"


    // $ANTLR start "rule__IsInstanceOf__Group__3__Impl"
    // InternalFirstOrderLogic.g:3189:1: rule__IsInstanceOf__Group__3__Impl : ( ( rule__IsInstanceOf__TypeAssignment_3 ) ) ;
    public final void rule__IsInstanceOf__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3193:1: ( ( ( rule__IsInstanceOf__TypeAssignment_3 ) ) )
            // InternalFirstOrderLogic.g:3194:1: ( ( rule__IsInstanceOf__TypeAssignment_3 ) )
            {
            // InternalFirstOrderLogic.g:3194:1: ( ( rule__IsInstanceOf__TypeAssignment_3 ) )
            // InternalFirstOrderLogic.g:3195:2: ( rule__IsInstanceOf__TypeAssignment_3 )
            {
             before(grammarAccess.getIsInstanceOfAccess().getTypeAssignment_3()); 
            // InternalFirstOrderLogic.g:3196:2: ( rule__IsInstanceOf__TypeAssignment_3 )
            // InternalFirstOrderLogic.g:3196:3: rule__IsInstanceOf__TypeAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__IsInstanceOf__TypeAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getIsInstanceOfAccess().getTypeAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IsInstanceOf__Group__3__Impl"


    // $ANTLR start "rule__IsInstanceOf__Group__4"
    // InternalFirstOrderLogic.g:3204:1: rule__IsInstanceOf__Group__4 : rule__IsInstanceOf__Group__4__Impl ;
    public final void rule__IsInstanceOf__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3208:1: ( rule__IsInstanceOf__Group__4__Impl )
            // InternalFirstOrderLogic.g:3209:2: rule__IsInstanceOf__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__IsInstanceOf__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IsInstanceOf__Group__4"


    // $ANTLR start "rule__IsInstanceOf__Group__4__Impl"
    // InternalFirstOrderLogic.g:3215:1: rule__IsInstanceOf__Group__4__Impl : ( ')' ) ;
    public final void rule__IsInstanceOf__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3219:1: ( ( ')' ) )
            // InternalFirstOrderLogic.g:3220:1: ( ')' )
            {
            // InternalFirstOrderLogic.g:3220:1: ( ')' )
            // InternalFirstOrderLogic.g:3221:2: ')'
            {
             before(grammarAccess.getIsInstanceOfAccess().getRightParenthesisKeyword_4()); 
            match(input,25,FOLLOW_2); 
             after(grammarAccess.getIsInstanceOfAccess().getRightParenthesisKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IsInstanceOf__Group__4__Impl"


    // $ANTLR start "rule__ForAll__Group__0"
    // InternalFirstOrderLogic.g:3231:1: rule__ForAll__Group__0 : rule__ForAll__Group__0__Impl rule__ForAll__Group__1 ;
    public final void rule__ForAll__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3235:1: ( rule__ForAll__Group__0__Impl rule__ForAll__Group__1 )
            // InternalFirstOrderLogic.g:3236:2: rule__ForAll__Group__0__Impl rule__ForAll__Group__1
            {
            pushFollow(FOLLOW_26);
            rule__ForAll__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ForAll__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ForAll__Group__0"


    // $ANTLR start "rule__ForAll__Group__0__Impl"
    // InternalFirstOrderLogic.g:3243:1: rule__ForAll__Group__0__Impl : ( () ) ;
    public final void rule__ForAll__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3247:1: ( ( () ) )
            // InternalFirstOrderLogic.g:3248:1: ( () )
            {
            // InternalFirstOrderLogic.g:3248:1: ( () )
            // InternalFirstOrderLogic.g:3249:2: ()
            {
             before(grammarAccess.getForAllAccess().getForAllAction_0()); 
            // InternalFirstOrderLogic.g:3250:2: ()
            // InternalFirstOrderLogic.g:3250:3: 
            {
            }

             after(grammarAccess.getForAllAccess().getForAllAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ForAll__Group__0__Impl"


    // $ANTLR start "rule__ForAll__Group__1"
    // InternalFirstOrderLogic.g:3258:1: rule__ForAll__Group__1 : rule__ForAll__Group__1__Impl rule__ForAll__Group__2 ;
    public final void rule__ForAll__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3262:1: ( rule__ForAll__Group__1__Impl rule__ForAll__Group__2 )
            // InternalFirstOrderLogic.g:3263:2: rule__ForAll__Group__1__Impl rule__ForAll__Group__2
            {
            pushFollow(FOLLOW_7);
            rule__ForAll__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ForAll__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ForAll__Group__1"


    // $ANTLR start "rule__ForAll__Group__1__Impl"
    // InternalFirstOrderLogic.g:3270:1: rule__ForAll__Group__1__Impl : ( 'forAll(' ) ;
    public final void rule__ForAll__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3274:1: ( ( 'forAll(' ) )
            // InternalFirstOrderLogic.g:3275:1: ( 'forAll(' )
            {
            // InternalFirstOrderLogic.g:3275:1: ( 'forAll(' )
            // InternalFirstOrderLogic.g:3276:2: 'forAll('
            {
             before(grammarAccess.getForAllAccess().getForAllKeyword_1()); 
            match(input,34,FOLLOW_2); 
             after(grammarAccess.getForAllAccess().getForAllKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ForAll__Group__1__Impl"


    // $ANTLR start "rule__ForAll__Group__2"
    // InternalFirstOrderLogic.g:3285:1: rule__ForAll__Group__2 : rule__ForAll__Group__2__Impl rule__ForAll__Group__3 ;
    public final void rule__ForAll__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3289:1: ( rule__ForAll__Group__2__Impl rule__ForAll__Group__3 )
            // InternalFirstOrderLogic.g:3290:2: rule__ForAll__Group__2__Impl rule__ForAll__Group__3
            {
            pushFollow(FOLLOW_27);
            rule__ForAll__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ForAll__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ForAll__Group__2"


    // $ANTLR start "rule__ForAll__Group__2__Impl"
    // InternalFirstOrderLogic.g:3297:1: rule__ForAll__Group__2__Impl : ( ( rule__ForAll__NameAssignment_2 ) ) ;
    public final void rule__ForAll__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3301:1: ( ( ( rule__ForAll__NameAssignment_2 ) ) )
            // InternalFirstOrderLogic.g:3302:1: ( ( rule__ForAll__NameAssignment_2 ) )
            {
            // InternalFirstOrderLogic.g:3302:1: ( ( rule__ForAll__NameAssignment_2 ) )
            // InternalFirstOrderLogic.g:3303:2: ( rule__ForAll__NameAssignment_2 )
            {
             before(grammarAccess.getForAllAccess().getNameAssignment_2()); 
            // InternalFirstOrderLogic.g:3304:2: ( rule__ForAll__NameAssignment_2 )
            // InternalFirstOrderLogic.g:3304:3: rule__ForAll__NameAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__ForAll__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getForAllAccess().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ForAll__Group__2__Impl"


    // $ANTLR start "rule__ForAll__Group__3"
    // InternalFirstOrderLogic.g:3312:1: rule__ForAll__Group__3 : rule__ForAll__Group__3__Impl rule__ForAll__Group__4 ;
    public final void rule__ForAll__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3316:1: ( rule__ForAll__Group__3__Impl rule__ForAll__Group__4 )
            // InternalFirstOrderLogic.g:3317:2: rule__ForAll__Group__3__Impl rule__ForAll__Group__4
            {
            pushFollow(FOLLOW_24);
            rule__ForAll__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ForAll__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ForAll__Group__3"


    // $ANTLR start "rule__ForAll__Group__3__Impl"
    // InternalFirstOrderLogic.g:3324:1: rule__ForAll__Group__3__Impl : ( 'in' ) ;
    public final void rule__ForAll__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3328:1: ( ( 'in' ) )
            // InternalFirstOrderLogic.g:3329:1: ( 'in' )
            {
            // InternalFirstOrderLogic.g:3329:1: ( 'in' )
            // InternalFirstOrderLogic.g:3330:2: 'in'
            {
             before(grammarAccess.getForAllAccess().getInKeyword_3()); 
            match(input,35,FOLLOW_2); 
             after(grammarAccess.getForAllAccess().getInKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ForAll__Group__3__Impl"


    // $ANTLR start "rule__ForAll__Group__4"
    // InternalFirstOrderLogic.g:3339:1: rule__ForAll__Group__4 : rule__ForAll__Group__4__Impl rule__ForAll__Group__5 ;
    public final void rule__ForAll__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3343:1: ( rule__ForAll__Group__4__Impl rule__ForAll__Group__5 )
            // InternalFirstOrderLogic.g:3344:2: rule__ForAll__Group__4__Impl rule__ForAll__Group__5
            {
            pushFollow(FOLLOW_10);
            rule__ForAll__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ForAll__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ForAll__Group__4"


    // $ANTLR start "rule__ForAll__Group__4__Impl"
    // InternalFirstOrderLogic.g:3351:1: rule__ForAll__Group__4__Impl : ( ( rule__ForAll__IterationAssignment_4 ) ) ;
    public final void rule__ForAll__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3355:1: ( ( ( rule__ForAll__IterationAssignment_4 ) ) )
            // InternalFirstOrderLogic.g:3356:1: ( ( rule__ForAll__IterationAssignment_4 ) )
            {
            // InternalFirstOrderLogic.g:3356:1: ( ( rule__ForAll__IterationAssignment_4 ) )
            // InternalFirstOrderLogic.g:3357:2: ( rule__ForAll__IterationAssignment_4 )
            {
             before(grammarAccess.getForAllAccess().getIterationAssignment_4()); 
            // InternalFirstOrderLogic.g:3358:2: ( rule__ForAll__IterationAssignment_4 )
            // InternalFirstOrderLogic.g:3358:3: rule__ForAll__IterationAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__ForAll__IterationAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getForAllAccess().getIterationAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ForAll__Group__4__Impl"


    // $ANTLR start "rule__ForAll__Group__5"
    // InternalFirstOrderLogic.g:3366:1: rule__ForAll__Group__5 : rule__ForAll__Group__5__Impl rule__ForAll__Group__6 ;
    public final void rule__ForAll__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3370:1: ( rule__ForAll__Group__5__Impl rule__ForAll__Group__6 )
            // InternalFirstOrderLogic.g:3371:2: rule__ForAll__Group__5__Impl rule__ForAll__Group__6
            {
            pushFollow(FOLLOW_11);
            rule__ForAll__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ForAll__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ForAll__Group__5"


    // $ANTLR start "rule__ForAll__Group__5__Impl"
    // InternalFirstOrderLogic.g:3378:1: rule__ForAll__Group__5__Impl : ( ':' ) ;
    public final void rule__ForAll__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3382:1: ( ( ':' ) )
            // InternalFirstOrderLogic.g:3383:1: ( ':' )
            {
            // InternalFirstOrderLogic.g:3383:1: ( ':' )
            // InternalFirstOrderLogic.g:3384:2: ':'
            {
             before(grammarAccess.getForAllAccess().getColonKeyword_5()); 
            match(input,18,FOLLOW_2); 
             after(grammarAccess.getForAllAccess().getColonKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ForAll__Group__5__Impl"


    // $ANTLR start "rule__ForAll__Group__6"
    // InternalFirstOrderLogic.g:3393:1: rule__ForAll__Group__6 : rule__ForAll__Group__6__Impl rule__ForAll__Group__7 ;
    public final void rule__ForAll__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3397:1: ( rule__ForAll__Group__6__Impl rule__ForAll__Group__7 )
            // InternalFirstOrderLogic.g:3398:2: rule__ForAll__Group__6__Impl rule__ForAll__Group__7
            {
            pushFollow(FOLLOW_23);
            rule__ForAll__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ForAll__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ForAll__Group__6"


    // $ANTLR start "rule__ForAll__Group__6__Impl"
    // InternalFirstOrderLogic.g:3405:1: rule__ForAll__Group__6__Impl : ( ( rule__ForAll__FormulaAssignment_6 ) ) ;
    public final void rule__ForAll__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3409:1: ( ( ( rule__ForAll__FormulaAssignment_6 ) ) )
            // InternalFirstOrderLogic.g:3410:1: ( ( rule__ForAll__FormulaAssignment_6 ) )
            {
            // InternalFirstOrderLogic.g:3410:1: ( ( rule__ForAll__FormulaAssignment_6 ) )
            // InternalFirstOrderLogic.g:3411:2: ( rule__ForAll__FormulaAssignment_6 )
            {
             before(grammarAccess.getForAllAccess().getFormulaAssignment_6()); 
            // InternalFirstOrderLogic.g:3412:2: ( rule__ForAll__FormulaAssignment_6 )
            // InternalFirstOrderLogic.g:3412:3: rule__ForAll__FormulaAssignment_6
            {
            pushFollow(FOLLOW_2);
            rule__ForAll__FormulaAssignment_6();

            state._fsp--;


            }

             after(grammarAccess.getForAllAccess().getFormulaAssignment_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ForAll__Group__6__Impl"


    // $ANTLR start "rule__ForAll__Group__7"
    // InternalFirstOrderLogic.g:3420:1: rule__ForAll__Group__7 : rule__ForAll__Group__7__Impl ;
    public final void rule__ForAll__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3424:1: ( rule__ForAll__Group__7__Impl )
            // InternalFirstOrderLogic.g:3425:2: rule__ForAll__Group__7__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ForAll__Group__7__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ForAll__Group__7"


    // $ANTLR start "rule__ForAll__Group__7__Impl"
    // InternalFirstOrderLogic.g:3431:1: rule__ForAll__Group__7__Impl : ( ')' ) ;
    public final void rule__ForAll__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3435:1: ( ( ')' ) )
            // InternalFirstOrderLogic.g:3436:1: ( ')' )
            {
            // InternalFirstOrderLogic.g:3436:1: ( ')' )
            // InternalFirstOrderLogic.g:3437:2: ')'
            {
             before(grammarAccess.getForAllAccess().getRightParenthesisKeyword_7()); 
            match(input,25,FOLLOW_2); 
             after(grammarAccess.getForAllAccess().getRightParenthesisKeyword_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ForAll__Group__7__Impl"


    // $ANTLR start "rule__Exists__Group__0"
    // InternalFirstOrderLogic.g:3447:1: rule__Exists__Group__0 : rule__Exists__Group__0__Impl rule__Exists__Group__1 ;
    public final void rule__Exists__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3451:1: ( rule__Exists__Group__0__Impl rule__Exists__Group__1 )
            // InternalFirstOrderLogic.g:3452:2: rule__Exists__Group__0__Impl rule__Exists__Group__1
            {
            pushFollow(FOLLOW_28);
            rule__Exists__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Exists__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Exists__Group__0"


    // $ANTLR start "rule__Exists__Group__0__Impl"
    // InternalFirstOrderLogic.g:3459:1: rule__Exists__Group__0__Impl : ( () ) ;
    public final void rule__Exists__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3463:1: ( ( () ) )
            // InternalFirstOrderLogic.g:3464:1: ( () )
            {
            // InternalFirstOrderLogic.g:3464:1: ( () )
            // InternalFirstOrderLogic.g:3465:2: ()
            {
             before(grammarAccess.getExistsAccess().getExistsAction_0()); 
            // InternalFirstOrderLogic.g:3466:2: ()
            // InternalFirstOrderLogic.g:3466:3: 
            {
            }

             after(grammarAccess.getExistsAccess().getExistsAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Exists__Group__0__Impl"


    // $ANTLR start "rule__Exists__Group__1"
    // InternalFirstOrderLogic.g:3474:1: rule__Exists__Group__1 : rule__Exists__Group__1__Impl rule__Exists__Group__2 ;
    public final void rule__Exists__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3478:1: ( rule__Exists__Group__1__Impl rule__Exists__Group__2 )
            // InternalFirstOrderLogic.g:3479:2: rule__Exists__Group__1__Impl rule__Exists__Group__2
            {
            pushFollow(FOLLOW_7);
            rule__Exists__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Exists__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Exists__Group__1"


    // $ANTLR start "rule__Exists__Group__1__Impl"
    // InternalFirstOrderLogic.g:3486:1: rule__Exists__Group__1__Impl : ( 'exists(' ) ;
    public final void rule__Exists__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3490:1: ( ( 'exists(' ) )
            // InternalFirstOrderLogic.g:3491:1: ( 'exists(' )
            {
            // InternalFirstOrderLogic.g:3491:1: ( 'exists(' )
            // InternalFirstOrderLogic.g:3492:2: 'exists('
            {
             before(grammarAccess.getExistsAccess().getExistsKeyword_1()); 
            match(input,36,FOLLOW_2); 
             after(grammarAccess.getExistsAccess().getExistsKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Exists__Group__1__Impl"


    // $ANTLR start "rule__Exists__Group__2"
    // InternalFirstOrderLogic.g:3501:1: rule__Exists__Group__2 : rule__Exists__Group__2__Impl rule__Exists__Group__3 ;
    public final void rule__Exists__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3505:1: ( rule__Exists__Group__2__Impl rule__Exists__Group__3 )
            // InternalFirstOrderLogic.g:3506:2: rule__Exists__Group__2__Impl rule__Exists__Group__3
            {
            pushFollow(FOLLOW_27);
            rule__Exists__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Exists__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Exists__Group__2"


    // $ANTLR start "rule__Exists__Group__2__Impl"
    // InternalFirstOrderLogic.g:3513:1: rule__Exists__Group__2__Impl : ( ( rule__Exists__NameAssignment_2 ) ) ;
    public final void rule__Exists__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3517:1: ( ( ( rule__Exists__NameAssignment_2 ) ) )
            // InternalFirstOrderLogic.g:3518:1: ( ( rule__Exists__NameAssignment_2 ) )
            {
            // InternalFirstOrderLogic.g:3518:1: ( ( rule__Exists__NameAssignment_2 ) )
            // InternalFirstOrderLogic.g:3519:2: ( rule__Exists__NameAssignment_2 )
            {
             before(grammarAccess.getExistsAccess().getNameAssignment_2()); 
            // InternalFirstOrderLogic.g:3520:2: ( rule__Exists__NameAssignment_2 )
            // InternalFirstOrderLogic.g:3520:3: rule__Exists__NameAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__Exists__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getExistsAccess().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Exists__Group__2__Impl"


    // $ANTLR start "rule__Exists__Group__3"
    // InternalFirstOrderLogic.g:3528:1: rule__Exists__Group__3 : rule__Exists__Group__3__Impl rule__Exists__Group__4 ;
    public final void rule__Exists__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3532:1: ( rule__Exists__Group__3__Impl rule__Exists__Group__4 )
            // InternalFirstOrderLogic.g:3533:2: rule__Exists__Group__3__Impl rule__Exists__Group__4
            {
            pushFollow(FOLLOW_24);
            rule__Exists__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Exists__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Exists__Group__3"


    // $ANTLR start "rule__Exists__Group__3__Impl"
    // InternalFirstOrderLogic.g:3540:1: rule__Exists__Group__3__Impl : ( 'in' ) ;
    public final void rule__Exists__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3544:1: ( ( 'in' ) )
            // InternalFirstOrderLogic.g:3545:1: ( 'in' )
            {
            // InternalFirstOrderLogic.g:3545:1: ( 'in' )
            // InternalFirstOrderLogic.g:3546:2: 'in'
            {
             before(grammarAccess.getExistsAccess().getInKeyword_3()); 
            match(input,35,FOLLOW_2); 
             after(grammarAccess.getExistsAccess().getInKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Exists__Group__3__Impl"


    // $ANTLR start "rule__Exists__Group__4"
    // InternalFirstOrderLogic.g:3555:1: rule__Exists__Group__4 : rule__Exists__Group__4__Impl rule__Exists__Group__5 ;
    public final void rule__Exists__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3559:1: ( rule__Exists__Group__4__Impl rule__Exists__Group__5 )
            // InternalFirstOrderLogic.g:3560:2: rule__Exists__Group__4__Impl rule__Exists__Group__5
            {
            pushFollow(FOLLOW_10);
            rule__Exists__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Exists__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Exists__Group__4"


    // $ANTLR start "rule__Exists__Group__4__Impl"
    // InternalFirstOrderLogic.g:3567:1: rule__Exists__Group__4__Impl : ( ( rule__Exists__IterationAssignment_4 ) ) ;
    public final void rule__Exists__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3571:1: ( ( ( rule__Exists__IterationAssignment_4 ) ) )
            // InternalFirstOrderLogic.g:3572:1: ( ( rule__Exists__IterationAssignment_4 ) )
            {
            // InternalFirstOrderLogic.g:3572:1: ( ( rule__Exists__IterationAssignment_4 ) )
            // InternalFirstOrderLogic.g:3573:2: ( rule__Exists__IterationAssignment_4 )
            {
             before(grammarAccess.getExistsAccess().getIterationAssignment_4()); 
            // InternalFirstOrderLogic.g:3574:2: ( rule__Exists__IterationAssignment_4 )
            // InternalFirstOrderLogic.g:3574:3: rule__Exists__IterationAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__Exists__IterationAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getExistsAccess().getIterationAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Exists__Group__4__Impl"


    // $ANTLR start "rule__Exists__Group__5"
    // InternalFirstOrderLogic.g:3582:1: rule__Exists__Group__5 : rule__Exists__Group__5__Impl rule__Exists__Group__6 ;
    public final void rule__Exists__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3586:1: ( rule__Exists__Group__5__Impl rule__Exists__Group__6 )
            // InternalFirstOrderLogic.g:3587:2: rule__Exists__Group__5__Impl rule__Exists__Group__6
            {
            pushFollow(FOLLOW_11);
            rule__Exists__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Exists__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Exists__Group__5"


    // $ANTLR start "rule__Exists__Group__5__Impl"
    // InternalFirstOrderLogic.g:3594:1: rule__Exists__Group__5__Impl : ( ':' ) ;
    public final void rule__Exists__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3598:1: ( ( ':' ) )
            // InternalFirstOrderLogic.g:3599:1: ( ':' )
            {
            // InternalFirstOrderLogic.g:3599:1: ( ':' )
            // InternalFirstOrderLogic.g:3600:2: ':'
            {
             before(grammarAccess.getExistsAccess().getColonKeyword_5()); 
            match(input,18,FOLLOW_2); 
             after(grammarAccess.getExistsAccess().getColonKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Exists__Group__5__Impl"


    // $ANTLR start "rule__Exists__Group__6"
    // InternalFirstOrderLogic.g:3609:1: rule__Exists__Group__6 : rule__Exists__Group__6__Impl rule__Exists__Group__7 ;
    public final void rule__Exists__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3613:1: ( rule__Exists__Group__6__Impl rule__Exists__Group__7 )
            // InternalFirstOrderLogic.g:3614:2: rule__Exists__Group__6__Impl rule__Exists__Group__7
            {
            pushFollow(FOLLOW_23);
            rule__Exists__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Exists__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Exists__Group__6"


    // $ANTLR start "rule__Exists__Group__6__Impl"
    // InternalFirstOrderLogic.g:3621:1: rule__Exists__Group__6__Impl : ( ( rule__Exists__FormulaAssignment_6 ) ) ;
    public final void rule__Exists__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3625:1: ( ( ( rule__Exists__FormulaAssignment_6 ) ) )
            // InternalFirstOrderLogic.g:3626:1: ( ( rule__Exists__FormulaAssignment_6 ) )
            {
            // InternalFirstOrderLogic.g:3626:1: ( ( rule__Exists__FormulaAssignment_6 ) )
            // InternalFirstOrderLogic.g:3627:2: ( rule__Exists__FormulaAssignment_6 )
            {
             before(grammarAccess.getExistsAccess().getFormulaAssignment_6()); 
            // InternalFirstOrderLogic.g:3628:2: ( rule__Exists__FormulaAssignment_6 )
            // InternalFirstOrderLogic.g:3628:3: rule__Exists__FormulaAssignment_6
            {
            pushFollow(FOLLOW_2);
            rule__Exists__FormulaAssignment_6();

            state._fsp--;


            }

             after(grammarAccess.getExistsAccess().getFormulaAssignment_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Exists__Group__6__Impl"


    // $ANTLR start "rule__Exists__Group__7"
    // InternalFirstOrderLogic.g:3636:1: rule__Exists__Group__7 : rule__Exists__Group__7__Impl ;
    public final void rule__Exists__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3640:1: ( rule__Exists__Group__7__Impl )
            // InternalFirstOrderLogic.g:3641:2: rule__Exists__Group__7__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Exists__Group__7__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Exists__Group__7"


    // $ANTLR start "rule__Exists__Group__7__Impl"
    // InternalFirstOrderLogic.g:3647:1: rule__Exists__Group__7__Impl : ( ')' ) ;
    public final void rule__Exists__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3651:1: ( ( ')' ) )
            // InternalFirstOrderLogic.g:3652:1: ( ')' )
            {
            // InternalFirstOrderLogic.g:3652:1: ( ')' )
            // InternalFirstOrderLogic.g:3653:2: ')'
            {
             before(grammarAccess.getExistsAccess().getRightParenthesisKeyword_7()); 
            match(input,25,FOLLOW_2); 
             after(grammarAccess.getExistsAccess().getRightParenthesisKeyword_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Exists__Group__7__Impl"


    // $ANTLR start "rule__BooleanExpression__Group_0__0"
    // InternalFirstOrderLogic.g:3663:1: rule__BooleanExpression__Group_0__0 : rule__BooleanExpression__Group_0__0__Impl rule__BooleanExpression__Group_0__1 ;
    public final void rule__BooleanExpression__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3667:1: ( rule__BooleanExpression__Group_0__0__Impl rule__BooleanExpression__Group_0__1 )
            // InternalFirstOrderLogic.g:3668:2: rule__BooleanExpression__Group_0__0__Impl rule__BooleanExpression__Group_0__1
            {
            pushFollow(FOLLOW_11);
            rule__BooleanExpression__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__BooleanExpression__Group_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BooleanExpression__Group_0__0"


    // $ANTLR start "rule__BooleanExpression__Group_0__0__Impl"
    // InternalFirstOrderLogic.g:3675:1: rule__BooleanExpression__Group_0__0__Impl : ( '(' ) ;
    public final void rule__BooleanExpression__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3679:1: ( ( '(' ) )
            // InternalFirstOrderLogic.g:3680:1: ( '(' )
            {
            // InternalFirstOrderLogic.g:3680:1: ( '(' )
            // InternalFirstOrderLogic.g:3681:2: '('
            {
             before(grammarAccess.getBooleanExpressionAccess().getLeftParenthesisKeyword_0_0()); 
            match(input,37,FOLLOW_2); 
             after(grammarAccess.getBooleanExpressionAccess().getLeftParenthesisKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BooleanExpression__Group_0__0__Impl"


    // $ANTLR start "rule__BooleanExpression__Group_0__1"
    // InternalFirstOrderLogic.g:3690:1: rule__BooleanExpression__Group_0__1 : rule__BooleanExpression__Group_0__1__Impl rule__BooleanExpression__Group_0__2 ;
    public final void rule__BooleanExpression__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3694:1: ( rule__BooleanExpression__Group_0__1__Impl rule__BooleanExpression__Group_0__2 )
            // InternalFirstOrderLogic.g:3695:2: rule__BooleanExpression__Group_0__1__Impl rule__BooleanExpression__Group_0__2
            {
            pushFollow(FOLLOW_23);
            rule__BooleanExpression__Group_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__BooleanExpression__Group_0__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BooleanExpression__Group_0__1"


    // $ANTLR start "rule__BooleanExpression__Group_0__1__Impl"
    // InternalFirstOrderLogic.g:3702:1: rule__BooleanExpression__Group_0__1__Impl : ( ruleFormula ) ;
    public final void rule__BooleanExpression__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3706:1: ( ( ruleFormula ) )
            // InternalFirstOrderLogic.g:3707:1: ( ruleFormula )
            {
            // InternalFirstOrderLogic.g:3707:1: ( ruleFormula )
            // InternalFirstOrderLogic.g:3708:2: ruleFormula
            {
             before(grammarAccess.getBooleanExpressionAccess().getFormulaParserRuleCall_0_1()); 
            pushFollow(FOLLOW_2);
            ruleFormula();

            state._fsp--;

             after(grammarAccess.getBooleanExpressionAccess().getFormulaParserRuleCall_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BooleanExpression__Group_0__1__Impl"


    // $ANTLR start "rule__BooleanExpression__Group_0__2"
    // InternalFirstOrderLogic.g:3717:1: rule__BooleanExpression__Group_0__2 : rule__BooleanExpression__Group_0__2__Impl ;
    public final void rule__BooleanExpression__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3721:1: ( rule__BooleanExpression__Group_0__2__Impl )
            // InternalFirstOrderLogic.g:3722:2: rule__BooleanExpression__Group_0__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__BooleanExpression__Group_0__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BooleanExpression__Group_0__2"


    // $ANTLR start "rule__BooleanExpression__Group_0__2__Impl"
    // InternalFirstOrderLogic.g:3728:1: rule__BooleanExpression__Group_0__2__Impl : ( ')' ) ;
    public final void rule__BooleanExpression__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3732:1: ( ( ')' ) )
            // InternalFirstOrderLogic.g:3733:1: ( ')' )
            {
            // InternalFirstOrderLogic.g:3733:1: ( ')' )
            // InternalFirstOrderLogic.g:3734:2: ')'
            {
             before(grammarAccess.getBooleanExpressionAccess().getRightParenthesisKeyword_0_2()); 
            match(input,25,FOLLOW_2); 
             after(grammarAccess.getBooleanExpressionAccess().getRightParenthesisKeyword_0_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BooleanExpression__Group_0__2__Impl"


    // $ANTLR start "rule__BoolConstant__Group__0"
    // InternalFirstOrderLogic.g:3744:1: rule__BoolConstant__Group__0 : rule__BoolConstant__Group__0__Impl rule__BoolConstant__Group__1 ;
    public final void rule__BoolConstant__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3748:1: ( rule__BoolConstant__Group__0__Impl rule__BoolConstant__Group__1 )
            // InternalFirstOrderLogic.g:3749:2: rule__BoolConstant__Group__0__Impl rule__BoolConstant__Group__1
            {
            pushFollow(FOLLOW_11);
            rule__BoolConstant__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__BoolConstant__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BoolConstant__Group__0"


    // $ANTLR start "rule__BoolConstant__Group__0__Impl"
    // InternalFirstOrderLogic.g:3756:1: rule__BoolConstant__Group__0__Impl : ( () ) ;
    public final void rule__BoolConstant__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3760:1: ( ( () ) )
            // InternalFirstOrderLogic.g:3761:1: ( () )
            {
            // InternalFirstOrderLogic.g:3761:1: ( () )
            // InternalFirstOrderLogic.g:3762:2: ()
            {
             before(grammarAccess.getBoolConstantAccess().getBoolConstantAction_0()); 
            // InternalFirstOrderLogic.g:3763:2: ()
            // InternalFirstOrderLogic.g:3763:3: 
            {
            }

             after(grammarAccess.getBoolConstantAccess().getBoolConstantAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BoolConstant__Group__0__Impl"


    // $ANTLR start "rule__BoolConstant__Group__1"
    // InternalFirstOrderLogic.g:3771:1: rule__BoolConstant__Group__1 : rule__BoolConstant__Group__1__Impl ;
    public final void rule__BoolConstant__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3775:1: ( rule__BoolConstant__Group__1__Impl )
            // InternalFirstOrderLogic.g:3776:2: rule__BoolConstant__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__BoolConstant__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BoolConstant__Group__1"


    // $ANTLR start "rule__BoolConstant__Group__1__Impl"
    // InternalFirstOrderLogic.g:3782:1: rule__BoolConstant__Group__1__Impl : ( ( rule__BoolConstant__ValueAssignment_1 ) ) ;
    public final void rule__BoolConstant__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3786:1: ( ( ( rule__BoolConstant__ValueAssignment_1 ) ) )
            // InternalFirstOrderLogic.g:3787:1: ( ( rule__BoolConstant__ValueAssignment_1 ) )
            {
            // InternalFirstOrderLogic.g:3787:1: ( ( rule__BoolConstant__ValueAssignment_1 ) )
            // InternalFirstOrderLogic.g:3788:2: ( rule__BoolConstant__ValueAssignment_1 )
            {
             before(grammarAccess.getBoolConstantAccess().getValueAssignment_1()); 
            // InternalFirstOrderLogic.g:3789:2: ( rule__BoolConstant__ValueAssignment_1 )
            // InternalFirstOrderLogic.g:3789:3: rule__BoolConstant__ValueAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__BoolConstant__ValueAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getBoolConstantAccess().getValueAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BoolConstant__Group__1__Impl"


    // $ANTLR start "rule__VariableRef__Group__0"
    // InternalFirstOrderLogic.g:3798:1: rule__VariableRef__Group__0 : rule__VariableRef__Group__0__Impl rule__VariableRef__Group__1 ;
    public final void rule__VariableRef__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3802:1: ( rule__VariableRef__Group__0__Impl rule__VariableRef__Group__1 )
            // InternalFirstOrderLogic.g:3803:2: rule__VariableRef__Group__0__Impl rule__VariableRef__Group__1
            {
            pushFollow(FOLLOW_7);
            rule__VariableRef__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__VariableRef__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariableRef__Group__0"


    // $ANTLR start "rule__VariableRef__Group__0__Impl"
    // InternalFirstOrderLogic.g:3810:1: rule__VariableRef__Group__0__Impl : ( () ) ;
    public final void rule__VariableRef__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3814:1: ( ( () ) )
            // InternalFirstOrderLogic.g:3815:1: ( () )
            {
            // InternalFirstOrderLogic.g:3815:1: ( () )
            // InternalFirstOrderLogic.g:3816:2: ()
            {
             before(grammarAccess.getVariableRefAccess().getVariableRefAction_0()); 
            // InternalFirstOrderLogic.g:3817:2: ()
            // InternalFirstOrderLogic.g:3817:3: 
            {
            }

             after(grammarAccess.getVariableRefAccess().getVariableRefAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariableRef__Group__0__Impl"


    // $ANTLR start "rule__VariableRef__Group__1"
    // InternalFirstOrderLogic.g:3825:1: rule__VariableRef__Group__1 : rule__VariableRef__Group__1__Impl rule__VariableRef__Group__2 ;
    public final void rule__VariableRef__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3829:1: ( rule__VariableRef__Group__1__Impl rule__VariableRef__Group__2 )
            // InternalFirstOrderLogic.g:3830:2: rule__VariableRef__Group__1__Impl rule__VariableRef__Group__2
            {
            pushFollow(FOLLOW_29);
            rule__VariableRef__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__VariableRef__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariableRef__Group__1"


    // $ANTLR start "rule__VariableRef__Group__1__Impl"
    // InternalFirstOrderLogic.g:3837:1: rule__VariableRef__Group__1__Impl : ( ( rule__VariableRef__NameAssignment_1 ) ) ;
    public final void rule__VariableRef__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3841:1: ( ( ( rule__VariableRef__NameAssignment_1 ) ) )
            // InternalFirstOrderLogic.g:3842:1: ( ( rule__VariableRef__NameAssignment_1 ) )
            {
            // InternalFirstOrderLogic.g:3842:1: ( ( rule__VariableRef__NameAssignment_1 ) )
            // InternalFirstOrderLogic.g:3843:2: ( rule__VariableRef__NameAssignment_1 )
            {
             before(grammarAccess.getVariableRefAccess().getNameAssignment_1()); 
            // InternalFirstOrderLogic.g:3844:2: ( rule__VariableRef__NameAssignment_1 )
            // InternalFirstOrderLogic.g:3844:3: rule__VariableRef__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__VariableRef__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getVariableRefAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariableRef__Group__1__Impl"


    // $ANTLR start "rule__VariableRef__Group__2"
    // InternalFirstOrderLogic.g:3852:1: rule__VariableRef__Group__2 : rule__VariableRef__Group__2__Impl ;
    public final void rule__VariableRef__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3856:1: ( rule__VariableRef__Group__2__Impl )
            // InternalFirstOrderLogic.g:3857:2: rule__VariableRef__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__VariableRef__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariableRef__Group__2"


    // $ANTLR start "rule__VariableRef__Group__2__Impl"
    // InternalFirstOrderLogic.g:3863:1: rule__VariableRef__Group__2__Impl : ( ( rule__VariableRef__GetAssignment_2 )? ) ;
    public final void rule__VariableRef__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3867:1: ( ( ( rule__VariableRef__GetAssignment_2 )? ) )
            // InternalFirstOrderLogic.g:3868:1: ( ( rule__VariableRef__GetAssignment_2 )? )
            {
            // InternalFirstOrderLogic.g:3868:1: ( ( rule__VariableRef__GetAssignment_2 )? )
            // InternalFirstOrderLogic.g:3869:2: ( rule__VariableRef__GetAssignment_2 )?
            {
             before(grammarAccess.getVariableRefAccess().getGetAssignment_2()); 
            // InternalFirstOrderLogic.g:3870:2: ( rule__VariableRef__GetAssignment_2 )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==38) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalFirstOrderLogic.g:3870:3: rule__VariableRef__GetAssignment_2
                    {
                    pushFollow(FOLLOW_2);
                    rule__VariableRef__GetAssignment_2();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getVariableRefAccess().getGetAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariableRef__Group__2__Impl"


    // $ANTLR start "rule__Get__Group__0"
    // InternalFirstOrderLogic.g:3879:1: rule__Get__Group__0 : rule__Get__Group__0__Impl rule__Get__Group__1 ;
    public final void rule__Get__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3883:1: ( rule__Get__Group__0__Impl rule__Get__Group__1 )
            // InternalFirstOrderLogic.g:3884:2: rule__Get__Group__0__Impl rule__Get__Group__1
            {
            pushFollow(FOLLOW_7);
            rule__Get__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Get__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Get__Group__0"


    // $ANTLR start "rule__Get__Group__0__Impl"
    // InternalFirstOrderLogic.g:3891:1: rule__Get__Group__0__Impl : ( '.' ) ;
    public final void rule__Get__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3895:1: ( ( '.' ) )
            // InternalFirstOrderLogic.g:3896:1: ( '.' )
            {
            // InternalFirstOrderLogic.g:3896:1: ( '.' )
            // InternalFirstOrderLogic.g:3897:2: '.'
            {
             before(grammarAccess.getGetAccess().getFullStopKeyword_0()); 
            match(input,38,FOLLOW_2); 
             after(grammarAccess.getGetAccess().getFullStopKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Get__Group__0__Impl"


    // $ANTLR start "rule__Get__Group__1"
    // InternalFirstOrderLogic.g:3906:1: rule__Get__Group__1 : rule__Get__Group__1__Impl rule__Get__Group__2 ;
    public final void rule__Get__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3910:1: ( rule__Get__Group__1__Impl rule__Get__Group__2 )
            // InternalFirstOrderLogic.g:3911:2: rule__Get__Group__1__Impl rule__Get__Group__2
            {
            pushFollow(FOLLOW_7);
            rule__Get__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Get__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Get__Group__1"


    // $ANTLR start "rule__Get__Group__1__Impl"
    // InternalFirstOrderLogic.g:3918:1: rule__Get__Group__1__Impl : ( ( rule__Get__Group_1__0 )? ) ;
    public final void rule__Get__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3922:1: ( ( ( rule__Get__Group_1__0 )? ) )
            // InternalFirstOrderLogic.g:3923:1: ( ( rule__Get__Group_1__0 )? )
            {
            // InternalFirstOrderLogic.g:3923:1: ( ( rule__Get__Group_1__0 )? )
            // InternalFirstOrderLogic.g:3924:2: ( rule__Get__Group_1__0 )?
            {
             before(grammarAccess.getGetAccess().getGroup_1()); 
            // InternalFirstOrderLogic.g:3925:2: ( rule__Get__Group_1__0 )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==RULE_ID) ) {
                int LA15_1 = input.LA(2);

                if ( (LA15_1==39) ) {
                    alt15=1;
                }
            }
            switch (alt15) {
                case 1 :
                    // InternalFirstOrderLogic.g:3925:3: rule__Get__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Get__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getGetAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Get__Group__1__Impl"


    // $ANTLR start "rule__Get__Group__2"
    // InternalFirstOrderLogic.g:3933:1: rule__Get__Group__2 : rule__Get__Group__2__Impl rule__Get__Group__3 ;
    public final void rule__Get__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3937:1: ( rule__Get__Group__2__Impl rule__Get__Group__3 )
            // InternalFirstOrderLogic.g:3938:2: rule__Get__Group__2__Impl rule__Get__Group__3
            {
            pushFollow(FOLLOW_29);
            rule__Get__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Get__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Get__Group__2"


    // $ANTLR start "rule__Get__Group__2__Impl"
    // InternalFirstOrderLogic.g:3945:1: rule__Get__Group__2__Impl : ( ( rule__Get__NameAssignment_2 ) ) ;
    public final void rule__Get__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3949:1: ( ( ( rule__Get__NameAssignment_2 ) ) )
            // InternalFirstOrderLogic.g:3950:1: ( ( rule__Get__NameAssignment_2 ) )
            {
            // InternalFirstOrderLogic.g:3950:1: ( ( rule__Get__NameAssignment_2 ) )
            // InternalFirstOrderLogic.g:3951:2: ( rule__Get__NameAssignment_2 )
            {
             before(grammarAccess.getGetAccess().getNameAssignment_2()); 
            // InternalFirstOrderLogic.g:3952:2: ( rule__Get__NameAssignment_2 )
            // InternalFirstOrderLogic.g:3952:3: rule__Get__NameAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__Get__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getGetAccess().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Get__Group__2__Impl"


    // $ANTLR start "rule__Get__Group__3"
    // InternalFirstOrderLogic.g:3960:1: rule__Get__Group__3 : rule__Get__Group__3__Impl ;
    public final void rule__Get__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3964:1: ( rule__Get__Group__3__Impl )
            // InternalFirstOrderLogic.g:3965:2: rule__Get__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Get__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Get__Group__3"


    // $ANTLR start "rule__Get__Group__3__Impl"
    // InternalFirstOrderLogic.g:3971:1: rule__Get__Group__3__Impl : ( ( rule__Get__NextAssignment_3 )? ) ;
    public final void rule__Get__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3975:1: ( ( ( rule__Get__NextAssignment_3 )? ) )
            // InternalFirstOrderLogic.g:3976:1: ( ( rule__Get__NextAssignment_3 )? )
            {
            // InternalFirstOrderLogic.g:3976:1: ( ( rule__Get__NextAssignment_3 )? )
            // InternalFirstOrderLogic.g:3977:2: ( rule__Get__NextAssignment_3 )?
            {
             before(grammarAccess.getGetAccess().getNextAssignment_3()); 
            // InternalFirstOrderLogic.g:3978:2: ( rule__Get__NextAssignment_3 )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==38) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalFirstOrderLogic.g:3978:3: rule__Get__NextAssignment_3
                    {
                    pushFollow(FOLLOW_2);
                    rule__Get__NextAssignment_3();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getGetAccess().getNextAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Get__Group__3__Impl"


    // $ANTLR start "rule__Get__Group_1__0"
    // InternalFirstOrderLogic.g:3987:1: rule__Get__Group_1__0 : rule__Get__Group_1__0__Impl rule__Get__Group_1__1 ;
    public final void rule__Get__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3991:1: ( rule__Get__Group_1__0__Impl rule__Get__Group_1__1 )
            // InternalFirstOrderLogic.g:3992:2: rule__Get__Group_1__0__Impl rule__Get__Group_1__1
            {
            pushFollow(FOLLOW_30);
            rule__Get__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Get__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Get__Group_1__0"


    // $ANTLR start "rule__Get__Group_1__0__Impl"
    // InternalFirstOrderLogic.g:3999:1: rule__Get__Group_1__0__Impl : ( ( rule__Get__TypeAssignment_1_0 ) ) ;
    public final void rule__Get__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4003:1: ( ( ( rule__Get__TypeAssignment_1_0 ) ) )
            // InternalFirstOrderLogic.g:4004:1: ( ( rule__Get__TypeAssignment_1_0 ) )
            {
            // InternalFirstOrderLogic.g:4004:1: ( ( rule__Get__TypeAssignment_1_0 ) )
            // InternalFirstOrderLogic.g:4005:2: ( rule__Get__TypeAssignment_1_0 )
            {
             before(grammarAccess.getGetAccess().getTypeAssignment_1_0()); 
            // InternalFirstOrderLogic.g:4006:2: ( rule__Get__TypeAssignment_1_0 )
            // InternalFirstOrderLogic.g:4006:3: rule__Get__TypeAssignment_1_0
            {
            pushFollow(FOLLOW_2);
            rule__Get__TypeAssignment_1_0();

            state._fsp--;


            }

             after(grammarAccess.getGetAccess().getTypeAssignment_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Get__Group_1__0__Impl"


    // $ANTLR start "rule__Get__Group_1__1"
    // InternalFirstOrderLogic.g:4014:1: rule__Get__Group_1__1 : rule__Get__Group_1__1__Impl ;
    public final void rule__Get__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4018:1: ( rule__Get__Group_1__1__Impl )
            // InternalFirstOrderLogic.g:4019:2: rule__Get__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Get__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Get__Group_1__1"


    // $ANTLR start "rule__Get__Group_1__1__Impl"
    // InternalFirstOrderLogic.g:4025:1: rule__Get__Group_1__1__Impl : ( '::' ) ;
    public final void rule__Get__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4029:1: ( ( '::' ) )
            // InternalFirstOrderLogic.g:4030:1: ( '::' )
            {
            // InternalFirstOrderLogic.g:4030:1: ( '::' )
            // InternalFirstOrderLogic.g:4031:2: '::'
            {
             before(grammarAccess.getGetAccess().getColonColonKeyword_1_1()); 
            match(input,39,FOLLOW_2); 
             after(grammarAccess.getGetAccess().getColonColonKeyword_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Get__Group_1__1__Impl"


    // $ANTLR start "rule__GetContainer__Group__0"
    // InternalFirstOrderLogic.g:4041:1: rule__GetContainer__Group__0 : rule__GetContainer__Group__0__Impl rule__GetContainer__Group__1 ;
    public final void rule__GetContainer__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4045:1: ( rule__GetContainer__Group__0__Impl rule__GetContainer__Group__1 )
            // InternalFirstOrderLogic.g:4046:2: rule__GetContainer__Group__0__Impl rule__GetContainer__Group__1
            {
            pushFollow(FOLLOW_24);
            rule__GetContainer__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__GetContainer__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GetContainer__Group__0"


    // $ANTLR start "rule__GetContainer__Group__0__Impl"
    // InternalFirstOrderLogic.g:4053:1: rule__GetContainer__Group__0__Impl : ( 'getContainer(' ) ;
    public final void rule__GetContainer__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4057:1: ( ( 'getContainer(' ) )
            // InternalFirstOrderLogic.g:4058:1: ( 'getContainer(' )
            {
            // InternalFirstOrderLogic.g:4058:1: ( 'getContainer(' )
            // InternalFirstOrderLogic.g:4059:2: 'getContainer('
            {
             before(grammarAccess.getGetContainerAccess().getGetContainerKeyword_0()); 
            match(input,40,FOLLOW_2); 
             after(grammarAccess.getGetContainerAccess().getGetContainerKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GetContainer__Group__0__Impl"


    // $ANTLR start "rule__GetContainer__Group__1"
    // InternalFirstOrderLogic.g:4068:1: rule__GetContainer__Group__1 : rule__GetContainer__Group__1__Impl rule__GetContainer__Group__2 ;
    public final void rule__GetContainer__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4072:1: ( rule__GetContainer__Group__1__Impl rule__GetContainer__Group__2 )
            // InternalFirstOrderLogic.g:4073:2: rule__GetContainer__Group__1__Impl rule__GetContainer__Group__2
            {
            pushFollow(FOLLOW_23);
            rule__GetContainer__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__GetContainer__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GetContainer__Group__1"


    // $ANTLR start "rule__GetContainer__Group__1__Impl"
    // InternalFirstOrderLogic.g:4080:1: rule__GetContainer__Group__1__Impl : ( ( rule__GetContainer__ElementAssignment_1 ) ) ;
    public final void rule__GetContainer__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4084:1: ( ( ( rule__GetContainer__ElementAssignment_1 ) ) )
            // InternalFirstOrderLogic.g:4085:1: ( ( rule__GetContainer__ElementAssignment_1 ) )
            {
            // InternalFirstOrderLogic.g:4085:1: ( ( rule__GetContainer__ElementAssignment_1 ) )
            // InternalFirstOrderLogic.g:4086:2: ( rule__GetContainer__ElementAssignment_1 )
            {
             before(grammarAccess.getGetContainerAccess().getElementAssignment_1()); 
            // InternalFirstOrderLogic.g:4087:2: ( rule__GetContainer__ElementAssignment_1 )
            // InternalFirstOrderLogic.g:4087:3: rule__GetContainer__ElementAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__GetContainer__ElementAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getGetContainerAccess().getElementAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GetContainer__Group__1__Impl"


    // $ANTLR start "rule__GetContainer__Group__2"
    // InternalFirstOrderLogic.g:4095:1: rule__GetContainer__Group__2 : rule__GetContainer__Group__2__Impl ;
    public final void rule__GetContainer__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4099:1: ( rule__GetContainer__Group__2__Impl )
            // InternalFirstOrderLogic.g:4100:2: rule__GetContainer__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__GetContainer__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GetContainer__Group__2"


    // $ANTLR start "rule__GetContainer__Group__2__Impl"
    // InternalFirstOrderLogic.g:4106:1: rule__GetContainer__Group__2__Impl : ( ')' ) ;
    public final void rule__GetContainer__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4110:1: ( ( ')' ) )
            // InternalFirstOrderLogic.g:4111:1: ( ')' )
            {
            // InternalFirstOrderLogic.g:4111:1: ( ')' )
            // InternalFirstOrderLogic.g:4112:2: ')'
            {
             before(grammarAccess.getGetContainerAccess().getRightParenthesisKeyword_2()); 
            match(input,25,FOLLOW_2); 
             after(grammarAccess.getGetContainerAccess().getRightParenthesisKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GetContainer__Group__2__Impl"


    // $ANTLR start "rule__GetContainment__Group__0"
    // InternalFirstOrderLogic.g:4122:1: rule__GetContainment__Group__0 : rule__GetContainment__Group__0__Impl rule__GetContainment__Group__1 ;
    public final void rule__GetContainment__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4126:1: ( rule__GetContainment__Group__0__Impl rule__GetContainment__Group__1 )
            // InternalFirstOrderLogic.g:4127:2: rule__GetContainment__Group__0__Impl rule__GetContainment__Group__1
            {
            pushFollow(FOLLOW_24);
            rule__GetContainment__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__GetContainment__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GetContainment__Group__0"


    // $ANTLR start "rule__GetContainment__Group__0__Impl"
    // InternalFirstOrderLogic.g:4134:1: rule__GetContainment__Group__0__Impl : ( 'getContainments(' ) ;
    public final void rule__GetContainment__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4138:1: ( ( 'getContainments(' ) )
            // InternalFirstOrderLogic.g:4139:1: ( 'getContainments(' )
            {
            // InternalFirstOrderLogic.g:4139:1: ( 'getContainments(' )
            // InternalFirstOrderLogic.g:4140:2: 'getContainments('
            {
             before(grammarAccess.getGetContainmentAccess().getGetContainmentsKeyword_0()); 
            match(input,41,FOLLOW_2); 
             after(grammarAccess.getGetContainmentAccess().getGetContainmentsKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GetContainment__Group__0__Impl"


    // $ANTLR start "rule__GetContainment__Group__1"
    // InternalFirstOrderLogic.g:4149:1: rule__GetContainment__Group__1 : rule__GetContainment__Group__1__Impl rule__GetContainment__Group__2 ;
    public final void rule__GetContainment__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4153:1: ( rule__GetContainment__Group__1__Impl rule__GetContainment__Group__2 )
            // InternalFirstOrderLogic.g:4154:2: rule__GetContainment__Group__1__Impl rule__GetContainment__Group__2
            {
            pushFollow(FOLLOW_23);
            rule__GetContainment__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__GetContainment__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GetContainment__Group__1"


    // $ANTLR start "rule__GetContainment__Group__1__Impl"
    // InternalFirstOrderLogic.g:4161:1: rule__GetContainment__Group__1__Impl : ( ( rule__GetContainment__ElementAssignment_1 ) ) ;
    public final void rule__GetContainment__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4165:1: ( ( ( rule__GetContainment__ElementAssignment_1 ) ) )
            // InternalFirstOrderLogic.g:4166:1: ( ( rule__GetContainment__ElementAssignment_1 ) )
            {
            // InternalFirstOrderLogic.g:4166:1: ( ( rule__GetContainment__ElementAssignment_1 ) )
            // InternalFirstOrderLogic.g:4167:2: ( rule__GetContainment__ElementAssignment_1 )
            {
             before(grammarAccess.getGetContainmentAccess().getElementAssignment_1()); 
            // InternalFirstOrderLogic.g:4168:2: ( rule__GetContainment__ElementAssignment_1 )
            // InternalFirstOrderLogic.g:4168:3: rule__GetContainment__ElementAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__GetContainment__ElementAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getGetContainmentAccess().getElementAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GetContainment__Group__1__Impl"


    // $ANTLR start "rule__GetContainment__Group__2"
    // InternalFirstOrderLogic.g:4176:1: rule__GetContainment__Group__2 : rule__GetContainment__Group__2__Impl ;
    public final void rule__GetContainment__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4180:1: ( rule__GetContainment__Group__2__Impl )
            // InternalFirstOrderLogic.g:4181:2: rule__GetContainment__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__GetContainment__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GetContainment__Group__2"


    // $ANTLR start "rule__GetContainment__Group__2__Impl"
    // InternalFirstOrderLogic.g:4187:1: rule__GetContainment__Group__2__Impl : ( ')' ) ;
    public final void rule__GetContainment__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4191:1: ( ( ')' ) )
            // InternalFirstOrderLogic.g:4192:1: ( ')' )
            {
            // InternalFirstOrderLogic.g:4192:1: ( ')' )
            // InternalFirstOrderLogic.g:4193:2: ')'
            {
             before(grammarAccess.getGetContainmentAccess().getRightParenthesisKeyword_2()); 
            match(input,25,FOLLOW_2); 
             after(grammarAccess.getGetContainmentAccess().getRightParenthesisKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GetContainment__Group__2__Impl"


    // $ANTLR start "rule__GetClosure__Group__0"
    // InternalFirstOrderLogic.g:4203:1: rule__GetClosure__Group__0 : rule__GetClosure__Group__0__Impl rule__GetClosure__Group__1 ;
    public final void rule__GetClosure__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4207:1: ( rule__GetClosure__Group__0__Impl rule__GetClosure__Group__1 )
            // InternalFirstOrderLogic.g:4208:2: rule__GetClosure__Group__0__Impl rule__GetClosure__Group__1
            {
            pushFollow(FOLLOW_24);
            rule__GetClosure__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__GetClosure__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GetClosure__Group__0"


    // $ANTLR start "rule__GetClosure__Group__0__Impl"
    // InternalFirstOrderLogic.g:4215:1: rule__GetClosure__Group__0__Impl : ( 'getClosure(' ) ;
    public final void rule__GetClosure__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4219:1: ( ( 'getClosure(' ) )
            // InternalFirstOrderLogic.g:4220:1: ( 'getClosure(' )
            {
            // InternalFirstOrderLogic.g:4220:1: ( 'getClosure(' )
            // InternalFirstOrderLogic.g:4221:2: 'getClosure('
            {
             before(grammarAccess.getGetClosureAccess().getGetClosureKeyword_0()); 
            match(input,42,FOLLOW_2); 
             after(grammarAccess.getGetClosureAccess().getGetClosureKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GetClosure__Group__0__Impl"


    // $ANTLR start "rule__GetClosure__Group__1"
    // InternalFirstOrderLogic.g:4230:1: rule__GetClosure__Group__1 : rule__GetClosure__Group__1__Impl rule__GetClosure__Group__2 ;
    public final void rule__GetClosure__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4234:1: ( rule__GetClosure__Group__1__Impl rule__GetClosure__Group__2 )
            // InternalFirstOrderLogic.g:4235:2: rule__GetClosure__Group__1__Impl rule__GetClosure__Group__2
            {
            pushFollow(FOLLOW_25);
            rule__GetClosure__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__GetClosure__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GetClosure__Group__1"


    // $ANTLR start "rule__GetClosure__Group__1__Impl"
    // InternalFirstOrderLogic.g:4242:1: rule__GetClosure__Group__1__Impl : ( ( rule__GetClosure__ElementAssignment_1 ) ) ;
    public final void rule__GetClosure__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4246:1: ( ( ( rule__GetClosure__ElementAssignment_1 ) ) )
            // InternalFirstOrderLogic.g:4247:1: ( ( rule__GetClosure__ElementAssignment_1 ) )
            {
            // InternalFirstOrderLogic.g:4247:1: ( ( rule__GetClosure__ElementAssignment_1 ) )
            // InternalFirstOrderLogic.g:4248:2: ( rule__GetClosure__ElementAssignment_1 )
            {
             before(grammarAccess.getGetClosureAccess().getElementAssignment_1()); 
            // InternalFirstOrderLogic.g:4249:2: ( rule__GetClosure__ElementAssignment_1 )
            // InternalFirstOrderLogic.g:4249:3: rule__GetClosure__ElementAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__GetClosure__ElementAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getGetClosureAccess().getElementAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GetClosure__Group__1__Impl"


    // $ANTLR start "rule__GetClosure__Group__2"
    // InternalFirstOrderLogic.g:4257:1: rule__GetClosure__Group__2 : rule__GetClosure__Group__2__Impl rule__GetClosure__Group__3 ;
    public final void rule__GetClosure__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4261:1: ( rule__GetClosure__Group__2__Impl rule__GetClosure__Group__3 )
            // InternalFirstOrderLogic.g:4262:2: rule__GetClosure__Group__2__Impl rule__GetClosure__Group__3
            {
            pushFollow(FOLLOW_7);
            rule__GetClosure__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__GetClosure__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GetClosure__Group__2"


    // $ANTLR start "rule__GetClosure__Group__2__Impl"
    // InternalFirstOrderLogic.g:4269:1: rule__GetClosure__Group__2__Impl : ( ',' ) ;
    public final void rule__GetClosure__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4273:1: ( ( ',' ) )
            // InternalFirstOrderLogic.g:4274:1: ( ',' )
            {
            // InternalFirstOrderLogic.g:4274:1: ( ',' )
            // InternalFirstOrderLogic.g:4275:2: ','
            {
             before(grammarAccess.getGetClosureAccess().getCommaKeyword_2()); 
            match(input,27,FOLLOW_2); 
             after(grammarAccess.getGetClosureAccess().getCommaKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GetClosure__Group__2__Impl"


    // $ANTLR start "rule__GetClosure__Group__3"
    // InternalFirstOrderLogic.g:4284:1: rule__GetClosure__Group__3 : rule__GetClosure__Group__3__Impl rule__GetClosure__Group__4 ;
    public final void rule__GetClosure__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4288:1: ( rule__GetClosure__Group__3__Impl rule__GetClosure__Group__4 )
            // InternalFirstOrderLogic.g:4289:2: rule__GetClosure__Group__3__Impl rule__GetClosure__Group__4
            {
            pushFollow(FOLLOW_23);
            rule__GetClosure__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__GetClosure__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GetClosure__Group__3"


    // $ANTLR start "rule__GetClosure__Group__3__Impl"
    // InternalFirstOrderLogic.g:4296:1: rule__GetClosure__Group__3__Impl : ( ( rule__GetClosure__FeatureAssignment_3 ) ) ;
    public final void rule__GetClosure__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4300:1: ( ( ( rule__GetClosure__FeatureAssignment_3 ) ) )
            // InternalFirstOrderLogic.g:4301:1: ( ( rule__GetClosure__FeatureAssignment_3 ) )
            {
            // InternalFirstOrderLogic.g:4301:1: ( ( rule__GetClosure__FeatureAssignment_3 ) )
            // InternalFirstOrderLogic.g:4302:2: ( rule__GetClosure__FeatureAssignment_3 )
            {
             before(grammarAccess.getGetClosureAccess().getFeatureAssignment_3()); 
            // InternalFirstOrderLogic.g:4303:2: ( rule__GetClosure__FeatureAssignment_3 )
            // InternalFirstOrderLogic.g:4303:3: rule__GetClosure__FeatureAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__GetClosure__FeatureAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getGetClosureAccess().getFeatureAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GetClosure__Group__3__Impl"


    // $ANTLR start "rule__GetClosure__Group__4"
    // InternalFirstOrderLogic.g:4311:1: rule__GetClosure__Group__4 : rule__GetClosure__Group__4__Impl ;
    public final void rule__GetClosure__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4315:1: ( rule__GetClosure__Group__4__Impl )
            // InternalFirstOrderLogic.g:4316:2: rule__GetClosure__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__GetClosure__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GetClosure__Group__4"


    // $ANTLR start "rule__GetClosure__Group__4__Impl"
    // InternalFirstOrderLogic.g:4322:1: rule__GetClosure__Group__4__Impl : ( ')' ) ;
    public final void rule__GetClosure__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4326:1: ( ( ')' ) )
            // InternalFirstOrderLogic.g:4327:1: ( ')' )
            {
            // InternalFirstOrderLogic.g:4327:1: ( ')' )
            // InternalFirstOrderLogic.g:4328:2: ')'
            {
             before(grammarAccess.getGetClosureAccess().getRightParenthesisKeyword_4()); 
            match(input,25,FOLLOW_2); 
             after(grammarAccess.getGetClosureAccess().getRightParenthesisKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GetClosure__Group__4__Impl"


    // $ANTLR start "rule__Concatenate__Group__0"
    // InternalFirstOrderLogic.g:4338:1: rule__Concatenate__Group__0 : rule__Concatenate__Group__0__Impl rule__Concatenate__Group__1 ;
    public final void rule__Concatenate__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4342:1: ( rule__Concatenate__Group__0__Impl rule__Concatenate__Group__1 )
            // InternalFirstOrderLogic.g:4343:2: rule__Concatenate__Group__0__Impl rule__Concatenate__Group__1
            {
            pushFollow(FOLLOW_24);
            rule__Concatenate__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Concatenate__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Concatenate__Group__0"


    // $ANTLR start "rule__Concatenate__Group__0__Impl"
    // InternalFirstOrderLogic.g:4350:1: rule__Concatenate__Group__0__Impl : ( 'concatenate(' ) ;
    public final void rule__Concatenate__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4354:1: ( ( 'concatenate(' ) )
            // InternalFirstOrderLogic.g:4355:1: ( 'concatenate(' )
            {
            // InternalFirstOrderLogic.g:4355:1: ( 'concatenate(' )
            // InternalFirstOrderLogic.g:4356:2: 'concatenate('
            {
             before(grammarAccess.getConcatenateAccess().getConcatenateKeyword_0()); 
            match(input,43,FOLLOW_2); 
             after(grammarAccess.getConcatenateAccess().getConcatenateKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Concatenate__Group__0__Impl"


    // $ANTLR start "rule__Concatenate__Group__1"
    // InternalFirstOrderLogic.g:4365:1: rule__Concatenate__Group__1 : rule__Concatenate__Group__1__Impl rule__Concatenate__Group__2 ;
    public final void rule__Concatenate__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4369:1: ( rule__Concatenate__Group__1__Impl rule__Concatenate__Group__2 )
            // InternalFirstOrderLogic.g:4370:2: rule__Concatenate__Group__1__Impl rule__Concatenate__Group__2
            {
            pushFollow(FOLLOW_25);
            rule__Concatenate__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Concatenate__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Concatenate__Group__1"


    // $ANTLR start "rule__Concatenate__Group__1__Impl"
    // InternalFirstOrderLogic.g:4377:1: rule__Concatenate__Group__1__Impl : ( ( rule__Concatenate__LeftAssignment_1 ) ) ;
    public final void rule__Concatenate__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4381:1: ( ( ( rule__Concatenate__LeftAssignment_1 ) ) )
            // InternalFirstOrderLogic.g:4382:1: ( ( rule__Concatenate__LeftAssignment_1 ) )
            {
            // InternalFirstOrderLogic.g:4382:1: ( ( rule__Concatenate__LeftAssignment_1 ) )
            // InternalFirstOrderLogic.g:4383:2: ( rule__Concatenate__LeftAssignment_1 )
            {
             before(grammarAccess.getConcatenateAccess().getLeftAssignment_1()); 
            // InternalFirstOrderLogic.g:4384:2: ( rule__Concatenate__LeftAssignment_1 )
            // InternalFirstOrderLogic.g:4384:3: rule__Concatenate__LeftAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Concatenate__LeftAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getConcatenateAccess().getLeftAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Concatenate__Group__1__Impl"


    // $ANTLR start "rule__Concatenate__Group__2"
    // InternalFirstOrderLogic.g:4392:1: rule__Concatenate__Group__2 : rule__Concatenate__Group__2__Impl rule__Concatenate__Group__3 ;
    public final void rule__Concatenate__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4396:1: ( rule__Concatenate__Group__2__Impl rule__Concatenate__Group__3 )
            // InternalFirstOrderLogic.g:4397:2: rule__Concatenate__Group__2__Impl rule__Concatenate__Group__3
            {
            pushFollow(FOLLOW_24);
            rule__Concatenate__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Concatenate__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Concatenate__Group__2"


    // $ANTLR start "rule__Concatenate__Group__2__Impl"
    // InternalFirstOrderLogic.g:4404:1: rule__Concatenate__Group__2__Impl : ( ',' ) ;
    public final void rule__Concatenate__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4408:1: ( ( ',' ) )
            // InternalFirstOrderLogic.g:4409:1: ( ',' )
            {
            // InternalFirstOrderLogic.g:4409:1: ( ',' )
            // InternalFirstOrderLogic.g:4410:2: ','
            {
             before(grammarAccess.getConcatenateAccess().getCommaKeyword_2()); 
            match(input,27,FOLLOW_2); 
             after(grammarAccess.getConcatenateAccess().getCommaKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Concatenate__Group__2__Impl"


    // $ANTLR start "rule__Concatenate__Group__3"
    // InternalFirstOrderLogic.g:4419:1: rule__Concatenate__Group__3 : rule__Concatenate__Group__3__Impl rule__Concatenate__Group__4 ;
    public final void rule__Concatenate__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4423:1: ( rule__Concatenate__Group__3__Impl rule__Concatenate__Group__4 )
            // InternalFirstOrderLogic.g:4424:2: rule__Concatenate__Group__3__Impl rule__Concatenate__Group__4
            {
            pushFollow(FOLLOW_23);
            rule__Concatenate__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Concatenate__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Concatenate__Group__3"


    // $ANTLR start "rule__Concatenate__Group__3__Impl"
    // InternalFirstOrderLogic.g:4431:1: rule__Concatenate__Group__3__Impl : ( ( rule__Concatenate__RightAssignment_3 ) ) ;
    public final void rule__Concatenate__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4435:1: ( ( ( rule__Concatenate__RightAssignment_3 ) ) )
            // InternalFirstOrderLogic.g:4436:1: ( ( rule__Concatenate__RightAssignment_3 ) )
            {
            // InternalFirstOrderLogic.g:4436:1: ( ( rule__Concatenate__RightAssignment_3 ) )
            // InternalFirstOrderLogic.g:4437:2: ( rule__Concatenate__RightAssignment_3 )
            {
             before(grammarAccess.getConcatenateAccess().getRightAssignment_3()); 
            // InternalFirstOrderLogic.g:4438:2: ( rule__Concatenate__RightAssignment_3 )
            // InternalFirstOrderLogic.g:4438:3: rule__Concatenate__RightAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__Concatenate__RightAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getConcatenateAccess().getRightAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Concatenate__Group__3__Impl"


    // $ANTLR start "rule__Concatenate__Group__4"
    // InternalFirstOrderLogic.g:4446:1: rule__Concatenate__Group__4 : rule__Concatenate__Group__4__Impl ;
    public final void rule__Concatenate__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4450:1: ( rule__Concatenate__Group__4__Impl )
            // InternalFirstOrderLogic.g:4451:2: rule__Concatenate__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Concatenate__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Concatenate__Group__4"


    // $ANTLR start "rule__Concatenate__Group__4__Impl"
    // InternalFirstOrderLogic.g:4457:1: rule__Concatenate__Group__4__Impl : ( ')' ) ;
    public final void rule__Concatenate__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4461:1: ( ( ')' ) )
            // InternalFirstOrderLogic.g:4462:1: ( ')' )
            {
            // InternalFirstOrderLogic.g:4462:1: ( ')' )
            // InternalFirstOrderLogic.g:4463:2: ')'
            {
             before(grammarAccess.getConcatenateAccess().getRightParenthesisKeyword_4()); 
            match(input,25,FOLLOW_2); 
             after(grammarAccess.getConcatenateAccess().getRightParenthesisKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Concatenate__Group__4__Impl"


    // $ANTLR start "rule__Capitalize__Group__0"
    // InternalFirstOrderLogic.g:4473:1: rule__Capitalize__Group__0 : rule__Capitalize__Group__0__Impl rule__Capitalize__Group__1 ;
    public final void rule__Capitalize__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4477:1: ( rule__Capitalize__Group__0__Impl rule__Capitalize__Group__1 )
            // InternalFirstOrderLogic.g:4478:2: rule__Capitalize__Group__0__Impl rule__Capitalize__Group__1
            {
            pushFollow(FOLLOW_24);
            rule__Capitalize__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Capitalize__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Capitalize__Group__0"


    // $ANTLR start "rule__Capitalize__Group__0__Impl"
    // InternalFirstOrderLogic.g:4485:1: rule__Capitalize__Group__0__Impl : ( 'capitalize(' ) ;
    public final void rule__Capitalize__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4489:1: ( ( 'capitalize(' ) )
            // InternalFirstOrderLogic.g:4490:1: ( 'capitalize(' )
            {
            // InternalFirstOrderLogic.g:4490:1: ( 'capitalize(' )
            // InternalFirstOrderLogic.g:4491:2: 'capitalize('
            {
             before(grammarAccess.getCapitalizeAccess().getCapitalizeKeyword_0()); 
            match(input,44,FOLLOW_2); 
             after(grammarAccess.getCapitalizeAccess().getCapitalizeKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Capitalize__Group__0__Impl"


    // $ANTLR start "rule__Capitalize__Group__1"
    // InternalFirstOrderLogic.g:4500:1: rule__Capitalize__Group__1 : rule__Capitalize__Group__1__Impl rule__Capitalize__Group__2 ;
    public final void rule__Capitalize__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4504:1: ( rule__Capitalize__Group__1__Impl rule__Capitalize__Group__2 )
            // InternalFirstOrderLogic.g:4505:2: rule__Capitalize__Group__1__Impl rule__Capitalize__Group__2
            {
            pushFollow(FOLLOW_23);
            rule__Capitalize__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Capitalize__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Capitalize__Group__1"


    // $ANTLR start "rule__Capitalize__Group__1__Impl"
    // InternalFirstOrderLogic.g:4512:1: rule__Capitalize__Group__1__Impl : ( ( rule__Capitalize__StringAssignment_1 ) ) ;
    public final void rule__Capitalize__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4516:1: ( ( ( rule__Capitalize__StringAssignment_1 ) ) )
            // InternalFirstOrderLogic.g:4517:1: ( ( rule__Capitalize__StringAssignment_1 ) )
            {
            // InternalFirstOrderLogic.g:4517:1: ( ( rule__Capitalize__StringAssignment_1 ) )
            // InternalFirstOrderLogic.g:4518:2: ( rule__Capitalize__StringAssignment_1 )
            {
             before(grammarAccess.getCapitalizeAccess().getStringAssignment_1()); 
            // InternalFirstOrderLogic.g:4519:2: ( rule__Capitalize__StringAssignment_1 )
            // InternalFirstOrderLogic.g:4519:3: rule__Capitalize__StringAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Capitalize__StringAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getCapitalizeAccess().getStringAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Capitalize__Group__1__Impl"


    // $ANTLR start "rule__Capitalize__Group__2"
    // InternalFirstOrderLogic.g:4527:1: rule__Capitalize__Group__2 : rule__Capitalize__Group__2__Impl ;
    public final void rule__Capitalize__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4531:1: ( rule__Capitalize__Group__2__Impl )
            // InternalFirstOrderLogic.g:4532:2: rule__Capitalize__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Capitalize__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Capitalize__Group__2"


    // $ANTLR start "rule__Capitalize__Group__2__Impl"
    // InternalFirstOrderLogic.g:4538:1: rule__Capitalize__Group__2__Impl : ( ')' ) ;
    public final void rule__Capitalize__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4542:1: ( ( ')' ) )
            // InternalFirstOrderLogic.g:4543:1: ( ')' )
            {
            // InternalFirstOrderLogic.g:4543:1: ( ')' )
            // InternalFirstOrderLogic.g:4544:2: ')'
            {
             before(grammarAccess.getCapitalizeAccess().getRightParenthesisKeyword_2()); 
            match(input,25,FOLLOW_2); 
             after(grammarAccess.getCapitalizeAccess().getRightParenthesisKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Capitalize__Group__2__Impl"


    // $ANTLR start "rule__Constant__Group_0__0"
    // InternalFirstOrderLogic.g:4554:1: rule__Constant__Group_0__0 : rule__Constant__Group_0__0__Impl rule__Constant__Group_0__1 ;
    public final void rule__Constant__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4558:1: ( rule__Constant__Group_0__0__Impl rule__Constant__Group_0__1 )
            // InternalFirstOrderLogic.g:4559:2: rule__Constant__Group_0__0__Impl rule__Constant__Group_0__1
            {
            pushFollow(FOLLOW_31);
            rule__Constant__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Constant__Group_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constant__Group_0__0"


    // $ANTLR start "rule__Constant__Group_0__0__Impl"
    // InternalFirstOrderLogic.g:4566:1: rule__Constant__Group_0__0__Impl : ( () ) ;
    public final void rule__Constant__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4570:1: ( ( () ) )
            // InternalFirstOrderLogic.g:4571:1: ( () )
            {
            // InternalFirstOrderLogic.g:4571:1: ( () )
            // InternalFirstOrderLogic.g:4572:2: ()
            {
             before(grammarAccess.getConstantAccess().getIntConstantAction_0_0()); 
            // InternalFirstOrderLogic.g:4573:2: ()
            // InternalFirstOrderLogic.g:4573:3: 
            {
            }

             after(grammarAccess.getConstantAccess().getIntConstantAction_0_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constant__Group_0__0__Impl"


    // $ANTLR start "rule__Constant__Group_0__1"
    // InternalFirstOrderLogic.g:4581:1: rule__Constant__Group_0__1 : rule__Constant__Group_0__1__Impl ;
    public final void rule__Constant__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4585:1: ( rule__Constant__Group_0__1__Impl )
            // InternalFirstOrderLogic.g:4586:2: rule__Constant__Group_0__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Constant__Group_0__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constant__Group_0__1"


    // $ANTLR start "rule__Constant__Group_0__1__Impl"
    // InternalFirstOrderLogic.g:4592:1: rule__Constant__Group_0__1__Impl : ( ( rule__Constant__ValueAssignment_0_1 ) ) ;
    public final void rule__Constant__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4596:1: ( ( ( rule__Constant__ValueAssignment_0_1 ) ) )
            // InternalFirstOrderLogic.g:4597:1: ( ( rule__Constant__ValueAssignment_0_1 ) )
            {
            // InternalFirstOrderLogic.g:4597:1: ( ( rule__Constant__ValueAssignment_0_1 ) )
            // InternalFirstOrderLogic.g:4598:2: ( rule__Constant__ValueAssignment_0_1 )
            {
             before(grammarAccess.getConstantAccess().getValueAssignment_0_1()); 
            // InternalFirstOrderLogic.g:4599:2: ( rule__Constant__ValueAssignment_0_1 )
            // InternalFirstOrderLogic.g:4599:3: rule__Constant__ValueAssignment_0_1
            {
            pushFollow(FOLLOW_2);
            rule__Constant__ValueAssignment_0_1();

            state._fsp--;


            }

             after(grammarAccess.getConstantAccess().getValueAssignment_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constant__Group_0__1__Impl"


    // $ANTLR start "rule__Constant__Group_1__0"
    // InternalFirstOrderLogic.g:4608:1: rule__Constant__Group_1__0 : rule__Constant__Group_1__0__Impl rule__Constant__Group_1__1 ;
    public final void rule__Constant__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4612:1: ( rule__Constant__Group_1__0__Impl rule__Constant__Group_1__1 )
            // InternalFirstOrderLogic.g:4613:2: rule__Constant__Group_1__0__Impl rule__Constant__Group_1__1
            {
            pushFollow(FOLLOW_3);
            rule__Constant__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Constant__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constant__Group_1__0"


    // $ANTLR start "rule__Constant__Group_1__0__Impl"
    // InternalFirstOrderLogic.g:4620:1: rule__Constant__Group_1__0__Impl : ( () ) ;
    public final void rule__Constant__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4624:1: ( ( () ) )
            // InternalFirstOrderLogic.g:4625:1: ( () )
            {
            // InternalFirstOrderLogic.g:4625:1: ( () )
            // InternalFirstOrderLogic.g:4626:2: ()
            {
             before(grammarAccess.getConstantAccess().getStringConstantAction_1_0()); 
            // InternalFirstOrderLogic.g:4627:2: ()
            // InternalFirstOrderLogic.g:4627:3: 
            {
            }

             after(grammarAccess.getConstantAccess().getStringConstantAction_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constant__Group_1__0__Impl"


    // $ANTLR start "rule__Constant__Group_1__1"
    // InternalFirstOrderLogic.g:4635:1: rule__Constant__Group_1__1 : rule__Constant__Group_1__1__Impl ;
    public final void rule__Constant__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4639:1: ( rule__Constant__Group_1__1__Impl )
            // InternalFirstOrderLogic.g:4640:2: rule__Constant__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Constant__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constant__Group_1__1"


    // $ANTLR start "rule__Constant__Group_1__1__Impl"
    // InternalFirstOrderLogic.g:4646:1: rule__Constant__Group_1__1__Impl : ( ( rule__Constant__ValueAssignment_1_1 ) ) ;
    public final void rule__Constant__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4650:1: ( ( ( rule__Constant__ValueAssignment_1_1 ) ) )
            // InternalFirstOrderLogic.g:4651:1: ( ( rule__Constant__ValueAssignment_1_1 ) )
            {
            // InternalFirstOrderLogic.g:4651:1: ( ( rule__Constant__ValueAssignment_1_1 ) )
            // InternalFirstOrderLogic.g:4652:2: ( rule__Constant__ValueAssignment_1_1 )
            {
             before(grammarAccess.getConstantAccess().getValueAssignment_1_1()); 
            // InternalFirstOrderLogic.g:4653:2: ( rule__Constant__ValueAssignment_1_1 )
            // InternalFirstOrderLogic.g:4653:3: rule__Constant__ValueAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__Constant__ValueAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getConstantAccess().getValueAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constant__Group_1__1__Impl"


    // $ANTLR start "rule__ConstraintLibrary__DomainAssignment_1"
    // InternalFirstOrderLogic.g:4662:1: rule__ConstraintLibrary__DomainAssignment_1 : ( RULE_STRING ) ;
    public final void rule__ConstraintLibrary__DomainAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4666:1: ( ( RULE_STRING ) )
            // InternalFirstOrderLogic.g:4667:2: ( RULE_STRING )
            {
            // InternalFirstOrderLogic.g:4667:2: ( RULE_STRING )
            // InternalFirstOrderLogic.g:4668:3: RULE_STRING
            {
             before(grammarAccess.getConstraintLibraryAccess().getDomainSTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getConstraintLibraryAccess().getDomainSTRINGTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintLibrary__DomainAssignment_1"


    // $ANTLR start "rule__ConstraintLibrary__PackageImportAssignment_3"
    // InternalFirstOrderLogic.g:4677:1: rule__ConstraintLibrary__PackageImportAssignment_3 : ( RULE_STRING ) ;
    public final void rule__ConstraintLibrary__PackageImportAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4681:1: ( ( RULE_STRING ) )
            // InternalFirstOrderLogic.g:4682:2: ( RULE_STRING )
            {
            // InternalFirstOrderLogic.g:4682:2: ( RULE_STRING )
            // InternalFirstOrderLogic.g:4683:3: RULE_STRING
            {
             before(grammarAccess.getConstraintLibraryAccess().getPackageImportSTRINGTerminalRuleCall_3_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getConstraintLibraryAccess().getPackageImportSTRINGTerminalRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintLibrary__PackageImportAssignment_3"


    // $ANTLR start "rule__ConstraintLibrary__ConstraintsAssignment_4"
    // InternalFirstOrderLogic.g:4692:1: rule__ConstraintLibrary__ConstraintsAssignment_4 : ( ruleConstraint ) ;
    public final void rule__ConstraintLibrary__ConstraintsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4696:1: ( ( ruleConstraint ) )
            // InternalFirstOrderLogic.g:4697:2: ( ruleConstraint )
            {
            // InternalFirstOrderLogic.g:4697:2: ( ruleConstraint )
            // InternalFirstOrderLogic.g:4698:3: ruleConstraint
            {
             before(grammarAccess.getConstraintLibraryAccess().getConstraintsConstraintParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleConstraint();

            state._fsp--;

             after(grammarAccess.getConstraintLibraryAccess().getConstraintsConstraintParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintLibrary__ConstraintsAssignment_4"


    // $ANTLR start "rule__Constraint__NameAssignment_1"
    // InternalFirstOrderLogic.g:4707:1: rule__Constraint__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Constraint__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4711:1: ( ( RULE_ID ) )
            // InternalFirstOrderLogic.g:4712:2: ( RULE_ID )
            {
            // InternalFirstOrderLogic.g:4712:2: ( RULE_ID )
            // InternalFirstOrderLogic.g:4713:3: RULE_ID
            {
             before(grammarAccess.getConstraintAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getConstraintAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraint__NameAssignment_1"


    // $ANTLR start "rule__Constraint__MessageAssignment_3"
    // InternalFirstOrderLogic.g:4722:1: rule__Constraint__MessageAssignment_3 : ( RULE_STRING ) ;
    public final void rule__Constraint__MessageAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4726:1: ( ( RULE_STRING ) )
            // InternalFirstOrderLogic.g:4727:2: ( RULE_STRING )
            {
            // InternalFirstOrderLogic.g:4727:2: ( RULE_STRING )
            // InternalFirstOrderLogic.g:4728:3: RULE_STRING
            {
             before(grammarAccess.getConstraintAccess().getMessageSTRINGTerminalRuleCall_3_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getConstraintAccess().getMessageSTRINGTerminalRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraint__MessageAssignment_3"


    // $ANTLR start "rule__Constraint__VariableAssignment_5"
    // InternalFirstOrderLogic.g:4737:1: rule__Constraint__VariableAssignment_5 : ( ruleVariable ) ;
    public final void rule__Constraint__VariableAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4741:1: ( ( ruleVariable ) )
            // InternalFirstOrderLogic.g:4742:2: ( ruleVariable )
            {
            // InternalFirstOrderLogic.g:4742:2: ( ruleVariable )
            // InternalFirstOrderLogic.g:4743:3: ruleVariable
            {
             before(grammarAccess.getConstraintAccess().getVariableVariableParserRuleCall_5_0()); 
            pushFollow(FOLLOW_2);
            ruleVariable();

            state._fsp--;

             after(grammarAccess.getConstraintAccess().getVariableVariableParserRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraint__VariableAssignment_5"


    // $ANTLR start "rule__Constraint__FormulaAssignment_7"
    // InternalFirstOrderLogic.g:4752:1: rule__Constraint__FormulaAssignment_7 : ( ruleFormula ) ;
    public final void rule__Constraint__FormulaAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4756:1: ( ( ruleFormula ) )
            // InternalFirstOrderLogic.g:4757:2: ( ruleFormula )
            {
            // InternalFirstOrderLogic.g:4757:2: ( ruleFormula )
            // InternalFirstOrderLogic.g:4758:3: ruleFormula
            {
             before(grammarAccess.getConstraintAccess().getFormulaFormulaParserRuleCall_7_0()); 
            pushFollow(FOLLOW_2);
            ruleFormula();

            state._fsp--;

             after(grammarAccess.getConstraintAccess().getFormulaFormulaParserRuleCall_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraint__FormulaAssignment_7"


    // $ANTLR start "rule__Variable__TypeAssignment_0"
    // InternalFirstOrderLogic.g:4767:1: rule__Variable__TypeAssignment_0 : ( RULE_ID ) ;
    public final void rule__Variable__TypeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4771:1: ( ( RULE_ID ) )
            // InternalFirstOrderLogic.g:4772:2: ( RULE_ID )
            {
            // InternalFirstOrderLogic.g:4772:2: ( RULE_ID )
            // InternalFirstOrderLogic.g:4773:3: RULE_ID
            {
             before(grammarAccess.getVariableAccess().getTypeIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getVariableAccess().getTypeIDTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Variable__TypeAssignment_0"


    // $ANTLR start "rule__Variable__NameAssignment_1"
    // InternalFirstOrderLogic.g:4782:1: rule__Variable__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Variable__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4786:1: ( ( RULE_ID ) )
            // InternalFirstOrderLogic.g:4787:2: ( RULE_ID )
            {
            // InternalFirstOrderLogic.g:4787:2: ( RULE_ID )
            // InternalFirstOrderLogic.g:4788:3: RULE_ID
            {
             before(grammarAccess.getVariableAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getVariableAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Variable__NameAssignment_1"


    // $ANTLR start "rule__Iff__RightAssignment_1_2"
    // InternalFirstOrderLogic.g:4797:1: rule__Iff__RightAssignment_1_2 : ( ruleIf ) ;
    public final void rule__Iff__RightAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4801:1: ( ( ruleIf ) )
            // InternalFirstOrderLogic.g:4802:2: ( ruleIf )
            {
            // InternalFirstOrderLogic.g:4802:2: ( ruleIf )
            // InternalFirstOrderLogic.g:4803:3: ruleIf
            {
             before(grammarAccess.getIffAccess().getRightIfParserRuleCall_1_2_0()); 
            pushFollow(FOLLOW_2);
            ruleIf();

            state._fsp--;

             after(grammarAccess.getIffAccess().getRightIfParserRuleCall_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Iff__RightAssignment_1_2"


    // $ANTLR start "rule__If__RightAssignment_1_2"
    // InternalFirstOrderLogic.g:4812:1: rule__If__RightAssignment_1_2 : ( ruleXor ) ;
    public final void rule__If__RightAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4816:1: ( ( ruleXor ) )
            // InternalFirstOrderLogic.g:4817:2: ( ruleXor )
            {
            // InternalFirstOrderLogic.g:4817:2: ( ruleXor )
            // InternalFirstOrderLogic.g:4818:3: ruleXor
            {
             before(grammarAccess.getIfAccess().getRightXorParserRuleCall_1_2_0()); 
            pushFollow(FOLLOW_2);
            ruleXor();

            state._fsp--;

             after(grammarAccess.getIfAccess().getRightXorParserRuleCall_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__If__RightAssignment_1_2"


    // $ANTLR start "rule__Xor__RightAssignment_1_2"
    // InternalFirstOrderLogic.g:4827:1: rule__Xor__RightAssignment_1_2 : ( ruleOr ) ;
    public final void rule__Xor__RightAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4831:1: ( ( ruleOr ) )
            // InternalFirstOrderLogic.g:4832:2: ( ruleOr )
            {
            // InternalFirstOrderLogic.g:4832:2: ( ruleOr )
            // InternalFirstOrderLogic.g:4833:3: ruleOr
            {
             before(grammarAccess.getXorAccess().getRightOrParserRuleCall_1_2_0()); 
            pushFollow(FOLLOW_2);
            ruleOr();

            state._fsp--;

             after(grammarAccess.getXorAccess().getRightOrParserRuleCall_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Xor__RightAssignment_1_2"


    // $ANTLR start "rule__Or__RightAssignment_1_2"
    // InternalFirstOrderLogic.g:4842:1: rule__Or__RightAssignment_1_2 : ( ruleAnd ) ;
    public final void rule__Or__RightAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4846:1: ( ( ruleAnd ) )
            // InternalFirstOrderLogic.g:4847:2: ( ruleAnd )
            {
            // InternalFirstOrderLogic.g:4847:2: ( ruleAnd )
            // InternalFirstOrderLogic.g:4848:3: ruleAnd
            {
             before(grammarAccess.getOrAccess().getRightAndParserRuleCall_1_2_0()); 
            pushFollow(FOLLOW_2);
            ruleAnd();

            state._fsp--;

             after(grammarAccess.getOrAccess().getRightAndParserRuleCall_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Or__RightAssignment_1_2"


    // $ANTLR start "rule__And__RightAssignment_1_2"
    // InternalFirstOrderLogic.g:4857:1: rule__And__RightAssignment_1_2 : ( ruleBooleanExpression ) ;
    public final void rule__And__RightAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4861:1: ( ( ruleBooleanExpression ) )
            // InternalFirstOrderLogic.g:4862:2: ( ruleBooleanExpression )
            {
            // InternalFirstOrderLogic.g:4862:2: ( ruleBooleanExpression )
            // InternalFirstOrderLogic.g:4863:3: ruleBooleanExpression
            {
             before(grammarAccess.getAndAccess().getRightBooleanExpressionParserRuleCall_1_2_0()); 
            pushFollow(FOLLOW_2);
            ruleBooleanExpression();

            state._fsp--;

             after(grammarAccess.getAndAccess().getRightBooleanExpressionParserRuleCall_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__And__RightAssignment_1_2"


    // $ANTLR start "rule__Not__NotAssignment_2"
    // InternalFirstOrderLogic.g:4872:1: rule__Not__NotAssignment_2 : ( ruleFormula ) ;
    public final void rule__Not__NotAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4876:1: ( ( ruleFormula ) )
            // InternalFirstOrderLogic.g:4877:2: ( ruleFormula )
            {
            // InternalFirstOrderLogic.g:4877:2: ( ruleFormula )
            // InternalFirstOrderLogic.g:4878:3: ruleFormula
            {
             before(grammarAccess.getNotAccess().getNotFormulaParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleFormula();

            state._fsp--;

             after(grammarAccess.getNotAccess().getNotFormulaParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Not__NotAssignment_2"


    // $ANTLR start "rule__Equals__LeftAssignment_1"
    // InternalFirstOrderLogic.g:4887:1: rule__Equals__LeftAssignment_1 : ( ruleTerm ) ;
    public final void rule__Equals__LeftAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4891:1: ( ( ruleTerm ) )
            // InternalFirstOrderLogic.g:4892:2: ( ruleTerm )
            {
            // InternalFirstOrderLogic.g:4892:2: ( ruleTerm )
            // InternalFirstOrderLogic.g:4893:3: ruleTerm
            {
             before(grammarAccess.getEqualsAccess().getLeftTermParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleTerm();

            state._fsp--;

             after(grammarAccess.getEqualsAccess().getLeftTermParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Equals__LeftAssignment_1"


    // $ANTLR start "rule__Equals__RightAssignment_3"
    // InternalFirstOrderLogic.g:4902:1: rule__Equals__RightAssignment_3 : ( ruleTerm ) ;
    public final void rule__Equals__RightAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4906:1: ( ( ruleTerm ) )
            // InternalFirstOrderLogic.g:4907:2: ( ruleTerm )
            {
            // InternalFirstOrderLogic.g:4907:2: ( ruleTerm )
            // InternalFirstOrderLogic.g:4908:3: ruleTerm
            {
             before(grammarAccess.getEqualsAccess().getRightTermParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleTerm();

            state._fsp--;

             after(grammarAccess.getEqualsAccess().getRightTermParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Equals__RightAssignment_3"


    // $ANTLR start "rule__Greater__LeftAssignment_1"
    // InternalFirstOrderLogic.g:4917:1: rule__Greater__LeftAssignment_1 : ( ruleTerm ) ;
    public final void rule__Greater__LeftAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4921:1: ( ( ruleTerm ) )
            // InternalFirstOrderLogic.g:4922:2: ( ruleTerm )
            {
            // InternalFirstOrderLogic.g:4922:2: ( ruleTerm )
            // InternalFirstOrderLogic.g:4923:3: ruleTerm
            {
             before(grammarAccess.getGreaterAccess().getLeftTermParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleTerm();

            state._fsp--;

             after(grammarAccess.getGreaterAccess().getLeftTermParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Greater__LeftAssignment_1"


    // $ANTLR start "rule__Greater__RightAssignment_3"
    // InternalFirstOrderLogic.g:4932:1: rule__Greater__RightAssignment_3 : ( ruleTerm ) ;
    public final void rule__Greater__RightAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4936:1: ( ( ruleTerm ) )
            // InternalFirstOrderLogic.g:4937:2: ( ruleTerm )
            {
            // InternalFirstOrderLogic.g:4937:2: ( ruleTerm )
            // InternalFirstOrderLogic.g:4938:3: ruleTerm
            {
             before(grammarAccess.getGreaterAccess().getRightTermParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleTerm();

            state._fsp--;

             after(grammarAccess.getGreaterAccess().getRightTermParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Greater__RightAssignment_3"


    // $ANTLR start "rule__GreaterEqual__LeftAssignment_1"
    // InternalFirstOrderLogic.g:4947:1: rule__GreaterEqual__LeftAssignment_1 : ( ruleTerm ) ;
    public final void rule__GreaterEqual__LeftAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4951:1: ( ( ruleTerm ) )
            // InternalFirstOrderLogic.g:4952:2: ( ruleTerm )
            {
            // InternalFirstOrderLogic.g:4952:2: ( ruleTerm )
            // InternalFirstOrderLogic.g:4953:3: ruleTerm
            {
             before(grammarAccess.getGreaterEqualAccess().getLeftTermParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleTerm();

            state._fsp--;

             after(grammarAccess.getGreaterEqualAccess().getLeftTermParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GreaterEqual__LeftAssignment_1"


    // $ANTLR start "rule__GreaterEqual__RightAssignment_3"
    // InternalFirstOrderLogic.g:4962:1: rule__GreaterEqual__RightAssignment_3 : ( ruleTerm ) ;
    public final void rule__GreaterEqual__RightAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4966:1: ( ( ruleTerm ) )
            // InternalFirstOrderLogic.g:4967:2: ( ruleTerm )
            {
            // InternalFirstOrderLogic.g:4967:2: ( ruleTerm )
            // InternalFirstOrderLogic.g:4968:3: ruleTerm
            {
             before(grammarAccess.getGreaterEqualAccess().getRightTermParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleTerm();

            state._fsp--;

             after(grammarAccess.getGreaterEqualAccess().getRightTermParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GreaterEqual__RightAssignment_3"


    // $ANTLR start "rule__Smaller__LeftAssignment_1"
    // InternalFirstOrderLogic.g:4977:1: rule__Smaller__LeftAssignment_1 : ( ruleTerm ) ;
    public final void rule__Smaller__LeftAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4981:1: ( ( ruleTerm ) )
            // InternalFirstOrderLogic.g:4982:2: ( ruleTerm )
            {
            // InternalFirstOrderLogic.g:4982:2: ( ruleTerm )
            // InternalFirstOrderLogic.g:4983:3: ruleTerm
            {
             before(grammarAccess.getSmallerAccess().getLeftTermParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleTerm();

            state._fsp--;

             after(grammarAccess.getSmallerAccess().getLeftTermParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Smaller__LeftAssignment_1"


    // $ANTLR start "rule__Smaller__RightAssignment_3"
    // InternalFirstOrderLogic.g:4992:1: rule__Smaller__RightAssignment_3 : ( ruleTerm ) ;
    public final void rule__Smaller__RightAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4996:1: ( ( ruleTerm ) )
            // InternalFirstOrderLogic.g:4997:2: ( ruleTerm )
            {
            // InternalFirstOrderLogic.g:4997:2: ( ruleTerm )
            // InternalFirstOrderLogic.g:4998:3: ruleTerm
            {
             before(grammarAccess.getSmallerAccess().getRightTermParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleTerm();

            state._fsp--;

             after(grammarAccess.getSmallerAccess().getRightTermParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Smaller__RightAssignment_3"


    // $ANTLR start "rule__SmallerEqual__LeftAssignment_1"
    // InternalFirstOrderLogic.g:5007:1: rule__SmallerEqual__LeftAssignment_1 : ( ruleTerm ) ;
    public final void rule__SmallerEqual__LeftAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5011:1: ( ( ruleTerm ) )
            // InternalFirstOrderLogic.g:5012:2: ( ruleTerm )
            {
            // InternalFirstOrderLogic.g:5012:2: ( ruleTerm )
            // InternalFirstOrderLogic.g:5013:3: ruleTerm
            {
             before(grammarAccess.getSmallerEqualAccess().getLeftTermParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleTerm();

            state._fsp--;

             after(grammarAccess.getSmallerEqualAccess().getLeftTermParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SmallerEqual__LeftAssignment_1"


    // $ANTLR start "rule__SmallerEqual__RightAssignment_3"
    // InternalFirstOrderLogic.g:5022:1: rule__SmallerEqual__RightAssignment_3 : ( ruleTerm ) ;
    public final void rule__SmallerEqual__RightAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5026:1: ( ( ruleTerm ) )
            // InternalFirstOrderLogic.g:5027:2: ( ruleTerm )
            {
            // InternalFirstOrderLogic.g:5027:2: ( ruleTerm )
            // InternalFirstOrderLogic.g:5028:3: ruleTerm
            {
             before(grammarAccess.getSmallerEqualAccess().getRightTermParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleTerm();

            state._fsp--;

             after(grammarAccess.getSmallerEqualAccess().getRightTermParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SmallerEqual__RightAssignment_3"


    // $ANTLR start "rule__IsEmpty__TermAssignment_1"
    // InternalFirstOrderLogic.g:5037:1: rule__IsEmpty__TermAssignment_1 : ( ruleTerm ) ;
    public final void rule__IsEmpty__TermAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5041:1: ( ( ruleTerm ) )
            // InternalFirstOrderLogic.g:5042:2: ( ruleTerm )
            {
            // InternalFirstOrderLogic.g:5042:2: ( ruleTerm )
            // InternalFirstOrderLogic.g:5043:3: ruleTerm
            {
             before(grammarAccess.getIsEmptyAccess().getTermTermParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleTerm();

            state._fsp--;

             after(grammarAccess.getIsEmptyAccess().getTermTermParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IsEmpty__TermAssignment_1"


    // $ANTLR start "rule__IsInstanceOf__TermAssignment_1"
    // InternalFirstOrderLogic.g:5052:1: rule__IsInstanceOf__TermAssignment_1 : ( ruleTerm ) ;
    public final void rule__IsInstanceOf__TermAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5056:1: ( ( ruleTerm ) )
            // InternalFirstOrderLogic.g:5057:2: ( ruleTerm )
            {
            // InternalFirstOrderLogic.g:5057:2: ( ruleTerm )
            // InternalFirstOrderLogic.g:5058:3: ruleTerm
            {
             before(grammarAccess.getIsInstanceOfAccess().getTermTermParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleTerm();

            state._fsp--;

             after(grammarAccess.getIsInstanceOfAccess().getTermTermParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IsInstanceOf__TermAssignment_1"


    // $ANTLR start "rule__IsInstanceOf__TypeAssignment_3"
    // InternalFirstOrderLogic.g:5067:1: rule__IsInstanceOf__TypeAssignment_3 : ( RULE_ID ) ;
    public final void rule__IsInstanceOf__TypeAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5071:1: ( ( RULE_ID ) )
            // InternalFirstOrderLogic.g:5072:2: ( RULE_ID )
            {
            // InternalFirstOrderLogic.g:5072:2: ( RULE_ID )
            // InternalFirstOrderLogic.g:5073:3: RULE_ID
            {
             before(grammarAccess.getIsInstanceOfAccess().getTypeIDTerminalRuleCall_3_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getIsInstanceOfAccess().getTypeIDTerminalRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IsInstanceOf__TypeAssignment_3"


    // $ANTLR start "rule__ForAll__NameAssignment_2"
    // InternalFirstOrderLogic.g:5082:1: rule__ForAll__NameAssignment_2 : ( ruleVariable ) ;
    public final void rule__ForAll__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5086:1: ( ( ruleVariable ) )
            // InternalFirstOrderLogic.g:5087:2: ( ruleVariable )
            {
            // InternalFirstOrderLogic.g:5087:2: ( ruleVariable )
            // InternalFirstOrderLogic.g:5088:3: ruleVariable
            {
             before(grammarAccess.getForAllAccess().getNameVariableParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleVariable();

            state._fsp--;

             after(grammarAccess.getForAllAccess().getNameVariableParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ForAll__NameAssignment_2"


    // $ANTLR start "rule__ForAll__IterationAssignment_4"
    // InternalFirstOrderLogic.g:5097:1: rule__ForAll__IterationAssignment_4 : ( ruleTerm ) ;
    public final void rule__ForAll__IterationAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5101:1: ( ( ruleTerm ) )
            // InternalFirstOrderLogic.g:5102:2: ( ruleTerm )
            {
            // InternalFirstOrderLogic.g:5102:2: ( ruleTerm )
            // InternalFirstOrderLogic.g:5103:3: ruleTerm
            {
             before(grammarAccess.getForAllAccess().getIterationTermParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleTerm();

            state._fsp--;

             after(grammarAccess.getForAllAccess().getIterationTermParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ForAll__IterationAssignment_4"


    // $ANTLR start "rule__ForAll__FormulaAssignment_6"
    // InternalFirstOrderLogic.g:5112:1: rule__ForAll__FormulaAssignment_6 : ( ruleFormula ) ;
    public final void rule__ForAll__FormulaAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5116:1: ( ( ruleFormula ) )
            // InternalFirstOrderLogic.g:5117:2: ( ruleFormula )
            {
            // InternalFirstOrderLogic.g:5117:2: ( ruleFormula )
            // InternalFirstOrderLogic.g:5118:3: ruleFormula
            {
             before(grammarAccess.getForAllAccess().getFormulaFormulaParserRuleCall_6_0()); 
            pushFollow(FOLLOW_2);
            ruleFormula();

            state._fsp--;

             after(grammarAccess.getForAllAccess().getFormulaFormulaParserRuleCall_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ForAll__FormulaAssignment_6"


    // $ANTLR start "rule__Exists__NameAssignment_2"
    // InternalFirstOrderLogic.g:5127:1: rule__Exists__NameAssignment_2 : ( ruleVariable ) ;
    public final void rule__Exists__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5131:1: ( ( ruleVariable ) )
            // InternalFirstOrderLogic.g:5132:2: ( ruleVariable )
            {
            // InternalFirstOrderLogic.g:5132:2: ( ruleVariable )
            // InternalFirstOrderLogic.g:5133:3: ruleVariable
            {
             before(grammarAccess.getExistsAccess().getNameVariableParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleVariable();

            state._fsp--;

             after(grammarAccess.getExistsAccess().getNameVariableParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Exists__NameAssignment_2"


    // $ANTLR start "rule__Exists__IterationAssignment_4"
    // InternalFirstOrderLogic.g:5142:1: rule__Exists__IterationAssignment_4 : ( ruleTerm ) ;
    public final void rule__Exists__IterationAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5146:1: ( ( ruleTerm ) )
            // InternalFirstOrderLogic.g:5147:2: ( ruleTerm )
            {
            // InternalFirstOrderLogic.g:5147:2: ( ruleTerm )
            // InternalFirstOrderLogic.g:5148:3: ruleTerm
            {
             before(grammarAccess.getExistsAccess().getIterationTermParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleTerm();

            state._fsp--;

             after(grammarAccess.getExistsAccess().getIterationTermParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Exists__IterationAssignment_4"


    // $ANTLR start "rule__Exists__FormulaAssignment_6"
    // InternalFirstOrderLogic.g:5157:1: rule__Exists__FormulaAssignment_6 : ( ruleFormula ) ;
    public final void rule__Exists__FormulaAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5161:1: ( ( ruleFormula ) )
            // InternalFirstOrderLogic.g:5162:2: ( ruleFormula )
            {
            // InternalFirstOrderLogic.g:5162:2: ( ruleFormula )
            // InternalFirstOrderLogic.g:5163:3: ruleFormula
            {
             before(grammarAccess.getExistsAccess().getFormulaFormulaParserRuleCall_6_0()); 
            pushFollow(FOLLOW_2);
            ruleFormula();

            state._fsp--;

             after(grammarAccess.getExistsAccess().getFormulaFormulaParserRuleCall_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Exists__FormulaAssignment_6"


    // $ANTLR start "rule__BoolConstant__ValueAssignment_1"
    // InternalFirstOrderLogic.g:5172:1: rule__BoolConstant__ValueAssignment_1 : ( ( rule__BoolConstant__ValueAlternatives_1_0 ) ) ;
    public final void rule__BoolConstant__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5176:1: ( ( ( rule__BoolConstant__ValueAlternatives_1_0 ) ) )
            // InternalFirstOrderLogic.g:5177:2: ( ( rule__BoolConstant__ValueAlternatives_1_0 ) )
            {
            // InternalFirstOrderLogic.g:5177:2: ( ( rule__BoolConstant__ValueAlternatives_1_0 ) )
            // InternalFirstOrderLogic.g:5178:3: ( rule__BoolConstant__ValueAlternatives_1_0 )
            {
             before(grammarAccess.getBoolConstantAccess().getValueAlternatives_1_0()); 
            // InternalFirstOrderLogic.g:5179:3: ( rule__BoolConstant__ValueAlternatives_1_0 )
            // InternalFirstOrderLogic.g:5179:4: rule__BoolConstant__ValueAlternatives_1_0
            {
            pushFollow(FOLLOW_2);
            rule__BoolConstant__ValueAlternatives_1_0();

            state._fsp--;


            }

             after(grammarAccess.getBoolConstantAccess().getValueAlternatives_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BoolConstant__ValueAssignment_1"


    // $ANTLR start "rule__VariableRef__NameAssignment_1"
    // InternalFirstOrderLogic.g:5187:1: rule__VariableRef__NameAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__VariableRef__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5191:1: ( ( ( RULE_ID ) ) )
            // InternalFirstOrderLogic.g:5192:2: ( ( RULE_ID ) )
            {
            // InternalFirstOrderLogic.g:5192:2: ( ( RULE_ID ) )
            // InternalFirstOrderLogic.g:5193:3: ( RULE_ID )
            {
             before(grammarAccess.getVariableRefAccess().getNameVariableCrossReference_1_0()); 
            // InternalFirstOrderLogic.g:5194:3: ( RULE_ID )
            // InternalFirstOrderLogic.g:5195:4: RULE_ID
            {
             before(grammarAccess.getVariableRefAccess().getNameVariableIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getVariableRefAccess().getNameVariableIDTerminalRuleCall_1_0_1()); 

            }

             after(grammarAccess.getVariableRefAccess().getNameVariableCrossReference_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariableRef__NameAssignment_1"


    // $ANTLR start "rule__VariableRef__GetAssignment_2"
    // InternalFirstOrderLogic.g:5206:1: rule__VariableRef__GetAssignment_2 : ( ruleGet ) ;
    public final void rule__VariableRef__GetAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5210:1: ( ( ruleGet ) )
            // InternalFirstOrderLogic.g:5211:2: ( ruleGet )
            {
            // InternalFirstOrderLogic.g:5211:2: ( ruleGet )
            // InternalFirstOrderLogic.g:5212:3: ruleGet
            {
             before(grammarAccess.getVariableRefAccess().getGetGetParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleGet();

            state._fsp--;

             after(grammarAccess.getVariableRefAccess().getGetGetParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariableRef__GetAssignment_2"


    // $ANTLR start "rule__Get__TypeAssignment_1_0"
    // InternalFirstOrderLogic.g:5221:1: rule__Get__TypeAssignment_1_0 : ( RULE_ID ) ;
    public final void rule__Get__TypeAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5225:1: ( ( RULE_ID ) )
            // InternalFirstOrderLogic.g:5226:2: ( RULE_ID )
            {
            // InternalFirstOrderLogic.g:5226:2: ( RULE_ID )
            // InternalFirstOrderLogic.g:5227:3: RULE_ID
            {
             before(grammarAccess.getGetAccess().getTypeIDTerminalRuleCall_1_0_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getGetAccess().getTypeIDTerminalRuleCall_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Get__TypeAssignment_1_0"


    // $ANTLR start "rule__Get__NameAssignment_2"
    // InternalFirstOrderLogic.g:5236:1: rule__Get__NameAssignment_2 : ( ( RULE_ID ) ) ;
    public final void rule__Get__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5240:1: ( ( ( RULE_ID ) ) )
            // InternalFirstOrderLogic.g:5241:2: ( ( RULE_ID ) )
            {
            // InternalFirstOrderLogic.g:5241:2: ( ( RULE_ID ) )
            // InternalFirstOrderLogic.g:5242:3: ( RULE_ID )
            {
             before(grammarAccess.getGetAccess().getNameEStructuralFeatureCrossReference_2_0()); 
            // InternalFirstOrderLogic.g:5243:3: ( RULE_ID )
            // InternalFirstOrderLogic.g:5244:4: RULE_ID
            {
             before(grammarAccess.getGetAccess().getNameEStructuralFeatureIDTerminalRuleCall_2_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getGetAccess().getNameEStructuralFeatureIDTerminalRuleCall_2_0_1()); 

            }

             after(grammarAccess.getGetAccess().getNameEStructuralFeatureCrossReference_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Get__NameAssignment_2"


    // $ANTLR start "rule__Get__NextAssignment_3"
    // InternalFirstOrderLogic.g:5255:1: rule__Get__NextAssignment_3 : ( ruleGet ) ;
    public final void rule__Get__NextAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5259:1: ( ( ruleGet ) )
            // InternalFirstOrderLogic.g:5260:2: ( ruleGet )
            {
            // InternalFirstOrderLogic.g:5260:2: ( ruleGet )
            // InternalFirstOrderLogic.g:5261:3: ruleGet
            {
             before(grammarAccess.getGetAccess().getNextGetParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleGet();

            state._fsp--;

             after(grammarAccess.getGetAccess().getNextGetParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Get__NextAssignment_3"


    // $ANTLR start "rule__GetContainer__ElementAssignment_1"
    // InternalFirstOrderLogic.g:5270:1: rule__GetContainer__ElementAssignment_1 : ( ruleTerm ) ;
    public final void rule__GetContainer__ElementAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5274:1: ( ( ruleTerm ) )
            // InternalFirstOrderLogic.g:5275:2: ( ruleTerm )
            {
            // InternalFirstOrderLogic.g:5275:2: ( ruleTerm )
            // InternalFirstOrderLogic.g:5276:3: ruleTerm
            {
             before(grammarAccess.getGetContainerAccess().getElementTermParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleTerm();

            state._fsp--;

             after(grammarAccess.getGetContainerAccess().getElementTermParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GetContainer__ElementAssignment_1"


    // $ANTLR start "rule__GetContainment__ElementAssignment_1"
    // InternalFirstOrderLogic.g:5285:1: rule__GetContainment__ElementAssignment_1 : ( ruleTerm ) ;
    public final void rule__GetContainment__ElementAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5289:1: ( ( ruleTerm ) )
            // InternalFirstOrderLogic.g:5290:2: ( ruleTerm )
            {
            // InternalFirstOrderLogic.g:5290:2: ( ruleTerm )
            // InternalFirstOrderLogic.g:5291:3: ruleTerm
            {
             before(grammarAccess.getGetContainmentAccess().getElementTermParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleTerm();

            state._fsp--;

             after(grammarAccess.getGetContainmentAccess().getElementTermParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GetContainment__ElementAssignment_1"


    // $ANTLR start "rule__GetClosure__ElementAssignment_1"
    // InternalFirstOrderLogic.g:5300:1: rule__GetClosure__ElementAssignment_1 : ( ruleTerm ) ;
    public final void rule__GetClosure__ElementAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5304:1: ( ( ruleTerm ) )
            // InternalFirstOrderLogic.g:5305:2: ( ruleTerm )
            {
            // InternalFirstOrderLogic.g:5305:2: ( ruleTerm )
            // InternalFirstOrderLogic.g:5306:3: ruleTerm
            {
             before(grammarAccess.getGetClosureAccess().getElementTermParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleTerm();

            state._fsp--;

             after(grammarAccess.getGetClosureAccess().getElementTermParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GetClosure__ElementAssignment_1"


    // $ANTLR start "rule__GetClosure__FeatureAssignment_3"
    // InternalFirstOrderLogic.g:5315:1: rule__GetClosure__FeatureAssignment_3 : ( RULE_ID ) ;
    public final void rule__GetClosure__FeatureAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5319:1: ( ( RULE_ID ) )
            // InternalFirstOrderLogic.g:5320:2: ( RULE_ID )
            {
            // InternalFirstOrderLogic.g:5320:2: ( RULE_ID )
            // InternalFirstOrderLogic.g:5321:3: RULE_ID
            {
             before(grammarAccess.getGetClosureAccess().getFeatureIDTerminalRuleCall_3_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getGetClosureAccess().getFeatureIDTerminalRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GetClosure__FeatureAssignment_3"


    // $ANTLR start "rule__Concatenate__LeftAssignment_1"
    // InternalFirstOrderLogic.g:5330:1: rule__Concatenate__LeftAssignment_1 : ( ruleTerm ) ;
    public final void rule__Concatenate__LeftAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5334:1: ( ( ruleTerm ) )
            // InternalFirstOrderLogic.g:5335:2: ( ruleTerm )
            {
            // InternalFirstOrderLogic.g:5335:2: ( ruleTerm )
            // InternalFirstOrderLogic.g:5336:3: ruleTerm
            {
             before(grammarAccess.getConcatenateAccess().getLeftTermParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleTerm();

            state._fsp--;

             after(grammarAccess.getConcatenateAccess().getLeftTermParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Concatenate__LeftAssignment_1"


    // $ANTLR start "rule__Concatenate__RightAssignment_3"
    // InternalFirstOrderLogic.g:5345:1: rule__Concatenate__RightAssignment_3 : ( ruleTerm ) ;
    public final void rule__Concatenate__RightAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5349:1: ( ( ruleTerm ) )
            // InternalFirstOrderLogic.g:5350:2: ( ruleTerm )
            {
            // InternalFirstOrderLogic.g:5350:2: ( ruleTerm )
            // InternalFirstOrderLogic.g:5351:3: ruleTerm
            {
             before(grammarAccess.getConcatenateAccess().getRightTermParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleTerm();

            state._fsp--;

             after(grammarAccess.getConcatenateAccess().getRightTermParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Concatenate__RightAssignment_3"


    // $ANTLR start "rule__Capitalize__StringAssignment_1"
    // InternalFirstOrderLogic.g:5360:1: rule__Capitalize__StringAssignment_1 : ( ruleTerm ) ;
    public final void rule__Capitalize__StringAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5364:1: ( ( ruleTerm ) )
            // InternalFirstOrderLogic.g:5365:2: ( ruleTerm )
            {
            // InternalFirstOrderLogic.g:5365:2: ( ruleTerm )
            // InternalFirstOrderLogic.g:5366:3: ruleTerm
            {
             before(grammarAccess.getCapitalizeAccess().getStringTermParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleTerm();

            state._fsp--;

             after(grammarAccess.getCapitalizeAccess().getStringTermParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Capitalize__StringAssignment_1"


    // $ANTLR start "rule__Constant__ValueAssignment_0_1"
    // InternalFirstOrderLogic.g:5375:1: rule__Constant__ValueAssignment_0_1 : ( RULE_INT ) ;
    public final void rule__Constant__ValueAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5379:1: ( ( RULE_INT ) )
            // InternalFirstOrderLogic.g:5380:2: ( RULE_INT )
            {
            // InternalFirstOrderLogic.g:5380:2: ( RULE_INT )
            // InternalFirstOrderLogic.g:5381:3: RULE_INT
            {
             before(grammarAccess.getConstantAccess().getValueINTTerminalRuleCall_0_1_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getConstantAccess().getValueINTTerminalRuleCall_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constant__ValueAssignment_0_1"


    // $ANTLR start "rule__Constant__ValueAssignment_1_1"
    // InternalFirstOrderLogic.g:5390:1: rule__Constant__ValueAssignment_1_1 : ( RULE_STRING ) ;
    public final void rule__Constant__ValueAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5394:1: ( ( RULE_STRING ) )
            // InternalFirstOrderLogic.g:5395:2: ( RULE_STRING )
            {
            // InternalFirstOrderLogic.g:5395:2: ( RULE_STRING )
            // InternalFirstOrderLogic.g:5396:3: RULE_STRING
            {
             before(grammarAccess.getConstantAccess().getValueSTRINGTerminalRuleCall_1_1_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getConstantAccess().getValueSTRINGTerminalRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constant__ValueAssignment_1_1"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x00000037F5001800L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x00001F37F5001870L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000001400000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000000000040L});

}