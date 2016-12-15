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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'true'", "'false'", "'domain'", "'context'", "':'", "'.'", "'::'", "'='", "'implies'", "'xor'", "'or'", "'and'", "'not('", "')'", "'isEmpty('", "'>'", "'>='", "'<'", "'<='", "'forAll('", "'in'", "'exists('", "'('"
    };
    public static final int RULE_STRING=5;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__33=33;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_ID=4;
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


    // $ANTLR start "entryRuleTerm"
    // InternalFirstOrderLogic.g:103:1: entryRuleTerm : ruleTerm EOF ;
    public final void entryRuleTerm() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:104:1: ( ruleTerm EOF )
            // InternalFirstOrderLogic.g:105:1: ruleTerm EOF
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
    // InternalFirstOrderLogic.g:112:1: ruleTerm : ( ( rule__Term__Alternatives ) ) ;
    public final void ruleTerm() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:116:2: ( ( ( rule__Term__Alternatives ) ) )
            // InternalFirstOrderLogic.g:117:2: ( ( rule__Term__Alternatives ) )
            {
            // InternalFirstOrderLogic.g:117:2: ( ( rule__Term__Alternatives ) )
            // InternalFirstOrderLogic.g:118:3: ( rule__Term__Alternatives )
            {
             before(grammarAccess.getTermAccess().getAlternatives()); 
            // InternalFirstOrderLogic.g:119:3: ( rule__Term__Alternatives )
            // InternalFirstOrderLogic.g:119:4: rule__Term__Alternatives
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


    // $ANTLR start "entryRuleVariable"
    // InternalFirstOrderLogic.g:128:1: entryRuleVariable : ruleVariable EOF ;
    public final void entryRuleVariable() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:129:1: ( ruleVariable EOF )
            // InternalFirstOrderLogic.g:130:1: ruleVariable EOF
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
    // InternalFirstOrderLogic.g:137:1: ruleVariable : ( ( rule__Variable__Group__0 ) ) ;
    public final void ruleVariable() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:141:2: ( ( ( rule__Variable__Group__0 ) ) )
            // InternalFirstOrderLogic.g:142:2: ( ( rule__Variable__Group__0 ) )
            {
            // InternalFirstOrderLogic.g:142:2: ( ( rule__Variable__Group__0 ) )
            // InternalFirstOrderLogic.g:143:3: ( rule__Variable__Group__0 )
            {
             before(grammarAccess.getVariableAccess().getGroup()); 
            // InternalFirstOrderLogic.g:144:3: ( rule__Variable__Group__0 )
            // InternalFirstOrderLogic.g:144:4: rule__Variable__Group__0
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
    // InternalFirstOrderLogic.g:262:1: ruleFormula : ( ruleEquality ) ;
    public final void ruleFormula() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:266:2: ( ( ruleEquality ) )
            // InternalFirstOrderLogic.g:267:2: ( ruleEquality )
            {
            // InternalFirstOrderLogic.g:267:2: ( ruleEquality )
            // InternalFirstOrderLogic.g:268:3: ruleEquality
            {
             before(grammarAccess.getFormulaAccess().getEqualityParserRuleCall()); 
            pushFollow(FOLLOW_2);
            ruleEquality();

            state._fsp--;

             after(grammarAccess.getFormulaAccess().getEqualityParserRuleCall()); 

            }


            }

        }
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


    // $ANTLR start "entryRuleEquality"
    // InternalFirstOrderLogic.g:278:1: entryRuleEquality : ruleEquality EOF ;
    public final void entryRuleEquality() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:279:1: ( ruleEquality EOF )
            // InternalFirstOrderLogic.g:280:1: ruleEquality EOF
            {
             before(grammarAccess.getEqualityRule()); 
            pushFollow(FOLLOW_1);
            ruleEquality();

            state._fsp--;

             after(grammarAccess.getEqualityRule()); 
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
    // $ANTLR end "entryRuleEquality"


    // $ANTLR start "ruleEquality"
    // InternalFirstOrderLogic.g:287:1: ruleEquality : ( ( rule__Equality__Group__0 ) ) ;
    public final void ruleEquality() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:291:2: ( ( ( rule__Equality__Group__0 ) ) )
            // InternalFirstOrderLogic.g:292:2: ( ( rule__Equality__Group__0 ) )
            {
            // InternalFirstOrderLogic.g:292:2: ( ( rule__Equality__Group__0 ) )
            // InternalFirstOrderLogic.g:293:3: ( rule__Equality__Group__0 )
            {
             before(grammarAccess.getEqualityAccess().getGroup()); 
            // InternalFirstOrderLogic.g:294:3: ( rule__Equality__Group__0 )
            // InternalFirstOrderLogic.g:294:4: rule__Equality__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Equality__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getEqualityAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEquality"


    // $ANTLR start "entryRuleBinaryFormula"
    // InternalFirstOrderLogic.g:303:1: entryRuleBinaryFormula : ruleBinaryFormula EOF ;
    public final void entryRuleBinaryFormula() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:304:1: ( ruleBinaryFormula EOF )
            // InternalFirstOrderLogic.g:305:1: ruleBinaryFormula EOF
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
    // InternalFirstOrderLogic.g:312:1: ruleBinaryFormula : ( ruleIf ) ;
    public final void ruleBinaryFormula() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:316:2: ( ( ruleIf ) )
            // InternalFirstOrderLogic.g:317:2: ( ruleIf )
            {
            // InternalFirstOrderLogic.g:317:2: ( ruleIf )
            // InternalFirstOrderLogic.g:318:3: ruleIf
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
    // InternalFirstOrderLogic.g:328:1: entryRuleIf : ruleIf EOF ;
    public final void entryRuleIf() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:329:1: ( ruleIf EOF )
            // InternalFirstOrderLogic.g:330:1: ruleIf EOF
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
    // InternalFirstOrderLogic.g:337:1: ruleIf : ( ( rule__If__Group__0 ) ) ;
    public final void ruleIf() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:341:2: ( ( ( rule__If__Group__0 ) ) )
            // InternalFirstOrderLogic.g:342:2: ( ( rule__If__Group__0 ) )
            {
            // InternalFirstOrderLogic.g:342:2: ( ( rule__If__Group__0 ) )
            // InternalFirstOrderLogic.g:343:3: ( rule__If__Group__0 )
            {
             before(grammarAccess.getIfAccess().getGroup()); 
            // InternalFirstOrderLogic.g:344:3: ( rule__If__Group__0 )
            // InternalFirstOrderLogic.g:344:4: rule__If__Group__0
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
    // InternalFirstOrderLogic.g:353:1: entryRuleXor : ruleXor EOF ;
    public final void entryRuleXor() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:354:1: ( ruleXor EOF )
            // InternalFirstOrderLogic.g:355:1: ruleXor EOF
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
    // InternalFirstOrderLogic.g:362:1: ruleXor : ( ( rule__Xor__Group__0 ) ) ;
    public final void ruleXor() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:366:2: ( ( ( rule__Xor__Group__0 ) ) )
            // InternalFirstOrderLogic.g:367:2: ( ( rule__Xor__Group__0 ) )
            {
            // InternalFirstOrderLogic.g:367:2: ( ( rule__Xor__Group__0 ) )
            // InternalFirstOrderLogic.g:368:3: ( rule__Xor__Group__0 )
            {
             before(grammarAccess.getXorAccess().getGroup()); 
            // InternalFirstOrderLogic.g:369:3: ( rule__Xor__Group__0 )
            // InternalFirstOrderLogic.g:369:4: rule__Xor__Group__0
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
    // InternalFirstOrderLogic.g:378:1: entryRuleOr : ruleOr EOF ;
    public final void entryRuleOr() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:379:1: ( ruleOr EOF )
            // InternalFirstOrderLogic.g:380:1: ruleOr EOF
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
    // InternalFirstOrderLogic.g:387:1: ruleOr : ( ( rule__Or__Group__0 ) ) ;
    public final void ruleOr() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:391:2: ( ( ( rule__Or__Group__0 ) ) )
            // InternalFirstOrderLogic.g:392:2: ( ( rule__Or__Group__0 ) )
            {
            // InternalFirstOrderLogic.g:392:2: ( ( rule__Or__Group__0 ) )
            // InternalFirstOrderLogic.g:393:3: ( rule__Or__Group__0 )
            {
             before(grammarAccess.getOrAccess().getGroup()); 
            // InternalFirstOrderLogic.g:394:3: ( rule__Or__Group__0 )
            // InternalFirstOrderLogic.g:394:4: rule__Or__Group__0
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
    // InternalFirstOrderLogic.g:403:1: entryRuleAnd : ruleAnd EOF ;
    public final void entryRuleAnd() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:404:1: ( ruleAnd EOF )
            // InternalFirstOrderLogic.g:405:1: ruleAnd EOF
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
    // InternalFirstOrderLogic.g:412:1: ruleAnd : ( ( rule__And__Group__0 ) ) ;
    public final void ruleAnd() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:416:2: ( ( ( rule__And__Group__0 ) ) )
            // InternalFirstOrderLogic.g:417:2: ( ( rule__And__Group__0 ) )
            {
            // InternalFirstOrderLogic.g:417:2: ( ( rule__And__Group__0 ) )
            // InternalFirstOrderLogic.g:418:3: ( rule__And__Group__0 )
            {
             before(grammarAccess.getAndAccess().getGroup()); 
            // InternalFirstOrderLogic.g:419:3: ( rule__And__Group__0 )
            // InternalFirstOrderLogic.g:419:4: rule__And__Group__0
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
    // InternalFirstOrderLogic.g:428:1: entryRuleUnaryFormula : ruleUnaryFormula EOF ;
    public final void entryRuleUnaryFormula() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:429:1: ( ruleUnaryFormula EOF )
            // InternalFirstOrderLogic.g:430:1: ruleUnaryFormula EOF
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
    // InternalFirstOrderLogic.g:437:1: ruleUnaryFormula : ( ruleNot ) ;
    public final void ruleUnaryFormula() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:441:2: ( ( ruleNot ) )
            // InternalFirstOrderLogic.g:442:2: ( ruleNot )
            {
            // InternalFirstOrderLogic.g:442:2: ( ruleNot )
            // InternalFirstOrderLogic.g:443:3: ruleNot
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
    // InternalFirstOrderLogic.g:453:1: entryRuleNot : ruleNot EOF ;
    public final void entryRuleNot() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:454:1: ( ruleNot EOF )
            // InternalFirstOrderLogic.g:455:1: ruleNot EOF
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
    // InternalFirstOrderLogic.g:462:1: ruleNot : ( ( rule__Not__Group__0 ) ) ;
    public final void ruleNot() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:466:2: ( ( ( rule__Not__Group__0 ) ) )
            // InternalFirstOrderLogic.g:467:2: ( ( rule__Not__Group__0 ) )
            {
            // InternalFirstOrderLogic.g:467:2: ( ( rule__Not__Group__0 ) )
            // InternalFirstOrderLogic.g:468:3: ( rule__Not__Group__0 )
            {
             before(grammarAccess.getNotAccess().getGroup()); 
            // InternalFirstOrderLogic.g:469:3: ( rule__Not__Group__0 )
            // InternalFirstOrderLogic.g:469:4: rule__Not__Group__0
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
    // InternalFirstOrderLogic.g:478:1: entryRulePredicate : rulePredicate EOF ;
    public final void entryRulePredicate() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:479:1: ( rulePredicate EOF )
            // InternalFirstOrderLogic.g:480:1: rulePredicate EOF
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
    // InternalFirstOrderLogic.g:487:1: rulePredicate : ( ruleIsEmpty ) ;
    public final void rulePredicate() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:491:2: ( ( ruleIsEmpty ) )
            // InternalFirstOrderLogic.g:492:2: ( ruleIsEmpty )
            {
            // InternalFirstOrderLogic.g:492:2: ( ruleIsEmpty )
            // InternalFirstOrderLogic.g:493:3: ruleIsEmpty
            {
             before(grammarAccess.getPredicateAccess().getIsEmptyParserRuleCall()); 
            pushFollow(FOLLOW_2);
            ruleIsEmpty();

            state._fsp--;

             after(grammarAccess.getPredicateAccess().getIsEmptyParserRuleCall()); 

            }


            }

        }
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


    // $ANTLR start "entryRuleIsEmpty"
    // InternalFirstOrderLogic.g:503:1: entryRuleIsEmpty : ruleIsEmpty EOF ;
    public final void entryRuleIsEmpty() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:504:1: ( ruleIsEmpty EOF )
            // InternalFirstOrderLogic.g:505:1: ruleIsEmpty EOF
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
    // InternalFirstOrderLogic.g:512:1: ruleIsEmpty : ( ( rule__IsEmpty__Group__0 ) ) ;
    public final void ruleIsEmpty() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:516:2: ( ( ( rule__IsEmpty__Group__0 ) ) )
            // InternalFirstOrderLogic.g:517:2: ( ( rule__IsEmpty__Group__0 ) )
            {
            // InternalFirstOrderLogic.g:517:2: ( ( rule__IsEmpty__Group__0 ) )
            // InternalFirstOrderLogic.g:518:3: ( rule__IsEmpty__Group__0 )
            {
             before(grammarAccess.getIsEmptyAccess().getGroup()); 
            // InternalFirstOrderLogic.g:519:3: ( rule__IsEmpty__Group__0 )
            // InternalFirstOrderLogic.g:519:4: rule__IsEmpty__Group__0
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


    // $ANTLR start "entryRuleGreater"
    // InternalFirstOrderLogic.g:528:1: entryRuleGreater : ruleGreater EOF ;
    public final void entryRuleGreater() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:529:1: ( ruleGreater EOF )
            // InternalFirstOrderLogic.g:530:1: ruleGreater EOF
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
    // InternalFirstOrderLogic.g:537:1: ruleGreater : ( ( rule__Greater__Group__0 ) ) ;
    public final void ruleGreater() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:541:2: ( ( ( rule__Greater__Group__0 ) ) )
            // InternalFirstOrderLogic.g:542:2: ( ( rule__Greater__Group__0 ) )
            {
            // InternalFirstOrderLogic.g:542:2: ( ( rule__Greater__Group__0 ) )
            // InternalFirstOrderLogic.g:543:3: ( rule__Greater__Group__0 )
            {
             before(grammarAccess.getGreaterAccess().getGroup()); 
            // InternalFirstOrderLogic.g:544:3: ( rule__Greater__Group__0 )
            // InternalFirstOrderLogic.g:544:4: rule__Greater__Group__0
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
    // InternalFirstOrderLogic.g:553:1: entryRuleGreaterEqual : ruleGreaterEqual EOF ;
    public final void entryRuleGreaterEqual() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:554:1: ( ruleGreaterEqual EOF )
            // InternalFirstOrderLogic.g:555:1: ruleGreaterEqual EOF
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
    // InternalFirstOrderLogic.g:562:1: ruleGreaterEqual : ( ( rule__GreaterEqual__Group__0 ) ) ;
    public final void ruleGreaterEqual() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:566:2: ( ( ( rule__GreaterEqual__Group__0 ) ) )
            // InternalFirstOrderLogic.g:567:2: ( ( rule__GreaterEqual__Group__0 ) )
            {
            // InternalFirstOrderLogic.g:567:2: ( ( rule__GreaterEqual__Group__0 ) )
            // InternalFirstOrderLogic.g:568:3: ( rule__GreaterEqual__Group__0 )
            {
             before(grammarAccess.getGreaterEqualAccess().getGroup()); 
            // InternalFirstOrderLogic.g:569:3: ( rule__GreaterEqual__Group__0 )
            // InternalFirstOrderLogic.g:569:4: rule__GreaterEqual__Group__0
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
    // InternalFirstOrderLogic.g:578:1: entryRuleSmaller : ruleSmaller EOF ;
    public final void entryRuleSmaller() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:579:1: ( ruleSmaller EOF )
            // InternalFirstOrderLogic.g:580:1: ruleSmaller EOF
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
    // InternalFirstOrderLogic.g:587:1: ruleSmaller : ( ( rule__Smaller__Group__0 ) ) ;
    public final void ruleSmaller() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:591:2: ( ( ( rule__Smaller__Group__0 ) ) )
            // InternalFirstOrderLogic.g:592:2: ( ( rule__Smaller__Group__0 ) )
            {
            // InternalFirstOrderLogic.g:592:2: ( ( rule__Smaller__Group__0 ) )
            // InternalFirstOrderLogic.g:593:3: ( rule__Smaller__Group__0 )
            {
             before(grammarAccess.getSmallerAccess().getGroup()); 
            // InternalFirstOrderLogic.g:594:3: ( rule__Smaller__Group__0 )
            // InternalFirstOrderLogic.g:594:4: rule__Smaller__Group__0
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
    // InternalFirstOrderLogic.g:603:1: entryRuleSmallerEqual : ruleSmallerEqual EOF ;
    public final void entryRuleSmallerEqual() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:604:1: ( ruleSmallerEqual EOF )
            // InternalFirstOrderLogic.g:605:1: ruleSmallerEqual EOF
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
    // InternalFirstOrderLogic.g:612:1: ruleSmallerEqual : ( ( rule__SmallerEqual__Group__0 ) ) ;
    public final void ruleSmallerEqual() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:616:2: ( ( ( rule__SmallerEqual__Group__0 ) ) )
            // InternalFirstOrderLogic.g:617:2: ( ( rule__SmallerEqual__Group__0 ) )
            {
            // InternalFirstOrderLogic.g:617:2: ( ( rule__SmallerEqual__Group__0 ) )
            // InternalFirstOrderLogic.g:618:3: ( rule__SmallerEqual__Group__0 )
            {
             before(grammarAccess.getSmallerEqualAccess().getGroup()); 
            // InternalFirstOrderLogic.g:619:3: ( rule__SmallerEqual__Group__0 )
            // InternalFirstOrderLogic.g:619:4: rule__SmallerEqual__Group__0
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


    // $ANTLR start "entryRuleQuantifier"
    // InternalFirstOrderLogic.g:628:1: entryRuleQuantifier : ruleQuantifier EOF ;
    public final void entryRuleQuantifier() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:629:1: ( ruleQuantifier EOF )
            // InternalFirstOrderLogic.g:630:1: ruleQuantifier EOF
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
    // InternalFirstOrderLogic.g:637:1: ruleQuantifier : ( ( rule__Quantifier__Alternatives ) ) ;
    public final void ruleQuantifier() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:641:2: ( ( ( rule__Quantifier__Alternatives ) ) )
            // InternalFirstOrderLogic.g:642:2: ( ( rule__Quantifier__Alternatives ) )
            {
            // InternalFirstOrderLogic.g:642:2: ( ( rule__Quantifier__Alternatives ) )
            // InternalFirstOrderLogic.g:643:3: ( rule__Quantifier__Alternatives )
            {
             before(grammarAccess.getQuantifierAccess().getAlternatives()); 
            // InternalFirstOrderLogic.g:644:3: ( rule__Quantifier__Alternatives )
            // InternalFirstOrderLogic.g:644:4: rule__Quantifier__Alternatives
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
    // InternalFirstOrderLogic.g:653:1: entryRuleForAll : ruleForAll EOF ;
    public final void entryRuleForAll() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:654:1: ( ruleForAll EOF )
            // InternalFirstOrderLogic.g:655:1: ruleForAll EOF
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
    // InternalFirstOrderLogic.g:662:1: ruleForAll : ( ( rule__ForAll__Group__0 ) ) ;
    public final void ruleForAll() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:666:2: ( ( ( rule__ForAll__Group__0 ) ) )
            // InternalFirstOrderLogic.g:667:2: ( ( rule__ForAll__Group__0 ) )
            {
            // InternalFirstOrderLogic.g:667:2: ( ( rule__ForAll__Group__0 ) )
            // InternalFirstOrderLogic.g:668:3: ( rule__ForAll__Group__0 )
            {
             before(grammarAccess.getForAllAccess().getGroup()); 
            // InternalFirstOrderLogic.g:669:3: ( rule__ForAll__Group__0 )
            // InternalFirstOrderLogic.g:669:4: rule__ForAll__Group__0
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
    // InternalFirstOrderLogic.g:678:1: entryRuleExists : ruleExists EOF ;
    public final void entryRuleExists() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:679:1: ( ruleExists EOF )
            // InternalFirstOrderLogic.g:680:1: ruleExists EOF
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
    // InternalFirstOrderLogic.g:687:1: ruleExists : ( ( rule__Exists__Group__0 ) ) ;
    public final void ruleExists() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:691:2: ( ( ( rule__Exists__Group__0 ) ) )
            // InternalFirstOrderLogic.g:692:2: ( ( rule__Exists__Group__0 ) )
            {
            // InternalFirstOrderLogic.g:692:2: ( ( rule__Exists__Group__0 ) )
            // InternalFirstOrderLogic.g:693:3: ( rule__Exists__Group__0 )
            {
             before(grammarAccess.getExistsAccess().getGroup()); 
            // InternalFirstOrderLogic.g:694:3: ( rule__Exists__Group__0 )
            // InternalFirstOrderLogic.g:694:4: rule__Exists__Group__0
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
    // InternalFirstOrderLogic.g:703:1: entryRulePrimary : rulePrimary EOF ;
    public final void entryRulePrimary() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:704:1: ( rulePrimary EOF )
            // InternalFirstOrderLogic.g:705:1: rulePrimary EOF
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
    // InternalFirstOrderLogic.g:712:1: rulePrimary : ( ( rule__Primary__Alternatives ) ) ;
    public final void rulePrimary() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:716:2: ( ( ( rule__Primary__Alternatives ) ) )
            // InternalFirstOrderLogic.g:717:2: ( ( rule__Primary__Alternatives ) )
            {
            // InternalFirstOrderLogic.g:717:2: ( ( rule__Primary__Alternatives ) )
            // InternalFirstOrderLogic.g:718:3: ( rule__Primary__Alternatives )
            {
             before(grammarAccess.getPrimaryAccess().getAlternatives()); 
            // InternalFirstOrderLogic.g:719:3: ( rule__Primary__Alternatives )
            // InternalFirstOrderLogic.g:719:4: rule__Primary__Alternatives
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


    // $ANTLR start "entryRuleConstant"
    // InternalFirstOrderLogic.g:728:1: entryRuleConstant : ruleConstant EOF ;
    public final void entryRuleConstant() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:729:1: ( ruleConstant EOF )
            // InternalFirstOrderLogic.g:730:1: ruleConstant EOF
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
    // InternalFirstOrderLogic.g:737:1: ruleConstant : ( ( rule__Constant__Alternatives ) ) ;
    public final void ruleConstant() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:741:2: ( ( ( rule__Constant__Alternatives ) ) )
            // InternalFirstOrderLogic.g:742:2: ( ( rule__Constant__Alternatives ) )
            {
            // InternalFirstOrderLogic.g:742:2: ( ( rule__Constant__Alternatives ) )
            // InternalFirstOrderLogic.g:743:3: ( rule__Constant__Alternatives )
            {
             before(grammarAccess.getConstantAccess().getAlternatives()); 
            // InternalFirstOrderLogic.g:744:3: ( rule__Constant__Alternatives )
            // InternalFirstOrderLogic.g:744:4: rule__Constant__Alternatives
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


    // $ANTLR start "rule__Term__Alternatives"
    // InternalFirstOrderLogic.g:752:1: rule__Term__Alternatives : ( ( ruleVariable ) | ( ruleFunction ) );
    public final void rule__Term__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:756:1: ( ( ruleVariable ) | ( ruleFunction ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==RULE_ID) ) {
                int LA1_1 = input.LA(2);

                if ( (LA1_1==RULE_ID) ) {
                    alt1=1;
                }
                else if ( (LA1_1==EOF||(LA1_1>=15 && LA1_1<=16)) ) {
                    alt1=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 1, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // InternalFirstOrderLogic.g:757:2: ( ruleVariable )
                    {
                    // InternalFirstOrderLogic.g:757:2: ( ruleVariable )
                    // InternalFirstOrderLogic.g:758:3: ruleVariable
                    {
                     before(grammarAccess.getTermAccess().getVariableParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleVariable();

                    state._fsp--;

                     after(grammarAccess.getTermAccess().getVariableParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalFirstOrderLogic.g:763:2: ( ruleFunction )
                    {
                    // InternalFirstOrderLogic.g:763:2: ( ruleFunction )
                    // InternalFirstOrderLogic.g:764:3: ruleFunction
                    {
                     before(grammarAccess.getTermAccess().getFunctionParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleFunction();

                    state._fsp--;

                     after(grammarAccess.getTermAccess().getFunctionParserRuleCall_1()); 

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


    // $ANTLR start "rule__Quantifier__Alternatives"
    // InternalFirstOrderLogic.g:773:1: rule__Quantifier__Alternatives : ( ( ruleForAll ) | ( ruleExists ) );
    public final void rule__Quantifier__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:777:1: ( ( ruleForAll ) | ( ruleExists ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==30) ) {
                alt2=1;
            }
            else if ( (LA2_0==32) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // InternalFirstOrderLogic.g:778:2: ( ruleForAll )
                    {
                    // InternalFirstOrderLogic.g:778:2: ( ruleForAll )
                    // InternalFirstOrderLogic.g:779:3: ruleForAll
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
                    // InternalFirstOrderLogic.g:784:2: ( ruleExists )
                    {
                    // InternalFirstOrderLogic.g:784:2: ( ruleExists )
                    // InternalFirstOrderLogic.g:785:3: ruleExists
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
    // InternalFirstOrderLogic.g:794:1: rule__Primary__Alternatives : ( ( ( rule__Primary__Group_0__0 ) ) | ( ruleUnaryFormula ) | ( ruleQuantifier ) | ( rulePredicate ) | ( ruleConstant ) );
    public final void rule__Primary__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:798:1: ( ( ( rule__Primary__Group_0__0 ) ) | ( ruleUnaryFormula ) | ( ruleQuantifier ) | ( rulePredicate ) | ( ruleConstant ) )
            int alt3=5;
            switch ( input.LA(1) ) {
            case 33:
                {
                alt3=1;
                }
                break;
            case 23:
                {
                alt3=2;
                }
                break;
            case 30:
            case 32:
                {
                alt3=3;
                }
                break;
            case 25:
                {
                alt3=4;
                }
                break;
            case RULE_ID:
            case RULE_STRING:
            case RULE_INT:
            case 11:
            case 12:
                {
                alt3=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // InternalFirstOrderLogic.g:799:2: ( ( rule__Primary__Group_0__0 ) )
                    {
                    // InternalFirstOrderLogic.g:799:2: ( ( rule__Primary__Group_0__0 ) )
                    // InternalFirstOrderLogic.g:800:3: ( rule__Primary__Group_0__0 )
                    {
                     before(grammarAccess.getPrimaryAccess().getGroup_0()); 
                    // InternalFirstOrderLogic.g:801:3: ( rule__Primary__Group_0__0 )
                    // InternalFirstOrderLogic.g:801:4: rule__Primary__Group_0__0
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
                    // InternalFirstOrderLogic.g:805:2: ( ruleUnaryFormula )
                    {
                    // InternalFirstOrderLogic.g:805:2: ( ruleUnaryFormula )
                    // InternalFirstOrderLogic.g:806:3: ruleUnaryFormula
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
                    // InternalFirstOrderLogic.g:811:2: ( ruleQuantifier )
                    {
                    // InternalFirstOrderLogic.g:811:2: ( ruleQuantifier )
                    // InternalFirstOrderLogic.g:812:3: ruleQuantifier
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
                    // InternalFirstOrderLogic.g:817:2: ( rulePredicate )
                    {
                    // InternalFirstOrderLogic.g:817:2: ( rulePredicate )
                    // InternalFirstOrderLogic.g:818:3: rulePredicate
                    {
                     before(grammarAccess.getPrimaryAccess().getPredicateParserRuleCall_3()); 
                    pushFollow(FOLLOW_2);
                    rulePredicate();

                    state._fsp--;

                     after(grammarAccess.getPrimaryAccess().getPredicateParserRuleCall_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalFirstOrderLogic.g:823:2: ( ruleConstant )
                    {
                    // InternalFirstOrderLogic.g:823:2: ( ruleConstant )
                    // InternalFirstOrderLogic.g:824:3: ruleConstant
                    {
                     before(grammarAccess.getPrimaryAccess().getConstantParserRuleCall_4()); 
                    pushFollow(FOLLOW_2);
                    ruleConstant();

                    state._fsp--;

                     after(grammarAccess.getPrimaryAccess().getConstantParserRuleCall_4()); 

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


    // $ANTLR start "rule__Constant__Alternatives"
    // InternalFirstOrderLogic.g:833:1: rule__Constant__Alternatives : ( ( ( rule__Constant__Group_0__0 ) ) | ( ( rule__Constant__Group_1__0 ) ) | ( ( rule__Constant__Group_2__0 ) ) | ( ( rule__Constant__Group_3__0 ) ) );
    public final void rule__Constant__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:837:1: ( ( ( rule__Constant__Group_0__0 ) ) | ( ( rule__Constant__Group_1__0 ) ) | ( ( rule__Constant__Group_2__0 ) ) | ( ( rule__Constant__Group_3__0 ) ) )
            int alt4=4;
            switch ( input.LA(1) ) {
            case RULE_INT:
                {
                alt4=1;
                }
                break;
            case RULE_STRING:
                {
                alt4=2;
                }
                break;
            case 11:
            case 12:
                {
                alt4=3;
                }
                break;
            case RULE_ID:
                {
                alt4=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // InternalFirstOrderLogic.g:838:2: ( ( rule__Constant__Group_0__0 ) )
                    {
                    // InternalFirstOrderLogic.g:838:2: ( ( rule__Constant__Group_0__0 ) )
                    // InternalFirstOrderLogic.g:839:3: ( rule__Constant__Group_0__0 )
                    {
                     before(grammarAccess.getConstantAccess().getGroup_0()); 
                    // InternalFirstOrderLogic.g:840:3: ( rule__Constant__Group_0__0 )
                    // InternalFirstOrderLogic.g:840:4: rule__Constant__Group_0__0
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
                    // InternalFirstOrderLogic.g:844:2: ( ( rule__Constant__Group_1__0 ) )
                    {
                    // InternalFirstOrderLogic.g:844:2: ( ( rule__Constant__Group_1__0 ) )
                    // InternalFirstOrderLogic.g:845:3: ( rule__Constant__Group_1__0 )
                    {
                     before(grammarAccess.getConstantAccess().getGroup_1()); 
                    // InternalFirstOrderLogic.g:846:3: ( rule__Constant__Group_1__0 )
                    // InternalFirstOrderLogic.g:846:4: rule__Constant__Group_1__0
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
                    // InternalFirstOrderLogic.g:850:2: ( ( rule__Constant__Group_2__0 ) )
                    {
                    // InternalFirstOrderLogic.g:850:2: ( ( rule__Constant__Group_2__0 ) )
                    // InternalFirstOrderLogic.g:851:3: ( rule__Constant__Group_2__0 )
                    {
                     before(grammarAccess.getConstantAccess().getGroup_2()); 
                    // InternalFirstOrderLogic.g:852:3: ( rule__Constant__Group_2__0 )
                    // InternalFirstOrderLogic.g:852:4: rule__Constant__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Constant__Group_2__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getConstantAccess().getGroup_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalFirstOrderLogic.g:856:2: ( ( rule__Constant__Group_3__0 ) )
                    {
                    // InternalFirstOrderLogic.g:856:2: ( ( rule__Constant__Group_3__0 ) )
                    // InternalFirstOrderLogic.g:857:3: ( rule__Constant__Group_3__0 )
                    {
                     before(grammarAccess.getConstantAccess().getGroup_3()); 
                    // InternalFirstOrderLogic.g:858:3: ( rule__Constant__Group_3__0 )
                    // InternalFirstOrderLogic.g:858:4: rule__Constant__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Constant__Group_3__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getConstantAccess().getGroup_3()); 

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


    // $ANTLR start "rule__Constant__ValueAlternatives_2_1_0"
    // InternalFirstOrderLogic.g:866:1: rule__Constant__ValueAlternatives_2_1_0 : ( ( 'true' ) | ( 'false' ) );
    public final void rule__Constant__ValueAlternatives_2_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:870:1: ( ( 'true' ) | ( 'false' ) )
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
                    // InternalFirstOrderLogic.g:871:2: ( 'true' )
                    {
                    // InternalFirstOrderLogic.g:871:2: ( 'true' )
                    // InternalFirstOrderLogic.g:872:3: 'true'
                    {
                     before(grammarAccess.getConstantAccess().getValueTrueKeyword_2_1_0_0()); 
                    match(input,11,FOLLOW_2); 
                     after(grammarAccess.getConstantAccess().getValueTrueKeyword_2_1_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalFirstOrderLogic.g:877:2: ( 'false' )
                    {
                    // InternalFirstOrderLogic.g:877:2: ( 'false' )
                    // InternalFirstOrderLogic.g:878:3: 'false'
                    {
                     before(grammarAccess.getConstantAccess().getValueFalseKeyword_2_1_0_1()); 
                    match(input,12,FOLLOW_2); 
                     after(grammarAccess.getConstantAccess().getValueFalseKeyword_2_1_0_1()); 

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
    // $ANTLR end "rule__Constant__ValueAlternatives_2_1_0"


    // $ANTLR start "rule__ConstraintRuleBase__Group__0"
    // InternalFirstOrderLogic.g:887:1: rule__ConstraintRuleBase__Group__0 : rule__ConstraintRuleBase__Group__0__Impl rule__ConstraintRuleBase__Group__1 ;
    public final void rule__ConstraintRuleBase__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:891:1: ( rule__ConstraintRuleBase__Group__0__Impl rule__ConstraintRuleBase__Group__1 )
            // InternalFirstOrderLogic.g:892:2: rule__ConstraintRuleBase__Group__0__Impl rule__ConstraintRuleBase__Group__1
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
    // InternalFirstOrderLogic.g:899:1: rule__ConstraintRuleBase__Group__0__Impl : ( 'domain' ) ;
    public final void rule__ConstraintRuleBase__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:903:1: ( ( 'domain' ) )
            // InternalFirstOrderLogic.g:904:1: ( 'domain' )
            {
            // InternalFirstOrderLogic.g:904:1: ( 'domain' )
            // InternalFirstOrderLogic.g:905:2: 'domain'
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
    // InternalFirstOrderLogic.g:914:1: rule__ConstraintRuleBase__Group__1 : rule__ConstraintRuleBase__Group__1__Impl rule__ConstraintRuleBase__Group__2 ;
    public final void rule__ConstraintRuleBase__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:918:1: ( rule__ConstraintRuleBase__Group__1__Impl rule__ConstraintRuleBase__Group__2 )
            // InternalFirstOrderLogic.g:919:2: rule__ConstraintRuleBase__Group__1__Impl rule__ConstraintRuleBase__Group__2
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
    // InternalFirstOrderLogic.g:926:1: rule__ConstraintRuleBase__Group__1__Impl : ( ( rule__ConstraintRuleBase__DomainAssignment_1 ) ) ;
    public final void rule__ConstraintRuleBase__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:930:1: ( ( ( rule__ConstraintRuleBase__DomainAssignment_1 ) ) )
            // InternalFirstOrderLogic.g:931:1: ( ( rule__ConstraintRuleBase__DomainAssignment_1 ) )
            {
            // InternalFirstOrderLogic.g:931:1: ( ( rule__ConstraintRuleBase__DomainAssignment_1 ) )
            // InternalFirstOrderLogic.g:932:2: ( rule__ConstraintRuleBase__DomainAssignment_1 )
            {
             before(grammarAccess.getConstraintRuleBaseAccess().getDomainAssignment_1()); 
            // InternalFirstOrderLogic.g:933:2: ( rule__ConstraintRuleBase__DomainAssignment_1 )
            // InternalFirstOrderLogic.g:933:3: rule__ConstraintRuleBase__DomainAssignment_1
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
    // InternalFirstOrderLogic.g:941:1: rule__ConstraintRuleBase__Group__2 : rule__ConstraintRuleBase__Group__2__Impl ;
    public final void rule__ConstraintRuleBase__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:945:1: ( rule__ConstraintRuleBase__Group__2__Impl )
            // InternalFirstOrderLogic.g:946:2: rule__ConstraintRuleBase__Group__2__Impl
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
    // InternalFirstOrderLogic.g:952:1: rule__ConstraintRuleBase__Group__2__Impl : ( ( rule__ConstraintRuleBase__ConstraintsAssignment_2 ) ) ;
    public final void rule__ConstraintRuleBase__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:956:1: ( ( ( rule__ConstraintRuleBase__ConstraintsAssignment_2 ) ) )
            // InternalFirstOrderLogic.g:957:1: ( ( rule__ConstraintRuleBase__ConstraintsAssignment_2 ) )
            {
            // InternalFirstOrderLogic.g:957:1: ( ( rule__ConstraintRuleBase__ConstraintsAssignment_2 ) )
            // InternalFirstOrderLogic.g:958:2: ( rule__ConstraintRuleBase__ConstraintsAssignment_2 )
            {
             before(grammarAccess.getConstraintRuleBaseAccess().getConstraintsAssignment_2()); 
            // InternalFirstOrderLogic.g:959:2: ( rule__ConstraintRuleBase__ConstraintsAssignment_2 )
            // InternalFirstOrderLogic.g:959:3: rule__ConstraintRuleBase__ConstraintsAssignment_2
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
    // InternalFirstOrderLogic.g:968:1: rule__Constraint__Group__0 : rule__Constraint__Group__0__Impl rule__Constraint__Group__1 ;
    public final void rule__Constraint__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:972:1: ( rule__Constraint__Group__0__Impl rule__Constraint__Group__1 )
            // InternalFirstOrderLogic.g:973:2: rule__Constraint__Group__0__Impl rule__Constraint__Group__1
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
    // InternalFirstOrderLogic.g:980:1: rule__Constraint__Group__0__Impl : ( 'context' ) ;
    public final void rule__Constraint__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:984:1: ( ( 'context' ) )
            // InternalFirstOrderLogic.g:985:1: ( 'context' )
            {
            // InternalFirstOrderLogic.g:985:1: ( 'context' )
            // InternalFirstOrderLogic.g:986:2: 'context'
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
    // InternalFirstOrderLogic.g:995:1: rule__Constraint__Group__1 : rule__Constraint__Group__1__Impl rule__Constraint__Group__2 ;
    public final void rule__Constraint__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:999:1: ( rule__Constraint__Group__1__Impl rule__Constraint__Group__2 )
            // InternalFirstOrderLogic.g:1000:2: rule__Constraint__Group__1__Impl rule__Constraint__Group__2
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
    // InternalFirstOrderLogic.g:1007:1: rule__Constraint__Group__1__Impl : ( ( rule__Constraint__VariableAssignment_1 ) ) ;
    public final void rule__Constraint__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1011:1: ( ( ( rule__Constraint__VariableAssignment_1 ) ) )
            // InternalFirstOrderLogic.g:1012:1: ( ( rule__Constraint__VariableAssignment_1 ) )
            {
            // InternalFirstOrderLogic.g:1012:1: ( ( rule__Constraint__VariableAssignment_1 ) )
            // InternalFirstOrderLogic.g:1013:2: ( rule__Constraint__VariableAssignment_1 )
            {
             before(grammarAccess.getConstraintAccess().getVariableAssignment_1()); 
            // InternalFirstOrderLogic.g:1014:2: ( rule__Constraint__VariableAssignment_1 )
            // InternalFirstOrderLogic.g:1014:3: rule__Constraint__VariableAssignment_1
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
    // InternalFirstOrderLogic.g:1022:1: rule__Constraint__Group__2 : rule__Constraint__Group__2__Impl rule__Constraint__Group__3 ;
    public final void rule__Constraint__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1026:1: ( rule__Constraint__Group__2__Impl rule__Constraint__Group__3 )
            // InternalFirstOrderLogic.g:1027:2: rule__Constraint__Group__2__Impl rule__Constraint__Group__3
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
    // InternalFirstOrderLogic.g:1034:1: rule__Constraint__Group__2__Impl : ( ':' ) ;
    public final void rule__Constraint__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1038:1: ( ( ':' ) )
            // InternalFirstOrderLogic.g:1039:1: ( ':' )
            {
            // InternalFirstOrderLogic.g:1039:1: ( ':' )
            // InternalFirstOrderLogic.g:1040:2: ':'
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
    // InternalFirstOrderLogic.g:1049:1: rule__Constraint__Group__3 : rule__Constraint__Group__3__Impl ;
    public final void rule__Constraint__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1053:1: ( rule__Constraint__Group__3__Impl )
            // InternalFirstOrderLogic.g:1054:2: rule__Constraint__Group__3__Impl
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
    // InternalFirstOrderLogic.g:1060:1: rule__Constraint__Group__3__Impl : ( ( rule__Constraint__FormulaAssignment_3 ) ) ;
    public final void rule__Constraint__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1064:1: ( ( ( rule__Constraint__FormulaAssignment_3 ) ) )
            // InternalFirstOrderLogic.g:1065:1: ( ( rule__Constraint__FormulaAssignment_3 ) )
            {
            // InternalFirstOrderLogic.g:1065:1: ( ( rule__Constraint__FormulaAssignment_3 ) )
            // InternalFirstOrderLogic.g:1066:2: ( rule__Constraint__FormulaAssignment_3 )
            {
             before(grammarAccess.getConstraintAccess().getFormulaAssignment_3()); 
            // InternalFirstOrderLogic.g:1067:2: ( rule__Constraint__FormulaAssignment_3 )
            // InternalFirstOrderLogic.g:1067:3: rule__Constraint__FormulaAssignment_3
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
    // InternalFirstOrderLogic.g:1076:1: rule__Variable__Group__0 : rule__Variable__Group__0__Impl rule__Variable__Group__1 ;
    public final void rule__Variable__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1080:1: ( rule__Variable__Group__0__Impl rule__Variable__Group__1 )
            // InternalFirstOrderLogic.g:1081:2: rule__Variable__Group__0__Impl rule__Variable__Group__1
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
    // InternalFirstOrderLogic.g:1088:1: rule__Variable__Group__0__Impl : ( ( rule__Variable__TypeAssignment_0 ) ) ;
    public final void rule__Variable__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1092:1: ( ( ( rule__Variable__TypeAssignment_0 ) ) )
            // InternalFirstOrderLogic.g:1093:1: ( ( rule__Variable__TypeAssignment_0 ) )
            {
            // InternalFirstOrderLogic.g:1093:1: ( ( rule__Variable__TypeAssignment_0 ) )
            // InternalFirstOrderLogic.g:1094:2: ( rule__Variable__TypeAssignment_0 )
            {
             before(grammarAccess.getVariableAccess().getTypeAssignment_0()); 
            // InternalFirstOrderLogic.g:1095:2: ( rule__Variable__TypeAssignment_0 )
            // InternalFirstOrderLogic.g:1095:3: rule__Variable__TypeAssignment_0
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
    // InternalFirstOrderLogic.g:1103:1: rule__Variable__Group__1 : rule__Variable__Group__1__Impl ;
    public final void rule__Variable__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1107:1: ( rule__Variable__Group__1__Impl )
            // InternalFirstOrderLogic.g:1108:2: rule__Variable__Group__1__Impl
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
    // InternalFirstOrderLogic.g:1114:1: rule__Variable__Group__1__Impl : ( ( rule__Variable__NameAssignment_1 ) ) ;
    public final void rule__Variable__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1118:1: ( ( ( rule__Variable__NameAssignment_1 ) ) )
            // InternalFirstOrderLogic.g:1119:1: ( ( rule__Variable__NameAssignment_1 ) )
            {
            // InternalFirstOrderLogic.g:1119:1: ( ( rule__Variable__NameAssignment_1 ) )
            // InternalFirstOrderLogic.g:1120:2: ( rule__Variable__NameAssignment_1 )
            {
             before(grammarAccess.getVariableAccess().getNameAssignment_1()); 
            // InternalFirstOrderLogic.g:1121:2: ( rule__Variable__NameAssignment_1 )
            // InternalFirstOrderLogic.g:1121:3: rule__Variable__NameAssignment_1
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
    // InternalFirstOrderLogic.g:1130:1: rule__GetTerm__Group__0 : rule__GetTerm__Group__0__Impl rule__GetTerm__Group__1 ;
    public final void rule__GetTerm__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1134:1: ( rule__GetTerm__Group__0__Impl rule__GetTerm__Group__1 )
            // InternalFirstOrderLogic.g:1135:2: rule__GetTerm__Group__0__Impl rule__GetTerm__Group__1
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
    // InternalFirstOrderLogic.g:1142:1: rule__GetTerm__Group__0__Impl : ( () ) ;
    public final void rule__GetTerm__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1146:1: ( ( () ) )
            // InternalFirstOrderLogic.g:1147:1: ( () )
            {
            // InternalFirstOrderLogic.g:1147:1: ( () )
            // InternalFirstOrderLogic.g:1148:2: ()
            {
             before(grammarAccess.getGetTermAccess().getGetTermAction_0()); 
            // InternalFirstOrderLogic.g:1149:2: ()
            // InternalFirstOrderLogic.g:1149:3: 
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
    // InternalFirstOrderLogic.g:1157:1: rule__GetTerm__Group__1 : rule__GetTerm__Group__1__Impl rule__GetTerm__Group__2 ;
    public final void rule__GetTerm__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1161:1: ( rule__GetTerm__Group__1__Impl rule__GetTerm__Group__2 )
            // InternalFirstOrderLogic.g:1162:2: rule__GetTerm__Group__1__Impl rule__GetTerm__Group__2
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
    // InternalFirstOrderLogic.g:1169:1: rule__GetTerm__Group__1__Impl : ( ( rule__GetTerm__NameAssignment_1 ) ) ;
    public final void rule__GetTerm__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1173:1: ( ( ( rule__GetTerm__NameAssignment_1 ) ) )
            // InternalFirstOrderLogic.g:1174:1: ( ( rule__GetTerm__NameAssignment_1 ) )
            {
            // InternalFirstOrderLogic.g:1174:1: ( ( rule__GetTerm__NameAssignment_1 ) )
            // InternalFirstOrderLogic.g:1175:2: ( rule__GetTerm__NameAssignment_1 )
            {
             before(grammarAccess.getGetTermAccess().getNameAssignment_1()); 
            // InternalFirstOrderLogic.g:1176:2: ( rule__GetTerm__NameAssignment_1 )
            // InternalFirstOrderLogic.g:1176:3: rule__GetTerm__NameAssignment_1
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
    // InternalFirstOrderLogic.g:1184:1: rule__GetTerm__Group__2 : rule__GetTerm__Group__2__Impl ;
    public final void rule__GetTerm__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1188:1: ( rule__GetTerm__Group__2__Impl )
            // InternalFirstOrderLogic.g:1189:2: rule__GetTerm__Group__2__Impl
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
    // InternalFirstOrderLogic.g:1195:1: rule__GetTerm__Group__2__Impl : ( ( rule__GetTerm__FeatureAssignment_2 )? ) ;
    public final void rule__GetTerm__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1199:1: ( ( ( rule__GetTerm__FeatureAssignment_2 )? ) )
            // InternalFirstOrderLogic.g:1200:1: ( ( rule__GetTerm__FeatureAssignment_2 )? )
            {
            // InternalFirstOrderLogic.g:1200:1: ( ( rule__GetTerm__FeatureAssignment_2 )? )
            // InternalFirstOrderLogic.g:1201:2: ( rule__GetTerm__FeatureAssignment_2 )?
            {
             before(grammarAccess.getGetTermAccess().getFeatureAssignment_2()); 
            // InternalFirstOrderLogic.g:1202:2: ( rule__GetTerm__FeatureAssignment_2 )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==16) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalFirstOrderLogic.g:1202:3: rule__GetTerm__FeatureAssignment_2
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
    // InternalFirstOrderLogic.g:1211:1: rule__Get__Group__0 : rule__Get__Group__0__Impl rule__Get__Group__1 ;
    public final void rule__Get__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1215:1: ( rule__Get__Group__0__Impl rule__Get__Group__1 )
            // InternalFirstOrderLogic.g:1216:2: rule__Get__Group__0__Impl rule__Get__Group__1
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
    // InternalFirstOrderLogic.g:1223:1: rule__Get__Group__0__Impl : ( '.' ) ;
    public final void rule__Get__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1227:1: ( ( '.' ) )
            // InternalFirstOrderLogic.g:1228:1: ( '.' )
            {
            // InternalFirstOrderLogic.g:1228:1: ( '.' )
            // InternalFirstOrderLogic.g:1229:2: '.'
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
    // InternalFirstOrderLogic.g:1238:1: rule__Get__Group__1 : rule__Get__Group__1__Impl rule__Get__Group__2 ;
    public final void rule__Get__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1242:1: ( rule__Get__Group__1__Impl rule__Get__Group__2 )
            // InternalFirstOrderLogic.g:1243:2: rule__Get__Group__1__Impl rule__Get__Group__2
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
    // InternalFirstOrderLogic.g:1250:1: rule__Get__Group__1__Impl : ( ( rule__Get__Group_1__0 )? ) ;
    public final void rule__Get__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1254:1: ( ( ( rule__Get__Group_1__0 )? ) )
            // InternalFirstOrderLogic.g:1255:1: ( ( rule__Get__Group_1__0 )? )
            {
            // InternalFirstOrderLogic.g:1255:1: ( ( rule__Get__Group_1__0 )? )
            // InternalFirstOrderLogic.g:1256:2: ( rule__Get__Group_1__0 )?
            {
             before(grammarAccess.getGetAccess().getGroup_1()); 
            // InternalFirstOrderLogic.g:1257:2: ( rule__Get__Group_1__0 )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_ID) ) {
                int LA7_1 = input.LA(2);

                if ( (LA7_1==17) ) {
                    alt7=1;
                }
            }
            switch (alt7) {
                case 1 :
                    // InternalFirstOrderLogic.g:1257:3: rule__Get__Group_1__0
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
    // InternalFirstOrderLogic.g:1265:1: rule__Get__Group__2 : rule__Get__Group__2__Impl rule__Get__Group__3 ;
    public final void rule__Get__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1269:1: ( rule__Get__Group__2__Impl rule__Get__Group__3 )
            // InternalFirstOrderLogic.g:1270:2: rule__Get__Group__2__Impl rule__Get__Group__3
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
    // InternalFirstOrderLogic.g:1277:1: rule__Get__Group__2__Impl : ( ( rule__Get__NameAssignment_2 ) ) ;
    public final void rule__Get__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1281:1: ( ( ( rule__Get__NameAssignment_2 ) ) )
            // InternalFirstOrderLogic.g:1282:1: ( ( rule__Get__NameAssignment_2 ) )
            {
            // InternalFirstOrderLogic.g:1282:1: ( ( rule__Get__NameAssignment_2 ) )
            // InternalFirstOrderLogic.g:1283:2: ( rule__Get__NameAssignment_2 )
            {
             before(grammarAccess.getGetAccess().getNameAssignment_2()); 
            // InternalFirstOrderLogic.g:1284:2: ( rule__Get__NameAssignment_2 )
            // InternalFirstOrderLogic.g:1284:3: rule__Get__NameAssignment_2
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
    // InternalFirstOrderLogic.g:1292:1: rule__Get__Group__3 : rule__Get__Group__3__Impl ;
    public final void rule__Get__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1296:1: ( rule__Get__Group__3__Impl )
            // InternalFirstOrderLogic.g:1297:2: rule__Get__Group__3__Impl
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
    // InternalFirstOrderLogic.g:1303:1: rule__Get__Group__3__Impl : ( ( rule__Get__NextAssignment_3 )? ) ;
    public final void rule__Get__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1307:1: ( ( ( rule__Get__NextAssignment_3 )? ) )
            // InternalFirstOrderLogic.g:1308:1: ( ( rule__Get__NextAssignment_3 )? )
            {
            // InternalFirstOrderLogic.g:1308:1: ( ( rule__Get__NextAssignment_3 )? )
            // InternalFirstOrderLogic.g:1309:2: ( rule__Get__NextAssignment_3 )?
            {
             before(grammarAccess.getGetAccess().getNextAssignment_3()); 
            // InternalFirstOrderLogic.g:1310:2: ( rule__Get__NextAssignment_3 )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==16) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalFirstOrderLogic.g:1310:3: rule__Get__NextAssignment_3
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
    // InternalFirstOrderLogic.g:1319:1: rule__Get__Group_1__0 : rule__Get__Group_1__0__Impl rule__Get__Group_1__1 ;
    public final void rule__Get__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1323:1: ( rule__Get__Group_1__0__Impl rule__Get__Group_1__1 )
            // InternalFirstOrderLogic.g:1324:2: rule__Get__Group_1__0__Impl rule__Get__Group_1__1
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
    // InternalFirstOrderLogic.g:1331:1: rule__Get__Group_1__0__Impl : ( ( rule__Get__TypeAssignment_1_0 ) ) ;
    public final void rule__Get__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1335:1: ( ( ( rule__Get__TypeAssignment_1_0 ) ) )
            // InternalFirstOrderLogic.g:1336:1: ( ( rule__Get__TypeAssignment_1_0 ) )
            {
            // InternalFirstOrderLogic.g:1336:1: ( ( rule__Get__TypeAssignment_1_0 ) )
            // InternalFirstOrderLogic.g:1337:2: ( rule__Get__TypeAssignment_1_0 )
            {
             before(grammarAccess.getGetAccess().getTypeAssignment_1_0()); 
            // InternalFirstOrderLogic.g:1338:2: ( rule__Get__TypeAssignment_1_0 )
            // InternalFirstOrderLogic.g:1338:3: rule__Get__TypeAssignment_1_0
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
    // InternalFirstOrderLogic.g:1346:1: rule__Get__Group_1__1 : rule__Get__Group_1__1__Impl ;
    public final void rule__Get__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1350:1: ( rule__Get__Group_1__1__Impl )
            // InternalFirstOrderLogic.g:1351:2: rule__Get__Group_1__1__Impl
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
    // InternalFirstOrderLogic.g:1357:1: rule__Get__Group_1__1__Impl : ( '::' ) ;
    public final void rule__Get__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1361:1: ( ( '::' ) )
            // InternalFirstOrderLogic.g:1362:1: ( '::' )
            {
            // InternalFirstOrderLogic.g:1362:1: ( '::' )
            // InternalFirstOrderLogic.g:1363:2: '::'
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


    // $ANTLR start "rule__Equality__Group__0"
    // InternalFirstOrderLogic.g:1373:1: rule__Equality__Group__0 : rule__Equality__Group__0__Impl rule__Equality__Group__1 ;
    public final void rule__Equality__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1377:1: ( rule__Equality__Group__0__Impl rule__Equality__Group__1 )
            // InternalFirstOrderLogic.g:1378:2: rule__Equality__Group__0__Impl rule__Equality__Group__1
            {
            pushFollow(FOLLOW_10);
            rule__Equality__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Equality__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Equality__Group__0"


    // $ANTLR start "rule__Equality__Group__0__Impl"
    // InternalFirstOrderLogic.g:1385:1: rule__Equality__Group__0__Impl : ( ruleBinaryFormula ) ;
    public final void rule__Equality__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1389:1: ( ( ruleBinaryFormula ) )
            // InternalFirstOrderLogic.g:1390:1: ( ruleBinaryFormula )
            {
            // InternalFirstOrderLogic.g:1390:1: ( ruleBinaryFormula )
            // InternalFirstOrderLogic.g:1391:2: ruleBinaryFormula
            {
             before(grammarAccess.getEqualityAccess().getBinaryFormulaParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleBinaryFormula();

            state._fsp--;

             after(grammarAccess.getEqualityAccess().getBinaryFormulaParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Equality__Group__0__Impl"


    // $ANTLR start "rule__Equality__Group__1"
    // InternalFirstOrderLogic.g:1400:1: rule__Equality__Group__1 : rule__Equality__Group__1__Impl ;
    public final void rule__Equality__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1404:1: ( rule__Equality__Group__1__Impl )
            // InternalFirstOrderLogic.g:1405:2: rule__Equality__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Equality__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Equality__Group__1"


    // $ANTLR start "rule__Equality__Group__1__Impl"
    // InternalFirstOrderLogic.g:1411:1: rule__Equality__Group__1__Impl : ( ( rule__Equality__Group_1__0 )* ) ;
    public final void rule__Equality__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1415:1: ( ( ( rule__Equality__Group_1__0 )* ) )
            // InternalFirstOrderLogic.g:1416:1: ( ( rule__Equality__Group_1__0 )* )
            {
            // InternalFirstOrderLogic.g:1416:1: ( ( rule__Equality__Group_1__0 )* )
            // InternalFirstOrderLogic.g:1417:2: ( rule__Equality__Group_1__0 )*
            {
             before(grammarAccess.getEqualityAccess().getGroup_1()); 
            // InternalFirstOrderLogic.g:1418:2: ( rule__Equality__Group_1__0 )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==18) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalFirstOrderLogic.g:1418:3: rule__Equality__Group_1__0
            	    {
            	    pushFollow(FOLLOW_11);
            	    rule__Equality__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

             after(grammarAccess.getEqualityAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Equality__Group__1__Impl"


    // $ANTLR start "rule__Equality__Group_1__0"
    // InternalFirstOrderLogic.g:1427:1: rule__Equality__Group_1__0 : rule__Equality__Group_1__0__Impl rule__Equality__Group_1__1 ;
    public final void rule__Equality__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1431:1: ( rule__Equality__Group_1__0__Impl rule__Equality__Group_1__1 )
            // InternalFirstOrderLogic.g:1432:2: rule__Equality__Group_1__0__Impl rule__Equality__Group_1__1
            {
            pushFollow(FOLLOW_10);
            rule__Equality__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Equality__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Equality__Group_1__0"


    // $ANTLR start "rule__Equality__Group_1__0__Impl"
    // InternalFirstOrderLogic.g:1439:1: rule__Equality__Group_1__0__Impl : ( () ) ;
    public final void rule__Equality__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1443:1: ( ( () ) )
            // InternalFirstOrderLogic.g:1444:1: ( () )
            {
            // InternalFirstOrderLogic.g:1444:1: ( () )
            // InternalFirstOrderLogic.g:1445:2: ()
            {
             before(grammarAccess.getEqualityAccess().getEqualityLeftAction_1_0()); 
            // InternalFirstOrderLogic.g:1446:2: ()
            // InternalFirstOrderLogic.g:1446:3: 
            {
            }

             after(grammarAccess.getEqualityAccess().getEqualityLeftAction_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Equality__Group_1__0__Impl"


    // $ANTLR start "rule__Equality__Group_1__1"
    // InternalFirstOrderLogic.g:1454:1: rule__Equality__Group_1__1 : rule__Equality__Group_1__1__Impl rule__Equality__Group_1__2 ;
    public final void rule__Equality__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1458:1: ( rule__Equality__Group_1__1__Impl rule__Equality__Group_1__2 )
            // InternalFirstOrderLogic.g:1459:2: rule__Equality__Group_1__1__Impl rule__Equality__Group_1__2
            {
            pushFollow(FOLLOW_7);
            rule__Equality__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Equality__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Equality__Group_1__1"


    // $ANTLR start "rule__Equality__Group_1__1__Impl"
    // InternalFirstOrderLogic.g:1466:1: rule__Equality__Group_1__1__Impl : ( '=' ) ;
    public final void rule__Equality__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1470:1: ( ( '=' ) )
            // InternalFirstOrderLogic.g:1471:1: ( '=' )
            {
            // InternalFirstOrderLogic.g:1471:1: ( '=' )
            // InternalFirstOrderLogic.g:1472:2: '='
            {
             before(grammarAccess.getEqualityAccess().getEqualsSignKeyword_1_1()); 
            match(input,18,FOLLOW_2); 
             after(grammarAccess.getEqualityAccess().getEqualsSignKeyword_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Equality__Group_1__1__Impl"


    // $ANTLR start "rule__Equality__Group_1__2"
    // InternalFirstOrderLogic.g:1481:1: rule__Equality__Group_1__2 : rule__Equality__Group_1__2__Impl ;
    public final void rule__Equality__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1485:1: ( rule__Equality__Group_1__2__Impl )
            // InternalFirstOrderLogic.g:1486:2: rule__Equality__Group_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Equality__Group_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Equality__Group_1__2"


    // $ANTLR start "rule__Equality__Group_1__2__Impl"
    // InternalFirstOrderLogic.g:1492:1: rule__Equality__Group_1__2__Impl : ( ( rule__Equality__RightAssignment_1_2 ) ) ;
    public final void rule__Equality__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1496:1: ( ( ( rule__Equality__RightAssignment_1_2 ) ) )
            // InternalFirstOrderLogic.g:1497:1: ( ( rule__Equality__RightAssignment_1_2 ) )
            {
            // InternalFirstOrderLogic.g:1497:1: ( ( rule__Equality__RightAssignment_1_2 ) )
            // InternalFirstOrderLogic.g:1498:2: ( rule__Equality__RightAssignment_1_2 )
            {
             before(grammarAccess.getEqualityAccess().getRightAssignment_1_2()); 
            // InternalFirstOrderLogic.g:1499:2: ( rule__Equality__RightAssignment_1_2 )
            // InternalFirstOrderLogic.g:1499:3: rule__Equality__RightAssignment_1_2
            {
            pushFollow(FOLLOW_2);
            rule__Equality__RightAssignment_1_2();

            state._fsp--;


            }

             after(grammarAccess.getEqualityAccess().getRightAssignment_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Equality__Group_1__2__Impl"


    // $ANTLR start "rule__If__Group__0"
    // InternalFirstOrderLogic.g:1508:1: rule__If__Group__0 : rule__If__Group__0__Impl rule__If__Group__1 ;
    public final void rule__If__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1512:1: ( rule__If__Group__0__Impl rule__If__Group__1 )
            // InternalFirstOrderLogic.g:1513:2: rule__If__Group__0__Impl rule__If__Group__1
            {
            pushFollow(FOLLOW_12);
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
    // InternalFirstOrderLogic.g:1520:1: rule__If__Group__0__Impl : ( ruleXor ) ;
    public final void rule__If__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1524:1: ( ( ruleXor ) )
            // InternalFirstOrderLogic.g:1525:1: ( ruleXor )
            {
            // InternalFirstOrderLogic.g:1525:1: ( ruleXor )
            // InternalFirstOrderLogic.g:1526:2: ruleXor
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
    // InternalFirstOrderLogic.g:1535:1: rule__If__Group__1 : rule__If__Group__1__Impl ;
    public final void rule__If__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1539:1: ( rule__If__Group__1__Impl )
            // InternalFirstOrderLogic.g:1540:2: rule__If__Group__1__Impl
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
    // InternalFirstOrderLogic.g:1546:1: rule__If__Group__1__Impl : ( ( rule__If__Group_1__0 )* ) ;
    public final void rule__If__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1550:1: ( ( ( rule__If__Group_1__0 )* ) )
            // InternalFirstOrderLogic.g:1551:1: ( ( rule__If__Group_1__0 )* )
            {
            // InternalFirstOrderLogic.g:1551:1: ( ( rule__If__Group_1__0 )* )
            // InternalFirstOrderLogic.g:1552:2: ( rule__If__Group_1__0 )*
            {
             before(grammarAccess.getIfAccess().getGroup_1()); 
            // InternalFirstOrderLogic.g:1553:2: ( rule__If__Group_1__0 )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==19) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalFirstOrderLogic.g:1553:3: rule__If__Group_1__0
            	    {
            	    pushFollow(FOLLOW_13);
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
    // InternalFirstOrderLogic.g:1562:1: rule__If__Group_1__0 : rule__If__Group_1__0__Impl rule__If__Group_1__1 ;
    public final void rule__If__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1566:1: ( rule__If__Group_1__0__Impl rule__If__Group_1__1 )
            // InternalFirstOrderLogic.g:1567:2: rule__If__Group_1__0__Impl rule__If__Group_1__1
            {
            pushFollow(FOLLOW_12);
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
    // InternalFirstOrderLogic.g:1574:1: rule__If__Group_1__0__Impl : ( () ) ;
    public final void rule__If__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1578:1: ( ( () ) )
            // InternalFirstOrderLogic.g:1579:1: ( () )
            {
            // InternalFirstOrderLogic.g:1579:1: ( () )
            // InternalFirstOrderLogic.g:1580:2: ()
            {
             before(grammarAccess.getIfAccess().getIfLeftAction_1_0()); 
            // InternalFirstOrderLogic.g:1581:2: ()
            // InternalFirstOrderLogic.g:1581:3: 
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
    // InternalFirstOrderLogic.g:1589:1: rule__If__Group_1__1 : rule__If__Group_1__1__Impl rule__If__Group_1__2 ;
    public final void rule__If__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1593:1: ( rule__If__Group_1__1__Impl rule__If__Group_1__2 )
            // InternalFirstOrderLogic.g:1594:2: rule__If__Group_1__1__Impl rule__If__Group_1__2
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
    // InternalFirstOrderLogic.g:1601:1: rule__If__Group_1__1__Impl : ( 'implies' ) ;
    public final void rule__If__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1605:1: ( ( 'implies' ) )
            // InternalFirstOrderLogic.g:1606:1: ( 'implies' )
            {
            // InternalFirstOrderLogic.g:1606:1: ( 'implies' )
            // InternalFirstOrderLogic.g:1607:2: 'implies'
            {
             before(grammarAccess.getIfAccess().getImpliesKeyword_1_1()); 
            match(input,19,FOLLOW_2); 
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
    // InternalFirstOrderLogic.g:1616:1: rule__If__Group_1__2 : rule__If__Group_1__2__Impl ;
    public final void rule__If__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1620:1: ( rule__If__Group_1__2__Impl )
            // InternalFirstOrderLogic.g:1621:2: rule__If__Group_1__2__Impl
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
    // InternalFirstOrderLogic.g:1627:1: rule__If__Group_1__2__Impl : ( ( rule__If__RightAssignment_1_2 ) ) ;
    public final void rule__If__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1631:1: ( ( ( rule__If__RightAssignment_1_2 ) ) )
            // InternalFirstOrderLogic.g:1632:1: ( ( rule__If__RightAssignment_1_2 ) )
            {
            // InternalFirstOrderLogic.g:1632:1: ( ( rule__If__RightAssignment_1_2 ) )
            // InternalFirstOrderLogic.g:1633:2: ( rule__If__RightAssignment_1_2 )
            {
             before(grammarAccess.getIfAccess().getRightAssignment_1_2()); 
            // InternalFirstOrderLogic.g:1634:2: ( rule__If__RightAssignment_1_2 )
            // InternalFirstOrderLogic.g:1634:3: rule__If__RightAssignment_1_2
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
    // InternalFirstOrderLogic.g:1643:1: rule__Xor__Group__0 : rule__Xor__Group__0__Impl rule__Xor__Group__1 ;
    public final void rule__Xor__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1647:1: ( rule__Xor__Group__0__Impl rule__Xor__Group__1 )
            // InternalFirstOrderLogic.g:1648:2: rule__Xor__Group__0__Impl rule__Xor__Group__1
            {
            pushFollow(FOLLOW_14);
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
    // InternalFirstOrderLogic.g:1655:1: rule__Xor__Group__0__Impl : ( ruleOr ) ;
    public final void rule__Xor__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1659:1: ( ( ruleOr ) )
            // InternalFirstOrderLogic.g:1660:1: ( ruleOr )
            {
            // InternalFirstOrderLogic.g:1660:1: ( ruleOr )
            // InternalFirstOrderLogic.g:1661:2: ruleOr
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
    // InternalFirstOrderLogic.g:1670:1: rule__Xor__Group__1 : rule__Xor__Group__1__Impl ;
    public final void rule__Xor__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1674:1: ( rule__Xor__Group__1__Impl )
            // InternalFirstOrderLogic.g:1675:2: rule__Xor__Group__1__Impl
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
    // InternalFirstOrderLogic.g:1681:1: rule__Xor__Group__1__Impl : ( ( rule__Xor__Group_1__0 )* ) ;
    public final void rule__Xor__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1685:1: ( ( ( rule__Xor__Group_1__0 )* ) )
            // InternalFirstOrderLogic.g:1686:1: ( ( rule__Xor__Group_1__0 )* )
            {
            // InternalFirstOrderLogic.g:1686:1: ( ( rule__Xor__Group_1__0 )* )
            // InternalFirstOrderLogic.g:1687:2: ( rule__Xor__Group_1__0 )*
            {
             before(grammarAccess.getXorAccess().getGroup_1()); 
            // InternalFirstOrderLogic.g:1688:2: ( rule__Xor__Group_1__0 )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==20) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalFirstOrderLogic.g:1688:3: rule__Xor__Group_1__0
            	    {
            	    pushFollow(FOLLOW_15);
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
    // InternalFirstOrderLogic.g:1697:1: rule__Xor__Group_1__0 : rule__Xor__Group_1__0__Impl rule__Xor__Group_1__1 ;
    public final void rule__Xor__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1701:1: ( rule__Xor__Group_1__0__Impl rule__Xor__Group_1__1 )
            // InternalFirstOrderLogic.g:1702:2: rule__Xor__Group_1__0__Impl rule__Xor__Group_1__1
            {
            pushFollow(FOLLOW_14);
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
    // InternalFirstOrderLogic.g:1709:1: rule__Xor__Group_1__0__Impl : ( () ) ;
    public final void rule__Xor__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1713:1: ( ( () ) )
            // InternalFirstOrderLogic.g:1714:1: ( () )
            {
            // InternalFirstOrderLogic.g:1714:1: ( () )
            // InternalFirstOrderLogic.g:1715:2: ()
            {
             before(grammarAccess.getXorAccess().getXorLeftAction_1_0()); 
            // InternalFirstOrderLogic.g:1716:2: ()
            // InternalFirstOrderLogic.g:1716:3: 
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
    // InternalFirstOrderLogic.g:1724:1: rule__Xor__Group_1__1 : rule__Xor__Group_1__1__Impl rule__Xor__Group_1__2 ;
    public final void rule__Xor__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1728:1: ( rule__Xor__Group_1__1__Impl rule__Xor__Group_1__2 )
            // InternalFirstOrderLogic.g:1729:2: rule__Xor__Group_1__1__Impl rule__Xor__Group_1__2
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
    // InternalFirstOrderLogic.g:1736:1: rule__Xor__Group_1__1__Impl : ( 'xor' ) ;
    public final void rule__Xor__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1740:1: ( ( 'xor' ) )
            // InternalFirstOrderLogic.g:1741:1: ( 'xor' )
            {
            // InternalFirstOrderLogic.g:1741:1: ( 'xor' )
            // InternalFirstOrderLogic.g:1742:2: 'xor'
            {
             before(grammarAccess.getXorAccess().getXorKeyword_1_1()); 
            match(input,20,FOLLOW_2); 
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
    // InternalFirstOrderLogic.g:1751:1: rule__Xor__Group_1__2 : rule__Xor__Group_1__2__Impl ;
    public final void rule__Xor__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1755:1: ( rule__Xor__Group_1__2__Impl )
            // InternalFirstOrderLogic.g:1756:2: rule__Xor__Group_1__2__Impl
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
    // InternalFirstOrderLogic.g:1762:1: rule__Xor__Group_1__2__Impl : ( ( rule__Xor__RightAssignment_1_2 ) ) ;
    public final void rule__Xor__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1766:1: ( ( ( rule__Xor__RightAssignment_1_2 ) ) )
            // InternalFirstOrderLogic.g:1767:1: ( ( rule__Xor__RightAssignment_1_2 ) )
            {
            // InternalFirstOrderLogic.g:1767:1: ( ( rule__Xor__RightAssignment_1_2 ) )
            // InternalFirstOrderLogic.g:1768:2: ( rule__Xor__RightAssignment_1_2 )
            {
             before(grammarAccess.getXorAccess().getRightAssignment_1_2()); 
            // InternalFirstOrderLogic.g:1769:2: ( rule__Xor__RightAssignment_1_2 )
            // InternalFirstOrderLogic.g:1769:3: rule__Xor__RightAssignment_1_2
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
    // InternalFirstOrderLogic.g:1778:1: rule__Or__Group__0 : rule__Or__Group__0__Impl rule__Or__Group__1 ;
    public final void rule__Or__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1782:1: ( rule__Or__Group__0__Impl rule__Or__Group__1 )
            // InternalFirstOrderLogic.g:1783:2: rule__Or__Group__0__Impl rule__Or__Group__1
            {
            pushFollow(FOLLOW_16);
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
    // InternalFirstOrderLogic.g:1790:1: rule__Or__Group__0__Impl : ( ruleAnd ) ;
    public final void rule__Or__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1794:1: ( ( ruleAnd ) )
            // InternalFirstOrderLogic.g:1795:1: ( ruleAnd )
            {
            // InternalFirstOrderLogic.g:1795:1: ( ruleAnd )
            // InternalFirstOrderLogic.g:1796:2: ruleAnd
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
    // InternalFirstOrderLogic.g:1805:1: rule__Or__Group__1 : rule__Or__Group__1__Impl ;
    public final void rule__Or__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1809:1: ( rule__Or__Group__1__Impl )
            // InternalFirstOrderLogic.g:1810:2: rule__Or__Group__1__Impl
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
    // InternalFirstOrderLogic.g:1816:1: rule__Or__Group__1__Impl : ( ( rule__Or__Group_1__0 )* ) ;
    public final void rule__Or__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1820:1: ( ( ( rule__Or__Group_1__0 )* ) )
            // InternalFirstOrderLogic.g:1821:1: ( ( rule__Or__Group_1__0 )* )
            {
            // InternalFirstOrderLogic.g:1821:1: ( ( rule__Or__Group_1__0 )* )
            // InternalFirstOrderLogic.g:1822:2: ( rule__Or__Group_1__0 )*
            {
             before(grammarAccess.getOrAccess().getGroup_1()); 
            // InternalFirstOrderLogic.g:1823:2: ( rule__Or__Group_1__0 )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==21) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalFirstOrderLogic.g:1823:3: rule__Or__Group_1__0
            	    {
            	    pushFollow(FOLLOW_17);
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
    // InternalFirstOrderLogic.g:1832:1: rule__Or__Group_1__0 : rule__Or__Group_1__0__Impl rule__Or__Group_1__1 ;
    public final void rule__Or__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1836:1: ( rule__Or__Group_1__0__Impl rule__Or__Group_1__1 )
            // InternalFirstOrderLogic.g:1837:2: rule__Or__Group_1__0__Impl rule__Or__Group_1__1
            {
            pushFollow(FOLLOW_16);
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
    // InternalFirstOrderLogic.g:1844:1: rule__Or__Group_1__0__Impl : ( () ) ;
    public final void rule__Or__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1848:1: ( ( () ) )
            // InternalFirstOrderLogic.g:1849:1: ( () )
            {
            // InternalFirstOrderLogic.g:1849:1: ( () )
            // InternalFirstOrderLogic.g:1850:2: ()
            {
             before(grammarAccess.getOrAccess().getOrLeftAction_1_0()); 
            // InternalFirstOrderLogic.g:1851:2: ()
            // InternalFirstOrderLogic.g:1851:3: 
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
    // InternalFirstOrderLogic.g:1859:1: rule__Or__Group_1__1 : rule__Or__Group_1__1__Impl rule__Or__Group_1__2 ;
    public final void rule__Or__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1863:1: ( rule__Or__Group_1__1__Impl rule__Or__Group_1__2 )
            // InternalFirstOrderLogic.g:1864:2: rule__Or__Group_1__1__Impl rule__Or__Group_1__2
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
    // InternalFirstOrderLogic.g:1871:1: rule__Or__Group_1__1__Impl : ( 'or' ) ;
    public final void rule__Or__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1875:1: ( ( 'or' ) )
            // InternalFirstOrderLogic.g:1876:1: ( 'or' )
            {
            // InternalFirstOrderLogic.g:1876:1: ( 'or' )
            // InternalFirstOrderLogic.g:1877:2: 'or'
            {
             before(grammarAccess.getOrAccess().getOrKeyword_1_1()); 
            match(input,21,FOLLOW_2); 
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
    // InternalFirstOrderLogic.g:1886:1: rule__Or__Group_1__2 : rule__Or__Group_1__2__Impl ;
    public final void rule__Or__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1890:1: ( rule__Or__Group_1__2__Impl )
            // InternalFirstOrderLogic.g:1891:2: rule__Or__Group_1__2__Impl
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
    // InternalFirstOrderLogic.g:1897:1: rule__Or__Group_1__2__Impl : ( ( rule__Or__RightAssignment_1_2 ) ) ;
    public final void rule__Or__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1901:1: ( ( ( rule__Or__RightAssignment_1_2 ) ) )
            // InternalFirstOrderLogic.g:1902:1: ( ( rule__Or__RightAssignment_1_2 ) )
            {
            // InternalFirstOrderLogic.g:1902:1: ( ( rule__Or__RightAssignment_1_2 ) )
            // InternalFirstOrderLogic.g:1903:2: ( rule__Or__RightAssignment_1_2 )
            {
             before(grammarAccess.getOrAccess().getRightAssignment_1_2()); 
            // InternalFirstOrderLogic.g:1904:2: ( rule__Or__RightAssignment_1_2 )
            // InternalFirstOrderLogic.g:1904:3: rule__Or__RightAssignment_1_2
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
    // InternalFirstOrderLogic.g:1913:1: rule__And__Group__0 : rule__And__Group__0__Impl rule__And__Group__1 ;
    public final void rule__And__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1917:1: ( rule__And__Group__0__Impl rule__And__Group__1 )
            // InternalFirstOrderLogic.g:1918:2: rule__And__Group__0__Impl rule__And__Group__1
            {
            pushFollow(FOLLOW_18);
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
    // InternalFirstOrderLogic.g:1925:1: rule__And__Group__0__Impl : ( ruleGreater ) ;
    public final void rule__And__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1929:1: ( ( ruleGreater ) )
            // InternalFirstOrderLogic.g:1930:1: ( ruleGreater )
            {
            // InternalFirstOrderLogic.g:1930:1: ( ruleGreater )
            // InternalFirstOrderLogic.g:1931:2: ruleGreater
            {
             before(grammarAccess.getAndAccess().getGreaterParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleGreater();

            state._fsp--;

             after(grammarAccess.getAndAccess().getGreaterParserRuleCall_0()); 

            }


            }

        }
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
    // InternalFirstOrderLogic.g:1940:1: rule__And__Group__1 : rule__And__Group__1__Impl ;
    public final void rule__And__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1944:1: ( rule__And__Group__1__Impl )
            // InternalFirstOrderLogic.g:1945:2: rule__And__Group__1__Impl
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
    // InternalFirstOrderLogic.g:1951:1: rule__And__Group__1__Impl : ( ( rule__And__Group_1__0 )* ) ;
    public final void rule__And__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1955:1: ( ( ( rule__And__Group_1__0 )* ) )
            // InternalFirstOrderLogic.g:1956:1: ( ( rule__And__Group_1__0 )* )
            {
            // InternalFirstOrderLogic.g:1956:1: ( ( rule__And__Group_1__0 )* )
            // InternalFirstOrderLogic.g:1957:2: ( rule__And__Group_1__0 )*
            {
             before(grammarAccess.getAndAccess().getGroup_1()); 
            // InternalFirstOrderLogic.g:1958:2: ( rule__And__Group_1__0 )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==22) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalFirstOrderLogic.g:1958:3: rule__And__Group_1__0
            	    {
            	    pushFollow(FOLLOW_19);
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
    // InternalFirstOrderLogic.g:1967:1: rule__And__Group_1__0 : rule__And__Group_1__0__Impl rule__And__Group_1__1 ;
    public final void rule__And__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1971:1: ( rule__And__Group_1__0__Impl rule__And__Group_1__1 )
            // InternalFirstOrderLogic.g:1972:2: rule__And__Group_1__0__Impl rule__And__Group_1__1
            {
            pushFollow(FOLLOW_18);
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
    // InternalFirstOrderLogic.g:1979:1: rule__And__Group_1__0__Impl : ( () ) ;
    public final void rule__And__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1983:1: ( ( () ) )
            // InternalFirstOrderLogic.g:1984:1: ( () )
            {
            // InternalFirstOrderLogic.g:1984:1: ( () )
            // InternalFirstOrderLogic.g:1985:2: ()
            {
             before(grammarAccess.getAndAccess().getAndLeftAction_1_0()); 
            // InternalFirstOrderLogic.g:1986:2: ()
            // InternalFirstOrderLogic.g:1986:3: 
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
    // InternalFirstOrderLogic.g:1994:1: rule__And__Group_1__1 : rule__And__Group_1__1__Impl rule__And__Group_1__2 ;
    public final void rule__And__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1998:1: ( rule__And__Group_1__1__Impl rule__And__Group_1__2 )
            // InternalFirstOrderLogic.g:1999:2: rule__And__Group_1__1__Impl rule__And__Group_1__2
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
    // InternalFirstOrderLogic.g:2006:1: rule__And__Group_1__1__Impl : ( 'and' ) ;
    public final void rule__And__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2010:1: ( ( 'and' ) )
            // InternalFirstOrderLogic.g:2011:1: ( 'and' )
            {
            // InternalFirstOrderLogic.g:2011:1: ( 'and' )
            // InternalFirstOrderLogic.g:2012:2: 'and'
            {
             before(grammarAccess.getAndAccess().getAndKeyword_1_1()); 
            match(input,22,FOLLOW_2); 
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
    // InternalFirstOrderLogic.g:2021:1: rule__And__Group_1__2 : rule__And__Group_1__2__Impl ;
    public final void rule__And__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2025:1: ( rule__And__Group_1__2__Impl )
            // InternalFirstOrderLogic.g:2026:2: rule__And__Group_1__2__Impl
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
    // InternalFirstOrderLogic.g:2032:1: rule__And__Group_1__2__Impl : ( ( rule__And__RightAssignment_1_2 ) ) ;
    public final void rule__And__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2036:1: ( ( ( rule__And__RightAssignment_1_2 ) ) )
            // InternalFirstOrderLogic.g:2037:1: ( ( rule__And__RightAssignment_1_2 ) )
            {
            // InternalFirstOrderLogic.g:2037:1: ( ( rule__And__RightAssignment_1_2 ) )
            // InternalFirstOrderLogic.g:2038:2: ( rule__And__RightAssignment_1_2 )
            {
             before(grammarAccess.getAndAccess().getRightAssignment_1_2()); 
            // InternalFirstOrderLogic.g:2039:2: ( rule__And__RightAssignment_1_2 )
            // InternalFirstOrderLogic.g:2039:3: rule__And__RightAssignment_1_2
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
    // InternalFirstOrderLogic.g:2048:1: rule__Not__Group__0 : rule__Not__Group__0__Impl rule__Not__Group__1 ;
    public final void rule__Not__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2052:1: ( rule__Not__Group__0__Impl rule__Not__Group__1 )
            // InternalFirstOrderLogic.g:2053:2: rule__Not__Group__0__Impl rule__Not__Group__1
            {
            pushFollow(FOLLOW_20);
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
    // InternalFirstOrderLogic.g:2060:1: rule__Not__Group__0__Impl : ( () ) ;
    public final void rule__Not__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2064:1: ( ( () ) )
            // InternalFirstOrderLogic.g:2065:1: ( () )
            {
            // InternalFirstOrderLogic.g:2065:1: ( () )
            // InternalFirstOrderLogic.g:2066:2: ()
            {
             before(grammarAccess.getNotAccess().getNotAction_0()); 
            // InternalFirstOrderLogic.g:2067:2: ()
            // InternalFirstOrderLogic.g:2067:3: 
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
    // InternalFirstOrderLogic.g:2075:1: rule__Not__Group__1 : rule__Not__Group__1__Impl rule__Not__Group__2 ;
    public final void rule__Not__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2079:1: ( rule__Not__Group__1__Impl rule__Not__Group__2 )
            // InternalFirstOrderLogic.g:2080:2: rule__Not__Group__1__Impl rule__Not__Group__2
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
    // InternalFirstOrderLogic.g:2087:1: rule__Not__Group__1__Impl : ( 'not(' ) ;
    public final void rule__Not__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2091:1: ( ( 'not(' ) )
            // InternalFirstOrderLogic.g:2092:1: ( 'not(' )
            {
            // InternalFirstOrderLogic.g:2092:1: ( 'not(' )
            // InternalFirstOrderLogic.g:2093:2: 'not('
            {
             before(grammarAccess.getNotAccess().getNotKeyword_1()); 
            match(input,23,FOLLOW_2); 
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
    // InternalFirstOrderLogic.g:2102:1: rule__Not__Group__2 : rule__Not__Group__2__Impl rule__Not__Group__3 ;
    public final void rule__Not__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2106:1: ( rule__Not__Group__2__Impl rule__Not__Group__3 )
            // InternalFirstOrderLogic.g:2107:2: rule__Not__Group__2__Impl rule__Not__Group__3
            {
            pushFollow(FOLLOW_21);
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
    // InternalFirstOrderLogic.g:2114:1: rule__Not__Group__2__Impl : ( ( rule__Not__NotAssignment_2 ) ) ;
    public final void rule__Not__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2118:1: ( ( ( rule__Not__NotAssignment_2 ) ) )
            // InternalFirstOrderLogic.g:2119:1: ( ( rule__Not__NotAssignment_2 ) )
            {
            // InternalFirstOrderLogic.g:2119:1: ( ( rule__Not__NotAssignment_2 ) )
            // InternalFirstOrderLogic.g:2120:2: ( rule__Not__NotAssignment_2 )
            {
             before(grammarAccess.getNotAccess().getNotAssignment_2()); 
            // InternalFirstOrderLogic.g:2121:2: ( rule__Not__NotAssignment_2 )
            // InternalFirstOrderLogic.g:2121:3: rule__Not__NotAssignment_2
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
    // InternalFirstOrderLogic.g:2129:1: rule__Not__Group__3 : rule__Not__Group__3__Impl ;
    public final void rule__Not__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2133:1: ( rule__Not__Group__3__Impl )
            // InternalFirstOrderLogic.g:2134:2: rule__Not__Group__3__Impl
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
    // InternalFirstOrderLogic.g:2140:1: rule__Not__Group__3__Impl : ( ')' ) ;
    public final void rule__Not__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2144:1: ( ( ')' ) )
            // InternalFirstOrderLogic.g:2145:1: ( ')' )
            {
            // InternalFirstOrderLogic.g:2145:1: ( ')' )
            // InternalFirstOrderLogic.g:2146:2: ')'
            {
             before(grammarAccess.getNotAccess().getRightParenthesisKeyword_3()); 
            match(input,24,FOLLOW_2); 
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


    // $ANTLR start "rule__IsEmpty__Group__0"
    // InternalFirstOrderLogic.g:2156:1: rule__IsEmpty__Group__0 : rule__IsEmpty__Group__0__Impl rule__IsEmpty__Group__1 ;
    public final void rule__IsEmpty__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2160:1: ( rule__IsEmpty__Group__0__Impl rule__IsEmpty__Group__1 )
            // InternalFirstOrderLogic.g:2161:2: rule__IsEmpty__Group__0__Impl rule__IsEmpty__Group__1
            {
            pushFollow(FOLLOW_5);
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
    // InternalFirstOrderLogic.g:2168:1: rule__IsEmpty__Group__0__Impl : ( 'isEmpty(' ) ;
    public final void rule__IsEmpty__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2172:1: ( ( 'isEmpty(' ) )
            // InternalFirstOrderLogic.g:2173:1: ( 'isEmpty(' )
            {
            // InternalFirstOrderLogic.g:2173:1: ( 'isEmpty(' )
            // InternalFirstOrderLogic.g:2174:2: 'isEmpty('
            {
             before(grammarAccess.getIsEmptyAccess().getIsEmptyKeyword_0()); 
            match(input,25,FOLLOW_2); 
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
    // InternalFirstOrderLogic.g:2183:1: rule__IsEmpty__Group__1 : rule__IsEmpty__Group__1__Impl rule__IsEmpty__Group__2 ;
    public final void rule__IsEmpty__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2187:1: ( rule__IsEmpty__Group__1__Impl rule__IsEmpty__Group__2 )
            // InternalFirstOrderLogic.g:2188:2: rule__IsEmpty__Group__1__Impl rule__IsEmpty__Group__2
            {
            pushFollow(FOLLOW_21);
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
    // InternalFirstOrderLogic.g:2195:1: rule__IsEmpty__Group__1__Impl : ( ( rule__IsEmpty__TermAssignment_1 ) ) ;
    public final void rule__IsEmpty__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2199:1: ( ( ( rule__IsEmpty__TermAssignment_1 ) ) )
            // InternalFirstOrderLogic.g:2200:1: ( ( rule__IsEmpty__TermAssignment_1 ) )
            {
            // InternalFirstOrderLogic.g:2200:1: ( ( rule__IsEmpty__TermAssignment_1 ) )
            // InternalFirstOrderLogic.g:2201:2: ( rule__IsEmpty__TermAssignment_1 )
            {
             before(grammarAccess.getIsEmptyAccess().getTermAssignment_1()); 
            // InternalFirstOrderLogic.g:2202:2: ( rule__IsEmpty__TermAssignment_1 )
            // InternalFirstOrderLogic.g:2202:3: rule__IsEmpty__TermAssignment_1
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
    // InternalFirstOrderLogic.g:2210:1: rule__IsEmpty__Group__2 : rule__IsEmpty__Group__2__Impl ;
    public final void rule__IsEmpty__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2214:1: ( rule__IsEmpty__Group__2__Impl )
            // InternalFirstOrderLogic.g:2215:2: rule__IsEmpty__Group__2__Impl
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
    // InternalFirstOrderLogic.g:2221:1: rule__IsEmpty__Group__2__Impl : ( ')' ) ;
    public final void rule__IsEmpty__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2225:1: ( ( ')' ) )
            // InternalFirstOrderLogic.g:2226:1: ( ')' )
            {
            // InternalFirstOrderLogic.g:2226:1: ( ')' )
            // InternalFirstOrderLogic.g:2227:2: ')'
            {
             before(grammarAccess.getIsEmptyAccess().getRightParenthesisKeyword_2()); 
            match(input,24,FOLLOW_2); 
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


    // $ANTLR start "rule__Greater__Group__0"
    // InternalFirstOrderLogic.g:2237:1: rule__Greater__Group__0 : rule__Greater__Group__0__Impl rule__Greater__Group__1 ;
    public final void rule__Greater__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2241:1: ( rule__Greater__Group__0__Impl rule__Greater__Group__1 )
            // InternalFirstOrderLogic.g:2242:2: rule__Greater__Group__0__Impl rule__Greater__Group__1
            {
            pushFollow(FOLLOW_22);
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
    // InternalFirstOrderLogic.g:2249:1: rule__Greater__Group__0__Impl : ( ruleGreaterEqual ) ;
    public final void rule__Greater__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2253:1: ( ( ruleGreaterEqual ) )
            // InternalFirstOrderLogic.g:2254:1: ( ruleGreaterEqual )
            {
            // InternalFirstOrderLogic.g:2254:1: ( ruleGreaterEqual )
            // InternalFirstOrderLogic.g:2255:2: ruleGreaterEqual
            {
             before(grammarAccess.getGreaterAccess().getGreaterEqualParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleGreaterEqual();

            state._fsp--;

             after(grammarAccess.getGreaterAccess().getGreaterEqualParserRuleCall_0()); 

            }


            }

        }
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
    // InternalFirstOrderLogic.g:2264:1: rule__Greater__Group__1 : rule__Greater__Group__1__Impl ;
    public final void rule__Greater__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2268:1: ( rule__Greater__Group__1__Impl )
            // InternalFirstOrderLogic.g:2269:2: rule__Greater__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Greater__Group__1__Impl();

            state._fsp--;


            }

        }
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
    // InternalFirstOrderLogic.g:2275:1: rule__Greater__Group__1__Impl : ( ( rule__Greater__Group_1__0 )* ) ;
    public final void rule__Greater__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2279:1: ( ( ( rule__Greater__Group_1__0 )* ) )
            // InternalFirstOrderLogic.g:2280:1: ( ( rule__Greater__Group_1__0 )* )
            {
            // InternalFirstOrderLogic.g:2280:1: ( ( rule__Greater__Group_1__0 )* )
            // InternalFirstOrderLogic.g:2281:2: ( rule__Greater__Group_1__0 )*
            {
             before(grammarAccess.getGreaterAccess().getGroup_1()); 
            // InternalFirstOrderLogic.g:2282:2: ( rule__Greater__Group_1__0 )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==26) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // InternalFirstOrderLogic.g:2282:3: rule__Greater__Group_1__0
            	    {
            	    pushFollow(FOLLOW_23);
            	    rule__Greater__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

             after(grammarAccess.getGreaterAccess().getGroup_1()); 

            }


            }

        }
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


    // $ANTLR start "rule__Greater__Group_1__0"
    // InternalFirstOrderLogic.g:2291:1: rule__Greater__Group_1__0 : rule__Greater__Group_1__0__Impl rule__Greater__Group_1__1 ;
    public final void rule__Greater__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2295:1: ( rule__Greater__Group_1__0__Impl rule__Greater__Group_1__1 )
            // InternalFirstOrderLogic.g:2296:2: rule__Greater__Group_1__0__Impl rule__Greater__Group_1__1
            {
            pushFollow(FOLLOW_22);
            rule__Greater__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Greater__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Greater__Group_1__0"


    // $ANTLR start "rule__Greater__Group_1__0__Impl"
    // InternalFirstOrderLogic.g:2303:1: rule__Greater__Group_1__0__Impl : ( () ) ;
    public final void rule__Greater__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2307:1: ( ( () ) )
            // InternalFirstOrderLogic.g:2308:1: ( () )
            {
            // InternalFirstOrderLogic.g:2308:1: ( () )
            // InternalFirstOrderLogic.g:2309:2: ()
            {
             before(grammarAccess.getGreaterAccess().getGreaterLeftAction_1_0()); 
            // InternalFirstOrderLogic.g:2310:2: ()
            // InternalFirstOrderLogic.g:2310:3: 
            {
            }

             after(grammarAccess.getGreaterAccess().getGreaterLeftAction_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Greater__Group_1__0__Impl"


    // $ANTLR start "rule__Greater__Group_1__1"
    // InternalFirstOrderLogic.g:2318:1: rule__Greater__Group_1__1 : rule__Greater__Group_1__1__Impl rule__Greater__Group_1__2 ;
    public final void rule__Greater__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2322:1: ( rule__Greater__Group_1__1__Impl rule__Greater__Group_1__2 )
            // InternalFirstOrderLogic.g:2323:2: rule__Greater__Group_1__1__Impl rule__Greater__Group_1__2
            {
            pushFollow(FOLLOW_7);
            rule__Greater__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Greater__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Greater__Group_1__1"


    // $ANTLR start "rule__Greater__Group_1__1__Impl"
    // InternalFirstOrderLogic.g:2330:1: rule__Greater__Group_1__1__Impl : ( '>' ) ;
    public final void rule__Greater__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2334:1: ( ( '>' ) )
            // InternalFirstOrderLogic.g:2335:1: ( '>' )
            {
            // InternalFirstOrderLogic.g:2335:1: ( '>' )
            // InternalFirstOrderLogic.g:2336:2: '>'
            {
             before(grammarAccess.getGreaterAccess().getGreaterThanSignKeyword_1_1()); 
            match(input,26,FOLLOW_2); 
             after(grammarAccess.getGreaterAccess().getGreaterThanSignKeyword_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Greater__Group_1__1__Impl"


    // $ANTLR start "rule__Greater__Group_1__2"
    // InternalFirstOrderLogic.g:2345:1: rule__Greater__Group_1__2 : rule__Greater__Group_1__2__Impl ;
    public final void rule__Greater__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2349:1: ( rule__Greater__Group_1__2__Impl )
            // InternalFirstOrderLogic.g:2350:2: rule__Greater__Group_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Greater__Group_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Greater__Group_1__2"


    // $ANTLR start "rule__Greater__Group_1__2__Impl"
    // InternalFirstOrderLogic.g:2356:1: rule__Greater__Group_1__2__Impl : ( ( rule__Greater__RightAssignment_1_2 ) ) ;
    public final void rule__Greater__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2360:1: ( ( ( rule__Greater__RightAssignment_1_2 ) ) )
            // InternalFirstOrderLogic.g:2361:1: ( ( rule__Greater__RightAssignment_1_2 ) )
            {
            // InternalFirstOrderLogic.g:2361:1: ( ( rule__Greater__RightAssignment_1_2 ) )
            // InternalFirstOrderLogic.g:2362:2: ( rule__Greater__RightAssignment_1_2 )
            {
             before(grammarAccess.getGreaterAccess().getRightAssignment_1_2()); 
            // InternalFirstOrderLogic.g:2363:2: ( rule__Greater__RightAssignment_1_2 )
            // InternalFirstOrderLogic.g:2363:3: rule__Greater__RightAssignment_1_2
            {
            pushFollow(FOLLOW_2);
            rule__Greater__RightAssignment_1_2();

            state._fsp--;


            }

             after(grammarAccess.getGreaterAccess().getRightAssignment_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Greater__Group_1__2__Impl"


    // $ANTLR start "rule__GreaterEqual__Group__0"
    // InternalFirstOrderLogic.g:2372:1: rule__GreaterEqual__Group__0 : rule__GreaterEqual__Group__0__Impl rule__GreaterEqual__Group__1 ;
    public final void rule__GreaterEqual__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2376:1: ( rule__GreaterEqual__Group__0__Impl rule__GreaterEqual__Group__1 )
            // InternalFirstOrderLogic.g:2377:2: rule__GreaterEqual__Group__0__Impl rule__GreaterEqual__Group__1
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
    // InternalFirstOrderLogic.g:2384:1: rule__GreaterEqual__Group__0__Impl : ( ruleSmaller ) ;
    public final void rule__GreaterEqual__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2388:1: ( ( ruleSmaller ) )
            // InternalFirstOrderLogic.g:2389:1: ( ruleSmaller )
            {
            // InternalFirstOrderLogic.g:2389:1: ( ruleSmaller )
            // InternalFirstOrderLogic.g:2390:2: ruleSmaller
            {
             before(grammarAccess.getGreaterEqualAccess().getSmallerParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleSmaller();

            state._fsp--;

             after(grammarAccess.getGreaterEqualAccess().getSmallerParserRuleCall_0()); 

            }


            }

        }
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
    // InternalFirstOrderLogic.g:2399:1: rule__GreaterEqual__Group__1 : rule__GreaterEqual__Group__1__Impl ;
    public final void rule__GreaterEqual__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2403:1: ( rule__GreaterEqual__Group__1__Impl )
            // InternalFirstOrderLogic.g:2404:2: rule__GreaterEqual__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__GreaterEqual__Group__1__Impl();

            state._fsp--;


            }

        }
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
    // InternalFirstOrderLogic.g:2410:1: rule__GreaterEqual__Group__1__Impl : ( ( rule__GreaterEqual__Group_1__0 )* ) ;
    public final void rule__GreaterEqual__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2414:1: ( ( ( rule__GreaterEqual__Group_1__0 )* ) )
            // InternalFirstOrderLogic.g:2415:1: ( ( rule__GreaterEqual__Group_1__0 )* )
            {
            // InternalFirstOrderLogic.g:2415:1: ( ( rule__GreaterEqual__Group_1__0 )* )
            // InternalFirstOrderLogic.g:2416:2: ( rule__GreaterEqual__Group_1__0 )*
            {
             before(grammarAccess.getGreaterEqualAccess().getGroup_1()); 
            // InternalFirstOrderLogic.g:2417:2: ( rule__GreaterEqual__Group_1__0 )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==27) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // InternalFirstOrderLogic.g:2417:3: rule__GreaterEqual__Group_1__0
            	    {
            	    pushFollow(FOLLOW_25);
            	    rule__GreaterEqual__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

             after(grammarAccess.getGreaterEqualAccess().getGroup_1()); 

            }


            }

        }
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


    // $ANTLR start "rule__GreaterEqual__Group_1__0"
    // InternalFirstOrderLogic.g:2426:1: rule__GreaterEqual__Group_1__0 : rule__GreaterEqual__Group_1__0__Impl rule__GreaterEqual__Group_1__1 ;
    public final void rule__GreaterEqual__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2430:1: ( rule__GreaterEqual__Group_1__0__Impl rule__GreaterEqual__Group_1__1 )
            // InternalFirstOrderLogic.g:2431:2: rule__GreaterEqual__Group_1__0__Impl rule__GreaterEqual__Group_1__1
            {
            pushFollow(FOLLOW_24);
            rule__GreaterEqual__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__GreaterEqual__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GreaterEqual__Group_1__0"


    // $ANTLR start "rule__GreaterEqual__Group_1__0__Impl"
    // InternalFirstOrderLogic.g:2438:1: rule__GreaterEqual__Group_1__0__Impl : ( () ) ;
    public final void rule__GreaterEqual__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2442:1: ( ( () ) )
            // InternalFirstOrderLogic.g:2443:1: ( () )
            {
            // InternalFirstOrderLogic.g:2443:1: ( () )
            // InternalFirstOrderLogic.g:2444:2: ()
            {
             before(grammarAccess.getGreaterEqualAccess().getGreaterEqualLeftAction_1_0()); 
            // InternalFirstOrderLogic.g:2445:2: ()
            // InternalFirstOrderLogic.g:2445:3: 
            {
            }

             after(grammarAccess.getGreaterEqualAccess().getGreaterEqualLeftAction_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GreaterEqual__Group_1__0__Impl"


    // $ANTLR start "rule__GreaterEqual__Group_1__1"
    // InternalFirstOrderLogic.g:2453:1: rule__GreaterEqual__Group_1__1 : rule__GreaterEqual__Group_1__1__Impl rule__GreaterEqual__Group_1__2 ;
    public final void rule__GreaterEqual__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2457:1: ( rule__GreaterEqual__Group_1__1__Impl rule__GreaterEqual__Group_1__2 )
            // InternalFirstOrderLogic.g:2458:2: rule__GreaterEqual__Group_1__1__Impl rule__GreaterEqual__Group_1__2
            {
            pushFollow(FOLLOW_7);
            rule__GreaterEqual__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__GreaterEqual__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GreaterEqual__Group_1__1"


    // $ANTLR start "rule__GreaterEqual__Group_1__1__Impl"
    // InternalFirstOrderLogic.g:2465:1: rule__GreaterEqual__Group_1__1__Impl : ( '>=' ) ;
    public final void rule__GreaterEqual__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2469:1: ( ( '>=' ) )
            // InternalFirstOrderLogic.g:2470:1: ( '>=' )
            {
            // InternalFirstOrderLogic.g:2470:1: ( '>=' )
            // InternalFirstOrderLogic.g:2471:2: '>='
            {
             before(grammarAccess.getGreaterEqualAccess().getGreaterThanSignEqualsSignKeyword_1_1()); 
            match(input,27,FOLLOW_2); 
             after(grammarAccess.getGreaterEqualAccess().getGreaterThanSignEqualsSignKeyword_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GreaterEqual__Group_1__1__Impl"


    // $ANTLR start "rule__GreaterEqual__Group_1__2"
    // InternalFirstOrderLogic.g:2480:1: rule__GreaterEqual__Group_1__2 : rule__GreaterEqual__Group_1__2__Impl ;
    public final void rule__GreaterEqual__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2484:1: ( rule__GreaterEqual__Group_1__2__Impl )
            // InternalFirstOrderLogic.g:2485:2: rule__GreaterEqual__Group_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__GreaterEqual__Group_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GreaterEqual__Group_1__2"


    // $ANTLR start "rule__GreaterEqual__Group_1__2__Impl"
    // InternalFirstOrderLogic.g:2491:1: rule__GreaterEqual__Group_1__2__Impl : ( ( rule__GreaterEqual__RightAssignment_1_2 ) ) ;
    public final void rule__GreaterEqual__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2495:1: ( ( ( rule__GreaterEqual__RightAssignment_1_2 ) ) )
            // InternalFirstOrderLogic.g:2496:1: ( ( rule__GreaterEqual__RightAssignment_1_2 ) )
            {
            // InternalFirstOrderLogic.g:2496:1: ( ( rule__GreaterEqual__RightAssignment_1_2 ) )
            // InternalFirstOrderLogic.g:2497:2: ( rule__GreaterEqual__RightAssignment_1_2 )
            {
             before(grammarAccess.getGreaterEqualAccess().getRightAssignment_1_2()); 
            // InternalFirstOrderLogic.g:2498:2: ( rule__GreaterEqual__RightAssignment_1_2 )
            // InternalFirstOrderLogic.g:2498:3: rule__GreaterEqual__RightAssignment_1_2
            {
            pushFollow(FOLLOW_2);
            rule__GreaterEqual__RightAssignment_1_2();

            state._fsp--;


            }

             after(grammarAccess.getGreaterEqualAccess().getRightAssignment_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GreaterEqual__Group_1__2__Impl"


    // $ANTLR start "rule__Smaller__Group__0"
    // InternalFirstOrderLogic.g:2507:1: rule__Smaller__Group__0 : rule__Smaller__Group__0__Impl rule__Smaller__Group__1 ;
    public final void rule__Smaller__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2511:1: ( rule__Smaller__Group__0__Impl rule__Smaller__Group__1 )
            // InternalFirstOrderLogic.g:2512:2: rule__Smaller__Group__0__Impl rule__Smaller__Group__1
            {
            pushFollow(FOLLOW_26);
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
    // InternalFirstOrderLogic.g:2519:1: rule__Smaller__Group__0__Impl : ( ruleSmallerEqual ) ;
    public final void rule__Smaller__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2523:1: ( ( ruleSmallerEqual ) )
            // InternalFirstOrderLogic.g:2524:1: ( ruleSmallerEqual )
            {
            // InternalFirstOrderLogic.g:2524:1: ( ruleSmallerEqual )
            // InternalFirstOrderLogic.g:2525:2: ruleSmallerEqual
            {
             before(grammarAccess.getSmallerAccess().getSmallerEqualParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleSmallerEqual();

            state._fsp--;

             after(grammarAccess.getSmallerAccess().getSmallerEqualParserRuleCall_0()); 

            }


            }

        }
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
    // InternalFirstOrderLogic.g:2534:1: rule__Smaller__Group__1 : rule__Smaller__Group__1__Impl ;
    public final void rule__Smaller__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2538:1: ( rule__Smaller__Group__1__Impl )
            // InternalFirstOrderLogic.g:2539:2: rule__Smaller__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Smaller__Group__1__Impl();

            state._fsp--;


            }

        }
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
    // InternalFirstOrderLogic.g:2545:1: rule__Smaller__Group__1__Impl : ( ( rule__Smaller__Group_1__0 )* ) ;
    public final void rule__Smaller__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2549:1: ( ( ( rule__Smaller__Group_1__0 )* ) )
            // InternalFirstOrderLogic.g:2550:1: ( ( rule__Smaller__Group_1__0 )* )
            {
            // InternalFirstOrderLogic.g:2550:1: ( ( rule__Smaller__Group_1__0 )* )
            // InternalFirstOrderLogic.g:2551:2: ( rule__Smaller__Group_1__0 )*
            {
             before(grammarAccess.getSmallerAccess().getGroup_1()); 
            // InternalFirstOrderLogic.g:2552:2: ( rule__Smaller__Group_1__0 )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==28) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalFirstOrderLogic.g:2552:3: rule__Smaller__Group_1__0
            	    {
            	    pushFollow(FOLLOW_27);
            	    rule__Smaller__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

             after(grammarAccess.getSmallerAccess().getGroup_1()); 

            }


            }

        }
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


    // $ANTLR start "rule__Smaller__Group_1__0"
    // InternalFirstOrderLogic.g:2561:1: rule__Smaller__Group_1__0 : rule__Smaller__Group_1__0__Impl rule__Smaller__Group_1__1 ;
    public final void rule__Smaller__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2565:1: ( rule__Smaller__Group_1__0__Impl rule__Smaller__Group_1__1 )
            // InternalFirstOrderLogic.g:2566:2: rule__Smaller__Group_1__0__Impl rule__Smaller__Group_1__1
            {
            pushFollow(FOLLOW_26);
            rule__Smaller__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Smaller__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Smaller__Group_1__0"


    // $ANTLR start "rule__Smaller__Group_1__0__Impl"
    // InternalFirstOrderLogic.g:2573:1: rule__Smaller__Group_1__0__Impl : ( () ) ;
    public final void rule__Smaller__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2577:1: ( ( () ) )
            // InternalFirstOrderLogic.g:2578:1: ( () )
            {
            // InternalFirstOrderLogic.g:2578:1: ( () )
            // InternalFirstOrderLogic.g:2579:2: ()
            {
             before(grammarAccess.getSmallerAccess().getSmallerLeftAction_1_0()); 
            // InternalFirstOrderLogic.g:2580:2: ()
            // InternalFirstOrderLogic.g:2580:3: 
            {
            }

             after(grammarAccess.getSmallerAccess().getSmallerLeftAction_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Smaller__Group_1__0__Impl"


    // $ANTLR start "rule__Smaller__Group_1__1"
    // InternalFirstOrderLogic.g:2588:1: rule__Smaller__Group_1__1 : rule__Smaller__Group_1__1__Impl rule__Smaller__Group_1__2 ;
    public final void rule__Smaller__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2592:1: ( rule__Smaller__Group_1__1__Impl rule__Smaller__Group_1__2 )
            // InternalFirstOrderLogic.g:2593:2: rule__Smaller__Group_1__1__Impl rule__Smaller__Group_1__2
            {
            pushFollow(FOLLOW_7);
            rule__Smaller__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Smaller__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Smaller__Group_1__1"


    // $ANTLR start "rule__Smaller__Group_1__1__Impl"
    // InternalFirstOrderLogic.g:2600:1: rule__Smaller__Group_1__1__Impl : ( '<' ) ;
    public final void rule__Smaller__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2604:1: ( ( '<' ) )
            // InternalFirstOrderLogic.g:2605:1: ( '<' )
            {
            // InternalFirstOrderLogic.g:2605:1: ( '<' )
            // InternalFirstOrderLogic.g:2606:2: '<'
            {
             before(grammarAccess.getSmallerAccess().getLessThanSignKeyword_1_1()); 
            match(input,28,FOLLOW_2); 
             after(grammarAccess.getSmallerAccess().getLessThanSignKeyword_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Smaller__Group_1__1__Impl"


    // $ANTLR start "rule__Smaller__Group_1__2"
    // InternalFirstOrderLogic.g:2615:1: rule__Smaller__Group_1__2 : rule__Smaller__Group_1__2__Impl ;
    public final void rule__Smaller__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2619:1: ( rule__Smaller__Group_1__2__Impl )
            // InternalFirstOrderLogic.g:2620:2: rule__Smaller__Group_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Smaller__Group_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Smaller__Group_1__2"


    // $ANTLR start "rule__Smaller__Group_1__2__Impl"
    // InternalFirstOrderLogic.g:2626:1: rule__Smaller__Group_1__2__Impl : ( ( rule__Smaller__RightAssignment_1_2 ) ) ;
    public final void rule__Smaller__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2630:1: ( ( ( rule__Smaller__RightAssignment_1_2 ) ) )
            // InternalFirstOrderLogic.g:2631:1: ( ( rule__Smaller__RightAssignment_1_2 ) )
            {
            // InternalFirstOrderLogic.g:2631:1: ( ( rule__Smaller__RightAssignment_1_2 ) )
            // InternalFirstOrderLogic.g:2632:2: ( rule__Smaller__RightAssignment_1_2 )
            {
             before(grammarAccess.getSmallerAccess().getRightAssignment_1_2()); 
            // InternalFirstOrderLogic.g:2633:2: ( rule__Smaller__RightAssignment_1_2 )
            // InternalFirstOrderLogic.g:2633:3: rule__Smaller__RightAssignment_1_2
            {
            pushFollow(FOLLOW_2);
            rule__Smaller__RightAssignment_1_2();

            state._fsp--;


            }

             after(grammarAccess.getSmallerAccess().getRightAssignment_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Smaller__Group_1__2__Impl"


    // $ANTLR start "rule__SmallerEqual__Group__0"
    // InternalFirstOrderLogic.g:2642:1: rule__SmallerEqual__Group__0 : rule__SmallerEqual__Group__0__Impl rule__SmallerEqual__Group__1 ;
    public final void rule__SmallerEqual__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2646:1: ( rule__SmallerEqual__Group__0__Impl rule__SmallerEqual__Group__1 )
            // InternalFirstOrderLogic.g:2647:2: rule__SmallerEqual__Group__0__Impl rule__SmallerEqual__Group__1
            {
            pushFollow(FOLLOW_28);
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
    // InternalFirstOrderLogic.g:2654:1: rule__SmallerEqual__Group__0__Impl : ( rulePrimary ) ;
    public final void rule__SmallerEqual__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2658:1: ( ( rulePrimary ) )
            // InternalFirstOrderLogic.g:2659:1: ( rulePrimary )
            {
            // InternalFirstOrderLogic.g:2659:1: ( rulePrimary )
            // InternalFirstOrderLogic.g:2660:2: rulePrimary
            {
             before(grammarAccess.getSmallerEqualAccess().getPrimaryParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            rulePrimary();

            state._fsp--;

             after(grammarAccess.getSmallerEqualAccess().getPrimaryParserRuleCall_0()); 

            }


            }

        }
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
    // InternalFirstOrderLogic.g:2669:1: rule__SmallerEqual__Group__1 : rule__SmallerEqual__Group__1__Impl ;
    public final void rule__SmallerEqual__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2673:1: ( rule__SmallerEqual__Group__1__Impl )
            // InternalFirstOrderLogic.g:2674:2: rule__SmallerEqual__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__SmallerEqual__Group__1__Impl();

            state._fsp--;


            }

        }
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
    // InternalFirstOrderLogic.g:2680:1: rule__SmallerEqual__Group__1__Impl : ( ( rule__SmallerEqual__Group_1__0 )* ) ;
    public final void rule__SmallerEqual__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2684:1: ( ( ( rule__SmallerEqual__Group_1__0 )* ) )
            // InternalFirstOrderLogic.g:2685:1: ( ( rule__SmallerEqual__Group_1__0 )* )
            {
            // InternalFirstOrderLogic.g:2685:1: ( ( rule__SmallerEqual__Group_1__0 )* )
            // InternalFirstOrderLogic.g:2686:2: ( rule__SmallerEqual__Group_1__0 )*
            {
             before(grammarAccess.getSmallerEqualAccess().getGroup_1()); 
            // InternalFirstOrderLogic.g:2687:2: ( rule__SmallerEqual__Group_1__0 )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==29) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // InternalFirstOrderLogic.g:2687:3: rule__SmallerEqual__Group_1__0
            	    {
            	    pushFollow(FOLLOW_29);
            	    rule__SmallerEqual__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

             after(grammarAccess.getSmallerEqualAccess().getGroup_1()); 

            }


            }

        }
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


    // $ANTLR start "rule__SmallerEqual__Group_1__0"
    // InternalFirstOrderLogic.g:2696:1: rule__SmallerEqual__Group_1__0 : rule__SmallerEqual__Group_1__0__Impl rule__SmallerEqual__Group_1__1 ;
    public final void rule__SmallerEqual__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2700:1: ( rule__SmallerEqual__Group_1__0__Impl rule__SmallerEqual__Group_1__1 )
            // InternalFirstOrderLogic.g:2701:2: rule__SmallerEqual__Group_1__0__Impl rule__SmallerEqual__Group_1__1
            {
            pushFollow(FOLLOW_28);
            rule__SmallerEqual__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SmallerEqual__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SmallerEqual__Group_1__0"


    // $ANTLR start "rule__SmallerEqual__Group_1__0__Impl"
    // InternalFirstOrderLogic.g:2708:1: rule__SmallerEqual__Group_1__0__Impl : ( () ) ;
    public final void rule__SmallerEqual__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2712:1: ( ( () ) )
            // InternalFirstOrderLogic.g:2713:1: ( () )
            {
            // InternalFirstOrderLogic.g:2713:1: ( () )
            // InternalFirstOrderLogic.g:2714:2: ()
            {
             before(grammarAccess.getSmallerEqualAccess().getSmallerEqualLeftAction_1_0()); 
            // InternalFirstOrderLogic.g:2715:2: ()
            // InternalFirstOrderLogic.g:2715:3: 
            {
            }

             after(grammarAccess.getSmallerEqualAccess().getSmallerEqualLeftAction_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SmallerEqual__Group_1__0__Impl"


    // $ANTLR start "rule__SmallerEqual__Group_1__1"
    // InternalFirstOrderLogic.g:2723:1: rule__SmallerEqual__Group_1__1 : rule__SmallerEqual__Group_1__1__Impl rule__SmallerEqual__Group_1__2 ;
    public final void rule__SmallerEqual__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2727:1: ( rule__SmallerEqual__Group_1__1__Impl rule__SmallerEqual__Group_1__2 )
            // InternalFirstOrderLogic.g:2728:2: rule__SmallerEqual__Group_1__1__Impl rule__SmallerEqual__Group_1__2
            {
            pushFollow(FOLLOW_7);
            rule__SmallerEqual__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SmallerEqual__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SmallerEqual__Group_1__1"


    // $ANTLR start "rule__SmallerEqual__Group_1__1__Impl"
    // InternalFirstOrderLogic.g:2735:1: rule__SmallerEqual__Group_1__1__Impl : ( '<=' ) ;
    public final void rule__SmallerEqual__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2739:1: ( ( '<=' ) )
            // InternalFirstOrderLogic.g:2740:1: ( '<=' )
            {
            // InternalFirstOrderLogic.g:2740:1: ( '<=' )
            // InternalFirstOrderLogic.g:2741:2: '<='
            {
             before(grammarAccess.getSmallerEqualAccess().getLessThanSignEqualsSignKeyword_1_1()); 
            match(input,29,FOLLOW_2); 
             after(grammarAccess.getSmallerEqualAccess().getLessThanSignEqualsSignKeyword_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SmallerEqual__Group_1__1__Impl"


    // $ANTLR start "rule__SmallerEqual__Group_1__2"
    // InternalFirstOrderLogic.g:2750:1: rule__SmallerEqual__Group_1__2 : rule__SmallerEqual__Group_1__2__Impl ;
    public final void rule__SmallerEqual__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2754:1: ( rule__SmallerEqual__Group_1__2__Impl )
            // InternalFirstOrderLogic.g:2755:2: rule__SmallerEqual__Group_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__SmallerEqual__Group_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SmallerEqual__Group_1__2"


    // $ANTLR start "rule__SmallerEqual__Group_1__2__Impl"
    // InternalFirstOrderLogic.g:2761:1: rule__SmallerEqual__Group_1__2__Impl : ( ( rule__SmallerEqual__RightAssignment_1_2 ) ) ;
    public final void rule__SmallerEqual__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2765:1: ( ( ( rule__SmallerEqual__RightAssignment_1_2 ) ) )
            // InternalFirstOrderLogic.g:2766:1: ( ( rule__SmallerEqual__RightAssignment_1_2 ) )
            {
            // InternalFirstOrderLogic.g:2766:1: ( ( rule__SmallerEqual__RightAssignment_1_2 ) )
            // InternalFirstOrderLogic.g:2767:2: ( rule__SmallerEqual__RightAssignment_1_2 )
            {
             before(grammarAccess.getSmallerEqualAccess().getRightAssignment_1_2()); 
            // InternalFirstOrderLogic.g:2768:2: ( rule__SmallerEqual__RightAssignment_1_2 )
            // InternalFirstOrderLogic.g:2768:3: rule__SmallerEqual__RightAssignment_1_2
            {
            pushFollow(FOLLOW_2);
            rule__SmallerEqual__RightAssignment_1_2();

            state._fsp--;


            }

             after(grammarAccess.getSmallerEqualAccess().getRightAssignment_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SmallerEqual__Group_1__2__Impl"


    // $ANTLR start "rule__ForAll__Group__0"
    // InternalFirstOrderLogic.g:2777:1: rule__ForAll__Group__0 : rule__ForAll__Group__0__Impl rule__ForAll__Group__1 ;
    public final void rule__ForAll__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2781:1: ( rule__ForAll__Group__0__Impl rule__ForAll__Group__1 )
            // InternalFirstOrderLogic.g:2782:2: rule__ForAll__Group__0__Impl rule__ForAll__Group__1
            {
            pushFollow(FOLLOW_30);
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
    // InternalFirstOrderLogic.g:2789:1: rule__ForAll__Group__0__Impl : ( () ) ;
    public final void rule__ForAll__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2793:1: ( ( () ) )
            // InternalFirstOrderLogic.g:2794:1: ( () )
            {
            // InternalFirstOrderLogic.g:2794:1: ( () )
            // InternalFirstOrderLogic.g:2795:2: ()
            {
             before(grammarAccess.getForAllAccess().getForAllAction_0()); 
            // InternalFirstOrderLogic.g:2796:2: ()
            // InternalFirstOrderLogic.g:2796:3: 
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
    // InternalFirstOrderLogic.g:2804:1: rule__ForAll__Group__1 : rule__ForAll__Group__1__Impl rule__ForAll__Group__2 ;
    public final void rule__ForAll__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2808:1: ( rule__ForAll__Group__1__Impl rule__ForAll__Group__2 )
            // InternalFirstOrderLogic.g:2809:2: rule__ForAll__Group__1__Impl rule__ForAll__Group__2
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
    // InternalFirstOrderLogic.g:2816:1: rule__ForAll__Group__1__Impl : ( 'forAll(' ) ;
    public final void rule__ForAll__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2820:1: ( ( 'forAll(' ) )
            // InternalFirstOrderLogic.g:2821:1: ( 'forAll(' )
            {
            // InternalFirstOrderLogic.g:2821:1: ( 'forAll(' )
            // InternalFirstOrderLogic.g:2822:2: 'forAll('
            {
             before(grammarAccess.getForAllAccess().getForAllKeyword_1()); 
            match(input,30,FOLLOW_2); 
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
    // InternalFirstOrderLogic.g:2831:1: rule__ForAll__Group__2 : rule__ForAll__Group__2__Impl rule__ForAll__Group__3 ;
    public final void rule__ForAll__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2835:1: ( rule__ForAll__Group__2__Impl rule__ForAll__Group__3 )
            // InternalFirstOrderLogic.g:2836:2: rule__ForAll__Group__2__Impl rule__ForAll__Group__3
            {
            pushFollow(FOLLOW_31);
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
    // InternalFirstOrderLogic.g:2843:1: rule__ForAll__Group__2__Impl : ( ( rule__ForAll__NameAssignment_2 ) ) ;
    public final void rule__ForAll__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2847:1: ( ( ( rule__ForAll__NameAssignment_2 ) ) )
            // InternalFirstOrderLogic.g:2848:1: ( ( rule__ForAll__NameAssignment_2 ) )
            {
            // InternalFirstOrderLogic.g:2848:1: ( ( rule__ForAll__NameAssignment_2 ) )
            // InternalFirstOrderLogic.g:2849:2: ( rule__ForAll__NameAssignment_2 )
            {
             before(grammarAccess.getForAllAccess().getNameAssignment_2()); 
            // InternalFirstOrderLogic.g:2850:2: ( rule__ForAll__NameAssignment_2 )
            // InternalFirstOrderLogic.g:2850:3: rule__ForAll__NameAssignment_2
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
    // InternalFirstOrderLogic.g:2858:1: rule__ForAll__Group__3 : rule__ForAll__Group__3__Impl rule__ForAll__Group__4 ;
    public final void rule__ForAll__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2862:1: ( rule__ForAll__Group__3__Impl rule__ForAll__Group__4 )
            // InternalFirstOrderLogic.g:2863:2: rule__ForAll__Group__3__Impl rule__ForAll__Group__4
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
    // InternalFirstOrderLogic.g:2870:1: rule__ForAll__Group__3__Impl : ( 'in' ) ;
    public final void rule__ForAll__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2874:1: ( ( 'in' ) )
            // InternalFirstOrderLogic.g:2875:1: ( 'in' )
            {
            // InternalFirstOrderLogic.g:2875:1: ( 'in' )
            // InternalFirstOrderLogic.g:2876:2: 'in'
            {
             before(grammarAccess.getForAllAccess().getInKeyword_3()); 
            match(input,31,FOLLOW_2); 
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
    // InternalFirstOrderLogic.g:2885:1: rule__ForAll__Group__4 : rule__ForAll__Group__4__Impl rule__ForAll__Group__5 ;
    public final void rule__ForAll__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2889:1: ( rule__ForAll__Group__4__Impl rule__ForAll__Group__5 )
            // InternalFirstOrderLogic.g:2890:2: rule__ForAll__Group__4__Impl rule__ForAll__Group__5
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
    // InternalFirstOrderLogic.g:2897:1: rule__ForAll__Group__4__Impl : ( ( rule__ForAll__IterationAssignment_4 ) ) ;
    public final void rule__ForAll__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2901:1: ( ( ( rule__ForAll__IterationAssignment_4 ) ) )
            // InternalFirstOrderLogic.g:2902:1: ( ( rule__ForAll__IterationAssignment_4 ) )
            {
            // InternalFirstOrderLogic.g:2902:1: ( ( rule__ForAll__IterationAssignment_4 ) )
            // InternalFirstOrderLogic.g:2903:2: ( rule__ForAll__IterationAssignment_4 )
            {
             before(grammarAccess.getForAllAccess().getIterationAssignment_4()); 
            // InternalFirstOrderLogic.g:2904:2: ( rule__ForAll__IterationAssignment_4 )
            // InternalFirstOrderLogic.g:2904:3: rule__ForAll__IterationAssignment_4
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
    // InternalFirstOrderLogic.g:2912:1: rule__ForAll__Group__5 : rule__ForAll__Group__5__Impl rule__ForAll__Group__6 ;
    public final void rule__ForAll__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2916:1: ( rule__ForAll__Group__5__Impl rule__ForAll__Group__6 )
            // InternalFirstOrderLogic.g:2917:2: rule__ForAll__Group__5__Impl rule__ForAll__Group__6
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
    // InternalFirstOrderLogic.g:2924:1: rule__ForAll__Group__5__Impl : ( ':' ) ;
    public final void rule__ForAll__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2928:1: ( ( ':' ) )
            // InternalFirstOrderLogic.g:2929:1: ( ':' )
            {
            // InternalFirstOrderLogic.g:2929:1: ( ':' )
            // InternalFirstOrderLogic.g:2930:2: ':'
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
    // InternalFirstOrderLogic.g:2939:1: rule__ForAll__Group__6 : rule__ForAll__Group__6__Impl rule__ForAll__Group__7 ;
    public final void rule__ForAll__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2943:1: ( rule__ForAll__Group__6__Impl rule__ForAll__Group__7 )
            // InternalFirstOrderLogic.g:2944:2: rule__ForAll__Group__6__Impl rule__ForAll__Group__7
            {
            pushFollow(FOLLOW_21);
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
    // InternalFirstOrderLogic.g:2951:1: rule__ForAll__Group__6__Impl : ( ( rule__ForAll__FormulaAssignment_6 ) ) ;
    public final void rule__ForAll__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2955:1: ( ( ( rule__ForAll__FormulaAssignment_6 ) ) )
            // InternalFirstOrderLogic.g:2956:1: ( ( rule__ForAll__FormulaAssignment_6 ) )
            {
            // InternalFirstOrderLogic.g:2956:1: ( ( rule__ForAll__FormulaAssignment_6 ) )
            // InternalFirstOrderLogic.g:2957:2: ( rule__ForAll__FormulaAssignment_6 )
            {
             before(grammarAccess.getForAllAccess().getFormulaAssignment_6()); 
            // InternalFirstOrderLogic.g:2958:2: ( rule__ForAll__FormulaAssignment_6 )
            // InternalFirstOrderLogic.g:2958:3: rule__ForAll__FormulaAssignment_6
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
    // InternalFirstOrderLogic.g:2966:1: rule__ForAll__Group__7 : rule__ForAll__Group__7__Impl ;
    public final void rule__ForAll__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2970:1: ( rule__ForAll__Group__7__Impl )
            // InternalFirstOrderLogic.g:2971:2: rule__ForAll__Group__7__Impl
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
    // InternalFirstOrderLogic.g:2977:1: rule__ForAll__Group__7__Impl : ( ')' ) ;
    public final void rule__ForAll__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2981:1: ( ( ')' ) )
            // InternalFirstOrderLogic.g:2982:1: ( ')' )
            {
            // InternalFirstOrderLogic.g:2982:1: ( ')' )
            // InternalFirstOrderLogic.g:2983:2: ')'
            {
             before(grammarAccess.getForAllAccess().getRightParenthesisKeyword_7()); 
            match(input,24,FOLLOW_2); 
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
    // InternalFirstOrderLogic.g:2993:1: rule__Exists__Group__0 : rule__Exists__Group__0__Impl rule__Exists__Group__1 ;
    public final void rule__Exists__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2997:1: ( rule__Exists__Group__0__Impl rule__Exists__Group__1 )
            // InternalFirstOrderLogic.g:2998:2: rule__Exists__Group__0__Impl rule__Exists__Group__1
            {
            pushFollow(FOLLOW_32);
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
    // InternalFirstOrderLogic.g:3005:1: rule__Exists__Group__0__Impl : ( () ) ;
    public final void rule__Exists__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3009:1: ( ( () ) )
            // InternalFirstOrderLogic.g:3010:1: ( () )
            {
            // InternalFirstOrderLogic.g:3010:1: ( () )
            // InternalFirstOrderLogic.g:3011:2: ()
            {
             before(grammarAccess.getExistsAccess().getExistsAction_0()); 
            // InternalFirstOrderLogic.g:3012:2: ()
            // InternalFirstOrderLogic.g:3012:3: 
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
    // InternalFirstOrderLogic.g:3020:1: rule__Exists__Group__1 : rule__Exists__Group__1__Impl rule__Exists__Group__2 ;
    public final void rule__Exists__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3024:1: ( rule__Exists__Group__1__Impl rule__Exists__Group__2 )
            // InternalFirstOrderLogic.g:3025:2: rule__Exists__Group__1__Impl rule__Exists__Group__2
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
    // InternalFirstOrderLogic.g:3032:1: rule__Exists__Group__1__Impl : ( 'exists(' ) ;
    public final void rule__Exists__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3036:1: ( ( 'exists(' ) )
            // InternalFirstOrderLogic.g:3037:1: ( 'exists(' )
            {
            // InternalFirstOrderLogic.g:3037:1: ( 'exists(' )
            // InternalFirstOrderLogic.g:3038:2: 'exists('
            {
             before(grammarAccess.getExistsAccess().getExistsKeyword_1()); 
            match(input,32,FOLLOW_2); 
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
    // InternalFirstOrderLogic.g:3047:1: rule__Exists__Group__2 : rule__Exists__Group__2__Impl rule__Exists__Group__3 ;
    public final void rule__Exists__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3051:1: ( rule__Exists__Group__2__Impl rule__Exists__Group__3 )
            // InternalFirstOrderLogic.g:3052:2: rule__Exists__Group__2__Impl rule__Exists__Group__3
            {
            pushFollow(FOLLOW_31);
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
    // InternalFirstOrderLogic.g:3059:1: rule__Exists__Group__2__Impl : ( ( rule__Exists__NameAssignment_2 ) ) ;
    public final void rule__Exists__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3063:1: ( ( ( rule__Exists__NameAssignment_2 ) ) )
            // InternalFirstOrderLogic.g:3064:1: ( ( rule__Exists__NameAssignment_2 ) )
            {
            // InternalFirstOrderLogic.g:3064:1: ( ( rule__Exists__NameAssignment_2 ) )
            // InternalFirstOrderLogic.g:3065:2: ( rule__Exists__NameAssignment_2 )
            {
             before(grammarAccess.getExistsAccess().getNameAssignment_2()); 
            // InternalFirstOrderLogic.g:3066:2: ( rule__Exists__NameAssignment_2 )
            // InternalFirstOrderLogic.g:3066:3: rule__Exists__NameAssignment_2
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
    // InternalFirstOrderLogic.g:3074:1: rule__Exists__Group__3 : rule__Exists__Group__3__Impl rule__Exists__Group__4 ;
    public final void rule__Exists__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3078:1: ( rule__Exists__Group__3__Impl rule__Exists__Group__4 )
            // InternalFirstOrderLogic.g:3079:2: rule__Exists__Group__3__Impl rule__Exists__Group__4
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
    // InternalFirstOrderLogic.g:3086:1: rule__Exists__Group__3__Impl : ( 'in' ) ;
    public final void rule__Exists__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3090:1: ( ( 'in' ) )
            // InternalFirstOrderLogic.g:3091:1: ( 'in' )
            {
            // InternalFirstOrderLogic.g:3091:1: ( 'in' )
            // InternalFirstOrderLogic.g:3092:2: 'in'
            {
             before(grammarAccess.getExistsAccess().getInKeyword_3()); 
            match(input,31,FOLLOW_2); 
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
    // InternalFirstOrderLogic.g:3101:1: rule__Exists__Group__4 : rule__Exists__Group__4__Impl rule__Exists__Group__5 ;
    public final void rule__Exists__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3105:1: ( rule__Exists__Group__4__Impl rule__Exists__Group__5 )
            // InternalFirstOrderLogic.g:3106:2: rule__Exists__Group__4__Impl rule__Exists__Group__5
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
    // InternalFirstOrderLogic.g:3113:1: rule__Exists__Group__4__Impl : ( ( rule__Exists__IterationAssignment_4 ) ) ;
    public final void rule__Exists__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3117:1: ( ( ( rule__Exists__IterationAssignment_4 ) ) )
            // InternalFirstOrderLogic.g:3118:1: ( ( rule__Exists__IterationAssignment_4 ) )
            {
            // InternalFirstOrderLogic.g:3118:1: ( ( rule__Exists__IterationAssignment_4 ) )
            // InternalFirstOrderLogic.g:3119:2: ( rule__Exists__IterationAssignment_4 )
            {
             before(grammarAccess.getExistsAccess().getIterationAssignment_4()); 
            // InternalFirstOrderLogic.g:3120:2: ( rule__Exists__IterationAssignment_4 )
            // InternalFirstOrderLogic.g:3120:3: rule__Exists__IterationAssignment_4
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
    // InternalFirstOrderLogic.g:3128:1: rule__Exists__Group__5 : rule__Exists__Group__5__Impl rule__Exists__Group__6 ;
    public final void rule__Exists__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3132:1: ( rule__Exists__Group__5__Impl rule__Exists__Group__6 )
            // InternalFirstOrderLogic.g:3133:2: rule__Exists__Group__5__Impl rule__Exists__Group__6
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
    // InternalFirstOrderLogic.g:3140:1: rule__Exists__Group__5__Impl : ( ':' ) ;
    public final void rule__Exists__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3144:1: ( ( ':' ) )
            // InternalFirstOrderLogic.g:3145:1: ( ':' )
            {
            // InternalFirstOrderLogic.g:3145:1: ( ':' )
            // InternalFirstOrderLogic.g:3146:2: ':'
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
    // InternalFirstOrderLogic.g:3155:1: rule__Exists__Group__6 : rule__Exists__Group__6__Impl rule__Exists__Group__7 ;
    public final void rule__Exists__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3159:1: ( rule__Exists__Group__6__Impl rule__Exists__Group__7 )
            // InternalFirstOrderLogic.g:3160:2: rule__Exists__Group__6__Impl rule__Exists__Group__7
            {
            pushFollow(FOLLOW_21);
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
    // InternalFirstOrderLogic.g:3167:1: rule__Exists__Group__6__Impl : ( ( rule__Exists__FormulaAssignment_6 ) ) ;
    public final void rule__Exists__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3171:1: ( ( ( rule__Exists__FormulaAssignment_6 ) ) )
            // InternalFirstOrderLogic.g:3172:1: ( ( rule__Exists__FormulaAssignment_6 ) )
            {
            // InternalFirstOrderLogic.g:3172:1: ( ( rule__Exists__FormulaAssignment_6 ) )
            // InternalFirstOrderLogic.g:3173:2: ( rule__Exists__FormulaAssignment_6 )
            {
             before(grammarAccess.getExistsAccess().getFormulaAssignment_6()); 
            // InternalFirstOrderLogic.g:3174:2: ( rule__Exists__FormulaAssignment_6 )
            // InternalFirstOrderLogic.g:3174:3: rule__Exists__FormulaAssignment_6
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
    // InternalFirstOrderLogic.g:3182:1: rule__Exists__Group__7 : rule__Exists__Group__7__Impl ;
    public final void rule__Exists__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3186:1: ( rule__Exists__Group__7__Impl )
            // InternalFirstOrderLogic.g:3187:2: rule__Exists__Group__7__Impl
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
    // InternalFirstOrderLogic.g:3193:1: rule__Exists__Group__7__Impl : ( ')' ) ;
    public final void rule__Exists__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3197:1: ( ( ')' ) )
            // InternalFirstOrderLogic.g:3198:1: ( ')' )
            {
            // InternalFirstOrderLogic.g:3198:1: ( ')' )
            // InternalFirstOrderLogic.g:3199:2: ')'
            {
             before(grammarAccess.getExistsAccess().getRightParenthesisKeyword_7()); 
            match(input,24,FOLLOW_2); 
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
    // InternalFirstOrderLogic.g:3209:1: rule__Primary__Group_0__0 : rule__Primary__Group_0__0__Impl rule__Primary__Group_0__1 ;
    public final void rule__Primary__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3213:1: ( rule__Primary__Group_0__0__Impl rule__Primary__Group_0__1 )
            // InternalFirstOrderLogic.g:3214:2: rule__Primary__Group_0__0__Impl rule__Primary__Group_0__1
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
    // InternalFirstOrderLogic.g:3221:1: rule__Primary__Group_0__0__Impl : ( '(' ) ;
    public final void rule__Primary__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3225:1: ( ( '(' ) )
            // InternalFirstOrderLogic.g:3226:1: ( '(' )
            {
            // InternalFirstOrderLogic.g:3226:1: ( '(' )
            // InternalFirstOrderLogic.g:3227:2: '('
            {
             before(grammarAccess.getPrimaryAccess().getLeftParenthesisKeyword_0_0()); 
            match(input,33,FOLLOW_2); 
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
    // InternalFirstOrderLogic.g:3236:1: rule__Primary__Group_0__1 : rule__Primary__Group_0__1__Impl rule__Primary__Group_0__2 ;
    public final void rule__Primary__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3240:1: ( rule__Primary__Group_0__1__Impl rule__Primary__Group_0__2 )
            // InternalFirstOrderLogic.g:3241:2: rule__Primary__Group_0__1__Impl rule__Primary__Group_0__2
            {
            pushFollow(FOLLOW_21);
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
    // InternalFirstOrderLogic.g:3248:1: rule__Primary__Group_0__1__Impl : ( ruleFormula ) ;
    public final void rule__Primary__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3252:1: ( ( ruleFormula ) )
            // InternalFirstOrderLogic.g:3253:1: ( ruleFormula )
            {
            // InternalFirstOrderLogic.g:3253:1: ( ruleFormula )
            // InternalFirstOrderLogic.g:3254:2: ruleFormula
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
    // InternalFirstOrderLogic.g:3263:1: rule__Primary__Group_0__2 : rule__Primary__Group_0__2__Impl ;
    public final void rule__Primary__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3267:1: ( rule__Primary__Group_0__2__Impl )
            // InternalFirstOrderLogic.g:3268:2: rule__Primary__Group_0__2__Impl
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
    // InternalFirstOrderLogic.g:3274:1: rule__Primary__Group_0__2__Impl : ( ')' ) ;
    public final void rule__Primary__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3278:1: ( ( ')' ) )
            // InternalFirstOrderLogic.g:3279:1: ( ')' )
            {
            // InternalFirstOrderLogic.g:3279:1: ( ')' )
            // InternalFirstOrderLogic.g:3280:2: ')'
            {
             before(grammarAccess.getPrimaryAccess().getRightParenthesisKeyword_0_2()); 
            match(input,24,FOLLOW_2); 
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


    // $ANTLR start "rule__Constant__Group_0__0"
    // InternalFirstOrderLogic.g:3290:1: rule__Constant__Group_0__0 : rule__Constant__Group_0__0__Impl rule__Constant__Group_0__1 ;
    public final void rule__Constant__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3294:1: ( rule__Constant__Group_0__0__Impl rule__Constant__Group_0__1 )
            // InternalFirstOrderLogic.g:3295:2: rule__Constant__Group_0__0__Impl rule__Constant__Group_0__1
            {
            pushFollow(FOLLOW_33);
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
    // InternalFirstOrderLogic.g:3302:1: rule__Constant__Group_0__0__Impl : ( () ) ;
    public final void rule__Constant__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3306:1: ( ( () ) )
            // InternalFirstOrderLogic.g:3307:1: ( () )
            {
            // InternalFirstOrderLogic.g:3307:1: ( () )
            // InternalFirstOrderLogic.g:3308:2: ()
            {
             before(grammarAccess.getConstantAccess().getIntConstantAction_0_0()); 
            // InternalFirstOrderLogic.g:3309:2: ()
            // InternalFirstOrderLogic.g:3309:3: 
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
    // InternalFirstOrderLogic.g:3317:1: rule__Constant__Group_0__1 : rule__Constant__Group_0__1__Impl ;
    public final void rule__Constant__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3321:1: ( rule__Constant__Group_0__1__Impl )
            // InternalFirstOrderLogic.g:3322:2: rule__Constant__Group_0__1__Impl
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
    // InternalFirstOrderLogic.g:3328:1: rule__Constant__Group_0__1__Impl : ( ( rule__Constant__ValueAssignment_0_1 ) ) ;
    public final void rule__Constant__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3332:1: ( ( ( rule__Constant__ValueAssignment_0_1 ) ) )
            // InternalFirstOrderLogic.g:3333:1: ( ( rule__Constant__ValueAssignment_0_1 ) )
            {
            // InternalFirstOrderLogic.g:3333:1: ( ( rule__Constant__ValueAssignment_0_1 ) )
            // InternalFirstOrderLogic.g:3334:2: ( rule__Constant__ValueAssignment_0_1 )
            {
             before(grammarAccess.getConstantAccess().getValueAssignment_0_1()); 
            // InternalFirstOrderLogic.g:3335:2: ( rule__Constant__ValueAssignment_0_1 )
            // InternalFirstOrderLogic.g:3335:3: rule__Constant__ValueAssignment_0_1
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
    // InternalFirstOrderLogic.g:3344:1: rule__Constant__Group_1__0 : rule__Constant__Group_1__0__Impl rule__Constant__Group_1__1 ;
    public final void rule__Constant__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3348:1: ( rule__Constant__Group_1__0__Impl rule__Constant__Group_1__1 )
            // InternalFirstOrderLogic.g:3349:2: rule__Constant__Group_1__0__Impl rule__Constant__Group_1__1
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
    // InternalFirstOrderLogic.g:3356:1: rule__Constant__Group_1__0__Impl : ( () ) ;
    public final void rule__Constant__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3360:1: ( ( () ) )
            // InternalFirstOrderLogic.g:3361:1: ( () )
            {
            // InternalFirstOrderLogic.g:3361:1: ( () )
            // InternalFirstOrderLogic.g:3362:2: ()
            {
             before(grammarAccess.getConstantAccess().getStringConstantAction_1_0()); 
            // InternalFirstOrderLogic.g:3363:2: ()
            // InternalFirstOrderLogic.g:3363:3: 
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
    // InternalFirstOrderLogic.g:3371:1: rule__Constant__Group_1__1 : rule__Constant__Group_1__1__Impl ;
    public final void rule__Constant__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3375:1: ( rule__Constant__Group_1__1__Impl )
            // InternalFirstOrderLogic.g:3376:2: rule__Constant__Group_1__1__Impl
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
    // InternalFirstOrderLogic.g:3382:1: rule__Constant__Group_1__1__Impl : ( ( rule__Constant__ValueAssignment_1_1 ) ) ;
    public final void rule__Constant__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3386:1: ( ( ( rule__Constant__ValueAssignment_1_1 ) ) )
            // InternalFirstOrderLogic.g:3387:1: ( ( rule__Constant__ValueAssignment_1_1 ) )
            {
            // InternalFirstOrderLogic.g:3387:1: ( ( rule__Constant__ValueAssignment_1_1 ) )
            // InternalFirstOrderLogic.g:3388:2: ( rule__Constant__ValueAssignment_1_1 )
            {
             before(grammarAccess.getConstantAccess().getValueAssignment_1_1()); 
            // InternalFirstOrderLogic.g:3389:2: ( rule__Constant__ValueAssignment_1_1 )
            // InternalFirstOrderLogic.g:3389:3: rule__Constant__ValueAssignment_1_1
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


    // $ANTLR start "rule__Constant__Group_2__0"
    // InternalFirstOrderLogic.g:3398:1: rule__Constant__Group_2__0 : rule__Constant__Group_2__0__Impl rule__Constant__Group_2__1 ;
    public final void rule__Constant__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3402:1: ( rule__Constant__Group_2__0__Impl rule__Constant__Group_2__1 )
            // InternalFirstOrderLogic.g:3403:2: rule__Constant__Group_2__0__Impl rule__Constant__Group_2__1
            {
            pushFollow(FOLLOW_34);
            rule__Constant__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Constant__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constant__Group_2__0"


    // $ANTLR start "rule__Constant__Group_2__0__Impl"
    // InternalFirstOrderLogic.g:3410:1: rule__Constant__Group_2__0__Impl : ( () ) ;
    public final void rule__Constant__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3414:1: ( ( () ) )
            // InternalFirstOrderLogic.g:3415:1: ( () )
            {
            // InternalFirstOrderLogic.g:3415:1: ( () )
            // InternalFirstOrderLogic.g:3416:2: ()
            {
             before(grammarAccess.getConstantAccess().getBoolConstantAction_2_0()); 
            // InternalFirstOrderLogic.g:3417:2: ()
            // InternalFirstOrderLogic.g:3417:3: 
            {
            }

             after(grammarAccess.getConstantAccess().getBoolConstantAction_2_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constant__Group_2__0__Impl"


    // $ANTLR start "rule__Constant__Group_2__1"
    // InternalFirstOrderLogic.g:3425:1: rule__Constant__Group_2__1 : rule__Constant__Group_2__1__Impl ;
    public final void rule__Constant__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3429:1: ( rule__Constant__Group_2__1__Impl )
            // InternalFirstOrderLogic.g:3430:2: rule__Constant__Group_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Constant__Group_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constant__Group_2__1"


    // $ANTLR start "rule__Constant__Group_2__1__Impl"
    // InternalFirstOrderLogic.g:3436:1: rule__Constant__Group_2__1__Impl : ( ( rule__Constant__ValueAssignment_2_1 ) ) ;
    public final void rule__Constant__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3440:1: ( ( ( rule__Constant__ValueAssignment_2_1 ) ) )
            // InternalFirstOrderLogic.g:3441:1: ( ( rule__Constant__ValueAssignment_2_1 ) )
            {
            // InternalFirstOrderLogic.g:3441:1: ( ( rule__Constant__ValueAssignment_2_1 ) )
            // InternalFirstOrderLogic.g:3442:2: ( rule__Constant__ValueAssignment_2_1 )
            {
             before(grammarAccess.getConstantAccess().getValueAssignment_2_1()); 
            // InternalFirstOrderLogic.g:3443:2: ( rule__Constant__ValueAssignment_2_1 )
            // InternalFirstOrderLogic.g:3443:3: rule__Constant__ValueAssignment_2_1
            {
            pushFollow(FOLLOW_2);
            rule__Constant__ValueAssignment_2_1();

            state._fsp--;


            }

             after(grammarAccess.getConstantAccess().getValueAssignment_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constant__Group_2__1__Impl"


    // $ANTLR start "rule__Constant__Group_3__0"
    // InternalFirstOrderLogic.g:3452:1: rule__Constant__Group_3__0 : rule__Constant__Group_3__0__Impl rule__Constant__Group_3__1 ;
    public final void rule__Constant__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3456:1: ( rule__Constant__Group_3__0__Impl rule__Constant__Group_3__1 )
            // InternalFirstOrderLogic.g:3457:2: rule__Constant__Group_3__0__Impl rule__Constant__Group_3__1
            {
            pushFollow(FOLLOW_7);
            rule__Constant__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Constant__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constant__Group_3__0"


    // $ANTLR start "rule__Constant__Group_3__0__Impl"
    // InternalFirstOrderLogic.g:3464:1: rule__Constant__Group_3__0__Impl : ( () ) ;
    public final void rule__Constant__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3468:1: ( ( () ) )
            // InternalFirstOrderLogic.g:3469:1: ( () )
            {
            // InternalFirstOrderLogic.g:3469:1: ( () )
            // InternalFirstOrderLogic.g:3470:2: ()
            {
             before(grammarAccess.getConstantAccess().getVariableRefAction_3_0()); 
            // InternalFirstOrderLogic.g:3471:2: ()
            // InternalFirstOrderLogic.g:3471:3: 
            {
            }

             after(grammarAccess.getConstantAccess().getVariableRefAction_3_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constant__Group_3__0__Impl"


    // $ANTLR start "rule__Constant__Group_3__1"
    // InternalFirstOrderLogic.g:3479:1: rule__Constant__Group_3__1 : rule__Constant__Group_3__1__Impl ;
    public final void rule__Constant__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3483:1: ( rule__Constant__Group_3__1__Impl )
            // InternalFirstOrderLogic.g:3484:2: rule__Constant__Group_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Constant__Group_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constant__Group_3__1"


    // $ANTLR start "rule__Constant__Group_3__1__Impl"
    // InternalFirstOrderLogic.g:3490:1: rule__Constant__Group_3__1__Impl : ( ( rule__Constant__VariableAssignment_3_1 ) ) ;
    public final void rule__Constant__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3494:1: ( ( ( rule__Constant__VariableAssignment_3_1 ) ) )
            // InternalFirstOrderLogic.g:3495:1: ( ( rule__Constant__VariableAssignment_3_1 ) )
            {
            // InternalFirstOrderLogic.g:3495:1: ( ( rule__Constant__VariableAssignment_3_1 ) )
            // InternalFirstOrderLogic.g:3496:2: ( rule__Constant__VariableAssignment_3_1 )
            {
             before(grammarAccess.getConstantAccess().getVariableAssignment_3_1()); 
            // InternalFirstOrderLogic.g:3497:2: ( rule__Constant__VariableAssignment_3_1 )
            // InternalFirstOrderLogic.g:3497:3: rule__Constant__VariableAssignment_3_1
            {
            pushFollow(FOLLOW_2);
            rule__Constant__VariableAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getConstantAccess().getVariableAssignment_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constant__Group_3__1__Impl"


    // $ANTLR start "rule__ConstraintRuleBase__DomainAssignment_1"
    // InternalFirstOrderLogic.g:3506:1: rule__ConstraintRuleBase__DomainAssignment_1 : ( RULE_STRING ) ;
    public final void rule__ConstraintRuleBase__DomainAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3510:1: ( ( RULE_STRING ) )
            // InternalFirstOrderLogic.g:3511:2: ( RULE_STRING )
            {
            // InternalFirstOrderLogic.g:3511:2: ( RULE_STRING )
            // InternalFirstOrderLogic.g:3512:3: RULE_STRING
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
    // InternalFirstOrderLogic.g:3521:1: rule__ConstraintRuleBase__ConstraintsAssignment_2 : ( ruleConstraint ) ;
    public final void rule__ConstraintRuleBase__ConstraintsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3525:1: ( ( ruleConstraint ) )
            // InternalFirstOrderLogic.g:3526:2: ( ruleConstraint )
            {
            // InternalFirstOrderLogic.g:3526:2: ( ruleConstraint )
            // InternalFirstOrderLogic.g:3527:3: ruleConstraint
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
    // InternalFirstOrderLogic.g:3536:1: rule__Constraint__VariableAssignment_1 : ( ruleVariable ) ;
    public final void rule__Constraint__VariableAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3540:1: ( ( ruleVariable ) )
            // InternalFirstOrderLogic.g:3541:2: ( ruleVariable )
            {
            // InternalFirstOrderLogic.g:3541:2: ( ruleVariable )
            // InternalFirstOrderLogic.g:3542:3: ruleVariable
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
    // InternalFirstOrderLogic.g:3551:1: rule__Constraint__FormulaAssignment_3 : ( ruleFormula ) ;
    public final void rule__Constraint__FormulaAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3555:1: ( ( ruleFormula ) )
            // InternalFirstOrderLogic.g:3556:2: ( ruleFormula )
            {
            // InternalFirstOrderLogic.g:3556:2: ( ruleFormula )
            // InternalFirstOrderLogic.g:3557:3: ruleFormula
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
    // InternalFirstOrderLogic.g:3566:1: rule__Variable__TypeAssignment_0 : ( RULE_ID ) ;
    public final void rule__Variable__TypeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3570:1: ( ( RULE_ID ) )
            // InternalFirstOrderLogic.g:3571:2: ( RULE_ID )
            {
            // InternalFirstOrderLogic.g:3571:2: ( RULE_ID )
            // InternalFirstOrderLogic.g:3572:3: RULE_ID
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
    // InternalFirstOrderLogic.g:3581:1: rule__Variable__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Variable__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3585:1: ( ( RULE_ID ) )
            // InternalFirstOrderLogic.g:3586:2: ( RULE_ID )
            {
            // InternalFirstOrderLogic.g:3586:2: ( RULE_ID )
            // InternalFirstOrderLogic.g:3587:3: RULE_ID
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
    // InternalFirstOrderLogic.g:3596:1: rule__GetTerm__NameAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__GetTerm__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3600:1: ( ( ( RULE_ID ) ) )
            // InternalFirstOrderLogic.g:3601:2: ( ( RULE_ID ) )
            {
            // InternalFirstOrderLogic.g:3601:2: ( ( RULE_ID ) )
            // InternalFirstOrderLogic.g:3602:3: ( RULE_ID )
            {
             before(grammarAccess.getGetTermAccess().getNameVariableCrossReference_1_0()); 
            // InternalFirstOrderLogic.g:3603:3: ( RULE_ID )
            // InternalFirstOrderLogic.g:3604:4: RULE_ID
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
    // InternalFirstOrderLogic.g:3615:1: rule__GetTerm__FeatureAssignment_2 : ( ruleGet ) ;
    public final void rule__GetTerm__FeatureAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3619:1: ( ( ruleGet ) )
            // InternalFirstOrderLogic.g:3620:2: ( ruleGet )
            {
            // InternalFirstOrderLogic.g:3620:2: ( ruleGet )
            // InternalFirstOrderLogic.g:3621:3: ruleGet
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
    // InternalFirstOrderLogic.g:3630:1: rule__Get__TypeAssignment_1_0 : ( RULE_ID ) ;
    public final void rule__Get__TypeAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3634:1: ( ( RULE_ID ) )
            // InternalFirstOrderLogic.g:3635:2: ( RULE_ID )
            {
            // InternalFirstOrderLogic.g:3635:2: ( RULE_ID )
            // InternalFirstOrderLogic.g:3636:3: RULE_ID
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
    // InternalFirstOrderLogic.g:3645:1: rule__Get__NameAssignment_2 : ( ( ruleFeature ) ) ;
    public final void rule__Get__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3649:1: ( ( ( ruleFeature ) ) )
            // InternalFirstOrderLogic.g:3650:2: ( ( ruleFeature ) )
            {
            // InternalFirstOrderLogic.g:3650:2: ( ( ruleFeature ) )
            // InternalFirstOrderLogic.g:3651:3: ( ruleFeature )
            {
             before(grammarAccess.getGetAccess().getNameEStructuralFeatureCrossReference_2_0()); 
            // InternalFirstOrderLogic.g:3652:3: ( ruleFeature )
            // InternalFirstOrderLogic.g:3653:4: ruleFeature
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
    // InternalFirstOrderLogic.g:3664:1: rule__Get__NextAssignment_3 : ( ruleGet ) ;
    public final void rule__Get__NextAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3668:1: ( ( ruleGet ) )
            // InternalFirstOrderLogic.g:3669:2: ( ruleGet )
            {
            // InternalFirstOrderLogic.g:3669:2: ( ruleGet )
            // InternalFirstOrderLogic.g:3670:3: ruleGet
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


    // $ANTLR start "rule__Equality__RightAssignment_1_2"
    // InternalFirstOrderLogic.g:3679:1: rule__Equality__RightAssignment_1_2 : ( ruleBinaryFormula ) ;
    public final void rule__Equality__RightAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3683:1: ( ( ruleBinaryFormula ) )
            // InternalFirstOrderLogic.g:3684:2: ( ruleBinaryFormula )
            {
            // InternalFirstOrderLogic.g:3684:2: ( ruleBinaryFormula )
            // InternalFirstOrderLogic.g:3685:3: ruleBinaryFormula
            {
             before(grammarAccess.getEqualityAccess().getRightBinaryFormulaParserRuleCall_1_2_0()); 
            pushFollow(FOLLOW_2);
            ruleBinaryFormula();

            state._fsp--;

             after(grammarAccess.getEqualityAccess().getRightBinaryFormulaParserRuleCall_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Equality__RightAssignment_1_2"


    // $ANTLR start "rule__If__RightAssignment_1_2"
    // InternalFirstOrderLogic.g:3694:1: rule__If__RightAssignment_1_2 : ( ruleXor ) ;
    public final void rule__If__RightAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3698:1: ( ( ruleXor ) )
            // InternalFirstOrderLogic.g:3699:2: ( ruleXor )
            {
            // InternalFirstOrderLogic.g:3699:2: ( ruleXor )
            // InternalFirstOrderLogic.g:3700:3: ruleXor
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
    // InternalFirstOrderLogic.g:3709:1: rule__Xor__RightAssignment_1_2 : ( ruleOr ) ;
    public final void rule__Xor__RightAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3713:1: ( ( ruleOr ) )
            // InternalFirstOrderLogic.g:3714:2: ( ruleOr )
            {
            // InternalFirstOrderLogic.g:3714:2: ( ruleOr )
            // InternalFirstOrderLogic.g:3715:3: ruleOr
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
    // InternalFirstOrderLogic.g:3724:1: rule__Or__RightAssignment_1_2 : ( ruleAnd ) ;
    public final void rule__Or__RightAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3728:1: ( ( ruleAnd ) )
            // InternalFirstOrderLogic.g:3729:2: ( ruleAnd )
            {
            // InternalFirstOrderLogic.g:3729:2: ( ruleAnd )
            // InternalFirstOrderLogic.g:3730:3: ruleAnd
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
    // InternalFirstOrderLogic.g:3739:1: rule__And__RightAssignment_1_2 : ( ruleGreater ) ;
    public final void rule__And__RightAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3743:1: ( ( ruleGreater ) )
            // InternalFirstOrderLogic.g:3744:2: ( ruleGreater )
            {
            // InternalFirstOrderLogic.g:3744:2: ( ruleGreater )
            // InternalFirstOrderLogic.g:3745:3: ruleGreater
            {
             before(grammarAccess.getAndAccess().getRightGreaterParserRuleCall_1_2_0()); 
            pushFollow(FOLLOW_2);
            ruleGreater();

            state._fsp--;

             after(grammarAccess.getAndAccess().getRightGreaterParserRuleCall_1_2_0()); 

            }


            }

        }
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
    // InternalFirstOrderLogic.g:3754:1: rule__Not__NotAssignment_2 : ( ruleFormula ) ;
    public final void rule__Not__NotAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3758:1: ( ( ruleFormula ) )
            // InternalFirstOrderLogic.g:3759:2: ( ruleFormula )
            {
            // InternalFirstOrderLogic.g:3759:2: ( ruleFormula )
            // InternalFirstOrderLogic.g:3760:3: ruleFormula
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


    // $ANTLR start "rule__IsEmpty__TermAssignment_1"
    // InternalFirstOrderLogic.g:3769:1: rule__IsEmpty__TermAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__IsEmpty__TermAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3773:1: ( ( ( RULE_ID ) ) )
            // InternalFirstOrderLogic.g:3774:2: ( ( RULE_ID ) )
            {
            // InternalFirstOrderLogic.g:3774:2: ( ( RULE_ID ) )
            // InternalFirstOrderLogic.g:3775:3: ( RULE_ID )
            {
             before(grammarAccess.getIsEmptyAccess().getTermTermCrossReference_1_0()); 
            // InternalFirstOrderLogic.g:3776:3: ( RULE_ID )
            // InternalFirstOrderLogic.g:3777:4: RULE_ID
            {
             before(grammarAccess.getIsEmptyAccess().getTermTermIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getIsEmptyAccess().getTermTermIDTerminalRuleCall_1_0_1()); 

            }

             after(grammarAccess.getIsEmptyAccess().getTermTermCrossReference_1_0()); 

            }


            }

        }
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


    // $ANTLR start "rule__Greater__RightAssignment_1_2"
    // InternalFirstOrderLogic.g:3788:1: rule__Greater__RightAssignment_1_2 : ( ruleGreaterEqual ) ;
    public final void rule__Greater__RightAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3792:1: ( ( ruleGreaterEqual ) )
            // InternalFirstOrderLogic.g:3793:2: ( ruleGreaterEqual )
            {
            // InternalFirstOrderLogic.g:3793:2: ( ruleGreaterEqual )
            // InternalFirstOrderLogic.g:3794:3: ruleGreaterEqual
            {
             before(grammarAccess.getGreaterAccess().getRightGreaterEqualParserRuleCall_1_2_0()); 
            pushFollow(FOLLOW_2);
            ruleGreaterEqual();

            state._fsp--;

             after(grammarAccess.getGreaterAccess().getRightGreaterEqualParserRuleCall_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Greater__RightAssignment_1_2"


    // $ANTLR start "rule__GreaterEqual__RightAssignment_1_2"
    // InternalFirstOrderLogic.g:3803:1: rule__GreaterEqual__RightAssignment_1_2 : ( ruleSmaller ) ;
    public final void rule__GreaterEqual__RightAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3807:1: ( ( ruleSmaller ) )
            // InternalFirstOrderLogic.g:3808:2: ( ruleSmaller )
            {
            // InternalFirstOrderLogic.g:3808:2: ( ruleSmaller )
            // InternalFirstOrderLogic.g:3809:3: ruleSmaller
            {
             before(grammarAccess.getGreaterEqualAccess().getRightSmallerParserRuleCall_1_2_0()); 
            pushFollow(FOLLOW_2);
            ruleSmaller();

            state._fsp--;

             after(grammarAccess.getGreaterEqualAccess().getRightSmallerParserRuleCall_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GreaterEqual__RightAssignment_1_2"


    // $ANTLR start "rule__Smaller__RightAssignment_1_2"
    // InternalFirstOrderLogic.g:3818:1: rule__Smaller__RightAssignment_1_2 : ( ruleSmallerEqual ) ;
    public final void rule__Smaller__RightAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3822:1: ( ( ruleSmallerEqual ) )
            // InternalFirstOrderLogic.g:3823:2: ( ruleSmallerEqual )
            {
            // InternalFirstOrderLogic.g:3823:2: ( ruleSmallerEqual )
            // InternalFirstOrderLogic.g:3824:3: ruleSmallerEqual
            {
             before(grammarAccess.getSmallerAccess().getRightSmallerEqualParserRuleCall_1_2_0()); 
            pushFollow(FOLLOW_2);
            ruleSmallerEqual();

            state._fsp--;

             after(grammarAccess.getSmallerAccess().getRightSmallerEqualParserRuleCall_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Smaller__RightAssignment_1_2"


    // $ANTLR start "rule__SmallerEqual__RightAssignment_1_2"
    // InternalFirstOrderLogic.g:3833:1: rule__SmallerEqual__RightAssignment_1_2 : ( rulePrimary ) ;
    public final void rule__SmallerEqual__RightAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3837:1: ( ( rulePrimary ) )
            // InternalFirstOrderLogic.g:3838:2: ( rulePrimary )
            {
            // InternalFirstOrderLogic.g:3838:2: ( rulePrimary )
            // InternalFirstOrderLogic.g:3839:3: rulePrimary
            {
             before(grammarAccess.getSmallerEqualAccess().getRightPrimaryParserRuleCall_1_2_0()); 
            pushFollow(FOLLOW_2);
            rulePrimary();

            state._fsp--;

             after(grammarAccess.getSmallerEqualAccess().getRightPrimaryParserRuleCall_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SmallerEqual__RightAssignment_1_2"


    // $ANTLR start "rule__ForAll__NameAssignment_2"
    // InternalFirstOrderLogic.g:3848:1: rule__ForAll__NameAssignment_2 : ( ruleVariable ) ;
    public final void rule__ForAll__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3852:1: ( ( ruleVariable ) )
            // InternalFirstOrderLogic.g:3853:2: ( ruleVariable )
            {
            // InternalFirstOrderLogic.g:3853:2: ( ruleVariable )
            // InternalFirstOrderLogic.g:3854:3: ruleVariable
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
    // InternalFirstOrderLogic.g:3863:1: rule__ForAll__IterationAssignment_4 : ( ruleTerm ) ;
    public final void rule__ForAll__IterationAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3867:1: ( ( ruleTerm ) )
            // InternalFirstOrderLogic.g:3868:2: ( ruleTerm )
            {
            // InternalFirstOrderLogic.g:3868:2: ( ruleTerm )
            // InternalFirstOrderLogic.g:3869:3: ruleTerm
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
    // InternalFirstOrderLogic.g:3878:1: rule__ForAll__FormulaAssignment_6 : ( ruleFormula ) ;
    public final void rule__ForAll__FormulaAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3882:1: ( ( ruleFormula ) )
            // InternalFirstOrderLogic.g:3883:2: ( ruleFormula )
            {
            // InternalFirstOrderLogic.g:3883:2: ( ruleFormula )
            // InternalFirstOrderLogic.g:3884:3: ruleFormula
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
    // InternalFirstOrderLogic.g:3893:1: rule__Exists__NameAssignment_2 : ( ruleVariable ) ;
    public final void rule__Exists__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3897:1: ( ( ruleVariable ) )
            // InternalFirstOrderLogic.g:3898:2: ( ruleVariable )
            {
            // InternalFirstOrderLogic.g:3898:2: ( ruleVariable )
            // InternalFirstOrderLogic.g:3899:3: ruleVariable
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
    // InternalFirstOrderLogic.g:3908:1: rule__Exists__IterationAssignment_4 : ( ruleTerm ) ;
    public final void rule__Exists__IterationAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3912:1: ( ( ruleTerm ) )
            // InternalFirstOrderLogic.g:3913:2: ( ruleTerm )
            {
            // InternalFirstOrderLogic.g:3913:2: ( ruleTerm )
            // InternalFirstOrderLogic.g:3914:3: ruleTerm
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
    // InternalFirstOrderLogic.g:3923:1: rule__Exists__FormulaAssignment_6 : ( ruleFormula ) ;
    public final void rule__Exists__FormulaAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3927:1: ( ( ruleFormula ) )
            // InternalFirstOrderLogic.g:3928:2: ( ruleFormula )
            {
            // InternalFirstOrderLogic.g:3928:2: ( ruleFormula )
            // InternalFirstOrderLogic.g:3929:3: ruleFormula
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


    // $ANTLR start "rule__Constant__ValueAssignment_0_1"
    // InternalFirstOrderLogic.g:3938:1: rule__Constant__ValueAssignment_0_1 : ( RULE_INT ) ;
    public final void rule__Constant__ValueAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3942:1: ( ( RULE_INT ) )
            // InternalFirstOrderLogic.g:3943:2: ( RULE_INT )
            {
            // InternalFirstOrderLogic.g:3943:2: ( RULE_INT )
            // InternalFirstOrderLogic.g:3944:3: RULE_INT
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
    // InternalFirstOrderLogic.g:3953:1: rule__Constant__ValueAssignment_1_1 : ( RULE_STRING ) ;
    public final void rule__Constant__ValueAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3957:1: ( ( RULE_STRING ) )
            // InternalFirstOrderLogic.g:3958:2: ( RULE_STRING )
            {
            // InternalFirstOrderLogic.g:3958:2: ( RULE_STRING )
            // InternalFirstOrderLogic.g:3959:3: RULE_STRING
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


    // $ANTLR start "rule__Constant__ValueAssignment_2_1"
    // InternalFirstOrderLogic.g:3968:1: rule__Constant__ValueAssignment_2_1 : ( ( rule__Constant__ValueAlternatives_2_1_0 ) ) ;
    public final void rule__Constant__ValueAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3972:1: ( ( ( rule__Constant__ValueAlternatives_2_1_0 ) ) )
            // InternalFirstOrderLogic.g:3973:2: ( ( rule__Constant__ValueAlternatives_2_1_0 ) )
            {
            // InternalFirstOrderLogic.g:3973:2: ( ( rule__Constant__ValueAlternatives_2_1_0 ) )
            // InternalFirstOrderLogic.g:3974:3: ( rule__Constant__ValueAlternatives_2_1_0 )
            {
             before(grammarAccess.getConstantAccess().getValueAlternatives_2_1_0()); 
            // InternalFirstOrderLogic.g:3975:3: ( rule__Constant__ValueAlternatives_2_1_0 )
            // InternalFirstOrderLogic.g:3975:4: rule__Constant__ValueAlternatives_2_1_0
            {
            pushFollow(FOLLOW_2);
            rule__Constant__ValueAlternatives_2_1_0();

            state._fsp--;


            }

             after(grammarAccess.getConstantAccess().getValueAlternatives_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constant__ValueAssignment_2_1"


    // $ANTLR start "rule__Constant__VariableAssignment_3_1"
    // InternalFirstOrderLogic.g:3983:1: rule__Constant__VariableAssignment_3_1 : ( ( RULE_ID ) ) ;
    public final void rule__Constant__VariableAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3987:1: ( ( ( RULE_ID ) ) )
            // InternalFirstOrderLogic.g:3988:2: ( ( RULE_ID ) )
            {
            // InternalFirstOrderLogic.g:3988:2: ( ( RULE_ID ) )
            // InternalFirstOrderLogic.g:3989:3: ( RULE_ID )
            {
             before(grammarAccess.getConstantAccess().getVariableVariableCrossReference_3_1_0()); 
            // InternalFirstOrderLogic.g:3990:3: ( RULE_ID )
            // InternalFirstOrderLogic.g:3991:4: RULE_ID
            {
             before(grammarAccess.getConstantAccess().getVariableVariableIDTerminalRuleCall_3_1_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getConstantAccess().getVariableVariableIDTerminalRuleCall_3_1_0_1()); 

            }

             after(grammarAccess.getConstantAccess().getVariableVariableCrossReference_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constant__VariableAssignment_3_1"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000342801870L});
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
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000140000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000000001800L});

}