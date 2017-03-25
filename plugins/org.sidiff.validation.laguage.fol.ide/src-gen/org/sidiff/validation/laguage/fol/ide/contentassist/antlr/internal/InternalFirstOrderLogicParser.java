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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'true'", "'false'", "'domain'", "'import'", "'constraint'", "'message'", "'context'", "':'", "'='", "'implies'", "'xor'", "'or'", "'and'", "'not('", "')'", "'isEqual('", "','", "'isGreater('", "'isGreaterEqual('", "'isSmaller('", "'isSmallerEqual('", "'isEmpty('", "'isInstanceOf('", "'forAll('", "'in'", "'exists('", "'('", "'.'", "'::'", "'getContainer('", "'getContainments('", "'getClosure('", "'size('", "'concatenate('", "'capitalize('"
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
    public static final int T__45=45;
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


    // $ANTLR start "entryRuleGetContainments"
    // InternalFirstOrderLogic.g:803:1: entryRuleGetContainments : ruleGetContainments EOF ;
    public final void entryRuleGetContainments() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:804:1: ( ruleGetContainments EOF )
            // InternalFirstOrderLogic.g:805:1: ruleGetContainments EOF
            {
             before(grammarAccess.getGetContainmentsRule()); 
            pushFollow(FOLLOW_1);
            ruleGetContainments();

            state._fsp--;

             after(grammarAccess.getGetContainmentsRule()); 
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
    // $ANTLR end "entryRuleGetContainments"


    // $ANTLR start "ruleGetContainments"
    // InternalFirstOrderLogic.g:812:1: ruleGetContainments : ( ( rule__GetContainments__Group__0 ) ) ;
    public final void ruleGetContainments() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:816:2: ( ( ( rule__GetContainments__Group__0 ) ) )
            // InternalFirstOrderLogic.g:817:2: ( ( rule__GetContainments__Group__0 ) )
            {
            // InternalFirstOrderLogic.g:817:2: ( ( rule__GetContainments__Group__0 ) )
            // InternalFirstOrderLogic.g:818:3: ( rule__GetContainments__Group__0 )
            {
             before(grammarAccess.getGetContainmentsAccess().getGroup()); 
            // InternalFirstOrderLogic.g:819:3: ( rule__GetContainments__Group__0 )
            // InternalFirstOrderLogic.g:819:4: rule__GetContainments__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__GetContainments__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getGetContainmentsAccess().getGroup()); 

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
    // $ANTLR end "ruleGetContainments"


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


    // $ANTLR start "entryRuleSize"
    // InternalFirstOrderLogic.g:853:1: entryRuleSize : ruleSize EOF ;
    public final void entryRuleSize() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:854:1: ( ruleSize EOF )
            // InternalFirstOrderLogic.g:855:1: ruleSize EOF
            {
             before(grammarAccess.getSizeRule()); 
            pushFollow(FOLLOW_1);
            ruleSize();

            state._fsp--;

             after(grammarAccess.getSizeRule()); 
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
    // $ANTLR end "entryRuleSize"


    // $ANTLR start "ruleSize"
    // InternalFirstOrderLogic.g:862:1: ruleSize : ( ( rule__Size__Group__0 ) ) ;
    public final void ruleSize() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:866:2: ( ( ( rule__Size__Group__0 ) ) )
            // InternalFirstOrderLogic.g:867:2: ( ( rule__Size__Group__0 ) )
            {
            // InternalFirstOrderLogic.g:867:2: ( ( rule__Size__Group__0 ) )
            // InternalFirstOrderLogic.g:868:3: ( rule__Size__Group__0 )
            {
             before(grammarAccess.getSizeAccess().getGroup()); 
            // InternalFirstOrderLogic.g:869:3: ( rule__Size__Group__0 )
            // InternalFirstOrderLogic.g:869:4: rule__Size__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Size__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getSizeAccess().getGroup()); 

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
    // $ANTLR end "ruleSize"


    // $ANTLR start "entryRuleConcatenate"
    // InternalFirstOrderLogic.g:878:1: entryRuleConcatenate : ruleConcatenate EOF ;
    public final void entryRuleConcatenate() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:879:1: ( ruleConcatenate EOF )
            // InternalFirstOrderLogic.g:880:1: ruleConcatenate EOF
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
    // InternalFirstOrderLogic.g:887:1: ruleConcatenate : ( ( rule__Concatenate__Group__0 ) ) ;
    public final void ruleConcatenate() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:891:2: ( ( ( rule__Concatenate__Group__0 ) ) )
            // InternalFirstOrderLogic.g:892:2: ( ( rule__Concatenate__Group__0 ) )
            {
            // InternalFirstOrderLogic.g:892:2: ( ( rule__Concatenate__Group__0 ) )
            // InternalFirstOrderLogic.g:893:3: ( rule__Concatenate__Group__0 )
            {
             before(grammarAccess.getConcatenateAccess().getGroup()); 
            // InternalFirstOrderLogic.g:894:3: ( rule__Concatenate__Group__0 )
            // InternalFirstOrderLogic.g:894:4: rule__Concatenate__Group__0
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
    // InternalFirstOrderLogic.g:903:1: entryRuleCapitalize : ruleCapitalize EOF ;
    public final void entryRuleCapitalize() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:904:1: ( ruleCapitalize EOF )
            // InternalFirstOrderLogic.g:905:1: ruleCapitalize EOF
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
    // InternalFirstOrderLogic.g:912:1: ruleCapitalize : ( ( rule__Capitalize__Group__0 ) ) ;
    public final void ruleCapitalize() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:916:2: ( ( ( rule__Capitalize__Group__0 ) ) )
            // InternalFirstOrderLogic.g:917:2: ( ( rule__Capitalize__Group__0 ) )
            {
            // InternalFirstOrderLogic.g:917:2: ( ( rule__Capitalize__Group__0 ) )
            // InternalFirstOrderLogic.g:918:3: ( rule__Capitalize__Group__0 )
            {
             before(grammarAccess.getCapitalizeAccess().getGroup()); 
            // InternalFirstOrderLogic.g:919:3: ( rule__Capitalize__Group__0 )
            // InternalFirstOrderLogic.g:919:4: rule__Capitalize__Group__0
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
    // InternalFirstOrderLogic.g:928:1: entryRuleConstant : ruleConstant EOF ;
    public final void entryRuleConstant() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:929:1: ( ruleConstant EOF )
            // InternalFirstOrderLogic.g:930:1: ruleConstant EOF
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
    // InternalFirstOrderLogic.g:937:1: ruleConstant : ( ( rule__Constant__Alternatives ) ) ;
    public final void ruleConstant() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:941:2: ( ( ( rule__Constant__Alternatives ) ) )
            // InternalFirstOrderLogic.g:942:2: ( ( rule__Constant__Alternatives ) )
            {
            // InternalFirstOrderLogic.g:942:2: ( ( rule__Constant__Alternatives ) )
            // InternalFirstOrderLogic.g:943:3: ( rule__Constant__Alternatives )
            {
             before(grammarAccess.getConstantAccess().getAlternatives()); 
            // InternalFirstOrderLogic.g:944:3: ( rule__Constant__Alternatives )
            // InternalFirstOrderLogic.g:944:4: rule__Constant__Alternatives
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
    // InternalFirstOrderLogic.g:952:1: rule__Predicate__Alternatives : ( ( ruleEquals ) | ( ruleInequality ) | ( ruleIsEmpty ) | ( ruleIsInstanceOf ) );
    public final void rule__Predicate__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:956:1: ( ( ruleEquals ) | ( ruleInequality ) | ( ruleIsEmpty ) | ( ruleIsInstanceOf ) )
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
                    // InternalFirstOrderLogic.g:957:2: ( ruleEquals )
                    {
                    // InternalFirstOrderLogic.g:957:2: ( ruleEquals )
                    // InternalFirstOrderLogic.g:958:3: ruleEquals
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
                    // InternalFirstOrderLogic.g:963:2: ( ruleInequality )
                    {
                    // InternalFirstOrderLogic.g:963:2: ( ruleInequality )
                    // InternalFirstOrderLogic.g:964:3: ruleInequality
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
                    // InternalFirstOrderLogic.g:969:2: ( ruleIsEmpty )
                    {
                    // InternalFirstOrderLogic.g:969:2: ( ruleIsEmpty )
                    // InternalFirstOrderLogic.g:970:3: ruleIsEmpty
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
                    // InternalFirstOrderLogic.g:975:2: ( ruleIsInstanceOf )
                    {
                    // InternalFirstOrderLogic.g:975:2: ( ruleIsInstanceOf )
                    // InternalFirstOrderLogic.g:976:3: ruleIsInstanceOf
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
    // InternalFirstOrderLogic.g:985:1: rule__Inequality__Alternatives : ( ( ruleGreater ) | ( ruleGreaterEqual ) | ( ruleSmaller ) | ( ruleSmallerEqual ) );
    public final void rule__Inequality__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:989:1: ( ( ruleGreater ) | ( ruleGreaterEqual ) | ( ruleSmaller ) | ( ruleSmallerEqual ) )
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
                    // InternalFirstOrderLogic.g:990:2: ( ruleGreater )
                    {
                    // InternalFirstOrderLogic.g:990:2: ( ruleGreater )
                    // InternalFirstOrderLogic.g:991:3: ruleGreater
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
                    // InternalFirstOrderLogic.g:996:2: ( ruleGreaterEqual )
                    {
                    // InternalFirstOrderLogic.g:996:2: ( ruleGreaterEqual )
                    // InternalFirstOrderLogic.g:997:3: ruleGreaterEqual
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
                    // InternalFirstOrderLogic.g:1002:2: ( ruleSmaller )
                    {
                    // InternalFirstOrderLogic.g:1002:2: ( ruleSmaller )
                    // InternalFirstOrderLogic.g:1003:3: ruleSmaller
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
                    // InternalFirstOrderLogic.g:1008:2: ( ruleSmallerEqual )
                    {
                    // InternalFirstOrderLogic.g:1008:2: ( ruleSmallerEqual )
                    // InternalFirstOrderLogic.g:1009:3: ruleSmallerEqual
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
    // InternalFirstOrderLogic.g:1018:1: rule__Quantifier__Alternatives : ( ( ruleForAll ) | ( ruleExists ) );
    public final void rule__Quantifier__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1022:1: ( ( ruleForAll ) | ( ruleExists ) )
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
                    // InternalFirstOrderLogic.g:1023:2: ( ruleForAll )
                    {
                    // InternalFirstOrderLogic.g:1023:2: ( ruleForAll )
                    // InternalFirstOrderLogic.g:1024:3: ruleForAll
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
                    // InternalFirstOrderLogic.g:1029:2: ( ruleExists )
                    {
                    // InternalFirstOrderLogic.g:1029:2: ( ruleExists )
                    // InternalFirstOrderLogic.g:1030:3: ruleExists
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
    // InternalFirstOrderLogic.g:1039:1: rule__BooleanExpression__Alternatives : ( ( ( rule__BooleanExpression__Group_0__0 ) ) | ( ruleUnaryFormula ) | ( ruleQuantifier ) | ( rulePredicate ) | ( ruleBoolConstant ) );
    public final void rule__BooleanExpression__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1043:1: ( ( ( rule__BooleanExpression__Group_0__0 ) ) | ( ruleUnaryFormula ) | ( ruleQuantifier ) | ( rulePredicate ) | ( ruleBoolConstant ) )
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
                    // InternalFirstOrderLogic.g:1044:2: ( ( rule__BooleanExpression__Group_0__0 ) )
                    {
                    // InternalFirstOrderLogic.g:1044:2: ( ( rule__BooleanExpression__Group_0__0 ) )
                    // InternalFirstOrderLogic.g:1045:3: ( rule__BooleanExpression__Group_0__0 )
                    {
                     before(grammarAccess.getBooleanExpressionAccess().getGroup_0()); 
                    // InternalFirstOrderLogic.g:1046:3: ( rule__BooleanExpression__Group_0__0 )
                    // InternalFirstOrderLogic.g:1046:4: rule__BooleanExpression__Group_0__0
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
                    // InternalFirstOrderLogic.g:1050:2: ( ruleUnaryFormula )
                    {
                    // InternalFirstOrderLogic.g:1050:2: ( ruleUnaryFormula )
                    // InternalFirstOrderLogic.g:1051:3: ruleUnaryFormula
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
                    // InternalFirstOrderLogic.g:1056:2: ( ruleQuantifier )
                    {
                    // InternalFirstOrderLogic.g:1056:2: ( ruleQuantifier )
                    // InternalFirstOrderLogic.g:1057:3: ruleQuantifier
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
                    // InternalFirstOrderLogic.g:1062:2: ( rulePredicate )
                    {
                    // InternalFirstOrderLogic.g:1062:2: ( rulePredicate )
                    // InternalFirstOrderLogic.g:1063:3: rulePredicate
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
                    // InternalFirstOrderLogic.g:1068:2: ( ruleBoolConstant )
                    {
                    // InternalFirstOrderLogic.g:1068:2: ( ruleBoolConstant )
                    // InternalFirstOrderLogic.g:1069:3: ruleBoolConstant
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
    // InternalFirstOrderLogic.g:1078:1: rule__BoolConstant__ValueAlternatives_1_0 : ( ( 'true' ) | ( 'false' ) );
    public final void rule__BoolConstant__ValueAlternatives_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1082:1: ( ( 'true' ) | ( 'false' ) )
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
                    // InternalFirstOrderLogic.g:1083:2: ( 'true' )
                    {
                    // InternalFirstOrderLogic.g:1083:2: ( 'true' )
                    // InternalFirstOrderLogic.g:1084:3: 'true'
                    {
                     before(grammarAccess.getBoolConstantAccess().getValueTrueKeyword_1_0_0()); 
                    match(input,11,FOLLOW_2); 
                     after(grammarAccess.getBoolConstantAccess().getValueTrueKeyword_1_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalFirstOrderLogic.g:1089:2: ( 'false' )
                    {
                    // InternalFirstOrderLogic.g:1089:2: ( 'false' )
                    // InternalFirstOrderLogic.g:1090:3: 'false'
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
    // InternalFirstOrderLogic.g:1099:1: rule__Term__Alternatives : ( ( ruleConstant ) | ( ruleVariableRef ) | ( ruleGetContainments ) | ( ruleGetContainer ) | ( ruleGetClosure ) | ( ruleSize ) | ( ruleConcatenate ) | ( ruleCapitalize ) );
    public final void rule__Term__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1103:1: ( ( ruleConstant ) | ( ruleVariableRef ) | ( ruleGetContainments ) | ( ruleGetContainer ) | ( ruleGetClosure ) | ( ruleSize ) | ( ruleConcatenate ) | ( ruleCapitalize ) )
            int alt6=8;
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
            case 45:
                {
                alt6=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // InternalFirstOrderLogic.g:1104:2: ( ruleConstant )
                    {
                    // InternalFirstOrderLogic.g:1104:2: ( ruleConstant )
                    // InternalFirstOrderLogic.g:1105:3: ruleConstant
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
                    // InternalFirstOrderLogic.g:1110:2: ( ruleVariableRef )
                    {
                    // InternalFirstOrderLogic.g:1110:2: ( ruleVariableRef )
                    // InternalFirstOrderLogic.g:1111:3: ruleVariableRef
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
                    // InternalFirstOrderLogic.g:1116:2: ( ruleGetContainments )
                    {
                    // InternalFirstOrderLogic.g:1116:2: ( ruleGetContainments )
                    // InternalFirstOrderLogic.g:1117:3: ruleGetContainments
                    {
                     before(grammarAccess.getTermAccess().getGetContainmentsParserRuleCall_2()); 
                    pushFollow(FOLLOW_2);
                    ruleGetContainments();

                    state._fsp--;

                     after(grammarAccess.getTermAccess().getGetContainmentsParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalFirstOrderLogic.g:1122:2: ( ruleGetContainer )
                    {
                    // InternalFirstOrderLogic.g:1122:2: ( ruleGetContainer )
                    // InternalFirstOrderLogic.g:1123:3: ruleGetContainer
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
                    // InternalFirstOrderLogic.g:1128:2: ( ruleGetClosure )
                    {
                    // InternalFirstOrderLogic.g:1128:2: ( ruleGetClosure )
                    // InternalFirstOrderLogic.g:1129:3: ruleGetClosure
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
                    // InternalFirstOrderLogic.g:1134:2: ( ruleSize )
                    {
                    // InternalFirstOrderLogic.g:1134:2: ( ruleSize )
                    // InternalFirstOrderLogic.g:1135:3: ruleSize
                    {
                     before(grammarAccess.getTermAccess().getSizeParserRuleCall_5()); 
                    pushFollow(FOLLOW_2);
                    ruleSize();

                    state._fsp--;

                     after(grammarAccess.getTermAccess().getSizeParserRuleCall_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalFirstOrderLogic.g:1140:2: ( ruleConcatenate )
                    {
                    // InternalFirstOrderLogic.g:1140:2: ( ruleConcatenate )
                    // InternalFirstOrderLogic.g:1141:3: ruleConcatenate
                    {
                     before(grammarAccess.getTermAccess().getConcatenateParserRuleCall_6()); 
                    pushFollow(FOLLOW_2);
                    ruleConcatenate();

                    state._fsp--;

                     after(grammarAccess.getTermAccess().getConcatenateParserRuleCall_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalFirstOrderLogic.g:1146:2: ( ruleCapitalize )
                    {
                    // InternalFirstOrderLogic.g:1146:2: ( ruleCapitalize )
                    // InternalFirstOrderLogic.g:1147:3: ruleCapitalize
                    {
                     before(grammarAccess.getTermAccess().getCapitalizeParserRuleCall_7()); 
                    pushFollow(FOLLOW_2);
                    ruleCapitalize();

                    state._fsp--;

                     after(grammarAccess.getTermAccess().getCapitalizeParserRuleCall_7()); 

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
    // InternalFirstOrderLogic.g:1156:1: rule__Constant__Alternatives : ( ( ( rule__Constant__Group_0__0 ) ) | ( ( rule__Constant__Group_1__0 ) ) | ( ruleBoolConstant ) );
    public final void rule__Constant__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1160:1: ( ( ( rule__Constant__Group_0__0 ) ) | ( ( rule__Constant__Group_1__0 ) ) | ( ruleBoolConstant ) )
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
                    // InternalFirstOrderLogic.g:1161:2: ( ( rule__Constant__Group_0__0 ) )
                    {
                    // InternalFirstOrderLogic.g:1161:2: ( ( rule__Constant__Group_0__0 ) )
                    // InternalFirstOrderLogic.g:1162:3: ( rule__Constant__Group_0__0 )
                    {
                     before(grammarAccess.getConstantAccess().getGroup_0()); 
                    // InternalFirstOrderLogic.g:1163:3: ( rule__Constant__Group_0__0 )
                    // InternalFirstOrderLogic.g:1163:4: rule__Constant__Group_0__0
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
                    // InternalFirstOrderLogic.g:1167:2: ( ( rule__Constant__Group_1__0 ) )
                    {
                    // InternalFirstOrderLogic.g:1167:2: ( ( rule__Constant__Group_1__0 ) )
                    // InternalFirstOrderLogic.g:1168:3: ( rule__Constant__Group_1__0 )
                    {
                     before(grammarAccess.getConstantAccess().getGroup_1()); 
                    // InternalFirstOrderLogic.g:1169:3: ( rule__Constant__Group_1__0 )
                    // InternalFirstOrderLogic.g:1169:4: rule__Constant__Group_1__0
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
                    // InternalFirstOrderLogic.g:1173:2: ( ruleBoolConstant )
                    {
                    // InternalFirstOrderLogic.g:1173:2: ( ruleBoolConstant )
                    // InternalFirstOrderLogic.g:1174:3: ruleBoolConstant
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
    // InternalFirstOrderLogic.g:1183:1: rule__ConstraintLibrary__Group__0 : rule__ConstraintLibrary__Group__0__Impl rule__ConstraintLibrary__Group__1 ;
    public final void rule__ConstraintLibrary__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1187:1: ( rule__ConstraintLibrary__Group__0__Impl rule__ConstraintLibrary__Group__1 )
            // InternalFirstOrderLogic.g:1188:2: rule__ConstraintLibrary__Group__0__Impl rule__ConstraintLibrary__Group__1
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
    // InternalFirstOrderLogic.g:1195:1: rule__ConstraintLibrary__Group__0__Impl : ( 'domain' ) ;
    public final void rule__ConstraintLibrary__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1199:1: ( ( 'domain' ) )
            // InternalFirstOrderLogic.g:1200:1: ( 'domain' )
            {
            // InternalFirstOrderLogic.g:1200:1: ( 'domain' )
            // InternalFirstOrderLogic.g:1201:2: 'domain'
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
    // InternalFirstOrderLogic.g:1210:1: rule__ConstraintLibrary__Group__1 : rule__ConstraintLibrary__Group__1__Impl rule__ConstraintLibrary__Group__2 ;
    public final void rule__ConstraintLibrary__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1214:1: ( rule__ConstraintLibrary__Group__1__Impl rule__ConstraintLibrary__Group__2 )
            // InternalFirstOrderLogic.g:1215:2: rule__ConstraintLibrary__Group__1__Impl rule__ConstraintLibrary__Group__2
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
    // InternalFirstOrderLogic.g:1222:1: rule__ConstraintLibrary__Group__1__Impl : ( ( rule__ConstraintLibrary__DomainAssignment_1 ) ) ;
    public final void rule__ConstraintLibrary__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1226:1: ( ( ( rule__ConstraintLibrary__DomainAssignment_1 ) ) )
            // InternalFirstOrderLogic.g:1227:1: ( ( rule__ConstraintLibrary__DomainAssignment_1 ) )
            {
            // InternalFirstOrderLogic.g:1227:1: ( ( rule__ConstraintLibrary__DomainAssignment_1 ) )
            // InternalFirstOrderLogic.g:1228:2: ( rule__ConstraintLibrary__DomainAssignment_1 )
            {
             before(grammarAccess.getConstraintLibraryAccess().getDomainAssignment_1()); 
            // InternalFirstOrderLogic.g:1229:2: ( rule__ConstraintLibrary__DomainAssignment_1 )
            // InternalFirstOrderLogic.g:1229:3: rule__ConstraintLibrary__DomainAssignment_1
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
    // InternalFirstOrderLogic.g:1237:1: rule__ConstraintLibrary__Group__2 : rule__ConstraintLibrary__Group__2__Impl rule__ConstraintLibrary__Group__3 ;
    public final void rule__ConstraintLibrary__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1241:1: ( rule__ConstraintLibrary__Group__2__Impl rule__ConstraintLibrary__Group__3 )
            // InternalFirstOrderLogic.g:1242:2: rule__ConstraintLibrary__Group__2__Impl rule__ConstraintLibrary__Group__3
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
    // InternalFirstOrderLogic.g:1249:1: rule__ConstraintLibrary__Group__2__Impl : ( 'import' ) ;
    public final void rule__ConstraintLibrary__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1253:1: ( ( 'import' ) )
            // InternalFirstOrderLogic.g:1254:1: ( 'import' )
            {
            // InternalFirstOrderLogic.g:1254:1: ( 'import' )
            // InternalFirstOrderLogic.g:1255:2: 'import'
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
    // InternalFirstOrderLogic.g:1264:1: rule__ConstraintLibrary__Group__3 : rule__ConstraintLibrary__Group__3__Impl rule__ConstraintLibrary__Group__4 ;
    public final void rule__ConstraintLibrary__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1268:1: ( rule__ConstraintLibrary__Group__3__Impl rule__ConstraintLibrary__Group__4 )
            // InternalFirstOrderLogic.g:1269:2: rule__ConstraintLibrary__Group__3__Impl rule__ConstraintLibrary__Group__4
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
    // InternalFirstOrderLogic.g:1276:1: rule__ConstraintLibrary__Group__3__Impl : ( ( rule__ConstraintLibrary__PackageImportAssignment_3 ) ) ;
    public final void rule__ConstraintLibrary__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1280:1: ( ( ( rule__ConstraintLibrary__PackageImportAssignment_3 ) ) )
            // InternalFirstOrderLogic.g:1281:1: ( ( rule__ConstraintLibrary__PackageImportAssignment_3 ) )
            {
            // InternalFirstOrderLogic.g:1281:1: ( ( rule__ConstraintLibrary__PackageImportAssignment_3 ) )
            // InternalFirstOrderLogic.g:1282:2: ( rule__ConstraintLibrary__PackageImportAssignment_3 )
            {
             before(grammarAccess.getConstraintLibraryAccess().getPackageImportAssignment_3()); 
            // InternalFirstOrderLogic.g:1283:2: ( rule__ConstraintLibrary__PackageImportAssignment_3 )
            // InternalFirstOrderLogic.g:1283:3: rule__ConstraintLibrary__PackageImportAssignment_3
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
    // InternalFirstOrderLogic.g:1291:1: rule__ConstraintLibrary__Group__4 : rule__ConstraintLibrary__Group__4__Impl ;
    public final void rule__ConstraintLibrary__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1295:1: ( rule__ConstraintLibrary__Group__4__Impl )
            // InternalFirstOrderLogic.g:1296:2: rule__ConstraintLibrary__Group__4__Impl
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
    // InternalFirstOrderLogic.g:1302:1: rule__ConstraintLibrary__Group__4__Impl : ( ( rule__ConstraintLibrary__ConstraintsAssignment_4 )* ) ;
    public final void rule__ConstraintLibrary__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1306:1: ( ( ( rule__ConstraintLibrary__ConstraintsAssignment_4 )* ) )
            // InternalFirstOrderLogic.g:1307:1: ( ( rule__ConstraintLibrary__ConstraintsAssignment_4 )* )
            {
            // InternalFirstOrderLogic.g:1307:1: ( ( rule__ConstraintLibrary__ConstraintsAssignment_4 )* )
            // InternalFirstOrderLogic.g:1308:2: ( rule__ConstraintLibrary__ConstraintsAssignment_4 )*
            {
             before(grammarAccess.getConstraintLibraryAccess().getConstraintsAssignment_4()); 
            // InternalFirstOrderLogic.g:1309:2: ( rule__ConstraintLibrary__ConstraintsAssignment_4 )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==15) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalFirstOrderLogic.g:1309:3: rule__ConstraintLibrary__ConstraintsAssignment_4
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
    // InternalFirstOrderLogic.g:1318:1: rule__Constraint__Group__0 : rule__Constraint__Group__0__Impl rule__Constraint__Group__1 ;
    public final void rule__Constraint__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1322:1: ( rule__Constraint__Group__0__Impl rule__Constraint__Group__1 )
            // InternalFirstOrderLogic.g:1323:2: rule__Constraint__Group__0__Impl rule__Constraint__Group__1
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
    // InternalFirstOrderLogic.g:1330:1: rule__Constraint__Group__0__Impl : ( 'constraint' ) ;
    public final void rule__Constraint__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1334:1: ( ( 'constraint' ) )
            // InternalFirstOrderLogic.g:1335:1: ( 'constraint' )
            {
            // InternalFirstOrderLogic.g:1335:1: ( 'constraint' )
            // InternalFirstOrderLogic.g:1336:2: 'constraint'
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
    // InternalFirstOrderLogic.g:1345:1: rule__Constraint__Group__1 : rule__Constraint__Group__1__Impl rule__Constraint__Group__2 ;
    public final void rule__Constraint__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1349:1: ( rule__Constraint__Group__1__Impl rule__Constraint__Group__2 )
            // InternalFirstOrderLogic.g:1350:2: rule__Constraint__Group__1__Impl rule__Constraint__Group__2
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
    // InternalFirstOrderLogic.g:1357:1: rule__Constraint__Group__1__Impl : ( ( rule__Constraint__NameAssignment_1 ) ) ;
    public final void rule__Constraint__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1361:1: ( ( ( rule__Constraint__NameAssignment_1 ) ) )
            // InternalFirstOrderLogic.g:1362:1: ( ( rule__Constraint__NameAssignment_1 ) )
            {
            // InternalFirstOrderLogic.g:1362:1: ( ( rule__Constraint__NameAssignment_1 ) )
            // InternalFirstOrderLogic.g:1363:2: ( rule__Constraint__NameAssignment_1 )
            {
             before(grammarAccess.getConstraintAccess().getNameAssignment_1()); 
            // InternalFirstOrderLogic.g:1364:2: ( rule__Constraint__NameAssignment_1 )
            // InternalFirstOrderLogic.g:1364:3: rule__Constraint__NameAssignment_1
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
    // InternalFirstOrderLogic.g:1372:1: rule__Constraint__Group__2 : rule__Constraint__Group__2__Impl rule__Constraint__Group__3 ;
    public final void rule__Constraint__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1376:1: ( rule__Constraint__Group__2__Impl rule__Constraint__Group__3 )
            // InternalFirstOrderLogic.g:1377:2: rule__Constraint__Group__2__Impl rule__Constraint__Group__3
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
    // InternalFirstOrderLogic.g:1384:1: rule__Constraint__Group__2__Impl : ( 'message' ) ;
    public final void rule__Constraint__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1388:1: ( ( 'message' ) )
            // InternalFirstOrderLogic.g:1389:1: ( 'message' )
            {
            // InternalFirstOrderLogic.g:1389:1: ( 'message' )
            // InternalFirstOrderLogic.g:1390:2: 'message'
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
    // InternalFirstOrderLogic.g:1399:1: rule__Constraint__Group__3 : rule__Constraint__Group__3__Impl rule__Constraint__Group__4 ;
    public final void rule__Constraint__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1403:1: ( rule__Constraint__Group__3__Impl rule__Constraint__Group__4 )
            // InternalFirstOrderLogic.g:1404:2: rule__Constraint__Group__3__Impl rule__Constraint__Group__4
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
    // InternalFirstOrderLogic.g:1411:1: rule__Constraint__Group__3__Impl : ( ( rule__Constraint__MessageAssignment_3 ) ) ;
    public final void rule__Constraint__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1415:1: ( ( ( rule__Constraint__MessageAssignment_3 ) ) )
            // InternalFirstOrderLogic.g:1416:1: ( ( rule__Constraint__MessageAssignment_3 ) )
            {
            // InternalFirstOrderLogic.g:1416:1: ( ( rule__Constraint__MessageAssignment_3 ) )
            // InternalFirstOrderLogic.g:1417:2: ( rule__Constraint__MessageAssignment_3 )
            {
             before(grammarAccess.getConstraintAccess().getMessageAssignment_3()); 
            // InternalFirstOrderLogic.g:1418:2: ( rule__Constraint__MessageAssignment_3 )
            // InternalFirstOrderLogic.g:1418:3: rule__Constraint__MessageAssignment_3
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
    // InternalFirstOrderLogic.g:1426:1: rule__Constraint__Group__4 : rule__Constraint__Group__4__Impl rule__Constraint__Group__5 ;
    public final void rule__Constraint__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1430:1: ( rule__Constraint__Group__4__Impl rule__Constraint__Group__5 )
            // InternalFirstOrderLogic.g:1431:2: rule__Constraint__Group__4__Impl rule__Constraint__Group__5
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
    // InternalFirstOrderLogic.g:1438:1: rule__Constraint__Group__4__Impl : ( 'context' ) ;
    public final void rule__Constraint__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1442:1: ( ( 'context' ) )
            // InternalFirstOrderLogic.g:1443:1: ( 'context' )
            {
            // InternalFirstOrderLogic.g:1443:1: ( 'context' )
            // InternalFirstOrderLogic.g:1444:2: 'context'
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
    // InternalFirstOrderLogic.g:1453:1: rule__Constraint__Group__5 : rule__Constraint__Group__5__Impl rule__Constraint__Group__6 ;
    public final void rule__Constraint__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1457:1: ( rule__Constraint__Group__5__Impl rule__Constraint__Group__6 )
            // InternalFirstOrderLogic.g:1458:2: rule__Constraint__Group__5__Impl rule__Constraint__Group__6
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
    // InternalFirstOrderLogic.g:1465:1: rule__Constraint__Group__5__Impl : ( ( rule__Constraint__VariableAssignment_5 ) ) ;
    public final void rule__Constraint__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1469:1: ( ( ( rule__Constraint__VariableAssignment_5 ) ) )
            // InternalFirstOrderLogic.g:1470:1: ( ( rule__Constraint__VariableAssignment_5 ) )
            {
            // InternalFirstOrderLogic.g:1470:1: ( ( rule__Constraint__VariableAssignment_5 ) )
            // InternalFirstOrderLogic.g:1471:2: ( rule__Constraint__VariableAssignment_5 )
            {
             before(grammarAccess.getConstraintAccess().getVariableAssignment_5()); 
            // InternalFirstOrderLogic.g:1472:2: ( rule__Constraint__VariableAssignment_5 )
            // InternalFirstOrderLogic.g:1472:3: rule__Constraint__VariableAssignment_5
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
    // InternalFirstOrderLogic.g:1480:1: rule__Constraint__Group__6 : rule__Constraint__Group__6__Impl rule__Constraint__Group__7 ;
    public final void rule__Constraint__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1484:1: ( rule__Constraint__Group__6__Impl rule__Constraint__Group__7 )
            // InternalFirstOrderLogic.g:1485:2: rule__Constraint__Group__6__Impl rule__Constraint__Group__7
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
    // InternalFirstOrderLogic.g:1492:1: rule__Constraint__Group__6__Impl : ( ':' ) ;
    public final void rule__Constraint__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1496:1: ( ( ':' ) )
            // InternalFirstOrderLogic.g:1497:1: ( ':' )
            {
            // InternalFirstOrderLogic.g:1497:1: ( ':' )
            // InternalFirstOrderLogic.g:1498:2: ':'
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
    // InternalFirstOrderLogic.g:1507:1: rule__Constraint__Group__7 : rule__Constraint__Group__7__Impl ;
    public final void rule__Constraint__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1511:1: ( rule__Constraint__Group__7__Impl )
            // InternalFirstOrderLogic.g:1512:2: rule__Constraint__Group__7__Impl
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
    // InternalFirstOrderLogic.g:1518:1: rule__Constraint__Group__7__Impl : ( ( rule__Constraint__FormulaAssignment_7 ) ) ;
    public final void rule__Constraint__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1522:1: ( ( ( rule__Constraint__FormulaAssignment_7 ) ) )
            // InternalFirstOrderLogic.g:1523:1: ( ( rule__Constraint__FormulaAssignment_7 ) )
            {
            // InternalFirstOrderLogic.g:1523:1: ( ( rule__Constraint__FormulaAssignment_7 ) )
            // InternalFirstOrderLogic.g:1524:2: ( rule__Constraint__FormulaAssignment_7 )
            {
             before(grammarAccess.getConstraintAccess().getFormulaAssignment_7()); 
            // InternalFirstOrderLogic.g:1525:2: ( rule__Constraint__FormulaAssignment_7 )
            // InternalFirstOrderLogic.g:1525:3: rule__Constraint__FormulaAssignment_7
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
    // InternalFirstOrderLogic.g:1534:1: rule__Variable__Group__0 : rule__Variable__Group__0__Impl rule__Variable__Group__1 ;
    public final void rule__Variable__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1538:1: ( rule__Variable__Group__0__Impl rule__Variable__Group__1 )
            // InternalFirstOrderLogic.g:1539:2: rule__Variable__Group__0__Impl rule__Variable__Group__1
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
    // InternalFirstOrderLogic.g:1546:1: rule__Variable__Group__0__Impl : ( ( rule__Variable__TypeAssignment_0 ) ) ;
    public final void rule__Variable__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1550:1: ( ( ( rule__Variable__TypeAssignment_0 ) ) )
            // InternalFirstOrderLogic.g:1551:1: ( ( rule__Variable__TypeAssignment_0 ) )
            {
            // InternalFirstOrderLogic.g:1551:1: ( ( rule__Variable__TypeAssignment_0 ) )
            // InternalFirstOrderLogic.g:1552:2: ( rule__Variable__TypeAssignment_0 )
            {
             before(grammarAccess.getVariableAccess().getTypeAssignment_0()); 
            // InternalFirstOrderLogic.g:1553:2: ( rule__Variable__TypeAssignment_0 )
            // InternalFirstOrderLogic.g:1553:3: rule__Variable__TypeAssignment_0
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
    // InternalFirstOrderLogic.g:1561:1: rule__Variable__Group__1 : rule__Variable__Group__1__Impl ;
    public final void rule__Variable__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1565:1: ( rule__Variable__Group__1__Impl )
            // InternalFirstOrderLogic.g:1566:2: rule__Variable__Group__1__Impl
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
    // InternalFirstOrderLogic.g:1572:1: rule__Variable__Group__1__Impl : ( ( rule__Variable__NameAssignment_1 ) ) ;
    public final void rule__Variable__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1576:1: ( ( ( rule__Variable__NameAssignment_1 ) ) )
            // InternalFirstOrderLogic.g:1577:1: ( ( rule__Variable__NameAssignment_1 ) )
            {
            // InternalFirstOrderLogic.g:1577:1: ( ( rule__Variable__NameAssignment_1 ) )
            // InternalFirstOrderLogic.g:1578:2: ( rule__Variable__NameAssignment_1 )
            {
             before(grammarAccess.getVariableAccess().getNameAssignment_1()); 
            // InternalFirstOrderLogic.g:1579:2: ( rule__Variable__NameAssignment_1 )
            // InternalFirstOrderLogic.g:1579:3: rule__Variable__NameAssignment_1
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
    // InternalFirstOrderLogic.g:1588:1: rule__Iff__Group__0 : rule__Iff__Group__0__Impl rule__Iff__Group__1 ;
    public final void rule__Iff__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1592:1: ( rule__Iff__Group__0__Impl rule__Iff__Group__1 )
            // InternalFirstOrderLogic.g:1593:2: rule__Iff__Group__0__Impl rule__Iff__Group__1
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
    // InternalFirstOrderLogic.g:1600:1: rule__Iff__Group__0__Impl : ( ruleIf ) ;
    public final void rule__Iff__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1604:1: ( ( ruleIf ) )
            // InternalFirstOrderLogic.g:1605:1: ( ruleIf )
            {
            // InternalFirstOrderLogic.g:1605:1: ( ruleIf )
            // InternalFirstOrderLogic.g:1606:2: ruleIf
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
    // InternalFirstOrderLogic.g:1615:1: rule__Iff__Group__1 : rule__Iff__Group__1__Impl ;
    public final void rule__Iff__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1619:1: ( rule__Iff__Group__1__Impl )
            // InternalFirstOrderLogic.g:1620:2: rule__Iff__Group__1__Impl
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
    // InternalFirstOrderLogic.g:1626:1: rule__Iff__Group__1__Impl : ( ( rule__Iff__Group_1__0 )* ) ;
    public final void rule__Iff__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1630:1: ( ( ( rule__Iff__Group_1__0 )* ) )
            // InternalFirstOrderLogic.g:1631:1: ( ( rule__Iff__Group_1__0 )* )
            {
            // InternalFirstOrderLogic.g:1631:1: ( ( rule__Iff__Group_1__0 )* )
            // InternalFirstOrderLogic.g:1632:2: ( rule__Iff__Group_1__0 )*
            {
             before(grammarAccess.getIffAccess().getGroup_1()); 
            // InternalFirstOrderLogic.g:1633:2: ( rule__Iff__Group_1__0 )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==19) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalFirstOrderLogic.g:1633:3: rule__Iff__Group_1__0
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
    // InternalFirstOrderLogic.g:1642:1: rule__Iff__Group_1__0 : rule__Iff__Group_1__0__Impl rule__Iff__Group_1__1 ;
    public final void rule__Iff__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1646:1: ( rule__Iff__Group_1__0__Impl rule__Iff__Group_1__1 )
            // InternalFirstOrderLogic.g:1647:2: rule__Iff__Group_1__0__Impl rule__Iff__Group_1__1
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
    // InternalFirstOrderLogic.g:1654:1: rule__Iff__Group_1__0__Impl : ( () ) ;
    public final void rule__Iff__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1658:1: ( ( () ) )
            // InternalFirstOrderLogic.g:1659:1: ( () )
            {
            // InternalFirstOrderLogic.g:1659:1: ( () )
            // InternalFirstOrderLogic.g:1660:2: ()
            {
             before(grammarAccess.getIffAccess().getIffLeftAction_1_0()); 
            // InternalFirstOrderLogic.g:1661:2: ()
            // InternalFirstOrderLogic.g:1661:3: 
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
    // InternalFirstOrderLogic.g:1669:1: rule__Iff__Group_1__1 : rule__Iff__Group_1__1__Impl rule__Iff__Group_1__2 ;
    public final void rule__Iff__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1673:1: ( rule__Iff__Group_1__1__Impl rule__Iff__Group_1__2 )
            // InternalFirstOrderLogic.g:1674:2: rule__Iff__Group_1__1__Impl rule__Iff__Group_1__2
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
    // InternalFirstOrderLogic.g:1681:1: rule__Iff__Group_1__1__Impl : ( '=' ) ;
    public final void rule__Iff__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1685:1: ( ( '=' ) )
            // InternalFirstOrderLogic.g:1686:1: ( '=' )
            {
            // InternalFirstOrderLogic.g:1686:1: ( '=' )
            // InternalFirstOrderLogic.g:1687:2: '='
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
    // InternalFirstOrderLogic.g:1696:1: rule__Iff__Group_1__2 : rule__Iff__Group_1__2__Impl ;
    public final void rule__Iff__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1700:1: ( rule__Iff__Group_1__2__Impl )
            // InternalFirstOrderLogic.g:1701:2: rule__Iff__Group_1__2__Impl
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
    // InternalFirstOrderLogic.g:1707:1: rule__Iff__Group_1__2__Impl : ( ( rule__Iff__RightAssignment_1_2 ) ) ;
    public final void rule__Iff__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1711:1: ( ( ( rule__Iff__RightAssignment_1_2 ) ) )
            // InternalFirstOrderLogic.g:1712:1: ( ( rule__Iff__RightAssignment_1_2 ) )
            {
            // InternalFirstOrderLogic.g:1712:1: ( ( rule__Iff__RightAssignment_1_2 ) )
            // InternalFirstOrderLogic.g:1713:2: ( rule__Iff__RightAssignment_1_2 )
            {
             before(grammarAccess.getIffAccess().getRightAssignment_1_2()); 
            // InternalFirstOrderLogic.g:1714:2: ( rule__Iff__RightAssignment_1_2 )
            // InternalFirstOrderLogic.g:1714:3: rule__Iff__RightAssignment_1_2
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
    // InternalFirstOrderLogic.g:1723:1: rule__If__Group__0 : rule__If__Group__0__Impl rule__If__Group__1 ;
    public final void rule__If__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1727:1: ( rule__If__Group__0__Impl rule__If__Group__1 )
            // InternalFirstOrderLogic.g:1728:2: rule__If__Group__0__Impl rule__If__Group__1
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
    // InternalFirstOrderLogic.g:1735:1: rule__If__Group__0__Impl : ( ruleXor ) ;
    public final void rule__If__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1739:1: ( ( ruleXor ) )
            // InternalFirstOrderLogic.g:1740:1: ( ruleXor )
            {
            // InternalFirstOrderLogic.g:1740:1: ( ruleXor )
            // InternalFirstOrderLogic.g:1741:2: ruleXor
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
    // InternalFirstOrderLogic.g:1750:1: rule__If__Group__1 : rule__If__Group__1__Impl ;
    public final void rule__If__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1754:1: ( rule__If__Group__1__Impl )
            // InternalFirstOrderLogic.g:1755:2: rule__If__Group__1__Impl
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
    // InternalFirstOrderLogic.g:1761:1: rule__If__Group__1__Impl : ( ( rule__If__Group_1__0 )* ) ;
    public final void rule__If__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1765:1: ( ( ( rule__If__Group_1__0 )* ) )
            // InternalFirstOrderLogic.g:1766:1: ( ( rule__If__Group_1__0 )* )
            {
            // InternalFirstOrderLogic.g:1766:1: ( ( rule__If__Group_1__0 )* )
            // InternalFirstOrderLogic.g:1767:2: ( rule__If__Group_1__0 )*
            {
             before(grammarAccess.getIfAccess().getGroup_1()); 
            // InternalFirstOrderLogic.g:1768:2: ( rule__If__Group_1__0 )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==20) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalFirstOrderLogic.g:1768:3: rule__If__Group_1__0
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
    // InternalFirstOrderLogic.g:1777:1: rule__If__Group_1__0 : rule__If__Group_1__0__Impl rule__If__Group_1__1 ;
    public final void rule__If__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1781:1: ( rule__If__Group_1__0__Impl rule__If__Group_1__1 )
            // InternalFirstOrderLogic.g:1782:2: rule__If__Group_1__0__Impl rule__If__Group_1__1
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
    // InternalFirstOrderLogic.g:1789:1: rule__If__Group_1__0__Impl : ( () ) ;
    public final void rule__If__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1793:1: ( ( () ) )
            // InternalFirstOrderLogic.g:1794:1: ( () )
            {
            // InternalFirstOrderLogic.g:1794:1: ( () )
            // InternalFirstOrderLogic.g:1795:2: ()
            {
             before(grammarAccess.getIfAccess().getIfLeftAction_1_0()); 
            // InternalFirstOrderLogic.g:1796:2: ()
            // InternalFirstOrderLogic.g:1796:3: 
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
    // InternalFirstOrderLogic.g:1804:1: rule__If__Group_1__1 : rule__If__Group_1__1__Impl rule__If__Group_1__2 ;
    public final void rule__If__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1808:1: ( rule__If__Group_1__1__Impl rule__If__Group_1__2 )
            // InternalFirstOrderLogic.g:1809:2: rule__If__Group_1__1__Impl rule__If__Group_1__2
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
    // InternalFirstOrderLogic.g:1816:1: rule__If__Group_1__1__Impl : ( 'implies' ) ;
    public final void rule__If__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1820:1: ( ( 'implies' ) )
            // InternalFirstOrderLogic.g:1821:1: ( 'implies' )
            {
            // InternalFirstOrderLogic.g:1821:1: ( 'implies' )
            // InternalFirstOrderLogic.g:1822:2: 'implies'
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
    // InternalFirstOrderLogic.g:1831:1: rule__If__Group_1__2 : rule__If__Group_1__2__Impl ;
    public final void rule__If__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1835:1: ( rule__If__Group_1__2__Impl )
            // InternalFirstOrderLogic.g:1836:2: rule__If__Group_1__2__Impl
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
    // InternalFirstOrderLogic.g:1842:1: rule__If__Group_1__2__Impl : ( ( rule__If__RightAssignment_1_2 ) ) ;
    public final void rule__If__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1846:1: ( ( ( rule__If__RightAssignment_1_2 ) ) )
            // InternalFirstOrderLogic.g:1847:1: ( ( rule__If__RightAssignment_1_2 ) )
            {
            // InternalFirstOrderLogic.g:1847:1: ( ( rule__If__RightAssignment_1_2 ) )
            // InternalFirstOrderLogic.g:1848:2: ( rule__If__RightAssignment_1_2 )
            {
             before(grammarAccess.getIfAccess().getRightAssignment_1_2()); 
            // InternalFirstOrderLogic.g:1849:2: ( rule__If__RightAssignment_1_2 )
            // InternalFirstOrderLogic.g:1849:3: rule__If__RightAssignment_1_2
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
    // InternalFirstOrderLogic.g:1858:1: rule__Xor__Group__0 : rule__Xor__Group__0__Impl rule__Xor__Group__1 ;
    public final void rule__Xor__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1862:1: ( rule__Xor__Group__0__Impl rule__Xor__Group__1 )
            // InternalFirstOrderLogic.g:1863:2: rule__Xor__Group__0__Impl rule__Xor__Group__1
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
    // InternalFirstOrderLogic.g:1870:1: rule__Xor__Group__0__Impl : ( ruleOr ) ;
    public final void rule__Xor__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1874:1: ( ( ruleOr ) )
            // InternalFirstOrderLogic.g:1875:1: ( ruleOr )
            {
            // InternalFirstOrderLogic.g:1875:1: ( ruleOr )
            // InternalFirstOrderLogic.g:1876:2: ruleOr
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
    // InternalFirstOrderLogic.g:1885:1: rule__Xor__Group__1 : rule__Xor__Group__1__Impl ;
    public final void rule__Xor__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1889:1: ( rule__Xor__Group__1__Impl )
            // InternalFirstOrderLogic.g:1890:2: rule__Xor__Group__1__Impl
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
    // InternalFirstOrderLogic.g:1896:1: rule__Xor__Group__1__Impl : ( ( rule__Xor__Group_1__0 )* ) ;
    public final void rule__Xor__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1900:1: ( ( ( rule__Xor__Group_1__0 )* ) )
            // InternalFirstOrderLogic.g:1901:1: ( ( rule__Xor__Group_1__0 )* )
            {
            // InternalFirstOrderLogic.g:1901:1: ( ( rule__Xor__Group_1__0 )* )
            // InternalFirstOrderLogic.g:1902:2: ( rule__Xor__Group_1__0 )*
            {
             before(grammarAccess.getXorAccess().getGroup_1()); 
            // InternalFirstOrderLogic.g:1903:2: ( rule__Xor__Group_1__0 )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==21) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalFirstOrderLogic.g:1903:3: rule__Xor__Group_1__0
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
    // InternalFirstOrderLogic.g:1912:1: rule__Xor__Group_1__0 : rule__Xor__Group_1__0__Impl rule__Xor__Group_1__1 ;
    public final void rule__Xor__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1916:1: ( rule__Xor__Group_1__0__Impl rule__Xor__Group_1__1 )
            // InternalFirstOrderLogic.g:1917:2: rule__Xor__Group_1__0__Impl rule__Xor__Group_1__1
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
    // InternalFirstOrderLogic.g:1924:1: rule__Xor__Group_1__0__Impl : ( () ) ;
    public final void rule__Xor__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1928:1: ( ( () ) )
            // InternalFirstOrderLogic.g:1929:1: ( () )
            {
            // InternalFirstOrderLogic.g:1929:1: ( () )
            // InternalFirstOrderLogic.g:1930:2: ()
            {
             before(grammarAccess.getXorAccess().getXorLeftAction_1_0()); 
            // InternalFirstOrderLogic.g:1931:2: ()
            // InternalFirstOrderLogic.g:1931:3: 
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
    // InternalFirstOrderLogic.g:1939:1: rule__Xor__Group_1__1 : rule__Xor__Group_1__1__Impl rule__Xor__Group_1__2 ;
    public final void rule__Xor__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1943:1: ( rule__Xor__Group_1__1__Impl rule__Xor__Group_1__2 )
            // InternalFirstOrderLogic.g:1944:2: rule__Xor__Group_1__1__Impl rule__Xor__Group_1__2
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
    // InternalFirstOrderLogic.g:1951:1: rule__Xor__Group_1__1__Impl : ( 'xor' ) ;
    public final void rule__Xor__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1955:1: ( ( 'xor' ) )
            // InternalFirstOrderLogic.g:1956:1: ( 'xor' )
            {
            // InternalFirstOrderLogic.g:1956:1: ( 'xor' )
            // InternalFirstOrderLogic.g:1957:2: 'xor'
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
    // InternalFirstOrderLogic.g:1966:1: rule__Xor__Group_1__2 : rule__Xor__Group_1__2__Impl ;
    public final void rule__Xor__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1970:1: ( rule__Xor__Group_1__2__Impl )
            // InternalFirstOrderLogic.g:1971:2: rule__Xor__Group_1__2__Impl
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
    // InternalFirstOrderLogic.g:1977:1: rule__Xor__Group_1__2__Impl : ( ( rule__Xor__RightAssignment_1_2 ) ) ;
    public final void rule__Xor__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1981:1: ( ( ( rule__Xor__RightAssignment_1_2 ) ) )
            // InternalFirstOrderLogic.g:1982:1: ( ( rule__Xor__RightAssignment_1_2 ) )
            {
            // InternalFirstOrderLogic.g:1982:1: ( ( rule__Xor__RightAssignment_1_2 ) )
            // InternalFirstOrderLogic.g:1983:2: ( rule__Xor__RightAssignment_1_2 )
            {
             before(grammarAccess.getXorAccess().getRightAssignment_1_2()); 
            // InternalFirstOrderLogic.g:1984:2: ( rule__Xor__RightAssignment_1_2 )
            // InternalFirstOrderLogic.g:1984:3: rule__Xor__RightAssignment_1_2
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
    // InternalFirstOrderLogic.g:1993:1: rule__Or__Group__0 : rule__Or__Group__0__Impl rule__Or__Group__1 ;
    public final void rule__Or__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1997:1: ( rule__Or__Group__0__Impl rule__Or__Group__1 )
            // InternalFirstOrderLogic.g:1998:2: rule__Or__Group__0__Impl rule__Or__Group__1
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
    // InternalFirstOrderLogic.g:2005:1: rule__Or__Group__0__Impl : ( ruleAnd ) ;
    public final void rule__Or__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2009:1: ( ( ruleAnd ) )
            // InternalFirstOrderLogic.g:2010:1: ( ruleAnd )
            {
            // InternalFirstOrderLogic.g:2010:1: ( ruleAnd )
            // InternalFirstOrderLogic.g:2011:2: ruleAnd
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
    // InternalFirstOrderLogic.g:2020:1: rule__Or__Group__1 : rule__Or__Group__1__Impl ;
    public final void rule__Or__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2024:1: ( rule__Or__Group__1__Impl )
            // InternalFirstOrderLogic.g:2025:2: rule__Or__Group__1__Impl
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
    // InternalFirstOrderLogic.g:2031:1: rule__Or__Group__1__Impl : ( ( rule__Or__Group_1__0 )* ) ;
    public final void rule__Or__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2035:1: ( ( ( rule__Or__Group_1__0 )* ) )
            // InternalFirstOrderLogic.g:2036:1: ( ( rule__Or__Group_1__0 )* )
            {
            // InternalFirstOrderLogic.g:2036:1: ( ( rule__Or__Group_1__0 )* )
            // InternalFirstOrderLogic.g:2037:2: ( rule__Or__Group_1__0 )*
            {
             before(grammarAccess.getOrAccess().getGroup_1()); 
            // InternalFirstOrderLogic.g:2038:2: ( rule__Or__Group_1__0 )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==22) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalFirstOrderLogic.g:2038:3: rule__Or__Group_1__0
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
    // InternalFirstOrderLogic.g:2047:1: rule__Or__Group_1__0 : rule__Or__Group_1__0__Impl rule__Or__Group_1__1 ;
    public final void rule__Or__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2051:1: ( rule__Or__Group_1__0__Impl rule__Or__Group_1__1 )
            // InternalFirstOrderLogic.g:2052:2: rule__Or__Group_1__0__Impl rule__Or__Group_1__1
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
    // InternalFirstOrderLogic.g:2059:1: rule__Or__Group_1__0__Impl : ( () ) ;
    public final void rule__Or__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2063:1: ( ( () ) )
            // InternalFirstOrderLogic.g:2064:1: ( () )
            {
            // InternalFirstOrderLogic.g:2064:1: ( () )
            // InternalFirstOrderLogic.g:2065:2: ()
            {
             before(grammarAccess.getOrAccess().getOrLeftAction_1_0()); 
            // InternalFirstOrderLogic.g:2066:2: ()
            // InternalFirstOrderLogic.g:2066:3: 
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
    // InternalFirstOrderLogic.g:2074:1: rule__Or__Group_1__1 : rule__Or__Group_1__1__Impl rule__Or__Group_1__2 ;
    public final void rule__Or__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2078:1: ( rule__Or__Group_1__1__Impl rule__Or__Group_1__2 )
            // InternalFirstOrderLogic.g:2079:2: rule__Or__Group_1__1__Impl rule__Or__Group_1__2
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
    // InternalFirstOrderLogic.g:2086:1: rule__Or__Group_1__1__Impl : ( 'or' ) ;
    public final void rule__Or__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2090:1: ( ( 'or' ) )
            // InternalFirstOrderLogic.g:2091:1: ( 'or' )
            {
            // InternalFirstOrderLogic.g:2091:1: ( 'or' )
            // InternalFirstOrderLogic.g:2092:2: 'or'
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
    // InternalFirstOrderLogic.g:2101:1: rule__Or__Group_1__2 : rule__Or__Group_1__2__Impl ;
    public final void rule__Or__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2105:1: ( rule__Or__Group_1__2__Impl )
            // InternalFirstOrderLogic.g:2106:2: rule__Or__Group_1__2__Impl
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
    // InternalFirstOrderLogic.g:2112:1: rule__Or__Group_1__2__Impl : ( ( rule__Or__RightAssignment_1_2 ) ) ;
    public final void rule__Or__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2116:1: ( ( ( rule__Or__RightAssignment_1_2 ) ) )
            // InternalFirstOrderLogic.g:2117:1: ( ( rule__Or__RightAssignment_1_2 ) )
            {
            // InternalFirstOrderLogic.g:2117:1: ( ( rule__Or__RightAssignment_1_2 ) )
            // InternalFirstOrderLogic.g:2118:2: ( rule__Or__RightAssignment_1_2 )
            {
             before(grammarAccess.getOrAccess().getRightAssignment_1_2()); 
            // InternalFirstOrderLogic.g:2119:2: ( rule__Or__RightAssignment_1_2 )
            // InternalFirstOrderLogic.g:2119:3: rule__Or__RightAssignment_1_2
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
    // InternalFirstOrderLogic.g:2128:1: rule__And__Group__0 : rule__And__Group__0__Impl rule__And__Group__1 ;
    public final void rule__And__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2132:1: ( rule__And__Group__0__Impl rule__And__Group__1 )
            // InternalFirstOrderLogic.g:2133:2: rule__And__Group__0__Impl rule__And__Group__1
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
    // InternalFirstOrderLogic.g:2140:1: rule__And__Group__0__Impl : ( ruleBooleanExpression ) ;
    public final void rule__And__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2144:1: ( ( ruleBooleanExpression ) )
            // InternalFirstOrderLogic.g:2145:1: ( ruleBooleanExpression )
            {
            // InternalFirstOrderLogic.g:2145:1: ( ruleBooleanExpression )
            // InternalFirstOrderLogic.g:2146:2: ruleBooleanExpression
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
    // InternalFirstOrderLogic.g:2155:1: rule__And__Group__1 : rule__And__Group__1__Impl ;
    public final void rule__And__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2159:1: ( rule__And__Group__1__Impl )
            // InternalFirstOrderLogic.g:2160:2: rule__And__Group__1__Impl
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
    // InternalFirstOrderLogic.g:2166:1: rule__And__Group__1__Impl : ( ( rule__And__Group_1__0 )* ) ;
    public final void rule__And__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2170:1: ( ( ( rule__And__Group_1__0 )* ) )
            // InternalFirstOrderLogic.g:2171:1: ( ( rule__And__Group_1__0 )* )
            {
            // InternalFirstOrderLogic.g:2171:1: ( ( rule__And__Group_1__0 )* )
            // InternalFirstOrderLogic.g:2172:2: ( rule__And__Group_1__0 )*
            {
             before(grammarAccess.getAndAccess().getGroup_1()); 
            // InternalFirstOrderLogic.g:2173:2: ( rule__And__Group_1__0 )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==23) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalFirstOrderLogic.g:2173:3: rule__And__Group_1__0
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
    // InternalFirstOrderLogic.g:2182:1: rule__And__Group_1__0 : rule__And__Group_1__0__Impl rule__And__Group_1__1 ;
    public final void rule__And__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2186:1: ( rule__And__Group_1__0__Impl rule__And__Group_1__1 )
            // InternalFirstOrderLogic.g:2187:2: rule__And__Group_1__0__Impl rule__And__Group_1__1
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
    // InternalFirstOrderLogic.g:2194:1: rule__And__Group_1__0__Impl : ( () ) ;
    public final void rule__And__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2198:1: ( ( () ) )
            // InternalFirstOrderLogic.g:2199:1: ( () )
            {
            // InternalFirstOrderLogic.g:2199:1: ( () )
            // InternalFirstOrderLogic.g:2200:2: ()
            {
             before(grammarAccess.getAndAccess().getAndLeftAction_1_0()); 
            // InternalFirstOrderLogic.g:2201:2: ()
            // InternalFirstOrderLogic.g:2201:3: 
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
    // InternalFirstOrderLogic.g:2209:1: rule__And__Group_1__1 : rule__And__Group_1__1__Impl rule__And__Group_1__2 ;
    public final void rule__And__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2213:1: ( rule__And__Group_1__1__Impl rule__And__Group_1__2 )
            // InternalFirstOrderLogic.g:2214:2: rule__And__Group_1__1__Impl rule__And__Group_1__2
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
    // InternalFirstOrderLogic.g:2221:1: rule__And__Group_1__1__Impl : ( 'and' ) ;
    public final void rule__And__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2225:1: ( ( 'and' ) )
            // InternalFirstOrderLogic.g:2226:1: ( 'and' )
            {
            // InternalFirstOrderLogic.g:2226:1: ( 'and' )
            // InternalFirstOrderLogic.g:2227:2: 'and'
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
    // InternalFirstOrderLogic.g:2236:1: rule__And__Group_1__2 : rule__And__Group_1__2__Impl ;
    public final void rule__And__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2240:1: ( rule__And__Group_1__2__Impl )
            // InternalFirstOrderLogic.g:2241:2: rule__And__Group_1__2__Impl
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
    // InternalFirstOrderLogic.g:2247:1: rule__And__Group_1__2__Impl : ( ( rule__And__RightAssignment_1_2 ) ) ;
    public final void rule__And__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2251:1: ( ( ( rule__And__RightAssignment_1_2 ) ) )
            // InternalFirstOrderLogic.g:2252:1: ( ( rule__And__RightAssignment_1_2 ) )
            {
            // InternalFirstOrderLogic.g:2252:1: ( ( rule__And__RightAssignment_1_2 ) )
            // InternalFirstOrderLogic.g:2253:2: ( rule__And__RightAssignment_1_2 )
            {
             before(grammarAccess.getAndAccess().getRightAssignment_1_2()); 
            // InternalFirstOrderLogic.g:2254:2: ( rule__And__RightAssignment_1_2 )
            // InternalFirstOrderLogic.g:2254:3: rule__And__RightAssignment_1_2
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
    // InternalFirstOrderLogic.g:2263:1: rule__Not__Group__0 : rule__Not__Group__0__Impl rule__Not__Group__1 ;
    public final void rule__Not__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2267:1: ( rule__Not__Group__0__Impl rule__Not__Group__1 )
            // InternalFirstOrderLogic.g:2268:2: rule__Not__Group__0__Impl rule__Not__Group__1
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
    // InternalFirstOrderLogic.g:2275:1: rule__Not__Group__0__Impl : ( () ) ;
    public final void rule__Not__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2279:1: ( ( () ) )
            // InternalFirstOrderLogic.g:2280:1: ( () )
            {
            // InternalFirstOrderLogic.g:2280:1: ( () )
            // InternalFirstOrderLogic.g:2281:2: ()
            {
             before(grammarAccess.getNotAccess().getNotAction_0()); 
            // InternalFirstOrderLogic.g:2282:2: ()
            // InternalFirstOrderLogic.g:2282:3: 
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
    // InternalFirstOrderLogic.g:2290:1: rule__Not__Group__1 : rule__Not__Group__1__Impl rule__Not__Group__2 ;
    public final void rule__Not__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2294:1: ( rule__Not__Group__1__Impl rule__Not__Group__2 )
            // InternalFirstOrderLogic.g:2295:2: rule__Not__Group__1__Impl rule__Not__Group__2
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
    // InternalFirstOrderLogic.g:2302:1: rule__Not__Group__1__Impl : ( 'not(' ) ;
    public final void rule__Not__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2306:1: ( ( 'not(' ) )
            // InternalFirstOrderLogic.g:2307:1: ( 'not(' )
            {
            // InternalFirstOrderLogic.g:2307:1: ( 'not(' )
            // InternalFirstOrderLogic.g:2308:2: 'not('
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
    // InternalFirstOrderLogic.g:2317:1: rule__Not__Group__2 : rule__Not__Group__2__Impl rule__Not__Group__3 ;
    public final void rule__Not__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2321:1: ( rule__Not__Group__2__Impl rule__Not__Group__3 )
            // InternalFirstOrderLogic.g:2322:2: rule__Not__Group__2__Impl rule__Not__Group__3
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
    // InternalFirstOrderLogic.g:2329:1: rule__Not__Group__2__Impl : ( ( rule__Not__NotAssignment_2 ) ) ;
    public final void rule__Not__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2333:1: ( ( ( rule__Not__NotAssignment_2 ) ) )
            // InternalFirstOrderLogic.g:2334:1: ( ( rule__Not__NotAssignment_2 ) )
            {
            // InternalFirstOrderLogic.g:2334:1: ( ( rule__Not__NotAssignment_2 ) )
            // InternalFirstOrderLogic.g:2335:2: ( rule__Not__NotAssignment_2 )
            {
             before(grammarAccess.getNotAccess().getNotAssignment_2()); 
            // InternalFirstOrderLogic.g:2336:2: ( rule__Not__NotAssignment_2 )
            // InternalFirstOrderLogic.g:2336:3: rule__Not__NotAssignment_2
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
    // InternalFirstOrderLogic.g:2344:1: rule__Not__Group__3 : rule__Not__Group__3__Impl ;
    public final void rule__Not__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2348:1: ( rule__Not__Group__3__Impl )
            // InternalFirstOrderLogic.g:2349:2: rule__Not__Group__3__Impl
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
    // InternalFirstOrderLogic.g:2355:1: rule__Not__Group__3__Impl : ( ')' ) ;
    public final void rule__Not__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2359:1: ( ( ')' ) )
            // InternalFirstOrderLogic.g:2360:1: ( ')' )
            {
            // InternalFirstOrderLogic.g:2360:1: ( ')' )
            // InternalFirstOrderLogic.g:2361:2: ')'
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
    // InternalFirstOrderLogic.g:2371:1: rule__Equals__Group__0 : rule__Equals__Group__0__Impl rule__Equals__Group__1 ;
    public final void rule__Equals__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2375:1: ( rule__Equals__Group__0__Impl rule__Equals__Group__1 )
            // InternalFirstOrderLogic.g:2376:2: rule__Equals__Group__0__Impl rule__Equals__Group__1
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
    // InternalFirstOrderLogic.g:2383:1: rule__Equals__Group__0__Impl : ( 'isEqual(' ) ;
    public final void rule__Equals__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2387:1: ( ( 'isEqual(' ) )
            // InternalFirstOrderLogic.g:2388:1: ( 'isEqual(' )
            {
            // InternalFirstOrderLogic.g:2388:1: ( 'isEqual(' )
            // InternalFirstOrderLogic.g:2389:2: 'isEqual('
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
    // InternalFirstOrderLogic.g:2398:1: rule__Equals__Group__1 : rule__Equals__Group__1__Impl rule__Equals__Group__2 ;
    public final void rule__Equals__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2402:1: ( rule__Equals__Group__1__Impl rule__Equals__Group__2 )
            // InternalFirstOrderLogic.g:2403:2: rule__Equals__Group__1__Impl rule__Equals__Group__2
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
    // InternalFirstOrderLogic.g:2410:1: rule__Equals__Group__1__Impl : ( ( rule__Equals__LeftAssignment_1 ) ) ;
    public final void rule__Equals__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2414:1: ( ( ( rule__Equals__LeftAssignment_1 ) ) )
            // InternalFirstOrderLogic.g:2415:1: ( ( rule__Equals__LeftAssignment_1 ) )
            {
            // InternalFirstOrderLogic.g:2415:1: ( ( rule__Equals__LeftAssignment_1 ) )
            // InternalFirstOrderLogic.g:2416:2: ( rule__Equals__LeftAssignment_1 )
            {
             before(grammarAccess.getEqualsAccess().getLeftAssignment_1()); 
            // InternalFirstOrderLogic.g:2417:2: ( rule__Equals__LeftAssignment_1 )
            // InternalFirstOrderLogic.g:2417:3: rule__Equals__LeftAssignment_1
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
    // InternalFirstOrderLogic.g:2425:1: rule__Equals__Group__2 : rule__Equals__Group__2__Impl rule__Equals__Group__3 ;
    public final void rule__Equals__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2429:1: ( rule__Equals__Group__2__Impl rule__Equals__Group__3 )
            // InternalFirstOrderLogic.g:2430:2: rule__Equals__Group__2__Impl rule__Equals__Group__3
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
    // InternalFirstOrderLogic.g:2437:1: rule__Equals__Group__2__Impl : ( ',' ) ;
    public final void rule__Equals__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2441:1: ( ( ',' ) )
            // InternalFirstOrderLogic.g:2442:1: ( ',' )
            {
            // InternalFirstOrderLogic.g:2442:1: ( ',' )
            // InternalFirstOrderLogic.g:2443:2: ','
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
    // InternalFirstOrderLogic.g:2452:1: rule__Equals__Group__3 : rule__Equals__Group__3__Impl rule__Equals__Group__4 ;
    public final void rule__Equals__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2456:1: ( rule__Equals__Group__3__Impl rule__Equals__Group__4 )
            // InternalFirstOrderLogic.g:2457:2: rule__Equals__Group__3__Impl rule__Equals__Group__4
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
    // InternalFirstOrderLogic.g:2464:1: rule__Equals__Group__3__Impl : ( ( rule__Equals__RightAssignment_3 ) ) ;
    public final void rule__Equals__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2468:1: ( ( ( rule__Equals__RightAssignment_3 ) ) )
            // InternalFirstOrderLogic.g:2469:1: ( ( rule__Equals__RightAssignment_3 ) )
            {
            // InternalFirstOrderLogic.g:2469:1: ( ( rule__Equals__RightAssignment_3 ) )
            // InternalFirstOrderLogic.g:2470:2: ( rule__Equals__RightAssignment_3 )
            {
             before(grammarAccess.getEqualsAccess().getRightAssignment_3()); 
            // InternalFirstOrderLogic.g:2471:2: ( rule__Equals__RightAssignment_3 )
            // InternalFirstOrderLogic.g:2471:3: rule__Equals__RightAssignment_3
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
    // InternalFirstOrderLogic.g:2479:1: rule__Equals__Group__4 : rule__Equals__Group__4__Impl ;
    public final void rule__Equals__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2483:1: ( rule__Equals__Group__4__Impl )
            // InternalFirstOrderLogic.g:2484:2: rule__Equals__Group__4__Impl
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
    // InternalFirstOrderLogic.g:2490:1: rule__Equals__Group__4__Impl : ( ')' ) ;
    public final void rule__Equals__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2494:1: ( ( ')' ) )
            // InternalFirstOrderLogic.g:2495:1: ( ')' )
            {
            // InternalFirstOrderLogic.g:2495:1: ( ')' )
            // InternalFirstOrderLogic.g:2496:2: ')'
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
    // InternalFirstOrderLogic.g:2506:1: rule__Greater__Group__0 : rule__Greater__Group__0__Impl rule__Greater__Group__1 ;
    public final void rule__Greater__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2510:1: ( rule__Greater__Group__0__Impl rule__Greater__Group__1 )
            // InternalFirstOrderLogic.g:2511:2: rule__Greater__Group__0__Impl rule__Greater__Group__1
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
    // InternalFirstOrderLogic.g:2518:1: rule__Greater__Group__0__Impl : ( 'isGreater(' ) ;
    public final void rule__Greater__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2522:1: ( ( 'isGreater(' ) )
            // InternalFirstOrderLogic.g:2523:1: ( 'isGreater(' )
            {
            // InternalFirstOrderLogic.g:2523:1: ( 'isGreater(' )
            // InternalFirstOrderLogic.g:2524:2: 'isGreater('
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
    // InternalFirstOrderLogic.g:2533:1: rule__Greater__Group__1 : rule__Greater__Group__1__Impl rule__Greater__Group__2 ;
    public final void rule__Greater__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2537:1: ( rule__Greater__Group__1__Impl rule__Greater__Group__2 )
            // InternalFirstOrderLogic.g:2538:2: rule__Greater__Group__1__Impl rule__Greater__Group__2
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
    // InternalFirstOrderLogic.g:2545:1: rule__Greater__Group__1__Impl : ( ( rule__Greater__LeftAssignment_1 ) ) ;
    public final void rule__Greater__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2549:1: ( ( ( rule__Greater__LeftAssignment_1 ) ) )
            // InternalFirstOrderLogic.g:2550:1: ( ( rule__Greater__LeftAssignment_1 ) )
            {
            // InternalFirstOrderLogic.g:2550:1: ( ( rule__Greater__LeftAssignment_1 ) )
            // InternalFirstOrderLogic.g:2551:2: ( rule__Greater__LeftAssignment_1 )
            {
             before(grammarAccess.getGreaterAccess().getLeftAssignment_1()); 
            // InternalFirstOrderLogic.g:2552:2: ( rule__Greater__LeftAssignment_1 )
            // InternalFirstOrderLogic.g:2552:3: rule__Greater__LeftAssignment_1
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
    // InternalFirstOrderLogic.g:2560:1: rule__Greater__Group__2 : rule__Greater__Group__2__Impl rule__Greater__Group__3 ;
    public final void rule__Greater__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2564:1: ( rule__Greater__Group__2__Impl rule__Greater__Group__3 )
            // InternalFirstOrderLogic.g:2565:2: rule__Greater__Group__2__Impl rule__Greater__Group__3
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
    // InternalFirstOrderLogic.g:2572:1: rule__Greater__Group__2__Impl : ( ',' ) ;
    public final void rule__Greater__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2576:1: ( ( ',' ) )
            // InternalFirstOrderLogic.g:2577:1: ( ',' )
            {
            // InternalFirstOrderLogic.g:2577:1: ( ',' )
            // InternalFirstOrderLogic.g:2578:2: ','
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
    // InternalFirstOrderLogic.g:2587:1: rule__Greater__Group__3 : rule__Greater__Group__3__Impl rule__Greater__Group__4 ;
    public final void rule__Greater__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2591:1: ( rule__Greater__Group__3__Impl rule__Greater__Group__4 )
            // InternalFirstOrderLogic.g:2592:2: rule__Greater__Group__3__Impl rule__Greater__Group__4
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
    // InternalFirstOrderLogic.g:2599:1: rule__Greater__Group__3__Impl : ( ( rule__Greater__RightAssignment_3 ) ) ;
    public final void rule__Greater__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2603:1: ( ( ( rule__Greater__RightAssignment_3 ) ) )
            // InternalFirstOrderLogic.g:2604:1: ( ( rule__Greater__RightAssignment_3 ) )
            {
            // InternalFirstOrderLogic.g:2604:1: ( ( rule__Greater__RightAssignment_3 ) )
            // InternalFirstOrderLogic.g:2605:2: ( rule__Greater__RightAssignment_3 )
            {
             before(grammarAccess.getGreaterAccess().getRightAssignment_3()); 
            // InternalFirstOrderLogic.g:2606:2: ( rule__Greater__RightAssignment_3 )
            // InternalFirstOrderLogic.g:2606:3: rule__Greater__RightAssignment_3
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
    // InternalFirstOrderLogic.g:2614:1: rule__Greater__Group__4 : rule__Greater__Group__4__Impl ;
    public final void rule__Greater__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2618:1: ( rule__Greater__Group__4__Impl )
            // InternalFirstOrderLogic.g:2619:2: rule__Greater__Group__4__Impl
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
    // InternalFirstOrderLogic.g:2625:1: rule__Greater__Group__4__Impl : ( ')' ) ;
    public final void rule__Greater__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2629:1: ( ( ')' ) )
            // InternalFirstOrderLogic.g:2630:1: ( ')' )
            {
            // InternalFirstOrderLogic.g:2630:1: ( ')' )
            // InternalFirstOrderLogic.g:2631:2: ')'
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
    // InternalFirstOrderLogic.g:2641:1: rule__GreaterEqual__Group__0 : rule__GreaterEqual__Group__0__Impl rule__GreaterEqual__Group__1 ;
    public final void rule__GreaterEqual__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2645:1: ( rule__GreaterEqual__Group__0__Impl rule__GreaterEqual__Group__1 )
            // InternalFirstOrderLogic.g:2646:2: rule__GreaterEqual__Group__0__Impl rule__GreaterEqual__Group__1
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
    // InternalFirstOrderLogic.g:2653:1: rule__GreaterEqual__Group__0__Impl : ( 'isGreaterEqual(' ) ;
    public final void rule__GreaterEqual__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2657:1: ( ( 'isGreaterEqual(' ) )
            // InternalFirstOrderLogic.g:2658:1: ( 'isGreaterEqual(' )
            {
            // InternalFirstOrderLogic.g:2658:1: ( 'isGreaterEqual(' )
            // InternalFirstOrderLogic.g:2659:2: 'isGreaterEqual('
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
    // InternalFirstOrderLogic.g:2668:1: rule__GreaterEqual__Group__1 : rule__GreaterEqual__Group__1__Impl rule__GreaterEqual__Group__2 ;
    public final void rule__GreaterEqual__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2672:1: ( rule__GreaterEqual__Group__1__Impl rule__GreaterEqual__Group__2 )
            // InternalFirstOrderLogic.g:2673:2: rule__GreaterEqual__Group__1__Impl rule__GreaterEqual__Group__2
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
    // InternalFirstOrderLogic.g:2680:1: rule__GreaterEqual__Group__1__Impl : ( ( rule__GreaterEqual__LeftAssignment_1 ) ) ;
    public final void rule__GreaterEqual__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2684:1: ( ( ( rule__GreaterEqual__LeftAssignment_1 ) ) )
            // InternalFirstOrderLogic.g:2685:1: ( ( rule__GreaterEqual__LeftAssignment_1 ) )
            {
            // InternalFirstOrderLogic.g:2685:1: ( ( rule__GreaterEqual__LeftAssignment_1 ) )
            // InternalFirstOrderLogic.g:2686:2: ( rule__GreaterEqual__LeftAssignment_1 )
            {
             before(grammarAccess.getGreaterEqualAccess().getLeftAssignment_1()); 
            // InternalFirstOrderLogic.g:2687:2: ( rule__GreaterEqual__LeftAssignment_1 )
            // InternalFirstOrderLogic.g:2687:3: rule__GreaterEqual__LeftAssignment_1
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
    // InternalFirstOrderLogic.g:2695:1: rule__GreaterEqual__Group__2 : rule__GreaterEqual__Group__2__Impl rule__GreaterEqual__Group__3 ;
    public final void rule__GreaterEqual__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2699:1: ( rule__GreaterEqual__Group__2__Impl rule__GreaterEqual__Group__3 )
            // InternalFirstOrderLogic.g:2700:2: rule__GreaterEqual__Group__2__Impl rule__GreaterEqual__Group__3
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
    // InternalFirstOrderLogic.g:2707:1: rule__GreaterEqual__Group__2__Impl : ( ',' ) ;
    public final void rule__GreaterEqual__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2711:1: ( ( ',' ) )
            // InternalFirstOrderLogic.g:2712:1: ( ',' )
            {
            // InternalFirstOrderLogic.g:2712:1: ( ',' )
            // InternalFirstOrderLogic.g:2713:2: ','
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
    // InternalFirstOrderLogic.g:2722:1: rule__GreaterEqual__Group__3 : rule__GreaterEqual__Group__3__Impl rule__GreaterEqual__Group__4 ;
    public final void rule__GreaterEqual__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2726:1: ( rule__GreaterEqual__Group__3__Impl rule__GreaterEqual__Group__4 )
            // InternalFirstOrderLogic.g:2727:2: rule__GreaterEqual__Group__3__Impl rule__GreaterEqual__Group__4
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
    // InternalFirstOrderLogic.g:2734:1: rule__GreaterEqual__Group__3__Impl : ( ( rule__GreaterEqual__RightAssignment_3 ) ) ;
    public final void rule__GreaterEqual__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2738:1: ( ( ( rule__GreaterEqual__RightAssignment_3 ) ) )
            // InternalFirstOrderLogic.g:2739:1: ( ( rule__GreaterEqual__RightAssignment_3 ) )
            {
            // InternalFirstOrderLogic.g:2739:1: ( ( rule__GreaterEqual__RightAssignment_3 ) )
            // InternalFirstOrderLogic.g:2740:2: ( rule__GreaterEqual__RightAssignment_3 )
            {
             before(grammarAccess.getGreaterEqualAccess().getRightAssignment_3()); 
            // InternalFirstOrderLogic.g:2741:2: ( rule__GreaterEqual__RightAssignment_3 )
            // InternalFirstOrderLogic.g:2741:3: rule__GreaterEqual__RightAssignment_3
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
    // InternalFirstOrderLogic.g:2749:1: rule__GreaterEqual__Group__4 : rule__GreaterEqual__Group__4__Impl ;
    public final void rule__GreaterEqual__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2753:1: ( rule__GreaterEqual__Group__4__Impl )
            // InternalFirstOrderLogic.g:2754:2: rule__GreaterEqual__Group__4__Impl
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
    // InternalFirstOrderLogic.g:2760:1: rule__GreaterEqual__Group__4__Impl : ( ')' ) ;
    public final void rule__GreaterEqual__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2764:1: ( ( ')' ) )
            // InternalFirstOrderLogic.g:2765:1: ( ')' )
            {
            // InternalFirstOrderLogic.g:2765:1: ( ')' )
            // InternalFirstOrderLogic.g:2766:2: ')'
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
    // InternalFirstOrderLogic.g:2776:1: rule__Smaller__Group__0 : rule__Smaller__Group__0__Impl rule__Smaller__Group__1 ;
    public final void rule__Smaller__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2780:1: ( rule__Smaller__Group__0__Impl rule__Smaller__Group__1 )
            // InternalFirstOrderLogic.g:2781:2: rule__Smaller__Group__0__Impl rule__Smaller__Group__1
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
    // InternalFirstOrderLogic.g:2788:1: rule__Smaller__Group__0__Impl : ( 'isSmaller(' ) ;
    public final void rule__Smaller__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2792:1: ( ( 'isSmaller(' ) )
            // InternalFirstOrderLogic.g:2793:1: ( 'isSmaller(' )
            {
            // InternalFirstOrderLogic.g:2793:1: ( 'isSmaller(' )
            // InternalFirstOrderLogic.g:2794:2: 'isSmaller('
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
    // InternalFirstOrderLogic.g:2803:1: rule__Smaller__Group__1 : rule__Smaller__Group__1__Impl rule__Smaller__Group__2 ;
    public final void rule__Smaller__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2807:1: ( rule__Smaller__Group__1__Impl rule__Smaller__Group__2 )
            // InternalFirstOrderLogic.g:2808:2: rule__Smaller__Group__1__Impl rule__Smaller__Group__2
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
    // InternalFirstOrderLogic.g:2815:1: rule__Smaller__Group__1__Impl : ( ( rule__Smaller__LeftAssignment_1 ) ) ;
    public final void rule__Smaller__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2819:1: ( ( ( rule__Smaller__LeftAssignment_1 ) ) )
            // InternalFirstOrderLogic.g:2820:1: ( ( rule__Smaller__LeftAssignment_1 ) )
            {
            // InternalFirstOrderLogic.g:2820:1: ( ( rule__Smaller__LeftAssignment_1 ) )
            // InternalFirstOrderLogic.g:2821:2: ( rule__Smaller__LeftAssignment_1 )
            {
             before(grammarAccess.getSmallerAccess().getLeftAssignment_1()); 
            // InternalFirstOrderLogic.g:2822:2: ( rule__Smaller__LeftAssignment_1 )
            // InternalFirstOrderLogic.g:2822:3: rule__Smaller__LeftAssignment_1
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
    // InternalFirstOrderLogic.g:2830:1: rule__Smaller__Group__2 : rule__Smaller__Group__2__Impl rule__Smaller__Group__3 ;
    public final void rule__Smaller__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2834:1: ( rule__Smaller__Group__2__Impl rule__Smaller__Group__3 )
            // InternalFirstOrderLogic.g:2835:2: rule__Smaller__Group__2__Impl rule__Smaller__Group__3
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
    // InternalFirstOrderLogic.g:2842:1: rule__Smaller__Group__2__Impl : ( ',' ) ;
    public final void rule__Smaller__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2846:1: ( ( ',' ) )
            // InternalFirstOrderLogic.g:2847:1: ( ',' )
            {
            // InternalFirstOrderLogic.g:2847:1: ( ',' )
            // InternalFirstOrderLogic.g:2848:2: ','
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
    // InternalFirstOrderLogic.g:2857:1: rule__Smaller__Group__3 : rule__Smaller__Group__3__Impl rule__Smaller__Group__4 ;
    public final void rule__Smaller__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2861:1: ( rule__Smaller__Group__3__Impl rule__Smaller__Group__4 )
            // InternalFirstOrderLogic.g:2862:2: rule__Smaller__Group__3__Impl rule__Smaller__Group__4
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
    // InternalFirstOrderLogic.g:2869:1: rule__Smaller__Group__3__Impl : ( ( rule__Smaller__RightAssignment_3 ) ) ;
    public final void rule__Smaller__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2873:1: ( ( ( rule__Smaller__RightAssignment_3 ) ) )
            // InternalFirstOrderLogic.g:2874:1: ( ( rule__Smaller__RightAssignment_3 ) )
            {
            // InternalFirstOrderLogic.g:2874:1: ( ( rule__Smaller__RightAssignment_3 ) )
            // InternalFirstOrderLogic.g:2875:2: ( rule__Smaller__RightAssignment_3 )
            {
             before(grammarAccess.getSmallerAccess().getRightAssignment_3()); 
            // InternalFirstOrderLogic.g:2876:2: ( rule__Smaller__RightAssignment_3 )
            // InternalFirstOrderLogic.g:2876:3: rule__Smaller__RightAssignment_3
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
    // InternalFirstOrderLogic.g:2884:1: rule__Smaller__Group__4 : rule__Smaller__Group__4__Impl ;
    public final void rule__Smaller__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2888:1: ( rule__Smaller__Group__4__Impl )
            // InternalFirstOrderLogic.g:2889:2: rule__Smaller__Group__4__Impl
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
    // InternalFirstOrderLogic.g:2895:1: rule__Smaller__Group__4__Impl : ( ')' ) ;
    public final void rule__Smaller__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2899:1: ( ( ')' ) )
            // InternalFirstOrderLogic.g:2900:1: ( ')' )
            {
            // InternalFirstOrderLogic.g:2900:1: ( ')' )
            // InternalFirstOrderLogic.g:2901:2: ')'
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
    // InternalFirstOrderLogic.g:2911:1: rule__SmallerEqual__Group__0 : rule__SmallerEqual__Group__0__Impl rule__SmallerEqual__Group__1 ;
    public final void rule__SmallerEqual__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2915:1: ( rule__SmallerEqual__Group__0__Impl rule__SmallerEqual__Group__1 )
            // InternalFirstOrderLogic.g:2916:2: rule__SmallerEqual__Group__0__Impl rule__SmallerEqual__Group__1
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
    // InternalFirstOrderLogic.g:2923:1: rule__SmallerEqual__Group__0__Impl : ( 'isSmallerEqual(' ) ;
    public final void rule__SmallerEqual__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2927:1: ( ( 'isSmallerEqual(' ) )
            // InternalFirstOrderLogic.g:2928:1: ( 'isSmallerEqual(' )
            {
            // InternalFirstOrderLogic.g:2928:1: ( 'isSmallerEqual(' )
            // InternalFirstOrderLogic.g:2929:2: 'isSmallerEqual('
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
    // InternalFirstOrderLogic.g:2938:1: rule__SmallerEqual__Group__1 : rule__SmallerEqual__Group__1__Impl rule__SmallerEqual__Group__2 ;
    public final void rule__SmallerEqual__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2942:1: ( rule__SmallerEqual__Group__1__Impl rule__SmallerEqual__Group__2 )
            // InternalFirstOrderLogic.g:2943:2: rule__SmallerEqual__Group__1__Impl rule__SmallerEqual__Group__2
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
    // InternalFirstOrderLogic.g:2950:1: rule__SmallerEqual__Group__1__Impl : ( ( rule__SmallerEqual__LeftAssignment_1 ) ) ;
    public final void rule__SmallerEqual__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2954:1: ( ( ( rule__SmallerEqual__LeftAssignment_1 ) ) )
            // InternalFirstOrderLogic.g:2955:1: ( ( rule__SmallerEqual__LeftAssignment_1 ) )
            {
            // InternalFirstOrderLogic.g:2955:1: ( ( rule__SmallerEqual__LeftAssignment_1 ) )
            // InternalFirstOrderLogic.g:2956:2: ( rule__SmallerEqual__LeftAssignment_1 )
            {
             before(grammarAccess.getSmallerEqualAccess().getLeftAssignment_1()); 
            // InternalFirstOrderLogic.g:2957:2: ( rule__SmallerEqual__LeftAssignment_1 )
            // InternalFirstOrderLogic.g:2957:3: rule__SmallerEqual__LeftAssignment_1
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
    // InternalFirstOrderLogic.g:2965:1: rule__SmallerEqual__Group__2 : rule__SmallerEqual__Group__2__Impl rule__SmallerEqual__Group__3 ;
    public final void rule__SmallerEqual__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2969:1: ( rule__SmallerEqual__Group__2__Impl rule__SmallerEqual__Group__3 )
            // InternalFirstOrderLogic.g:2970:2: rule__SmallerEqual__Group__2__Impl rule__SmallerEqual__Group__3
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
    // InternalFirstOrderLogic.g:2977:1: rule__SmallerEqual__Group__2__Impl : ( ',' ) ;
    public final void rule__SmallerEqual__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2981:1: ( ( ',' ) )
            // InternalFirstOrderLogic.g:2982:1: ( ',' )
            {
            // InternalFirstOrderLogic.g:2982:1: ( ',' )
            // InternalFirstOrderLogic.g:2983:2: ','
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
    // InternalFirstOrderLogic.g:2992:1: rule__SmallerEqual__Group__3 : rule__SmallerEqual__Group__3__Impl rule__SmallerEqual__Group__4 ;
    public final void rule__SmallerEqual__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2996:1: ( rule__SmallerEqual__Group__3__Impl rule__SmallerEqual__Group__4 )
            // InternalFirstOrderLogic.g:2997:2: rule__SmallerEqual__Group__3__Impl rule__SmallerEqual__Group__4
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
    // InternalFirstOrderLogic.g:3004:1: rule__SmallerEqual__Group__3__Impl : ( ( rule__SmallerEqual__RightAssignment_3 ) ) ;
    public final void rule__SmallerEqual__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3008:1: ( ( ( rule__SmallerEqual__RightAssignment_3 ) ) )
            // InternalFirstOrderLogic.g:3009:1: ( ( rule__SmallerEqual__RightAssignment_3 ) )
            {
            // InternalFirstOrderLogic.g:3009:1: ( ( rule__SmallerEqual__RightAssignment_3 ) )
            // InternalFirstOrderLogic.g:3010:2: ( rule__SmallerEqual__RightAssignment_3 )
            {
             before(grammarAccess.getSmallerEqualAccess().getRightAssignment_3()); 
            // InternalFirstOrderLogic.g:3011:2: ( rule__SmallerEqual__RightAssignment_3 )
            // InternalFirstOrderLogic.g:3011:3: rule__SmallerEqual__RightAssignment_3
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
    // InternalFirstOrderLogic.g:3019:1: rule__SmallerEqual__Group__4 : rule__SmallerEqual__Group__4__Impl ;
    public final void rule__SmallerEqual__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3023:1: ( rule__SmallerEqual__Group__4__Impl )
            // InternalFirstOrderLogic.g:3024:2: rule__SmallerEqual__Group__4__Impl
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
    // InternalFirstOrderLogic.g:3030:1: rule__SmallerEqual__Group__4__Impl : ( ')' ) ;
    public final void rule__SmallerEqual__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3034:1: ( ( ')' ) )
            // InternalFirstOrderLogic.g:3035:1: ( ')' )
            {
            // InternalFirstOrderLogic.g:3035:1: ( ')' )
            // InternalFirstOrderLogic.g:3036:2: ')'
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
    // InternalFirstOrderLogic.g:3046:1: rule__IsEmpty__Group__0 : rule__IsEmpty__Group__0__Impl rule__IsEmpty__Group__1 ;
    public final void rule__IsEmpty__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3050:1: ( rule__IsEmpty__Group__0__Impl rule__IsEmpty__Group__1 )
            // InternalFirstOrderLogic.g:3051:2: rule__IsEmpty__Group__0__Impl rule__IsEmpty__Group__1
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
    // InternalFirstOrderLogic.g:3058:1: rule__IsEmpty__Group__0__Impl : ( 'isEmpty(' ) ;
    public final void rule__IsEmpty__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3062:1: ( ( 'isEmpty(' ) )
            // InternalFirstOrderLogic.g:3063:1: ( 'isEmpty(' )
            {
            // InternalFirstOrderLogic.g:3063:1: ( 'isEmpty(' )
            // InternalFirstOrderLogic.g:3064:2: 'isEmpty('
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
    // InternalFirstOrderLogic.g:3073:1: rule__IsEmpty__Group__1 : rule__IsEmpty__Group__1__Impl rule__IsEmpty__Group__2 ;
    public final void rule__IsEmpty__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3077:1: ( rule__IsEmpty__Group__1__Impl rule__IsEmpty__Group__2 )
            // InternalFirstOrderLogic.g:3078:2: rule__IsEmpty__Group__1__Impl rule__IsEmpty__Group__2
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
    // InternalFirstOrderLogic.g:3085:1: rule__IsEmpty__Group__1__Impl : ( ( rule__IsEmpty__TermAssignment_1 ) ) ;
    public final void rule__IsEmpty__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3089:1: ( ( ( rule__IsEmpty__TermAssignment_1 ) ) )
            // InternalFirstOrderLogic.g:3090:1: ( ( rule__IsEmpty__TermAssignment_1 ) )
            {
            // InternalFirstOrderLogic.g:3090:1: ( ( rule__IsEmpty__TermAssignment_1 ) )
            // InternalFirstOrderLogic.g:3091:2: ( rule__IsEmpty__TermAssignment_1 )
            {
             before(grammarAccess.getIsEmptyAccess().getTermAssignment_1()); 
            // InternalFirstOrderLogic.g:3092:2: ( rule__IsEmpty__TermAssignment_1 )
            // InternalFirstOrderLogic.g:3092:3: rule__IsEmpty__TermAssignment_1
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
    // InternalFirstOrderLogic.g:3100:1: rule__IsEmpty__Group__2 : rule__IsEmpty__Group__2__Impl ;
    public final void rule__IsEmpty__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3104:1: ( rule__IsEmpty__Group__2__Impl )
            // InternalFirstOrderLogic.g:3105:2: rule__IsEmpty__Group__2__Impl
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
    // InternalFirstOrderLogic.g:3111:1: rule__IsEmpty__Group__2__Impl : ( ')' ) ;
    public final void rule__IsEmpty__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3115:1: ( ( ')' ) )
            // InternalFirstOrderLogic.g:3116:1: ( ')' )
            {
            // InternalFirstOrderLogic.g:3116:1: ( ')' )
            // InternalFirstOrderLogic.g:3117:2: ')'
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
    // InternalFirstOrderLogic.g:3127:1: rule__IsInstanceOf__Group__0 : rule__IsInstanceOf__Group__0__Impl rule__IsInstanceOf__Group__1 ;
    public final void rule__IsInstanceOf__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3131:1: ( rule__IsInstanceOf__Group__0__Impl rule__IsInstanceOf__Group__1 )
            // InternalFirstOrderLogic.g:3132:2: rule__IsInstanceOf__Group__0__Impl rule__IsInstanceOf__Group__1
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
    // InternalFirstOrderLogic.g:3139:1: rule__IsInstanceOf__Group__0__Impl : ( 'isInstanceOf(' ) ;
    public final void rule__IsInstanceOf__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3143:1: ( ( 'isInstanceOf(' ) )
            // InternalFirstOrderLogic.g:3144:1: ( 'isInstanceOf(' )
            {
            // InternalFirstOrderLogic.g:3144:1: ( 'isInstanceOf(' )
            // InternalFirstOrderLogic.g:3145:2: 'isInstanceOf('
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
    // InternalFirstOrderLogic.g:3154:1: rule__IsInstanceOf__Group__1 : rule__IsInstanceOf__Group__1__Impl rule__IsInstanceOf__Group__2 ;
    public final void rule__IsInstanceOf__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3158:1: ( rule__IsInstanceOf__Group__1__Impl rule__IsInstanceOf__Group__2 )
            // InternalFirstOrderLogic.g:3159:2: rule__IsInstanceOf__Group__1__Impl rule__IsInstanceOf__Group__2
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
    // InternalFirstOrderLogic.g:3166:1: rule__IsInstanceOf__Group__1__Impl : ( ( rule__IsInstanceOf__TermAssignment_1 ) ) ;
    public final void rule__IsInstanceOf__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3170:1: ( ( ( rule__IsInstanceOf__TermAssignment_1 ) ) )
            // InternalFirstOrderLogic.g:3171:1: ( ( rule__IsInstanceOf__TermAssignment_1 ) )
            {
            // InternalFirstOrderLogic.g:3171:1: ( ( rule__IsInstanceOf__TermAssignment_1 ) )
            // InternalFirstOrderLogic.g:3172:2: ( rule__IsInstanceOf__TermAssignment_1 )
            {
             before(grammarAccess.getIsInstanceOfAccess().getTermAssignment_1()); 
            // InternalFirstOrderLogic.g:3173:2: ( rule__IsInstanceOf__TermAssignment_1 )
            // InternalFirstOrderLogic.g:3173:3: rule__IsInstanceOf__TermAssignment_1
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
    // InternalFirstOrderLogic.g:3181:1: rule__IsInstanceOf__Group__2 : rule__IsInstanceOf__Group__2__Impl rule__IsInstanceOf__Group__3 ;
    public final void rule__IsInstanceOf__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3185:1: ( rule__IsInstanceOf__Group__2__Impl rule__IsInstanceOf__Group__3 )
            // InternalFirstOrderLogic.g:3186:2: rule__IsInstanceOf__Group__2__Impl rule__IsInstanceOf__Group__3
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
    // InternalFirstOrderLogic.g:3193:1: rule__IsInstanceOf__Group__2__Impl : ( ',' ) ;
    public final void rule__IsInstanceOf__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3197:1: ( ( ',' ) )
            // InternalFirstOrderLogic.g:3198:1: ( ',' )
            {
            // InternalFirstOrderLogic.g:3198:1: ( ',' )
            // InternalFirstOrderLogic.g:3199:2: ','
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
    // InternalFirstOrderLogic.g:3208:1: rule__IsInstanceOf__Group__3 : rule__IsInstanceOf__Group__3__Impl rule__IsInstanceOf__Group__4 ;
    public final void rule__IsInstanceOf__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3212:1: ( rule__IsInstanceOf__Group__3__Impl rule__IsInstanceOf__Group__4 )
            // InternalFirstOrderLogic.g:3213:2: rule__IsInstanceOf__Group__3__Impl rule__IsInstanceOf__Group__4
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
    // InternalFirstOrderLogic.g:3220:1: rule__IsInstanceOf__Group__3__Impl : ( ( rule__IsInstanceOf__TypeAssignment_3 ) ) ;
    public final void rule__IsInstanceOf__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3224:1: ( ( ( rule__IsInstanceOf__TypeAssignment_3 ) ) )
            // InternalFirstOrderLogic.g:3225:1: ( ( rule__IsInstanceOf__TypeAssignment_3 ) )
            {
            // InternalFirstOrderLogic.g:3225:1: ( ( rule__IsInstanceOf__TypeAssignment_3 ) )
            // InternalFirstOrderLogic.g:3226:2: ( rule__IsInstanceOf__TypeAssignment_3 )
            {
             before(grammarAccess.getIsInstanceOfAccess().getTypeAssignment_3()); 
            // InternalFirstOrderLogic.g:3227:2: ( rule__IsInstanceOf__TypeAssignment_3 )
            // InternalFirstOrderLogic.g:3227:3: rule__IsInstanceOf__TypeAssignment_3
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
    // InternalFirstOrderLogic.g:3235:1: rule__IsInstanceOf__Group__4 : rule__IsInstanceOf__Group__4__Impl ;
    public final void rule__IsInstanceOf__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3239:1: ( rule__IsInstanceOf__Group__4__Impl )
            // InternalFirstOrderLogic.g:3240:2: rule__IsInstanceOf__Group__4__Impl
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
    // InternalFirstOrderLogic.g:3246:1: rule__IsInstanceOf__Group__4__Impl : ( ')' ) ;
    public final void rule__IsInstanceOf__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3250:1: ( ( ')' ) )
            // InternalFirstOrderLogic.g:3251:1: ( ')' )
            {
            // InternalFirstOrderLogic.g:3251:1: ( ')' )
            // InternalFirstOrderLogic.g:3252:2: ')'
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
    // InternalFirstOrderLogic.g:3262:1: rule__ForAll__Group__0 : rule__ForAll__Group__0__Impl rule__ForAll__Group__1 ;
    public final void rule__ForAll__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3266:1: ( rule__ForAll__Group__0__Impl rule__ForAll__Group__1 )
            // InternalFirstOrderLogic.g:3267:2: rule__ForAll__Group__0__Impl rule__ForAll__Group__1
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
    // InternalFirstOrderLogic.g:3274:1: rule__ForAll__Group__0__Impl : ( () ) ;
    public final void rule__ForAll__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3278:1: ( ( () ) )
            // InternalFirstOrderLogic.g:3279:1: ( () )
            {
            // InternalFirstOrderLogic.g:3279:1: ( () )
            // InternalFirstOrderLogic.g:3280:2: ()
            {
             before(grammarAccess.getForAllAccess().getForAllAction_0()); 
            // InternalFirstOrderLogic.g:3281:2: ()
            // InternalFirstOrderLogic.g:3281:3: 
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
    // InternalFirstOrderLogic.g:3289:1: rule__ForAll__Group__1 : rule__ForAll__Group__1__Impl rule__ForAll__Group__2 ;
    public final void rule__ForAll__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3293:1: ( rule__ForAll__Group__1__Impl rule__ForAll__Group__2 )
            // InternalFirstOrderLogic.g:3294:2: rule__ForAll__Group__1__Impl rule__ForAll__Group__2
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
    // InternalFirstOrderLogic.g:3301:1: rule__ForAll__Group__1__Impl : ( 'forAll(' ) ;
    public final void rule__ForAll__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3305:1: ( ( 'forAll(' ) )
            // InternalFirstOrderLogic.g:3306:1: ( 'forAll(' )
            {
            // InternalFirstOrderLogic.g:3306:1: ( 'forAll(' )
            // InternalFirstOrderLogic.g:3307:2: 'forAll('
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
    // InternalFirstOrderLogic.g:3316:1: rule__ForAll__Group__2 : rule__ForAll__Group__2__Impl rule__ForAll__Group__3 ;
    public final void rule__ForAll__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3320:1: ( rule__ForAll__Group__2__Impl rule__ForAll__Group__3 )
            // InternalFirstOrderLogic.g:3321:2: rule__ForAll__Group__2__Impl rule__ForAll__Group__3
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
    // InternalFirstOrderLogic.g:3328:1: rule__ForAll__Group__2__Impl : ( ( rule__ForAll__NameAssignment_2 ) ) ;
    public final void rule__ForAll__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3332:1: ( ( ( rule__ForAll__NameAssignment_2 ) ) )
            // InternalFirstOrderLogic.g:3333:1: ( ( rule__ForAll__NameAssignment_2 ) )
            {
            // InternalFirstOrderLogic.g:3333:1: ( ( rule__ForAll__NameAssignment_2 ) )
            // InternalFirstOrderLogic.g:3334:2: ( rule__ForAll__NameAssignment_2 )
            {
             before(grammarAccess.getForAllAccess().getNameAssignment_2()); 
            // InternalFirstOrderLogic.g:3335:2: ( rule__ForAll__NameAssignment_2 )
            // InternalFirstOrderLogic.g:3335:3: rule__ForAll__NameAssignment_2
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
    // InternalFirstOrderLogic.g:3343:1: rule__ForAll__Group__3 : rule__ForAll__Group__3__Impl rule__ForAll__Group__4 ;
    public final void rule__ForAll__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3347:1: ( rule__ForAll__Group__3__Impl rule__ForAll__Group__4 )
            // InternalFirstOrderLogic.g:3348:2: rule__ForAll__Group__3__Impl rule__ForAll__Group__4
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
    // InternalFirstOrderLogic.g:3355:1: rule__ForAll__Group__3__Impl : ( 'in' ) ;
    public final void rule__ForAll__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3359:1: ( ( 'in' ) )
            // InternalFirstOrderLogic.g:3360:1: ( 'in' )
            {
            // InternalFirstOrderLogic.g:3360:1: ( 'in' )
            // InternalFirstOrderLogic.g:3361:2: 'in'
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
    // InternalFirstOrderLogic.g:3370:1: rule__ForAll__Group__4 : rule__ForAll__Group__4__Impl rule__ForAll__Group__5 ;
    public final void rule__ForAll__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3374:1: ( rule__ForAll__Group__4__Impl rule__ForAll__Group__5 )
            // InternalFirstOrderLogic.g:3375:2: rule__ForAll__Group__4__Impl rule__ForAll__Group__5
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
    // InternalFirstOrderLogic.g:3382:1: rule__ForAll__Group__4__Impl : ( ( rule__ForAll__IterationAssignment_4 ) ) ;
    public final void rule__ForAll__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3386:1: ( ( ( rule__ForAll__IterationAssignment_4 ) ) )
            // InternalFirstOrderLogic.g:3387:1: ( ( rule__ForAll__IterationAssignment_4 ) )
            {
            // InternalFirstOrderLogic.g:3387:1: ( ( rule__ForAll__IterationAssignment_4 ) )
            // InternalFirstOrderLogic.g:3388:2: ( rule__ForAll__IterationAssignment_4 )
            {
             before(grammarAccess.getForAllAccess().getIterationAssignment_4()); 
            // InternalFirstOrderLogic.g:3389:2: ( rule__ForAll__IterationAssignment_4 )
            // InternalFirstOrderLogic.g:3389:3: rule__ForAll__IterationAssignment_4
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
    // InternalFirstOrderLogic.g:3397:1: rule__ForAll__Group__5 : rule__ForAll__Group__5__Impl rule__ForAll__Group__6 ;
    public final void rule__ForAll__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3401:1: ( rule__ForAll__Group__5__Impl rule__ForAll__Group__6 )
            // InternalFirstOrderLogic.g:3402:2: rule__ForAll__Group__5__Impl rule__ForAll__Group__6
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
    // InternalFirstOrderLogic.g:3409:1: rule__ForAll__Group__5__Impl : ( ':' ) ;
    public final void rule__ForAll__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3413:1: ( ( ':' ) )
            // InternalFirstOrderLogic.g:3414:1: ( ':' )
            {
            // InternalFirstOrderLogic.g:3414:1: ( ':' )
            // InternalFirstOrderLogic.g:3415:2: ':'
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
    // InternalFirstOrderLogic.g:3424:1: rule__ForAll__Group__6 : rule__ForAll__Group__6__Impl rule__ForAll__Group__7 ;
    public final void rule__ForAll__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3428:1: ( rule__ForAll__Group__6__Impl rule__ForAll__Group__7 )
            // InternalFirstOrderLogic.g:3429:2: rule__ForAll__Group__6__Impl rule__ForAll__Group__7
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
    // InternalFirstOrderLogic.g:3436:1: rule__ForAll__Group__6__Impl : ( ( rule__ForAll__FormulaAssignment_6 ) ) ;
    public final void rule__ForAll__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3440:1: ( ( ( rule__ForAll__FormulaAssignment_6 ) ) )
            // InternalFirstOrderLogic.g:3441:1: ( ( rule__ForAll__FormulaAssignment_6 ) )
            {
            // InternalFirstOrderLogic.g:3441:1: ( ( rule__ForAll__FormulaAssignment_6 ) )
            // InternalFirstOrderLogic.g:3442:2: ( rule__ForAll__FormulaAssignment_6 )
            {
             before(grammarAccess.getForAllAccess().getFormulaAssignment_6()); 
            // InternalFirstOrderLogic.g:3443:2: ( rule__ForAll__FormulaAssignment_6 )
            // InternalFirstOrderLogic.g:3443:3: rule__ForAll__FormulaAssignment_6
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
    // InternalFirstOrderLogic.g:3451:1: rule__ForAll__Group__7 : rule__ForAll__Group__7__Impl ;
    public final void rule__ForAll__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3455:1: ( rule__ForAll__Group__7__Impl )
            // InternalFirstOrderLogic.g:3456:2: rule__ForAll__Group__7__Impl
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
    // InternalFirstOrderLogic.g:3462:1: rule__ForAll__Group__7__Impl : ( ')' ) ;
    public final void rule__ForAll__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3466:1: ( ( ')' ) )
            // InternalFirstOrderLogic.g:3467:1: ( ')' )
            {
            // InternalFirstOrderLogic.g:3467:1: ( ')' )
            // InternalFirstOrderLogic.g:3468:2: ')'
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
    // InternalFirstOrderLogic.g:3478:1: rule__Exists__Group__0 : rule__Exists__Group__0__Impl rule__Exists__Group__1 ;
    public final void rule__Exists__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3482:1: ( rule__Exists__Group__0__Impl rule__Exists__Group__1 )
            // InternalFirstOrderLogic.g:3483:2: rule__Exists__Group__0__Impl rule__Exists__Group__1
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
    // InternalFirstOrderLogic.g:3490:1: rule__Exists__Group__0__Impl : ( () ) ;
    public final void rule__Exists__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3494:1: ( ( () ) )
            // InternalFirstOrderLogic.g:3495:1: ( () )
            {
            // InternalFirstOrderLogic.g:3495:1: ( () )
            // InternalFirstOrderLogic.g:3496:2: ()
            {
             before(grammarAccess.getExistsAccess().getExistsAction_0()); 
            // InternalFirstOrderLogic.g:3497:2: ()
            // InternalFirstOrderLogic.g:3497:3: 
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
    // InternalFirstOrderLogic.g:3505:1: rule__Exists__Group__1 : rule__Exists__Group__1__Impl rule__Exists__Group__2 ;
    public final void rule__Exists__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3509:1: ( rule__Exists__Group__1__Impl rule__Exists__Group__2 )
            // InternalFirstOrderLogic.g:3510:2: rule__Exists__Group__1__Impl rule__Exists__Group__2
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
    // InternalFirstOrderLogic.g:3517:1: rule__Exists__Group__1__Impl : ( 'exists(' ) ;
    public final void rule__Exists__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3521:1: ( ( 'exists(' ) )
            // InternalFirstOrderLogic.g:3522:1: ( 'exists(' )
            {
            // InternalFirstOrderLogic.g:3522:1: ( 'exists(' )
            // InternalFirstOrderLogic.g:3523:2: 'exists('
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
    // InternalFirstOrderLogic.g:3532:1: rule__Exists__Group__2 : rule__Exists__Group__2__Impl rule__Exists__Group__3 ;
    public final void rule__Exists__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3536:1: ( rule__Exists__Group__2__Impl rule__Exists__Group__3 )
            // InternalFirstOrderLogic.g:3537:2: rule__Exists__Group__2__Impl rule__Exists__Group__3
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
    // InternalFirstOrderLogic.g:3544:1: rule__Exists__Group__2__Impl : ( ( rule__Exists__NameAssignment_2 ) ) ;
    public final void rule__Exists__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3548:1: ( ( ( rule__Exists__NameAssignment_2 ) ) )
            // InternalFirstOrderLogic.g:3549:1: ( ( rule__Exists__NameAssignment_2 ) )
            {
            // InternalFirstOrderLogic.g:3549:1: ( ( rule__Exists__NameAssignment_2 ) )
            // InternalFirstOrderLogic.g:3550:2: ( rule__Exists__NameAssignment_2 )
            {
             before(grammarAccess.getExistsAccess().getNameAssignment_2()); 
            // InternalFirstOrderLogic.g:3551:2: ( rule__Exists__NameAssignment_2 )
            // InternalFirstOrderLogic.g:3551:3: rule__Exists__NameAssignment_2
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
    // InternalFirstOrderLogic.g:3559:1: rule__Exists__Group__3 : rule__Exists__Group__3__Impl rule__Exists__Group__4 ;
    public final void rule__Exists__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3563:1: ( rule__Exists__Group__3__Impl rule__Exists__Group__4 )
            // InternalFirstOrderLogic.g:3564:2: rule__Exists__Group__3__Impl rule__Exists__Group__4
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
    // InternalFirstOrderLogic.g:3571:1: rule__Exists__Group__3__Impl : ( 'in' ) ;
    public final void rule__Exists__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3575:1: ( ( 'in' ) )
            // InternalFirstOrderLogic.g:3576:1: ( 'in' )
            {
            // InternalFirstOrderLogic.g:3576:1: ( 'in' )
            // InternalFirstOrderLogic.g:3577:2: 'in'
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
    // InternalFirstOrderLogic.g:3586:1: rule__Exists__Group__4 : rule__Exists__Group__4__Impl rule__Exists__Group__5 ;
    public final void rule__Exists__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3590:1: ( rule__Exists__Group__4__Impl rule__Exists__Group__5 )
            // InternalFirstOrderLogic.g:3591:2: rule__Exists__Group__4__Impl rule__Exists__Group__5
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
    // InternalFirstOrderLogic.g:3598:1: rule__Exists__Group__4__Impl : ( ( rule__Exists__IterationAssignment_4 ) ) ;
    public final void rule__Exists__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3602:1: ( ( ( rule__Exists__IterationAssignment_4 ) ) )
            // InternalFirstOrderLogic.g:3603:1: ( ( rule__Exists__IterationAssignment_4 ) )
            {
            // InternalFirstOrderLogic.g:3603:1: ( ( rule__Exists__IterationAssignment_4 ) )
            // InternalFirstOrderLogic.g:3604:2: ( rule__Exists__IterationAssignment_4 )
            {
             before(grammarAccess.getExistsAccess().getIterationAssignment_4()); 
            // InternalFirstOrderLogic.g:3605:2: ( rule__Exists__IterationAssignment_4 )
            // InternalFirstOrderLogic.g:3605:3: rule__Exists__IterationAssignment_4
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
    // InternalFirstOrderLogic.g:3613:1: rule__Exists__Group__5 : rule__Exists__Group__5__Impl rule__Exists__Group__6 ;
    public final void rule__Exists__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3617:1: ( rule__Exists__Group__5__Impl rule__Exists__Group__6 )
            // InternalFirstOrderLogic.g:3618:2: rule__Exists__Group__5__Impl rule__Exists__Group__6
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
    // InternalFirstOrderLogic.g:3625:1: rule__Exists__Group__5__Impl : ( ':' ) ;
    public final void rule__Exists__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3629:1: ( ( ':' ) )
            // InternalFirstOrderLogic.g:3630:1: ( ':' )
            {
            // InternalFirstOrderLogic.g:3630:1: ( ':' )
            // InternalFirstOrderLogic.g:3631:2: ':'
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
    // InternalFirstOrderLogic.g:3640:1: rule__Exists__Group__6 : rule__Exists__Group__6__Impl rule__Exists__Group__7 ;
    public final void rule__Exists__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3644:1: ( rule__Exists__Group__6__Impl rule__Exists__Group__7 )
            // InternalFirstOrderLogic.g:3645:2: rule__Exists__Group__6__Impl rule__Exists__Group__7
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
    // InternalFirstOrderLogic.g:3652:1: rule__Exists__Group__6__Impl : ( ( rule__Exists__FormulaAssignment_6 ) ) ;
    public final void rule__Exists__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3656:1: ( ( ( rule__Exists__FormulaAssignment_6 ) ) )
            // InternalFirstOrderLogic.g:3657:1: ( ( rule__Exists__FormulaAssignment_6 ) )
            {
            // InternalFirstOrderLogic.g:3657:1: ( ( rule__Exists__FormulaAssignment_6 ) )
            // InternalFirstOrderLogic.g:3658:2: ( rule__Exists__FormulaAssignment_6 )
            {
             before(grammarAccess.getExistsAccess().getFormulaAssignment_6()); 
            // InternalFirstOrderLogic.g:3659:2: ( rule__Exists__FormulaAssignment_6 )
            // InternalFirstOrderLogic.g:3659:3: rule__Exists__FormulaAssignment_6
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
    // InternalFirstOrderLogic.g:3667:1: rule__Exists__Group__7 : rule__Exists__Group__7__Impl ;
    public final void rule__Exists__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3671:1: ( rule__Exists__Group__7__Impl )
            // InternalFirstOrderLogic.g:3672:2: rule__Exists__Group__7__Impl
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
    // InternalFirstOrderLogic.g:3678:1: rule__Exists__Group__7__Impl : ( ')' ) ;
    public final void rule__Exists__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3682:1: ( ( ')' ) )
            // InternalFirstOrderLogic.g:3683:1: ( ')' )
            {
            // InternalFirstOrderLogic.g:3683:1: ( ')' )
            // InternalFirstOrderLogic.g:3684:2: ')'
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
    // InternalFirstOrderLogic.g:3694:1: rule__BooleanExpression__Group_0__0 : rule__BooleanExpression__Group_0__0__Impl rule__BooleanExpression__Group_0__1 ;
    public final void rule__BooleanExpression__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3698:1: ( rule__BooleanExpression__Group_0__0__Impl rule__BooleanExpression__Group_0__1 )
            // InternalFirstOrderLogic.g:3699:2: rule__BooleanExpression__Group_0__0__Impl rule__BooleanExpression__Group_0__1
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
    // InternalFirstOrderLogic.g:3706:1: rule__BooleanExpression__Group_0__0__Impl : ( '(' ) ;
    public final void rule__BooleanExpression__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3710:1: ( ( '(' ) )
            // InternalFirstOrderLogic.g:3711:1: ( '(' )
            {
            // InternalFirstOrderLogic.g:3711:1: ( '(' )
            // InternalFirstOrderLogic.g:3712:2: '('
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
    // InternalFirstOrderLogic.g:3721:1: rule__BooleanExpression__Group_0__1 : rule__BooleanExpression__Group_0__1__Impl rule__BooleanExpression__Group_0__2 ;
    public final void rule__BooleanExpression__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3725:1: ( rule__BooleanExpression__Group_0__1__Impl rule__BooleanExpression__Group_0__2 )
            // InternalFirstOrderLogic.g:3726:2: rule__BooleanExpression__Group_0__1__Impl rule__BooleanExpression__Group_0__2
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
    // InternalFirstOrderLogic.g:3733:1: rule__BooleanExpression__Group_0__1__Impl : ( ruleFormula ) ;
    public final void rule__BooleanExpression__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3737:1: ( ( ruleFormula ) )
            // InternalFirstOrderLogic.g:3738:1: ( ruleFormula )
            {
            // InternalFirstOrderLogic.g:3738:1: ( ruleFormula )
            // InternalFirstOrderLogic.g:3739:2: ruleFormula
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
    // InternalFirstOrderLogic.g:3748:1: rule__BooleanExpression__Group_0__2 : rule__BooleanExpression__Group_0__2__Impl ;
    public final void rule__BooleanExpression__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3752:1: ( rule__BooleanExpression__Group_0__2__Impl )
            // InternalFirstOrderLogic.g:3753:2: rule__BooleanExpression__Group_0__2__Impl
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
    // InternalFirstOrderLogic.g:3759:1: rule__BooleanExpression__Group_0__2__Impl : ( ')' ) ;
    public final void rule__BooleanExpression__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3763:1: ( ( ')' ) )
            // InternalFirstOrderLogic.g:3764:1: ( ')' )
            {
            // InternalFirstOrderLogic.g:3764:1: ( ')' )
            // InternalFirstOrderLogic.g:3765:2: ')'
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
    // InternalFirstOrderLogic.g:3775:1: rule__BoolConstant__Group__0 : rule__BoolConstant__Group__0__Impl rule__BoolConstant__Group__1 ;
    public final void rule__BoolConstant__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3779:1: ( rule__BoolConstant__Group__0__Impl rule__BoolConstant__Group__1 )
            // InternalFirstOrderLogic.g:3780:2: rule__BoolConstant__Group__0__Impl rule__BoolConstant__Group__1
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
    // InternalFirstOrderLogic.g:3787:1: rule__BoolConstant__Group__0__Impl : ( () ) ;
    public final void rule__BoolConstant__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3791:1: ( ( () ) )
            // InternalFirstOrderLogic.g:3792:1: ( () )
            {
            // InternalFirstOrderLogic.g:3792:1: ( () )
            // InternalFirstOrderLogic.g:3793:2: ()
            {
             before(grammarAccess.getBoolConstantAccess().getBoolConstantAction_0()); 
            // InternalFirstOrderLogic.g:3794:2: ()
            // InternalFirstOrderLogic.g:3794:3: 
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
    // InternalFirstOrderLogic.g:3802:1: rule__BoolConstant__Group__1 : rule__BoolConstant__Group__1__Impl ;
    public final void rule__BoolConstant__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3806:1: ( rule__BoolConstant__Group__1__Impl )
            // InternalFirstOrderLogic.g:3807:2: rule__BoolConstant__Group__1__Impl
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
    // InternalFirstOrderLogic.g:3813:1: rule__BoolConstant__Group__1__Impl : ( ( rule__BoolConstant__ValueAssignment_1 ) ) ;
    public final void rule__BoolConstant__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3817:1: ( ( ( rule__BoolConstant__ValueAssignment_1 ) ) )
            // InternalFirstOrderLogic.g:3818:1: ( ( rule__BoolConstant__ValueAssignment_1 ) )
            {
            // InternalFirstOrderLogic.g:3818:1: ( ( rule__BoolConstant__ValueAssignment_1 ) )
            // InternalFirstOrderLogic.g:3819:2: ( rule__BoolConstant__ValueAssignment_1 )
            {
             before(grammarAccess.getBoolConstantAccess().getValueAssignment_1()); 
            // InternalFirstOrderLogic.g:3820:2: ( rule__BoolConstant__ValueAssignment_1 )
            // InternalFirstOrderLogic.g:3820:3: rule__BoolConstant__ValueAssignment_1
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
    // InternalFirstOrderLogic.g:3829:1: rule__VariableRef__Group__0 : rule__VariableRef__Group__0__Impl rule__VariableRef__Group__1 ;
    public final void rule__VariableRef__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3833:1: ( rule__VariableRef__Group__0__Impl rule__VariableRef__Group__1 )
            // InternalFirstOrderLogic.g:3834:2: rule__VariableRef__Group__0__Impl rule__VariableRef__Group__1
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
    // InternalFirstOrderLogic.g:3841:1: rule__VariableRef__Group__0__Impl : ( () ) ;
    public final void rule__VariableRef__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3845:1: ( ( () ) )
            // InternalFirstOrderLogic.g:3846:1: ( () )
            {
            // InternalFirstOrderLogic.g:3846:1: ( () )
            // InternalFirstOrderLogic.g:3847:2: ()
            {
             before(grammarAccess.getVariableRefAccess().getVariableRefAction_0()); 
            // InternalFirstOrderLogic.g:3848:2: ()
            // InternalFirstOrderLogic.g:3848:3: 
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
    // InternalFirstOrderLogic.g:3856:1: rule__VariableRef__Group__1 : rule__VariableRef__Group__1__Impl rule__VariableRef__Group__2 ;
    public final void rule__VariableRef__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3860:1: ( rule__VariableRef__Group__1__Impl rule__VariableRef__Group__2 )
            // InternalFirstOrderLogic.g:3861:2: rule__VariableRef__Group__1__Impl rule__VariableRef__Group__2
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
    // InternalFirstOrderLogic.g:3868:1: rule__VariableRef__Group__1__Impl : ( ( rule__VariableRef__NameAssignment_1 ) ) ;
    public final void rule__VariableRef__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3872:1: ( ( ( rule__VariableRef__NameAssignment_1 ) ) )
            // InternalFirstOrderLogic.g:3873:1: ( ( rule__VariableRef__NameAssignment_1 ) )
            {
            // InternalFirstOrderLogic.g:3873:1: ( ( rule__VariableRef__NameAssignment_1 ) )
            // InternalFirstOrderLogic.g:3874:2: ( rule__VariableRef__NameAssignment_1 )
            {
             before(grammarAccess.getVariableRefAccess().getNameAssignment_1()); 
            // InternalFirstOrderLogic.g:3875:2: ( rule__VariableRef__NameAssignment_1 )
            // InternalFirstOrderLogic.g:3875:3: rule__VariableRef__NameAssignment_1
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
    // InternalFirstOrderLogic.g:3883:1: rule__VariableRef__Group__2 : rule__VariableRef__Group__2__Impl ;
    public final void rule__VariableRef__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3887:1: ( rule__VariableRef__Group__2__Impl )
            // InternalFirstOrderLogic.g:3888:2: rule__VariableRef__Group__2__Impl
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
    // InternalFirstOrderLogic.g:3894:1: rule__VariableRef__Group__2__Impl : ( ( rule__VariableRef__GetAssignment_2 )? ) ;
    public final void rule__VariableRef__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3898:1: ( ( ( rule__VariableRef__GetAssignment_2 )? ) )
            // InternalFirstOrderLogic.g:3899:1: ( ( rule__VariableRef__GetAssignment_2 )? )
            {
            // InternalFirstOrderLogic.g:3899:1: ( ( rule__VariableRef__GetAssignment_2 )? )
            // InternalFirstOrderLogic.g:3900:2: ( rule__VariableRef__GetAssignment_2 )?
            {
             before(grammarAccess.getVariableRefAccess().getGetAssignment_2()); 
            // InternalFirstOrderLogic.g:3901:2: ( rule__VariableRef__GetAssignment_2 )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==38) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalFirstOrderLogic.g:3901:3: rule__VariableRef__GetAssignment_2
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
    // InternalFirstOrderLogic.g:3910:1: rule__Get__Group__0 : rule__Get__Group__0__Impl rule__Get__Group__1 ;
    public final void rule__Get__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3914:1: ( rule__Get__Group__0__Impl rule__Get__Group__1 )
            // InternalFirstOrderLogic.g:3915:2: rule__Get__Group__0__Impl rule__Get__Group__1
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
    // InternalFirstOrderLogic.g:3922:1: rule__Get__Group__0__Impl : ( '.' ) ;
    public final void rule__Get__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3926:1: ( ( '.' ) )
            // InternalFirstOrderLogic.g:3927:1: ( '.' )
            {
            // InternalFirstOrderLogic.g:3927:1: ( '.' )
            // InternalFirstOrderLogic.g:3928:2: '.'
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
    // InternalFirstOrderLogic.g:3937:1: rule__Get__Group__1 : rule__Get__Group__1__Impl rule__Get__Group__2 ;
    public final void rule__Get__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3941:1: ( rule__Get__Group__1__Impl rule__Get__Group__2 )
            // InternalFirstOrderLogic.g:3942:2: rule__Get__Group__1__Impl rule__Get__Group__2
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
    // InternalFirstOrderLogic.g:3949:1: rule__Get__Group__1__Impl : ( ( rule__Get__Group_1__0 )? ) ;
    public final void rule__Get__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3953:1: ( ( ( rule__Get__Group_1__0 )? ) )
            // InternalFirstOrderLogic.g:3954:1: ( ( rule__Get__Group_1__0 )? )
            {
            // InternalFirstOrderLogic.g:3954:1: ( ( rule__Get__Group_1__0 )? )
            // InternalFirstOrderLogic.g:3955:2: ( rule__Get__Group_1__0 )?
            {
             before(grammarAccess.getGetAccess().getGroup_1()); 
            // InternalFirstOrderLogic.g:3956:2: ( rule__Get__Group_1__0 )?
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
                    // InternalFirstOrderLogic.g:3956:3: rule__Get__Group_1__0
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
    // InternalFirstOrderLogic.g:3964:1: rule__Get__Group__2 : rule__Get__Group__2__Impl rule__Get__Group__3 ;
    public final void rule__Get__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3968:1: ( rule__Get__Group__2__Impl rule__Get__Group__3 )
            // InternalFirstOrderLogic.g:3969:2: rule__Get__Group__2__Impl rule__Get__Group__3
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
    // InternalFirstOrderLogic.g:3976:1: rule__Get__Group__2__Impl : ( ( rule__Get__NameAssignment_2 ) ) ;
    public final void rule__Get__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3980:1: ( ( ( rule__Get__NameAssignment_2 ) ) )
            // InternalFirstOrderLogic.g:3981:1: ( ( rule__Get__NameAssignment_2 ) )
            {
            // InternalFirstOrderLogic.g:3981:1: ( ( rule__Get__NameAssignment_2 ) )
            // InternalFirstOrderLogic.g:3982:2: ( rule__Get__NameAssignment_2 )
            {
             before(grammarAccess.getGetAccess().getNameAssignment_2()); 
            // InternalFirstOrderLogic.g:3983:2: ( rule__Get__NameAssignment_2 )
            // InternalFirstOrderLogic.g:3983:3: rule__Get__NameAssignment_2
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
    // InternalFirstOrderLogic.g:3991:1: rule__Get__Group__3 : rule__Get__Group__3__Impl ;
    public final void rule__Get__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3995:1: ( rule__Get__Group__3__Impl )
            // InternalFirstOrderLogic.g:3996:2: rule__Get__Group__3__Impl
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
    // InternalFirstOrderLogic.g:4002:1: rule__Get__Group__3__Impl : ( ( rule__Get__NextAssignment_3 )? ) ;
    public final void rule__Get__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4006:1: ( ( ( rule__Get__NextAssignment_3 )? ) )
            // InternalFirstOrderLogic.g:4007:1: ( ( rule__Get__NextAssignment_3 )? )
            {
            // InternalFirstOrderLogic.g:4007:1: ( ( rule__Get__NextAssignment_3 )? )
            // InternalFirstOrderLogic.g:4008:2: ( rule__Get__NextAssignment_3 )?
            {
             before(grammarAccess.getGetAccess().getNextAssignment_3()); 
            // InternalFirstOrderLogic.g:4009:2: ( rule__Get__NextAssignment_3 )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==38) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalFirstOrderLogic.g:4009:3: rule__Get__NextAssignment_3
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
    // InternalFirstOrderLogic.g:4018:1: rule__Get__Group_1__0 : rule__Get__Group_1__0__Impl rule__Get__Group_1__1 ;
    public final void rule__Get__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4022:1: ( rule__Get__Group_1__0__Impl rule__Get__Group_1__1 )
            // InternalFirstOrderLogic.g:4023:2: rule__Get__Group_1__0__Impl rule__Get__Group_1__1
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
    // InternalFirstOrderLogic.g:4030:1: rule__Get__Group_1__0__Impl : ( ( rule__Get__TypeAssignment_1_0 ) ) ;
    public final void rule__Get__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4034:1: ( ( ( rule__Get__TypeAssignment_1_0 ) ) )
            // InternalFirstOrderLogic.g:4035:1: ( ( rule__Get__TypeAssignment_1_0 ) )
            {
            // InternalFirstOrderLogic.g:4035:1: ( ( rule__Get__TypeAssignment_1_0 ) )
            // InternalFirstOrderLogic.g:4036:2: ( rule__Get__TypeAssignment_1_0 )
            {
             before(grammarAccess.getGetAccess().getTypeAssignment_1_0()); 
            // InternalFirstOrderLogic.g:4037:2: ( rule__Get__TypeAssignment_1_0 )
            // InternalFirstOrderLogic.g:4037:3: rule__Get__TypeAssignment_1_0
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
    // InternalFirstOrderLogic.g:4045:1: rule__Get__Group_1__1 : rule__Get__Group_1__1__Impl ;
    public final void rule__Get__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4049:1: ( rule__Get__Group_1__1__Impl )
            // InternalFirstOrderLogic.g:4050:2: rule__Get__Group_1__1__Impl
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
    // InternalFirstOrderLogic.g:4056:1: rule__Get__Group_1__1__Impl : ( '::' ) ;
    public final void rule__Get__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4060:1: ( ( '::' ) )
            // InternalFirstOrderLogic.g:4061:1: ( '::' )
            {
            // InternalFirstOrderLogic.g:4061:1: ( '::' )
            // InternalFirstOrderLogic.g:4062:2: '::'
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
    // InternalFirstOrderLogic.g:4072:1: rule__GetContainer__Group__0 : rule__GetContainer__Group__0__Impl rule__GetContainer__Group__1 ;
    public final void rule__GetContainer__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4076:1: ( rule__GetContainer__Group__0__Impl rule__GetContainer__Group__1 )
            // InternalFirstOrderLogic.g:4077:2: rule__GetContainer__Group__0__Impl rule__GetContainer__Group__1
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
    // InternalFirstOrderLogic.g:4084:1: rule__GetContainer__Group__0__Impl : ( 'getContainer(' ) ;
    public final void rule__GetContainer__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4088:1: ( ( 'getContainer(' ) )
            // InternalFirstOrderLogic.g:4089:1: ( 'getContainer(' )
            {
            // InternalFirstOrderLogic.g:4089:1: ( 'getContainer(' )
            // InternalFirstOrderLogic.g:4090:2: 'getContainer('
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
    // InternalFirstOrderLogic.g:4099:1: rule__GetContainer__Group__1 : rule__GetContainer__Group__1__Impl rule__GetContainer__Group__2 ;
    public final void rule__GetContainer__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4103:1: ( rule__GetContainer__Group__1__Impl rule__GetContainer__Group__2 )
            // InternalFirstOrderLogic.g:4104:2: rule__GetContainer__Group__1__Impl rule__GetContainer__Group__2
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
    // InternalFirstOrderLogic.g:4111:1: rule__GetContainer__Group__1__Impl : ( ( rule__GetContainer__ElementAssignment_1 ) ) ;
    public final void rule__GetContainer__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4115:1: ( ( ( rule__GetContainer__ElementAssignment_1 ) ) )
            // InternalFirstOrderLogic.g:4116:1: ( ( rule__GetContainer__ElementAssignment_1 ) )
            {
            // InternalFirstOrderLogic.g:4116:1: ( ( rule__GetContainer__ElementAssignment_1 ) )
            // InternalFirstOrderLogic.g:4117:2: ( rule__GetContainer__ElementAssignment_1 )
            {
             before(grammarAccess.getGetContainerAccess().getElementAssignment_1()); 
            // InternalFirstOrderLogic.g:4118:2: ( rule__GetContainer__ElementAssignment_1 )
            // InternalFirstOrderLogic.g:4118:3: rule__GetContainer__ElementAssignment_1
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
    // InternalFirstOrderLogic.g:4126:1: rule__GetContainer__Group__2 : rule__GetContainer__Group__2__Impl ;
    public final void rule__GetContainer__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4130:1: ( rule__GetContainer__Group__2__Impl )
            // InternalFirstOrderLogic.g:4131:2: rule__GetContainer__Group__2__Impl
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
    // InternalFirstOrderLogic.g:4137:1: rule__GetContainer__Group__2__Impl : ( ')' ) ;
    public final void rule__GetContainer__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4141:1: ( ( ')' ) )
            // InternalFirstOrderLogic.g:4142:1: ( ')' )
            {
            // InternalFirstOrderLogic.g:4142:1: ( ')' )
            // InternalFirstOrderLogic.g:4143:2: ')'
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


    // $ANTLR start "rule__GetContainments__Group__0"
    // InternalFirstOrderLogic.g:4153:1: rule__GetContainments__Group__0 : rule__GetContainments__Group__0__Impl rule__GetContainments__Group__1 ;
    public final void rule__GetContainments__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4157:1: ( rule__GetContainments__Group__0__Impl rule__GetContainments__Group__1 )
            // InternalFirstOrderLogic.g:4158:2: rule__GetContainments__Group__0__Impl rule__GetContainments__Group__1
            {
            pushFollow(FOLLOW_24);
            rule__GetContainments__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__GetContainments__Group__1();

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
    // $ANTLR end "rule__GetContainments__Group__0"


    // $ANTLR start "rule__GetContainments__Group__0__Impl"
    // InternalFirstOrderLogic.g:4165:1: rule__GetContainments__Group__0__Impl : ( 'getContainments(' ) ;
    public final void rule__GetContainments__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4169:1: ( ( 'getContainments(' ) )
            // InternalFirstOrderLogic.g:4170:1: ( 'getContainments(' )
            {
            // InternalFirstOrderLogic.g:4170:1: ( 'getContainments(' )
            // InternalFirstOrderLogic.g:4171:2: 'getContainments('
            {
             before(grammarAccess.getGetContainmentsAccess().getGetContainmentsKeyword_0()); 
            match(input,41,FOLLOW_2); 
             after(grammarAccess.getGetContainmentsAccess().getGetContainmentsKeyword_0()); 

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
    // $ANTLR end "rule__GetContainments__Group__0__Impl"


    // $ANTLR start "rule__GetContainments__Group__1"
    // InternalFirstOrderLogic.g:4180:1: rule__GetContainments__Group__1 : rule__GetContainments__Group__1__Impl rule__GetContainments__Group__2 ;
    public final void rule__GetContainments__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4184:1: ( rule__GetContainments__Group__1__Impl rule__GetContainments__Group__2 )
            // InternalFirstOrderLogic.g:4185:2: rule__GetContainments__Group__1__Impl rule__GetContainments__Group__2
            {
            pushFollow(FOLLOW_23);
            rule__GetContainments__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__GetContainments__Group__2();

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
    // $ANTLR end "rule__GetContainments__Group__1"


    // $ANTLR start "rule__GetContainments__Group__1__Impl"
    // InternalFirstOrderLogic.g:4192:1: rule__GetContainments__Group__1__Impl : ( ( rule__GetContainments__ElementAssignment_1 ) ) ;
    public final void rule__GetContainments__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4196:1: ( ( ( rule__GetContainments__ElementAssignment_1 ) ) )
            // InternalFirstOrderLogic.g:4197:1: ( ( rule__GetContainments__ElementAssignment_1 ) )
            {
            // InternalFirstOrderLogic.g:4197:1: ( ( rule__GetContainments__ElementAssignment_1 ) )
            // InternalFirstOrderLogic.g:4198:2: ( rule__GetContainments__ElementAssignment_1 )
            {
             before(grammarAccess.getGetContainmentsAccess().getElementAssignment_1()); 
            // InternalFirstOrderLogic.g:4199:2: ( rule__GetContainments__ElementAssignment_1 )
            // InternalFirstOrderLogic.g:4199:3: rule__GetContainments__ElementAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__GetContainments__ElementAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getGetContainmentsAccess().getElementAssignment_1()); 

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
    // $ANTLR end "rule__GetContainments__Group__1__Impl"


    // $ANTLR start "rule__GetContainments__Group__2"
    // InternalFirstOrderLogic.g:4207:1: rule__GetContainments__Group__2 : rule__GetContainments__Group__2__Impl ;
    public final void rule__GetContainments__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4211:1: ( rule__GetContainments__Group__2__Impl )
            // InternalFirstOrderLogic.g:4212:2: rule__GetContainments__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__GetContainments__Group__2__Impl();

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
    // $ANTLR end "rule__GetContainments__Group__2"


    // $ANTLR start "rule__GetContainments__Group__2__Impl"
    // InternalFirstOrderLogic.g:4218:1: rule__GetContainments__Group__2__Impl : ( ')' ) ;
    public final void rule__GetContainments__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4222:1: ( ( ')' ) )
            // InternalFirstOrderLogic.g:4223:1: ( ')' )
            {
            // InternalFirstOrderLogic.g:4223:1: ( ')' )
            // InternalFirstOrderLogic.g:4224:2: ')'
            {
             before(grammarAccess.getGetContainmentsAccess().getRightParenthesisKeyword_2()); 
            match(input,25,FOLLOW_2); 
             after(grammarAccess.getGetContainmentsAccess().getRightParenthesisKeyword_2()); 

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
    // $ANTLR end "rule__GetContainments__Group__2__Impl"


    // $ANTLR start "rule__GetClosure__Group__0"
    // InternalFirstOrderLogic.g:4234:1: rule__GetClosure__Group__0 : rule__GetClosure__Group__0__Impl rule__GetClosure__Group__1 ;
    public final void rule__GetClosure__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4238:1: ( rule__GetClosure__Group__0__Impl rule__GetClosure__Group__1 )
            // InternalFirstOrderLogic.g:4239:2: rule__GetClosure__Group__0__Impl rule__GetClosure__Group__1
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
    // InternalFirstOrderLogic.g:4246:1: rule__GetClosure__Group__0__Impl : ( 'getClosure(' ) ;
    public final void rule__GetClosure__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4250:1: ( ( 'getClosure(' ) )
            // InternalFirstOrderLogic.g:4251:1: ( 'getClosure(' )
            {
            // InternalFirstOrderLogic.g:4251:1: ( 'getClosure(' )
            // InternalFirstOrderLogic.g:4252:2: 'getClosure('
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
    // InternalFirstOrderLogic.g:4261:1: rule__GetClosure__Group__1 : rule__GetClosure__Group__1__Impl rule__GetClosure__Group__2 ;
    public final void rule__GetClosure__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4265:1: ( rule__GetClosure__Group__1__Impl rule__GetClosure__Group__2 )
            // InternalFirstOrderLogic.g:4266:2: rule__GetClosure__Group__1__Impl rule__GetClosure__Group__2
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
    // InternalFirstOrderLogic.g:4273:1: rule__GetClosure__Group__1__Impl : ( ( rule__GetClosure__ElementAssignment_1 ) ) ;
    public final void rule__GetClosure__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4277:1: ( ( ( rule__GetClosure__ElementAssignment_1 ) ) )
            // InternalFirstOrderLogic.g:4278:1: ( ( rule__GetClosure__ElementAssignment_1 ) )
            {
            // InternalFirstOrderLogic.g:4278:1: ( ( rule__GetClosure__ElementAssignment_1 ) )
            // InternalFirstOrderLogic.g:4279:2: ( rule__GetClosure__ElementAssignment_1 )
            {
             before(grammarAccess.getGetClosureAccess().getElementAssignment_1()); 
            // InternalFirstOrderLogic.g:4280:2: ( rule__GetClosure__ElementAssignment_1 )
            // InternalFirstOrderLogic.g:4280:3: rule__GetClosure__ElementAssignment_1
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
    // InternalFirstOrderLogic.g:4288:1: rule__GetClosure__Group__2 : rule__GetClosure__Group__2__Impl rule__GetClosure__Group__3 ;
    public final void rule__GetClosure__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4292:1: ( rule__GetClosure__Group__2__Impl rule__GetClosure__Group__3 )
            // InternalFirstOrderLogic.g:4293:2: rule__GetClosure__Group__2__Impl rule__GetClosure__Group__3
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
    // InternalFirstOrderLogic.g:4300:1: rule__GetClosure__Group__2__Impl : ( ',' ) ;
    public final void rule__GetClosure__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4304:1: ( ( ',' ) )
            // InternalFirstOrderLogic.g:4305:1: ( ',' )
            {
            // InternalFirstOrderLogic.g:4305:1: ( ',' )
            // InternalFirstOrderLogic.g:4306:2: ','
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
    // InternalFirstOrderLogic.g:4315:1: rule__GetClosure__Group__3 : rule__GetClosure__Group__3__Impl rule__GetClosure__Group__4 ;
    public final void rule__GetClosure__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4319:1: ( rule__GetClosure__Group__3__Impl rule__GetClosure__Group__4 )
            // InternalFirstOrderLogic.g:4320:2: rule__GetClosure__Group__3__Impl rule__GetClosure__Group__4
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
    // InternalFirstOrderLogic.g:4327:1: rule__GetClosure__Group__3__Impl : ( ( rule__GetClosure__FeatureAssignment_3 ) ) ;
    public final void rule__GetClosure__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4331:1: ( ( ( rule__GetClosure__FeatureAssignment_3 ) ) )
            // InternalFirstOrderLogic.g:4332:1: ( ( rule__GetClosure__FeatureAssignment_3 ) )
            {
            // InternalFirstOrderLogic.g:4332:1: ( ( rule__GetClosure__FeatureAssignment_3 ) )
            // InternalFirstOrderLogic.g:4333:2: ( rule__GetClosure__FeatureAssignment_3 )
            {
             before(grammarAccess.getGetClosureAccess().getFeatureAssignment_3()); 
            // InternalFirstOrderLogic.g:4334:2: ( rule__GetClosure__FeatureAssignment_3 )
            // InternalFirstOrderLogic.g:4334:3: rule__GetClosure__FeatureAssignment_3
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
    // InternalFirstOrderLogic.g:4342:1: rule__GetClosure__Group__4 : rule__GetClosure__Group__4__Impl ;
    public final void rule__GetClosure__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4346:1: ( rule__GetClosure__Group__4__Impl )
            // InternalFirstOrderLogic.g:4347:2: rule__GetClosure__Group__4__Impl
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
    // InternalFirstOrderLogic.g:4353:1: rule__GetClosure__Group__4__Impl : ( ')' ) ;
    public final void rule__GetClosure__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4357:1: ( ( ')' ) )
            // InternalFirstOrderLogic.g:4358:1: ( ')' )
            {
            // InternalFirstOrderLogic.g:4358:1: ( ')' )
            // InternalFirstOrderLogic.g:4359:2: ')'
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


    // $ANTLR start "rule__Size__Group__0"
    // InternalFirstOrderLogic.g:4369:1: rule__Size__Group__0 : rule__Size__Group__0__Impl rule__Size__Group__1 ;
    public final void rule__Size__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4373:1: ( rule__Size__Group__0__Impl rule__Size__Group__1 )
            // InternalFirstOrderLogic.g:4374:2: rule__Size__Group__0__Impl rule__Size__Group__1
            {
            pushFollow(FOLLOW_24);
            rule__Size__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Size__Group__1();

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
    // $ANTLR end "rule__Size__Group__0"


    // $ANTLR start "rule__Size__Group__0__Impl"
    // InternalFirstOrderLogic.g:4381:1: rule__Size__Group__0__Impl : ( 'size(' ) ;
    public final void rule__Size__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4385:1: ( ( 'size(' ) )
            // InternalFirstOrderLogic.g:4386:1: ( 'size(' )
            {
            // InternalFirstOrderLogic.g:4386:1: ( 'size(' )
            // InternalFirstOrderLogic.g:4387:2: 'size('
            {
             before(grammarAccess.getSizeAccess().getSizeKeyword_0()); 
            match(input,43,FOLLOW_2); 
             after(grammarAccess.getSizeAccess().getSizeKeyword_0()); 

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
    // $ANTLR end "rule__Size__Group__0__Impl"


    // $ANTLR start "rule__Size__Group__1"
    // InternalFirstOrderLogic.g:4396:1: rule__Size__Group__1 : rule__Size__Group__1__Impl rule__Size__Group__2 ;
    public final void rule__Size__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4400:1: ( rule__Size__Group__1__Impl rule__Size__Group__2 )
            // InternalFirstOrderLogic.g:4401:2: rule__Size__Group__1__Impl rule__Size__Group__2
            {
            pushFollow(FOLLOW_23);
            rule__Size__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Size__Group__2();

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
    // $ANTLR end "rule__Size__Group__1"


    // $ANTLR start "rule__Size__Group__1__Impl"
    // InternalFirstOrderLogic.g:4408:1: rule__Size__Group__1__Impl : ( ( rule__Size__ElementsAssignment_1 ) ) ;
    public final void rule__Size__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4412:1: ( ( ( rule__Size__ElementsAssignment_1 ) ) )
            // InternalFirstOrderLogic.g:4413:1: ( ( rule__Size__ElementsAssignment_1 ) )
            {
            // InternalFirstOrderLogic.g:4413:1: ( ( rule__Size__ElementsAssignment_1 ) )
            // InternalFirstOrderLogic.g:4414:2: ( rule__Size__ElementsAssignment_1 )
            {
             before(grammarAccess.getSizeAccess().getElementsAssignment_1()); 
            // InternalFirstOrderLogic.g:4415:2: ( rule__Size__ElementsAssignment_1 )
            // InternalFirstOrderLogic.g:4415:3: rule__Size__ElementsAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Size__ElementsAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getSizeAccess().getElementsAssignment_1()); 

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
    // $ANTLR end "rule__Size__Group__1__Impl"


    // $ANTLR start "rule__Size__Group__2"
    // InternalFirstOrderLogic.g:4423:1: rule__Size__Group__2 : rule__Size__Group__2__Impl ;
    public final void rule__Size__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4427:1: ( rule__Size__Group__2__Impl )
            // InternalFirstOrderLogic.g:4428:2: rule__Size__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Size__Group__2__Impl();

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
    // $ANTLR end "rule__Size__Group__2"


    // $ANTLR start "rule__Size__Group__2__Impl"
    // InternalFirstOrderLogic.g:4434:1: rule__Size__Group__2__Impl : ( ')' ) ;
    public final void rule__Size__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4438:1: ( ( ')' ) )
            // InternalFirstOrderLogic.g:4439:1: ( ')' )
            {
            // InternalFirstOrderLogic.g:4439:1: ( ')' )
            // InternalFirstOrderLogic.g:4440:2: ')'
            {
             before(grammarAccess.getSizeAccess().getRightParenthesisKeyword_2()); 
            match(input,25,FOLLOW_2); 
             after(grammarAccess.getSizeAccess().getRightParenthesisKeyword_2()); 

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
    // $ANTLR end "rule__Size__Group__2__Impl"


    // $ANTLR start "rule__Concatenate__Group__0"
    // InternalFirstOrderLogic.g:4450:1: rule__Concatenate__Group__0 : rule__Concatenate__Group__0__Impl rule__Concatenate__Group__1 ;
    public final void rule__Concatenate__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4454:1: ( rule__Concatenate__Group__0__Impl rule__Concatenate__Group__1 )
            // InternalFirstOrderLogic.g:4455:2: rule__Concatenate__Group__0__Impl rule__Concatenate__Group__1
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
    // InternalFirstOrderLogic.g:4462:1: rule__Concatenate__Group__0__Impl : ( 'concatenate(' ) ;
    public final void rule__Concatenate__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4466:1: ( ( 'concatenate(' ) )
            // InternalFirstOrderLogic.g:4467:1: ( 'concatenate(' )
            {
            // InternalFirstOrderLogic.g:4467:1: ( 'concatenate(' )
            // InternalFirstOrderLogic.g:4468:2: 'concatenate('
            {
             before(grammarAccess.getConcatenateAccess().getConcatenateKeyword_0()); 
            match(input,44,FOLLOW_2); 
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
    // InternalFirstOrderLogic.g:4477:1: rule__Concatenate__Group__1 : rule__Concatenate__Group__1__Impl rule__Concatenate__Group__2 ;
    public final void rule__Concatenate__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4481:1: ( rule__Concatenate__Group__1__Impl rule__Concatenate__Group__2 )
            // InternalFirstOrderLogic.g:4482:2: rule__Concatenate__Group__1__Impl rule__Concatenate__Group__2
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
    // InternalFirstOrderLogic.g:4489:1: rule__Concatenate__Group__1__Impl : ( ( rule__Concatenate__LeftAssignment_1 ) ) ;
    public final void rule__Concatenate__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4493:1: ( ( ( rule__Concatenate__LeftAssignment_1 ) ) )
            // InternalFirstOrderLogic.g:4494:1: ( ( rule__Concatenate__LeftAssignment_1 ) )
            {
            // InternalFirstOrderLogic.g:4494:1: ( ( rule__Concatenate__LeftAssignment_1 ) )
            // InternalFirstOrderLogic.g:4495:2: ( rule__Concatenate__LeftAssignment_1 )
            {
             before(grammarAccess.getConcatenateAccess().getLeftAssignment_1()); 
            // InternalFirstOrderLogic.g:4496:2: ( rule__Concatenate__LeftAssignment_1 )
            // InternalFirstOrderLogic.g:4496:3: rule__Concatenate__LeftAssignment_1
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
    // InternalFirstOrderLogic.g:4504:1: rule__Concatenate__Group__2 : rule__Concatenate__Group__2__Impl rule__Concatenate__Group__3 ;
    public final void rule__Concatenate__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4508:1: ( rule__Concatenate__Group__2__Impl rule__Concatenate__Group__3 )
            // InternalFirstOrderLogic.g:4509:2: rule__Concatenate__Group__2__Impl rule__Concatenate__Group__3
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
    // InternalFirstOrderLogic.g:4516:1: rule__Concatenate__Group__2__Impl : ( ',' ) ;
    public final void rule__Concatenate__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4520:1: ( ( ',' ) )
            // InternalFirstOrderLogic.g:4521:1: ( ',' )
            {
            // InternalFirstOrderLogic.g:4521:1: ( ',' )
            // InternalFirstOrderLogic.g:4522:2: ','
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
    // InternalFirstOrderLogic.g:4531:1: rule__Concatenate__Group__3 : rule__Concatenate__Group__3__Impl rule__Concatenate__Group__4 ;
    public final void rule__Concatenate__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4535:1: ( rule__Concatenate__Group__3__Impl rule__Concatenate__Group__4 )
            // InternalFirstOrderLogic.g:4536:2: rule__Concatenate__Group__3__Impl rule__Concatenate__Group__4
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
    // InternalFirstOrderLogic.g:4543:1: rule__Concatenate__Group__3__Impl : ( ( rule__Concatenate__RightAssignment_3 ) ) ;
    public final void rule__Concatenate__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4547:1: ( ( ( rule__Concatenate__RightAssignment_3 ) ) )
            // InternalFirstOrderLogic.g:4548:1: ( ( rule__Concatenate__RightAssignment_3 ) )
            {
            // InternalFirstOrderLogic.g:4548:1: ( ( rule__Concatenate__RightAssignment_3 ) )
            // InternalFirstOrderLogic.g:4549:2: ( rule__Concatenate__RightAssignment_3 )
            {
             before(grammarAccess.getConcatenateAccess().getRightAssignment_3()); 
            // InternalFirstOrderLogic.g:4550:2: ( rule__Concatenate__RightAssignment_3 )
            // InternalFirstOrderLogic.g:4550:3: rule__Concatenate__RightAssignment_3
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
    // InternalFirstOrderLogic.g:4558:1: rule__Concatenate__Group__4 : rule__Concatenate__Group__4__Impl ;
    public final void rule__Concatenate__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4562:1: ( rule__Concatenate__Group__4__Impl )
            // InternalFirstOrderLogic.g:4563:2: rule__Concatenate__Group__4__Impl
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
    // InternalFirstOrderLogic.g:4569:1: rule__Concatenate__Group__4__Impl : ( ')' ) ;
    public final void rule__Concatenate__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4573:1: ( ( ')' ) )
            // InternalFirstOrderLogic.g:4574:1: ( ')' )
            {
            // InternalFirstOrderLogic.g:4574:1: ( ')' )
            // InternalFirstOrderLogic.g:4575:2: ')'
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
    // InternalFirstOrderLogic.g:4585:1: rule__Capitalize__Group__0 : rule__Capitalize__Group__0__Impl rule__Capitalize__Group__1 ;
    public final void rule__Capitalize__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4589:1: ( rule__Capitalize__Group__0__Impl rule__Capitalize__Group__1 )
            // InternalFirstOrderLogic.g:4590:2: rule__Capitalize__Group__0__Impl rule__Capitalize__Group__1
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
    // InternalFirstOrderLogic.g:4597:1: rule__Capitalize__Group__0__Impl : ( 'capitalize(' ) ;
    public final void rule__Capitalize__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4601:1: ( ( 'capitalize(' ) )
            // InternalFirstOrderLogic.g:4602:1: ( 'capitalize(' )
            {
            // InternalFirstOrderLogic.g:4602:1: ( 'capitalize(' )
            // InternalFirstOrderLogic.g:4603:2: 'capitalize('
            {
             before(grammarAccess.getCapitalizeAccess().getCapitalizeKeyword_0()); 
            match(input,45,FOLLOW_2); 
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
    // InternalFirstOrderLogic.g:4612:1: rule__Capitalize__Group__1 : rule__Capitalize__Group__1__Impl rule__Capitalize__Group__2 ;
    public final void rule__Capitalize__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4616:1: ( rule__Capitalize__Group__1__Impl rule__Capitalize__Group__2 )
            // InternalFirstOrderLogic.g:4617:2: rule__Capitalize__Group__1__Impl rule__Capitalize__Group__2
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
    // InternalFirstOrderLogic.g:4624:1: rule__Capitalize__Group__1__Impl : ( ( rule__Capitalize__StringAssignment_1 ) ) ;
    public final void rule__Capitalize__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4628:1: ( ( ( rule__Capitalize__StringAssignment_1 ) ) )
            // InternalFirstOrderLogic.g:4629:1: ( ( rule__Capitalize__StringAssignment_1 ) )
            {
            // InternalFirstOrderLogic.g:4629:1: ( ( rule__Capitalize__StringAssignment_1 ) )
            // InternalFirstOrderLogic.g:4630:2: ( rule__Capitalize__StringAssignment_1 )
            {
             before(grammarAccess.getCapitalizeAccess().getStringAssignment_1()); 
            // InternalFirstOrderLogic.g:4631:2: ( rule__Capitalize__StringAssignment_1 )
            // InternalFirstOrderLogic.g:4631:3: rule__Capitalize__StringAssignment_1
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
    // InternalFirstOrderLogic.g:4639:1: rule__Capitalize__Group__2 : rule__Capitalize__Group__2__Impl ;
    public final void rule__Capitalize__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4643:1: ( rule__Capitalize__Group__2__Impl )
            // InternalFirstOrderLogic.g:4644:2: rule__Capitalize__Group__2__Impl
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
    // InternalFirstOrderLogic.g:4650:1: rule__Capitalize__Group__2__Impl : ( ')' ) ;
    public final void rule__Capitalize__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4654:1: ( ( ')' ) )
            // InternalFirstOrderLogic.g:4655:1: ( ')' )
            {
            // InternalFirstOrderLogic.g:4655:1: ( ')' )
            // InternalFirstOrderLogic.g:4656:2: ')'
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
    // InternalFirstOrderLogic.g:4666:1: rule__Constant__Group_0__0 : rule__Constant__Group_0__0__Impl rule__Constant__Group_0__1 ;
    public final void rule__Constant__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4670:1: ( rule__Constant__Group_0__0__Impl rule__Constant__Group_0__1 )
            // InternalFirstOrderLogic.g:4671:2: rule__Constant__Group_0__0__Impl rule__Constant__Group_0__1
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
    // InternalFirstOrderLogic.g:4678:1: rule__Constant__Group_0__0__Impl : ( () ) ;
    public final void rule__Constant__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4682:1: ( ( () ) )
            // InternalFirstOrderLogic.g:4683:1: ( () )
            {
            // InternalFirstOrderLogic.g:4683:1: ( () )
            // InternalFirstOrderLogic.g:4684:2: ()
            {
             before(grammarAccess.getConstantAccess().getIntConstantAction_0_0()); 
            // InternalFirstOrderLogic.g:4685:2: ()
            // InternalFirstOrderLogic.g:4685:3: 
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
    // InternalFirstOrderLogic.g:4693:1: rule__Constant__Group_0__1 : rule__Constant__Group_0__1__Impl ;
    public final void rule__Constant__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4697:1: ( rule__Constant__Group_0__1__Impl )
            // InternalFirstOrderLogic.g:4698:2: rule__Constant__Group_0__1__Impl
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
    // InternalFirstOrderLogic.g:4704:1: rule__Constant__Group_0__1__Impl : ( ( rule__Constant__ValueAssignment_0_1 ) ) ;
    public final void rule__Constant__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4708:1: ( ( ( rule__Constant__ValueAssignment_0_1 ) ) )
            // InternalFirstOrderLogic.g:4709:1: ( ( rule__Constant__ValueAssignment_0_1 ) )
            {
            // InternalFirstOrderLogic.g:4709:1: ( ( rule__Constant__ValueAssignment_0_1 ) )
            // InternalFirstOrderLogic.g:4710:2: ( rule__Constant__ValueAssignment_0_1 )
            {
             before(grammarAccess.getConstantAccess().getValueAssignment_0_1()); 
            // InternalFirstOrderLogic.g:4711:2: ( rule__Constant__ValueAssignment_0_1 )
            // InternalFirstOrderLogic.g:4711:3: rule__Constant__ValueAssignment_0_1
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
    // InternalFirstOrderLogic.g:4720:1: rule__Constant__Group_1__0 : rule__Constant__Group_1__0__Impl rule__Constant__Group_1__1 ;
    public final void rule__Constant__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4724:1: ( rule__Constant__Group_1__0__Impl rule__Constant__Group_1__1 )
            // InternalFirstOrderLogic.g:4725:2: rule__Constant__Group_1__0__Impl rule__Constant__Group_1__1
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
    // InternalFirstOrderLogic.g:4732:1: rule__Constant__Group_1__0__Impl : ( () ) ;
    public final void rule__Constant__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4736:1: ( ( () ) )
            // InternalFirstOrderLogic.g:4737:1: ( () )
            {
            // InternalFirstOrderLogic.g:4737:1: ( () )
            // InternalFirstOrderLogic.g:4738:2: ()
            {
             before(grammarAccess.getConstantAccess().getStringConstantAction_1_0()); 
            // InternalFirstOrderLogic.g:4739:2: ()
            // InternalFirstOrderLogic.g:4739:3: 
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
    // InternalFirstOrderLogic.g:4747:1: rule__Constant__Group_1__1 : rule__Constant__Group_1__1__Impl ;
    public final void rule__Constant__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4751:1: ( rule__Constant__Group_1__1__Impl )
            // InternalFirstOrderLogic.g:4752:2: rule__Constant__Group_1__1__Impl
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
    // InternalFirstOrderLogic.g:4758:1: rule__Constant__Group_1__1__Impl : ( ( rule__Constant__ValueAssignment_1_1 ) ) ;
    public final void rule__Constant__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4762:1: ( ( ( rule__Constant__ValueAssignment_1_1 ) ) )
            // InternalFirstOrderLogic.g:4763:1: ( ( rule__Constant__ValueAssignment_1_1 ) )
            {
            // InternalFirstOrderLogic.g:4763:1: ( ( rule__Constant__ValueAssignment_1_1 ) )
            // InternalFirstOrderLogic.g:4764:2: ( rule__Constant__ValueAssignment_1_1 )
            {
             before(grammarAccess.getConstantAccess().getValueAssignment_1_1()); 
            // InternalFirstOrderLogic.g:4765:2: ( rule__Constant__ValueAssignment_1_1 )
            // InternalFirstOrderLogic.g:4765:3: rule__Constant__ValueAssignment_1_1
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
    // InternalFirstOrderLogic.g:4774:1: rule__ConstraintLibrary__DomainAssignment_1 : ( RULE_STRING ) ;
    public final void rule__ConstraintLibrary__DomainAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4778:1: ( ( RULE_STRING ) )
            // InternalFirstOrderLogic.g:4779:2: ( RULE_STRING )
            {
            // InternalFirstOrderLogic.g:4779:2: ( RULE_STRING )
            // InternalFirstOrderLogic.g:4780:3: RULE_STRING
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
    // InternalFirstOrderLogic.g:4789:1: rule__ConstraintLibrary__PackageImportAssignment_3 : ( RULE_STRING ) ;
    public final void rule__ConstraintLibrary__PackageImportAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4793:1: ( ( RULE_STRING ) )
            // InternalFirstOrderLogic.g:4794:2: ( RULE_STRING )
            {
            // InternalFirstOrderLogic.g:4794:2: ( RULE_STRING )
            // InternalFirstOrderLogic.g:4795:3: RULE_STRING
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
    // InternalFirstOrderLogic.g:4804:1: rule__ConstraintLibrary__ConstraintsAssignment_4 : ( ruleConstraint ) ;
    public final void rule__ConstraintLibrary__ConstraintsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4808:1: ( ( ruleConstraint ) )
            // InternalFirstOrderLogic.g:4809:2: ( ruleConstraint )
            {
            // InternalFirstOrderLogic.g:4809:2: ( ruleConstraint )
            // InternalFirstOrderLogic.g:4810:3: ruleConstraint
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
    // InternalFirstOrderLogic.g:4819:1: rule__Constraint__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Constraint__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4823:1: ( ( RULE_ID ) )
            // InternalFirstOrderLogic.g:4824:2: ( RULE_ID )
            {
            // InternalFirstOrderLogic.g:4824:2: ( RULE_ID )
            // InternalFirstOrderLogic.g:4825:3: RULE_ID
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
    // InternalFirstOrderLogic.g:4834:1: rule__Constraint__MessageAssignment_3 : ( RULE_STRING ) ;
    public final void rule__Constraint__MessageAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4838:1: ( ( RULE_STRING ) )
            // InternalFirstOrderLogic.g:4839:2: ( RULE_STRING )
            {
            // InternalFirstOrderLogic.g:4839:2: ( RULE_STRING )
            // InternalFirstOrderLogic.g:4840:3: RULE_STRING
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
    // InternalFirstOrderLogic.g:4849:1: rule__Constraint__VariableAssignment_5 : ( ruleVariable ) ;
    public final void rule__Constraint__VariableAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4853:1: ( ( ruleVariable ) )
            // InternalFirstOrderLogic.g:4854:2: ( ruleVariable )
            {
            // InternalFirstOrderLogic.g:4854:2: ( ruleVariable )
            // InternalFirstOrderLogic.g:4855:3: ruleVariable
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
    // InternalFirstOrderLogic.g:4864:1: rule__Constraint__FormulaAssignment_7 : ( ruleFormula ) ;
    public final void rule__Constraint__FormulaAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4868:1: ( ( ruleFormula ) )
            // InternalFirstOrderLogic.g:4869:2: ( ruleFormula )
            {
            // InternalFirstOrderLogic.g:4869:2: ( ruleFormula )
            // InternalFirstOrderLogic.g:4870:3: ruleFormula
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
    // InternalFirstOrderLogic.g:4879:1: rule__Variable__TypeAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__Variable__TypeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4883:1: ( ( ( RULE_ID ) ) )
            // InternalFirstOrderLogic.g:4884:2: ( ( RULE_ID ) )
            {
            // InternalFirstOrderLogic.g:4884:2: ( ( RULE_ID ) )
            // InternalFirstOrderLogic.g:4885:3: ( RULE_ID )
            {
             before(grammarAccess.getVariableAccess().getTypeEClassifierCrossReference_0_0()); 
            // InternalFirstOrderLogic.g:4886:3: ( RULE_ID )
            // InternalFirstOrderLogic.g:4887:4: RULE_ID
            {
             before(grammarAccess.getVariableAccess().getTypeEClassifierIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getVariableAccess().getTypeEClassifierIDTerminalRuleCall_0_0_1()); 

            }

             after(grammarAccess.getVariableAccess().getTypeEClassifierCrossReference_0_0()); 

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
    // InternalFirstOrderLogic.g:4898:1: rule__Variable__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Variable__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4902:1: ( ( RULE_ID ) )
            // InternalFirstOrderLogic.g:4903:2: ( RULE_ID )
            {
            // InternalFirstOrderLogic.g:4903:2: ( RULE_ID )
            // InternalFirstOrderLogic.g:4904:3: RULE_ID
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
    // InternalFirstOrderLogic.g:4913:1: rule__Iff__RightAssignment_1_2 : ( ruleIf ) ;
    public final void rule__Iff__RightAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4917:1: ( ( ruleIf ) )
            // InternalFirstOrderLogic.g:4918:2: ( ruleIf )
            {
            // InternalFirstOrderLogic.g:4918:2: ( ruleIf )
            // InternalFirstOrderLogic.g:4919:3: ruleIf
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
    // InternalFirstOrderLogic.g:4928:1: rule__If__RightAssignment_1_2 : ( ruleXor ) ;
    public final void rule__If__RightAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4932:1: ( ( ruleXor ) )
            // InternalFirstOrderLogic.g:4933:2: ( ruleXor )
            {
            // InternalFirstOrderLogic.g:4933:2: ( ruleXor )
            // InternalFirstOrderLogic.g:4934:3: ruleXor
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
    // InternalFirstOrderLogic.g:4943:1: rule__Xor__RightAssignment_1_2 : ( ruleOr ) ;
    public final void rule__Xor__RightAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4947:1: ( ( ruleOr ) )
            // InternalFirstOrderLogic.g:4948:2: ( ruleOr )
            {
            // InternalFirstOrderLogic.g:4948:2: ( ruleOr )
            // InternalFirstOrderLogic.g:4949:3: ruleOr
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
    // InternalFirstOrderLogic.g:4958:1: rule__Or__RightAssignment_1_2 : ( ruleAnd ) ;
    public final void rule__Or__RightAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4962:1: ( ( ruleAnd ) )
            // InternalFirstOrderLogic.g:4963:2: ( ruleAnd )
            {
            // InternalFirstOrderLogic.g:4963:2: ( ruleAnd )
            // InternalFirstOrderLogic.g:4964:3: ruleAnd
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
    // InternalFirstOrderLogic.g:4973:1: rule__And__RightAssignment_1_2 : ( ruleBooleanExpression ) ;
    public final void rule__And__RightAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4977:1: ( ( ruleBooleanExpression ) )
            // InternalFirstOrderLogic.g:4978:2: ( ruleBooleanExpression )
            {
            // InternalFirstOrderLogic.g:4978:2: ( ruleBooleanExpression )
            // InternalFirstOrderLogic.g:4979:3: ruleBooleanExpression
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
    // InternalFirstOrderLogic.g:4988:1: rule__Not__NotAssignment_2 : ( ruleFormula ) ;
    public final void rule__Not__NotAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4992:1: ( ( ruleFormula ) )
            // InternalFirstOrderLogic.g:4993:2: ( ruleFormula )
            {
            // InternalFirstOrderLogic.g:4993:2: ( ruleFormula )
            // InternalFirstOrderLogic.g:4994:3: ruleFormula
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
    // InternalFirstOrderLogic.g:5003:1: rule__Equals__LeftAssignment_1 : ( ruleTerm ) ;
    public final void rule__Equals__LeftAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5007:1: ( ( ruleTerm ) )
            // InternalFirstOrderLogic.g:5008:2: ( ruleTerm )
            {
            // InternalFirstOrderLogic.g:5008:2: ( ruleTerm )
            // InternalFirstOrderLogic.g:5009:3: ruleTerm
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
    // InternalFirstOrderLogic.g:5018:1: rule__Equals__RightAssignment_3 : ( ruleTerm ) ;
    public final void rule__Equals__RightAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5022:1: ( ( ruleTerm ) )
            // InternalFirstOrderLogic.g:5023:2: ( ruleTerm )
            {
            // InternalFirstOrderLogic.g:5023:2: ( ruleTerm )
            // InternalFirstOrderLogic.g:5024:3: ruleTerm
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
    // InternalFirstOrderLogic.g:5033:1: rule__Greater__LeftAssignment_1 : ( ruleTerm ) ;
    public final void rule__Greater__LeftAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5037:1: ( ( ruleTerm ) )
            // InternalFirstOrderLogic.g:5038:2: ( ruleTerm )
            {
            // InternalFirstOrderLogic.g:5038:2: ( ruleTerm )
            // InternalFirstOrderLogic.g:5039:3: ruleTerm
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
    // InternalFirstOrderLogic.g:5048:1: rule__Greater__RightAssignment_3 : ( ruleTerm ) ;
    public final void rule__Greater__RightAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5052:1: ( ( ruleTerm ) )
            // InternalFirstOrderLogic.g:5053:2: ( ruleTerm )
            {
            // InternalFirstOrderLogic.g:5053:2: ( ruleTerm )
            // InternalFirstOrderLogic.g:5054:3: ruleTerm
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
    // InternalFirstOrderLogic.g:5063:1: rule__GreaterEqual__LeftAssignment_1 : ( ruleTerm ) ;
    public final void rule__GreaterEqual__LeftAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5067:1: ( ( ruleTerm ) )
            // InternalFirstOrderLogic.g:5068:2: ( ruleTerm )
            {
            // InternalFirstOrderLogic.g:5068:2: ( ruleTerm )
            // InternalFirstOrderLogic.g:5069:3: ruleTerm
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
    // InternalFirstOrderLogic.g:5078:1: rule__GreaterEqual__RightAssignment_3 : ( ruleTerm ) ;
    public final void rule__GreaterEqual__RightAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5082:1: ( ( ruleTerm ) )
            // InternalFirstOrderLogic.g:5083:2: ( ruleTerm )
            {
            // InternalFirstOrderLogic.g:5083:2: ( ruleTerm )
            // InternalFirstOrderLogic.g:5084:3: ruleTerm
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
    // InternalFirstOrderLogic.g:5093:1: rule__Smaller__LeftAssignment_1 : ( ruleTerm ) ;
    public final void rule__Smaller__LeftAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5097:1: ( ( ruleTerm ) )
            // InternalFirstOrderLogic.g:5098:2: ( ruleTerm )
            {
            // InternalFirstOrderLogic.g:5098:2: ( ruleTerm )
            // InternalFirstOrderLogic.g:5099:3: ruleTerm
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
    // InternalFirstOrderLogic.g:5108:1: rule__Smaller__RightAssignment_3 : ( ruleTerm ) ;
    public final void rule__Smaller__RightAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5112:1: ( ( ruleTerm ) )
            // InternalFirstOrderLogic.g:5113:2: ( ruleTerm )
            {
            // InternalFirstOrderLogic.g:5113:2: ( ruleTerm )
            // InternalFirstOrderLogic.g:5114:3: ruleTerm
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
    // InternalFirstOrderLogic.g:5123:1: rule__SmallerEqual__LeftAssignment_1 : ( ruleTerm ) ;
    public final void rule__SmallerEqual__LeftAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5127:1: ( ( ruleTerm ) )
            // InternalFirstOrderLogic.g:5128:2: ( ruleTerm )
            {
            // InternalFirstOrderLogic.g:5128:2: ( ruleTerm )
            // InternalFirstOrderLogic.g:5129:3: ruleTerm
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
    // InternalFirstOrderLogic.g:5138:1: rule__SmallerEqual__RightAssignment_3 : ( ruleTerm ) ;
    public final void rule__SmallerEqual__RightAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5142:1: ( ( ruleTerm ) )
            // InternalFirstOrderLogic.g:5143:2: ( ruleTerm )
            {
            // InternalFirstOrderLogic.g:5143:2: ( ruleTerm )
            // InternalFirstOrderLogic.g:5144:3: ruleTerm
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
    // InternalFirstOrderLogic.g:5153:1: rule__IsEmpty__TermAssignment_1 : ( ruleTerm ) ;
    public final void rule__IsEmpty__TermAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5157:1: ( ( ruleTerm ) )
            // InternalFirstOrderLogic.g:5158:2: ( ruleTerm )
            {
            // InternalFirstOrderLogic.g:5158:2: ( ruleTerm )
            // InternalFirstOrderLogic.g:5159:3: ruleTerm
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
    // InternalFirstOrderLogic.g:5168:1: rule__IsInstanceOf__TermAssignment_1 : ( ruleTerm ) ;
    public final void rule__IsInstanceOf__TermAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5172:1: ( ( ruleTerm ) )
            // InternalFirstOrderLogic.g:5173:2: ( ruleTerm )
            {
            // InternalFirstOrderLogic.g:5173:2: ( ruleTerm )
            // InternalFirstOrderLogic.g:5174:3: ruleTerm
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
    // InternalFirstOrderLogic.g:5183:1: rule__IsInstanceOf__TypeAssignment_3 : ( ( RULE_ID ) ) ;
    public final void rule__IsInstanceOf__TypeAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5187:1: ( ( ( RULE_ID ) ) )
            // InternalFirstOrderLogic.g:5188:2: ( ( RULE_ID ) )
            {
            // InternalFirstOrderLogic.g:5188:2: ( ( RULE_ID ) )
            // InternalFirstOrderLogic.g:5189:3: ( RULE_ID )
            {
             before(grammarAccess.getIsInstanceOfAccess().getTypeEClassifierCrossReference_3_0()); 
            // InternalFirstOrderLogic.g:5190:3: ( RULE_ID )
            // InternalFirstOrderLogic.g:5191:4: RULE_ID
            {
             before(grammarAccess.getIsInstanceOfAccess().getTypeEClassifierIDTerminalRuleCall_3_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getIsInstanceOfAccess().getTypeEClassifierIDTerminalRuleCall_3_0_1()); 

            }

             after(grammarAccess.getIsInstanceOfAccess().getTypeEClassifierCrossReference_3_0()); 

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
    // InternalFirstOrderLogic.g:5202:1: rule__ForAll__NameAssignment_2 : ( ruleVariable ) ;
    public final void rule__ForAll__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5206:1: ( ( ruleVariable ) )
            // InternalFirstOrderLogic.g:5207:2: ( ruleVariable )
            {
            // InternalFirstOrderLogic.g:5207:2: ( ruleVariable )
            // InternalFirstOrderLogic.g:5208:3: ruleVariable
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
    // InternalFirstOrderLogic.g:5217:1: rule__ForAll__IterationAssignment_4 : ( ruleTerm ) ;
    public final void rule__ForAll__IterationAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5221:1: ( ( ruleTerm ) )
            // InternalFirstOrderLogic.g:5222:2: ( ruleTerm )
            {
            // InternalFirstOrderLogic.g:5222:2: ( ruleTerm )
            // InternalFirstOrderLogic.g:5223:3: ruleTerm
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
    // InternalFirstOrderLogic.g:5232:1: rule__ForAll__FormulaAssignment_6 : ( ruleFormula ) ;
    public final void rule__ForAll__FormulaAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5236:1: ( ( ruleFormula ) )
            // InternalFirstOrderLogic.g:5237:2: ( ruleFormula )
            {
            // InternalFirstOrderLogic.g:5237:2: ( ruleFormula )
            // InternalFirstOrderLogic.g:5238:3: ruleFormula
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
    // InternalFirstOrderLogic.g:5247:1: rule__Exists__NameAssignment_2 : ( ruleVariable ) ;
    public final void rule__Exists__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5251:1: ( ( ruleVariable ) )
            // InternalFirstOrderLogic.g:5252:2: ( ruleVariable )
            {
            // InternalFirstOrderLogic.g:5252:2: ( ruleVariable )
            // InternalFirstOrderLogic.g:5253:3: ruleVariable
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
    // InternalFirstOrderLogic.g:5262:1: rule__Exists__IterationAssignment_4 : ( ruleTerm ) ;
    public final void rule__Exists__IterationAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5266:1: ( ( ruleTerm ) )
            // InternalFirstOrderLogic.g:5267:2: ( ruleTerm )
            {
            // InternalFirstOrderLogic.g:5267:2: ( ruleTerm )
            // InternalFirstOrderLogic.g:5268:3: ruleTerm
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
    // InternalFirstOrderLogic.g:5277:1: rule__Exists__FormulaAssignment_6 : ( ruleFormula ) ;
    public final void rule__Exists__FormulaAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5281:1: ( ( ruleFormula ) )
            // InternalFirstOrderLogic.g:5282:2: ( ruleFormula )
            {
            // InternalFirstOrderLogic.g:5282:2: ( ruleFormula )
            // InternalFirstOrderLogic.g:5283:3: ruleFormula
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
    // InternalFirstOrderLogic.g:5292:1: rule__BoolConstant__ValueAssignment_1 : ( ( rule__BoolConstant__ValueAlternatives_1_0 ) ) ;
    public final void rule__BoolConstant__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5296:1: ( ( ( rule__BoolConstant__ValueAlternatives_1_0 ) ) )
            // InternalFirstOrderLogic.g:5297:2: ( ( rule__BoolConstant__ValueAlternatives_1_0 ) )
            {
            // InternalFirstOrderLogic.g:5297:2: ( ( rule__BoolConstant__ValueAlternatives_1_0 ) )
            // InternalFirstOrderLogic.g:5298:3: ( rule__BoolConstant__ValueAlternatives_1_0 )
            {
             before(grammarAccess.getBoolConstantAccess().getValueAlternatives_1_0()); 
            // InternalFirstOrderLogic.g:5299:3: ( rule__BoolConstant__ValueAlternatives_1_0 )
            // InternalFirstOrderLogic.g:5299:4: rule__BoolConstant__ValueAlternatives_1_0
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
    // InternalFirstOrderLogic.g:5307:1: rule__VariableRef__NameAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__VariableRef__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5311:1: ( ( ( RULE_ID ) ) )
            // InternalFirstOrderLogic.g:5312:2: ( ( RULE_ID ) )
            {
            // InternalFirstOrderLogic.g:5312:2: ( ( RULE_ID ) )
            // InternalFirstOrderLogic.g:5313:3: ( RULE_ID )
            {
             before(grammarAccess.getVariableRefAccess().getNameVariableCrossReference_1_0()); 
            // InternalFirstOrderLogic.g:5314:3: ( RULE_ID )
            // InternalFirstOrderLogic.g:5315:4: RULE_ID
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
    // InternalFirstOrderLogic.g:5326:1: rule__VariableRef__GetAssignment_2 : ( ruleGet ) ;
    public final void rule__VariableRef__GetAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5330:1: ( ( ruleGet ) )
            // InternalFirstOrderLogic.g:5331:2: ( ruleGet )
            {
            // InternalFirstOrderLogic.g:5331:2: ( ruleGet )
            // InternalFirstOrderLogic.g:5332:3: ruleGet
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
    // InternalFirstOrderLogic.g:5341:1: rule__Get__TypeAssignment_1_0 : ( ( RULE_ID ) ) ;
    public final void rule__Get__TypeAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5345:1: ( ( ( RULE_ID ) ) )
            // InternalFirstOrderLogic.g:5346:2: ( ( RULE_ID ) )
            {
            // InternalFirstOrderLogic.g:5346:2: ( ( RULE_ID ) )
            // InternalFirstOrderLogic.g:5347:3: ( RULE_ID )
            {
             before(grammarAccess.getGetAccess().getTypeEClassifierCrossReference_1_0_0()); 
            // InternalFirstOrderLogic.g:5348:3: ( RULE_ID )
            // InternalFirstOrderLogic.g:5349:4: RULE_ID
            {
             before(grammarAccess.getGetAccess().getTypeEClassifierIDTerminalRuleCall_1_0_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getGetAccess().getTypeEClassifierIDTerminalRuleCall_1_0_0_1()); 

            }

             after(grammarAccess.getGetAccess().getTypeEClassifierCrossReference_1_0_0()); 

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
    // InternalFirstOrderLogic.g:5360:1: rule__Get__NameAssignment_2 : ( ( RULE_ID ) ) ;
    public final void rule__Get__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5364:1: ( ( ( RULE_ID ) ) )
            // InternalFirstOrderLogic.g:5365:2: ( ( RULE_ID ) )
            {
            // InternalFirstOrderLogic.g:5365:2: ( ( RULE_ID ) )
            // InternalFirstOrderLogic.g:5366:3: ( RULE_ID )
            {
             before(grammarAccess.getGetAccess().getNameEStructuralFeatureCrossReference_2_0()); 
            // InternalFirstOrderLogic.g:5367:3: ( RULE_ID )
            // InternalFirstOrderLogic.g:5368:4: RULE_ID
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
    // InternalFirstOrderLogic.g:5379:1: rule__Get__NextAssignment_3 : ( ruleGet ) ;
    public final void rule__Get__NextAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5383:1: ( ( ruleGet ) )
            // InternalFirstOrderLogic.g:5384:2: ( ruleGet )
            {
            // InternalFirstOrderLogic.g:5384:2: ( ruleGet )
            // InternalFirstOrderLogic.g:5385:3: ruleGet
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
    // InternalFirstOrderLogic.g:5394:1: rule__GetContainer__ElementAssignment_1 : ( ruleTerm ) ;
    public final void rule__GetContainer__ElementAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5398:1: ( ( ruleTerm ) )
            // InternalFirstOrderLogic.g:5399:2: ( ruleTerm )
            {
            // InternalFirstOrderLogic.g:5399:2: ( ruleTerm )
            // InternalFirstOrderLogic.g:5400:3: ruleTerm
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


    // $ANTLR start "rule__GetContainments__ElementAssignment_1"
    // InternalFirstOrderLogic.g:5409:1: rule__GetContainments__ElementAssignment_1 : ( ruleTerm ) ;
    public final void rule__GetContainments__ElementAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5413:1: ( ( ruleTerm ) )
            // InternalFirstOrderLogic.g:5414:2: ( ruleTerm )
            {
            // InternalFirstOrderLogic.g:5414:2: ( ruleTerm )
            // InternalFirstOrderLogic.g:5415:3: ruleTerm
            {
             before(grammarAccess.getGetContainmentsAccess().getElementTermParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleTerm();

            state._fsp--;

             after(grammarAccess.getGetContainmentsAccess().getElementTermParserRuleCall_1_0()); 

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
    // $ANTLR end "rule__GetContainments__ElementAssignment_1"


    // $ANTLR start "rule__GetClosure__ElementAssignment_1"
    // InternalFirstOrderLogic.g:5424:1: rule__GetClosure__ElementAssignment_1 : ( ruleTerm ) ;
    public final void rule__GetClosure__ElementAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5428:1: ( ( ruleTerm ) )
            // InternalFirstOrderLogic.g:5429:2: ( ruleTerm )
            {
            // InternalFirstOrderLogic.g:5429:2: ( ruleTerm )
            // InternalFirstOrderLogic.g:5430:3: ruleTerm
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
    // InternalFirstOrderLogic.g:5439:1: rule__GetClosure__FeatureAssignment_3 : ( ( RULE_ID ) ) ;
    public final void rule__GetClosure__FeatureAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5443:1: ( ( ( RULE_ID ) ) )
            // InternalFirstOrderLogic.g:5444:2: ( ( RULE_ID ) )
            {
            // InternalFirstOrderLogic.g:5444:2: ( ( RULE_ID ) )
            // InternalFirstOrderLogic.g:5445:3: ( RULE_ID )
            {
             before(grammarAccess.getGetClosureAccess().getFeatureEStructuralFeatureCrossReference_3_0()); 
            // InternalFirstOrderLogic.g:5446:3: ( RULE_ID )
            // InternalFirstOrderLogic.g:5447:4: RULE_ID
            {
             before(grammarAccess.getGetClosureAccess().getFeatureEStructuralFeatureIDTerminalRuleCall_3_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getGetClosureAccess().getFeatureEStructuralFeatureIDTerminalRuleCall_3_0_1()); 

            }

             after(grammarAccess.getGetClosureAccess().getFeatureEStructuralFeatureCrossReference_3_0()); 

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


    // $ANTLR start "rule__Size__ElementsAssignment_1"
    // InternalFirstOrderLogic.g:5458:1: rule__Size__ElementsAssignment_1 : ( ruleTerm ) ;
    public final void rule__Size__ElementsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5462:1: ( ( ruleTerm ) )
            // InternalFirstOrderLogic.g:5463:2: ( ruleTerm )
            {
            // InternalFirstOrderLogic.g:5463:2: ( ruleTerm )
            // InternalFirstOrderLogic.g:5464:3: ruleTerm
            {
             before(grammarAccess.getSizeAccess().getElementsTermParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleTerm();

            state._fsp--;

             after(grammarAccess.getSizeAccess().getElementsTermParserRuleCall_1_0()); 

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
    // $ANTLR end "rule__Size__ElementsAssignment_1"


    // $ANTLR start "rule__Concatenate__LeftAssignment_1"
    // InternalFirstOrderLogic.g:5473:1: rule__Concatenate__LeftAssignment_1 : ( ruleTerm ) ;
    public final void rule__Concatenate__LeftAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5477:1: ( ( ruleTerm ) )
            // InternalFirstOrderLogic.g:5478:2: ( ruleTerm )
            {
            // InternalFirstOrderLogic.g:5478:2: ( ruleTerm )
            // InternalFirstOrderLogic.g:5479:3: ruleTerm
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
    // InternalFirstOrderLogic.g:5488:1: rule__Concatenate__RightAssignment_3 : ( ruleTerm ) ;
    public final void rule__Concatenate__RightAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5492:1: ( ( ruleTerm ) )
            // InternalFirstOrderLogic.g:5493:2: ( ruleTerm )
            {
            // InternalFirstOrderLogic.g:5493:2: ( ruleTerm )
            // InternalFirstOrderLogic.g:5494:3: ruleTerm
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
    // InternalFirstOrderLogic.g:5503:1: rule__Capitalize__StringAssignment_1 : ( ruleTerm ) ;
    public final void rule__Capitalize__StringAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5507:1: ( ( ruleTerm ) )
            // InternalFirstOrderLogic.g:5508:2: ( ruleTerm )
            {
            // InternalFirstOrderLogic.g:5508:2: ( ruleTerm )
            // InternalFirstOrderLogic.g:5509:3: ruleTerm
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
    // InternalFirstOrderLogic.g:5518:1: rule__Constant__ValueAssignment_0_1 : ( RULE_INT ) ;
    public final void rule__Constant__ValueAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5522:1: ( ( RULE_INT ) )
            // InternalFirstOrderLogic.g:5523:2: ( RULE_INT )
            {
            // InternalFirstOrderLogic.g:5523:2: ( RULE_INT )
            // InternalFirstOrderLogic.g:5524:3: RULE_INT
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
    // InternalFirstOrderLogic.g:5533:1: rule__Constant__ValueAssignment_1_1 : ( RULE_STRING ) ;
    public final void rule__Constant__ValueAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5537:1: ( ( RULE_STRING ) )
            // InternalFirstOrderLogic.g:5538:2: ( RULE_STRING )
            {
            // InternalFirstOrderLogic.g:5538:2: ( RULE_STRING )
            // InternalFirstOrderLogic.g:5539:3: RULE_STRING
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
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x00003F37F5001870L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000001400000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000000000040L});

}