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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'true'", "'false'", "'domain'", "'import'", "'constraint'", "'message'", "'context'", "':'", "'='", "'implies'", "'xor'", "'or'", "'and'", "'not('", "')'", "'isEqual('", "','", "'isGreater('", "'isGreaterEqual('", "'isSmaller('", "'isSmallerEqual('", "'isEmpty('", "'forAll('", "'in'", "'exists('", "'('", "'.'", "'::'", "'getContainer('", "'getContainments('"
    };
    public static final int RULE_STRING=4;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__37=37;
    public static final int T__16=16;
    public static final int T__38=38;
    public static final int T__17=17;
    public static final int T__39=39;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__33=33;
    public static final int T__12=12;
    public static final int T__34=34;
    public static final int T__13=13;
    public static final int T__35=35;
    public static final int T__14=14;
    public static final int T__36=36;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_ID=5;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
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
    public static final int T__40=40;
    public static final int T__20=20;
    public static final int T__21=21;

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


    // $ANTLR start "entryRuleQuantifier"
    // InternalFirstOrderLogic.g:553:1: entryRuleQuantifier : ruleQuantifier EOF ;
    public final void entryRuleQuantifier() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:554:1: ( ruleQuantifier EOF )
            // InternalFirstOrderLogic.g:555:1: ruleQuantifier EOF
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
    // InternalFirstOrderLogic.g:562:1: ruleQuantifier : ( ( rule__Quantifier__Alternatives ) ) ;
    public final void ruleQuantifier() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:566:2: ( ( ( rule__Quantifier__Alternatives ) ) )
            // InternalFirstOrderLogic.g:567:2: ( ( rule__Quantifier__Alternatives ) )
            {
            // InternalFirstOrderLogic.g:567:2: ( ( rule__Quantifier__Alternatives ) )
            // InternalFirstOrderLogic.g:568:3: ( rule__Quantifier__Alternatives )
            {
             before(grammarAccess.getQuantifierAccess().getAlternatives()); 
            // InternalFirstOrderLogic.g:569:3: ( rule__Quantifier__Alternatives )
            // InternalFirstOrderLogic.g:569:4: rule__Quantifier__Alternatives
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
    // InternalFirstOrderLogic.g:578:1: entryRuleForAll : ruleForAll EOF ;
    public final void entryRuleForAll() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:579:1: ( ruleForAll EOF )
            // InternalFirstOrderLogic.g:580:1: ruleForAll EOF
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
    // InternalFirstOrderLogic.g:587:1: ruleForAll : ( ( rule__ForAll__Group__0 ) ) ;
    public final void ruleForAll() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:591:2: ( ( ( rule__ForAll__Group__0 ) ) )
            // InternalFirstOrderLogic.g:592:2: ( ( rule__ForAll__Group__0 ) )
            {
            // InternalFirstOrderLogic.g:592:2: ( ( rule__ForAll__Group__0 ) )
            // InternalFirstOrderLogic.g:593:3: ( rule__ForAll__Group__0 )
            {
             before(grammarAccess.getForAllAccess().getGroup()); 
            // InternalFirstOrderLogic.g:594:3: ( rule__ForAll__Group__0 )
            // InternalFirstOrderLogic.g:594:4: rule__ForAll__Group__0
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
    // InternalFirstOrderLogic.g:603:1: entryRuleExists : ruleExists EOF ;
    public final void entryRuleExists() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:604:1: ( ruleExists EOF )
            // InternalFirstOrderLogic.g:605:1: ruleExists EOF
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
    // InternalFirstOrderLogic.g:612:1: ruleExists : ( ( rule__Exists__Group__0 ) ) ;
    public final void ruleExists() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:616:2: ( ( ( rule__Exists__Group__0 ) ) )
            // InternalFirstOrderLogic.g:617:2: ( ( rule__Exists__Group__0 ) )
            {
            // InternalFirstOrderLogic.g:617:2: ( ( rule__Exists__Group__0 ) )
            // InternalFirstOrderLogic.g:618:3: ( rule__Exists__Group__0 )
            {
             before(grammarAccess.getExistsAccess().getGroup()); 
            // InternalFirstOrderLogic.g:619:3: ( rule__Exists__Group__0 )
            // InternalFirstOrderLogic.g:619:4: rule__Exists__Group__0
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
    // InternalFirstOrderLogic.g:628:1: entryRuleBooleanExpression : ruleBooleanExpression EOF ;
    public final void entryRuleBooleanExpression() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:629:1: ( ruleBooleanExpression EOF )
            // InternalFirstOrderLogic.g:630:1: ruleBooleanExpression EOF
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
    // InternalFirstOrderLogic.g:637:1: ruleBooleanExpression : ( ( rule__BooleanExpression__Alternatives ) ) ;
    public final void ruleBooleanExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:641:2: ( ( ( rule__BooleanExpression__Alternatives ) ) )
            // InternalFirstOrderLogic.g:642:2: ( ( rule__BooleanExpression__Alternatives ) )
            {
            // InternalFirstOrderLogic.g:642:2: ( ( rule__BooleanExpression__Alternatives ) )
            // InternalFirstOrderLogic.g:643:3: ( rule__BooleanExpression__Alternatives )
            {
             before(grammarAccess.getBooleanExpressionAccess().getAlternatives()); 
            // InternalFirstOrderLogic.g:644:3: ( rule__BooleanExpression__Alternatives )
            // InternalFirstOrderLogic.g:644:4: rule__BooleanExpression__Alternatives
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
    // InternalFirstOrderLogic.g:653:1: entryRuleBoolConstant : ruleBoolConstant EOF ;
    public final void entryRuleBoolConstant() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:654:1: ( ruleBoolConstant EOF )
            // InternalFirstOrderLogic.g:655:1: ruleBoolConstant EOF
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
    // InternalFirstOrderLogic.g:662:1: ruleBoolConstant : ( ( rule__BoolConstant__Group__0 ) ) ;
    public final void ruleBoolConstant() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:666:2: ( ( ( rule__BoolConstant__Group__0 ) ) )
            // InternalFirstOrderLogic.g:667:2: ( ( rule__BoolConstant__Group__0 ) )
            {
            // InternalFirstOrderLogic.g:667:2: ( ( rule__BoolConstant__Group__0 ) )
            // InternalFirstOrderLogic.g:668:3: ( rule__BoolConstant__Group__0 )
            {
             before(grammarAccess.getBoolConstantAccess().getGroup()); 
            // InternalFirstOrderLogic.g:669:3: ( rule__BoolConstant__Group__0 )
            // InternalFirstOrderLogic.g:669:4: rule__BoolConstant__Group__0
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
    // InternalFirstOrderLogic.g:678:1: entryRuleTerm : ruleTerm EOF ;
    public final void entryRuleTerm() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:679:1: ( ruleTerm EOF )
            // InternalFirstOrderLogic.g:680:1: ruleTerm EOF
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
    // InternalFirstOrderLogic.g:687:1: ruleTerm : ( ( rule__Term__Alternatives ) ) ;
    public final void ruleTerm() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:691:2: ( ( ( rule__Term__Alternatives ) ) )
            // InternalFirstOrderLogic.g:692:2: ( ( rule__Term__Alternatives ) )
            {
            // InternalFirstOrderLogic.g:692:2: ( ( rule__Term__Alternatives ) )
            // InternalFirstOrderLogic.g:693:3: ( rule__Term__Alternatives )
            {
             before(grammarAccess.getTermAccess().getAlternatives()); 
            // InternalFirstOrderLogic.g:694:3: ( rule__Term__Alternatives )
            // InternalFirstOrderLogic.g:694:4: rule__Term__Alternatives
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
    // InternalFirstOrderLogic.g:703:1: entryRuleVariableRef : ruleVariableRef EOF ;
    public final void entryRuleVariableRef() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:704:1: ( ruleVariableRef EOF )
            // InternalFirstOrderLogic.g:705:1: ruleVariableRef EOF
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
    // InternalFirstOrderLogic.g:712:1: ruleVariableRef : ( ( rule__VariableRef__Group__0 ) ) ;
    public final void ruleVariableRef() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:716:2: ( ( ( rule__VariableRef__Group__0 ) ) )
            // InternalFirstOrderLogic.g:717:2: ( ( rule__VariableRef__Group__0 ) )
            {
            // InternalFirstOrderLogic.g:717:2: ( ( rule__VariableRef__Group__0 ) )
            // InternalFirstOrderLogic.g:718:3: ( rule__VariableRef__Group__0 )
            {
             before(grammarAccess.getVariableRefAccess().getGroup()); 
            // InternalFirstOrderLogic.g:719:3: ( rule__VariableRef__Group__0 )
            // InternalFirstOrderLogic.g:719:4: rule__VariableRef__Group__0
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
    // InternalFirstOrderLogic.g:728:1: entryRuleGet : ruleGet EOF ;
    public final void entryRuleGet() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:729:1: ( ruleGet EOF )
            // InternalFirstOrderLogic.g:730:1: ruleGet EOF
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
    // InternalFirstOrderLogic.g:737:1: ruleGet : ( ( rule__Get__Group__0 ) ) ;
    public final void ruleGet() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:741:2: ( ( ( rule__Get__Group__0 ) ) )
            // InternalFirstOrderLogic.g:742:2: ( ( rule__Get__Group__0 ) )
            {
            // InternalFirstOrderLogic.g:742:2: ( ( rule__Get__Group__0 ) )
            // InternalFirstOrderLogic.g:743:3: ( rule__Get__Group__0 )
            {
             before(grammarAccess.getGetAccess().getGroup()); 
            // InternalFirstOrderLogic.g:744:3: ( rule__Get__Group__0 )
            // InternalFirstOrderLogic.g:744:4: rule__Get__Group__0
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
    // InternalFirstOrderLogic.g:753:1: entryRuleGetContainer : ruleGetContainer EOF ;
    public final void entryRuleGetContainer() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:754:1: ( ruleGetContainer EOF )
            // InternalFirstOrderLogic.g:755:1: ruleGetContainer EOF
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
    // InternalFirstOrderLogic.g:762:1: ruleGetContainer : ( ( rule__GetContainer__Group__0 ) ) ;
    public final void ruleGetContainer() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:766:2: ( ( ( rule__GetContainer__Group__0 ) ) )
            // InternalFirstOrderLogic.g:767:2: ( ( rule__GetContainer__Group__0 ) )
            {
            // InternalFirstOrderLogic.g:767:2: ( ( rule__GetContainer__Group__0 ) )
            // InternalFirstOrderLogic.g:768:3: ( rule__GetContainer__Group__0 )
            {
             before(grammarAccess.getGetContainerAccess().getGroup()); 
            // InternalFirstOrderLogic.g:769:3: ( rule__GetContainer__Group__0 )
            // InternalFirstOrderLogic.g:769:4: rule__GetContainer__Group__0
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
    // InternalFirstOrderLogic.g:778:1: entryRuleGetContainment : ruleGetContainment EOF ;
    public final void entryRuleGetContainment() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:779:1: ( ruleGetContainment EOF )
            // InternalFirstOrderLogic.g:780:1: ruleGetContainment EOF
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
    // InternalFirstOrderLogic.g:787:1: ruleGetContainment : ( ( rule__GetContainment__Group__0 ) ) ;
    public final void ruleGetContainment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:791:2: ( ( ( rule__GetContainment__Group__0 ) ) )
            // InternalFirstOrderLogic.g:792:2: ( ( rule__GetContainment__Group__0 ) )
            {
            // InternalFirstOrderLogic.g:792:2: ( ( rule__GetContainment__Group__0 ) )
            // InternalFirstOrderLogic.g:793:3: ( rule__GetContainment__Group__0 )
            {
             before(grammarAccess.getGetContainmentAccess().getGroup()); 
            // InternalFirstOrderLogic.g:794:3: ( rule__GetContainment__Group__0 )
            // InternalFirstOrderLogic.g:794:4: rule__GetContainment__Group__0
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


    // $ANTLR start "entryRuleConstant"
    // InternalFirstOrderLogic.g:803:1: entryRuleConstant : ruleConstant EOF ;
    public final void entryRuleConstant() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:804:1: ( ruleConstant EOF )
            // InternalFirstOrderLogic.g:805:1: ruleConstant EOF
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
    // InternalFirstOrderLogic.g:812:1: ruleConstant : ( ( rule__Constant__Alternatives ) ) ;
    public final void ruleConstant() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:816:2: ( ( ( rule__Constant__Alternatives ) ) )
            // InternalFirstOrderLogic.g:817:2: ( ( rule__Constant__Alternatives ) )
            {
            // InternalFirstOrderLogic.g:817:2: ( ( rule__Constant__Alternatives ) )
            // InternalFirstOrderLogic.g:818:3: ( rule__Constant__Alternatives )
            {
             before(grammarAccess.getConstantAccess().getAlternatives()); 
            // InternalFirstOrderLogic.g:819:3: ( rule__Constant__Alternatives )
            // InternalFirstOrderLogic.g:819:4: rule__Constant__Alternatives
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
    // InternalFirstOrderLogic.g:827:1: rule__Predicate__Alternatives : ( ( ruleEquals ) | ( ruleInequality ) | ( ruleIsEmpty ) );
    public final void rule__Predicate__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:831:1: ( ( ruleEquals ) | ( ruleInequality ) | ( ruleIsEmpty ) )
            int alt1=3;
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
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // InternalFirstOrderLogic.g:832:2: ( ruleEquals )
                    {
                    // InternalFirstOrderLogic.g:832:2: ( ruleEquals )
                    // InternalFirstOrderLogic.g:833:3: ruleEquals
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
                    // InternalFirstOrderLogic.g:838:2: ( ruleInequality )
                    {
                    // InternalFirstOrderLogic.g:838:2: ( ruleInequality )
                    // InternalFirstOrderLogic.g:839:3: ruleInequality
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
                    // InternalFirstOrderLogic.g:844:2: ( ruleIsEmpty )
                    {
                    // InternalFirstOrderLogic.g:844:2: ( ruleIsEmpty )
                    // InternalFirstOrderLogic.g:845:3: ruleIsEmpty
                    {
                     before(grammarAccess.getPredicateAccess().getIsEmptyParserRuleCall_2()); 
                    pushFollow(FOLLOW_2);
                    ruleIsEmpty();

                    state._fsp--;

                     after(grammarAccess.getPredicateAccess().getIsEmptyParserRuleCall_2()); 

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
    // InternalFirstOrderLogic.g:854:1: rule__Inequality__Alternatives : ( ( ruleGreater ) | ( ruleGreaterEqual ) | ( ruleSmaller ) | ( ruleSmallerEqual ) );
    public final void rule__Inequality__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:858:1: ( ( ruleGreater ) | ( ruleGreaterEqual ) | ( ruleSmaller ) | ( ruleSmallerEqual ) )
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
                    // InternalFirstOrderLogic.g:859:2: ( ruleGreater )
                    {
                    // InternalFirstOrderLogic.g:859:2: ( ruleGreater )
                    // InternalFirstOrderLogic.g:860:3: ruleGreater
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
                    // InternalFirstOrderLogic.g:865:2: ( ruleGreaterEqual )
                    {
                    // InternalFirstOrderLogic.g:865:2: ( ruleGreaterEqual )
                    // InternalFirstOrderLogic.g:866:3: ruleGreaterEqual
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
                    // InternalFirstOrderLogic.g:871:2: ( ruleSmaller )
                    {
                    // InternalFirstOrderLogic.g:871:2: ( ruleSmaller )
                    // InternalFirstOrderLogic.g:872:3: ruleSmaller
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
                    // InternalFirstOrderLogic.g:877:2: ( ruleSmallerEqual )
                    {
                    // InternalFirstOrderLogic.g:877:2: ( ruleSmallerEqual )
                    // InternalFirstOrderLogic.g:878:3: ruleSmallerEqual
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
    // InternalFirstOrderLogic.g:887:1: rule__Quantifier__Alternatives : ( ( ruleForAll ) | ( ruleExists ) );
    public final void rule__Quantifier__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:891:1: ( ( ruleForAll ) | ( ruleExists ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==33) ) {
                alt3=1;
            }
            else if ( (LA3_0==35) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // InternalFirstOrderLogic.g:892:2: ( ruleForAll )
                    {
                    // InternalFirstOrderLogic.g:892:2: ( ruleForAll )
                    // InternalFirstOrderLogic.g:893:3: ruleForAll
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
                    // InternalFirstOrderLogic.g:898:2: ( ruleExists )
                    {
                    // InternalFirstOrderLogic.g:898:2: ( ruleExists )
                    // InternalFirstOrderLogic.g:899:3: ruleExists
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
    // InternalFirstOrderLogic.g:908:1: rule__BooleanExpression__Alternatives : ( ( ( rule__BooleanExpression__Group_0__0 ) ) | ( ruleUnaryFormula ) | ( ruleQuantifier ) | ( rulePredicate ) | ( ruleBoolConstant ) );
    public final void rule__BooleanExpression__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:912:1: ( ( ( rule__BooleanExpression__Group_0__0 ) ) | ( ruleUnaryFormula ) | ( ruleQuantifier ) | ( rulePredicate ) | ( ruleBoolConstant ) )
            int alt4=5;
            switch ( input.LA(1) ) {
            case 36:
                {
                alt4=1;
                }
                break;
            case 24:
                {
                alt4=2;
                }
                break;
            case 33:
            case 35:
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
                    // InternalFirstOrderLogic.g:913:2: ( ( rule__BooleanExpression__Group_0__0 ) )
                    {
                    // InternalFirstOrderLogic.g:913:2: ( ( rule__BooleanExpression__Group_0__0 ) )
                    // InternalFirstOrderLogic.g:914:3: ( rule__BooleanExpression__Group_0__0 )
                    {
                     before(grammarAccess.getBooleanExpressionAccess().getGroup_0()); 
                    // InternalFirstOrderLogic.g:915:3: ( rule__BooleanExpression__Group_0__0 )
                    // InternalFirstOrderLogic.g:915:4: rule__BooleanExpression__Group_0__0
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
                    // InternalFirstOrderLogic.g:919:2: ( ruleUnaryFormula )
                    {
                    // InternalFirstOrderLogic.g:919:2: ( ruleUnaryFormula )
                    // InternalFirstOrderLogic.g:920:3: ruleUnaryFormula
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
                    // InternalFirstOrderLogic.g:925:2: ( ruleQuantifier )
                    {
                    // InternalFirstOrderLogic.g:925:2: ( ruleQuantifier )
                    // InternalFirstOrderLogic.g:926:3: ruleQuantifier
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
                    // InternalFirstOrderLogic.g:931:2: ( rulePredicate )
                    {
                    // InternalFirstOrderLogic.g:931:2: ( rulePredicate )
                    // InternalFirstOrderLogic.g:932:3: rulePredicate
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
                    // InternalFirstOrderLogic.g:937:2: ( ruleBoolConstant )
                    {
                    // InternalFirstOrderLogic.g:937:2: ( ruleBoolConstant )
                    // InternalFirstOrderLogic.g:938:3: ruleBoolConstant
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
    // InternalFirstOrderLogic.g:947:1: rule__BoolConstant__ValueAlternatives_1_0 : ( ( 'true' ) | ( 'false' ) );
    public final void rule__BoolConstant__ValueAlternatives_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:951:1: ( ( 'true' ) | ( 'false' ) )
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
                    // InternalFirstOrderLogic.g:952:2: ( 'true' )
                    {
                    // InternalFirstOrderLogic.g:952:2: ( 'true' )
                    // InternalFirstOrderLogic.g:953:3: 'true'
                    {
                     before(grammarAccess.getBoolConstantAccess().getValueTrueKeyword_1_0_0()); 
                    match(input,11,FOLLOW_2); 
                     after(grammarAccess.getBoolConstantAccess().getValueTrueKeyword_1_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalFirstOrderLogic.g:958:2: ( 'false' )
                    {
                    // InternalFirstOrderLogic.g:958:2: ( 'false' )
                    // InternalFirstOrderLogic.g:959:3: 'false'
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
    // InternalFirstOrderLogic.g:968:1: rule__Term__Alternatives : ( ( ruleConstant ) | ( ruleVariableRef ) | ( ruleGetContainment ) | ( ruleGetContainer ) );
    public final void rule__Term__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:972:1: ( ( ruleConstant ) | ( ruleVariableRef ) | ( ruleGetContainment ) | ( ruleGetContainer ) )
            int alt6=4;
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
            case 40:
                {
                alt6=3;
                }
                break;
            case 39:
                {
                alt6=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // InternalFirstOrderLogic.g:973:2: ( ruleConstant )
                    {
                    // InternalFirstOrderLogic.g:973:2: ( ruleConstant )
                    // InternalFirstOrderLogic.g:974:3: ruleConstant
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
                    // InternalFirstOrderLogic.g:979:2: ( ruleVariableRef )
                    {
                    // InternalFirstOrderLogic.g:979:2: ( ruleVariableRef )
                    // InternalFirstOrderLogic.g:980:3: ruleVariableRef
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
                    // InternalFirstOrderLogic.g:985:2: ( ruleGetContainment )
                    {
                    // InternalFirstOrderLogic.g:985:2: ( ruleGetContainment )
                    // InternalFirstOrderLogic.g:986:3: ruleGetContainment
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
                    // InternalFirstOrderLogic.g:991:2: ( ruleGetContainer )
                    {
                    // InternalFirstOrderLogic.g:991:2: ( ruleGetContainer )
                    // InternalFirstOrderLogic.g:992:3: ruleGetContainer
                    {
                     before(grammarAccess.getTermAccess().getGetContainerParserRuleCall_3()); 
                    pushFollow(FOLLOW_2);
                    ruleGetContainer();

                    state._fsp--;

                     after(grammarAccess.getTermAccess().getGetContainerParserRuleCall_3()); 

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
    // InternalFirstOrderLogic.g:1001:1: rule__Constant__Alternatives : ( ( ( rule__Constant__Group_0__0 ) ) | ( ( rule__Constant__Group_1__0 ) ) | ( ruleBoolConstant ) );
    public final void rule__Constant__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1005:1: ( ( ( rule__Constant__Group_0__0 ) ) | ( ( rule__Constant__Group_1__0 ) ) | ( ruleBoolConstant ) )
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
                    // InternalFirstOrderLogic.g:1006:2: ( ( rule__Constant__Group_0__0 ) )
                    {
                    // InternalFirstOrderLogic.g:1006:2: ( ( rule__Constant__Group_0__0 ) )
                    // InternalFirstOrderLogic.g:1007:3: ( rule__Constant__Group_0__0 )
                    {
                     before(grammarAccess.getConstantAccess().getGroup_0()); 
                    // InternalFirstOrderLogic.g:1008:3: ( rule__Constant__Group_0__0 )
                    // InternalFirstOrderLogic.g:1008:4: rule__Constant__Group_0__0
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
                    // InternalFirstOrderLogic.g:1012:2: ( ( rule__Constant__Group_1__0 ) )
                    {
                    // InternalFirstOrderLogic.g:1012:2: ( ( rule__Constant__Group_1__0 ) )
                    // InternalFirstOrderLogic.g:1013:3: ( rule__Constant__Group_1__0 )
                    {
                     before(grammarAccess.getConstantAccess().getGroup_1()); 
                    // InternalFirstOrderLogic.g:1014:3: ( rule__Constant__Group_1__0 )
                    // InternalFirstOrderLogic.g:1014:4: rule__Constant__Group_1__0
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
                    // InternalFirstOrderLogic.g:1018:2: ( ruleBoolConstant )
                    {
                    // InternalFirstOrderLogic.g:1018:2: ( ruleBoolConstant )
                    // InternalFirstOrderLogic.g:1019:3: ruleBoolConstant
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
    // InternalFirstOrderLogic.g:1028:1: rule__ConstraintLibrary__Group__0 : rule__ConstraintLibrary__Group__0__Impl rule__ConstraintLibrary__Group__1 ;
    public final void rule__ConstraintLibrary__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1032:1: ( rule__ConstraintLibrary__Group__0__Impl rule__ConstraintLibrary__Group__1 )
            // InternalFirstOrderLogic.g:1033:2: rule__ConstraintLibrary__Group__0__Impl rule__ConstraintLibrary__Group__1
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
    // InternalFirstOrderLogic.g:1040:1: rule__ConstraintLibrary__Group__0__Impl : ( 'domain' ) ;
    public final void rule__ConstraintLibrary__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1044:1: ( ( 'domain' ) )
            // InternalFirstOrderLogic.g:1045:1: ( 'domain' )
            {
            // InternalFirstOrderLogic.g:1045:1: ( 'domain' )
            // InternalFirstOrderLogic.g:1046:2: 'domain'
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
    // InternalFirstOrderLogic.g:1055:1: rule__ConstraintLibrary__Group__1 : rule__ConstraintLibrary__Group__1__Impl rule__ConstraintLibrary__Group__2 ;
    public final void rule__ConstraintLibrary__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1059:1: ( rule__ConstraintLibrary__Group__1__Impl rule__ConstraintLibrary__Group__2 )
            // InternalFirstOrderLogic.g:1060:2: rule__ConstraintLibrary__Group__1__Impl rule__ConstraintLibrary__Group__2
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
    // InternalFirstOrderLogic.g:1067:1: rule__ConstraintLibrary__Group__1__Impl : ( ( rule__ConstraintLibrary__DomainAssignment_1 ) ) ;
    public final void rule__ConstraintLibrary__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1071:1: ( ( ( rule__ConstraintLibrary__DomainAssignment_1 ) ) )
            // InternalFirstOrderLogic.g:1072:1: ( ( rule__ConstraintLibrary__DomainAssignment_1 ) )
            {
            // InternalFirstOrderLogic.g:1072:1: ( ( rule__ConstraintLibrary__DomainAssignment_1 ) )
            // InternalFirstOrderLogic.g:1073:2: ( rule__ConstraintLibrary__DomainAssignment_1 )
            {
             before(grammarAccess.getConstraintLibraryAccess().getDomainAssignment_1()); 
            // InternalFirstOrderLogic.g:1074:2: ( rule__ConstraintLibrary__DomainAssignment_1 )
            // InternalFirstOrderLogic.g:1074:3: rule__ConstraintLibrary__DomainAssignment_1
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
    // InternalFirstOrderLogic.g:1082:1: rule__ConstraintLibrary__Group__2 : rule__ConstraintLibrary__Group__2__Impl rule__ConstraintLibrary__Group__3 ;
    public final void rule__ConstraintLibrary__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1086:1: ( rule__ConstraintLibrary__Group__2__Impl rule__ConstraintLibrary__Group__3 )
            // InternalFirstOrderLogic.g:1087:2: rule__ConstraintLibrary__Group__2__Impl rule__ConstraintLibrary__Group__3
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
    // InternalFirstOrderLogic.g:1094:1: rule__ConstraintLibrary__Group__2__Impl : ( 'import' ) ;
    public final void rule__ConstraintLibrary__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1098:1: ( ( 'import' ) )
            // InternalFirstOrderLogic.g:1099:1: ( 'import' )
            {
            // InternalFirstOrderLogic.g:1099:1: ( 'import' )
            // InternalFirstOrderLogic.g:1100:2: 'import'
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
    // InternalFirstOrderLogic.g:1109:1: rule__ConstraintLibrary__Group__3 : rule__ConstraintLibrary__Group__3__Impl rule__ConstraintLibrary__Group__4 ;
    public final void rule__ConstraintLibrary__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1113:1: ( rule__ConstraintLibrary__Group__3__Impl rule__ConstraintLibrary__Group__4 )
            // InternalFirstOrderLogic.g:1114:2: rule__ConstraintLibrary__Group__3__Impl rule__ConstraintLibrary__Group__4
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
    // InternalFirstOrderLogic.g:1121:1: rule__ConstraintLibrary__Group__3__Impl : ( ( rule__ConstraintLibrary__PackageImportAssignment_3 ) ) ;
    public final void rule__ConstraintLibrary__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1125:1: ( ( ( rule__ConstraintLibrary__PackageImportAssignment_3 ) ) )
            // InternalFirstOrderLogic.g:1126:1: ( ( rule__ConstraintLibrary__PackageImportAssignment_3 ) )
            {
            // InternalFirstOrderLogic.g:1126:1: ( ( rule__ConstraintLibrary__PackageImportAssignment_3 ) )
            // InternalFirstOrderLogic.g:1127:2: ( rule__ConstraintLibrary__PackageImportAssignment_3 )
            {
             before(grammarAccess.getConstraintLibraryAccess().getPackageImportAssignment_3()); 
            // InternalFirstOrderLogic.g:1128:2: ( rule__ConstraintLibrary__PackageImportAssignment_3 )
            // InternalFirstOrderLogic.g:1128:3: rule__ConstraintLibrary__PackageImportAssignment_3
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
    // InternalFirstOrderLogic.g:1136:1: rule__ConstraintLibrary__Group__4 : rule__ConstraintLibrary__Group__4__Impl ;
    public final void rule__ConstraintLibrary__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1140:1: ( rule__ConstraintLibrary__Group__4__Impl )
            // InternalFirstOrderLogic.g:1141:2: rule__ConstraintLibrary__Group__4__Impl
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
    // InternalFirstOrderLogic.g:1147:1: rule__ConstraintLibrary__Group__4__Impl : ( ( rule__ConstraintLibrary__ConstraintsAssignment_4 )* ) ;
    public final void rule__ConstraintLibrary__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1151:1: ( ( ( rule__ConstraintLibrary__ConstraintsAssignment_4 )* ) )
            // InternalFirstOrderLogic.g:1152:1: ( ( rule__ConstraintLibrary__ConstraintsAssignment_4 )* )
            {
            // InternalFirstOrderLogic.g:1152:1: ( ( rule__ConstraintLibrary__ConstraintsAssignment_4 )* )
            // InternalFirstOrderLogic.g:1153:2: ( rule__ConstraintLibrary__ConstraintsAssignment_4 )*
            {
             before(grammarAccess.getConstraintLibraryAccess().getConstraintsAssignment_4()); 
            // InternalFirstOrderLogic.g:1154:2: ( rule__ConstraintLibrary__ConstraintsAssignment_4 )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==15) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalFirstOrderLogic.g:1154:3: rule__ConstraintLibrary__ConstraintsAssignment_4
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
    // InternalFirstOrderLogic.g:1163:1: rule__Constraint__Group__0 : rule__Constraint__Group__0__Impl rule__Constraint__Group__1 ;
    public final void rule__Constraint__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1167:1: ( rule__Constraint__Group__0__Impl rule__Constraint__Group__1 )
            // InternalFirstOrderLogic.g:1168:2: rule__Constraint__Group__0__Impl rule__Constraint__Group__1
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
    // InternalFirstOrderLogic.g:1175:1: rule__Constraint__Group__0__Impl : ( 'constraint' ) ;
    public final void rule__Constraint__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1179:1: ( ( 'constraint' ) )
            // InternalFirstOrderLogic.g:1180:1: ( 'constraint' )
            {
            // InternalFirstOrderLogic.g:1180:1: ( 'constraint' )
            // InternalFirstOrderLogic.g:1181:2: 'constraint'
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
    // InternalFirstOrderLogic.g:1190:1: rule__Constraint__Group__1 : rule__Constraint__Group__1__Impl rule__Constraint__Group__2 ;
    public final void rule__Constraint__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1194:1: ( rule__Constraint__Group__1__Impl rule__Constraint__Group__2 )
            // InternalFirstOrderLogic.g:1195:2: rule__Constraint__Group__1__Impl rule__Constraint__Group__2
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
    // InternalFirstOrderLogic.g:1202:1: rule__Constraint__Group__1__Impl : ( ( rule__Constraint__NameAssignment_1 ) ) ;
    public final void rule__Constraint__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1206:1: ( ( ( rule__Constraint__NameAssignment_1 ) ) )
            // InternalFirstOrderLogic.g:1207:1: ( ( rule__Constraint__NameAssignment_1 ) )
            {
            // InternalFirstOrderLogic.g:1207:1: ( ( rule__Constraint__NameAssignment_1 ) )
            // InternalFirstOrderLogic.g:1208:2: ( rule__Constraint__NameAssignment_1 )
            {
             before(grammarAccess.getConstraintAccess().getNameAssignment_1()); 
            // InternalFirstOrderLogic.g:1209:2: ( rule__Constraint__NameAssignment_1 )
            // InternalFirstOrderLogic.g:1209:3: rule__Constraint__NameAssignment_1
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
    // InternalFirstOrderLogic.g:1217:1: rule__Constraint__Group__2 : rule__Constraint__Group__2__Impl rule__Constraint__Group__3 ;
    public final void rule__Constraint__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1221:1: ( rule__Constraint__Group__2__Impl rule__Constraint__Group__3 )
            // InternalFirstOrderLogic.g:1222:2: rule__Constraint__Group__2__Impl rule__Constraint__Group__3
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
    // InternalFirstOrderLogic.g:1229:1: rule__Constraint__Group__2__Impl : ( 'message' ) ;
    public final void rule__Constraint__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1233:1: ( ( 'message' ) )
            // InternalFirstOrderLogic.g:1234:1: ( 'message' )
            {
            // InternalFirstOrderLogic.g:1234:1: ( 'message' )
            // InternalFirstOrderLogic.g:1235:2: 'message'
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
    // InternalFirstOrderLogic.g:1244:1: rule__Constraint__Group__3 : rule__Constraint__Group__3__Impl rule__Constraint__Group__4 ;
    public final void rule__Constraint__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1248:1: ( rule__Constraint__Group__3__Impl rule__Constraint__Group__4 )
            // InternalFirstOrderLogic.g:1249:2: rule__Constraint__Group__3__Impl rule__Constraint__Group__4
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
    // InternalFirstOrderLogic.g:1256:1: rule__Constraint__Group__3__Impl : ( ( rule__Constraint__MessageAssignment_3 ) ) ;
    public final void rule__Constraint__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1260:1: ( ( ( rule__Constraint__MessageAssignment_3 ) ) )
            // InternalFirstOrderLogic.g:1261:1: ( ( rule__Constraint__MessageAssignment_3 ) )
            {
            // InternalFirstOrderLogic.g:1261:1: ( ( rule__Constraint__MessageAssignment_3 ) )
            // InternalFirstOrderLogic.g:1262:2: ( rule__Constraint__MessageAssignment_3 )
            {
             before(grammarAccess.getConstraintAccess().getMessageAssignment_3()); 
            // InternalFirstOrderLogic.g:1263:2: ( rule__Constraint__MessageAssignment_3 )
            // InternalFirstOrderLogic.g:1263:3: rule__Constraint__MessageAssignment_3
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
    // InternalFirstOrderLogic.g:1271:1: rule__Constraint__Group__4 : rule__Constraint__Group__4__Impl rule__Constraint__Group__5 ;
    public final void rule__Constraint__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1275:1: ( rule__Constraint__Group__4__Impl rule__Constraint__Group__5 )
            // InternalFirstOrderLogic.g:1276:2: rule__Constraint__Group__4__Impl rule__Constraint__Group__5
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
    // InternalFirstOrderLogic.g:1283:1: rule__Constraint__Group__4__Impl : ( 'context' ) ;
    public final void rule__Constraint__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1287:1: ( ( 'context' ) )
            // InternalFirstOrderLogic.g:1288:1: ( 'context' )
            {
            // InternalFirstOrderLogic.g:1288:1: ( 'context' )
            // InternalFirstOrderLogic.g:1289:2: 'context'
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
    // InternalFirstOrderLogic.g:1298:1: rule__Constraint__Group__5 : rule__Constraint__Group__5__Impl rule__Constraint__Group__6 ;
    public final void rule__Constraint__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1302:1: ( rule__Constraint__Group__5__Impl rule__Constraint__Group__6 )
            // InternalFirstOrderLogic.g:1303:2: rule__Constraint__Group__5__Impl rule__Constraint__Group__6
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
    // InternalFirstOrderLogic.g:1310:1: rule__Constraint__Group__5__Impl : ( ( rule__Constraint__VariableAssignment_5 ) ) ;
    public final void rule__Constraint__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1314:1: ( ( ( rule__Constraint__VariableAssignment_5 ) ) )
            // InternalFirstOrderLogic.g:1315:1: ( ( rule__Constraint__VariableAssignment_5 ) )
            {
            // InternalFirstOrderLogic.g:1315:1: ( ( rule__Constraint__VariableAssignment_5 ) )
            // InternalFirstOrderLogic.g:1316:2: ( rule__Constraint__VariableAssignment_5 )
            {
             before(grammarAccess.getConstraintAccess().getVariableAssignment_5()); 
            // InternalFirstOrderLogic.g:1317:2: ( rule__Constraint__VariableAssignment_5 )
            // InternalFirstOrderLogic.g:1317:3: rule__Constraint__VariableAssignment_5
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
    // InternalFirstOrderLogic.g:1325:1: rule__Constraint__Group__6 : rule__Constraint__Group__6__Impl rule__Constraint__Group__7 ;
    public final void rule__Constraint__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1329:1: ( rule__Constraint__Group__6__Impl rule__Constraint__Group__7 )
            // InternalFirstOrderLogic.g:1330:2: rule__Constraint__Group__6__Impl rule__Constraint__Group__7
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
    // InternalFirstOrderLogic.g:1337:1: rule__Constraint__Group__6__Impl : ( ':' ) ;
    public final void rule__Constraint__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1341:1: ( ( ':' ) )
            // InternalFirstOrderLogic.g:1342:1: ( ':' )
            {
            // InternalFirstOrderLogic.g:1342:1: ( ':' )
            // InternalFirstOrderLogic.g:1343:2: ':'
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
    // InternalFirstOrderLogic.g:1352:1: rule__Constraint__Group__7 : rule__Constraint__Group__7__Impl ;
    public final void rule__Constraint__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1356:1: ( rule__Constraint__Group__7__Impl )
            // InternalFirstOrderLogic.g:1357:2: rule__Constraint__Group__7__Impl
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
    // InternalFirstOrderLogic.g:1363:1: rule__Constraint__Group__7__Impl : ( ( rule__Constraint__FormulaAssignment_7 ) ) ;
    public final void rule__Constraint__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1367:1: ( ( ( rule__Constraint__FormulaAssignment_7 ) ) )
            // InternalFirstOrderLogic.g:1368:1: ( ( rule__Constraint__FormulaAssignment_7 ) )
            {
            // InternalFirstOrderLogic.g:1368:1: ( ( rule__Constraint__FormulaAssignment_7 ) )
            // InternalFirstOrderLogic.g:1369:2: ( rule__Constraint__FormulaAssignment_7 )
            {
             before(grammarAccess.getConstraintAccess().getFormulaAssignment_7()); 
            // InternalFirstOrderLogic.g:1370:2: ( rule__Constraint__FormulaAssignment_7 )
            // InternalFirstOrderLogic.g:1370:3: rule__Constraint__FormulaAssignment_7
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
    // InternalFirstOrderLogic.g:1379:1: rule__Variable__Group__0 : rule__Variable__Group__0__Impl rule__Variable__Group__1 ;
    public final void rule__Variable__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1383:1: ( rule__Variable__Group__0__Impl rule__Variable__Group__1 )
            // InternalFirstOrderLogic.g:1384:2: rule__Variable__Group__0__Impl rule__Variable__Group__1
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
    // InternalFirstOrderLogic.g:1391:1: rule__Variable__Group__0__Impl : ( ( rule__Variable__TypeAssignment_0 ) ) ;
    public final void rule__Variable__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1395:1: ( ( ( rule__Variable__TypeAssignment_0 ) ) )
            // InternalFirstOrderLogic.g:1396:1: ( ( rule__Variable__TypeAssignment_0 ) )
            {
            // InternalFirstOrderLogic.g:1396:1: ( ( rule__Variable__TypeAssignment_0 ) )
            // InternalFirstOrderLogic.g:1397:2: ( rule__Variable__TypeAssignment_0 )
            {
             before(grammarAccess.getVariableAccess().getTypeAssignment_0()); 
            // InternalFirstOrderLogic.g:1398:2: ( rule__Variable__TypeAssignment_0 )
            // InternalFirstOrderLogic.g:1398:3: rule__Variable__TypeAssignment_0
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
    // InternalFirstOrderLogic.g:1406:1: rule__Variable__Group__1 : rule__Variable__Group__1__Impl ;
    public final void rule__Variable__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1410:1: ( rule__Variable__Group__1__Impl )
            // InternalFirstOrderLogic.g:1411:2: rule__Variable__Group__1__Impl
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
    // InternalFirstOrderLogic.g:1417:1: rule__Variable__Group__1__Impl : ( ( rule__Variable__NameAssignment_1 ) ) ;
    public final void rule__Variable__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1421:1: ( ( ( rule__Variable__NameAssignment_1 ) ) )
            // InternalFirstOrderLogic.g:1422:1: ( ( rule__Variable__NameAssignment_1 ) )
            {
            // InternalFirstOrderLogic.g:1422:1: ( ( rule__Variable__NameAssignment_1 ) )
            // InternalFirstOrderLogic.g:1423:2: ( rule__Variable__NameAssignment_1 )
            {
             before(grammarAccess.getVariableAccess().getNameAssignment_1()); 
            // InternalFirstOrderLogic.g:1424:2: ( rule__Variable__NameAssignment_1 )
            // InternalFirstOrderLogic.g:1424:3: rule__Variable__NameAssignment_1
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
    // InternalFirstOrderLogic.g:1433:1: rule__Iff__Group__0 : rule__Iff__Group__0__Impl rule__Iff__Group__1 ;
    public final void rule__Iff__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1437:1: ( rule__Iff__Group__0__Impl rule__Iff__Group__1 )
            // InternalFirstOrderLogic.g:1438:2: rule__Iff__Group__0__Impl rule__Iff__Group__1
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
    // InternalFirstOrderLogic.g:1445:1: rule__Iff__Group__0__Impl : ( ruleIf ) ;
    public final void rule__Iff__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1449:1: ( ( ruleIf ) )
            // InternalFirstOrderLogic.g:1450:1: ( ruleIf )
            {
            // InternalFirstOrderLogic.g:1450:1: ( ruleIf )
            // InternalFirstOrderLogic.g:1451:2: ruleIf
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
    // InternalFirstOrderLogic.g:1460:1: rule__Iff__Group__1 : rule__Iff__Group__1__Impl ;
    public final void rule__Iff__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1464:1: ( rule__Iff__Group__1__Impl )
            // InternalFirstOrderLogic.g:1465:2: rule__Iff__Group__1__Impl
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
    // InternalFirstOrderLogic.g:1471:1: rule__Iff__Group__1__Impl : ( ( rule__Iff__Group_1__0 )* ) ;
    public final void rule__Iff__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1475:1: ( ( ( rule__Iff__Group_1__0 )* ) )
            // InternalFirstOrderLogic.g:1476:1: ( ( rule__Iff__Group_1__0 )* )
            {
            // InternalFirstOrderLogic.g:1476:1: ( ( rule__Iff__Group_1__0 )* )
            // InternalFirstOrderLogic.g:1477:2: ( rule__Iff__Group_1__0 )*
            {
             before(grammarAccess.getIffAccess().getGroup_1()); 
            // InternalFirstOrderLogic.g:1478:2: ( rule__Iff__Group_1__0 )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==19) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalFirstOrderLogic.g:1478:3: rule__Iff__Group_1__0
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
    // InternalFirstOrderLogic.g:1487:1: rule__Iff__Group_1__0 : rule__Iff__Group_1__0__Impl rule__Iff__Group_1__1 ;
    public final void rule__Iff__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1491:1: ( rule__Iff__Group_1__0__Impl rule__Iff__Group_1__1 )
            // InternalFirstOrderLogic.g:1492:2: rule__Iff__Group_1__0__Impl rule__Iff__Group_1__1
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
    // InternalFirstOrderLogic.g:1499:1: rule__Iff__Group_1__0__Impl : ( () ) ;
    public final void rule__Iff__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1503:1: ( ( () ) )
            // InternalFirstOrderLogic.g:1504:1: ( () )
            {
            // InternalFirstOrderLogic.g:1504:1: ( () )
            // InternalFirstOrderLogic.g:1505:2: ()
            {
             before(grammarAccess.getIffAccess().getIffLeftAction_1_0()); 
            // InternalFirstOrderLogic.g:1506:2: ()
            // InternalFirstOrderLogic.g:1506:3: 
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
    // InternalFirstOrderLogic.g:1514:1: rule__Iff__Group_1__1 : rule__Iff__Group_1__1__Impl rule__Iff__Group_1__2 ;
    public final void rule__Iff__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1518:1: ( rule__Iff__Group_1__1__Impl rule__Iff__Group_1__2 )
            // InternalFirstOrderLogic.g:1519:2: rule__Iff__Group_1__1__Impl rule__Iff__Group_1__2
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
    // InternalFirstOrderLogic.g:1526:1: rule__Iff__Group_1__1__Impl : ( '=' ) ;
    public final void rule__Iff__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1530:1: ( ( '=' ) )
            // InternalFirstOrderLogic.g:1531:1: ( '=' )
            {
            // InternalFirstOrderLogic.g:1531:1: ( '=' )
            // InternalFirstOrderLogic.g:1532:2: '='
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
    // InternalFirstOrderLogic.g:1541:1: rule__Iff__Group_1__2 : rule__Iff__Group_1__2__Impl ;
    public final void rule__Iff__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1545:1: ( rule__Iff__Group_1__2__Impl )
            // InternalFirstOrderLogic.g:1546:2: rule__Iff__Group_1__2__Impl
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
    // InternalFirstOrderLogic.g:1552:1: rule__Iff__Group_1__2__Impl : ( ( rule__Iff__RightAssignment_1_2 ) ) ;
    public final void rule__Iff__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1556:1: ( ( ( rule__Iff__RightAssignment_1_2 ) ) )
            // InternalFirstOrderLogic.g:1557:1: ( ( rule__Iff__RightAssignment_1_2 ) )
            {
            // InternalFirstOrderLogic.g:1557:1: ( ( rule__Iff__RightAssignment_1_2 ) )
            // InternalFirstOrderLogic.g:1558:2: ( rule__Iff__RightAssignment_1_2 )
            {
             before(grammarAccess.getIffAccess().getRightAssignment_1_2()); 
            // InternalFirstOrderLogic.g:1559:2: ( rule__Iff__RightAssignment_1_2 )
            // InternalFirstOrderLogic.g:1559:3: rule__Iff__RightAssignment_1_2
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
    // InternalFirstOrderLogic.g:1568:1: rule__If__Group__0 : rule__If__Group__0__Impl rule__If__Group__1 ;
    public final void rule__If__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1572:1: ( rule__If__Group__0__Impl rule__If__Group__1 )
            // InternalFirstOrderLogic.g:1573:2: rule__If__Group__0__Impl rule__If__Group__1
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
    // InternalFirstOrderLogic.g:1580:1: rule__If__Group__0__Impl : ( ruleXor ) ;
    public final void rule__If__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1584:1: ( ( ruleXor ) )
            // InternalFirstOrderLogic.g:1585:1: ( ruleXor )
            {
            // InternalFirstOrderLogic.g:1585:1: ( ruleXor )
            // InternalFirstOrderLogic.g:1586:2: ruleXor
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
    // InternalFirstOrderLogic.g:1595:1: rule__If__Group__1 : rule__If__Group__1__Impl ;
    public final void rule__If__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1599:1: ( rule__If__Group__1__Impl )
            // InternalFirstOrderLogic.g:1600:2: rule__If__Group__1__Impl
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
    // InternalFirstOrderLogic.g:1606:1: rule__If__Group__1__Impl : ( ( rule__If__Group_1__0 )* ) ;
    public final void rule__If__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1610:1: ( ( ( rule__If__Group_1__0 )* ) )
            // InternalFirstOrderLogic.g:1611:1: ( ( rule__If__Group_1__0 )* )
            {
            // InternalFirstOrderLogic.g:1611:1: ( ( rule__If__Group_1__0 )* )
            // InternalFirstOrderLogic.g:1612:2: ( rule__If__Group_1__0 )*
            {
             before(grammarAccess.getIfAccess().getGroup_1()); 
            // InternalFirstOrderLogic.g:1613:2: ( rule__If__Group_1__0 )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==20) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalFirstOrderLogic.g:1613:3: rule__If__Group_1__0
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
    // InternalFirstOrderLogic.g:1622:1: rule__If__Group_1__0 : rule__If__Group_1__0__Impl rule__If__Group_1__1 ;
    public final void rule__If__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1626:1: ( rule__If__Group_1__0__Impl rule__If__Group_1__1 )
            // InternalFirstOrderLogic.g:1627:2: rule__If__Group_1__0__Impl rule__If__Group_1__1
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
    // InternalFirstOrderLogic.g:1634:1: rule__If__Group_1__0__Impl : ( () ) ;
    public final void rule__If__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1638:1: ( ( () ) )
            // InternalFirstOrderLogic.g:1639:1: ( () )
            {
            // InternalFirstOrderLogic.g:1639:1: ( () )
            // InternalFirstOrderLogic.g:1640:2: ()
            {
             before(grammarAccess.getIfAccess().getIfLeftAction_1_0()); 
            // InternalFirstOrderLogic.g:1641:2: ()
            // InternalFirstOrderLogic.g:1641:3: 
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
    // InternalFirstOrderLogic.g:1649:1: rule__If__Group_1__1 : rule__If__Group_1__1__Impl rule__If__Group_1__2 ;
    public final void rule__If__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1653:1: ( rule__If__Group_1__1__Impl rule__If__Group_1__2 )
            // InternalFirstOrderLogic.g:1654:2: rule__If__Group_1__1__Impl rule__If__Group_1__2
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
    // InternalFirstOrderLogic.g:1661:1: rule__If__Group_1__1__Impl : ( 'implies' ) ;
    public final void rule__If__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1665:1: ( ( 'implies' ) )
            // InternalFirstOrderLogic.g:1666:1: ( 'implies' )
            {
            // InternalFirstOrderLogic.g:1666:1: ( 'implies' )
            // InternalFirstOrderLogic.g:1667:2: 'implies'
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
    // InternalFirstOrderLogic.g:1676:1: rule__If__Group_1__2 : rule__If__Group_1__2__Impl ;
    public final void rule__If__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1680:1: ( rule__If__Group_1__2__Impl )
            // InternalFirstOrderLogic.g:1681:2: rule__If__Group_1__2__Impl
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
    // InternalFirstOrderLogic.g:1687:1: rule__If__Group_1__2__Impl : ( ( rule__If__RightAssignment_1_2 ) ) ;
    public final void rule__If__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1691:1: ( ( ( rule__If__RightAssignment_1_2 ) ) )
            // InternalFirstOrderLogic.g:1692:1: ( ( rule__If__RightAssignment_1_2 ) )
            {
            // InternalFirstOrderLogic.g:1692:1: ( ( rule__If__RightAssignment_1_2 ) )
            // InternalFirstOrderLogic.g:1693:2: ( rule__If__RightAssignment_1_2 )
            {
             before(grammarAccess.getIfAccess().getRightAssignment_1_2()); 
            // InternalFirstOrderLogic.g:1694:2: ( rule__If__RightAssignment_1_2 )
            // InternalFirstOrderLogic.g:1694:3: rule__If__RightAssignment_1_2
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
    // InternalFirstOrderLogic.g:1703:1: rule__Xor__Group__0 : rule__Xor__Group__0__Impl rule__Xor__Group__1 ;
    public final void rule__Xor__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1707:1: ( rule__Xor__Group__0__Impl rule__Xor__Group__1 )
            // InternalFirstOrderLogic.g:1708:2: rule__Xor__Group__0__Impl rule__Xor__Group__1
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
    // InternalFirstOrderLogic.g:1715:1: rule__Xor__Group__0__Impl : ( ruleOr ) ;
    public final void rule__Xor__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1719:1: ( ( ruleOr ) )
            // InternalFirstOrderLogic.g:1720:1: ( ruleOr )
            {
            // InternalFirstOrderLogic.g:1720:1: ( ruleOr )
            // InternalFirstOrderLogic.g:1721:2: ruleOr
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
    // InternalFirstOrderLogic.g:1730:1: rule__Xor__Group__1 : rule__Xor__Group__1__Impl ;
    public final void rule__Xor__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1734:1: ( rule__Xor__Group__1__Impl )
            // InternalFirstOrderLogic.g:1735:2: rule__Xor__Group__1__Impl
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
    // InternalFirstOrderLogic.g:1741:1: rule__Xor__Group__1__Impl : ( ( rule__Xor__Group_1__0 )* ) ;
    public final void rule__Xor__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1745:1: ( ( ( rule__Xor__Group_1__0 )* ) )
            // InternalFirstOrderLogic.g:1746:1: ( ( rule__Xor__Group_1__0 )* )
            {
            // InternalFirstOrderLogic.g:1746:1: ( ( rule__Xor__Group_1__0 )* )
            // InternalFirstOrderLogic.g:1747:2: ( rule__Xor__Group_1__0 )*
            {
             before(grammarAccess.getXorAccess().getGroup_1()); 
            // InternalFirstOrderLogic.g:1748:2: ( rule__Xor__Group_1__0 )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==21) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalFirstOrderLogic.g:1748:3: rule__Xor__Group_1__0
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
    // InternalFirstOrderLogic.g:1757:1: rule__Xor__Group_1__0 : rule__Xor__Group_1__0__Impl rule__Xor__Group_1__1 ;
    public final void rule__Xor__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1761:1: ( rule__Xor__Group_1__0__Impl rule__Xor__Group_1__1 )
            // InternalFirstOrderLogic.g:1762:2: rule__Xor__Group_1__0__Impl rule__Xor__Group_1__1
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
    // InternalFirstOrderLogic.g:1769:1: rule__Xor__Group_1__0__Impl : ( () ) ;
    public final void rule__Xor__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1773:1: ( ( () ) )
            // InternalFirstOrderLogic.g:1774:1: ( () )
            {
            // InternalFirstOrderLogic.g:1774:1: ( () )
            // InternalFirstOrderLogic.g:1775:2: ()
            {
             before(grammarAccess.getXorAccess().getXorLeftAction_1_0()); 
            // InternalFirstOrderLogic.g:1776:2: ()
            // InternalFirstOrderLogic.g:1776:3: 
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
    // InternalFirstOrderLogic.g:1784:1: rule__Xor__Group_1__1 : rule__Xor__Group_1__1__Impl rule__Xor__Group_1__2 ;
    public final void rule__Xor__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1788:1: ( rule__Xor__Group_1__1__Impl rule__Xor__Group_1__2 )
            // InternalFirstOrderLogic.g:1789:2: rule__Xor__Group_1__1__Impl rule__Xor__Group_1__2
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
    // InternalFirstOrderLogic.g:1796:1: rule__Xor__Group_1__1__Impl : ( 'xor' ) ;
    public final void rule__Xor__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1800:1: ( ( 'xor' ) )
            // InternalFirstOrderLogic.g:1801:1: ( 'xor' )
            {
            // InternalFirstOrderLogic.g:1801:1: ( 'xor' )
            // InternalFirstOrderLogic.g:1802:2: 'xor'
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
    // InternalFirstOrderLogic.g:1811:1: rule__Xor__Group_1__2 : rule__Xor__Group_1__2__Impl ;
    public final void rule__Xor__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1815:1: ( rule__Xor__Group_1__2__Impl )
            // InternalFirstOrderLogic.g:1816:2: rule__Xor__Group_1__2__Impl
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
    // InternalFirstOrderLogic.g:1822:1: rule__Xor__Group_1__2__Impl : ( ( rule__Xor__RightAssignment_1_2 ) ) ;
    public final void rule__Xor__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1826:1: ( ( ( rule__Xor__RightAssignment_1_2 ) ) )
            // InternalFirstOrderLogic.g:1827:1: ( ( rule__Xor__RightAssignment_1_2 ) )
            {
            // InternalFirstOrderLogic.g:1827:1: ( ( rule__Xor__RightAssignment_1_2 ) )
            // InternalFirstOrderLogic.g:1828:2: ( rule__Xor__RightAssignment_1_2 )
            {
             before(grammarAccess.getXorAccess().getRightAssignment_1_2()); 
            // InternalFirstOrderLogic.g:1829:2: ( rule__Xor__RightAssignment_1_2 )
            // InternalFirstOrderLogic.g:1829:3: rule__Xor__RightAssignment_1_2
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
    // InternalFirstOrderLogic.g:1838:1: rule__Or__Group__0 : rule__Or__Group__0__Impl rule__Or__Group__1 ;
    public final void rule__Or__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1842:1: ( rule__Or__Group__0__Impl rule__Or__Group__1 )
            // InternalFirstOrderLogic.g:1843:2: rule__Or__Group__0__Impl rule__Or__Group__1
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
    // InternalFirstOrderLogic.g:1850:1: rule__Or__Group__0__Impl : ( ruleAnd ) ;
    public final void rule__Or__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1854:1: ( ( ruleAnd ) )
            // InternalFirstOrderLogic.g:1855:1: ( ruleAnd )
            {
            // InternalFirstOrderLogic.g:1855:1: ( ruleAnd )
            // InternalFirstOrderLogic.g:1856:2: ruleAnd
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
    // InternalFirstOrderLogic.g:1865:1: rule__Or__Group__1 : rule__Or__Group__1__Impl ;
    public final void rule__Or__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1869:1: ( rule__Or__Group__1__Impl )
            // InternalFirstOrderLogic.g:1870:2: rule__Or__Group__1__Impl
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
    // InternalFirstOrderLogic.g:1876:1: rule__Or__Group__1__Impl : ( ( rule__Or__Group_1__0 )* ) ;
    public final void rule__Or__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1880:1: ( ( ( rule__Or__Group_1__0 )* ) )
            // InternalFirstOrderLogic.g:1881:1: ( ( rule__Or__Group_1__0 )* )
            {
            // InternalFirstOrderLogic.g:1881:1: ( ( rule__Or__Group_1__0 )* )
            // InternalFirstOrderLogic.g:1882:2: ( rule__Or__Group_1__0 )*
            {
             before(grammarAccess.getOrAccess().getGroup_1()); 
            // InternalFirstOrderLogic.g:1883:2: ( rule__Or__Group_1__0 )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==22) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalFirstOrderLogic.g:1883:3: rule__Or__Group_1__0
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
    // InternalFirstOrderLogic.g:1892:1: rule__Or__Group_1__0 : rule__Or__Group_1__0__Impl rule__Or__Group_1__1 ;
    public final void rule__Or__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1896:1: ( rule__Or__Group_1__0__Impl rule__Or__Group_1__1 )
            // InternalFirstOrderLogic.g:1897:2: rule__Or__Group_1__0__Impl rule__Or__Group_1__1
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
    // InternalFirstOrderLogic.g:1904:1: rule__Or__Group_1__0__Impl : ( () ) ;
    public final void rule__Or__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1908:1: ( ( () ) )
            // InternalFirstOrderLogic.g:1909:1: ( () )
            {
            // InternalFirstOrderLogic.g:1909:1: ( () )
            // InternalFirstOrderLogic.g:1910:2: ()
            {
             before(grammarAccess.getOrAccess().getOrLeftAction_1_0()); 
            // InternalFirstOrderLogic.g:1911:2: ()
            // InternalFirstOrderLogic.g:1911:3: 
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
    // InternalFirstOrderLogic.g:1919:1: rule__Or__Group_1__1 : rule__Or__Group_1__1__Impl rule__Or__Group_1__2 ;
    public final void rule__Or__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1923:1: ( rule__Or__Group_1__1__Impl rule__Or__Group_1__2 )
            // InternalFirstOrderLogic.g:1924:2: rule__Or__Group_1__1__Impl rule__Or__Group_1__2
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
    // InternalFirstOrderLogic.g:1931:1: rule__Or__Group_1__1__Impl : ( 'or' ) ;
    public final void rule__Or__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1935:1: ( ( 'or' ) )
            // InternalFirstOrderLogic.g:1936:1: ( 'or' )
            {
            // InternalFirstOrderLogic.g:1936:1: ( 'or' )
            // InternalFirstOrderLogic.g:1937:2: 'or'
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
    // InternalFirstOrderLogic.g:1946:1: rule__Or__Group_1__2 : rule__Or__Group_1__2__Impl ;
    public final void rule__Or__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1950:1: ( rule__Or__Group_1__2__Impl )
            // InternalFirstOrderLogic.g:1951:2: rule__Or__Group_1__2__Impl
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
    // InternalFirstOrderLogic.g:1957:1: rule__Or__Group_1__2__Impl : ( ( rule__Or__RightAssignment_1_2 ) ) ;
    public final void rule__Or__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1961:1: ( ( ( rule__Or__RightAssignment_1_2 ) ) )
            // InternalFirstOrderLogic.g:1962:1: ( ( rule__Or__RightAssignment_1_2 ) )
            {
            // InternalFirstOrderLogic.g:1962:1: ( ( rule__Or__RightAssignment_1_2 ) )
            // InternalFirstOrderLogic.g:1963:2: ( rule__Or__RightAssignment_1_2 )
            {
             before(grammarAccess.getOrAccess().getRightAssignment_1_2()); 
            // InternalFirstOrderLogic.g:1964:2: ( rule__Or__RightAssignment_1_2 )
            // InternalFirstOrderLogic.g:1964:3: rule__Or__RightAssignment_1_2
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
    // InternalFirstOrderLogic.g:1973:1: rule__And__Group__0 : rule__And__Group__0__Impl rule__And__Group__1 ;
    public final void rule__And__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1977:1: ( rule__And__Group__0__Impl rule__And__Group__1 )
            // InternalFirstOrderLogic.g:1978:2: rule__And__Group__0__Impl rule__And__Group__1
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
    // InternalFirstOrderLogic.g:1985:1: rule__And__Group__0__Impl : ( ruleBooleanExpression ) ;
    public final void rule__And__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1989:1: ( ( ruleBooleanExpression ) )
            // InternalFirstOrderLogic.g:1990:1: ( ruleBooleanExpression )
            {
            // InternalFirstOrderLogic.g:1990:1: ( ruleBooleanExpression )
            // InternalFirstOrderLogic.g:1991:2: ruleBooleanExpression
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
    // InternalFirstOrderLogic.g:2000:1: rule__And__Group__1 : rule__And__Group__1__Impl ;
    public final void rule__And__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2004:1: ( rule__And__Group__1__Impl )
            // InternalFirstOrderLogic.g:2005:2: rule__And__Group__1__Impl
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
    // InternalFirstOrderLogic.g:2011:1: rule__And__Group__1__Impl : ( ( rule__And__Group_1__0 )* ) ;
    public final void rule__And__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2015:1: ( ( ( rule__And__Group_1__0 )* ) )
            // InternalFirstOrderLogic.g:2016:1: ( ( rule__And__Group_1__0 )* )
            {
            // InternalFirstOrderLogic.g:2016:1: ( ( rule__And__Group_1__0 )* )
            // InternalFirstOrderLogic.g:2017:2: ( rule__And__Group_1__0 )*
            {
             before(grammarAccess.getAndAccess().getGroup_1()); 
            // InternalFirstOrderLogic.g:2018:2: ( rule__And__Group_1__0 )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==23) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalFirstOrderLogic.g:2018:3: rule__And__Group_1__0
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
    // InternalFirstOrderLogic.g:2027:1: rule__And__Group_1__0 : rule__And__Group_1__0__Impl rule__And__Group_1__1 ;
    public final void rule__And__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2031:1: ( rule__And__Group_1__0__Impl rule__And__Group_1__1 )
            // InternalFirstOrderLogic.g:2032:2: rule__And__Group_1__0__Impl rule__And__Group_1__1
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
    // InternalFirstOrderLogic.g:2039:1: rule__And__Group_1__0__Impl : ( () ) ;
    public final void rule__And__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2043:1: ( ( () ) )
            // InternalFirstOrderLogic.g:2044:1: ( () )
            {
            // InternalFirstOrderLogic.g:2044:1: ( () )
            // InternalFirstOrderLogic.g:2045:2: ()
            {
             before(grammarAccess.getAndAccess().getAndLeftAction_1_0()); 
            // InternalFirstOrderLogic.g:2046:2: ()
            // InternalFirstOrderLogic.g:2046:3: 
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
    // InternalFirstOrderLogic.g:2054:1: rule__And__Group_1__1 : rule__And__Group_1__1__Impl rule__And__Group_1__2 ;
    public final void rule__And__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2058:1: ( rule__And__Group_1__1__Impl rule__And__Group_1__2 )
            // InternalFirstOrderLogic.g:2059:2: rule__And__Group_1__1__Impl rule__And__Group_1__2
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
    // InternalFirstOrderLogic.g:2066:1: rule__And__Group_1__1__Impl : ( 'and' ) ;
    public final void rule__And__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2070:1: ( ( 'and' ) )
            // InternalFirstOrderLogic.g:2071:1: ( 'and' )
            {
            // InternalFirstOrderLogic.g:2071:1: ( 'and' )
            // InternalFirstOrderLogic.g:2072:2: 'and'
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
    // InternalFirstOrderLogic.g:2081:1: rule__And__Group_1__2 : rule__And__Group_1__2__Impl ;
    public final void rule__And__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2085:1: ( rule__And__Group_1__2__Impl )
            // InternalFirstOrderLogic.g:2086:2: rule__And__Group_1__2__Impl
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
    // InternalFirstOrderLogic.g:2092:1: rule__And__Group_1__2__Impl : ( ( rule__And__RightAssignment_1_2 ) ) ;
    public final void rule__And__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2096:1: ( ( ( rule__And__RightAssignment_1_2 ) ) )
            // InternalFirstOrderLogic.g:2097:1: ( ( rule__And__RightAssignment_1_2 ) )
            {
            // InternalFirstOrderLogic.g:2097:1: ( ( rule__And__RightAssignment_1_2 ) )
            // InternalFirstOrderLogic.g:2098:2: ( rule__And__RightAssignment_1_2 )
            {
             before(grammarAccess.getAndAccess().getRightAssignment_1_2()); 
            // InternalFirstOrderLogic.g:2099:2: ( rule__And__RightAssignment_1_2 )
            // InternalFirstOrderLogic.g:2099:3: rule__And__RightAssignment_1_2
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
    // InternalFirstOrderLogic.g:2108:1: rule__Not__Group__0 : rule__Not__Group__0__Impl rule__Not__Group__1 ;
    public final void rule__Not__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2112:1: ( rule__Not__Group__0__Impl rule__Not__Group__1 )
            // InternalFirstOrderLogic.g:2113:2: rule__Not__Group__0__Impl rule__Not__Group__1
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
    // InternalFirstOrderLogic.g:2120:1: rule__Not__Group__0__Impl : ( () ) ;
    public final void rule__Not__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2124:1: ( ( () ) )
            // InternalFirstOrderLogic.g:2125:1: ( () )
            {
            // InternalFirstOrderLogic.g:2125:1: ( () )
            // InternalFirstOrderLogic.g:2126:2: ()
            {
             before(grammarAccess.getNotAccess().getNotAction_0()); 
            // InternalFirstOrderLogic.g:2127:2: ()
            // InternalFirstOrderLogic.g:2127:3: 
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
    // InternalFirstOrderLogic.g:2135:1: rule__Not__Group__1 : rule__Not__Group__1__Impl rule__Not__Group__2 ;
    public final void rule__Not__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2139:1: ( rule__Not__Group__1__Impl rule__Not__Group__2 )
            // InternalFirstOrderLogic.g:2140:2: rule__Not__Group__1__Impl rule__Not__Group__2
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
    // InternalFirstOrderLogic.g:2147:1: rule__Not__Group__1__Impl : ( 'not(' ) ;
    public final void rule__Not__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2151:1: ( ( 'not(' ) )
            // InternalFirstOrderLogic.g:2152:1: ( 'not(' )
            {
            // InternalFirstOrderLogic.g:2152:1: ( 'not(' )
            // InternalFirstOrderLogic.g:2153:2: 'not('
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
    // InternalFirstOrderLogic.g:2162:1: rule__Not__Group__2 : rule__Not__Group__2__Impl rule__Not__Group__3 ;
    public final void rule__Not__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2166:1: ( rule__Not__Group__2__Impl rule__Not__Group__3 )
            // InternalFirstOrderLogic.g:2167:2: rule__Not__Group__2__Impl rule__Not__Group__3
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
    // InternalFirstOrderLogic.g:2174:1: rule__Not__Group__2__Impl : ( ( rule__Not__NotAssignment_2 ) ) ;
    public final void rule__Not__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2178:1: ( ( ( rule__Not__NotAssignment_2 ) ) )
            // InternalFirstOrderLogic.g:2179:1: ( ( rule__Not__NotAssignment_2 ) )
            {
            // InternalFirstOrderLogic.g:2179:1: ( ( rule__Not__NotAssignment_2 ) )
            // InternalFirstOrderLogic.g:2180:2: ( rule__Not__NotAssignment_2 )
            {
             before(grammarAccess.getNotAccess().getNotAssignment_2()); 
            // InternalFirstOrderLogic.g:2181:2: ( rule__Not__NotAssignment_2 )
            // InternalFirstOrderLogic.g:2181:3: rule__Not__NotAssignment_2
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
    // InternalFirstOrderLogic.g:2189:1: rule__Not__Group__3 : rule__Not__Group__3__Impl ;
    public final void rule__Not__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2193:1: ( rule__Not__Group__3__Impl )
            // InternalFirstOrderLogic.g:2194:2: rule__Not__Group__3__Impl
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
    // InternalFirstOrderLogic.g:2200:1: rule__Not__Group__3__Impl : ( ')' ) ;
    public final void rule__Not__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2204:1: ( ( ')' ) )
            // InternalFirstOrderLogic.g:2205:1: ( ')' )
            {
            // InternalFirstOrderLogic.g:2205:1: ( ')' )
            // InternalFirstOrderLogic.g:2206:2: ')'
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
    // InternalFirstOrderLogic.g:2216:1: rule__Equals__Group__0 : rule__Equals__Group__0__Impl rule__Equals__Group__1 ;
    public final void rule__Equals__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2220:1: ( rule__Equals__Group__0__Impl rule__Equals__Group__1 )
            // InternalFirstOrderLogic.g:2221:2: rule__Equals__Group__0__Impl rule__Equals__Group__1
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
    // InternalFirstOrderLogic.g:2228:1: rule__Equals__Group__0__Impl : ( 'isEqual(' ) ;
    public final void rule__Equals__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2232:1: ( ( 'isEqual(' ) )
            // InternalFirstOrderLogic.g:2233:1: ( 'isEqual(' )
            {
            // InternalFirstOrderLogic.g:2233:1: ( 'isEqual(' )
            // InternalFirstOrderLogic.g:2234:2: 'isEqual('
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
    // InternalFirstOrderLogic.g:2243:1: rule__Equals__Group__1 : rule__Equals__Group__1__Impl rule__Equals__Group__2 ;
    public final void rule__Equals__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2247:1: ( rule__Equals__Group__1__Impl rule__Equals__Group__2 )
            // InternalFirstOrderLogic.g:2248:2: rule__Equals__Group__1__Impl rule__Equals__Group__2
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
    // InternalFirstOrderLogic.g:2255:1: rule__Equals__Group__1__Impl : ( ( rule__Equals__LeftAssignment_1 ) ) ;
    public final void rule__Equals__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2259:1: ( ( ( rule__Equals__LeftAssignment_1 ) ) )
            // InternalFirstOrderLogic.g:2260:1: ( ( rule__Equals__LeftAssignment_1 ) )
            {
            // InternalFirstOrderLogic.g:2260:1: ( ( rule__Equals__LeftAssignment_1 ) )
            // InternalFirstOrderLogic.g:2261:2: ( rule__Equals__LeftAssignment_1 )
            {
             before(grammarAccess.getEqualsAccess().getLeftAssignment_1()); 
            // InternalFirstOrderLogic.g:2262:2: ( rule__Equals__LeftAssignment_1 )
            // InternalFirstOrderLogic.g:2262:3: rule__Equals__LeftAssignment_1
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
    // InternalFirstOrderLogic.g:2270:1: rule__Equals__Group__2 : rule__Equals__Group__2__Impl rule__Equals__Group__3 ;
    public final void rule__Equals__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2274:1: ( rule__Equals__Group__2__Impl rule__Equals__Group__3 )
            // InternalFirstOrderLogic.g:2275:2: rule__Equals__Group__2__Impl rule__Equals__Group__3
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
    // InternalFirstOrderLogic.g:2282:1: rule__Equals__Group__2__Impl : ( ',' ) ;
    public final void rule__Equals__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2286:1: ( ( ',' ) )
            // InternalFirstOrderLogic.g:2287:1: ( ',' )
            {
            // InternalFirstOrderLogic.g:2287:1: ( ',' )
            // InternalFirstOrderLogic.g:2288:2: ','
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
    // InternalFirstOrderLogic.g:2297:1: rule__Equals__Group__3 : rule__Equals__Group__3__Impl rule__Equals__Group__4 ;
    public final void rule__Equals__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2301:1: ( rule__Equals__Group__3__Impl rule__Equals__Group__4 )
            // InternalFirstOrderLogic.g:2302:2: rule__Equals__Group__3__Impl rule__Equals__Group__4
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
    // InternalFirstOrderLogic.g:2309:1: rule__Equals__Group__3__Impl : ( ( rule__Equals__RightAssignment_3 ) ) ;
    public final void rule__Equals__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2313:1: ( ( ( rule__Equals__RightAssignment_3 ) ) )
            // InternalFirstOrderLogic.g:2314:1: ( ( rule__Equals__RightAssignment_3 ) )
            {
            // InternalFirstOrderLogic.g:2314:1: ( ( rule__Equals__RightAssignment_3 ) )
            // InternalFirstOrderLogic.g:2315:2: ( rule__Equals__RightAssignment_3 )
            {
             before(grammarAccess.getEqualsAccess().getRightAssignment_3()); 
            // InternalFirstOrderLogic.g:2316:2: ( rule__Equals__RightAssignment_3 )
            // InternalFirstOrderLogic.g:2316:3: rule__Equals__RightAssignment_3
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
    // InternalFirstOrderLogic.g:2324:1: rule__Equals__Group__4 : rule__Equals__Group__4__Impl ;
    public final void rule__Equals__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2328:1: ( rule__Equals__Group__4__Impl )
            // InternalFirstOrderLogic.g:2329:2: rule__Equals__Group__4__Impl
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
    // InternalFirstOrderLogic.g:2335:1: rule__Equals__Group__4__Impl : ( ')' ) ;
    public final void rule__Equals__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2339:1: ( ( ')' ) )
            // InternalFirstOrderLogic.g:2340:1: ( ')' )
            {
            // InternalFirstOrderLogic.g:2340:1: ( ')' )
            // InternalFirstOrderLogic.g:2341:2: ')'
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
    // InternalFirstOrderLogic.g:2351:1: rule__Greater__Group__0 : rule__Greater__Group__0__Impl rule__Greater__Group__1 ;
    public final void rule__Greater__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2355:1: ( rule__Greater__Group__0__Impl rule__Greater__Group__1 )
            // InternalFirstOrderLogic.g:2356:2: rule__Greater__Group__0__Impl rule__Greater__Group__1
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
    // InternalFirstOrderLogic.g:2363:1: rule__Greater__Group__0__Impl : ( 'isGreater(' ) ;
    public final void rule__Greater__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2367:1: ( ( 'isGreater(' ) )
            // InternalFirstOrderLogic.g:2368:1: ( 'isGreater(' )
            {
            // InternalFirstOrderLogic.g:2368:1: ( 'isGreater(' )
            // InternalFirstOrderLogic.g:2369:2: 'isGreater('
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
    // InternalFirstOrderLogic.g:2378:1: rule__Greater__Group__1 : rule__Greater__Group__1__Impl rule__Greater__Group__2 ;
    public final void rule__Greater__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2382:1: ( rule__Greater__Group__1__Impl rule__Greater__Group__2 )
            // InternalFirstOrderLogic.g:2383:2: rule__Greater__Group__1__Impl rule__Greater__Group__2
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
    // InternalFirstOrderLogic.g:2390:1: rule__Greater__Group__1__Impl : ( ( rule__Greater__LeftAssignment_1 ) ) ;
    public final void rule__Greater__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2394:1: ( ( ( rule__Greater__LeftAssignment_1 ) ) )
            // InternalFirstOrderLogic.g:2395:1: ( ( rule__Greater__LeftAssignment_1 ) )
            {
            // InternalFirstOrderLogic.g:2395:1: ( ( rule__Greater__LeftAssignment_1 ) )
            // InternalFirstOrderLogic.g:2396:2: ( rule__Greater__LeftAssignment_1 )
            {
             before(grammarAccess.getGreaterAccess().getLeftAssignment_1()); 
            // InternalFirstOrderLogic.g:2397:2: ( rule__Greater__LeftAssignment_1 )
            // InternalFirstOrderLogic.g:2397:3: rule__Greater__LeftAssignment_1
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
    // InternalFirstOrderLogic.g:2405:1: rule__Greater__Group__2 : rule__Greater__Group__2__Impl rule__Greater__Group__3 ;
    public final void rule__Greater__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2409:1: ( rule__Greater__Group__2__Impl rule__Greater__Group__3 )
            // InternalFirstOrderLogic.g:2410:2: rule__Greater__Group__2__Impl rule__Greater__Group__3
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
    // InternalFirstOrderLogic.g:2417:1: rule__Greater__Group__2__Impl : ( ',' ) ;
    public final void rule__Greater__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2421:1: ( ( ',' ) )
            // InternalFirstOrderLogic.g:2422:1: ( ',' )
            {
            // InternalFirstOrderLogic.g:2422:1: ( ',' )
            // InternalFirstOrderLogic.g:2423:2: ','
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
    // InternalFirstOrderLogic.g:2432:1: rule__Greater__Group__3 : rule__Greater__Group__3__Impl rule__Greater__Group__4 ;
    public final void rule__Greater__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2436:1: ( rule__Greater__Group__3__Impl rule__Greater__Group__4 )
            // InternalFirstOrderLogic.g:2437:2: rule__Greater__Group__3__Impl rule__Greater__Group__4
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
    // InternalFirstOrderLogic.g:2444:1: rule__Greater__Group__3__Impl : ( ( rule__Greater__RightAssignment_3 ) ) ;
    public final void rule__Greater__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2448:1: ( ( ( rule__Greater__RightAssignment_3 ) ) )
            // InternalFirstOrderLogic.g:2449:1: ( ( rule__Greater__RightAssignment_3 ) )
            {
            // InternalFirstOrderLogic.g:2449:1: ( ( rule__Greater__RightAssignment_3 ) )
            // InternalFirstOrderLogic.g:2450:2: ( rule__Greater__RightAssignment_3 )
            {
             before(grammarAccess.getGreaterAccess().getRightAssignment_3()); 
            // InternalFirstOrderLogic.g:2451:2: ( rule__Greater__RightAssignment_3 )
            // InternalFirstOrderLogic.g:2451:3: rule__Greater__RightAssignment_3
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
    // InternalFirstOrderLogic.g:2459:1: rule__Greater__Group__4 : rule__Greater__Group__4__Impl ;
    public final void rule__Greater__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2463:1: ( rule__Greater__Group__4__Impl )
            // InternalFirstOrderLogic.g:2464:2: rule__Greater__Group__4__Impl
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
    // InternalFirstOrderLogic.g:2470:1: rule__Greater__Group__4__Impl : ( ')' ) ;
    public final void rule__Greater__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2474:1: ( ( ')' ) )
            // InternalFirstOrderLogic.g:2475:1: ( ')' )
            {
            // InternalFirstOrderLogic.g:2475:1: ( ')' )
            // InternalFirstOrderLogic.g:2476:2: ')'
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
    // InternalFirstOrderLogic.g:2486:1: rule__GreaterEqual__Group__0 : rule__GreaterEqual__Group__0__Impl rule__GreaterEqual__Group__1 ;
    public final void rule__GreaterEqual__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2490:1: ( rule__GreaterEqual__Group__0__Impl rule__GreaterEqual__Group__1 )
            // InternalFirstOrderLogic.g:2491:2: rule__GreaterEqual__Group__0__Impl rule__GreaterEqual__Group__1
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
    // InternalFirstOrderLogic.g:2498:1: rule__GreaterEqual__Group__0__Impl : ( 'isGreaterEqual(' ) ;
    public final void rule__GreaterEqual__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2502:1: ( ( 'isGreaterEqual(' ) )
            // InternalFirstOrderLogic.g:2503:1: ( 'isGreaterEqual(' )
            {
            // InternalFirstOrderLogic.g:2503:1: ( 'isGreaterEqual(' )
            // InternalFirstOrderLogic.g:2504:2: 'isGreaterEqual('
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
    // InternalFirstOrderLogic.g:2513:1: rule__GreaterEqual__Group__1 : rule__GreaterEqual__Group__1__Impl rule__GreaterEqual__Group__2 ;
    public final void rule__GreaterEqual__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2517:1: ( rule__GreaterEqual__Group__1__Impl rule__GreaterEqual__Group__2 )
            // InternalFirstOrderLogic.g:2518:2: rule__GreaterEqual__Group__1__Impl rule__GreaterEqual__Group__2
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
    // InternalFirstOrderLogic.g:2525:1: rule__GreaterEqual__Group__1__Impl : ( ( rule__GreaterEqual__LeftAssignment_1 ) ) ;
    public final void rule__GreaterEqual__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2529:1: ( ( ( rule__GreaterEqual__LeftAssignment_1 ) ) )
            // InternalFirstOrderLogic.g:2530:1: ( ( rule__GreaterEqual__LeftAssignment_1 ) )
            {
            // InternalFirstOrderLogic.g:2530:1: ( ( rule__GreaterEqual__LeftAssignment_1 ) )
            // InternalFirstOrderLogic.g:2531:2: ( rule__GreaterEqual__LeftAssignment_1 )
            {
             before(grammarAccess.getGreaterEqualAccess().getLeftAssignment_1()); 
            // InternalFirstOrderLogic.g:2532:2: ( rule__GreaterEqual__LeftAssignment_1 )
            // InternalFirstOrderLogic.g:2532:3: rule__GreaterEqual__LeftAssignment_1
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
    // InternalFirstOrderLogic.g:2540:1: rule__GreaterEqual__Group__2 : rule__GreaterEqual__Group__2__Impl rule__GreaterEqual__Group__3 ;
    public final void rule__GreaterEqual__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2544:1: ( rule__GreaterEqual__Group__2__Impl rule__GreaterEqual__Group__3 )
            // InternalFirstOrderLogic.g:2545:2: rule__GreaterEqual__Group__2__Impl rule__GreaterEqual__Group__3
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
    // InternalFirstOrderLogic.g:2552:1: rule__GreaterEqual__Group__2__Impl : ( ',' ) ;
    public final void rule__GreaterEqual__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2556:1: ( ( ',' ) )
            // InternalFirstOrderLogic.g:2557:1: ( ',' )
            {
            // InternalFirstOrderLogic.g:2557:1: ( ',' )
            // InternalFirstOrderLogic.g:2558:2: ','
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
    // InternalFirstOrderLogic.g:2567:1: rule__GreaterEqual__Group__3 : rule__GreaterEqual__Group__3__Impl rule__GreaterEqual__Group__4 ;
    public final void rule__GreaterEqual__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2571:1: ( rule__GreaterEqual__Group__3__Impl rule__GreaterEqual__Group__4 )
            // InternalFirstOrderLogic.g:2572:2: rule__GreaterEqual__Group__3__Impl rule__GreaterEqual__Group__4
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
    // InternalFirstOrderLogic.g:2579:1: rule__GreaterEqual__Group__3__Impl : ( ( rule__GreaterEqual__RightAssignment_3 ) ) ;
    public final void rule__GreaterEqual__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2583:1: ( ( ( rule__GreaterEqual__RightAssignment_3 ) ) )
            // InternalFirstOrderLogic.g:2584:1: ( ( rule__GreaterEqual__RightAssignment_3 ) )
            {
            // InternalFirstOrderLogic.g:2584:1: ( ( rule__GreaterEqual__RightAssignment_3 ) )
            // InternalFirstOrderLogic.g:2585:2: ( rule__GreaterEqual__RightAssignment_3 )
            {
             before(grammarAccess.getGreaterEqualAccess().getRightAssignment_3()); 
            // InternalFirstOrderLogic.g:2586:2: ( rule__GreaterEqual__RightAssignment_3 )
            // InternalFirstOrderLogic.g:2586:3: rule__GreaterEqual__RightAssignment_3
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
    // InternalFirstOrderLogic.g:2594:1: rule__GreaterEqual__Group__4 : rule__GreaterEqual__Group__4__Impl ;
    public final void rule__GreaterEqual__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2598:1: ( rule__GreaterEqual__Group__4__Impl )
            // InternalFirstOrderLogic.g:2599:2: rule__GreaterEqual__Group__4__Impl
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
    // InternalFirstOrderLogic.g:2605:1: rule__GreaterEqual__Group__4__Impl : ( ')' ) ;
    public final void rule__GreaterEqual__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2609:1: ( ( ')' ) )
            // InternalFirstOrderLogic.g:2610:1: ( ')' )
            {
            // InternalFirstOrderLogic.g:2610:1: ( ')' )
            // InternalFirstOrderLogic.g:2611:2: ')'
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
    // InternalFirstOrderLogic.g:2621:1: rule__Smaller__Group__0 : rule__Smaller__Group__0__Impl rule__Smaller__Group__1 ;
    public final void rule__Smaller__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2625:1: ( rule__Smaller__Group__0__Impl rule__Smaller__Group__1 )
            // InternalFirstOrderLogic.g:2626:2: rule__Smaller__Group__0__Impl rule__Smaller__Group__1
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
    // InternalFirstOrderLogic.g:2633:1: rule__Smaller__Group__0__Impl : ( 'isSmaller(' ) ;
    public final void rule__Smaller__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2637:1: ( ( 'isSmaller(' ) )
            // InternalFirstOrderLogic.g:2638:1: ( 'isSmaller(' )
            {
            // InternalFirstOrderLogic.g:2638:1: ( 'isSmaller(' )
            // InternalFirstOrderLogic.g:2639:2: 'isSmaller('
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
    // InternalFirstOrderLogic.g:2648:1: rule__Smaller__Group__1 : rule__Smaller__Group__1__Impl rule__Smaller__Group__2 ;
    public final void rule__Smaller__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2652:1: ( rule__Smaller__Group__1__Impl rule__Smaller__Group__2 )
            // InternalFirstOrderLogic.g:2653:2: rule__Smaller__Group__1__Impl rule__Smaller__Group__2
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
    // InternalFirstOrderLogic.g:2660:1: rule__Smaller__Group__1__Impl : ( ( rule__Smaller__LeftAssignment_1 ) ) ;
    public final void rule__Smaller__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2664:1: ( ( ( rule__Smaller__LeftAssignment_1 ) ) )
            // InternalFirstOrderLogic.g:2665:1: ( ( rule__Smaller__LeftAssignment_1 ) )
            {
            // InternalFirstOrderLogic.g:2665:1: ( ( rule__Smaller__LeftAssignment_1 ) )
            // InternalFirstOrderLogic.g:2666:2: ( rule__Smaller__LeftAssignment_1 )
            {
             before(grammarAccess.getSmallerAccess().getLeftAssignment_1()); 
            // InternalFirstOrderLogic.g:2667:2: ( rule__Smaller__LeftAssignment_1 )
            // InternalFirstOrderLogic.g:2667:3: rule__Smaller__LeftAssignment_1
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
    // InternalFirstOrderLogic.g:2675:1: rule__Smaller__Group__2 : rule__Smaller__Group__2__Impl rule__Smaller__Group__3 ;
    public final void rule__Smaller__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2679:1: ( rule__Smaller__Group__2__Impl rule__Smaller__Group__3 )
            // InternalFirstOrderLogic.g:2680:2: rule__Smaller__Group__2__Impl rule__Smaller__Group__3
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
    // InternalFirstOrderLogic.g:2687:1: rule__Smaller__Group__2__Impl : ( ',' ) ;
    public final void rule__Smaller__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2691:1: ( ( ',' ) )
            // InternalFirstOrderLogic.g:2692:1: ( ',' )
            {
            // InternalFirstOrderLogic.g:2692:1: ( ',' )
            // InternalFirstOrderLogic.g:2693:2: ','
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
    // InternalFirstOrderLogic.g:2702:1: rule__Smaller__Group__3 : rule__Smaller__Group__3__Impl rule__Smaller__Group__4 ;
    public final void rule__Smaller__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2706:1: ( rule__Smaller__Group__3__Impl rule__Smaller__Group__4 )
            // InternalFirstOrderLogic.g:2707:2: rule__Smaller__Group__3__Impl rule__Smaller__Group__4
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
    // InternalFirstOrderLogic.g:2714:1: rule__Smaller__Group__3__Impl : ( ( rule__Smaller__RightAssignment_3 ) ) ;
    public final void rule__Smaller__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2718:1: ( ( ( rule__Smaller__RightAssignment_3 ) ) )
            // InternalFirstOrderLogic.g:2719:1: ( ( rule__Smaller__RightAssignment_3 ) )
            {
            // InternalFirstOrderLogic.g:2719:1: ( ( rule__Smaller__RightAssignment_3 ) )
            // InternalFirstOrderLogic.g:2720:2: ( rule__Smaller__RightAssignment_3 )
            {
             before(grammarAccess.getSmallerAccess().getRightAssignment_3()); 
            // InternalFirstOrderLogic.g:2721:2: ( rule__Smaller__RightAssignment_3 )
            // InternalFirstOrderLogic.g:2721:3: rule__Smaller__RightAssignment_3
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
    // InternalFirstOrderLogic.g:2729:1: rule__Smaller__Group__4 : rule__Smaller__Group__4__Impl ;
    public final void rule__Smaller__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2733:1: ( rule__Smaller__Group__4__Impl )
            // InternalFirstOrderLogic.g:2734:2: rule__Smaller__Group__4__Impl
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
    // InternalFirstOrderLogic.g:2740:1: rule__Smaller__Group__4__Impl : ( ')' ) ;
    public final void rule__Smaller__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2744:1: ( ( ')' ) )
            // InternalFirstOrderLogic.g:2745:1: ( ')' )
            {
            // InternalFirstOrderLogic.g:2745:1: ( ')' )
            // InternalFirstOrderLogic.g:2746:2: ')'
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
    // InternalFirstOrderLogic.g:2756:1: rule__SmallerEqual__Group__0 : rule__SmallerEqual__Group__0__Impl rule__SmallerEqual__Group__1 ;
    public final void rule__SmallerEqual__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2760:1: ( rule__SmallerEqual__Group__0__Impl rule__SmallerEqual__Group__1 )
            // InternalFirstOrderLogic.g:2761:2: rule__SmallerEqual__Group__0__Impl rule__SmallerEqual__Group__1
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
    // InternalFirstOrderLogic.g:2768:1: rule__SmallerEqual__Group__0__Impl : ( 'isSmallerEqual(' ) ;
    public final void rule__SmallerEqual__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2772:1: ( ( 'isSmallerEqual(' ) )
            // InternalFirstOrderLogic.g:2773:1: ( 'isSmallerEqual(' )
            {
            // InternalFirstOrderLogic.g:2773:1: ( 'isSmallerEqual(' )
            // InternalFirstOrderLogic.g:2774:2: 'isSmallerEqual('
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
    // InternalFirstOrderLogic.g:2783:1: rule__SmallerEqual__Group__1 : rule__SmallerEqual__Group__1__Impl rule__SmallerEqual__Group__2 ;
    public final void rule__SmallerEqual__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2787:1: ( rule__SmallerEqual__Group__1__Impl rule__SmallerEqual__Group__2 )
            // InternalFirstOrderLogic.g:2788:2: rule__SmallerEqual__Group__1__Impl rule__SmallerEqual__Group__2
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
    // InternalFirstOrderLogic.g:2795:1: rule__SmallerEqual__Group__1__Impl : ( ( rule__SmallerEqual__LeftAssignment_1 ) ) ;
    public final void rule__SmallerEqual__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2799:1: ( ( ( rule__SmallerEqual__LeftAssignment_1 ) ) )
            // InternalFirstOrderLogic.g:2800:1: ( ( rule__SmallerEqual__LeftAssignment_1 ) )
            {
            // InternalFirstOrderLogic.g:2800:1: ( ( rule__SmallerEqual__LeftAssignment_1 ) )
            // InternalFirstOrderLogic.g:2801:2: ( rule__SmallerEqual__LeftAssignment_1 )
            {
             before(grammarAccess.getSmallerEqualAccess().getLeftAssignment_1()); 
            // InternalFirstOrderLogic.g:2802:2: ( rule__SmallerEqual__LeftAssignment_1 )
            // InternalFirstOrderLogic.g:2802:3: rule__SmallerEqual__LeftAssignment_1
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
    // InternalFirstOrderLogic.g:2810:1: rule__SmallerEqual__Group__2 : rule__SmallerEqual__Group__2__Impl rule__SmallerEqual__Group__3 ;
    public final void rule__SmallerEqual__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2814:1: ( rule__SmallerEqual__Group__2__Impl rule__SmallerEqual__Group__3 )
            // InternalFirstOrderLogic.g:2815:2: rule__SmallerEqual__Group__2__Impl rule__SmallerEqual__Group__3
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
    // InternalFirstOrderLogic.g:2822:1: rule__SmallerEqual__Group__2__Impl : ( ',' ) ;
    public final void rule__SmallerEqual__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2826:1: ( ( ',' ) )
            // InternalFirstOrderLogic.g:2827:1: ( ',' )
            {
            // InternalFirstOrderLogic.g:2827:1: ( ',' )
            // InternalFirstOrderLogic.g:2828:2: ','
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
    // InternalFirstOrderLogic.g:2837:1: rule__SmallerEqual__Group__3 : rule__SmallerEqual__Group__3__Impl rule__SmallerEqual__Group__4 ;
    public final void rule__SmallerEqual__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2841:1: ( rule__SmallerEqual__Group__3__Impl rule__SmallerEqual__Group__4 )
            // InternalFirstOrderLogic.g:2842:2: rule__SmallerEqual__Group__3__Impl rule__SmallerEqual__Group__4
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
    // InternalFirstOrderLogic.g:2849:1: rule__SmallerEqual__Group__3__Impl : ( ( rule__SmallerEqual__RightAssignment_3 ) ) ;
    public final void rule__SmallerEqual__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2853:1: ( ( ( rule__SmallerEqual__RightAssignment_3 ) ) )
            // InternalFirstOrderLogic.g:2854:1: ( ( rule__SmallerEqual__RightAssignment_3 ) )
            {
            // InternalFirstOrderLogic.g:2854:1: ( ( rule__SmallerEqual__RightAssignment_3 ) )
            // InternalFirstOrderLogic.g:2855:2: ( rule__SmallerEqual__RightAssignment_3 )
            {
             before(grammarAccess.getSmallerEqualAccess().getRightAssignment_3()); 
            // InternalFirstOrderLogic.g:2856:2: ( rule__SmallerEqual__RightAssignment_3 )
            // InternalFirstOrderLogic.g:2856:3: rule__SmallerEqual__RightAssignment_3
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
    // InternalFirstOrderLogic.g:2864:1: rule__SmallerEqual__Group__4 : rule__SmallerEqual__Group__4__Impl ;
    public final void rule__SmallerEqual__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2868:1: ( rule__SmallerEqual__Group__4__Impl )
            // InternalFirstOrderLogic.g:2869:2: rule__SmallerEqual__Group__4__Impl
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
    // InternalFirstOrderLogic.g:2875:1: rule__SmallerEqual__Group__4__Impl : ( ')' ) ;
    public final void rule__SmallerEqual__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2879:1: ( ( ')' ) )
            // InternalFirstOrderLogic.g:2880:1: ( ')' )
            {
            // InternalFirstOrderLogic.g:2880:1: ( ')' )
            // InternalFirstOrderLogic.g:2881:2: ')'
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
    // InternalFirstOrderLogic.g:2891:1: rule__IsEmpty__Group__0 : rule__IsEmpty__Group__0__Impl rule__IsEmpty__Group__1 ;
    public final void rule__IsEmpty__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2895:1: ( rule__IsEmpty__Group__0__Impl rule__IsEmpty__Group__1 )
            // InternalFirstOrderLogic.g:2896:2: rule__IsEmpty__Group__0__Impl rule__IsEmpty__Group__1
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
    // InternalFirstOrderLogic.g:2903:1: rule__IsEmpty__Group__0__Impl : ( 'isEmpty(' ) ;
    public final void rule__IsEmpty__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2907:1: ( ( 'isEmpty(' ) )
            // InternalFirstOrderLogic.g:2908:1: ( 'isEmpty(' )
            {
            // InternalFirstOrderLogic.g:2908:1: ( 'isEmpty(' )
            // InternalFirstOrderLogic.g:2909:2: 'isEmpty('
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
    // InternalFirstOrderLogic.g:2918:1: rule__IsEmpty__Group__1 : rule__IsEmpty__Group__1__Impl rule__IsEmpty__Group__2 ;
    public final void rule__IsEmpty__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2922:1: ( rule__IsEmpty__Group__1__Impl rule__IsEmpty__Group__2 )
            // InternalFirstOrderLogic.g:2923:2: rule__IsEmpty__Group__1__Impl rule__IsEmpty__Group__2
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
    // InternalFirstOrderLogic.g:2930:1: rule__IsEmpty__Group__1__Impl : ( ( rule__IsEmpty__TermAssignment_1 ) ) ;
    public final void rule__IsEmpty__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2934:1: ( ( ( rule__IsEmpty__TermAssignment_1 ) ) )
            // InternalFirstOrderLogic.g:2935:1: ( ( rule__IsEmpty__TermAssignment_1 ) )
            {
            // InternalFirstOrderLogic.g:2935:1: ( ( rule__IsEmpty__TermAssignment_1 ) )
            // InternalFirstOrderLogic.g:2936:2: ( rule__IsEmpty__TermAssignment_1 )
            {
             before(grammarAccess.getIsEmptyAccess().getTermAssignment_1()); 
            // InternalFirstOrderLogic.g:2937:2: ( rule__IsEmpty__TermAssignment_1 )
            // InternalFirstOrderLogic.g:2937:3: rule__IsEmpty__TermAssignment_1
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
    // InternalFirstOrderLogic.g:2945:1: rule__IsEmpty__Group__2 : rule__IsEmpty__Group__2__Impl ;
    public final void rule__IsEmpty__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2949:1: ( rule__IsEmpty__Group__2__Impl )
            // InternalFirstOrderLogic.g:2950:2: rule__IsEmpty__Group__2__Impl
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
    // InternalFirstOrderLogic.g:2956:1: rule__IsEmpty__Group__2__Impl : ( ')' ) ;
    public final void rule__IsEmpty__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2960:1: ( ( ')' ) )
            // InternalFirstOrderLogic.g:2961:1: ( ')' )
            {
            // InternalFirstOrderLogic.g:2961:1: ( ')' )
            // InternalFirstOrderLogic.g:2962:2: ')'
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


    // $ANTLR start "rule__ForAll__Group__0"
    // InternalFirstOrderLogic.g:2972:1: rule__ForAll__Group__0 : rule__ForAll__Group__0__Impl rule__ForAll__Group__1 ;
    public final void rule__ForAll__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2976:1: ( rule__ForAll__Group__0__Impl rule__ForAll__Group__1 )
            // InternalFirstOrderLogic.g:2977:2: rule__ForAll__Group__0__Impl rule__ForAll__Group__1
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
    // InternalFirstOrderLogic.g:2984:1: rule__ForAll__Group__0__Impl : ( () ) ;
    public final void rule__ForAll__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2988:1: ( ( () ) )
            // InternalFirstOrderLogic.g:2989:1: ( () )
            {
            // InternalFirstOrderLogic.g:2989:1: ( () )
            // InternalFirstOrderLogic.g:2990:2: ()
            {
             before(grammarAccess.getForAllAccess().getForAllAction_0()); 
            // InternalFirstOrderLogic.g:2991:2: ()
            // InternalFirstOrderLogic.g:2991:3: 
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
    // InternalFirstOrderLogic.g:2999:1: rule__ForAll__Group__1 : rule__ForAll__Group__1__Impl rule__ForAll__Group__2 ;
    public final void rule__ForAll__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3003:1: ( rule__ForAll__Group__1__Impl rule__ForAll__Group__2 )
            // InternalFirstOrderLogic.g:3004:2: rule__ForAll__Group__1__Impl rule__ForAll__Group__2
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
    // InternalFirstOrderLogic.g:3011:1: rule__ForAll__Group__1__Impl : ( 'forAll(' ) ;
    public final void rule__ForAll__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3015:1: ( ( 'forAll(' ) )
            // InternalFirstOrderLogic.g:3016:1: ( 'forAll(' )
            {
            // InternalFirstOrderLogic.g:3016:1: ( 'forAll(' )
            // InternalFirstOrderLogic.g:3017:2: 'forAll('
            {
             before(grammarAccess.getForAllAccess().getForAllKeyword_1()); 
            match(input,33,FOLLOW_2); 
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
    // InternalFirstOrderLogic.g:3026:1: rule__ForAll__Group__2 : rule__ForAll__Group__2__Impl rule__ForAll__Group__3 ;
    public final void rule__ForAll__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3030:1: ( rule__ForAll__Group__2__Impl rule__ForAll__Group__3 )
            // InternalFirstOrderLogic.g:3031:2: rule__ForAll__Group__2__Impl rule__ForAll__Group__3
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
    // InternalFirstOrderLogic.g:3038:1: rule__ForAll__Group__2__Impl : ( ( rule__ForAll__NameAssignment_2 ) ) ;
    public final void rule__ForAll__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3042:1: ( ( ( rule__ForAll__NameAssignment_2 ) ) )
            // InternalFirstOrderLogic.g:3043:1: ( ( rule__ForAll__NameAssignment_2 ) )
            {
            // InternalFirstOrderLogic.g:3043:1: ( ( rule__ForAll__NameAssignment_2 ) )
            // InternalFirstOrderLogic.g:3044:2: ( rule__ForAll__NameAssignment_2 )
            {
             before(grammarAccess.getForAllAccess().getNameAssignment_2()); 
            // InternalFirstOrderLogic.g:3045:2: ( rule__ForAll__NameAssignment_2 )
            // InternalFirstOrderLogic.g:3045:3: rule__ForAll__NameAssignment_2
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
    // InternalFirstOrderLogic.g:3053:1: rule__ForAll__Group__3 : rule__ForAll__Group__3__Impl rule__ForAll__Group__4 ;
    public final void rule__ForAll__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3057:1: ( rule__ForAll__Group__3__Impl rule__ForAll__Group__4 )
            // InternalFirstOrderLogic.g:3058:2: rule__ForAll__Group__3__Impl rule__ForAll__Group__4
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
    // InternalFirstOrderLogic.g:3065:1: rule__ForAll__Group__3__Impl : ( 'in' ) ;
    public final void rule__ForAll__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3069:1: ( ( 'in' ) )
            // InternalFirstOrderLogic.g:3070:1: ( 'in' )
            {
            // InternalFirstOrderLogic.g:3070:1: ( 'in' )
            // InternalFirstOrderLogic.g:3071:2: 'in'
            {
             before(grammarAccess.getForAllAccess().getInKeyword_3()); 
            match(input,34,FOLLOW_2); 
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
    // InternalFirstOrderLogic.g:3080:1: rule__ForAll__Group__4 : rule__ForAll__Group__4__Impl rule__ForAll__Group__5 ;
    public final void rule__ForAll__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3084:1: ( rule__ForAll__Group__4__Impl rule__ForAll__Group__5 )
            // InternalFirstOrderLogic.g:3085:2: rule__ForAll__Group__4__Impl rule__ForAll__Group__5
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
    // InternalFirstOrderLogic.g:3092:1: rule__ForAll__Group__4__Impl : ( ( rule__ForAll__IterationAssignment_4 ) ) ;
    public final void rule__ForAll__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3096:1: ( ( ( rule__ForAll__IterationAssignment_4 ) ) )
            // InternalFirstOrderLogic.g:3097:1: ( ( rule__ForAll__IterationAssignment_4 ) )
            {
            // InternalFirstOrderLogic.g:3097:1: ( ( rule__ForAll__IterationAssignment_4 ) )
            // InternalFirstOrderLogic.g:3098:2: ( rule__ForAll__IterationAssignment_4 )
            {
             before(grammarAccess.getForAllAccess().getIterationAssignment_4()); 
            // InternalFirstOrderLogic.g:3099:2: ( rule__ForAll__IterationAssignment_4 )
            // InternalFirstOrderLogic.g:3099:3: rule__ForAll__IterationAssignment_4
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
    // InternalFirstOrderLogic.g:3107:1: rule__ForAll__Group__5 : rule__ForAll__Group__5__Impl rule__ForAll__Group__6 ;
    public final void rule__ForAll__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3111:1: ( rule__ForAll__Group__5__Impl rule__ForAll__Group__6 )
            // InternalFirstOrderLogic.g:3112:2: rule__ForAll__Group__5__Impl rule__ForAll__Group__6
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
    // InternalFirstOrderLogic.g:3119:1: rule__ForAll__Group__5__Impl : ( ':' ) ;
    public final void rule__ForAll__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3123:1: ( ( ':' ) )
            // InternalFirstOrderLogic.g:3124:1: ( ':' )
            {
            // InternalFirstOrderLogic.g:3124:1: ( ':' )
            // InternalFirstOrderLogic.g:3125:2: ':'
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
    // InternalFirstOrderLogic.g:3134:1: rule__ForAll__Group__6 : rule__ForAll__Group__6__Impl rule__ForAll__Group__7 ;
    public final void rule__ForAll__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3138:1: ( rule__ForAll__Group__6__Impl rule__ForAll__Group__7 )
            // InternalFirstOrderLogic.g:3139:2: rule__ForAll__Group__6__Impl rule__ForAll__Group__7
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
    // InternalFirstOrderLogic.g:3146:1: rule__ForAll__Group__6__Impl : ( ( rule__ForAll__FormulaAssignment_6 ) ) ;
    public final void rule__ForAll__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3150:1: ( ( ( rule__ForAll__FormulaAssignment_6 ) ) )
            // InternalFirstOrderLogic.g:3151:1: ( ( rule__ForAll__FormulaAssignment_6 ) )
            {
            // InternalFirstOrderLogic.g:3151:1: ( ( rule__ForAll__FormulaAssignment_6 ) )
            // InternalFirstOrderLogic.g:3152:2: ( rule__ForAll__FormulaAssignment_6 )
            {
             before(grammarAccess.getForAllAccess().getFormulaAssignment_6()); 
            // InternalFirstOrderLogic.g:3153:2: ( rule__ForAll__FormulaAssignment_6 )
            // InternalFirstOrderLogic.g:3153:3: rule__ForAll__FormulaAssignment_6
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
    // InternalFirstOrderLogic.g:3161:1: rule__ForAll__Group__7 : rule__ForAll__Group__7__Impl ;
    public final void rule__ForAll__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3165:1: ( rule__ForAll__Group__7__Impl )
            // InternalFirstOrderLogic.g:3166:2: rule__ForAll__Group__7__Impl
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
    // InternalFirstOrderLogic.g:3172:1: rule__ForAll__Group__7__Impl : ( ')' ) ;
    public final void rule__ForAll__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3176:1: ( ( ')' ) )
            // InternalFirstOrderLogic.g:3177:1: ( ')' )
            {
            // InternalFirstOrderLogic.g:3177:1: ( ')' )
            // InternalFirstOrderLogic.g:3178:2: ')'
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
    // InternalFirstOrderLogic.g:3188:1: rule__Exists__Group__0 : rule__Exists__Group__0__Impl rule__Exists__Group__1 ;
    public final void rule__Exists__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3192:1: ( rule__Exists__Group__0__Impl rule__Exists__Group__1 )
            // InternalFirstOrderLogic.g:3193:2: rule__Exists__Group__0__Impl rule__Exists__Group__1
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
    // InternalFirstOrderLogic.g:3200:1: rule__Exists__Group__0__Impl : ( () ) ;
    public final void rule__Exists__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3204:1: ( ( () ) )
            // InternalFirstOrderLogic.g:3205:1: ( () )
            {
            // InternalFirstOrderLogic.g:3205:1: ( () )
            // InternalFirstOrderLogic.g:3206:2: ()
            {
             before(grammarAccess.getExistsAccess().getExistsAction_0()); 
            // InternalFirstOrderLogic.g:3207:2: ()
            // InternalFirstOrderLogic.g:3207:3: 
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
    // InternalFirstOrderLogic.g:3215:1: rule__Exists__Group__1 : rule__Exists__Group__1__Impl rule__Exists__Group__2 ;
    public final void rule__Exists__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3219:1: ( rule__Exists__Group__1__Impl rule__Exists__Group__2 )
            // InternalFirstOrderLogic.g:3220:2: rule__Exists__Group__1__Impl rule__Exists__Group__2
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
    // InternalFirstOrderLogic.g:3227:1: rule__Exists__Group__1__Impl : ( 'exists(' ) ;
    public final void rule__Exists__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3231:1: ( ( 'exists(' ) )
            // InternalFirstOrderLogic.g:3232:1: ( 'exists(' )
            {
            // InternalFirstOrderLogic.g:3232:1: ( 'exists(' )
            // InternalFirstOrderLogic.g:3233:2: 'exists('
            {
             before(grammarAccess.getExistsAccess().getExistsKeyword_1()); 
            match(input,35,FOLLOW_2); 
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
    // InternalFirstOrderLogic.g:3242:1: rule__Exists__Group__2 : rule__Exists__Group__2__Impl rule__Exists__Group__3 ;
    public final void rule__Exists__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3246:1: ( rule__Exists__Group__2__Impl rule__Exists__Group__3 )
            // InternalFirstOrderLogic.g:3247:2: rule__Exists__Group__2__Impl rule__Exists__Group__3
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
    // InternalFirstOrderLogic.g:3254:1: rule__Exists__Group__2__Impl : ( ( rule__Exists__NameAssignment_2 ) ) ;
    public final void rule__Exists__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3258:1: ( ( ( rule__Exists__NameAssignment_2 ) ) )
            // InternalFirstOrderLogic.g:3259:1: ( ( rule__Exists__NameAssignment_2 ) )
            {
            // InternalFirstOrderLogic.g:3259:1: ( ( rule__Exists__NameAssignment_2 ) )
            // InternalFirstOrderLogic.g:3260:2: ( rule__Exists__NameAssignment_2 )
            {
             before(grammarAccess.getExistsAccess().getNameAssignment_2()); 
            // InternalFirstOrderLogic.g:3261:2: ( rule__Exists__NameAssignment_2 )
            // InternalFirstOrderLogic.g:3261:3: rule__Exists__NameAssignment_2
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
    // InternalFirstOrderLogic.g:3269:1: rule__Exists__Group__3 : rule__Exists__Group__3__Impl rule__Exists__Group__4 ;
    public final void rule__Exists__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3273:1: ( rule__Exists__Group__3__Impl rule__Exists__Group__4 )
            // InternalFirstOrderLogic.g:3274:2: rule__Exists__Group__3__Impl rule__Exists__Group__4
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
    // InternalFirstOrderLogic.g:3281:1: rule__Exists__Group__3__Impl : ( 'in' ) ;
    public final void rule__Exists__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3285:1: ( ( 'in' ) )
            // InternalFirstOrderLogic.g:3286:1: ( 'in' )
            {
            // InternalFirstOrderLogic.g:3286:1: ( 'in' )
            // InternalFirstOrderLogic.g:3287:2: 'in'
            {
             before(grammarAccess.getExistsAccess().getInKeyword_3()); 
            match(input,34,FOLLOW_2); 
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
    // InternalFirstOrderLogic.g:3296:1: rule__Exists__Group__4 : rule__Exists__Group__4__Impl rule__Exists__Group__5 ;
    public final void rule__Exists__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3300:1: ( rule__Exists__Group__4__Impl rule__Exists__Group__5 )
            // InternalFirstOrderLogic.g:3301:2: rule__Exists__Group__4__Impl rule__Exists__Group__5
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
    // InternalFirstOrderLogic.g:3308:1: rule__Exists__Group__4__Impl : ( ( rule__Exists__IterationAssignment_4 ) ) ;
    public final void rule__Exists__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3312:1: ( ( ( rule__Exists__IterationAssignment_4 ) ) )
            // InternalFirstOrderLogic.g:3313:1: ( ( rule__Exists__IterationAssignment_4 ) )
            {
            // InternalFirstOrderLogic.g:3313:1: ( ( rule__Exists__IterationAssignment_4 ) )
            // InternalFirstOrderLogic.g:3314:2: ( rule__Exists__IterationAssignment_4 )
            {
             before(grammarAccess.getExistsAccess().getIterationAssignment_4()); 
            // InternalFirstOrderLogic.g:3315:2: ( rule__Exists__IterationAssignment_4 )
            // InternalFirstOrderLogic.g:3315:3: rule__Exists__IterationAssignment_4
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
    // InternalFirstOrderLogic.g:3323:1: rule__Exists__Group__5 : rule__Exists__Group__5__Impl rule__Exists__Group__6 ;
    public final void rule__Exists__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3327:1: ( rule__Exists__Group__5__Impl rule__Exists__Group__6 )
            // InternalFirstOrderLogic.g:3328:2: rule__Exists__Group__5__Impl rule__Exists__Group__6
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
    // InternalFirstOrderLogic.g:3335:1: rule__Exists__Group__5__Impl : ( ':' ) ;
    public final void rule__Exists__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3339:1: ( ( ':' ) )
            // InternalFirstOrderLogic.g:3340:1: ( ':' )
            {
            // InternalFirstOrderLogic.g:3340:1: ( ':' )
            // InternalFirstOrderLogic.g:3341:2: ':'
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
    // InternalFirstOrderLogic.g:3350:1: rule__Exists__Group__6 : rule__Exists__Group__6__Impl rule__Exists__Group__7 ;
    public final void rule__Exists__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3354:1: ( rule__Exists__Group__6__Impl rule__Exists__Group__7 )
            // InternalFirstOrderLogic.g:3355:2: rule__Exists__Group__6__Impl rule__Exists__Group__7
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
    // InternalFirstOrderLogic.g:3362:1: rule__Exists__Group__6__Impl : ( ( rule__Exists__FormulaAssignment_6 ) ) ;
    public final void rule__Exists__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3366:1: ( ( ( rule__Exists__FormulaAssignment_6 ) ) )
            // InternalFirstOrderLogic.g:3367:1: ( ( rule__Exists__FormulaAssignment_6 ) )
            {
            // InternalFirstOrderLogic.g:3367:1: ( ( rule__Exists__FormulaAssignment_6 ) )
            // InternalFirstOrderLogic.g:3368:2: ( rule__Exists__FormulaAssignment_6 )
            {
             before(grammarAccess.getExistsAccess().getFormulaAssignment_6()); 
            // InternalFirstOrderLogic.g:3369:2: ( rule__Exists__FormulaAssignment_6 )
            // InternalFirstOrderLogic.g:3369:3: rule__Exists__FormulaAssignment_6
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
    // InternalFirstOrderLogic.g:3377:1: rule__Exists__Group__7 : rule__Exists__Group__7__Impl ;
    public final void rule__Exists__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3381:1: ( rule__Exists__Group__7__Impl )
            // InternalFirstOrderLogic.g:3382:2: rule__Exists__Group__7__Impl
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
    // InternalFirstOrderLogic.g:3388:1: rule__Exists__Group__7__Impl : ( ')' ) ;
    public final void rule__Exists__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3392:1: ( ( ')' ) )
            // InternalFirstOrderLogic.g:3393:1: ( ')' )
            {
            // InternalFirstOrderLogic.g:3393:1: ( ')' )
            // InternalFirstOrderLogic.g:3394:2: ')'
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
    // InternalFirstOrderLogic.g:3404:1: rule__BooleanExpression__Group_0__0 : rule__BooleanExpression__Group_0__0__Impl rule__BooleanExpression__Group_0__1 ;
    public final void rule__BooleanExpression__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3408:1: ( rule__BooleanExpression__Group_0__0__Impl rule__BooleanExpression__Group_0__1 )
            // InternalFirstOrderLogic.g:3409:2: rule__BooleanExpression__Group_0__0__Impl rule__BooleanExpression__Group_0__1
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
    // InternalFirstOrderLogic.g:3416:1: rule__BooleanExpression__Group_0__0__Impl : ( '(' ) ;
    public final void rule__BooleanExpression__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3420:1: ( ( '(' ) )
            // InternalFirstOrderLogic.g:3421:1: ( '(' )
            {
            // InternalFirstOrderLogic.g:3421:1: ( '(' )
            // InternalFirstOrderLogic.g:3422:2: '('
            {
             before(grammarAccess.getBooleanExpressionAccess().getLeftParenthesisKeyword_0_0()); 
            match(input,36,FOLLOW_2); 
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
    // InternalFirstOrderLogic.g:3431:1: rule__BooleanExpression__Group_0__1 : rule__BooleanExpression__Group_0__1__Impl rule__BooleanExpression__Group_0__2 ;
    public final void rule__BooleanExpression__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3435:1: ( rule__BooleanExpression__Group_0__1__Impl rule__BooleanExpression__Group_0__2 )
            // InternalFirstOrderLogic.g:3436:2: rule__BooleanExpression__Group_0__1__Impl rule__BooleanExpression__Group_0__2
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
    // InternalFirstOrderLogic.g:3443:1: rule__BooleanExpression__Group_0__1__Impl : ( ruleFormula ) ;
    public final void rule__BooleanExpression__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3447:1: ( ( ruleFormula ) )
            // InternalFirstOrderLogic.g:3448:1: ( ruleFormula )
            {
            // InternalFirstOrderLogic.g:3448:1: ( ruleFormula )
            // InternalFirstOrderLogic.g:3449:2: ruleFormula
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
    // InternalFirstOrderLogic.g:3458:1: rule__BooleanExpression__Group_0__2 : rule__BooleanExpression__Group_0__2__Impl ;
    public final void rule__BooleanExpression__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3462:1: ( rule__BooleanExpression__Group_0__2__Impl )
            // InternalFirstOrderLogic.g:3463:2: rule__BooleanExpression__Group_0__2__Impl
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
    // InternalFirstOrderLogic.g:3469:1: rule__BooleanExpression__Group_0__2__Impl : ( ')' ) ;
    public final void rule__BooleanExpression__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3473:1: ( ( ')' ) )
            // InternalFirstOrderLogic.g:3474:1: ( ')' )
            {
            // InternalFirstOrderLogic.g:3474:1: ( ')' )
            // InternalFirstOrderLogic.g:3475:2: ')'
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
    // InternalFirstOrderLogic.g:3485:1: rule__BoolConstant__Group__0 : rule__BoolConstant__Group__0__Impl rule__BoolConstant__Group__1 ;
    public final void rule__BoolConstant__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3489:1: ( rule__BoolConstant__Group__0__Impl rule__BoolConstant__Group__1 )
            // InternalFirstOrderLogic.g:3490:2: rule__BoolConstant__Group__0__Impl rule__BoolConstant__Group__1
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
    // InternalFirstOrderLogic.g:3497:1: rule__BoolConstant__Group__0__Impl : ( () ) ;
    public final void rule__BoolConstant__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3501:1: ( ( () ) )
            // InternalFirstOrderLogic.g:3502:1: ( () )
            {
            // InternalFirstOrderLogic.g:3502:1: ( () )
            // InternalFirstOrderLogic.g:3503:2: ()
            {
             before(grammarAccess.getBoolConstantAccess().getBoolConstantAction_0()); 
            // InternalFirstOrderLogic.g:3504:2: ()
            // InternalFirstOrderLogic.g:3504:3: 
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
    // InternalFirstOrderLogic.g:3512:1: rule__BoolConstant__Group__1 : rule__BoolConstant__Group__1__Impl ;
    public final void rule__BoolConstant__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3516:1: ( rule__BoolConstant__Group__1__Impl )
            // InternalFirstOrderLogic.g:3517:2: rule__BoolConstant__Group__1__Impl
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
    // InternalFirstOrderLogic.g:3523:1: rule__BoolConstant__Group__1__Impl : ( ( rule__BoolConstant__ValueAssignment_1 ) ) ;
    public final void rule__BoolConstant__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3527:1: ( ( ( rule__BoolConstant__ValueAssignment_1 ) ) )
            // InternalFirstOrderLogic.g:3528:1: ( ( rule__BoolConstant__ValueAssignment_1 ) )
            {
            // InternalFirstOrderLogic.g:3528:1: ( ( rule__BoolConstant__ValueAssignment_1 ) )
            // InternalFirstOrderLogic.g:3529:2: ( rule__BoolConstant__ValueAssignment_1 )
            {
             before(grammarAccess.getBoolConstantAccess().getValueAssignment_1()); 
            // InternalFirstOrderLogic.g:3530:2: ( rule__BoolConstant__ValueAssignment_1 )
            // InternalFirstOrderLogic.g:3530:3: rule__BoolConstant__ValueAssignment_1
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
    // InternalFirstOrderLogic.g:3539:1: rule__VariableRef__Group__0 : rule__VariableRef__Group__0__Impl rule__VariableRef__Group__1 ;
    public final void rule__VariableRef__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3543:1: ( rule__VariableRef__Group__0__Impl rule__VariableRef__Group__1 )
            // InternalFirstOrderLogic.g:3544:2: rule__VariableRef__Group__0__Impl rule__VariableRef__Group__1
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
    // InternalFirstOrderLogic.g:3551:1: rule__VariableRef__Group__0__Impl : ( () ) ;
    public final void rule__VariableRef__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3555:1: ( ( () ) )
            // InternalFirstOrderLogic.g:3556:1: ( () )
            {
            // InternalFirstOrderLogic.g:3556:1: ( () )
            // InternalFirstOrderLogic.g:3557:2: ()
            {
             before(grammarAccess.getVariableRefAccess().getVariableRefAction_0()); 
            // InternalFirstOrderLogic.g:3558:2: ()
            // InternalFirstOrderLogic.g:3558:3: 
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
    // InternalFirstOrderLogic.g:3566:1: rule__VariableRef__Group__1 : rule__VariableRef__Group__1__Impl rule__VariableRef__Group__2 ;
    public final void rule__VariableRef__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3570:1: ( rule__VariableRef__Group__1__Impl rule__VariableRef__Group__2 )
            // InternalFirstOrderLogic.g:3571:2: rule__VariableRef__Group__1__Impl rule__VariableRef__Group__2
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
    // InternalFirstOrderLogic.g:3578:1: rule__VariableRef__Group__1__Impl : ( ( rule__VariableRef__NameAssignment_1 ) ) ;
    public final void rule__VariableRef__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3582:1: ( ( ( rule__VariableRef__NameAssignment_1 ) ) )
            // InternalFirstOrderLogic.g:3583:1: ( ( rule__VariableRef__NameAssignment_1 ) )
            {
            // InternalFirstOrderLogic.g:3583:1: ( ( rule__VariableRef__NameAssignment_1 ) )
            // InternalFirstOrderLogic.g:3584:2: ( rule__VariableRef__NameAssignment_1 )
            {
             before(grammarAccess.getVariableRefAccess().getNameAssignment_1()); 
            // InternalFirstOrderLogic.g:3585:2: ( rule__VariableRef__NameAssignment_1 )
            // InternalFirstOrderLogic.g:3585:3: rule__VariableRef__NameAssignment_1
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
    // InternalFirstOrderLogic.g:3593:1: rule__VariableRef__Group__2 : rule__VariableRef__Group__2__Impl ;
    public final void rule__VariableRef__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3597:1: ( rule__VariableRef__Group__2__Impl )
            // InternalFirstOrderLogic.g:3598:2: rule__VariableRef__Group__2__Impl
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
    // InternalFirstOrderLogic.g:3604:1: rule__VariableRef__Group__2__Impl : ( ( rule__VariableRef__GetAssignment_2 )? ) ;
    public final void rule__VariableRef__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3608:1: ( ( ( rule__VariableRef__GetAssignment_2 )? ) )
            // InternalFirstOrderLogic.g:3609:1: ( ( rule__VariableRef__GetAssignment_2 )? )
            {
            // InternalFirstOrderLogic.g:3609:1: ( ( rule__VariableRef__GetAssignment_2 )? )
            // InternalFirstOrderLogic.g:3610:2: ( rule__VariableRef__GetAssignment_2 )?
            {
             before(grammarAccess.getVariableRefAccess().getGetAssignment_2()); 
            // InternalFirstOrderLogic.g:3611:2: ( rule__VariableRef__GetAssignment_2 )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==37) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalFirstOrderLogic.g:3611:3: rule__VariableRef__GetAssignment_2
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
    // InternalFirstOrderLogic.g:3620:1: rule__Get__Group__0 : rule__Get__Group__0__Impl rule__Get__Group__1 ;
    public final void rule__Get__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3624:1: ( rule__Get__Group__0__Impl rule__Get__Group__1 )
            // InternalFirstOrderLogic.g:3625:2: rule__Get__Group__0__Impl rule__Get__Group__1
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
    // InternalFirstOrderLogic.g:3632:1: rule__Get__Group__0__Impl : ( '.' ) ;
    public final void rule__Get__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3636:1: ( ( '.' ) )
            // InternalFirstOrderLogic.g:3637:1: ( '.' )
            {
            // InternalFirstOrderLogic.g:3637:1: ( '.' )
            // InternalFirstOrderLogic.g:3638:2: '.'
            {
             before(grammarAccess.getGetAccess().getFullStopKeyword_0()); 
            match(input,37,FOLLOW_2); 
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
    // InternalFirstOrderLogic.g:3647:1: rule__Get__Group__1 : rule__Get__Group__1__Impl rule__Get__Group__2 ;
    public final void rule__Get__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3651:1: ( rule__Get__Group__1__Impl rule__Get__Group__2 )
            // InternalFirstOrderLogic.g:3652:2: rule__Get__Group__1__Impl rule__Get__Group__2
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
    // InternalFirstOrderLogic.g:3659:1: rule__Get__Group__1__Impl : ( ( rule__Get__Group_1__0 )? ) ;
    public final void rule__Get__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3663:1: ( ( ( rule__Get__Group_1__0 )? ) )
            // InternalFirstOrderLogic.g:3664:1: ( ( rule__Get__Group_1__0 )? )
            {
            // InternalFirstOrderLogic.g:3664:1: ( ( rule__Get__Group_1__0 )? )
            // InternalFirstOrderLogic.g:3665:2: ( rule__Get__Group_1__0 )?
            {
             before(grammarAccess.getGetAccess().getGroup_1()); 
            // InternalFirstOrderLogic.g:3666:2: ( rule__Get__Group_1__0 )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==RULE_ID) ) {
                int LA15_1 = input.LA(2);

                if ( (LA15_1==38) ) {
                    alt15=1;
                }
            }
            switch (alt15) {
                case 1 :
                    // InternalFirstOrderLogic.g:3666:3: rule__Get__Group_1__0
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
    // InternalFirstOrderLogic.g:3674:1: rule__Get__Group__2 : rule__Get__Group__2__Impl rule__Get__Group__3 ;
    public final void rule__Get__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3678:1: ( rule__Get__Group__2__Impl rule__Get__Group__3 )
            // InternalFirstOrderLogic.g:3679:2: rule__Get__Group__2__Impl rule__Get__Group__3
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
    // InternalFirstOrderLogic.g:3686:1: rule__Get__Group__2__Impl : ( ( rule__Get__NameAssignment_2 ) ) ;
    public final void rule__Get__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3690:1: ( ( ( rule__Get__NameAssignment_2 ) ) )
            // InternalFirstOrderLogic.g:3691:1: ( ( rule__Get__NameAssignment_2 ) )
            {
            // InternalFirstOrderLogic.g:3691:1: ( ( rule__Get__NameAssignment_2 ) )
            // InternalFirstOrderLogic.g:3692:2: ( rule__Get__NameAssignment_2 )
            {
             before(grammarAccess.getGetAccess().getNameAssignment_2()); 
            // InternalFirstOrderLogic.g:3693:2: ( rule__Get__NameAssignment_2 )
            // InternalFirstOrderLogic.g:3693:3: rule__Get__NameAssignment_2
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
    // InternalFirstOrderLogic.g:3701:1: rule__Get__Group__3 : rule__Get__Group__3__Impl ;
    public final void rule__Get__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3705:1: ( rule__Get__Group__3__Impl )
            // InternalFirstOrderLogic.g:3706:2: rule__Get__Group__3__Impl
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
    // InternalFirstOrderLogic.g:3712:1: rule__Get__Group__3__Impl : ( ( rule__Get__NextAssignment_3 )? ) ;
    public final void rule__Get__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3716:1: ( ( ( rule__Get__NextAssignment_3 )? ) )
            // InternalFirstOrderLogic.g:3717:1: ( ( rule__Get__NextAssignment_3 )? )
            {
            // InternalFirstOrderLogic.g:3717:1: ( ( rule__Get__NextAssignment_3 )? )
            // InternalFirstOrderLogic.g:3718:2: ( rule__Get__NextAssignment_3 )?
            {
             before(grammarAccess.getGetAccess().getNextAssignment_3()); 
            // InternalFirstOrderLogic.g:3719:2: ( rule__Get__NextAssignment_3 )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==37) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalFirstOrderLogic.g:3719:3: rule__Get__NextAssignment_3
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
    // InternalFirstOrderLogic.g:3728:1: rule__Get__Group_1__0 : rule__Get__Group_1__0__Impl rule__Get__Group_1__1 ;
    public final void rule__Get__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3732:1: ( rule__Get__Group_1__0__Impl rule__Get__Group_1__1 )
            // InternalFirstOrderLogic.g:3733:2: rule__Get__Group_1__0__Impl rule__Get__Group_1__1
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
    // InternalFirstOrderLogic.g:3740:1: rule__Get__Group_1__0__Impl : ( ( rule__Get__TypeAssignment_1_0 ) ) ;
    public final void rule__Get__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3744:1: ( ( ( rule__Get__TypeAssignment_1_0 ) ) )
            // InternalFirstOrderLogic.g:3745:1: ( ( rule__Get__TypeAssignment_1_0 ) )
            {
            // InternalFirstOrderLogic.g:3745:1: ( ( rule__Get__TypeAssignment_1_0 ) )
            // InternalFirstOrderLogic.g:3746:2: ( rule__Get__TypeAssignment_1_0 )
            {
             before(grammarAccess.getGetAccess().getTypeAssignment_1_0()); 
            // InternalFirstOrderLogic.g:3747:2: ( rule__Get__TypeAssignment_1_0 )
            // InternalFirstOrderLogic.g:3747:3: rule__Get__TypeAssignment_1_0
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
    // InternalFirstOrderLogic.g:3755:1: rule__Get__Group_1__1 : rule__Get__Group_1__1__Impl ;
    public final void rule__Get__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3759:1: ( rule__Get__Group_1__1__Impl )
            // InternalFirstOrderLogic.g:3760:2: rule__Get__Group_1__1__Impl
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
    // InternalFirstOrderLogic.g:3766:1: rule__Get__Group_1__1__Impl : ( '::' ) ;
    public final void rule__Get__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3770:1: ( ( '::' ) )
            // InternalFirstOrderLogic.g:3771:1: ( '::' )
            {
            // InternalFirstOrderLogic.g:3771:1: ( '::' )
            // InternalFirstOrderLogic.g:3772:2: '::'
            {
             before(grammarAccess.getGetAccess().getColonColonKeyword_1_1()); 
            match(input,38,FOLLOW_2); 
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
    // InternalFirstOrderLogic.g:3782:1: rule__GetContainer__Group__0 : rule__GetContainer__Group__0__Impl rule__GetContainer__Group__1 ;
    public final void rule__GetContainer__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3786:1: ( rule__GetContainer__Group__0__Impl rule__GetContainer__Group__1 )
            // InternalFirstOrderLogic.g:3787:2: rule__GetContainer__Group__0__Impl rule__GetContainer__Group__1
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
    // InternalFirstOrderLogic.g:3794:1: rule__GetContainer__Group__0__Impl : ( 'getContainer(' ) ;
    public final void rule__GetContainer__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3798:1: ( ( 'getContainer(' ) )
            // InternalFirstOrderLogic.g:3799:1: ( 'getContainer(' )
            {
            // InternalFirstOrderLogic.g:3799:1: ( 'getContainer(' )
            // InternalFirstOrderLogic.g:3800:2: 'getContainer('
            {
             before(grammarAccess.getGetContainerAccess().getGetContainerKeyword_0()); 
            match(input,39,FOLLOW_2); 
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
    // InternalFirstOrderLogic.g:3809:1: rule__GetContainer__Group__1 : rule__GetContainer__Group__1__Impl rule__GetContainer__Group__2 ;
    public final void rule__GetContainer__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3813:1: ( rule__GetContainer__Group__1__Impl rule__GetContainer__Group__2 )
            // InternalFirstOrderLogic.g:3814:2: rule__GetContainer__Group__1__Impl rule__GetContainer__Group__2
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
    // InternalFirstOrderLogic.g:3821:1: rule__GetContainer__Group__1__Impl : ( ( rule__GetContainer__ElementAssignment_1 ) ) ;
    public final void rule__GetContainer__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3825:1: ( ( ( rule__GetContainer__ElementAssignment_1 ) ) )
            // InternalFirstOrderLogic.g:3826:1: ( ( rule__GetContainer__ElementAssignment_1 ) )
            {
            // InternalFirstOrderLogic.g:3826:1: ( ( rule__GetContainer__ElementAssignment_1 ) )
            // InternalFirstOrderLogic.g:3827:2: ( rule__GetContainer__ElementAssignment_1 )
            {
             before(grammarAccess.getGetContainerAccess().getElementAssignment_1()); 
            // InternalFirstOrderLogic.g:3828:2: ( rule__GetContainer__ElementAssignment_1 )
            // InternalFirstOrderLogic.g:3828:3: rule__GetContainer__ElementAssignment_1
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
    // InternalFirstOrderLogic.g:3836:1: rule__GetContainer__Group__2 : rule__GetContainer__Group__2__Impl ;
    public final void rule__GetContainer__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3840:1: ( rule__GetContainer__Group__2__Impl )
            // InternalFirstOrderLogic.g:3841:2: rule__GetContainer__Group__2__Impl
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
    // InternalFirstOrderLogic.g:3847:1: rule__GetContainer__Group__2__Impl : ( ')' ) ;
    public final void rule__GetContainer__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3851:1: ( ( ')' ) )
            // InternalFirstOrderLogic.g:3852:1: ( ')' )
            {
            // InternalFirstOrderLogic.g:3852:1: ( ')' )
            // InternalFirstOrderLogic.g:3853:2: ')'
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
    // InternalFirstOrderLogic.g:3863:1: rule__GetContainment__Group__0 : rule__GetContainment__Group__0__Impl rule__GetContainment__Group__1 ;
    public final void rule__GetContainment__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3867:1: ( rule__GetContainment__Group__0__Impl rule__GetContainment__Group__1 )
            // InternalFirstOrderLogic.g:3868:2: rule__GetContainment__Group__0__Impl rule__GetContainment__Group__1
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
    // InternalFirstOrderLogic.g:3875:1: rule__GetContainment__Group__0__Impl : ( 'getContainments(' ) ;
    public final void rule__GetContainment__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3879:1: ( ( 'getContainments(' ) )
            // InternalFirstOrderLogic.g:3880:1: ( 'getContainments(' )
            {
            // InternalFirstOrderLogic.g:3880:1: ( 'getContainments(' )
            // InternalFirstOrderLogic.g:3881:2: 'getContainments('
            {
             before(grammarAccess.getGetContainmentAccess().getGetContainmentsKeyword_0()); 
            match(input,40,FOLLOW_2); 
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
    // InternalFirstOrderLogic.g:3890:1: rule__GetContainment__Group__1 : rule__GetContainment__Group__1__Impl rule__GetContainment__Group__2 ;
    public final void rule__GetContainment__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3894:1: ( rule__GetContainment__Group__1__Impl rule__GetContainment__Group__2 )
            // InternalFirstOrderLogic.g:3895:2: rule__GetContainment__Group__1__Impl rule__GetContainment__Group__2
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
    // InternalFirstOrderLogic.g:3902:1: rule__GetContainment__Group__1__Impl : ( ( rule__GetContainment__ElementAssignment_1 ) ) ;
    public final void rule__GetContainment__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3906:1: ( ( ( rule__GetContainment__ElementAssignment_1 ) ) )
            // InternalFirstOrderLogic.g:3907:1: ( ( rule__GetContainment__ElementAssignment_1 ) )
            {
            // InternalFirstOrderLogic.g:3907:1: ( ( rule__GetContainment__ElementAssignment_1 ) )
            // InternalFirstOrderLogic.g:3908:2: ( rule__GetContainment__ElementAssignment_1 )
            {
             before(grammarAccess.getGetContainmentAccess().getElementAssignment_1()); 
            // InternalFirstOrderLogic.g:3909:2: ( rule__GetContainment__ElementAssignment_1 )
            // InternalFirstOrderLogic.g:3909:3: rule__GetContainment__ElementAssignment_1
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
    // InternalFirstOrderLogic.g:3917:1: rule__GetContainment__Group__2 : rule__GetContainment__Group__2__Impl ;
    public final void rule__GetContainment__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3921:1: ( rule__GetContainment__Group__2__Impl )
            // InternalFirstOrderLogic.g:3922:2: rule__GetContainment__Group__2__Impl
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
    // InternalFirstOrderLogic.g:3928:1: rule__GetContainment__Group__2__Impl : ( ')' ) ;
    public final void rule__GetContainment__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3932:1: ( ( ')' ) )
            // InternalFirstOrderLogic.g:3933:1: ( ')' )
            {
            // InternalFirstOrderLogic.g:3933:1: ( ')' )
            // InternalFirstOrderLogic.g:3934:2: ')'
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


    // $ANTLR start "rule__Constant__Group_0__0"
    // InternalFirstOrderLogic.g:3944:1: rule__Constant__Group_0__0 : rule__Constant__Group_0__0__Impl rule__Constant__Group_0__1 ;
    public final void rule__Constant__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3948:1: ( rule__Constant__Group_0__0__Impl rule__Constant__Group_0__1 )
            // InternalFirstOrderLogic.g:3949:2: rule__Constant__Group_0__0__Impl rule__Constant__Group_0__1
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
    // InternalFirstOrderLogic.g:3956:1: rule__Constant__Group_0__0__Impl : ( () ) ;
    public final void rule__Constant__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3960:1: ( ( () ) )
            // InternalFirstOrderLogic.g:3961:1: ( () )
            {
            // InternalFirstOrderLogic.g:3961:1: ( () )
            // InternalFirstOrderLogic.g:3962:2: ()
            {
             before(grammarAccess.getConstantAccess().getIntConstantAction_0_0()); 
            // InternalFirstOrderLogic.g:3963:2: ()
            // InternalFirstOrderLogic.g:3963:3: 
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
    // InternalFirstOrderLogic.g:3971:1: rule__Constant__Group_0__1 : rule__Constant__Group_0__1__Impl ;
    public final void rule__Constant__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3975:1: ( rule__Constant__Group_0__1__Impl )
            // InternalFirstOrderLogic.g:3976:2: rule__Constant__Group_0__1__Impl
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
    // InternalFirstOrderLogic.g:3982:1: rule__Constant__Group_0__1__Impl : ( ( rule__Constant__ValueAssignment_0_1 ) ) ;
    public final void rule__Constant__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3986:1: ( ( ( rule__Constant__ValueAssignment_0_1 ) ) )
            // InternalFirstOrderLogic.g:3987:1: ( ( rule__Constant__ValueAssignment_0_1 ) )
            {
            // InternalFirstOrderLogic.g:3987:1: ( ( rule__Constant__ValueAssignment_0_1 ) )
            // InternalFirstOrderLogic.g:3988:2: ( rule__Constant__ValueAssignment_0_1 )
            {
             before(grammarAccess.getConstantAccess().getValueAssignment_0_1()); 
            // InternalFirstOrderLogic.g:3989:2: ( rule__Constant__ValueAssignment_0_1 )
            // InternalFirstOrderLogic.g:3989:3: rule__Constant__ValueAssignment_0_1
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
    // InternalFirstOrderLogic.g:3998:1: rule__Constant__Group_1__0 : rule__Constant__Group_1__0__Impl rule__Constant__Group_1__1 ;
    public final void rule__Constant__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4002:1: ( rule__Constant__Group_1__0__Impl rule__Constant__Group_1__1 )
            // InternalFirstOrderLogic.g:4003:2: rule__Constant__Group_1__0__Impl rule__Constant__Group_1__1
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
    // InternalFirstOrderLogic.g:4010:1: rule__Constant__Group_1__0__Impl : ( () ) ;
    public final void rule__Constant__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4014:1: ( ( () ) )
            // InternalFirstOrderLogic.g:4015:1: ( () )
            {
            // InternalFirstOrderLogic.g:4015:1: ( () )
            // InternalFirstOrderLogic.g:4016:2: ()
            {
             before(grammarAccess.getConstantAccess().getStringConstantAction_1_0()); 
            // InternalFirstOrderLogic.g:4017:2: ()
            // InternalFirstOrderLogic.g:4017:3: 
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
    // InternalFirstOrderLogic.g:4025:1: rule__Constant__Group_1__1 : rule__Constant__Group_1__1__Impl ;
    public final void rule__Constant__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4029:1: ( rule__Constant__Group_1__1__Impl )
            // InternalFirstOrderLogic.g:4030:2: rule__Constant__Group_1__1__Impl
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
    // InternalFirstOrderLogic.g:4036:1: rule__Constant__Group_1__1__Impl : ( ( rule__Constant__ValueAssignment_1_1 ) ) ;
    public final void rule__Constant__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4040:1: ( ( ( rule__Constant__ValueAssignment_1_1 ) ) )
            // InternalFirstOrderLogic.g:4041:1: ( ( rule__Constant__ValueAssignment_1_1 ) )
            {
            // InternalFirstOrderLogic.g:4041:1: ( ( rule__Constant__ValueAssignment_1_1 ) )
            // InternalFirstOrderLogic.g:4042:2: ( rule__Constant__ValueAssignment_1_1 )
            {
             before(grammarAccess.getConstantAccess().getValueAssignment_1_1()); 
            // InternalFirstOrderLogic.g:4043:2: ( rule__Constant__ValueAssignment_1_1 )
            // InternalFirstOrderLogic.g:4043:3: rule__Constant__ValueAssignment_1_1
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
    // InternalFirstOrderLogic.g:4052:1: rule__ConstraintLibrary__DomainAssignment_1 : ( RULE_STRING ) ;
    public final void rule__ConstraintLibrary__DomainAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4056:1: ( ( RULE_STRING ) )
            // InternalFirstOrderLogic.g:4057:2: ( RULE_STRING )
            {
            // InternalFirstOrderLogic.g:4057:2: ( RULE_STRING )
            // InternalFirstOrderLogic.g:4058:3: RULE_STRING
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
    // InternalFirstOrderLogic.g:4067:1: rule__ConstraintLibrary__PackageImportAssignment_3 : ( RULE_STRING ) ;
    public final void rule__ConstraintLibrary__PackageImportAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4071:1: ( ( RULE_STRING ) )
            // InternalFirstOrderLogic.g:4072:2: ( RULE_STRING )
            {
            // InternalFirstOrderLogic.g:4072:2: ( RULE_STRING )
            // InternalFirstOrderLogic.g:4073:3: RULE_STRING
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
    // InternalFirstOrderLogic.g:4082:1: rule__ConstraintLibrary__ConstraintsAssignment_4 : ( ruleConstraint ) ;
    public final void rule__ConstraintLibrary__ConstraintsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4086:1: ( ( ruleConstraint ) )
            // InternalFirstOrderLogic.g:4087:2: ( ruleConstraint )
            {
            // InternalFirstOrderLogic.g:4087:2: ( ruleConstraint )
            // InternalFirstOrderLogic.g:4088:3: ruleConstraint
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
    // InternalFirstOrderLogic.g:4097:1: rule__Constraint__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Constraint__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4101:1: ( ( RULE_ID ) )
            // InternalFirstOrderLogic.g:4102:2: ( RULE_ID )
            {
            // InternalFirstOrderLogic.g:4102:2: ( RULE_ID )
            // InternalFirstOrderLogic.g:4103:3: RULE_ID
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
    // InternalFirstOrderLogic.g:4112:1: rule__Constraint__MessageAssignment_3 : ( RULE_STRING ) ;
    public final void rule__Constraint__MessageAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4116:1: ( ( RULE_STRING ) )
            // InternalFirstOrderLogic.g:4117:2: ( RULE_STRING )
            {
            // InternalFirstOrderLogic.g:4117:2: ( RULE_STRING )
            // InternalFirstOrderLogic.g:4118:3: RULE_STRING
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
    // InternalFirstOrderLogic.g:4127:1: rule__Constraint__VariableAssignment_5 : ( ruleVariable ) ;
    public final void rule__Constraint__VariableAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4131:1: ( ( ruleVariable ) )
            // InternalFirstOrderLogic.g:4132:2: ( ruleVariable )
            {
            // InternalFirstOrderLogic.g:4132:2: ( ruleVariable )
            // InternalFirstOrderLogic.g:4133:3: ruleVariable
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
    // InternalFirstOrderLogic.g:4142:1: rule__Constraint__FormulaAssignment_7 : ( ruleFormula ) ;
    public final void rule__Constraint__FormulaAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4146:1: ( ( ruleFormula ) )
            // InternalFirstOrderLogic.g:4147:2: ( ruleFormula )
            {
            // InternalFirstOrderLogic.g:4147:2: ( ruleFormula )
            // InternalFirstOrderLogic.g:4148:3: ruleFormula
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
    // InternalFirstOrderLogic.g:4157:1: rule__Variable__TypeAssignment_0 : ( RULE_ID ) ;
    public final void rule__Variable__TypeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4161:1: ( ( RULE_ID ) )
            // InternalFirstOrderLogic.g:4162:2: ( RULE_ID )
            {
            // InternalFirstOrderLogic.g:4162:2: ( RULE_ID )
            // InternalFirstOrderLogic.g:4163:3: RULE_ID
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
    // InternalFirstOrderLogic.g:4172:1: rule__Variable__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Variable__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4176:1: ( ( RULE_ID ) )
            // InternalFirstOrderLogic.g:4177:2: ( RULE_ID )
            {
            // InternalFirstOrderLogic.g:4177:2: ( RULE_ID )
            // InternalFirstOrderLogic.g:4178:3: RULE_ID
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
    // InternalFirstOrderLogic.g:4187:1: rule__Iff__RightAssignment_1_2 : ( ruleIf ) ;
    public final void rule__Iff__RightAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4191:1: ( ( ruleIf ) )
            // InternalFirstOrderLogic.g:4192:2: ( ruleIf )
            {
            // InternalFirstOrderLogic.g:4192:2: ( ruleIf )
            // InternalFirstOrderLogic.g:4193:3: ruleIf
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
    // InternalFirstOrderLogic.g:4202:1: rule__If__RightAssignment_1_2 : ( ruleXor ) ;
    public final void rule__If__RightAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4206:1: ( ( ruleXor ) )
            // InternalFirstOrderLogic.g:4207:2: ( ruleXor )
            {
            // InternalFirstOrderLogic.g:4207:2: ( ruleXor )
            // InternalFirstOrderLogic.g:4208:3: ruleXor
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
    // InternalFirstOrderLogic.g:4217:1: rule__Xor__RightAssignment_1_2 : ( ruleOr ) ;
    public final void rule__Xor__RightAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4221:1: ( ( ruleOr ) )
            // InternalFirstOrderLogic.g:4222:2: ( ruleOr )
            {
            // InternalFirstOrderLogic.g:4222:2: ( ruleOr )
            // InternalFirstOrderLogic.g:4223:3: ruleOr
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
    // InternalFirstOrderLogic.g:4232:1: rule__Or__RightAssignment_1_2 : ( ruleAnd ) ;
    public final void rule__Or__RightAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4236:1: ( ( ruleAnd ) )
            // InternalFirstOrderLogic.g:4237:2: ( ruleAnd )
            {
            // InternalFirstOrderLogic.g:4237:2: ( ruleAnd )
            // InternalFirstOrderLogic.g:4238:3: ruleAnd
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
    // InternalFirstOrderLogic.g:4247:1: rule__And__RightAssignment_1_2 : ( ruleBooleanExpression ) ;
    public final void rule__And__RightAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4251:1: ( ( ruleBooleanExpression ) )
            // InternalFirstOrderLogic.g:4252:2: ( ruleBooleanExpression )
            {
            // InternalFirstOrderLogic.g:4252:2: ( ruleBooleanExpression )
            // InternalFirstOrderLogic.g:4253:3: ruleBooleanExpression
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
    // InternalFirstOrderLogic.g:4262:1: rule__Not__NotAssignment_2 : ( ruleFormula ) ;
    public final void rule__Not__NotAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4266:1: ( ( ruleFormula ) )
            // InternalFirstOrderLogic.g:4267:2: ( ruleFormula )
            {
            // InternalFirstOrderLogic.g:4267:2: ( ruleFormula )
            // InternalFirstOrderLogic.g:4268:3: ruleFormula
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
    // InternalFirstOrderLogic.g:4277:1: rule__Equals__LeftAssignment_1 : ( ruleTerm ) ;
    public final void rule__Equals__LeftAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4281:1: ( ( ruleTerm ) )
            // InternalFirstOrderLogic.g:4282:2: ( ruleTerm )
            {
            // InternalFirstOrderLogic.g:4282:2: ( ruleTerm )
            // InternalFirstOrderLogic.g:4283:3: ruleTerm
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
    // InternalFirstOrderLogic.g:4292:1: rule__Equals__RightAssignment_3 : ( ruleTerm ) ;
    public final void rule__Equals__RightAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4296:1: ( ( ruleTerm ) )
            // InternalFirstOrderLogic.g:4297:2: ( ruleTerm )
            {
            // InternalFirstOrderLogic.g:4297:2: ( ruleTerm )
            // InternalFirstOrderLogic.g:4298:3: ruleTerm
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
    // InternalFirstOrderLogic.g:4307:1: rule__Greater__LeftAssignment_1 : ( ruleTerm ) ;
    public final void rule__Greater__LeftAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4311:1: ( ( ruleTerm ) )
            // InternalFirstOrderLogic.g:4312:2: ( ruleTerm )
            {
            // InternalFirstOrderLogic.g:4312:2: ( ruleTerm )
            // InternalFirstOrderLogic.g:4313:3: ruleTerm
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
    // InternalFirstOrderLogic.g:4322:1: rule__Greater__RightAssignment_3 : ( ruleTerm ) ;
    public final void rule__Greater__RightAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4326:1: ( ( ruleTerm ) )
            // InternalFirstOrderLogic.g:4327:2: ( ruleTerm )
            {
            // InternalFirstOrderLogic.g:4327:2: ( ruleTerm )
            // InternalFirstOrderLogic.g:4328:3: ruleTerm
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
    // InternalFirstOrderLogic.g:4337:1: rule__GreaterEqual__LeftAssignment_1 : ( ruleTerm ) ;
    public final void rule__GreaterEqual__LeftAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4341:1: ( ( ruleTerm ) )
            // InternalFirstOrderLogic.g:4342:2: ( ruleTerm )
            {
            // InternalFirstOrderLogic.g:4342:2: ( ruleTerm )
            // InternalFirstOrderLogic.g:4343:3: ruleTerm
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
    // InternalFirstOrderLogic.g:4352:1: rule__GreaterEqual__RightAssignment_3 : ( ruleTerm ) ;
    public final void rule__GreaterEqual__RightAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4356:1: ( ( ruleTerm ) )
            // InternalFirstOrderLogic.g:4357:2: ( ruleTerm )
            {
            // InternalFirstOrderLogic.g:4357:2: ( ruleTerm )
            // InternalFirstOrderLogic.g:4358:3: ruleTerm
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
    // InternalFirstOrderLogic.g:4367:1: rule__Smaller__LeftAssignment_1 : ( ruleTerm ) ;
    public final void rule__Smaller__LeftAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4371:1: ( ( ruleTerm ) )
            // InternalFirstOrderLogic.g:4372:2: ( ruleTerm )
            {
            // InternalFirstOrderLogic.g:4372:2: ( ruleTerm )
            // InternalFirstOrderLogic.g:4373:3: ruleTerm
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
    // InternalFirstOrderLogic.g:4382:1: rule__Smaller__RightAssignment_3 : ( ruleTerm ) ;
    public final void rule__Smaller__RightAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4386:1: ( ( ruleTerm ) )
            // InternalFirstOrderLogic.g:4387:2: ( ruleTerm )
            {
            // InternalFirstOrderLogic.g:4387:2: ( ruleTerm )
            // InternalFirstOrderLogic.g:4388:3: ruleTerm
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
    // InternalFirstOrderLogic.g:4397:1: rule__SmallerEqual__LeftAssignment_1 : ( ruleTerm ) ;
    public final void rule__SmallerEqual__LeftAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4401:1: ( ( ruleTerm ) )
            // InternalFirstOrderLogic.g:4402:2: ( ruleTerm )
            {
            // InternalFirstOrderLogic.g:4402:2: ( ruleTerm )
            // InternalFirstOrderLogic.g:4403:3: ruleTerm
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
    // InternalFirstOrderLogic.g:4412:1: rule__SmallerEqual__RightAssignment_3 : ( ruleTerm ) ;
    public final void rule__SmallerEqual__RightAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4416:1: ( ( ruleTerm ) )
            // InternalFirstOrderLogic.g:4417:2: ( ruleTerm )
            {
            // InternalFirstOrderLogic.g:4417:2: ( ruleTerm )
            // InternalFirstOrderLogic.g:4418:3: ruleTerm
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
    // InternalFirstOrderLogic.g:4427:1: rule__IsEmpty__TermAssignment_1 : ( ruleTerm ) ;
    public final void rule__IsEmpty__TermAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4431:1: ( ( ruleTerm ) )
            // InternalFirstOrderLogic.g:4432:2: ( ruleTerm )
            {
            // InternalFirstOrderLogic.g:4432:2: ( ruleTerm )
            // InternalFirstOrderLogic.g:4433:3: ruleTerm
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


    // $ANTLR start "rule__ForAll__NameAssignment_2"
    // InternalFirstOrderLogic.g:4442:1: rule__ForAll__NameAssignment_2 : ( ruleVariable ) ;
    public final void rule__ForAll__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4446:1: ( ( ruleVariable ) )
            // InternalFirstOrderLogic.g:4447:2: ( ruleVariable )
            {
            // InternalFirstOrderLogic.g:4447:2: ( ruleVariable )
            // InternalFirstOrderLogic.g:4448:3: ruleVariable
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
    // InternalFirstOrderLogic.g:4457:1: rule__ForAll__IterationAssignment_4 : ( ruleTerm ) ;
    public final void rule__ForAll__IterationAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4461:1: ( ( ruleTerm ) )
            // InternalFirstOrderLogic.g:4462:2: ( ruleTerm )
            {
            // InternalFirstOrderLogic.g:4462:2: ( ruleTerm )
            // InternalFirstOrderLogic.g:4463:3: ruleTerm
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
    // InternalFirstOrderLogic.g:4472:1: rule__ForAll__FormulaAssignment_6 : ( ruleFormula ) ;
    public final void rule__ForAll__FormulaAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4476:1: ( ( ruleFormula ) )
            // InternalFirstOrderLogic.g:4477:2: ( ruleFormula )
            {
            // InternalFirstOrderLogic.g:4477:2: ( ruleFormula )
            // InternalFirstOrderLogic.g:4478:3: ruleFormula
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
    // InternalFirstOrderLogic.g:4487:1: rule__Exists__NameAssignment_2 : ( ruleVariable ) ;
    public final void rule__Exists__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4491:1: ( ( ruleVariable ) )
            // InternalFirstOrderLogic.g:4492:2: ( ruleVariable )
            {
            // InternalFirstOrderLogic.g:4492:2: ( ruleVariable )
            // InternalFirstOrderLogic.g:4493:3: ruleVariable
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
    // InternalFirstOrderLogic.g:4502:1: rule__Exists__IterationAssignment_4 : ( ruleTerm ) ;
    public final void rule__Exists__IterationAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4506:1: ( ( ruleTerm ) )
            // InternalFirstOrderLogic.g:4507:2: ( ruleTerm )
            {
            // InternalFirstOrderLogic.g:4507:2: ( ruleTerm )
            // InternalFirstOrderLogic.g:4508:3: ruleTerm
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
    // InternalFirstOrderLogic.g:4517:1: rule__Exists__FormulaAssignment_6 : ( ruleFormula ) ;
    public final void rule__Exists__FormulaAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4521:1: ( ( ruleFormula ) )
            // InternalFirstOrderLogic.g:4522:2: ( ruleFormula )
            {
            // InternalFirstOrderLogic.g:4522:2: ( ruleFormula )
            // InternalFirstOrderLogic.g:4523:3: ruleFormula
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
    // InternalFirstOrderLogic.g:4532:1: rule__BoolConstant__ValueAssignment_1 : ( ( rule__BoolConstant__ValueAlternatives_1_0 ) ) ;
    public final void rule__BoolConstant__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4536:1: ( ( ( rule__BoolConstant__ValueAlternatives_1_0 ) ) )
            // InternalFirstOrderLogic.g:4537:2: ( ( rule__BoolConstant__ValueAlternatives_1_0 ) )
            {
            // InternalFirstOrderLogic.g:4537:2: ( ( rule__BoolConstant__ValueAlternatives_1_0 ) )
            // InternalFirstOrderLogic.g:4538:3: ( rule__BoolConstant__ValueAlternatives_1_0 )
            {
             before(grammarAccess.getBoolConstantAccess().getValueAlternatives_1_0()); 
            // InternalFirstOrderLogic.g:4539:3: ( rule__BoolConstant__ValueAlternatives_1_0 )
            // InternalFirstOrderLogic.g:4539:4: rule__BoolConstant__ValueAlternatives_1_0
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
    // InternalFirstOrderLogic.g:4547:1: rule__VariableRef__NameAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__VariableRef__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4551:1: ( ( ( RULE_ID ) ) )
            // InternalFirstOrderLogic.g:4552:2: ( ( RULE_ID ) )
            {
            // InternalFirstOrderLogic.g:4552:2: ( ( RULE_ID ) )
            // InternalFirstOrderLogic.g:4553:3: ( RULE_ID )
            {
             before(grammarAccess.getVariableRefAccess().getNameVariableCrossReference_1_0()); 
            // InternalFirstOrderLogic.g:4554:3: ( RULE_ID )
            // InternalFirstOrderLogic.g:4555:4: RULE_ID
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
    // InternalFirstOrderLogic.g:4566:1: rule__VariableRef__GetAssignment_2 : ( ruleGet ) ;
    public final void rule__VariableRef__GetAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4570:1: ( ( ruleGet ) )
            // InternalFirstOrderLogic.g:4571:2: ( ruleGet )
            {
            // InternalFirstOrderLogic.g:4571:2: ( ruleGet )
            // InternalFirstOrderLogic.g:4572:3: ruleGet
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
    // InternalFirstOrderLogic.g:4581:1: rule__Get__TypeAssignment_1_0 : ( RULE_ID ) ;
    public final void rule__Get__TypeAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4585:1: ( ( RULE_ID ) )
            // InternalFirstOrderLogic.g:4586:2: ( RULE_ID )
            {
            // InternalFirstOrderLogic.g:4586:2: ( RULE_ID )
            // InternalFirstOrderLogic.g:4587:3: RULE_ID
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
    // InternalFirstOrderLogic.g:4596:1: rule__Get__NameAssignment_2 : ( ( RULE_ID ) ) ;
    public final void rule__Get__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4600:1: ( ( ( RULE_ID ) ) )
            // InternalFirstOrderLogic.g:4601:2: ( ( RULE_ID ) )
            {
            // InternalFirstOrderLogic.g:4601:2: ( ( RULE_ID ) )
            // InternalFirstOrderLogic.g:4602:3: ( RULE_ID )
            {
             before(grammarAccess.getGetAccess().getNameEStructuralFeatureCrossReference_2_0()); 
            // InternalFirstOrderLogic.g:4603:3: ( RULE_ID )
            // InternalFirstOrderLogic.g:4604:4: RULE_ID
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
    // InternalFirstOrderLogic.g:4615:1: rule__Get__NextAssignment_3 : ( ruleGet ) ;
    public final void rule__Get__NextAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4619:1: ( ( ruleGet ) )
            // InternalFirstOrderLogic.g:4620:2: ( ruleGet )
            {
            // InternalFirstOrderLogic.g:4620:2: ( ruleGet )
            // InternalFirstOrderLogic.g:4621:3: ruleGet
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
    // InternalFirstOrderLogic.g:4630:1: rule__GetContainer__ElementAssignment_1 : ( ruleTerm ) ;
    public final void rule__GetContainer__ElementAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4634:1: ( ( ruleTerm ) )
            // InternalFirstOrderLogic.g:4635:2: ( ruleTerm )
            {
            // InternalFirstOrderLogic.g:4635:2: ( ruleTerm )
            // InternalFirstOrderLogic.g:4636:3: ruleTerm
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
    // InternalFirstOrderLogic.g:4645:1: rule__GetContainment__ElementAssignment_1 : ( ruleTerm ) ;
    public final void rule__GetContainment__ElementAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4649:1: ( ( ruleTerm ) )
            // InternalFirstOrderLogic.g:4650:2: ( ruleTerm )
            {
            // InternalFirstOrderLogic.g:4650:2: ( ruleTerm )
            // InternalFirstOrderLogic.g:4651:3: ruleTerm
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


    // $ANTLR start "rule__Constant__ValueAssignment_0_1"
    // InternalFirstOrderLogic.g:4660:1: rule__Constant__ValueAssignment_0_1 : ( RULE_INT ) ;
    public final void rule__Constant__ValueAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4664:1: ( ( RULE_INT ) )
            // InternalFirstOrderLogic.g:4665:2: ( RULE_INT )
            {
            // InternalFirstOrderLogic.g:4665:2: ( RULE_INT )
            // InternalFirstOrderLogic.g:4666:3: RULE_INT
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
    // InternalFirstOrderLogic.g:4675:1: rule__Constant__ValueAssignment_1_1 : ( RULE_STRING ) ;
    public final void rule__Constant__ValueAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4679:1: ( ( RULE_STRING ) )
            // InternalFirstOrderLogic.g:4680:2: ( RULE_STRING )
            {
            // InternalFirstOrderLogic.g:4680:2: ( RULE_STRING )
            // InternalFirstOrderLogic.g:4681:3: RULE_STRING
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
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000001BF5001800L});
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
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000019BF5001870L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000A00000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000000000040L});

}