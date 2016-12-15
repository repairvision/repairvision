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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'true'", "'false'", "'domain'", "'context'", "':'", "'.'", "'::'", "'implies'", "'xor'", "'or'", "'and'", "'not('", "')'", "'forAll('", "'in'", "'exists('", "'('"
    };
    public static final int RULE_STRING=5;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int RULE_INT=6;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
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



    // $ANTLR start "entryRuleConstraintRuleBase"
    // InternalFirstOrderLogic.g:53:1: entryRuleConstraintRuleBase : ruleConstraintRuleBase EOF ;
    public final void entryRuleConstraintRuleBase() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:54:1: ( ruleConstraintRuleBase EOF )
            // InternalFirstOrderLogic.g:55:1: ruleConstraintRuleBase EOF
            {
             before(grammarAccess.getConstraintRuleBaseRule()); 
            pushFollow(FOLLOW_1);
            ruleConstraintRuleBase();

            state._fsp--;

             after(grammarAccess.getConstraintRuleBaseRule()); 
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
    // $ANTLR end "entryRuleConstraintRuleBase"


    // $ANTLR start "ruleConstraintRuleBase"
    // InternalFirstOrderLogic.g:62:1: ruleConstraintRuleBase : ( ( rule__ConstraintRuleBase__Group__0 ) ) ;
    public final void ruleConstraintRuleBase() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:66:2: ( ( ( rule__ConstraintRuleBase__Group__0 ) ) )
            // InternalFirstOrderLogic.g:67:2: ( ( rule__ConstraintRuleBase__Group__0 ) )
            {
            // InternalFirstOrderLogic.g:67:2: ( ( rule__ConstraintRuleBase__Group__0 ) )
            // InternalFirstOrderLogic.g:68:3: ( rule__ConstraintRuleBase__Group__0 )
            {
             before(grammarAccess.getConstraintRuleBaseAccess().getGroup()); 
            // InternalFirstOrderLogic.g:69:3: ( rule__ConstraintRuleBase__Group__0 )
            // InternalFirstOrderLogic.g:69:4: rule__ConstraintRuleBase__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ConstraintRuleBase__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getConstraintRuleBaseAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleConstraintRuleBase"


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


    // $ANTLR start "entryRuleTerm"
    // InternalFirstOrderLogic.g:128:1: entryRuleTerm : ruleTerm EOF ;
    public final void entryRuleTerm() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:129:1: ( ruleTerm EOF )
            // InternalFirstOrderLogic.g:130:1: ruleTerm EOF
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
    // InternalFirstOrderLogic.g:137:1: ruleTerm : ( ruleFunction ) ;
    public final void ruleTerm() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:141:2: ( ( ruleFunction ) )
            // InternalFirstOrderLogic.g:142:2: ( ruleFunction )
            {
            // InternalFirstOrderLogic.g:142:2: ( ruleFunction )
            // InternalFirstOrderLogic.g:143:3: ruleFunction
            {
             before(grammarAccess.getTermAccess().getFunctionParserRuleCall()); 
            pushFollow(FOLLOW_2);
            ruleFunction();

            state._fsp--;

             after(grammarAccess.getTermAccess().getFunctionParserRuleCall()); 

            }


            }

        }
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


    // $ANTLR start "entryRuleFunction"
    // InternalFirstOrderLogic.g:153:1: entryRuleFunction : ruleFunction EOF ;
    public final void entryRuleFunction() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:154:1: ( ruleFunction EOF )
            // InternalFirstOrderLogic.g:155:1: ruleFunction EOF
            {
             before(grammarAccess.getFunctionRule()); 
            pushFollow(FOLLOW_1);
            ruleFunction();

            state._fsp--;

             after(grammarAccess.getFunctionRule()); 
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
    // $ANTLR end "entryRuleFunction"


    // $ANTLR start "ruleFunction"
    // InternalFirstOrderLogic.g:162:1: ruleFunction : ( ruleGetTerm ) ;
    public final void ruleFunction() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:166:2: ( ( ruleGetTerm ) )
            // InternalFirstOrderLogic.g:167:2: ( ruleGetTerm )
            {
            // InternalFirstOrderLogic.g:167:2: ( ruleGetTerm )
            // InternalFirstOrderLogic.g:168:3: ruleGetTerm
            {
             before(grammarAccess.getFunctionAccess().getGetTermParserRuleCall()); 
            pushFollow(FOLLOW_2);
            ruleGetTerm();

            state._fsp--;

             after(grammarAccess.getFunctionAccess().getGetTermParserRuleCall()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleFunction"


    // $ANTLR start "entryRuleGetTerm"
    // InternalFirstOrderLogic.g:178:1: entryRuleGetTerm : ruleGetTerm EOF ;
    public final void entryRuleGetTerm() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:179:1: ( ruleGetTerm EOF )
            // InternalFirstOrderLogic.g:180:1: ruleGetTerm EOF
            {
             before(grammarAccess.getGetTermRule()); 
            pushFollow(FOLLOW_1);
            ruleGetTerm();

            state._fsp--;

             after(grammarAccess.getGetTermRule()); 
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
    // $ANTLR end "entryRuleGetTerm"


    // $ANTLR start "ruleGetTerm"
    // InternalFirstOrderLogic.g:187:1: ruleGetTerm : ( ( rule__GetTerm__Group__0 ) ) ;
    public final void ruleGetTerm() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:191:2: ( ( ( rule__GetTerm__Group__0 ) ) )
            // InternalFirstOrderLogic.g:192:2: ( ( rule__GetTerm__Group__0 ) )
            {
            // InternalFirstOrderLogic.g:192:2: ( ( rule__GetTerm__Group__0 ) )
            // InternalFirstOrderLogic.g:193:3: ( rule__GetTerm__Group__0 )
            {
             before(grammarAccess.getGetTermAccess().getGroup()); 
            // InternalFirstOrderLogic.g:194:3: ( rule__GetTerm__Group__0 )
            // InternalFirstOrderLogic.g:194:4: rule__GetTerm__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__GetTerm__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getGetTermAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleGetTerm"


    // $ANTLR start "entryRuleGet"
    // InternalFirstOrderLogic.g:203:1: entryRuleGet : ruleGet EOF ;
    public final void entryRuleGet() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:204:1: ( ruleGet EOF )
            // InternalFirstOrderLogic.g:205:1: ruleGet EOF
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
    // InternalFirstOrderLogic.g:212:1: ruleGet : ( ( rule__Get__Group__0 ) ) ;
    public final void ruleGet() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:216:2: ( ( ( rule__Get__Group__0 ) ) )
            // InternalFirstOrderLogic.g:217:2: ( ( rule__Get__Group__0 ) )
            {
            // InternalFirstOrderLogic.g:217:2: ( ( rule__Get__Group__0 ) )
            // InternalFirstOrderLogic.g:218:3: ( rule__Get__Group__0 )
            {
             before(grammarAccess.getGetAccess().getGroup()); 
            // InternalFirstOrderLogic.g:219:3: ( rule__Get__Group__0 )
            // InternalFirstOrderLogic.g:219:4: rule__Get__Group__0
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


    // $ANTLR start "entryRuleFeature"
    // InternalFirstOrderLogic.g:228:1: entryRuleFeature : ruleFeature EOF ;
    public final void entryRuleFeature() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:229:1: ( ruleFeature EOF )
            // InternalFirstOrderLogic.g:230:1: ruleFeature EOF
            {
             before(grammarAccess.getFeatureRule()); 
            pushFollow(FOLLOW_1);
            ruleFeature();

            state._fsp--;

             after(grammarAccess.getFeatureRule()); 
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
    // $ANTLR end "entryRuleFeature"


    // $ANTLR start "ruleFeature"
    // InternalFirstOrderLogic.g:237:1: ruleFeature : ( RULE_ID ) ;
    public final void ruleFeature() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:241:2: ( ( RULE_ID ) )
            // InternalFirstOrderLogic.g:242:2: ( RULE_ID )
            {
            // InternalFirstOrderLogic.g:242:2: ( RULE_ID )
            // InternalFirstOrderLogic.g:243:3: RULE_ID
            {
             before(grammarAccess.getFeatureAccess().getIDTerminalRuleCall()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getFeatureAccess().getIDTerminalRuleCall()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleFeature"


    // $ANTLR start "entryRuleFormula"
    // InternalFirstOrderLogic.g:253:1: entryRuleFormula : ruleFormula EOF ;
    public final void entryRuleFormula() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:254:1: ( ruleFormula EOF )
            // InternalFirstOrderLogic.g:255:1: ruleFormula EOF
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
    // InternalFirstOrderLogic.g:262:1: ruleFormula : ( ruleBinaryFormula ) ;
    public final void ruleFormula() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:266:2: ( ( ruleBinaryFormula ) )
            // InternalFirstOrderLogic.g:267:2: ( ruleBinaryFormula )
            {
            // InternalFirstOrderLogic.g:267:2: ( ruleBinaryFormula )
            // InternalFirstOrderLogic.g:268:3: ruleBinaryFormula
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
    // InternalFirstOrderLogic.g:278:1: entryRuleBinaryFormula : ruleBinaryFormula EOF ;
    public final void entryRuleBinaryFormula() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:279:1: ( ruleBinaryFormula EOF )
            // InternalFirstOrderLogic.g:280:1: ruleBinaryFormula EOF
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
    // InternalFirstOrderLogic.g:287:1: ruleBinaryFormula : ( ruleIf ) ;
    public final void ruleBinaryFormula() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:291:2: ( ( ruleIf ) )
            // InternalFirstOrderLogic.g:292:2: ( ruleIf )
            {
            // InternalFirstOrderLogic.g:292:2: ( ruleIf )
            // InternalFirstOrderLogic.g:293:3: ruleIf
            {
             before(grammarAccess.getBinaryFormulaAccess().getIfParserRuleCall()); 
            pushFollow(FOLLOW_2);
            ruleIf();

            state._fsp--;

             after(grammarAccess.getBinaryFormulaAccess().getIfParserRuleCall()); 

            }


            }

        }
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


    // $ANTLR start "entryRuleIf"
    // InternalFirstOrderLogic.g:303:1: entryRuleIf : ruleIf EOF ;
    public final void entryRuleIf() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:304:1: ( ruleIf EOF )
            // InternalFirstOrderLogic.g:305:1: ruleIf EOF
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
    // InternalFirstOrderLogic.g:312:1: ruleIf : ( ( rule__If__Group__0 ) ) ;
    public final void ruleIf() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:316:2: ( ( ( rule__If__Group__0 ) ) )
            // InternalFirstOrderLogic.g:317:2: ( ( rule__If__Group__0 ) )
            {
            // InternalFirstOrderLogic.g:317:2: ( ( rule__If__Group__0 ) )
            // InternalFirstOrderLogic.g:318:3: ( rule__If__Group__0 )
            {
             before(grammarAccess.getIfAccess().getGroup()); 
            // InternalFirstOrderLogic.g:319:3: ( rule__If__Group__0 )
            // InternalFirstOrderLogic.g:319:4: rule__If__Group__0
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
    // InternalFirstOrderLogic.g:328:1: entryRuleXor : ruleXor EOF ;
    public final void entryRuleXor() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:329:1: ( ruleXor EOF )
            // InternalFirstOrderLogic.g:330:1: ruleXor EOF
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
    // InternalFirstOrderLogic.g:337:1: ruleXor : ( ( rule__Xor__Group__0 ) ) ;
    public final void ruleXor() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:341:2: ( ( ( rule__Xor__Group__0 ) ) )
            // InternalFirstOrderLogic.g:342:2: ( ( rule__Xor__Group__0 ) )
            {
            // InternalFirstOrderLogic.g:342:2: ( ( rule__Xor__Group__0 ) )
            // InternalFirstOrderLogic.g:343:3: ( rule__Xor__Group__0 )
            {
             before(grammarAccess.getXorAccess().getGroup()); 
            // InternalFirstOrderLogic.g:344:3: ( rule__Xor__Group__0 )
            // InternalFirstOrderLogic.g:344:4: rule__Xor__Group__0
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
    // InternalFirstOrderLogic.g:353:1: entryRuleOr : ruleOr EOF ;
    public final void entryRuleOr() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:354:1: ( ruleOr EOF )
            // InternalFirstOrderLogic.g:355:1: ruleOr EOF
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
    // InternalFirstOrderLogic.g:362:1: ruleOr : ( ( rule__Or__Group__0 ) ) ;
    public final void ruleOr() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:366:2: ( ( ( rule__Or__Group__0 ) ) )
            // InternalFirstOrderLogic.g:367:2: ( ( rule__Or__Group__0 ) )
            {
            // InternalFirstOrderLogic.g:367:2: ( ( rule__Or__Group__0 ) )
            // InternalFirstOrderLogic.g:368:3: ( rule__Or__Group__0 )
            {
             before(grammarAccess.getOrAccess().getGroup()); 
            // InternalFirstOrderLogic.g:369:3: ( rule__Or__Group__0 )
            // InternalFirstOrderLogic.g:369:4: rule__Or__Group__0
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
    // InternalFirstOrderLogic.g:378:1: entryRuleAnd : ruleAnd EOF ;
    public final void entryRuleAnd() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:379:1: ( ruleAnd EOF )
            // InternalFirstOrderLogic.g:380:1: ruleAnd EOF
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
    // InternalFirstOrderLogic.g:387:1: ruleAnd : ( ( rule__And__Group__0 ) ) ;
    public final void ruleAnd() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:391:2: ( ( ( rule__And__Group__0 ) ) )
            // InternalFirstOrderLogic.g:392:2: ( ( rule__And__Group__0 ) )
            {
            // InternalFirstOrderLogic.g:392:2: ( ( rule__And__Group__0 ) )
            // InternalFirstOrderLogic.g:393:3: ( rule__And__Group__0 )
            {
             before(grammarAccess.getAndAccess().getGroup()); 
            // InternalFirstOrderLogic.g:394:3: ( rule__And__Group__0 )
            // InternalFirstOrderLogic.g:394:4: rule__And__Group__0
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
    // InternalFirstOrderLogic.g:403:1: entryRuleUnaryFormula : ruleUnaryFormula EOF ;
    public final void entryRuleUnaryFormula() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:404:1: ( ruleUnaryFormula EOF )
            // InternalFirstOrderLogic.g:405:1: ruleUnaryFormula EOF
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
    // InternalFirstOrderLogic.g:412:1: ruleUnaryFormula : ( ruleNot ) ;
    public final void ruleUnaryFormula() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:416:2: ( ( ruleNot ) )
            // InternalFirstOrderLogic.g:417:2: ( ruleNot )
            {
            // InternalFirstOrderLogic.g:417:2: ( ruleNot )
            // InternalFirstOrderLogic.g:418:3: ruleNot
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
    // InternalFirstOrderLogic.g:428:1: entryRuleNot : ruleNot EOF ;
    public final void entryRuleNot() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:429:1: ( ruleNot EOF )
            // InternalFirstOrderLogic.g:430:1: ruleNot EOF
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
    // InternalFirstOrderLogic.g:437:1: ruleNot : ( ( rule__Not__Group__0 ) ) ;
    public final void ruleNot() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:441:2: ( ( ( rule__Not__Group__0 ) ) )
            // InternalFirstOrderLogic.g:442:2: ( ( rule__Not__Group__0 ) )
            {
            // InternalFirstOrderLogic.g:442:2: ( ( rule__Not__Group__0 ) )
            // InternalFirstOrderLogic.g:443:3: ( rule__Not__Group__0 )
            {
             before(grammarAccess.getNotAccess().getGroup()); 
            // InternalFirstOrderLogic.g:444:3: ( rule__Not__Group__0 )
            // InternalFirstOrderLogic.g:444:4: rule__Not__Group__0
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


    // $ANTLR start "entryRuleQuantifier"
    // InternalFirstOrderLogic.g:453:1: entryRuleQuantifier : ruleQuantifier EOF ;
    public final void entryRuleQuantifier() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:454:1: ( ruleQuantifier EOF )
            // InternalFirstOrderLogic.g:455:1: ruleQuantifier EOF
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
    // InternalFirstOrderLogic.g:462:1: ruleQuantifier : ( ( rule__Quantifier__Alternatives ) ) ;
    public final void ruleQuantifier() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:466:2: ( ( ( rule__Quantifier__Alternatives ) ) )
            // InternalFirstOrderLogic.g:467:2: ( ( rule__Quantifier__Alternatives ) )
            {
            // InternalFirstOrderLogic.g:467:2: ( ( rule__Quantifier__Alternatives ) )
            // InternalFirstOrderLogic.g:468:3: ( rule__Quantifier__Alternatives )
            {
             before(grammarAccess.getQuantifierAccess().getAlternatives()); 
            // InternalFirstOrderLogic.g:469:3: ( rule__Quantifier__Alternatives )
            // InternalFirstOrderLogic.g:469:4: rule__Quantifier__Alternatives
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
    // InternalFirstOrderLogic.g:478:1: entryRuleForAll : ruleForAll EOF ;
    public final void entryRuleForAll() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:479:1: ( ruleForAll EOF )
            // InternalFirstOrderLogic.g:480:1: ruleForAll EOF
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
    // InternalFirstOrderLogic.g:487:1: ruleForAll : ( ( rule__ForAll__Group__0 ) ) ;
    public final void ruleForAll() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:491:2: ( ( ( rule__ForAll__Group__0 ) ) )
            // InternalFirstOrderLogic.g:492:2: ( ( rule__ForAll__Group__0 ) )
            {
            // InternalFirstOrderLogic.g:492:2: ( ( rule__ForAll__Group__0 ) )
            // InternalFirstOrderLogic.g:493:3: ( rule__ForAll__Group__0 )
            {
             before(grammarAccess.getForAllAccess().getGroup()); 
            // InternalFirstOrderLogic.g:494:3: ( rule__ForAll__Group__0 )
            // InternalFirstOrderLogic.g:494:4: rule__ForAll__Group__0
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
    // InternalFirstOrderLogic.g:503:1: entryRuleExists : ruleExists EOF ;
    public final void entryRuleExists() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:504:1: ( ruleExists EOF )
            // InternalFirstOrderLogic.g:505:1: ruleExists EOF
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
    // InternalFirstOrderLogic.g:512:1: ruleExists : ( ( rule__Exists__Group__0 ) ) ;
    public final void ruleExists() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:516:2: ( ( ( rule__Exists__Group__0 ) ) )
            // InternalFirstOrderLogic.g:517:2: ( ( rule__Exists__Group__0 ) )
            {
            // InternalFirstOrderLogic.g:517:2: ( ( rule__Exists__Group__0 ) )
            // InternalFirstOrderLogic.g:518:3: ( rule__Exists__Group__0 )
            {
             before(grammarAccess.getExistsAccess().getGroup()); 
            // InternalFirstOrderLogic.g:519:3: ( rule__Exists__Group__0 )
            // InternalFirstOrderLogic.g:519:4: rule__Exists__Group__0
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


    // $ANTLR start "entryRulePrimary"
    // InternalFirstOrderLogic.g:528:1: entryRulePrimary : rulePrimary EOF ;
    public final void entryRulePrimary() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:529:1: ( rulePrimary EOF )
            // InternalFirstOrderLogic.g:530:1: rulePrimary EOF
            {
             before(grammarAccess.getPrimaryRule()); 
            pushFollow(FOLLOW_1);
            rulePrimary();

            state._fsp--;

             after(grammarAccess.getPrimaryRule()); 
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
    // $ANTLR end "entryRulePrimary"


    // $ANTLR start "rulePrimary"
    // InternalFirstOrderLogic.g:537:1: rulePrimary : ( ( rule__Primary__Alternatives ) ) ;
    public final void rulePrimary() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:541:2: ( ( ( rule__Primary__Alternatives ) ) )
            // InternalFirstOrderLogic.g:542:2: ( ( rule__Primary__Alternatives ) )
            {
            // InternalFirstOrderLogic.g:542:2: ( ( rule__Primary__Alternatives ) )
            // InternalFirstOrderLogic.g:543:3: ( rule__Primary__Alternatives )
            {
             before(grammarAccess.getPrimaryAccess().getAlternatives()); 
            // InternalFirstOrderLogic.g:544:3: ( rule__Primary__Alternatives )
            // InternalFirstOrderLogic.g:544:4: rule__Primary__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Primary__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getPrimaryAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePrimary"


    // $ANTLR start "entryRuleTerminalExpression"
    // InternalFirstOrderLogic.g:553:1: entryRuleTerminalExpression : ruleTerminalExpression EOF ;
    public final void entryRuleTerminalExpression() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:554:1: ( ruleTerminalExpression EOF )
            // InternalFirstOrderLogic.g:555:1: ruleTerminalExpression EOF
            {
             before(grammarAccess.getTerminalExpressionRule()); 
            pushFollow(FOLLOW_1);
            ruleTerminalExpression();

            state._fsp--;

             after(grammarAccess.getTerminalExpressionRule()); 
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
    // $ANTLR end "entryRuleTerminalExpression"


    // $ANTLR start "ruleTerminalExpression"
    // InternalFirstOrderLogic.g:562:1: ruleTerminalExpression : ( ( rule__TerminalExpression__Alternatives ) ) ;
    public final void ruleTerminalExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:566:2: ( ( ( rule__TerminalExpression__Alternatives ) ) )
            // InternalFirstOrderLogic.g:567:2: ( ( rule__TerminalExpression__Alternatives ) )
            {
            // InternalFirstOrderLogic.g:567:2: ( ( rule__TerminalExpression__Alternatives ) )
            // InternalFirstOrderLogic.g:568:3: ( rule__TerminalExpression__Alternatives )
            {
             before(grammarAccess.getTerminalExpressionAccess().getAlternatives()); 
            // InternalFirstOrderLogic.g:569:3: ( rule__TerminalExpression__Alternatives )
            // InternalFirstOrderLogic.g:569:4: rule__TerminalExpression__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__TerminalExpression__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getTerminalExpressionAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTerminalExpression"


    // $ANTLR start "rule__Quantifier__Alternatives"
    // InternalFirstOrderLogic.g:577:1: rule__Quantifier__Alternatives : ( ( ruleForAll ) | ( ruleExists ) );
    public final void rule__Quantifier__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:581:1: ( ( ruleForAll ) | ( ruleExists ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==24) ) {
                alt1=1;
            }
            else if ( (LA1_0==26) ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // InternalFirstOrderLogic.g:582:2: ( ruleForAll )
                    {
                    // InternalFirstOrderLogic.g:582:2: ( ruleForAll )
                    // InternalFirstOrderLogic.g:583:3: ruleForAll
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
                    // InternalFirstOrderLogic.g:588:2: ( ruleExists )
                    {
                    // InternalFirstOrderLogic.g:588:2: ( ruleExists )
                    // InternalFirstOrderLogic.g:589:3: ruleExists
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


    // $ANTLR start "rule__Primary__Alternatives"
    // InternalFirstOrderLogic.g:598:1: rule__Primary__Alternatives : ( ( ( rule__Primary__Group_0__0 ) ) | ( ruleUnaryFormula ) | ( ruleQuantifier ) | ( ruleTerminalExpression ) );
    public final void rule__Primary__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:602:1: ( ( ( rule__Primary__Group_0__0 ) ) | ( ruleUnaryFormula ) | ( ruleQuantifier ) | ( ruleTerminalExpression ) )
            int alt2=4;
            switch ( input.LA(1) ) {
            case 27:
                {
                alt2=1;
                }
                break;
            case 22:
                {
                alt2=2;
                }
                break;
            case 24:
            case 26:
                {
                alt2=3;
                }
                break;
            case RULE_ID:
            case RULE_STRING:
            case RULE_INT:
            case 11:
            case 12:
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
                    // InternalFirstOrderLogic.g:603:2: ( ( rule__Primary__Group_0__0 ) )
                    {
                    // InternalFirstOrderLogic.g:603:2: ( ( rule__Primary__Group_0__0 ) )
                    // InternalFirstOrderLogic.g:604:3: ( rule__Primary__Group_0__0 )
                    {
                     before(grammarAccess.getPrimaryAccess().getGroup_0()); 
                    // InternalFirstOrderLogic.g:605:3: ( rule__Primary__Group_0__0 )
                    // InternalFirstOrderLogic.g:605:4: rule__Primary__Group_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Primary__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getPrimaryAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalFirstOrderLogic.g:609:2: ( ruleUnaryFormula )
                    {
                    // InternalFirstOrderLogic.g:609:2: ( ruleUnaryFormula )
                    // InternalFirstOrderLogic.g:610:3: ruleUnaryFormula
                    {
                     before(grammarAccess.getPrimaryAccess().getUnaryFormulaParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleUnaryFormula();

                    state._fsp--;

                     after(grammarAccess.getPrimaryAccess().getUnaryFormulaParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalFirstOrderLogic.g:615:2: ( ruleQuantifier )
                    {
                    // InternalFirstOrderLogic.g:615:2: ( ruleQuantifier )
                    // InternalFirstOrderLogic.g:616:3: ruleQuantifier
                    {
                     before(grammarAccess.getPrimaryAccess().getQuantifierParserRuleCall_2()); 
                    pushFollow(FOLLOW_2);
                    ruleQuantifier();

                    state._fsp--;

                     after(grammarAccess.getPrimaryAccess().getQuantifierParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalFirstOrderLogic.g:621:2: ( ruleTerminalExpression )
                    {
                    // InternalFirstOrderLogic.g:621:2: ( ruleTerminalExpression )
                    // InternalFirstOrderLogic.g:622:3: ruleTerminalExpression
                    {
                     before(grammarAccess.getPrimaryAccess().getTerminalExpressionParserRuleCall_3()); 
                    pushFollow(FOLLOW_2);
                    ruleTerminalExpression();

                    state._fsp--;

                     after(grammarAccess.getPrimaryAccess().getTerminalExpressionParserRuleCall_3()); 

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
    // $ANTLR end "rule__Primary__Alternatives"


    // $ANTLR start "rule__TerminalExpression__Alternatives"
    // InternalFirstOrderLogic.g:631:1: rule__TerminalExpression__Alternatives : ( ( ( rule__TerminalExpression__Group_0__0 ) ) | ( ( rule__TerminalExpression__Group_1__0 ) ) | ( ( rule__TerminalExpression__Group_2__0 ) ) | ( ( rule__TerminalExpression__Group_3__0 ) ) );
    public final void rule__TerminalExpression__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:635:1: ( ( ( rule__TerminalExpression__Group_0__0 ) ) | ( ( rule__TerminalExpression__Group_1__0 ) ) | ( ( rule__TerminalExpression__Group_2__0 ) ) | ( ( rule__TerminalExpression__Group_3__0 ) ) )
            int alt3=4;
            switch ( input.LA(1) ) {
            case RULE_INT:
                {
                alt3=1;
                }
                break;
            case RULE_STRING:
                {
                alt3=2;
                }
                break;
            case 11:
            case 12:
                {
                alt3=3;
                }
                break;
            case RULE_ID:
                {
                alt3=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // InternalFirstOrderLogic.g:636:2: ( ( rule__TerminalExpression__Group_0__0 ) )
                    {
                    // InternalFirstOrderLogic.g:636:2: ( ( rule__TerminalExpression__Group_0__0 ) )
                    // InternalFirstOrderLogic.g:637:3: ( rule__TerminalExpression__Group_0__0 )
                    {
                     before(grammarAccess.getTerminalExpressionAccess().getGroup_0()); 
                    // InternalFirstOrderLogic.g:638:3: ( rule__TerminalExpression__Group_0__0 )
                    // InternalFirstOrderLogic.g:638:4: rule__TerminalExpression__Group_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__TerminalExpression__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getTerminalExpressionAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalFirstOrderLogic.g:642:2: ( ( rule__TerminalExpression__Group_1__0 ) )
                    {
                    // InternalFirstOrderLogic.g:642:2: ( ( rule__TerminalExpression__Group_1__0 ) )
                    // InternalFirstOrderLogic.g:643:3: ( rule__TerminalExpression__Group_1__0 )
                    {
                     before(grammarAccess.getTerminalExpressionAccess().getGroup_1()); 
                    // InternalFirstOrderLogic.g:644:3: ( rule__TerminalExpression__Group_1__0 )
                    // InternalFirstOrderLogic.g:644:4: rule__TerminalExpression__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__TerminalExpression__Group_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getTerminalExpressionAccess().getGroup_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalFirstOrderLogic.g:648:2: ( ( rule__TerminalExpression__Group_2__0 ) )
                    {
                    // InternalFirstOrderLogic.g:648:2: ( ( rule__TerminalExpression__Group_2__0 ) )
                    // InternalFirstOrderLogic.g:649:3: ( rule__TerminalExpression__Group_2__0 )
                    {
                     before(grammarAccess.getTerminalExpressionAccess().getGroup_2()); 
                    // InternalFirstOrderLogic.g:650:3: ( rule__TerminalExpression__Group_2__0 )
                    // InternalFirstOrderLogic.g:650:4: rule__TerminalExpression__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__TerminalExpression__Group_2__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getTerminalExpressionAccess().getGroup_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalFirstOrderLogic.g:654:2: ( ( rule__TerminalExpression__Group_3__0 ) )
                    {
                    // InternalFirstOrderLogic.g:654:2: ( ( rule__TerminalExpression__Group_3__0 ) )
                    // InternalFirstOrderLogic.g:655:3: ( rule__TerminalExpression__Group_3__0 )
                    {
                     before(grammarAccess.getTerminalExpressionAccess().getGroup_3()); 
                    // InternalFirstOrderLogic.g:656:3: ( rule__TerminalExpression__Group_3__0 )
                    // InternalFirstOrderLogic.g:656:4: rule__TerminalExpression__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__TerminalExpression__Group_3__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getTerminalExpressionAccess().getGroup_3()); 

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
    // $ANTLR end "rule__TerminalExpression__Alternatives"


    // $ANTLR start "rule__TerminalExpression__ValueAlternatives_2_1_0"
    // InternalFirstOrderLogic.g:664:1: rule__TerminalExpression__ValueAlternatives_2_1_0 : ( ( 'true' ) | ( 'false' ) );
    public final void rule__TerminalExpression__ValueAlternatives_2_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:668:1: ( ( 'true' ) | ( 'false' ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==11) ) {
                alt4=1;
            }
            else if ( (LA4_0==12) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // InternalFirstOrderLogic.g:669:2: ( 'true' )
                    {
                    // InternalFirstOrderLogic.g:669:2: ( 'true' )
                    // InternalFirstOrderLogic.g:670:3: 'true'
                    {
                     before(grammarAccess.getTerminalExpressionAccess().getValueTrueKeyword_2_1_0_0()); 
                    match(input,11,FOLLOW_2); 
                     after(grammarAccess.getTerminalExpressionAccess().getValueTrueKeyword_2_1_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalFirstOrderLogic.g:675:2: ( 'false' )
                    {
                    // InternalFirstOrderLogic.g:675:2: ( 'false' )
                    // InternalFirstOrderLogic.g:676:3: 'false'
                    {
                     before(grammarAccess.getTerminalExpressionAccess().getValueFalseKeyword_2_1_0_1()); 
                    match(input,12,FOLLOW_2); 
                     after(grammarAccess.getTerminalExpressionAccess().getValueFalseKeyword_2_1_0_1()); 

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
    // $ANTLR end "rule__TerminalExpression__ValueAlternatives_2_1_0"


    // $ANTLR start "rule__ConstraintRuleBase__Group__0"
    // InternalFirstOrderLogic.g:685:1: rule__ConstraintRuleBase__Group__0 : rule__ConstraintRuleBase__Group__0__Impl rule__ConstraintRuleBase__Group__1 ;
    public final void rule__ConstraintRuleBase__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:689:1: ( rule__ConstraintRuleBase__Group__0__Impl rule__ConstraintRuleBase__Group__1 )
            // InternalFirstOrderLogic.g:690:2: rule__ConstraintRuleBase__Group__0__Impl rule__ConstraintRuleBase__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__ConstraintRuleBase__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ConstraintRuleBase__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintRuleBase__Group__0"


    // $ANTLR start "rule__ConstraintRuleBase__Group__0__Impl"
    // InternalFirstOrderLogic.g:697:1: rule__ConstraintRuleBase__Group__0__Impl : ( 'domain' ) ;
    public final void rule__ConstraintRuleBase__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:701:1: ( ( 'domain' ) )
            // InternalFirstOrderLogic.g:702:1: ( 'domain' )
            {
            // InternalFirstOrderLogic.g:702:1: ( 'domain' )
            // InternalFirstOrderLogic.g:703:2: 'domain'
            {
             before(grammarAccess.getConstraintRuleBaseAccess().getDomainKeyword_0()); 
            match(input,13,FOLLOW_2); 
             after(grammarAccess.getConstraintRuleBaseAccess().getDomainKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintRuleBase__Group__0__Impl"


    // $ANTLR start "rule__ConstraintRuleBase__Group__1"
    // InternalFirstOrderLogic.g:712:1: rule__ConstraintRuleBase__Group__1 : rule__ConstraintRuleBase__Group__1__Impl rule__ConstraintRuleBase__Group__2 ;
    public final void rule__ConstraintRuleBase__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:716:1: ( rule__ConstraintRuleBase__Group__1__Impl rule__ConstraintRuleBase__Group__2 )
            // InternalFirstOrderLogic.g:717:2: rule__ConstraintRuleBase__Group__1__Impl rule__ConstraintRuleBase__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__ConstraintRuleBase__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ConstraintRuleBase__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintRuleBase__Group__1"


    // $ANTLR start "rule__ConstraintRuleBase__Group__1__Impl"
    // InternalFirstOrderLogic.g:724:1: rule__ConstraintRuleBase__Group__1__Impl : ( ( rule__ConstraintRuleBase__DomainAssignment_1 ) ) ;
    public final void rule__ConstraintRuleBase__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:728:1: ( ( ( rule__ConstraintRuleBase__DomainAssignment_1 ) ) )
            // InternalFirstOrderLogic.g:729:1: ( ( rule__ConstraintRuleBase__DomainAssignment_1 ) )
            {
            // InternalFirstOrderLogic.g:729:1: ( ( rule__ConstraintRuleBase__DomainAssignment_1 ) )
            // InternalFirstOrderLogic.g:730:2: ( rule__ConstraintRuleBase__DomainAssignment_1 )
            {
             before(grammarAccess.getConstraintRuleBaseAccess().getDomainAssignment_1()); 
            // InternalFirstOrderLogic.g:731:2: ( rule__ConstraintRuleBase__DomainAssignment_1 )
            // InternalFirstOrderLogic.g:731:3: rule__ConstraintRuleBase__DomainAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__ConstraintRuleBase__DomainAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getConstraintRuleBaseAccess().getDomainAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintRuleBase__Group__1__Impl"


    // $ANTLR start "rule__ConstraintRuleBase__Group__2"
    // InternalFirstOrderLogic.g:739:1: rule__ConstraintRuleBase__Group__2 : rule__ConstraintRuleBase__Group__2__Impl ;
    public final void rule__ConstraintRuleBase__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:743:1: ( rule__ConstraintRuleBase__Group__2__Impl )
            // InternalFirstOrderLogic.g:744:2: rule__ConstraintRuleBase__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ConstraintRuleBase__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintRuleBase__Group__2"


    // $ANTLR start "rule__ConstraintRuleBase__Group__2__Impl"
    // InternalFirstOrderLogic.g:750:1: rule__ConstraintRuleBase__Group__2__Impl : ( ( rule__ConstraintRuleBase__ConstraintsAssignment_2 ) ) ;
    public final void rule__ConstraintRuleBase__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:754:1: ( ( ( rule__ConstraintRuleBase__ConstraintsAssignment_2 ) ) )
            // InternalFirstOrderLogic.g:755:1: ( ( rule__ConstraintRuleBase__ConstraintsAssignment_2 ) )
            {
            // InternalFirstOrderLogic.g:755:1: ( ( rule__ConstraintRuleBase__ConstraintsAssignment_2 ) )
            // InternalFirstOrderLogic.g:756:2: ( rule__ConstraintRuleBase__ConstraintsAssignment_2 )
            {
             before(grammarAccess.getConstraintRuleBaseAccess().getConstraintsAssignment_2()); 
            // InternalFirstOrderLogic.g:757:2: ( rule__ConstraintRuleBase__ConstraintsAssignment_2 )
            // InternalFirstOrderLogic.g:757:3: rule__ConstraintRuleBase__ConstraintsAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__ConstraintRuleBase__ConstraintsAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getConstraintRuleBaseAccess().getConstraintsAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintRuleBase__Group__2__Impl"


    // $ANTLR start "rule__Constraint__Group__0"
    // InternalFirstOrderLogic.g:766:1: rule__Constraint__Group__0 : rule__Constraint__Group__0__Impl rule__Constraint__Group__1 ;
    public final void rule__Constraint__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:770:1: ( rule__Constraint__Group__0__Impl rule__Constraint__Group__1 )
            // InternalFirstOrderLogic.g:771:2: rule__Constraint__Group__0__Impl rule__Constraint__Group__1
            {
            pushFollow(FOLLOW_5);
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
    // InternalFirstOrderLogic.g:778:1: rule__Constraint__Group__0__Impl : ( 'context' ) ;
    public final void rule__Constraint__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:782:1: ( ( 'context' ) )
            // InternalFirstOrderLogic.g:783:1: ( 'context' )
            {
            // InternalFirstOrderLogic.g:783:1: ( 'context' )
            // InternalFirstOrderLogic.g:784:2: 'context'
            {
             before(grammarAccess.getConstraintAccess().getContextKeyword_0()); 
            match(input,14,FOLLOW_2); 
             after(grammarAccess.getConstraintAccess().getContextKeyword_0()); 

            }


            }

        }
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
    // InternalFirstOrderLogic.g:793:1: rule__Constraint__Group__1 : rule__Constraint__Group__1__Impl rule__Constraint__Group__2 ;
    public final void rule__Constraint__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:797:1: ( rule__Constraint__Group__1__Impl rule__Constraint__Group__2 )
            // InternalFirstOrderLogic.g:798:2: rule__Constraint__Group__1__Impl rule__Constraint__Group__2
            {
            pushFollow(FOLLOW_6);
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
    // InternalFirstOrderLogic.g:805:1: rule__Constraint__Group__1__Impl : ( ( rule__Constraint__VariableAssignment_1 ) ) ;
    public final void rule__Constraint__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:809:1: ( ( ( rule__Constraint__VariableAssignment_1 ) ) )
            // InternalFirstOrderLogic.g:810:1: ( ( rule__Constraint__VariableAssignment_1 ) )
            {
            // InternalFirstOrderLogic.g:810:1: ( ( rule__Constraint__VariableAssignment_1 ) )
            // InternalFirstOrderLogic.g:811:2: ( rule__Constraint__VariableAssignment_1 )
            {
             before(grammarAccess.getConstraintAccess().getVariableAssignment_1()); 
            // InternalFirstOrderLogic.g:812:2: ( rule__Constraint__VariableAssignment_1 )
            // InternalFirstOrderLogic.g:812:3: rule__Constraint__VariableAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Constraint__VariableAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getConstraintAccess().getVariableAssignment_1()); 

            }


            }

        }
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
    // InternalFirstOrderLogic.g:820:1: rule__Constraint__Group__2 : rule__Constraint__Group__2__Impl rule__Constraint__Group__3 ;
    public final void rule__Constraint__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:824:1: ( rule__Constraint__Group__2__Impl rule__Constraint__Group__3 )
            // InternalFirstOrderLogic.g:825:2: rule__Constraint__Group__2__Impl rule__Constraint__Group__3
            {
            pushFollow(FOLLOW_7);
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
    // InternalFirstOrderLogic.g:832:1: rule__Constraint__Group__2__Impl : ( ':' ) ;
    public final void rule__Constraint__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:836:1: ( ( ':' ) )
            // InternalFirstOrderLogic.g:837:1: ( ':' )
            {
            // InternalFirstOrderLogic.g:837:1: ( ':' )
            // InternalFirstOrderLogic.g:838:2: ':'
            {
             before(grammarAccess.getConstraintAccess().getColonKeyword_2()); 
            match(input,15,FOLLOW_2); 
             after(grammarAccess.getConstraintAccess().getColonKeyword_2()); 

            }


            }

        }
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
    // InternalFirstOrderLogic.g:847:1: rule__Constraint__Group__3 : rule__Constraint__Group__3__Impl ;
    public final void rule__Constraint__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:851:1: ( rule__Constraint__Group__3__Impl )
            // InternalFirstOrderLogic.g:852:2: rule__Constraint__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Constraint__Group__3__Impl();

            state._fsp--;


            }

        }
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
    // InternalFirstOrderLogic.g:858:1: rule__Constraint__Group__3__Impl : ( ( rule__Constraint__FormulaAssignment_3 ) ) ;
    public final void rule__Constraint__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:862:1: ( ( ( rule__Constraint__FormulaAssignment_3 ) ) )
            // InternalFirstOrderLogic.g:863:1: ( ( rule__Constraint__FormulaAssignment_3 ) )
            {
            // InternalFirstOrderLogic.g:863:1: ( ( rule__Constraint__FormulaAssignment_3 ) )
            // InternalFirstOrderLogic.g:864:2: ( rule__Constraint__FormulaAssignment_3 )
            {
             before(grammarAccess.getConstraintAccess().getFormulaAssignment_3()); 
            // InternalFirstOrderLogic.g:865:2: ( rule__Constraint__FormulaAssignment_3 )
            // InternalFirstOrderLogic.g:865:3: rule__Constraint__FormulaAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__Constraint__FormulaAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getConstraintAccess().getFormulaAssignment_3()); 

            }


            }

        }
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


    // $ANTLR start "rule__Variable__Group__0"
    // InternalFirstOrderLogic.g:874:1: rule__Variable__Group__0 : rule__Variable__Group__0__Impl rule__Variable__Group__1 ;
    public final void rule__Variable__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:878:1: ( rule__Variable__Group__0__Impl rule__Variable__Group__1 )
            // InternalFirstOrderLogic.g:879:2: rule__Variable__Group__0__Impl rule__Variable__Group__1
            {
            pushFollow(FOLLOW_5);
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
    // InternalFirstOrderLogic.g:886:1: rule__Variable__Group__0__Impl : ( ( rule__Variable__TypeAssignment_0 ) ) ;
    public final void rule__Variable__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:890:1: ( ( ( rule__Variable__TypeAssignment_0 ) ) )
            // InternalFirstOrderLogic.g:891:1: ( ( rule__Variable__TypeAssignment_0 ) )
            {
            // InternalFirstOrderLogic.g:891:1: ( ( rule__Variable__TypeAssignment_0 ) )
            // InternalFirstOrderLogic.g:892:2: ( rule__Variable__TypeAssignment_0 )
            {
             before(grammarAccess.getVariableAccess().getTypeAssignment_0()); 
            // InternalFirstOrderLogic.g:893:2: ( rule__Variable__TypeAssignment_0 )
            // InternalFirstOrderLogic.g:893:3: rule__Variable__TypeAssignment_0
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
    // InternalFirstOrderLogic.g:901:1: rule__Variable__Group__1 : rule__Variable__Group__1__Impl ;
    public final void rule__Variable__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:905:1: ( rule__Variable__Group__1__Impl )
            // InternalFirstOrderLogic.g:906:2: rule__Variable__Group__1__Impl
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
    // InternalFirstOrderLogic.g:912:1: rule__Variable__Group__1__Impl : ( ( rule__Variable__NameAssignment_1 ) ) ;
    public final void rule__Variable__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:916:1: ( ( ( rule__Variable__NameAssignment_1 ) ) )
            // InternalFirstOrderLogic.g:917:1: ( ( rule__Variable__NameAssignment_1 ) )
            {
            // InternalFirstOrderLogic.g:917:1: ( ( rule__Variable__NameAssignment_1 ) )
            // InternalFirstOrderLogic.g:918:2: ( rule__Variable__NameAssignment_1 )
            {
             before(grammarAccess.getVariableAccess().getNameAssignment_1()); 
            // InternalFirstOrderLogic.g:919:2: ( rule__Variable__NameAssignment_1 )
            // InternalFirstOrderLogic.g:919:3: rule__Variable__NameAssignment_1
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


    // $ANTLR start "rule__GetTerm__Group__0"
    // InternalFirstOrderLogic.g:928:1: rule__GetTerm__Group__0 : rule__GetTerm__Group__0__Impl rule__GetTerm__Group__1 ;
    public final void rule__GetTerm__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:932:1: ( rule__GetTerm__Group__0__Impl rule__GetTerm__Group__1 )
            // InternalFirstOrderLogic.g:933:2: rule__GetTerm__Group__0__Impl rule__GetTerm__Group__1
            {
            pushFollow(FOLLOW_5);
            rule__GetTerm__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__GetTerm__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GetTerm__Group__0"


    // $ANTLR start "rule__GetTerm__Group__0__Impl"
    // InternalFirstOrderLogic.g:940:1: rule__GetTerm__Group__0__Impl : ( () ) ;
    public final void rule__GetTerm__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:944:1: ( ( () ) )
            // InternalFirstOrderLogic.g:945:1: ( () )
            {
            // InternalFirstOrderLogic.g:945:1: ( () )
            // InternalFirstOrderLogic.g:946:2: ()
            {
             before(grammarAccess.getGetTermAccess().getGetTermAction_0()); 
            // InternalFirstOrderLogic.g:947:2: ()
            // InternalFirstOrderLogic.g:947:3: 
            {
            }

             after(grammarAccess.getGetTermAccess().getGetTermAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GetTerm__Group__0__Impl"


    // $ANTLR start "rule__GetTerm__Group__1"
    // InternalFirstOrderLogic.g:955:1: rule__GetTerm__Group__1 : rule__GetTerm__Group__1__Impl rule__GetTerm__Group__2 ;
    public final void rule__GetTerm__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:959:1: ( rule__GetTerm__Group__1__Impl rule__GetTerm__Group__2 )
            // InternalFirstOrderLogic.g:960:2: rule__GetTerm__Group__1__Impl rule__GetTerm__Group__2
            {
            pushFollow(FOLLOW_8);
            rule__GetTerm__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__GetTerm__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GetTerm__Group__1"


    // $ANTLR start "rule__GetTerm__Group__1__Impl"
    // InternalFirstOrderLogic.g:967:1: rule__GetTerm__Group__1__Impl : ( ( rule__GetTerm__NameAssignment_1 ) ) ;
    public final void rule__GetTerm__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:971:1: ( ( ( rule__GetTerm__NameAssignment_1 ) ) )
            // InternalFirstOrderLogic.g:972:1: ( ( rule__GetTerm__NameAssignment_1 ) )
            {
            // InternalFirstOrderLogic.g:972:1: ( ( rule__GetTerm__NameAssignment_1 ) )
            // InternalFirstOrderLogic.g:973:2: ( rule__GetTerm__NameAssignment_1 )
            {
             before(grammarAccess.getGetTermAccess().getNameAssignment_1()); 
            // InternalFirstOrderLogic.g:974:2: ( rule__GetTerm__NameAssignment_1 )
            // InternalFirstOrderLogic.g:974:3: rule__GetTerm__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__GetTerm__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getGetTermAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GetTerm__Group__1__Impl"


    // $ANTLR start "rule__GetTerm__Group__2"
    // InternalFirstOrderLogic.g:982:1: rule__GetTerm__Group__2 : rule__GetTerm__Group__2__Impl ;
    public final void rule__GetTerm__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:986:1: ( rule__GetTerm__Group__2__Impl )
            // InternalFirstOrderLogic.g:987:2: rule__GetTerm__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__GetTerm__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GetTerm__Group__2"


    // $ANTLR start "rule__GetTerm__Group__2__Impl"
    // InternalFirstOrderLogic.g:993:1: rule__GetTerm__Group__2__Impl : ( ( rule__GetTerm__FeatureAssignment_2 )? ) ;
    public final void rule__GetTerm__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:997:1: ( ( ( rule__GetTerm__FeatureAssignment_2 )? ) )
            // InternalFirstOrderLogic.g:998:1: ( ( rule__GetTerm__FeatureAssignment_2 )? )
            {
            // InternalFirstOrderLogic.g:998:1: ( ( rule__GetTerm__FeatureAssignment_2 )? )
            // InternalFirstOrderLogic.g:999:2: ( rule__GetTerm__FeatureAssignment_2 )?
            {
             before(grammarAccess.getGetTermAccess().getFeatureAssignment_2()); 
            // InternalFirstOrderLogic.g:1000:2: ( rule__GetTerm__FeatureAssignment_2 )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==16) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalFirstOrderLogic.g:1000:3: rule__GetTerm__FeatureAssignment_2
                    {
                    pushFollow(FOLLOW_2);
                    rule__GetTerm__FeatureAssignment_2();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getGetTermAccess().getFeatureAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GetTerm__Group__2__Impl"


    // $ANTLR start "rule__Get__Group__0"
    // InternalFirstOrderLogic.g:1009:1: rule__Get__Group__0 : rule__Get__Group__0__Impl rule__Get__Group__1 ;
    public final void rule__Get__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1013:1: ( rule__Get__Group__0__Impl rule__Get__Group__1 )
            // InternalFirstOrderLogic.g:1014:2: rule__Get__Group__0__Impl rule__Get__Group__1
            {
            pushFollow(FOLLOW_5);
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
    // InternalFirstOrderLogic.g:1021:1: rule__Get__Group__0__Impl : ( '.' ) ;
    public final void rule__Get__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1025:1: ( ( '.' ) )
            // InternalFirstOrderLogic.g:1026:1: ( '.' )
            {
            // InternalFirstOrderLogic.g:1026:1: ( '.' )
            // InternalFirstOrderLogic.g:1027:2: '.'
            {
             before(grammarAccess.getGetAccess().getFullStopKeyword_0()); 
            match(input,16,FOLLOW_2); 
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
    // InternalFirstOrderLogic.g:1036:1: rule__Get__Group__1 : rule__Get__Group__1__Impl rule__Get__Group__2 ;
    public final void rule__Get__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1040:1: ( rule__Get__Group__1__Impl rule__Get__Group__2 )
            // InternalFirstOrderLogic.g:1041:2: rule__Get__Group__1__Impl rule__Get__Group__2
            {
            pushFollow(FOLLOW_5);
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
    // InternalFirstOrderLogic.g:1048:1: rule__Get__Group__1__Impl : ( ( rule__Get__Group_1__0 )? ) ;
    public final void rule__Get__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1052:1: ( ( ( rule__Get__Group_1__0 )? ) )
            // InternalFirstOrderLogic.g:1053:1: ( ( rule__Get__Group_1__0 )? )
            {
            // InternalFirstOrderLogic.g:1053:1: ( ( rule__Get__Group_1__0 )? )
            // InternalFirstOrderLogic.g:1054:2: ( rule__Get__Group_1__0 )?
            {
             before(grammarAccess.getGetAccess().getGroup_1()); 
            // InternalFirstOrderLogic.g:1055:2: ( rule__Get__Group_1__0 )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_ID) ) {
                int LA6_1 = input.LA(2);

                if ( (LA6_1==17) ) {
                    alt6=1;
                }
            }
            switch (alt6) {
                case 1 :
                    // InternalFirstOrderLogic.g:1055:3: rule__Get__Group_1__0
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
    // InternalFirstOrderLogic.g:1063:1: rule__Get__Group__2 : rule__Get__Group__2__Impl rule__Get__Group__3 ;
    public final void rule__Get__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1067:1: ( rule__Get__Group__2__Impl rule__Get__Group__3 )
            // InternalFirstOrderLogic.g:1068:2: rule__Get__Group__2__Impl rule__Get__Group__3
            {
            pushFollow(FOLLOW_8);
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
    // InternalFirstOrderLogic.g:1075:1: rule__Get__Group__2__Impl : ( ( rule__Get__NameAssignment_2 ) ) ;
    public final void rule__Get__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1079:1: ( ( ( rule__Get__NameAssignment_2 ) ) )
            // InternalFirstOrderLogic.g:1080:1: ( ( rule__Get__NameAssignment_2 ) )
            {
            // InternalFirstOrderLogic.g:1080:1: ( ( rule__Get__NameAssignment_2 ) )
            // InternalFirstOrderLogic.g:1081:2: ( rule__Get__NameAssignment_2 )
            {
             before(grammarAccess.getGetAccess().getNameAssignment_2()); 
            // InternalFirstOrderLogic.g:1082:2: ( rule__Get__NameAssignment_2 )
            // InternalFirstOrderLogic.g:1082:3: rule__Get__NameAssignment_2
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
    // InternalFirstOrderLogic.g:1090:1: rule__Get__Group__3 : rule__Get__Group__3__Impl ;
    public final void rule__Get__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1094:1: ( rule__Get__Group__3__Impl )
            // InternalFirstOrderLogic.g:1095:2: rule__Get__Group__3__Impl
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
    // InternalFirstOrderLogic.g:1101:1: rule__Get__Group__3__Impl : ( ( rule__Get__NextAssignment_3 )? ) ;
    public final void rule__Get__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1105:1: ( ( ( rule__Get__NextAssignment_3 )? ) )
            // InternalFirstOrderLogic.g:1106:1: ( ( rule__Get__NextAssignment_3 )? )
            {
            // InternalFirstOrderLogic.g:1106:1: ( ( rule__Get__NextAssignment_3 )? )
            // InternalFirstOrderLogic.g:1107:2: ( rule__Get__NextAssignment_3 )?
            {
             before(grammarAccess.getGetAccess().getNextAssignment_3()); 
            // InternalFirstOrderLogic.g:1108:2: ( rule__Get__NextAssignment_3 )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==16) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalFirstOrderLogic.g:1108:3: rule__Get__NextAssignment_3
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
    // InternalFirstOrderLogic.g:1117:1: rule__Get__Group_1__0 : rule__Get__Group_1__0__Impl rule__Get__Group_1__1 ;
    public final void rule__Get__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1121:1: ( rule__Get__Group_1__0__Impl rule__Get__Group_1__1 )
            // InternalFirstOrderLogic.g:1122:2: rule__Get__Group_1__0__Impl rule__Get__Group_1__1
            {
            pushFollow(FOLLOW_9);
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
    // InternalFirstOrderLogic.g:1129:1: rule__Get__Group_1__0__Impl : ( ( rule__Get__TypeAssignment_1_0 ) ) ;
    public final void rule__Get__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1133:1: ( ( ( rule__Get__TypeAssignment_1_0 ) ) )
            // InternalFirstOrderLogic.g:1134:1: ( ( rule__Get__TypeAssignment_1_0 ) )
            {
            // InternalFirstOrderLogic.g:1134:1: ( ( rule__Get__TypeAssignment_1_0 ) )
            // InternalFirstOrderLogic.g:1135:2: ( rule__Get__TypeAssignment_1_0 )
            {
             before(grammarAccess.getGetAccess().getTypeAssignment_1_0()); 
            // InternalFirstOrderLogic.g:1136:2: ( rule__Get__TypeAssignment_1_0 )
            // InternalFirstOrderLogic.g:1136:3: rule__Get__TypeAssignment_1_0
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
    // InternalFirstOrderLogic.g:1144:1: rule__Get__Group_1__1 : rule__Get__Group_1__1__Impl ;
    public final void rule__Get__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1148:1: ( rule__Get__Group_1__1__Impl )
            // InternalFirstOrderLogic.g:1149:2: rule__Get__Group_1__1__Impl
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
    // InternalFirstOrderLogic.g:1155:1: rule__Get__Group_1__1__Impl : ( '::' ) ;
    public final void rule__Get__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1159:1: ( ( '::' ) )
            // InternalFirstOrderLogic.g:1160:1: ( '::' )
            {
            // InternalFirstOrderLogic.g:1160:1: ( '::' )
            // InternalFirstOrderLogic.g:1161:2: '::'
            {
             before(grammarAccess.getGetAccess().getColonColonKeyword_1_1()); 
            match(input,17,FOLLOW_2); 
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


    // $ANTLR start "rule__If__Group__0"
    // InternalFirstOrderLogic.g:1171:1: rule__If__Group__0 : rule__If__Group__0__Impl rule__If__Group__1 ;
    public final void rule__If__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1175:1: ( rule__If__Group__0__Impl rule__If__Group__1 )
            // InternalFirstOrderLogic.g:1176:2: rule__If__Group__0__Impl rule__If__Group__1
            {
            pushFollow(FOLLOW_10);
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
    // InternalFirstOrderLogic.g:1183:1: rule__If__Group__0__Impl : ( ruleXor ) ;
    public final void rule__If__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1187:1: ( ( ruleXor ) )
            // InternalFirstOrderLogic.g:1188:1: ( ruleXor )
            {
            // InternalFirstOrderLogic.g:1188:1: ( ruleXor )
            // InternalFirstOrderLogic.g:1189:2: ruleXor
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
    // InternalFirstOrderLogic.g:1198:1: rule__If__Group__1 : rule__If__Group__1__Impl ;
    public final void rule__If__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1202:1: ( rule__If__Group__1__Impl )
            // InternalFirstOrderLogic.g:1203:2: rule__If__Group__1__Impl
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
    // InternalFirstOrderLogic.g:1209:1: rule__If__Group__1__Impl : ( ( rule__If__Group_1__0 )* ) ;
    public final void rule__If__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1213:1: ( ( ( rule__If__Group_1__0 )* ) )
            // InternalFirstOrderLogic.g:1214:1: ( ( rule__If__Group_1__0 )* )
            {
            // InternalFirstOrderLogic.g:1214:1: ( ( rule__If__Group_1__0 )* )
            // InternalFirstOrderLogic.g:1215:2: ( rule__If__Group_1__0 )*
            {
             before(grammarAccess.getIfAccess().getGroup_1()); 
            // InternalFirstOrderLogic.g:1216:2: ( rule__If__Group_1__0 )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==18) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalFirstOrderLogic.g:1216:3: rule__If__Group_1__0
            	    {
            	    pushFollow(FOLLOW_11);
            	    rule__If__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop8;
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
    // InternalFirstOrderLogic.g:1225:1: rule__If__Group_1__0 : rule__If__Group_1__0__Impl rule__If__Group_1__1 ;
    public final void rule__If__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1229:1: ( rule__If__Group_1__0__Impl rule__If__Group_1__1 )
            // InternalFirstOrderLogic.g:1230:2: rule__If__Group_1__0__Impl rule__If__Group_1__1
            {
            pushFollow(FOLLOW_10);
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
    // InternalFirstOrderLogic.g:1237:1: rule__If__Group_1__0__Impl : ( () ) ;
    public final void rule__If__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1241:1: ( ( () ) )
            // InternalFirstOrderLogic.g:1242:1: ( () )
            {
            // InternalFirstOrderLogic.g:1242:1: ( () )
            // InternalFirstOrderLogic.g:1243:2: ()
            {
             before(grammarAccess.getIfAccess().getIfLeftAction_1_0()); 
            // InternalFirstOrderLogic.g:1244:2: ()
            // InternalFirstOrderLogic.g:1244:3: 
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
    // InternalFirstOrderLogic.g:1252:1: rule__If__Group_1__1 : rule__If__Group_1__1__Impl rule__If__Group_1__2 ;
    public final void rule__If__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1256:1: ( rule__If__Group_1__1__Impl rule__If__Group_1__2 )
            // InternalFirstOrderLogic.g:1257:2: rule__If__Group_1__1__Impl rule__If__Group_1__2
            {
            pushFollow(FOLLOW_7);
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
    // InternalFirstOrderLogic.g:1264:1: rule__If__Group_1__1__Impl : ( 'implies' ) ;
    public final void rule__If__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1268:1: ( ( 'implies' ) )
            // InternalFirstOrderLogic.g:1269:1: ( 'implies' )
            {
            // InternalFirstOrderLogic.g:1269:1: ( 'implies' )
            // InternalFirstOrderLogic.g:1270:2: 'implies'
            {
             before(grammarAccess.getIfAccess().getImpliesKeyword_1_1()); 
            match(input,18,FOLLOW_2); 
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
    // InternalFirstOrderLogic.g:1279:1: rule__If__Group_1__2 : rule__If__Group_1__2__Impl ;
    public final void rule__If__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1283:1: ( rule__If__Group_1__2__Impl )
            // InternalFirstOrderLogic.g:1284:2: rule__If__Group_1__2__Impl
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
    // InternalFirstOrderLogic.g:1290:1: rule__If__Group_1__2__Impl : ( ( rule__If__RightAssignment_1_2 ) ) ;
    public final void rule__If__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1294:1: ( ( ( rule__If__RightAssignment_1_2 ) ) )
            // InternalFirstOrderLogic.g:1295:1: ( ( rule__If__RightAssignment_1_2 ) )
            {
            // InternalFirstOrderLogic.g:1295:1: ( ( rule__If__RightAssignment_1_2 ) )
            // InternalFirstOrderLogic.g:1296:2: ( rule__If__RightAssignment_1_2 )
            {
             before(grammarAccess.getIfAccess().getRightAssignment_1_2()); 
            // InternalFirstOrderLogic.g:1297:2: ( rule__If__RightAssignment_1_2 )
            // InternalFirstOrderLogic.g:1297:3: rule__If__RightAssignment_1_2
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
    // InternalFirstOrderLogic.g:1306:1: rule__Xor__Group__0 : rule__Xor__Group__0__Impl rule__Xor__Group__1 ;
    public final void rule__Xor__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1310:1: ( rule__Xor__Group__0__Impl rule__Xor__Group__1 )
            // InternalFirstOrderLogic.g:1311:2: rule__Xor__Group__0__Impl rule__Xor__Group__1
            {
            pushFollow(FOLLOW_12);
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
    // InternalFirstOrderLogic.g:1318:1: rule__Xor__Group__0__Impl : ( ruleOr ) ;
    public final void rule__Xor__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1322:1: ( ( ruleOr ) )
            // InternalFirstOrderLogic.g:1323:1: ( ruleOr )
            {
            // InternalFirstOrderLogic.g:1323:1: ( ruleOr )
            // InternalFirstOrderLogic.g:1324:2: ruleOr
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
    // InternalFirstOrderLogic.g:1333:1: rule__Xor__Group__1 : rule__Xor__Group__1__Impl ;
    public final void rule__Xor__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1337:1: ( rule__Xor__Group__1__Impl )
            // InternalFirstOrderLogic.g:1338:2: rule__Xor__Group__1__Impl
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
    // InternalFirstOrderLogic.g:1344:1: rule__Xor__Group__1__Impl : ( ( rule__Xor__Group_1__0 )* ) ;
    public final void rule__Xor__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1348:1: ( ( ( rule__Xor__Group_1__0 )* ) )
            // InternalFirstOrderLogic.g:1349:1: ( ( rule__Xor__Group_1__0 )* )
            {
            // InternalFirstOrderLogic.g:1349:1: ( ( rule__Xor__Group_1__0 )* )
            // InternalFirstOrderLogic.g:1350:2: ( rule__Xor__Group_1__0 )*
            {
             before(grammarAccess.getXorAccess().getGroup_1()); 
            // InternalFirstOrderLogic.g:1351:2: ( rule__Xor__Group_1__0 )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==19) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalFirstOrderLogic.g:1351:3: rule__Xor__Group_1__0
            	    {
            	    pushFollow(FOLLOW_13);
            	    rule__Xor__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop9;
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
    // InternalFirstOrderLogic.g:1360:1: rule__Xor__Group_1__0 : rule__Xor__Group_1__0__Impl rule__Xor__Group_1__1 ;
    public final void rule__Xor__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1364:1: ( rule__Xor__Group_1__0__Impl rule__Xor__Group_1__1 )
            // InternalFirstOrderLogic.g:1365:2: rule__Xor__Group_1__0__Impl rule__Xor__Group_1__1
            {
            pushFollow(FOLLOW_12);
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
    // InternalFirstOrderLogic.g:1372:1: rule__Xor__Group_1__0__Impl : ( () ) ;
    public final void rule__Xor__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1376:1: ( ( () ) )
            // InternalFirstOrderLogic.g:1377:1: ( () )
            {
            // InternalFirstOrderLogic.g:1377:1: ( () )
            // InternalFirstOrderLogic.g:1378:2: ()
            {
             before(grammarAccess.getXorAccess().getXorLeftAction_1_0()); 
            // InternalFirstOrderLogic.g:1379:2: ()
            // InternalFirstOrderLogic.g:1379:3: 
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
    // InternalFirstOrderLogic.g:1387:1: rule__Xor__Group_1__1 : rule__Xor__Group_1__1__Impl rule__Xor__Group_1__2 ;
    public final void rule__Xor__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1391:1: ( rule__Xor__Group_1__1__Impl rule__Xor__Group_1__2 )
            // InternalFirstOrderLogic.g:1392:2: rule__Xor__Group_1__1__Impl rule__Xor__Group_1__2
            {
            pushFollow(FOLLOW_7);
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
    // InternalFirstOrderLogic.g:1399:1: rule__Xor__Group_1__1__Impl : ( 'xor' ) ;
    public final void rule__Xor__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1403:1: ( ( 'xor' ) )
            // InternalFirstOrderLogic.g:1404:1: ( 'xor' )
            {
            // InternalFirstOrderLogic.g:1404:1: ( 'xor' )
            // InternalFirstOrderLogic.g:1405:2: 'xor'
            {
             before(grammarAccess.getXorAccess().getXorKeyword_1_1()); 
            match(input,19,FOLLOW_2); 
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
    // InternalFirstOrderLogic.g:1414:1: rule__Xor__Group_1__2 : rule__Xor__Group_1__2__Impl ;
    public final void rule__Xor__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1418:1: ( rule__Xor__Group_1__2__Impl )
            // InternalFirstOrderLogic.g:1419:2: rule__Xor__Group_1__2__Impl
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
    // InternalFirstOrderLogic.g:1425:1: rule__Xor__Group_1__2__Impl : ( ( rule__Xor__RightAssignment_1_2 ) ) ;
    public final void rule__Xor__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1429:1: ( ( ( rule__Xor__RightAssignment_1_2 ) ) )
            // InternalFirstOrderLogic.g:1430:1: ( ( rule__Xor__RightAssignment_1_2 ) )
            {
            // InternalFirstOrderLogic.g:1430:1: ( ( rule__Xor__RightAssignment_1_2 ) )
            // InternalFirstOrderLogic.g:1431:2: ( rule__Xor__RightAssignment_1_2 )
            {
             before(grammarAccess.getXorAccess().getRightAssignment_1_2()); 
            // InternalFirstOrderLogic.g:1432:2: ( rule__Xor__RightAssignment_1_2 )
            // InternalFirstOrderLogic.g:1432:3: rule__Xor__RightAssignment_1_2
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
    // InternalFirstOrderLogic.g:1441:1: rule__Or__Group__0 : rule__Or__Group__0__Impl rule__Or__Group__1 ;
    public final void rule__Or__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1445:1: ( rule__Or__Group__0__Impl rule__Or__Group__1 )
            // InternalFirstOrderLogic.g:1446:2: rule__Or__Group__0__Impl rule__Or__Group__1
            {
            pushFollow(FOLLOW_14);
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
    // InternalFirstOrderLogic.g:1453:1: rule__Or__Group__0__Impl : ( ruleAnd ) ;
    public final void rule__Or__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1457:1: ( ( ruleAnd ) )
            // InternalFirstOrderLogic.g:1458:1: ( ruleAnd )
            {
            // InternalFirstOrderLogic.g:1458:1: ( ruleAnd )
            // InternalFirstOrderLogic.g:1459:2: ruleAnd
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
    // InternalFirstOrderLogic.g:1468:1: rule__Or__Group__1 : rule__Or__Group__1__Impl ;
    public final void rule__Or__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1472:1: ( rule__Or__Group__1__Impl )
            // InternalFirstOrderLogic.g:1473:2: rule__Or__Group__1__Impl
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
    // InternalFirstOrderLogic.g:1479:1: rule__Or__Group__1__Impl : ( ( rule__Or__Group_1__0 )* ) ;
    public final void rule__Or__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1483:1: ( ( ( rule__Or__Group_1__0 )* ) )
            // InternalFirstOrderLogic.g:1484:1: ( ( rule__Or__Group_1__0 )* )
            {
            // InternalFirstOrderLogic.g:1484:1: ( ( rule__Or__Group_1__0 )* )
            // InternalFirstOrderLogic.g:1485:2: ( rule__Or__Group_1__0 )*
            {
             before(grammarAccess.getOrAccess().getGroup_1()); 
            // InternalFirstOrderLogic.g:1486:2: ( rule__Or__Group_1__0 )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==20) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalFirstOrderLogic.g:1486:3: rule__Or__Group_1__0
            	    {
            	    pushFollow(FOLLOW_15);
            	    rule__Or__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop10;
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
    // InternalFirstOrderLogic.g:1495:1: rule__Or__Group_1__0 : rule__Or__Group_1__0__Impl rule__Or__Group_1__1 ;
    public final void rule__Or__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1499:1: ( rule__Or__Group_1__0__Impl rule__Or__Group_1__1 )
            // InternalFirstOrderLogic.g:1500:2: rule__Or__Group_1__0__Impl rule__Or__Group_1__1
            {
            pushFollow(FOLLOW_14);
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
    // InternalFirstOrderLogic.g:1507:1: rule__Or__Group_1__0__Impl : ( () ) ;
    public final void rule__Or__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1511:1: ( ( () ) )
            // InternalFirstOrderLogic.g:1512:1: ( () )
            {
            // InternalFirstOrderLogic.g:1512:1: ( () )
            // InternalFirstOrderLogic.g:1513:2: ()
            {
             before(grammarAccess.getOrAccess().getOrLeftAction_1_0()); 
            // InternalFirstOrderLogic.g:1514:2: ()
            // InternalFirstOrderLogic.g:1514:3: 
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
    // InternalFirstOrderLogic.g:1522:1: rule__Or__Group_1__1 : rule__Or__Group_1__1__Impl rule__Or__Group_1__2 ;
    public final void rule__Or__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1526:1: ( rule__Or__Group_1__1__Impl rule__Or__Group_1__2 )
            // InternalFirstOrderLogic.g:1527:2: rule__Or__Group_1__1__Impl rule__Or__Group_1__2
            {
            pushFollow(FOLLOW_7);
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
    // InternalFirstOrderLogic.g:1534:1: rule__Or__Group_1__1__Impl : ( 'or' ) ;
    public final void rule__Or__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1538:1: ( ( 'or' ) )
            // InternalFirstOrderLogic.g:1539:1: ( 'or' )
            {
            // InternalFirstOrderLogic.g:1539:1: ( 'or' )
            // InternalFirstOrderLogic.g:1540:2: 'or'
            {
             before(grammarAccess.getOrAccess().getOrKeyword_1_1()); 
            match(input,20,FOLLOW_2); 
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
    // InternalFirstOrderLogic.g:1549:1: rule__Or__Group_1__2 : rule__Or__Group_1__2__Impl ;
    public final void rule__Or__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1553:1: ( rule__Or__Group_1__2__Impl )
            // InternalFirstOrderLogic.g:1554:2: rule__Or__Group_1__2__Impl
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
    // InternalFirstOrderLogic.g:1560:1: rule__Or__Group_1__2__Impl : ( ( rule__Or__RightAssignment_1_2 ) ) ;
    public final void rule__Or__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1564:1: ( ( ( rule__Or__RightAssignment_1_2 ) ) )
            // InternalFirstOrderLogic.g:1565:1: ( ( rule__Or__RightAssignment_1_2 ) )
            {
            // InternalFirstOrderLogic.g:1565:1: ( ( rule__Or__RightAssignment_1_2 ) )
            // InternalFirstOrderLogic.g:1566:2: ( rule__Or__RightAssignment_1_2 )
            {
             before(grammarAccess.getOrAccess().getRightAssignment_1_2()); 
            // InternalFirstOrderLogic.g:1567:2: ( rule__Or__RightAssignment_1_2 )
            // InternalFirstOrderLogic.g:1567:3: rule__Or__RightAssignment_1_2
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
    // InternalFirstOrderLogic.g:1576:1: rule__And__Group__0 : rule__And__Group__0__Impl rule__And__Group__1 ;
    public final void rule__And__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1580:1: ( rule__And__Group__0__Impl rule__And__Group__1 )
            // InternalFirstOrderLogic.g:1581:2: rule__And__Group__0__Impl rule__And__Group__1
            {
            pushFollow(FOLLOW_16);
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
    // InternalFirstOrderLogic.g:1588:1: rule__And__Group__0__Impl : ( rulePrimary ) ;
    public final void rule__And__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1592:1: ( ( rulePrimary ) )
            // InternalFirstOrderLogic.g:1593:1: ( rulePrimary )
            {
            // InternalFirstOrderLogic.g:1593:1: ( rulePrimary )
            // InternalFirstOrderLogic.g:1594:2: rulePrimary
            {
             before(grammarAccess.getAndAccess().getPrimaryParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            rulePrimary();

            state._fsp--;

             after(grammarAccess.getAndAccess().getPrimaryParserRuleCall_0()); 

            }


            }

        }
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
    // InternalFirstOrderLogic.g:1603:1: rule__And__Group__1 : rule__And__Group__1__Impl ;
    public final void rule__And__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1607:1: ( rule__And__Group__1__Impl )
            // InternalFirstOrderLogic.g:1608:2: rule__And__Group__1__Impl
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
    // InternalFirstOrderLogic.g:1614:1: rule__And__Group__1__Impl : ( ( rule__And__Group_1__0 )* ) ;
    public final void rule__And__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1618:1: ( ( ( rule__And__Group_1__0 )* ) )
            // InternalFirstOrderLogic.g:1619:1: ( ( rule__And__Group_1__0 )* )
            {
            // InternalFirstOrderLogic.g:1619:1: ( ( rule__And__Group_1__0 )* )
            // InternalFirstOrderLogic.g:1620:2: ( rule__And__Group_1__0 )*
            {
             before(grammarAccess.getAndAccess().getGroup_1()); 
            // InternalFirstOrderLogic.g:1621:2: ( rule__And__Group_1__0 )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==21) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalFirstOrderLogic.g:1621:3: rule__And__Group_1__0
            	    {
            	    pushFollow(FOLLOW_17);
            	    rule__And__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop11;
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
    // InternalFirstOrderLogic.g:1630:1: rule__And__Group_1__0 : rule__And__Group_1__0__Impl rule__And__Group_1__1 ;
    public final void rule__And__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1634:1: ( rule__And__Group_1__0__Impl rule__And__Group_1__1 )
            // InternalFirstOrderLogic.g:1635:2: rule__And__Group_1__0__Impl rule__And__Group_1__1
            {
            pushFollow(FOLLOW_16);
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
    // InternalFirstOrderLogic.g:1642:1: rule__And__Group_1__0__Impl : ( () ) ;
    public final void rule__And__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1646:1: ( ( () ) )
            // InternalFirstOrderLogic.g:1647:1: ( () )
            {
            // InternalFirstOrderLogic.g:1647:1: ( () )
            // InternalFirstOrderLogic.g:1648:2: ()
            {
             before(grammarAccess.getAndAccess().getAndLeftAction_1_0()); 
            // InternalFirstOrderLogic.g:1649:2: ()
            // InternalFirstOrderLogic.g:1649:3: 
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
    // InternalFirstOrderLogic.g:1657:1: rule__And__Group_1__1 : rule__And__Group_1__1__Impl rule__And__Group_1__2 ;
    public final void rule__And__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1661:1: ( rule__And__Group_1__1__Impl rule__And__Group_1__2 )
            // InternalFirstOrderLogic.g:1662:2: rule__And__Group_1__1__Impl rule__And__Group_1__2
            {
            pushFollow(FOLLOW_7);
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
    // InternalFirstOrderLogic.g:1669:1: rule__And__Group_1__1__Impl : ( 'and' ) ;
    public final void rule__And__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1673:1: ( ( 'and' ) )
            // InternalFirstOrderLogic.g:1674:1: ( 'and' )
            {
            // InternalFirstOrderLogic.g:1674:1: ( 'and' )
            // InternalFirstOrderLogic.g:1675:2: 'and'
            {
             before(grammarAccess.getAndAccess().getAndKeyword_1_1()); 
            match(input,21,FOLLOW_2); 
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
    // InternalFirstOrderLogic.g:1684:1: rule__And__Group_1__2 : rule__And__Group_1__2__Impl ;
    public final void rule__And__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1688:1: ( rule__And__Group_1__2__Impl )
            // InternalFirstOrderLogic.g:1689:2: rule__And__Group_1__2__Impl
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
    // InternalFirstOrderLogic.g:1695:1: rule__And__Group_1__2__Impl : ( ( rule__And__RightAssignment_1_2 ) ) ;
    public final void rule__And__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1699:1: ( ( ( rule__And__RightAssignment_1_2 ) ) )
            // InternalFirstOrderLogic.g:1700:1: ( ( rule__And__RightAssignment_1_2 ) )
            {
            // InternalFirstOrderLogic.g:1700:1: ( ( rule__And__RightAssignment_1_2 ) )
            // InternalFirstOrderLogic.g:1701:2: ( rule__And__RightAssignment_1_2 )
            {
             before(grammarAccess.getAndAccess().getRightAssignment_1_2()); 
            // InternalFirstOrderLogic.g:1702:2: ( rule__And__RightAssignment_1_2 )
            // InternalFirstOrderLogic.g:1702:3: rule__And__RightAssignment_1_2
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
    // InternalFirstOrderLogic.g:1711:1: rule__Not__Group__0 : rule__Not__Group__0__Impl rule__Not__Group__1 ;
    public final void rule__Not__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1715:1: ( rule__Not__Group__0__Impl rule__Not__Group__1 )
            // InternalFirstOrderLogic.g:1716:2: rule__Not__Group__0__Impl rule__Not__Group__1
            {
            pushFollow(FOLLOW_18);
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
    // InternalFirstOrderLogic.g:1723:1: rule__Not__Group__0__Impl : ( () ) ;
    public final void rule__Not__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1727:1: ( ( () ) )
            // InternalFirstOrderLogic.g:1728:1: ( () )
            {
            // InternalFirstOrderLogic.g:1728:1: ( () )
            // InternalFirstOrderLogic.g:1729:2: ()
            {
             before(grammarAccess.getNotAccess().getNotAction_0()); 
            // InternalFirstOrderLogic.g:1730:2: ()
            // InternalFirstOrderLogic.g:1730:3: 
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
    // InternalFirstOrderLogic.g:1738:1: rule__Not__Group__1 : rule__Not__Group__1__Impl rule__Not__Group__2 ;
    public final void rule__Not__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1742:1: ( rule__Not__Group__1__Impl rule__Not__Group__2 )
            // InternalFirstOrderLogic.g:1743:2: rule__Not__Group__1__Impl rule__Not__Group__2
            {
            pushFollow(FOLLOW_7);
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
    // InternalFirstOrderLogic.g:1750:1: rule__Not__Group__1__Impl : ( 'not(' ) ;
    public final void rule__Not__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1754:1: ( ( 'not(' ) )
            // InternalFirstOrderLogic.g:1755:1: ( 'not(' )
            {
            // InternalFirstOrderLogic.g:1755:1: ( 'not(' )
            // InternalFirstOrderLogic.g:1756:2: 'not('
            {
             before(grammarAccess.getNotAccess().getNotKeyword_1()); 
            match(input,22,FOLLOW_2); 
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
    // InternalFirstOrderLogic.g:1765:1: rule__Not__Group__2 : rule__Not__Group__2__Impl rule__Not__Group__3 ;
    public final void rule__Not__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1769:1: ( rule__Not__Group__2__Impl rule__Not__Group__3 )
            // InternalFirstOrderLogic.g:1770:2: rule__Not__Group__2__Impl rule__Not__Group__3
            {
            pushFollow(FOLLOW_19);
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
    // InternalFirstOrderLogic.g:1777:1: rule__Not__Group__2__Impl : ( ( rule__Not__NotAssignment_2 ) ) ;
    public final void rule__Not__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1781:1: ( ( ( rule__Not__NotAssignment_2 ) ) )
            // InternalFirstOrderLogic.g:1782:1: ( ( rule__Not__NotAssignment_2 ) )
            {
            // InternalFirstOrderLogic.g:1782:1: ( ( rule__Not__NotAssignment_2 ) )
            // InternalFirstOrderLogic.g:1783:2: ( rule__Not__NotAssignment_2 )
            {
             before(grammarAccess.getNotAccess().getNotAssignment_2()); 
            // InternalFirstOrderLogic.g:1784:2: ( rule__Not__NotAssignment_2 )
            // InternalFirstOrderLogic.g:1784:3: rule__Not__NotAssignment_2
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
    // InternalFirstOrderLogic.g:1792:1: rule__Not__Group__3 : rule__Not__Group__3__Impl ;
    public final void rule__Not__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1796:1: ( rule__Not__Group__3__Impl )
            // InternalFirstOrderLogic.g:1797:2: rule__Not__Group__3__Impl
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
    // InternalFirstOrderLogic.g:1803:1: rule__Not__Group__3__Impl : ( ')' ) ;
    public final void rule__Not__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1807:1: ( ( ')' ) )
            // InternalFirstOrderLogic.g:1808:1: ( ')' )
            {
            // InternalFirstOrderLogic.g:1808:1: ( ')' )
            // InternalFirstOrderLogic.g:1809:2: ')'
            {
             before(grammarAccess.getNotAccess().getRightParenthesisKeyword_3()); 
            match(input,23,FOLLOW_2); 
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


    // $ANTLR start "rule__ForAll__Group__0"
    // InternalFirstOrderLogic.g:1819:1: rule__ForAll__Group__0 : rule__ForAll__Group__0__Impl rule__ForAll__Group__1 ;
    public final void rule__ForAll__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1823:1: ( rule__ForAll__Group__0__Impl rule__ForAll__Group__1 )
            // InternalFirstOrderLogic.g:1824:2: rule__ForAll__Group__0__Impl rule__ForAll__Group__1
            {
            pushFollow(FOLLOW_20);
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
    // InternalFirstOrderLogic.g:1831:1: rule__ForAll__Group__0__Impl : ( () ) ;
    public final void rule__ForAll__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1835:1: ( ( () ) )
            // InternalFirstOrderLogic.g:1836:1: ( () )
            {
            // InternalFirstOrderLogic.g:1836:1: ( () )
            // InternalFirstOrderLogic.g:1837:2: ()
            {
             before(grammarAccess.getForAllAccess().getForAllAction_0()); 
            // InternalFirstOrderLogic.g:1838:2: ()
            // InternalFirstOrderLogic.g:1838:3: 
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
    // InternalFirstOrderLogic.g:1846:1: rule__ForAll__Group__1 : rule__ForAll__Group__1__Impl rule__ForAll__Group__2 ;
    public final void rule__ForAll__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1850:1: ( rule__ForAll__Group__1__Impl rule__ForAll__Group__2 )
            // InternalFirstOrderLogic.g:1851:2: rule__ForAll__Group__1__Impl rule__ForAll__Group__2
            {
            pushFollow(FOLLOW_5);
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
    // InternalFirstOrderLogic.g:1858:1: rule__ForAll__Group__1__Impl : ( 'forAll(' ) ;
    public final void rule__ForAll__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1862:1: ( ( 'forAll(' ) )
            // InternalFirstOrderLogic.g:1863:1: ( 'forAll(' )
            {
            // InternalFirstOrderLogic.g:1863:1: ( 'forAll(' )
            // InternalFirstOrderLogic.g:1864:2: 'forAll('
            {
             before(grammarAccess.getForAllAccess().getForAllKeyword_1()); 
            match(input,24,FOLLOW_2); 
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
    // InternalFirstOrderLogic.g:1873:1: rule__ForAll__Group__2 : rule__ForAll__Group__2__Impl rule__ForAll__Group__3 ;
    public final void rule__ForAll__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1877:1: ( rule__ForAll__Group__2__Impl rule__ForAll__Group__3 )
            // InternalFirstOrderLogic.g:1878:2: rule__ForAll__Group__2__Impl rule__ForAll__Group__3
            {
            pushFollow(FOLLOW_21);
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
    // InternalFirstOrderLogic.g:1885:1: rule__ForAll__Group__2__Impl : ( ( rule__ForAll__NameAssignment_2 ) ) ;
    public final void rule__ForAll__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1889:1: ( ( ( rule__ForAll__NameAssignment_2 ) ) )
            // InternalFirstOrderLogic.g:1890:1: ( ( rule__ForAll__NameAssignment_2 ) )
            {
            // InternalFirstOrderLogic.g:1890:1: ( ( rule__ForAll__NameAssignment_2 ) )
            // InternalFirstOrderLogic.g:1891:2: ( rule__ForAll__NameAssignment_2 )
            {
             before(grammarAccess.getForAllAccess().getNameAssignment_2()); 
            // InternalFirstOrderLogic.g:1892:2: ( rule__ForAll__NameAssignment_2 )
            // InternalFirstOrderLogic.g:1892:3: rule__ForAll__NameAssignment_2
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
    // InternalFirstOrderLogic.g:1900:1: rule__ForAll__Group__3 : rule__ForAll__Group__3__Impl rule__ForAll__Group__4 ;
    public final void rule__ForAll__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1904:1: ( rule__ForAll__Group__3__Impl rule__ForAll__Group__4 )
            // InternalFirstOrderLogic.g:1905:2: rule__ForAll__Group__3__Impl rule__ForAll__Group__4
            {
            pushFollow(FOLLOW_5);
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
    // InternalFirstOrderLogic.g:1912:1: rule__ForAll__Group__3__Impl : ( 'in' ) ;
    public final void rule__ForAll__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1916:1: ( ( 'in' ) )
            // InternalFirstOrderLogic.g:1917:1: ( 'in' )
            {
            // InternalFirstOrderLogic.g:1917:1: ( 'in' )
            // InternalFirstOrderLogic.g:1918:2: 'in'
            {
             before(grammarAccess.getForAllAccess().getInKeyword_3()); 
            match(input,25,FOLLOW_2); 
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
    // InternalFirstOrderLogic.g:1927:1: rule__ForAll__Group__4 : rule__ForAll__Group__4__Impl rule__ForAll__Group__5 ;
    public final void rule__ForAll__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1931:1: ( rule__ForAll__Group__4__Impl rule__ForAll__Group__5 )
            // InternalFirstOrderLogic.g:1932:2: rule__ForAll__Group__4__Impl rule__ForAll__Group__5
            {
            pushFollow(FOLLOW_6);
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
    // InternalFirstOrderLogic.g:1939:1: rule__ForAll__Group__4__Impl : ( ( rule__ForAll__IterationAssignment_4 ) ) ;
    public final void rule__ForAll__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1943:1: ( ( ( rule__ForAll__IterationAssignment_4 ) ) )
            // InternalFirstOrderLogic.g:1944:1: ( ( rule__ForAll__IterationAssignment_4 ) )
            {
            // InternalFirstOrderLogic.g:1944:1: ( ( rule__ForAll__IterationAssignment_4 ) )
            // InternalFirstOrderLogic.g:1945:2: ( rule__ForAll__IterationAssignment_4 )
            {
             before(grammarAccess.getForAllAccess().getIterationAssignment_4()); 
            // InternalFirstOrderLogic.g:1946:2: ( rule__ForAll__IterationAssignment_4 )
            // InternalFirstOrderLogic.g:1946:3: rule__ForAll__IterationAssignment_4
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
    // InternalFirstOrderLogic.g:1954:1: rule__ForAll__Group__5 : rule__ForAll__Group__5__Impl rule__ForAll__Group__6 ;
    public final void rule__ForAll__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1958:1: ( rule__ForAll__Group__5__Impl rule__ForAll__Group__6 )
            // InternalFirstOrderLogic.g:1959:2: rule__ForAll__Group__5__Impl rule__ForAll__Group__6
            {
            pushFollow(FOLLOW_7);
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
    // InternalFirstOrderLogic.g:1966:1: rule__ForAll__Group__5__Impl : ( ':' ) ;
    public final void rule__ForAll__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1970:1: ( ( ':' ) )
            // InternalFirstOrderLogic.g:1971:1: ( ':' )
            {
            // InternalFirstOrderLogic.g:1971:1: ( ':' )
            // InternalFirstOrderLogic.g:1972:2: ':'
            {
             before(grammarAccess.getForAllAccess().getColonKeyword_5()); 
            match(input,15,FOLLOW_2); 
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
    // InternalFirstOrderLogic.g:1981:1: rule__ForAll__Group__6 : rule__ForAll__Group__6__Impl rule__ForAll__Group__7 ;
    public final void rule__ForAll__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1985:1: ( rule__ForAll__Group__6__Impl rule__ForAll__Group__7 )
            // InternalFirstOrderLogic.g:1986:2: rule__ForAll__Group__6__Impl rule__ForAll__Group__7
            {
            pushFollow(FOLLOW_19);
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
    // InternalFirstOrderLogic.g:1993:1: rule__ForAll__Group__6__Impl : ( ( rule__ForAll__FormulaAssignment_6 ) ) ;
    public final void rule__ForAll__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1997:1: ( ( ( rule__ForAll__FormulaAssignment_6 ) ) )
            // InternalFirstOrderLogic.g:1998:1: ( ( rule__ForAll__FormulaAssignment_6 ) )
            {
            // InternalFirstOrderLogic.g:1998:1: ( ( rule__ForAll__FormulaAssignment_6 ) )
            // InternalFirstOrderLogic.g:1999:2: ( rule__ForAll__FormulaAssignment_6 )
            {
             before(grammarAccess.getForAllAccess().getFormulaAssignment_6()); 
            // InternalFirstOrderLogic.g:2000:2: ( rule__ForAll__FormulaAssignment_6 )
            // InternalFirstOrderLogic.g:2000:3: rule__ForAll__FormulaAssignment_6
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
    // InternalFirstOrderLogic.g:2008:1: rule__ForAll__Group__7 : rule__ForAll__Group__7__Impl ;
    public final void rule__ForAll__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2012:1: ( rule__ForAll__Group__7__Impl )
            // InternalFirstOrderLogic.g:2013:2: rule__ForAll__Group__7__Impl
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
    // InternalFirstOrderLogic.g:2019:1: rule__ForAll__Group__7__Impl : ( ')' ) ;
    public final void rule__ForAll__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2023:1: ( ( ')' ) )
            // InternalFirstOrderLogic.g:2024:1: ( ')' )
            {
            // InternalFirstOrderLogic.g:2024:1: ( ')' )
            // InternalFirstOrderLogic.g:2025:2: ')'
            {
             before(grammarAccess.getForAllAccess().getRightParenthesisKeyword_7()); 
            match(input,23,FOLLOW_2); 
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
    // InternalFirstOrderLogic.g:2035:1: rule__Exists__Group__0 : rule__Exists__Group__0__Impl rule__Exists__Group__1 ;
    public final void rule__Exists__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2039:1: ( rule__Exists__Group__0__Impl rule__Exists__Group__1 )
            // InternalFirstOrderLogic.g:2040:2: rule__Exists__Group__0__Impl rule__Exists__Group__1
            {
            pushFollow(FOLLOW_22);
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
    // InternalFirstOrderLogic.g:2047:1: rule__Exists__Group__0__Impl : ( () ) ;
    public final void rule__Exists__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2051:1: ( ( () ) )
            // InternalFirstOrderLogic.g:2052:1: ( () )
            {
            // InternalFirstOrderLogic.g:2052:1: ( () )
            // InternalFirstOrderLogic.g:2053:2: ()
            {
             before(grammarAccess.getExistsAccess().getExistsAction_0()); 
            // InternalFirstOrderLogic.g:2054:2: ()
            // InternalFirstOrderLogic.g:2054:3: 
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
    // InternalFirstOrderLogic.g:2062:1: rule__Exists__Group__1 : rule__Exists__Group__1__Impl rule__Exists__Group__2 ;
    public final void rule__Exists__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2066:1: ( rule__Exists__Group__1__Impl rule__Exists__Group__2 )
            // InternalFirstOrderLogic.g:2067:2: rule__Exists__Group__1__Impl rule__Exists__Group__2
            {
            pushFollow(FOLLOW_5);
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
    // InternalFirstOrderLogic.g:2074:1: rule__Exists__Group__1__Impl : ( 'exists(' ) ;
    public final void rule__Exists__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2078:1: ( ( 'exists(' ) )
            // InternalFirstOrderLogic.g:2079:1: ( 'exists(' )
            {
            // InternalFirstOrderLogic.g:2079:1: ( 'exists(' )
            // InternalFirstOrderLogic.g:2080:2: 'exists('
            {
             before(grammarAccess.getExistsAccess().getExistsKeyword_1()); 
            match(input,26,FOLLOW_2); 
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
    // InternalFirstOrderLogic.g:2089:1: rule__Exists__Group__2 : rule__Exists__Group__2__Impl rule__Exists__Group__3 ;
    public final void rule__Exists__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2093:1: ( rule__Exists__Group__2__Impl rule__Exists__Group__3 )
            // InternalFirstOrderLogic.g:2094:2: rule__Exists__Group__2__Impl rule__Exists__Group__3
            {
            pushFollow(FOLLOW_21);
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
    // InternalFirstOrderLogic.g:2101:1: rule__Exists__Group__2__Impl : ( ( rule__Exists__NameAssignment_2 ) ) ;
    public final void rule__Exists__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2105:1: ( ( ( rule__Exists__NameAssignment_2 ) ) )
            // InternalFirstOrderLogic.g:2106:1: ( ( rule__Exists__NameAssignment_2 ) )
            {
            // InternalFirstOrderLogic.g:2106:1: ( ( rule__Exists__NameAssignment_2 ) )
            // InternalFirstOrderLogic.g:2107:2: ( rule__Exists__NameAssignment_2 )
            {
             before(grammarAccess.getExistsAccess().getNameAssignment_2()); 
            // InternalFirstOrderLogic.g:2108:2: ( rule__Exists__NameAssignment_2 )
            // InternalFirstOrderLogic.g:2108:3: rule__Exists__NameAssignment_2
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
    // InternalFirstOrderLogic.g:2116:1: rule__Exists__Group__3 : rule__Exists__Group__3__Impl rule__Exists__Group__4 ;
    public final void rule__Exists__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2120:1: ( rule__Exists__Group__3__Impl rule__Exists__Group__4 )
            // InternalFirstOrderLogic.g:2121:2: rule__Exists__Group__3__Impl rule__Exists__Group__4
            {
            pushFollow(FOLLOW_5);
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
    // InternalFirstOrderLogic.g:2128:1: rule__Exists__Group__3__Impl : ( 'in' ) ;
    public final void rule__Exists__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2132:1: ( ( 'in' ) )
            // InternalFirstOrderLogic.g:2133:1: ( 'in' )
            {
            // InternalFirstOrderLogic.g:2133:1: ( 'in' )
            // InternalFirstOrderLogic.g:2134:2: 'in'
            {
             before(grammarAccess.getExistsAccess().getInKeyword_3()); 
            match(input,25,FOLLOW_2); 
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
    // InternalFirstOrderLogic.g:2143:1: rule__Exists__Group__4 : rule__Exists__Group__4__Impl rule__Exists__Group__5 ;
    public final void rule__Exists__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2147:1: ( rule__Exists__Group__4__Impl rule__Exists__Group__5 )
            // InternalFirstOrderLogic.g:2148:2: rule__Exists__Group__4__Impl rule__Exists__Group__5
            {
            pushFollow(FOLLOW_6);
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
    // InternalFirstOrderLogic.g:2155:1: rule__Exists__Group__4__Impl : ( ( rule__Exists__IterationAssignment_4 ) ) ;
    public final void rule__Exists__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2159:1: ( ( ( rule__Exists__IterationAssignment_4 ) ) )
            // InternalFirstOrderLogic.g:2160:1: ( ( rule__Exists__IterationAssignment_4 ) )
            {
            // InternalFirstOrderLogic.g:2160:1: ( ( rule__Exists__IterationAssignment_4 ) )
            // InternalFirstOrderLogic.g:2161:2: ( rule__Exists__IterationAssignment_4 )
            {
             before(grammarAccess.getExistsAccess().getIterationAssignment_4()); 
            // InternalFirstOrderLogic.g:2162:2: ( rule__Exists__IterationAssignment_4 )
            // InternalFirstOrderLogic.g:2162:3: rule__Exists__IterationAssignment_4
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
    // InternalFirstOrderLogic.g:2170:1: rule__Exists__Group__5 : rule__Exists__Group__5__Impl rule__Exists__Group__6 ;
    public final void rule__Exists__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2174:1: ( rule__Exists__Group__5__Impl rule__Exists__Group__6 )
            // InternalFirstOrderLogic.g:2175:2: rule__Exists__Group__5__Impl rule__Exists__Group__6
            {
            pushFollow(FOLLOW_7);
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
    // InternalFirstOrderLogic.g:2182:1: rule__Exists__Group__5__Impl : ( ':' ) ;
    public final void rule__Exists__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2186:1: ( ( ':' ) )
            // InternalFirstOrderLogic.g:2187:1: ( ':' )
            {
            // InternalFirstOrderLogic.g:2187:1: ( ':' )
            // InternalFirstOrderLogic.g:2188:2: ':'
            {
             before(grammarAccess.getExistsAccess().getColonKeyword_5()); 
            match(input,15,FOLLOW_2); 
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
    // InternalFirstOrderLogic.g:2197:1: rule__Exists__Group__6 : rule__Exists__Group__6__Impl rule__Exists__Group__7 ;
    public final void rule__Exists__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2201:1: ( rule__Exists__Group__6__Impl rule__Exists__Group__7 )
            // InternalFirstOrderLogic.g:2202:2: rule__Exists__Group__6__Impl rule__Exists__Group__7
            {
            pushFollow(FOLLOW_19);
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
    // InternalFirstOrderLogic.g:2209:1: rule__Exists__Group__6__Impl : ( ( rule__Exists__FormulaAssignment_6 ) ) ;
    public final void rule__Exists__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2213:1: ( ( ( rule__Exists__FormulaAssignment_6 ) ) )
            // InternalFirstOrderLogic.g:2214:1: ( ( rule__Exists__FormulaAssignment_6 ) )
            {
            // InternalFirstOrderLogic.g:2214:1: ( ( rule__Exists__FormulaAssignment_6 ) )
            // InternalFirstOrderLogic.g:2215:2: ( rule__Exists__FormulaAssignment_6 )
            {
             before(grammarAccess.getExistsAccess().getFormulaAssignment_6()); 
            // InternalFirstOrderLogic.g:2216:2: ( rule__Exists__FormulaAssignment_6 )
            // InternalFirstOrderLogic.g:2216:3: rule__Exists__FormulaAssignment_6
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
    // InternalFirstOrderLogic.g:2224:1: rule__Exists__Group__7 : rule__Exists__Group__7__Impl ;
    public final void rule__Exists__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2228:1: ( rule__Exists__Group__7__Impl )
            // InternalFirstOrderLogic.g:2229:2: rule__Exists__Group__7__Impl
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
    // InternalFirstOrderLogic.g:2235:1: rule__Exists__Group__7__Impl : ( ')' ) ;
    public final void rule__Exists__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2239:1: ( ( ')' ) )
            // InternalFirstOrderLogic.g:2240:1: ( ')' )
            {
            // InternalFirstOrderLogic.g:2240:1: ( ')' )
            // InternalFirstOrderLogic.g:2241:2: ')'
            {
             before(grammarAccess.getExistsAccess().getRightParenthesisKeyword_7()); 
            match(input,23,FOLLOW_2); 
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


    // $ANTLR start "rule__Primary__Group_0__0"
    // InternalFirstOrderLogic.g:2251:1: rule__Primary__Group_0__0 : rule__Primary__Group_0__0__Impl rule__Primary__Group_0__1 ;
    public final void rule__Primary__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2255:1: ( rule__Primary__Group_0__0__Impl rule__Primary__Group_0__1 )
            // InternalFirstOrderLogic.g:2256:2: rule__Primary__Group_0__0__Impl rule__Primary__Group_0__1
            {
            pushFollow(FOLLOW_7);
            rule__Primary__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Primary__Group_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Primary__Group_0__0"


    // $ANTLR start "rule__Primary__Group_0__0__Impl"
    // InternalFirstOrderLogic.g:2263:1: rule__Primary__Group_0__0__Impl : ( '(' ) ;
    public final void rule__Primary__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2267:1: ( ( '(' ) )
            // InternalFirstOrderLogic.g:2268:1: ( '(' )
            {
            // InternalFirstOrderLogic.g:2268:1: ( '(' )
            // InternalFirstOrderLogic.g:2269:2: '('
            {
             before(grammarAccess.getPrimaryAccess().getLeftParenthesisKeyword_0_0()); 
            match(input,27,FOLLOW_2); 
             after(grammarAccess.getPrimaryAccess().getLeftParenthesisKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Primary__Group_0__0__Impl"


    // $ANTLR start "rule__Primary__Group_0__1"
    // InternalFirstOrderLogic.g:2278:1: rule__Primary__Group_0__1 : rule__Primary__Group_0__1__Impl rule__Primary__Group_0__2 ;
    public final void rule__Primary__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2282:1: ( rule__Primary__Group_0__1__Impl rule__Primary__Group_0__2 )
            // InternalFirstOrderLogic.g:2283:2: rule__Primary__Group_0__1__Impl rule__Primary__Group_0__2
            {
            pushFollow(FOLLOW_19);
            rule__Primary__Group_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Primary__Group_0__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Primary__Group_0__1"


    // $ANTLR start "rule__Primary__Group_0__1__Impl"
    // InternalFirstOrderLogic.g:2290:1: rule__Primary__Group_0__1__Impl : ( ruleFormula ) ;
    public final void rule__Primary__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2294:1: ( ( ruleFormula ) )
            // InternalFirstOrderLogic.g:2295:1: ( ruleFormula )
            {
            // InternalFirstOrderLogic.g:2295:1: ( ruleFormula )
            // InternalFirstOrderLogic.g:2296:2: ruleFormula
            {
             before(grammarAccess.getPrimaryAccess().getFormulaParserRuleCall_0_1()); 
            pushFollow(FOLLOW_2);
            ruleFormula();

            state._fsp--;

             after(grammarAccess.getPrimaryAccess().getFormulaParserRuleCall_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Primary__Group_0__1__Impl"


    // $ANTLR start "rule__Primary__Group_0__2"
    // InternalFirstOrderLogic.g:2305:1: rule__Primary__Group_0__2 : rule__Primary__Group_0__2__Impl ;
    public final void rule__Primary__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2309:1: ( rule__Primary__Group_0__2__Impl )
            // InternalFirstOrderLogic.g:2310:2: rule__Primary__Group_0__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Primary__Group_0__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Primary__Group_0__2"


    // $ANTLR start "rule__Primary__Group_0__2__Impl"
    // InternalFirstOrderLogic.g:2316:1: rule__Primary__Group_0__2__Impl : ( ')' ) ;
    public final void rule__Primary__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2320:1: ( ( ')' ) )
            // InternalFirstOrderLogic.g:2321:1: ( ')' )
            {
            // InternalFirstOrderLogic.g:2321:1: ( ')' )
            // InternalFirstOrderLogic.g:2322:2: ')'
            {
             before(grammarAccess.getPrimaryAccess().getRightParenthesisKeyword_0_2()); 
            match(input,23,FOLLOW_2); 
             after(grammarAccess.getPrimaryAccess().getRightParenthesisKeyword_0_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Primary__Group_0__2__Impl"


    // $ANTLR start "rule__TerminalExpression__Group_0__0"
    // InternalFirstOrderLogic.g:2332:1: rule__TerminalExpression__Group_0__0 : rule__TerminalExpression__Group_0__0__Impl rule__TerminalExpression__Group_0__1 ;
    public final void rule__TerminalExpression__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2336:1: ( rule__TerminalExpression__Group_0__0__Impl rule__TerminalExpression__Group_0__1 )
            // InternalFirstOrderLogic.g:2337:2: rule__TerminalExpression__Group_0__0__Impl rule__TerminalExpression__Group_0__1
            {
            pushFollow(FOLLOW_23);
            rule__TerminalExpression__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TerminalExpression__Group_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalExpression__Group_0__0"


    // $ANTLR start "rule__TerminalExpression__Group_0__0__Impl"
    // InternalFirstOrderLogic.g:2344:1: rule__TerminalExpression__Group_0__0__Impl : ( () ) ;
    public final void rule__TerminalExpression__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2348:1: ( ( () ) )
            // InternalFirstOrderLogic.g:2349:1: ( () )
            {
            // InternalFirstOrderLogic.g:2349:1: ( () )
            // InternalFirstOrderLogic.g:2350:2: ()
            {
             before(grammarAccess.getTerminalExpressionAccess().getIntConstantAction_0_0()); 
            // InternalFirstOrderLogic.g:2351:2: ()
            // InternalFirstOrderLogic.g:2351:3: 
            {
            }

             after(grammarAccess.getTerminalExpressionAccess().getIntConstantAction_0_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalExpression__Group_0__0__Impl"


    // $ANTLR start "rule__TerminalExpression__Group_0__1"
    // InternalFirstOrderLogic.g:2359:1: rule__TerminalExpression__Group_0__1 : rule__TerminalExpression__Group_0__1__Impl ;
    public final void rule__TerminalExpression__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2363:1: ( rule__TerminalExpression__Group_0__1__Impl )
            // InternalFirstOrderLogic.g:2364:2: rule__TerminalExpression__Group_0__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TerminalExpression__Group_0__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalExpression__Group_0__1"


    // $ANTLR start "rule__TerminalExpression__Group_0__1__Impl"
    // InternalFirstOrderLogic.g:2370:1: rule__TerminalExpression__Group_0__1__Impl : ( ( rule__TerminalExpression__ValueAssignment_0_1 ) ) ;
    public final void rule__TerminalExpression__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2374:1: ( ( ( rule__TerminalExpression__ValueAssignment_0_1 ) ) )
            // InternalFirstOrderLogic.g:2375:1: ( ( rule__TerminalExpression__ValueAssignment_0_1 ) )
            {
            // InternalFirstOrderLogic.g:2375:1: ( ( rule__TerminalExpression__ValueAssignment_0_1 ) )
            // InternalFirstOrderLogic.g:2376:2: ( rule__TerminalExpression__ValueAssignment_0_1 )
            {
             before(grammarAccess.getTerminalExpressionAccess().getValueAssignment_0_1()); 
            // InternalFirstOrderLogic.g:2377:2: ( rule__TerminalExpression__ValueAssignment_0_1 )
            // InternalFirstOrderLogic.g:2377:3: rule__TerminalExpression__ValueAssignment_0_1
            {
            pushFollow(FOLLOW_2);
            rule__TerminalExpression__ValueAssignment_0_1();

            state._fsp--;


            }

             after(grammarAccess.getTerminalExpressionAccess().getValueAssignment_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalExpression__Group_0__1__Impl"


    // $ANTLR start "rule__TerminalExpression__Group_1__0"
    // InternalFirstOrderLogic.g:2386:1: rule__TerminalExpression__Group_1__0 : rule__TerminalExpression__Group_1__0__Impl rule__TerminalExpression__Group_1__1 ;
    public final void rule__TerminalExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2390:1: ( rule__TerminalExpression__Group_1__0__Impl rule__TerminalExpression__Group_1__1 )
            // InternalFirstOrderLogic.g:2391:2: rule__TerminalExpression__Group_1__0__Impl rule__TerminalExpression__Group_1__1
            {
            pushFollow(FOLLOW_3);
            rule__TerminalExpression__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TerminalExpression__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalExpression__Group_1__0"


    // $ANTLR start "rule__TerminalExpression__Group_1__0__Impl"
    // InternalFirstOrderLogic.g:2398:1: rule__TerminalExpression__Group_1__0__Impl : ( () ) ;
    public final void rule__TerminalExpression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2402:1: ( ( () ) )
            // InternalFirstOrderLogic.g:2403:1: ( () )
            {
            // InternalFirstOrderLogic.g:2403:1: ( () )
            // InternalFirstOrderLogic.g:2404:2: ()
            {
             before(grammarAccess.getTerminalExpressionAccess().getStringConstantAction_1_0()); 
            // InternalFirstOrderLogic.g:2405:2: ()
            // InternalFirstOrderLogic.g:2405:3: 
            {
            }

             after(grammarAccess.getTerminalExpressionAccess().getStringConstantAction_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalExpression__Group_1__0__Impl"


    // $ANTLR start "rule__TerminalExpression__Group_1__1"
    // InternalFirstOrderLogic.g:2413:1: rule__TerminalExpression__Group_1__1 : rule__TerminalExpression__Group_1__1__Impl ;
    public final void rule__TerminalExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2417:1: ( rule__TerminalExpression__Group_1__1__Impl )
            // InternalFirstOrderLogic.g:2418:2: rule__TerminalExpression__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TerminalExpression__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalExpression__Group_1__1"


    // $ANTLR start "rule__TerminalExpression__Group_1__1__Impl"
    // InternalFirstOrderLogic.g:2424:1: rule__TerminalExpression__Group_1__1__Impl : ( ( rule__TerminalExpression__ValueAssignment_1_1 ) ) ;
    public final void rule__TerminalExpression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2428:1: ( ( ( rule__TerminalExpression__ValueAssignment_1_1 ) ) )
            // InternalFirstOrderLogic.g:2429:1: ( ( rule__TerminalExpression__ValueAssignment_1_1 ) )
            {
            // InternalFirstOrderLogic.g:2429:1: ( ( rule__TerminalExpression__ValueAssignment_1_1 ) )
            // InternalFirstOrderLogic.g:2430:2: ( rule__TerminalExpression__ValueAssignment_1_1 )
            {
             before(grammarAccess.getTerminalExpressionAccess().getValueAssignment_1_1()); 
            // InternalFirstOrderLogic.g:2431:2: ( rule__TerminalExpression__ValueAssignment_1_1 )
            // InternalFirstOrderLogic.g:2431:3: rule__TerminalExpression__ValueAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__TerminalExpression__ValueAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getTerminalExpressionAccess().getValueAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalExpression__Group_1__1__Impl"


    // $ANTLR start "rule__TerminalExpression__Group_2__0"
    // InternalFirstOrderLogic.g:2440:1: rule__TerminalExpression__Group_2__0 : rule__TerminalExpression__Group_2__0__Impl rule__TerminalExpression__Group_2__1 ;
    public final void rule__TerminalExpression__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2444:1: ( rule__TerminalExpression__Group_2__0__Impl rule__TerminalExpression__Group_2__1 )
            // InternalFirstOrderLogic.g:2445:2: rule__TerminalExpression__Group_2__0__Impl rule__TerminalExpression__Group_2__1
            {
            pushFollow(FOLLOW_24);
            rule__TerminalExpression__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TerminalExpression__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalExpression__Group_2__0"


    // $ANTLR start "rule__TerminalExpression__Group_2__0__Impl"
    // InternalFirstOrderLogic.g:2452:1: rule__TerminalExpression__Group_2__0__Impl : ( () ) ;
    public final void rule__TerminalExpression__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2456:1: ( ( () ) )
            // InternalFirstOrderLogic.g:2457:1: ( () )
            {
            // InternalFirstOrderLogic.g:2457:1: ( () )
            // InternalFirstOrderLogic.g:2458:2: ()
            {
             before(grammarAccess.getTerminalExpressionAccess().getBoolConstantAction_2_0()); 
            // InternalFirstOrderLogic.g:2459:2: ()
            // InternalFirstOrderLogic.g:2459:3: 
            {
            }

             after(grammarAccess.getTerminalExpressionAccess().getBoolConstantAction_2_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalExpression__Group_2__0__Impl"


    // $ANTLR start "rule__TerminalExpression__Group_2__1"
    // InternalFirstOrderLogic.g:2467:1: rule__TerminalExpression__Group_2__1 : rule__TerminalExpression__Group_2__1__Impl ;
    public final void rule__TerminalExpression__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2471:1: ( rule__TerminalExpression__Group_2__1__Impl )
            // InternalFirstOrderLogic.g:2472:2: rule__TerminalExpression__Group_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TerminalExpression__Group_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalExpression__Group_2__1"


    // $ANTLR start "rule__TerminalExpression__Group_2__1__Impl"
    // InternalFirstOrderLogic.g:2478:1: rule__TerminalExpression__Group_2__1__Impl : ( ( rule__TerminalExpression__ValueAssignment_2_1 ) ) ;
    public final void rule__TerminalExpression__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2482:1: ( ( ( rule__TerminalExpression__ValueAssignment_2_1 ) ) )
            // InternalFirstOrderLogic.g:2483:1: ( ( rule__TerminalExpression__ValueAssignment_2_1 ) )
            {
            // InternalFirstOrderLogic.g:2483:1: ( ( rule__TerminalExpression__ValueAssignment_2_1 ) )
            // InternalFirstOrderLogic.g:2484:2: ( rule__TerminalExpression__ValueAssignment_2_1 )
            {
             before(grammarAccess.getTerminalExpressionAccess().getValueAssignment_2_1()); 
            // InternalFirstOrderLogic.g:2485:2: ( rule__TerminalExpression__ValueAssignment_2_1 )
            // InternalFirstOrderLogic.g:2485:3: rule__TerminalExpression__ValueAssignment_2_1
            {
            pushFollow(FOLLOW_2);
            rule__TerminalExpression__ValueAssignment_2_1();

            state._fsp--;


            }

             after(grammarAccess.getTerminalExpressionAccess().getValueAssignment_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalExpression__Group_2__1__Impl"


    // $ANTLR start "rule__TerminalExpression__Group_3__0"
    // InternalFirstOrderLogic.g:2494:1: rule__TerminalExpression__Group_3__0 : rule__TerminalExpression__Group_3__0__Impl rule__TerminalExpression__Group_3__1 ;
    public final void rule__TerminalExpression__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2498:1: ( rule__TerminalExpression__Group_3__0__Impl rule__TerminalExpression__Group_3__1 )
            // InternalFirstOrderLogic.g:2499:2: rule__TerminalExpression__Group_3__0__Impl rule__TerminalExpression__Group_3__1
            {
            pushFollow(FOLLOW_7);
            rule__TerminalExpression__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TerminalExpression__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalExpression__Group_3__0"


    // $ANTLR start "rule__TerminalExpression__Group_3__0__Impl"
    // InternalFirstOrderLogic.g:2506:1: rule__TerminalExpression__Group_3__0__Impl : ( () ) ;
    public final void rule__TerminalExpression__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2510:1: ( ( () ) )
            // InternalFirstOrderLogic.g:2511:1: ( () )
            {
            // InternalFirstOrderLogic.g:2511:1: ( () )
            // InternalFirstOrderLogic.g:2512:2: ()
            {
             before(grammarAccess.getTerminalExpressionAccess().getVariableRefAction_3_0()); 
            // InternalFirstOrderLogic.g:2513:2: ()
            // InternalFirstOrderLogic.g:2513:3: 
            {
            }

             after(grammarAccess.getTerminalExpressionAccess().getVariableRefAction_3_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalExpression__Group_3__0__Impl"


    // $ANTLR start "rule__TerminalExpression__Group_3__1"
    // InternalFirstOrderLogic.g:2521:1: rule__TerminalExpression__Group_3__1 : rule__TerminalExpression__Group_3__1__Impl ;
    public final void rule__TerminalExpression__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2525:1: ( rule__TerminalExpression__Group_3__1__Impl )
            // InternalFirstOrderLogic.g:2526:2: rule__TerminalExpression__Group_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TerminalExpression__Group_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalExpression__Group_3__1"


    // $ANTLR start "rule__TerminalExpression__Group_3__1__Impl"
    // InternalFirstOrderLogic.g:2532:1: rule__TerminalExpression__Group_3__1__Impl : ( ( rule__TerminalExpression__VariableAssignment_3_1 ) ) ;
    public final void rule__TerminalExpression__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2536:1: ( ( ( rule__TerminalExpression__VariableAssignment_3_1 ) ) )
            // InternalFirstOrderLogic.g:2537:1: ( ( rule__TerminalExpression__VariableAssignment_3_1 ) )
            {
            // InternalFirstOrderLogic.g:2537:1: ( ( rule__TerminalExpression__VariableAssignment_3_1 ) )
            // InternalFirstOrderLogic.g:2538:2: ( rule__TerminalExpression__VariableAssignment_3_1 )
            {
             before(grammarAccess.getTerminalExpressionAccess().getVariableAssignment_3_1()); 
            // InternalFirstOrderLogic.g:2539:2: ( rule__TerminalExpression__VariableAssignment_3_1 )
            // InternalFirstOrderLogic.g:2539:3: rule__TerminalExpression__VariableAssignment_3_1
            {
            pushFollow(FOLLOW_2);
            rule__TerminalExpression__VariableAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getTerminalExpressionAccess().getVariableAssignment_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalExpression__Group_3__1__Impl"


    // $ANTLR start "rule__ConstraintRuleBase__DomainAssignment_1"
    // InternalFirstOrderLogic.g:2548:1: rule__ConstraintRuleBase__DomainAssignment_1 : ( RULE_STRING ) ;
    public final void rule__ConstraintRuleBase__DomainAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2552:1: ( ( RULE_STRING ) )
            // InternalFirstOrderLogic.g:2553:2: ( RULE_STRING )
            {
            // InternalFirstOrderLogic.g:2553:2: ( RULE_STRING )
            // InternalFirstOrderLogic.g:2554:3: RULE_STRING
            {
             before(grammarAccess.getConstraintRuleBaseAccess().getDomainSTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getConstraintRuleBaseAccess().getDomainSTRINGTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintRuleBase__DomainAssignment_1"


    // $ANTLR start "rule__ConstraintRuleBase__ConstraintsAssignment_2"
    // InternalFirstOrderLogic.g:2563:1: rule__ConstraintRuleBase__ConstraintsAssignment_2 : ( ruleConstraint ) ;
    public final void rule__ConstraintRuleBase__ConstraintsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2567:1: ( ( ruleConstraint ) )
            // InternalFirstOrderLogic.g:2568:2: ( ruleConstraint )
            {
            // InternalFirstOrderLogic.g:2568:2: ( ruleConstraint )
            // InternalFirstOrderLogic.g:2569:3: ruleConstraint
            {
             before(grammarAccess.getConstraintRuleBaseAccess().getConstraintsConstraintParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleConstraint();

            state._fsp--;

             after(grammarAccess.getConstraintRuleBaseAccess().getConstraintsConstraintParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintRuleBase__ConstraintsAssignment_2"


    // $ANTLR start "rule__Constraint__VariableAssignment_1"
    // InternalFirstOrderLogic.g:2578:1: rule__Constraint__VariableAssignment_1 : ( ruleVariable ) ;
    public final void rule__Constraint__VariableAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2582:1: ( ( ruleVariable ) )
            // InternalFirstOrderLogic.g:2583:2: ( ruleVariable )
            {
            // InternalFirstOrderLogic.g:2583:2: ( ruleVariable )
            // InternalFirstOrderLogic.g:2584:3: ruleVariable
            {
             before(grammarAccess.getConstraintAccess().getVariableVariableParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleVariable();

            state._fsp--;

             after(grammarAccess.getConstraintAccess().getVariableVariableParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraint__VariableAssignment_1"


    // $ANTLR start "rule__Constraint__FormulaAssignment_3"
    // InternalFirstOrderLogic.g:2593:1: rule__Constraint__FormulaAssignment_3 : ( ruleFormula ) ;
    public final void rule__Constraint__FormulaAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2597:1: ( ( ruleFormula ) )
            // InternalFirstOrderLogic.g:2598:2: ( ruleFormula )
            {
            // InternalFirstOrderLogic.g:2598:2: ( ruleFormula )
            // InternalFirstOrderLogic.g:2599:3: ruleFormula
            {
             before(grammarAccess.getConstraintAccess().getFormulaFormulaParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleFormula();

            state._fsp--;

             after(grammarAccess.getConstraintAccess().getFormulaFormulaParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraint__FormulaAssignment_3"


    // $ANTLR start "rule__Variable__TypeAssignment_0"
    // InternalFirstOrderLogic.g:2608:1: rule__Variable__TypeAssignment_0 : ( RULE_ID ) ;
    public final void rule__Variable__TypeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2612:1: ( ( RULE_ID ) )
            // InternalFirstOrderLogic.g:2613:2: ( RULE_ID )
            {
            // InternalFirstOrderLogic.g:2613:2: ( RULE_ID )
            // InternalFirstOrderLogic.g:2614:3: RULE_ID
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
    // InternalFirstOrderLogic.g:2623:1: rule__Variable__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Variable__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2627:1: ( ( RULE_ID ) )
            // InternalFirstOrderLogic.g:2628:2: ( RULE_ID )
            {
            // InternalFirstOrderLogic.g:2628:2: ( RULE_ID )
            // InternalFirstOrderLogic.g:2629:3: RULE_ID
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


    // $ANTLR start "rule__GetTerm__NameAssignment_1"
    // InternalFirstOrderLogic.g:2638:1: rule__GetTerm__NameAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__GetTerm__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2642:1: ( ( ( RULE_ID ) ) )
            // InternalFirstOrderLogic.g:2643:2: ( ( RULE_ID ) )
            {
            // InternalFirstOrderLogic.g:2643:2: ( ( RULE_ID ) )
            // InternalFirstOrderLogic.g:2644:3: ( RULE_ID )
            {
             before(grammarAccess.getGetTermAccess().getNameVariableCrossReference_1_0()); 
            // InternalFirstOrderLogic.g:2645:3: ( RULE_ID )
            // InternalFirstOrderLogic.g:2646:4: RULE_ID
            {
             before(grammarAccess.getGetTermAccess().getNameVariableIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getGetTermAccess().getNameVariableIDTerminalRuleCall_1_0_1()); 

            }

             after(grammarAccess.getGetTermAccess().getNameVariableCrossReference_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GetTerm__NameAssignment_1"


    // $ANTLR start "rule__GetTerm__FeatureAssignment_2"
    // InternalFirstOrderLogic.g:2657:1: rule__GetTerm__FeatureAssignment_2 : ( ruleGet ) ;
    public final void rule__GetTerm__FeatureAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2661:1: ( ( ruleGet ) )
            // InternalFirstOrderLogic.g:2662:2: ( ruleGet )
            {
            // InternalFirstOrderLogic.g:2662:2: ( ruleGet )
            // InternalFirstOrderLogic.g:2663:3: ruleGet
            {
             before(grammarAccess.getGetTermAccess().getFeatureGetParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleGet();

            state._fsp--;

             after(grammarAccess.getGetTermAccess().getFeatureGetParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GetTerm__FeatureAssignment_2"


    // $ANTLR start "rule__Get__TypeAssignment_1_0"
    // InternalFirstOrderLogic.g:2672:1: rule__Get__TypeAssignment_1_0 : ( RULE_ID ) ;
    public final void rule__Get__TypeAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2676:1: ( ( RULE_ID ) )
            // InternalFirstOrderLogic.g:2677:2: ( RULE_ID )
            {
            // InternalFirstOrderLogic.g:2677:2: ( RULE_ID )
            // InternalFirstOrderLogic.g:2678:3: RULE_ID
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
    // InternalFirstOrderLogic.g:2687:1: rule__Get__NameAssignment_2 : ( ( ruleFeature ) ) ;
    public final void rule__Get__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2691:1: ( ( ( ruleFeature ) ) )
            // InternalFirstOrderLogic.g:2692:2: ( ( ruleFeature ) )
            {
            // InternalFirstOrderLogic.g:2692:2: ( ( ruleFeature ) )
            // InternalFirstOrderLogic.g:2693:3: ( ruleFeature )
            {
             before(grammarAccess.getGetAccess().getNameEStructuralFeatureCrossReference_2_0()); 
            // InternalFirstOrderLogic.g:2694:3: ( ruleFeature )
            // InternalFirstOrderLogic.g:2695:4: ruleFeature
            {
             before(grammarAccess.getGetAccess().getNameEStructuralFeatureFeatureParserRuleCall_2_0_1()); 
            pushFollow(FOLLOW_2);
            ruleFeature();

            state._fsp--;

             after(grammarAccess.getGetAccess().getNameEStructuralFeatureFeatureParserRuleCall_2_0_1()); 

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
    // InternalFirstOrderLogic.g:2706:1: rule__Get__NextAssignment_3 : ( ruleGet ) ;
    public final void rule__Get__NextAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2710:1: ( ( ruleGet ) )
            // InternalFirstOrderLogic.g:2711:2: ( ruleGet )
            {
            // InternalFirstOrderLogic.g:2711:2: ( ruleGet )
            // InternalFirstOrderLogic.g:2712:3: ruleGet
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


    // $ANTLR start "rule__If__RightAssignment_1_2"
    // InternalFirstOrderLogic.g:2721:1: rule__If__RightAssignment_1_2 : ( ruleXor ) ;
    public final void rule__If__RightAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2725:1: ( ( ruleXor ) )
            // InternalFirstOrderLogic.g:2726:2: ( ruleXor )
            {
            // InternalFirstOrderLogic.g:2726:2: ( ruleXor )
            // InternalFirstOrderLogic.g:2727:3: ruleXor
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
    // InternalFirstOrderLogic.g:2736:1: rule__Xor__RightAssignment_1_2 : ( ruleOr ) ;
    public final void rule__Xor__RightAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2740:1: ( ( ruleOr ) )
            // InternalFirstOrderLogic.g:2741:2: ( ruleOr )
            {
            // InternalFirstOrderLogic.g:2741:2: ( ruleOr )
            // InternalFirstOrderLogic.g:2742:3: ruleOr
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
    // InternalFirstOrderLogic.g:2751:1: rule__Or__RightAssignment_1_2 : ( ruleAnd ) ;
    public final void rule__Or__RightAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2755:1: ( ( ruleAnd ) )
            // InternalFirstOrderLogic.g:2756:2: ( ruleAnd )
            {
            // InternalFirstOrderLogic.g:2756:2: ( ruleAnd )
            // InternalFirstOrderLogic.g:2757:3: ruleAnd
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
    // InternalFirstOrderLogic.g:2766:1: rule__And__RightAssignment_1_2 : ( rulePrimary ) ;
    public final void rule__And__RightAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2770:1: ( ( rulePrimary ) )
            // InternalFirstOrderLogic.g:2771:2: ( rulePrimary )
            {
            // InternalFirstOrderLogic.g:2771:2: ( rulePrimary )
            // InternalFirstOrderLogic.g:2772:3: rulePrimary
            {
             before(grammarAccess.getAndAccess().getRightPrimaryParserRuleCall_1_2_0()); 
            pushFollow(FOLLOW_2);
            rulePrimary();

            state._fsp--;

             after(grammarAccess.getAndAccess().getRightPrimaryParserRuleCall_1_2_0()); 

            }


            }

        }
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
    // InternalFirstOrderLogic.g:2781:1: rule__Not__NotAssignment_2 : ( ruleFormula ) ;
    public final void rule__Not__NotAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2785:1: ( ( ruleFormula ) )
            // InternalFirstOrderLogic.g:2786:2: ( ruleFormula )
            {
            // InternalFirstOrderLogic.g:2786:2: ( ruleFormula )
            // InternalFirstOrderLogic.g:2787:3: ruleFormula
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


    // $ANTLR start "rule__ForAll__NameAssignment_2"
    // InternalFirstOrderLogic.g:2796:1: rule__ForAll__NameAssignment_2 : ( ruleVariable ) ;
    public final void rule__ForAll__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2800:1: ( ( ruleVariable ) )
            // InternalFirstOrderLogic.g:2801:2: ( ruleVariable )
            {
            // InternalFirstOrderLogic.g:2801:2: ( ruleVariable )
            // InternalFirstOrderLogic.g:2802:3: ruleVariable
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
    // InternalFirstOrderLogic.g:2811:1: rule__ForAll__IterationAssignment_4 : ( ruleTerm ) ;
    public final void rule__ForAll__IterationAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2815:1: ( ( ruleTerm ) )
            // InternalFirstOrderLogic.g:2816:2: ( ruleTerm )
            {
            // InternalFirstOrderLogic.g:2816:2: ( ruleTerm )
            // InternalFirstOrderLogic.g:2817:3: ruleTerm
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
    // InternalFirstOrderLogic.g:2826:1: rule__ForAll__FormulaAssignment_6 : ( ruleFormula ) ;
    public final void rule__ForAll__FormulaAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2830:1: ( ( ruleFormula ) )
            // InternalFirstOrderLogic.g:2831:2: ( ruleFormula )
            {
            // InternalFirstOrderLogic.g:2831:2: ( ruleFormula )
            // InternalFirstOrderLogic.g:2832:3: ruleFormula
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
    // InternalFirstOrderLogic.g:2841:1: rule__Exists__NameAssignment_2 : ( ruleVariable ) ;
    public final void rule__Exists__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2845:1: ( ( ruleVariable ) )
            // InternalFirstOrderLogic.g:2846:2: ( ruleVariable )
            {
            // InternalFirstOrderLogic.g:2846:2: ( ruleVariable )
            // InternalFirstOrderLogic.g:2847:3: ruleVariable
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
    // InternalFirstOrderLogic.g:2856:1: rule__Exists__IterationAssignment_4 : ( ruleTerm ) ;
    public final void rule__Exists__IterationAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2860:1: ( ( ruleTerm ) )
            // InternalFirstOrderLogic.g:2861:2: ( ruleTerm )
            {
            // InternalFirstOrderLogic.g:2861:2: ( ruleTerm )
            // InternalFirstOrderLogic.g:2862:3: ruleTerm
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
    // InternalFirstOrderLogic.g:2871:1: rule__Exists__FormulaAssignment_6 : ( ruleFormula ) ;
    public final void rule__Exists__FormulaAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2875:1: ( ( ruleFormula ) )
            // InternalFirstOrderLogic.g:2876:2: ( ruleFormula )
            {
            // InternalFirstOrderLogic.g:2876:2: ( ruleFormula )
            // InternalFirstOrderLogic.g:2877:3: ruleFormula
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


    // $ANTLR start "rule__TerminalExpression__ValueAssignment_0_1"
    // InternalFirstOrderLogic.g:2886:1: rule__TerminalExpression__ValueAssignment_0_1 : ( RULE_INT ) ;
    public final void rule__TerminalExpression__ValueAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2890:1: ( ( RULE_INT ) )
            // InternalFirstOrderLogic.g:2891:2: ( RULE_INT )
            {
            // InternalFirstOrderLogic.g:2891:2: ( RULE_INT )
            // InternalFirstOrderLogic.g:2892:3: RULE_INT
            {
             before(grammarAccess.getTerminalExpressionAccess().getValueINTTerminalRuleCall_0_1_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getTerminalExpressionAccess().getValueINTTerminalRuleCall_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalExpression__ValueAssignment_0_1"


    // $ANTLR start "rule__TerminalExpression__ValueAssignment_1_1"
    // InternalFirstOrderLogic.g:2901:1: rule__TerminalExpression__ValueAssignment_1_1 : ( RULE_STRING ) ;
    public final void rule__TerminalExpression__ValueAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2905:1: ( ( RULE_STRING ) )
            // InternalFirstOrderLogic.g:2906:2: ( RULE_STRING )
            {
            // InternalFirstOrderLogic.g:2906:2: ( RULE_STRING )
            // InternalFirstOrderLogic.g:2907:3: RULE_STRING
            {
             before(grammarAccess.getTerminalExpressionAccess().getValueSTRINGTerminalRuleCall_1_1_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getTerminalExpressionAccess().getValueSTRINGTerminalRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalExpression__ValueAssignment_1_1"


    // $ANTLR start "rule__TerminalExpression__ValueAssignment_2_1"
    // InternalFirstOrderLogic.g:2916:1: rule__TerminalExpression__ValueAssignment_2_1 : ( ( rule__TerminalExpression__ValueAlternatives_2_1_0 ) ) ;
    public final void rule__TerminalExpression__ValueAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2920:1: ( ( ( rule__TerminalExpression__ValueAlternatives_2_1_0 ) ) )
            // InternalFirstOrderLogic.g:2921:2: ( ( rule__TerminalExpression__ValueAlternatives_2_1_0 ) )
            {
            // InternalFirstOrderLogic.g:2921:2: ( ( rule__TerminalExpression__ValueAlternatives_2_1_0 ) )
            // InternalFirstOrderLogic.g:2922:3: ( rule__TerminalExpression__ValueAlternatives_2_1_0 )
            {
             before(grammarAccess.getTerminalExpressionAccess().getValueAlternatives_2_1_0()); 
            // InternalFirstOrderLogic.g:2923:3: ( rule__TerminalExpression__ValueAlternatives_2_1_0 )
            // InternalFirstOrderLogic.g:2923:4: rule__TerminalExpression__ValueAlternatives_2_1_0
            {
            pushFollow(FOLLOW_2);
            rule__TerminalExpression__ValueAlternatives_2_1_0();

            state._fsp--;


            }

             after(grammarAccess.getTerminalExpressionAccess().getValueAlternatives_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalExpression__ValueAssignment_2_1"


    // $ANTLR start "rule__TerminalExpression__VariableAssignment_3_1"
    // InternalFirstOrderLogic.g:2931:1: rule__TerminalExpression__VariableAssignment_3_1 : ( ( RULE_ID ) ) ;
    public final void rule__TerminalExpression__VariableAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2935:1: ( ( ( RULE_ID ) ) )
            // InternalFirstOrderLogic.g:2936:2: ( ( RULE_ID ) )
            {
            // InternalFirstOrderLogic.g:2936:2: ( ( RULE_ID ) )
            // InternalFirstOrderLogic.g:2937:3: ( RULE_ID )
            {
             before(grammarAccess.getTerminalExpressionAccess().getVariableVariableCrossReference_3_1_0()); 
            // InternalFirstOrderLogic.g:2938:3: ( RULE_ID )
            // InternalFirstOrderLogic.g:2939:4: RULE_ID
            {
             before(grammarAccess.getTerminalExpressionAccess().getVariableVariableIDTerminalRuleCall_3_1_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getTerminalExpressionAccess().getVariableVariableIDTerminalRuleCall_3_1_0_1()); 

            }

             after(grammarAccess.getTerminalExpressionAccess().getVariableVariableCrossReference_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalExpression__VariableAssignment_3_1"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x000000000D401870L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000005000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000001800L});

}