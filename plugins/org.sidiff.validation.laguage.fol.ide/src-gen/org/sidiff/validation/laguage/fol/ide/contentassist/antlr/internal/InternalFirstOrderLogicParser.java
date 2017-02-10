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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'true'", "'false'", "'domain'", "'import'", "'constraint'", "'message'", "'context'", "':'", "'='", "'implies'", "'xor'", "'or'", "'and'", "'not('", "')'", "'equals('", "','", "'isGreater('", "'isGreaterEqual('", "'isSmaller('", "'isSmallerEqual('", "'isEmpty('", "'forAll('", "'in'", "'exists('", "'('", "'.'", "'::'"
    };
    public static final int RULE_STRING=4;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__37=37;
    public static final int T__16=16;
    public static final int T__38=38;
    public static final int T__17=17;
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
    // InternalFirstOrderLogic.g:137:1: ruleFormula : ( ruleIff ) ;
    public final void ruleFormula() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:141:2: ( ( ruleIff ) )
            // InternalFirstOrderLogic.g:142:2: ( ruleIff )
            {
            // InternalFirstOrderLogic.g:142:2: ( ruleIff )
            // InternalFirstOrderLogic.g:143:3: ruleIff
            {
             before(grammarAccess.getFormulaAccess().getIffParserRuleCall()); 
            pushFollow(FOLLOW_2);
            ruleIff();

            state._fsp--;

             after(grammarAccess.getFormulaAccess().getIffParserRuleCall()); 

            }


            }

        }
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


    // $ANTLR start "entryRuleIff"
    // InternalFirstOrderLogic.g:153:1: entryRuleIff : ruleIff EOF ;
    public final void entryRuleIff() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:154:1: ( ruleIff EOF )
            // InternalFirstOrderLogic.g:155:1: ruleIff EOF
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
    // InternalFirstOrderLogic.g:162:1: ruleIff : ( ( rule__Iff__Group__0 ) ) ;
    public final void ruleIff() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:166:2: ( ( ( rule__Iff__Group__0 ) ) )
            // InternalFirstOrderLogic.g:167:2: ( ( rule__Iff__Group__0 ) )
            {
            // InternalFirstOrderLogic.g:167:2: ( ( rule__Iff__Group__0 ) )
            // InternalFirstOrderLogic.g:168:3: ( rule__Iff__Group__0 )
            {
             before(grammarAccess.getIffAccess().getGroup()); 
            // InternalFirstOrderLogic.g:169:3: ( rule__Iff__Group__0 )
            // InternalFirstOrderLogic.g:169:4: rule__Iff__Group__0
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


    // $ANTLR start "entryRuleBinaryFormula"
    // InternalFirstOrderLogic.g:178:1: entryRuleBinaryFormula : ruleBinaryFormula EOF ;
    public final void entryRuleBinaryFormula() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:179:1: ( ruleBinaryFormula EOF )
            // InternalFirstOrderLogic.g:180:1: ruleBinaryFormula EOF
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
    // InternalFirstOrderLogic.g:187:1: ruleBinaryFormula : ( ruleIf ) ;
    public final void ruleBinaryFormula() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:191:2: ( ( ruleIf ) )
            // InternalFirstOrderLogic.g:192:2: ( ruleIf )
            {
            // InternalFirstOrderLogic.g:192:2: ( ruleIf )
            // InternalFirstOrderLogic.g:193:3: ruleIf
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


    // $ANTLR start "entryRuleConstant"
    // InternalFirstOrderLogic.g:753:1: entryRuleConstant : ruleConstant EOF ;
    public final void entryRuleConstant() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:754:1: ( ruleConstant EOF )
            // InternalFirstOrderLogic.g:755:1: ruleConstant EOF
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
    // InternalFirstOrderLogic.g:762:1: ruleConstant : ( ( rule__Constant__Alternatives ) ) ;
    public final void ruleConstant() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:766:2: ( ( ( rule__Constant__Alternatives ) ) )
            // InternalFirstOrderLogic.g:767:2: ( ( rule__Constant__Alternatives ) )
            {
            // InternalFirstOrderLogic.g:767:2: ( ( rule__Constant__Alternatives ) )
            // InternalFirstOrderLogic.g:768:3: ( rule__Constant__Alternatives )
            {
             before(grammarAccess.getConstantAccess().getAlternatives()); 
            // InternalFirstOrderLogic.g:769:3: ( rule__Constant__Alternatives )
            // InternalFirstOrderLogic.g:769:4: rule__Constant__Alternatives
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
    // InternalFirstOrderLogic.g:777:1: rule__Predicate__Alternatives : ( ( ruleEquals ) | ( ruleInequality ) | ( ruleIsEmpty ) );
    public final void rule__Predicate__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:781:1: ( ( ruleEquals ) | ( ruleInequality ) | ( ruleIsEmpty ) )
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
                    // InternalFirstOrderLogic.g:782:2: ( ruleEquals )
                    {
                    // InternalFirstOrderLogic.g:782:2: ( ruleEquals )
                    // InternalFirstOrderLogic.g:783:3: ruleEquals
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
                    // InternalFirstOrderLogic.g:788:2: ( ruleInequality )
                    {
                    // InternalFirstOrderLogic.g:788:2: ( ruleInequality )
                    // InternalFirstOrderLogic.g:789:3: ruleInequality
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
                    // InternalFirstOrderLogic.g:794:2: ( ruleIsEmpty )
                    {
                    // InternalFirstOrderLogic.g:794:2: ( ruleIsEmpty )
                    // InternalFirstOrderLogic.g:795:3: ruleIsEmpty
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
    // InternalFirstOrderLogic.g:804:1: rule__Inequality__Alternatives : ( ( ruleGreater ) | ( ruleGreaterEqual ) | ( ruleSmaller ) | ( ruleSmallerEqual ) );
    public final void rule__Inequality__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:808:1: ( ( ruleGreater ) | ( ruleGreaterEqual ) | ( ruleSmaller ) | ( ruleSmallerEqual ) )
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
                    // InternalFirstOrderLogic.g:809:2: ( ruleGreater )
                    {
                    // InternalFirstOrderLogic.g:809:2: ( ruleGreater )
                    // InternalFirstOrderLogic.g:810:3: ruleGreater
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
                    // InternalFirstOrderLogic.g:815:2: ( ruleGreaterEqual )
                    {
                    // InternalFirstOrderLogic.g:815:2: ( ruleGreaterEqual )
                    // InternalFirstOrderLogic.g:816:3: ruleGreaterEqual
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
                    // InternalFirstOrderLogic.g:821:2: ( ruleSmaller )
                    {
                    // InternalFirstOrderLogic.g:821:2: ( ruleSmaller )
                    // InternalFirstOrderLogic.g:822:3: ruleSmaller
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
                    // InternalFirstOrderLogic.g:827:2: ( ruleSmallerEqual )
                    {
                    // InternalFirstOrderLogic.g:827:2: ( ruleSmallerEqual )
                    // InternalFirstOrderLogic.g:828:3: ruleSmallerEqual
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
    // InternalFirstOrderLogic.g:837:1: rule__Quantifier__Alternatives : ( ( ruleForAll ) | ( ruleExists ) );
    public final void rule__Quantifier__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:841:1: ( ( ruleForAll ) | ( ruleExists ) )
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
                    // InternalFirstOrderLogic.g:842:2: ( ruleForAll )
                    {
                    // InternalFirstOrderLogic.g:842:2: ( ruleForAll )
                    // InternalFirstOrderLogic.g:843:3: ruleForAll
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
                    // InternalFirstOrderLogic.g:848:2: ( ruleExists )
                    {
                    // InternalFirstOrderLogic.g:848:2: ( ruleExists )
                    // InternalFirstOrderLogic.g:849:3: ruleExists
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
    // InternalFirstOrderLogic.g:858:1: rule__BooleanExpression__Alternatives : ( ( ( rule__BooleanExpression__Group_0__0 ) ) | ( ruleUnaryFormula ) | ( ruleQuantifier ) | ( rulePredicate ) | ( ruleBoolConstant ) );
    public final void rule__BooleanExpression__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:862:1: ( ( ( rule__BooleanExpression__Group_0__0 ) ) | ( ruleUnaryFormula ) | ( ruleQuantifier ) | ( rulePredicate ) | ( ruleBoolConstant ) )
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
                    // InternalFirstOrderLogic.g:863:2: ( ( rule__BooleanExpression__Group_0__0 ) )
                    {
                    // InternalFirstOrderLogic.g:863:2: ( ( rule__BooleanExpression__Group_0__0 ) )
                    // InternalFirstOrderLogic.g:864:3: ( rule__BooleanExpression__Group_0__0 )
                    {
                     before(grammarAccess.getBooleanExpressionAccess().getGroup_0()); 
                    // InternalFirstOrderLogic.g:865:3: ( rule__BooleanExpression__Group_0__0 )
                    // InternalFirstOrderLogic.g:865:4: rule__BooleanExpression__Group_0__0
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
                    // InternalFirstOrderLogic.g:869:2: ( ruleUnaryFormula )
                    {
                    // InternalFirstOrderLogic.g:869:2: ( ruleUnaryFormula )
                    // InternalFirstOrderLogic.g:870:3: ruleUnaryFormula
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
                    // InternalFirstOrderLogic.g:875:2: ( ruleQuantifier )
                    {
                    // InternalFirstOrderLogic.g:875:2: ( ruleQuantifier )
                    // InternalFirstOrderLogic.g:876:3: ruleQuantifier
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
                    // InternalFirstOrderLogic.g:881:2: ( rulePredicate )
                    {
                    // InternalFirstOrderLogic.g:881:2: ( rulePredicate )
                    // InternalFirstOrderLogic.g:882:3: rulePredicate
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
                    // InternalFirstOrderLogic.g:887:2: ( ruleBoolConstant )
                    {
                    // InternalFirstOrderLogic.g:887:2: ( ruleBoolConstant )
                    // InternalFirstOrderLogic.g:888:3: ruleBoolConstant
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
    // InternalFirstOrderLogic.g:897:1: rule__BoolConstant__ValueAlternatives_1_0 : ( ( 'true' ) | ( 'false' ) );
    public final void rule__BoolConstant__ValueAlternatives_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:901:1: ( ( 'true' ) | ( 'false' ) )
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
                    // InternalFirstOrderLogic.g:902:2: ( 'true' )
                    {
                    // InternalFirstOrderLogic.g:902:2: ( 'true' )
                    // InternalFirstOrderLogic.g:903:3: 'true'
                    {
                     before(grammarAccess.getBoolConstantAccess().getValueTrueKeyword_1_0_0()); 
                    match(input,11,FOLLOW_2); 
                     after(grammarAccess.getBoolConstantAccess().getValueTrueKeyword_1_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalFirstOrderLogic.g:908:2: ( 'false' )
                    {
                    // InternalFirstOrderLogic.g:908:2: ( 'false' )
                    // InternalFirstOrderLogic.g:909:3: 'false'
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
    // InternalFirstOrderLogic.g:918:1: rule__Term__Alternatives : ( ( ruleConstant ) | ( ruleVariableRef ) );
    public final void rule__Term__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:922:1: ( ( ruleConstant ) | ( ruleVariableRef ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_STRING||LA6_0==RULE_INT||(LA6_0>=11 && LA6_0<=12)) ) {
                alt6=1;
            }
            else if ( (LA6_0==RULE_ID) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalFirstOrderLogic.g:923:2: ( ruleConstant )
                    {
                    // InternalFirstOrderLogic.g:923:2: ( ruleConstant )
                    // InternalFirstOrderLogic.g:924:3: ruleConstant
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
                    // InternalFirstOrderLogic.g:929:2: ( ruleVariableRef )
                    {
                    // InternalFirstOrderLogic.g:929:2: ( ruleVariableRef )
                    // InternalFirstOrderLogic.g:930:3: ruleVariableRef
                    {
                     before(grammarAccess.getTermAccess().getVariableRefParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleVariableRef();

                    state._fsp--;

                     after(grammarAccess.getTermAccess().getVariableRefParserRuleCall_1()); 

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
    // InternalFirstOrderLogic.g:939:1: rule__Constant__Alternatives : ( ( ( rule__Constant__Group_0__0 ) ) | ( ( rule__Constant__Group_1__0 ) ) | ( ruleBoolConstant ) );
    public final void rule__Constant__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:943:1: ( ( ( rule__Constant__Group_0__0 ) ) | ( ( rule__Constant__Group_1__0 ) ) | ( ruleBoolConstant ) )
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
                    // InternalFirstOrderLogic.g:944:2: ( ( rule__Constant__Group_0__0 ) )
                    {
                    // InternalFirstOrderLogic.g:944:2: ( ( rule__Constant__Group_0__0 ) )
                    // InternalFirstOrderLogic.g:945:3: ( rule__Constant__Group_0__0 )
                    {
                     before(grammarAccess.getConstantAccess().getGroup_0()); 
                    // InternalFirstOrderLogic.g:946:3: ( rule__Constant__Group_0__0 )
                    // InternalFirstOrderLogic.g:946:4: rule__Constant__Group_0__0
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
                    // InternalFirstOrderLogic.g:950:2: ( ( rule__Constant__Group_1__0 ) )
                    {
                    // InternalFirstOrderLogic.g:950:2: ( ( rule__Constant__Group_1__0 ) )
                    // InternalFirstOrderLogic.g:951:3: ( rule__Constant__Group_1__0 )
                    {
                     before(grammarAccess.getConstantAccess().getGroup_1()); 
                    // InternalFirstOrderLogic.g:952:3: ( rule__Constant__Group_1__0 )
                    // InternalFirstOrderLogic.g:952:4: rule__Constant__Group_1__0
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
                    // InternalFirstOrderLogic.g:956:2: ( ruleBoolConstant )
                    {
                    // InternalFirstOrderLogic.g:956:2: ( ruleBoolConstant )
                    // InternalFirstOrderLogic.g:957:3: ruleBoolConstant
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


    // $ANTLR start "rule__ConstraintRuleBase__Group__0"
    // InternalFirstOrderLogic.g:966:1: rule__ConstraintRuleBase__Group__0 : rule__ConstraintRuleBase__Group__0__Impl rule__ConstraintRuleBase__Group__1 ;
    public final void rule__ConstraintRuleBase__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:970:1: ( rule__ConstraintRuleBase__Group__0__Impl rule__ConstraintRuleBase__Group__1 )
            // InternalFirstOrderLogic.g:971:2: rule__ConstraintRuleBase__Group__0__Impl rule__ConstraintRuleBase__Group__1
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
    // InternalFirstOrderLogic.g:978:1: rule__ConstraintRuleBase__Group__0__Impl : ( 'domain' ) ;
    public final void rule__ConstraintRuleBase__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:982:1: ( ( 'domain' ) )
            // InternalFirstOrderLogic.g:983:1: ( 'domain' )
            {
            // InternalFirstOrderLogic.g:983:1: ( 'domain' )
            // InternalFirstOrderLogic.g:984:2: 'domain'
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
    // InternalFirstOrderLogic.g:993:1: rule__ConstraintRuleBase__Group__1 : rule__ConstraintRuleBase__Group__1__Impl rule__ConstraintRuleBase__Group__2 ;
    public final void rule__ConstraintRuleBase__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:997:1: ( rule__ConstraintRuleBase__Group__1__Impl rule__ConstraintRuleBase__Group__2 )
            // InternalFirstOrderLogic.g:998:2: rule__ConstraintRuleBase__Group__1__Impl rule__ConstraintRuleBase__Group__2
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
    // InternalFirstOrderLogic.g:1005:1: rule__ConstraintRuleBase__Group__1__Impl : ( ( rule__ConstraintRuleBase__DomainAssignment_1 ) ) ;
    public final void rule__ConstraintRuleBase__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1009:1: ( ( ( rule__ConstraintRuleBase__DomainAssignment_1 ) ) )
            // InternalFirstOrderLogic.g:1010:1: ( ( rule__ConstraintRuleBase__DomainAssignment_1 ) )
            {
            // InternalFirstOrderLogic.g:1010:1: ( ( rule__ConstraintRuleBase__DomainAssignment_1 ) )
            // InternalFirstOrderLogic.g:1011:2: ( rule__ConstraintRuleBase__DomainAssignment_1 )
            {
             before(grammarAccess.getConstraintRuleBaseAccess().getDomainAssignment_1()); 
            // InternalFirstOrderLogic.g:1012:2: ( rule__ConstraintRuleBase__DomainAssignment_1 )
            // InternalFirstOrderLogic.g:1012:3: rule__ConstraintRuleBase__DomainAssignment_1
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
    // InternalFirstOrderLogic.g:1020:1: rule__ConstraintRuleBase__Group__2 : rule__ConstraintRuleBase__Group__2__Impl rule__ConstraintRuleBase__Group__3 ;
    public final void rule__ConstraintRuleBase__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1024:1: ( rule__ConstraintRuleBase__Group__2__Impl rule__ConstraintRuleBase__Group__3 )
            // InternalFirstOrderLogic.g:1025:2: rule__ConstraintRuleBase__Group__2__Impl rule__ConstraintRuleBase__Group__3
            {
            pushFollow(FOLLOW_3);
            rule__ConstraintRuleBase__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ConstraintRuleBase__Group__3();

            state._fsp--;


            }

        }
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
    // InternalFirstOrderLogic.g:1032:1: rule__ConstraintRuleBase__Group__2__Impl : ( 'import' ) ;
    public final void rule__ConstraintRuleBase__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1036:1: ( ( 'import' ) )
            // InternalFirstOrderLogic.g:1037:1: ( 'import' )
            {
            // InternalFirstOrderLogic.g:1037:1: ( 'import' )
            // InternalFirstOrderLogic.g:1038:2: 'import'
            {
             before(grammarAccess.getConstraintRuleBaseAccess().getImportKeyword_2()); 
            match(input,14,FOLLOW_2); 
             after(grammarAccess.getConstraintRuleBaseAccess().getImportKeyword_2()); 

            }


            }

        }
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


    // $ANTLR start "rule__ConstraintRuleBase__Group__3"
    // InternalFirstOrderLogic.g:1047:1: rule__ConstraintRuleBase__Group__3 : rule__ConstraintRuleBase__Group__3__Impl rule__ConstraintRuleBase__Group__4 ;
    public final void rule__ConstraintRuleBase__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1051:1: ( rule__ConstraintRuleBase__Group__3__Impl rule__ConstraintRuleBase__Group__4 )
            // InternalFirstOrderLogic.g:1052:2: rule__ConstraintRuleBase__Group__3__Impl rule__ConstraintRuleBase__Group__4
            {
            pushFollow(FOLLOW_5);
            rule__ConstraintRuleBase__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ConstraintRuleBase__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintRuleBase__Group__3"


    // $ANTLR start "rule__ConstraintRuleBase__Group__3__Impl"
    // InternalFirstOrderLogic.g:1059:1: rule__ConstraintRuleBase__Group__3__Impl : ( ( rule__ConstraintRuleBase__PackageImportAssignment_3 ) ) ;
    public final void rule__ConstraintRuleBase__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1063:1: ( ( ( rule__ConstraintRuleBase__PackageImportAssignment_3 ) ) )
            // InternalFirstOrderLogic.g:1064:1: ( ( rule__ConstraintRuleBase__PackageImportAssignment_3 ) )
            {
            // InternalFirstOrderLogic.g:1064:1: ( ( rule__ConstraintRuleBase__PackageImportAssignment_3 ) )
            // InternalFirstOrderLogic.g:1065:2: ( rule__ConstraintRuleBase__PackageImportAssignment_3 )
            {
             before(grammarAccess.getConstraintRuleBaseAccess().getPackageImportAssignment_3()); 
            // InternalFirstOrderLogic.g:1066:2: ( rule__ConstraintRuleBase__PackageImportAssignment_3 )
            // InternalFirstOrderLogic.g:1066:3: rule__ConstraintRuleBase__PackageImportAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__ConstraintRuleBase__PackageImportAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getConstraintRuleBaseAccess().getPackageImportAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintRuleBase__Group__3__Impl"


    // $ANTLR start "rule__ConstraintRuleBase__Group__4"
    // InternalFirstOrderLogic.g:1074:1: rule__ConstraintRuleBase__Group__4 : rule__ConstraintRuleBase__Group__4__Impl ;
    public final void rule__ConstraintRuleBase__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1078:1: ( rule__ConstraintRuleBase__Group__4__Impl )
            // InternalFirstOrderLogic.g:1079:2: rule__ConstraintRuleBase__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ConstraintRuleBase__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintRuleBase__Group__4"


    // $ANTLR start "rule__ConstraintRuleBase__Group__4__Impl"
    // InternalFirstOrderLogic.g:1085:1: rule__ConstraintRuleBase__Group__4__Impl : ( ( rule__ConstraintRuleBase__ConstraintsAssignment_4 )* ) ;
    public final void rule__ConstraintRuleBase__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1089:1: ( ( ( rule__ConstraintRuleBase__ConstraintsAssignment_4 )* ) )
            // InternalFirstOrderLogic.g:1090:1: ( ( rule__ConstraintRuleBase__ConstraintsAssignment_4 )* )
            {
            // InternalFirstOrderLogic.g:1090:1: ( ( rule__ConstraintRuleBase__ConstraintsAssignment_4 )* )
            // InternalFirstOrderLogic.g:1091:2: ( rule__ConstraintRuleBase__ConstraintsAssignment_4 )*
            {
             before(grammarAccess.getConstraintRuleBaseAccess().getConstraintsAssignment_4()); 
            // InternalFirstOrderLogic.g:1092:2: ( rule__ConstraintRuleBase__ConstraintsAssignment_4 )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==15) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalFirstOrderLogic.g:1092:3: rule__ConstraintRuleBase__ConstraintsAssignment_4
            	    {
            	    pushFollow(FOLLOW_6);
            	    rule__ConstraintRuleBase__ConstraintsAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

             after(grammarAccess.getConstraintRuleBaseAccess().getConstraintsAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintRuleBase__Group__4__Impl"


    // $ANTLR start "rule__Constraint__Group__0"
    // InternalFirstOrderLogic.g:1101:1: rule__Constraint__Group__0 : rule__Constraint__Group__0__Impl rule__Constraint__Group__1 ;
    public final void rule__Constraint__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1105:1: ( rule__Constraint__Group__0__Impl rule__Constraint__Group__1 )
            // InternalFirstOrderLogic.g:1106:2: rule__Constraint__Group__0__Impl rule__Constraint__Group__1
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
    // InternalFirstOrderLogic.g:1113:1: rule__Constraint__Group__0__Impl : ( 'constraint' ) ;
    public final void rule__Constraint__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1117:1: ( ( 'constraint' ) )
            // InternalFirstOrderLogic.g:1118:1: ( 'constraint' )
            {
            // InternalFirstOrderLogic.g:1118:1: ( 'constraint' )
            // InternalFirstOrderLogic.g:1119:2: 'constraint'
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
    // InternalFirstOrderLogic.g:1128:1: rule__Constraint__Group__1 : rule__Constraint__Group__1__Impl rule__Constraint__Group__2 ;
    public final void rule__Constraint__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1132:1: ( rule__Constraint__Group__1__Impl rule__Constraint__Group__2 )
            // InternalFirstOrderLogic.g:1133:2: rule__Constraint__Group__1__Impl rule__Constraint__Group__2
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
    // InternalFirstOrderLogic.g:1140:1: rule__Constraint__Group__1__Impl : ( ( rule__Constraint__NameAssignment_1 ) ) ;
    public final void rule__Constraint__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1144:1: ( ( ( rule__Constraint__NameAssignment_1 ) ) )
            // InternalFirstOrderLogic.g:1145:1: ( ( rule__Constraint__NameAssignment_1 ) )
            {
            // InternalFirstOrderLogic.g:1145:1: ( ( rule__Constraint__NameAssignment_1 ) )
            // InternalFirstOrderLogic.g:1146:2: ( rule__Constraint__NameAssignment_1 )
            {
             before(grammarAccess.getConstraintAccess().getNameAssignment_1()); 
            // InternalFirstOrderLogic.g:1147:2: ( rule__Constraint__NameAssignment_1 )
            // InternalFirstOrderLogic.g:1147:3: rule__Constraint__NameAssignment_1
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
    // InternalFirstOrderLogic.g:1155:1: rule__Constraint__Group__2 : rule__Constraint__Group__2__Impl rule__Constraint__Group__3 ;
    public final void rule__Constraint__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1159:1: ( rule__Constraint__Group__2__Impl rule__Constraint__Group__3 )
            // InternalFirstOrderLogic.g:1160:2: rule__Constraint__Group__2__Impl rule__Constraint__Group__3
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
    // InternalFirstOrderLogic.g:1167:1: rule__Constraint__Group__2__Impl : ( 'message' ) ;
    public final void rule__Constraint__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1171:1: ( ( 'message' ) )
            // InternalFirstOrderLogic.g:1172:1: ( 'message' )
            {
            // InternalFirstOrderLogic.g:1172:1: ( 'message' )
            // InternalFirstOrderLogic.g:1173:2: 'message'
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
    // InternalFirstOrderLogic.g:1182:1: rule__Constraint__Group__3 : rule__Constraint__Group__3__Impl rule__Constraint__Group__4 ;
    public final void rule__Constraint__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1186:1: ( rule__Constraint__Group__3__Impl rule__Constraint__Group__4 )
            // InternalFirstOrderLogic.g:1187:2: rule__Constraint__Group__3__Impl rule__Constraint__Group__4
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
    // InternalFirstOrderLogic.g:1194:1: rule__Constraint__Group__3__Impl : ( ( rule__Constraint__MessageAssignment_3 ) ) ;
    public final void rule__Constraint__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1198:1: ( ( ( rule__Constraint__MessageAssignment_3 ) ) )
            // InternalFirstOrderLogic.g:1199:1: ( ( rule__Constraint__MessageAssignment_3 ) )
            {
            // InternalFirstOrderLogic.g:1199:1: ( ( rule__Constraint__MessageAssignment_3 ) )
            // InternalFirstOrderLogic.g:1200:2: ( rule__Constraint__MessageAssignment_3 )
            {
             before(grammarAccess.getConstraintAccess().getMessageAssignment_3()); 
            // InternalFirstOrderLogic.g:1201:2: ( rule__Constraint__MessageAssignment_3 )
            // InternalFirstOrderLogic.g:1201:3: rule__Constraint__MessageAssignment_3
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
    // InternalFirstOrderLogic.g:1209:1: rule__Constraint__Group__4 : rule__Constraint__Group__4__Impl rule__Constraint__Group__5 ;
    public final void rule__Constraint__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1213:1: ( rule__Constraint__Group__4__Impl rule__Constraint__Group__5 )
            // InternalFirstOrderLogic.g:1214:2: rule__Constraint__Group__4__Impl rule__Constraint__Group__5
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
    // InternalFirstOrderLogic.g:1221:1: rule__Constraint__Group__4__Impl : ( 'context' ) ;
    public final void rule__Constraint__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1225:1: ( ( 'context' ) )
            // InternalFirstOrderLogic.g:1226:1: ( 'context' )
            {
            // InternalFirstOrderLogic.g:1226:1: ( 'context' )
            // InternalFirstOrderLogic.g:1227:2: 'context'
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
    // InternalFirstOrderLogic.g:1236:1: rule__Constraint__Group__5 : rule__Constraint__Group__5__Impl rule__Constraint__Group__6 ;
    public final void rule__Constraint__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1240:1: ( rule__Constraint__Group__5__Impl rule__Constraint__Group__6 )
            // InternalFirstOrderLogic.g:1241:2: rule__Constraint__Group__5__Impl rule__Constraint__Group__6
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
    // InternalFirstOrderLogic.g:1248:1: rule__Constraint__Group__5__Impl : ( ( rule__Constraint__VariableAssignment_5 ) ) ;
    public final void rule__Constraint__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1252:1: ( ( ( rule__Constraint__VariableAssignment_5 ) ) )
            // InternalFirstOrderLogic.g:1253:1: ( ( rule__Constraint__VariableAssignment_5 ) )
            {
            // InternalFirstOrderLogic.g:1253:1: ( ( rule__Constraint__VariableAssignment_5 ) )
            // InternalFirstOrderLogic.g:1254:2: ( rule__Constraint__VariableAssignment_5 )
            {
             before(grammarAccess.getConstraintAccess().getVariableAssignment_5()); 
            // InternalFirstOrderLogic.g:1255:2: ( rule__Constraint__VariableAssignment_5 )
            // InternalFirstOrderLogic.g:1255:3: rule__Constraint__VariableAssignment_5
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
    // InternalFirstOrderLogic.g:1263:1: rule__Constraint__Group__6 : rule__Constraint__Group__6__Impl rule__Constraint__Group__7 ;
    public final void rule__Constraint__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1267:1: ( rule__Constraint__Group__6__Impl rule__Constraint__Group__7 )
            // InternalFirstOrderLogic.g:1268:2: rule__Constraint__Group__6__Impl rule__Constraint__Group__7
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
    // InternalFirstOrderLogic.g:1275:1: rule__Constraint__Group__6__Impl : ( ':' ) ;
    public final void rule__Constraint__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1279:1: ( ( ':' ) )
            // InternalFirstOrderLogic.g:1280:1: ( ':' )
            {
            // InternalFirstOrderLogic.g:1280:1: ( ':' )
            // InternalFirstOrderLogic.g:1281:2: ':'
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
    // InternalFirstOrderLogic.g:1290:1: rule__Constraint__Group__7 : rule__Constraint__Group__7__Impl ;
    public final void rule__Constraint__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1294:1: ( rule__Constraint__Group__7__Impl )
            // InternalFirstOrderLogic.g:1295:2: rule__Constraint__Group__7__Impl
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
    // InternalFirstOrderLogic.g:1301:1: rule__Constraint__Group__7__Impl : ( ( rule__Constraint__FormulaAssignment_7 ) ) ;
    public final void rule__Constraint__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1305:1: ( ( ( rule__Constraint__FormulaAssignment_7 ) ) )
            // InternalFirstOrderLogic.g:1306:1: ( ( rule__Constraint__FormulaAssignment_7 ) )
            {
            // InternalFirstOrderLogic.g:1306:1: ( ( rule__Constraint__FormulaAssignment_7 ) )
            // InternalFirstOrderLogic.g:1307:2: ( rule__Constraint__FormulaAssignment_7 )
            {
             before(grammarAccess.getConstraintAccess().getFormulaAssignment_7()); 
            // InternalFirstOrderLogic.g:1308:2: ( rule__Constraint__FormulaAssignment_7 )
            // InternalFirstOrderLogic.g:1308:3: rule__Constraint__FormulaAssignment_7
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
    // InternalFirstOrderLogic.g:1317:1: rule__Variable__Group__0 : rule__Variable__Group__0__Impl rule__Variable__Group__1 ;
    public final void rule__Variable__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1321:1: ( rule__Variable__Group__0__Impl rule__Variable__Group__1 )
            // InternalFirstOrderLogic.g:1322:2: rule__Variable__Group__0__Impl rule__Variable__Group__1
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
    // InternalFirstOrderLogic.g:1329:1: rule__Variable__Group__0__Impl : ( ( rule__Variable__TypeAssignment_0 ) ) ;
    public final void rule__Variable__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1333:1: ( ( ( rule__Variable__TypeAssignment_0 ) ) )
            // InternalFirstOrderLogic.g:1334:1: ( ( rule__Variable__TypeAssignment_0 ) )
            {
            // InternalFirstOrderLogic.g:1334:1: ( ( rule__Variable__TypeAssignment_0 ) )
            // InternalFirstOrderLogic.g:1335:2: ( rule__Variable__TypeAssignment_0 )
            {
             before(grammarAccess.getVariableAccess().getTypeAssignment_0()); 
            // InternalFirstOrderLogic.g:1336:2: ( rule__Variable__TypeAssignment_0 )
            // InternalFirstOrderLogic.g:1336:3: rule__Variable__TypeAssignment_0
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
    // InternalFirstOrderLogic.g:1344:1: rule__Variable__Group__1 : rule__Variable__Group__1__Impl ;
    public final void rule__Variable__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1348:1: ( rule__Variable__Group__1__Impl )
            // InternalFirstOrderLogic.g:1349:2: rule__Variable__Group__1__Impl
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
    // InternalFirstOrderLogic.g:1355:1: rule__Variable__Group__1__Impl : ( ( rule__Variable__NameAssignment_1 ) ) ;
    public final void rule__Variable__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1359:1: ( ( ( rule__Variable__NameAssignment_1 ) ) )
            // InternalFirstOrderLogic.g:1360:1: ( ( rule__Variable__NameAssignment_1 ) )
            {
            // InternalFirstOrderLogic.g:1360:1: ( ( rule__Variable__NameAssignment_1 ) )
            // InternalFirstOrderLogic.g:1361:2: ( rule__Variable__NameAssignment_1 )
            {
             before(grammarAccess.getVariableAccess().getNameAssignment_1()); 
            // InternalFirstOrderLogic.g:1362:2: ( rule__Variable__NameAssignment_1 )
            // InternalFirstOrderLogic.g:1362:3: rule__Variable__NameAssignment_1
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
    // InternalFirstOrderLogic.g:1371:1: rule__Iff__Group__0 : rule__Iff__Group__0__Impl rule__Iff__Group__1 ;
    public final void rule__Iff__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1375:1: ( rule__Iff__Group__0__Impl rule__Iff__Group__1 )
            // InternalFirstOrderLogic.g:1376:2: rule__Iff__Group__0__Impl rule__Iff__Group__1
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
    // InternalFirstOrderLogic.g:1383:1: rule__Iff__Group__0__Impl : ( ruleBinaryFormula ) ;
    public final void rule__Iff__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1387:1: ( ( ruleBinaryFormula ) )
            // InternalFirstOrderLogic.g:1388:1: ( ruleBinaryFormula )
            {
            // InternalFirstOrderLogic.g:1388:1: ( ruleBinaryFormula )
            // InternalFirstOrderLogic.g:1389:2: ruleBinaryFormula
            {
             before(grammarAccess.getIffAccess().getBinaryFormulaParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleBinaryFormula();

            state._fsp--;

             after(grammarAccess.getIffAccess().getBinaryFormulaParserRuleCall_0()); 

            }


            }

        }
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
    // InternalFirstOrderLogic.g:1398:1: rule__Iff__Group__1 : rule__Iff__Group__1__Impl ;
    public final void rule__Iff__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1402:1: ( rule__Iff__Group__1__Impl )
            // InternalFirstOrderLogic.g:1403:2: rule__Iff__Group__1__Impl
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
    // InternalFirstOrderLogic.g:1409:1: rule__Iff__Group__1__Impl : ( ( rule__Iff__Group_1__0 )* ) ;
    public final void rule__Iff__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1413:1: ( ( ( rule__Iff__Group_1__0 )* ) )
            // InternalFirstOrderLogic.g:1414:1: ( ( rule__Iff__Group_1__0 )* )
            {
            // InternalFirstOrderLogic.g:1414:1: ( ( rule__Iff__Group_1__0 )* )
            // InternalFirstOrderLogic.g:1415:2: ( rule__Iff__Group_1__0 )*
            {
             before(grammarAccess.getIffAccess().getGroup_1()); 
            // InternalFirstOrderLogic.g:1416:2: ( rule__Iff__Group_1__0 )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==19) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalFirstOrderLogic.g:1416:3: rule__Iff__Group_1__0
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
    // InternalFirstOrderLogic.g:1425:1: rule__Iff__Group_1__0 : rule__Iff__Group_1__0__Impl rule__Iff__Group_1__1 ;
    public final void rule__Iff__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1429:1: ( rule__Iff__Group_1__0__Impl rule__Iff__Group_1__1 )
            // InternalFirstOrderLogic.g:1430:2: rule__Iff__Group_1__0__Impl rule__Iff__Group_1__1
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
    // InternalFirstOrderLogic.g:1437:1: rule__Iff__Group_1__0__Impl : ( () ) ;
    public final void rule__Iff__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1441:1: ( ( () ) )
            // InternalFirstOrderLogic.g:1442:1: ( () )
            {
            // InternalFirstOrderLogic.g:1442:1: ( () )
            // InternalFirstOrderLogic.g:1443:2: ()
            {
             before(grammarAccess.getIffAccess().getIffLeftAction_1_0()); 
            // InternalFirstOrderLogic.g:1444:2: ()
            // InternalFirstOrderLogic.g:1444:3: 
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
    // InternalFirstOrderLogic.g:1452:1: rule__Iff__Group_1__1 : rule__Iff__Group_1__1__Impl rule__Iff__Group_1__2 ;
    public final void rule__Iff__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1456:1: ( rule__Iff__Group_1__1__Impl rule__Iff__Group_1__2 )
            // InternalFirstOrderLogic.g:1457:2: rule__Iff__Group_1__1__Impl rule__Iff__Group_1__2
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
    // InternalFirstOrderLogic.g:1464:1: rule__Iff__Group_1__1__Impl : ( '=' ) ;
    public final void rule__Iff__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1468:1: ( ( '=' ) )
            // InternalFirstOrderLogic.g:1469:1: ( '=' )
            {
            // InternalFirstOrderLogic.g:1469:1: ( '=' )
            // InternalFirstOrderLogic.g:1470:2: '='
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
    // InternalFirstOrderLogic.g:1479:1: rule__Iff__Group_1__2 : rule__Iff__Group_1__2__Impl ;
    public final void rule__Iff__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1483:1: ( rule__Iff__Group_1__2__Impl )
            // InternalFirstOrderLogic.g:1484:2: rule__Iff__Group_1__2__Impl
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
    // InternalFirstOrderLogic.g:1490:1: rule__Iff__Group_1__2__Impl : ( ( rule__Iff__RightAssignment_1_2 ) ) ;
    public final void rule__Iff__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1494:1: ( ( ( rule__Iff__RightAssignment_1_2 ) ) )
            // InternalFirstOrderLogic.g:1495:1: ( ( rule__Iff__RightAssignment_1_2 ) )
            {
            // InternalFirstOrderLogic.g:1495:1: ( ( rule__Iff__RightAssignment_1_2 ) )
            // InternalFirstOrderLogic.g:1496:2: ( rule__Iff__RightAssignment_1_2 )
            {
             before(grammarAccess.getIffAccess().getRightAssignment_1_2()); 
            // InternalFirstOrderLogic.g:1497:2: ( rule__Iff__RightAssignment_1_2 )
            // InternalFirstOrderLogic.g:1497:3: rule__Iff__RightAssignment_1_2
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
    // InternalFirstOrderLogic.g:1506:1: rule__If__Group__0 : rule__If__Group__0__Impl rule__If__Group__1 ;
    public final void rule__If__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1510:1: ( rule__If__Group__0__Impl rule__If__Group__1 )
            // InternalFirstOrderLogic.g:1511:2: rule__If__Group__0__Impl rule__If__Group__1
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
    // InternalFirstOrderLogic.g:1518:1: rule__If__Group__0__Impl : ( ruleXor ) ;
    public final void rule__If__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1522:1: ( ( ruleXor ) )
            // InternalFirstOrderLogic.g:1523:1: ( ruleXor )
            {
            // InternalFirstOrderLogic.g:1523:1: ( ruleXor )
            // InternalFirstOrderLogic.g:1524:2: ruleXor
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
    // InternalFirstOrderLogic.g:1533:1: rule__If__Group__1 : rule__If__Group__1__Impl ;
    public final void rule__If__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1537:1: ( rule__If__Group__1__Impl )
            // InternalFirstOrderLogic.g:1538:2: rule__If__Group__1__Impl
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
    // InternalFirstOrderLogic.g:1544:1: rule__If__Group__1__Impl : ( ( rule__If__Group_1__0 )* ) ;
    public final void rule__If__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1548:1: ( ( ( rule__If__Group_1__0 )* ) )
            // InternalFirstOrderLogic.g:1549:1: ( ( rule__If__Group_1__0 )* )
            {
            // InternalFirstOrderLogic.g:1549:1: ( ( rule__If__Group_1__0 )* )
            // InternalFirstOrderLogic.g:1550:2: ( rule__If__Group_1__0 )*
            {
             before(grammarAccess.getIfAccess().getGroup_1()); 
            // InternalFirstOrderLogic.g:1551:2: ( rule__If__Group_1__0 )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==20) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalFirstOrderLogic.g:1551:3: rule__If__Group_1__0
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
    // InternalFirstOrderLogic.g:1560:1: rule__If__Group_1__0 : rule__If__Group_1__0__Impl rule__If__Group_1__1 ;
    public final void rule__If__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1564:1: ( rule__If__Group_1__0__Impl rule__If__Group_1__1 )
            // InternalFirstOrderLogic.g:1565:2: rule__If__Group_1__0__Impl rule__If__Group_1__1
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
    // InternalFirstOrderLogic.g:1572:1: rule__If__Group_1__0__Impl : ( () ) ;
    public final void rule__If__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1576:1: ( ( () ) )
            // InternalFirstOrderLogic.g:1577:1: ( () )
            {
            // InternalFirstOrderLogic.g:1577:1: ( () )
            // InternalFirstOrderLogic.g:1578:2: ()
            {
             before(grammarAccess.getIfAccess().getIfLeftAction_1_0()); 
            // InternalFirstOrderLogic.g:1579:2: ()
            // InternalFirstOrderLogic.g:1579:3: 
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
    // InternalFirstOrderLogic.g:1587:1: rule__If__Group_1__1 : rule__If__Group_1__1__Impl rule__If__Group_1__2 ;
    public final void rule__If__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1591:1: ( rule__If__Group_1__1__Impl rule__If__Group_1__2 )
            // InternalFirstOrderLogic.g:1592:2: rule__If__Group_1__1__Impl rule__If__Group_1__2
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
    // InternalFirstOrderLogic.g:1599:1: rule__If__Group_1__1__Impl : ( 'implies' ) ;
    public final void rule__If__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1603:1: ( ( 'implies' ) )
            // InternalFirstOrderLogic.g:1604:1: ( 'implies' )
            {
            // InternalFirstOrderLogic.g:1604:1: ( 'implies' )
            // InternalFirstOrderLogic.g:1605:2: 'implies'
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
    // InternalFirstOrderLogic.g:1614:1: rule__If__Group_1__2 : rule__If__Group_1__2__Impl ;
    public final void rule__If__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1618:1: ( rule__If__Group_1__2__Impl )
            // InternalFirstOrderLogic.g:1619:2: rule__If__Group_1__2__Impl
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
    // InternalFirstOrderLogic.g:1625:1: rule__If__Group_1__2__Impl : ( ( rule__If__RightAssignment_1_2 ) ) ;
    public final void rule__If__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1629:1: ( ( ( rule__If__RightAssignment_1_2 ) ) )
            // InternalFirstOrderLogic.g:1630:1: ( ( rule__If__RightAssignment_1_2 ) )
            {
            // InternalFirstOrderLogic.g:1630:1: ( ( rule__If__RightAssignment_1_2 ) )
            // InternalFirstOrderLogic.g:1631:2: ( rule__If__RightAssignment_1_2 )
            {
             before(grammarAccess.getIfAccess().getRightAssignment_1_2()); 
            // InternalFirstOrderLogic.g:1632:2: ( rule__If__RightAssignment_1_2 )
            // InternalFirstOrderLogic.g:1632:3: rule__If__RightAssignment_1_2
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
    // InternalFirstOrderLogic.g:1641:1: rule__Xor__Group__0 : rule__Xor__Group__0__Impl rule__Xor__Group__1 ;
    public final void rule__Xor__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1645:1: ( rule__Xor__Group__0__Impl rule__Xor__Group__1 )
            // InternalFirstOrderLogic.g:1646:2: rule__Xor__Group__0__Impl rule__Xor__Group__1
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
    // InternalFirstOrderLogic.g:1653:1: rule__Xor__Group__0__Impl : ( ruleOr ) ;
    public final void rule__Xor__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1657:1: ( ( ruleOr ) )
            // InternalFirstOrderLogic.g:1658:1: ( ruleOr )
            {
            // InternalFirstOrderLogic.g:1658:1: ( ruleOr )
            // InternalFirstOrderLogic.g:1659:2: ruleOr
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
    // InternalFirstOrderLogic.g:1668:1: rule__Xor__Group__1 : rule__Xor__Group__1__Impl ;
    public final void rule__Xor__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1672:1: ( rule__Xor__Group__1__Impl )
            // InternalFirstOrderLogic.g:1673:2: rule__Xor__Group__1__Impl
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
    // InternalFirstOrderLogic.g:1679:1: rule__Xor__Group__1__Impl : ( ( rule__Xor__Group_1__0 )* ) ;
    public final void rule__Xor__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1683:1: ( ( ( rule__Xor__Group_1__0 )* ) )
            // InternalFirstOrderLogic.g:1684:1: ( ( rule__Xor__Group_1__0 )* )
            {
            // InternalFirstOrderLogic.g:1684:1: ( ( rule__Xor__Group_1__0 )* )
            // InternalFirstOrderLogic.g:1685:2: ( rule__Xor__Group_1__0 )*
            {
             before(grammarAccess.getXorAccess().getGroup_1()); 
            // InternalFirstOrderLogic.g:1686:2: ( rule__Xor__Group_1__0 )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==21) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalFirstOrderLogic.g:1686:3: rule__Xor__Group_1__0
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
    // InternalFirstOrderLogic.g:1695:1: rule__Xor__Group_1__0 : rule__Xor__Group_1__0__Impl rule__Xor__Group_1__1 ;
    public final void rule__Xor__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1699:1: ( rule__Xor__Group_1__0__Impl rule__Xor__Group_1__1 )
            // InternalFirstOrderLogic.g:1700:2: rule__Xor__Group_1__0__Impl rule__Xor__Group_1__1
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
    // InternalFirstOrderLogic.g:1707:1: rule__Xor__Group_1__0__Impl : ( () ) ;
    public final void rule__Xor__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1711:1: ( ( () ) )
            // InternalFirstOrderLogic.g:1712:1: ( () )
            {
            // InternalFirstOrderLogic.g:1712:1: ( () )
            // InternalFirstOrderLogic.g:1713:2: ()
            {
             before(grammarAccess.getXorAccess().getXorLeftAction_1_0()); 
            // InternalFirstOrderLogic.g:1714:2: ()
            // InternalFirstOrderLogic.g:1714:3: 
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
    // InternalFirstOrderLogic.g:1722:1: rule__Xor__Group_1__1 : rule__Xor__Group_1__1__Impl rule__Xor__Group_1__2 ;
    public final void rule__Xor__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1726:1: ( rule__Xor__Group_1__1__Impl rule__Xor__Group_1__2 )
            // InternalFirstOrderLogic.g:1727:2: rule__Xor__Group_1__1__Impl rule__Xor__Group_1__2
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
    // InternalFirstOrderLogic.g:1734:1: rule__Xor__Group_1__1__Impl : ( 'xor' ) ;
    public final void rule__Xor__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1738:1: ( ( 'xor' ) )
            // InternalFirstOrderLogic.g:1739:1: ( 'xor' )
            {
            // InternalFirstOrderLogic.g:1739:1: ( 'xor' )
            // InternalFirstOrderLogic.g:1740:2: 'xor'
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
    // InternalFirstOrderLogic.g:1749:1: rule__Xor__Group_1__2 : rule__Xor__Group_1__2__Impl ;
    public final void rule__Xor__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1753:1: ( rule__Xor__Group_1__2__Impl )
            // InternalFirstOrderLogic.g:1754:2: rule__Xor__Group_1__2__Impl
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
    // InternalFirstOrderLogic.g:1760:1: rule__Xor__Group_1__2__Impl : ( ( rule__Xor__RightAssignment_1_2 ) ) ;
    public final void rule__Xor__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1764:1: ( ( ( rule__Xor__RightAssignment_1_2 ) ) )
            // InternalFirstOrderLogic.g:1765:1: ( ( rule__Xor__RightAssignment_1_2 ) )
            {
            // InternalFirstOrderLogic.g:1765:1: ( ( rule__Xor__RightAssignment_1_2 ) )
            // InternalFirstOrderLogic.g:1766:2: ( rule__Xor__RightAssignment_1_2 )
            {
             before(grammarAccess.getXorAccess().getRightAssignment_1_2()); 
            // InternalFirstOrderLogic.g:1767:2: ( rule__Xor__RightAssignment_1_2 )
            // InternalFirstOrderLogic.g:1767:3: rule__Xor__RightAssignment_1_2
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
    // InternalFirstOrderLogic.g:1776:1: rule__Or__Group__0 : rule__Or__Group__0__Impl rule__Or__Group__1 ;
    public final void rule__Or__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1780:1: ( rule__Or__Group__0__Impl rule__Or__Group__1 )
            // InternalFirstOrderLogic.g:1781:2: rule__Or__Group__0__Impl rule__Or__Group__1
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
    // InternalFirstOrderLogic.g:1788:1: rule__Or__Group__0__Impl : ( ruleAnd ) ;
    public final void rule__Or__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1792:1: ( ( ruleAnd ) )
            // InternalFirstOrderLogic.g:1793:1: ( ruleAnd )
            {
            // InternalFirstOrderLogic.g:1793:1: ( ruleAnd )
            // InternalFirstOrderLogic.g:1794:2: ruleAnd
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
    // InternalFirstOrderLogic.g:1803:1: rule__Or__Group__1 : rule__Or__Group__1__Impl ;
    public final void rule__Or__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1807:1: ( rule__Or__Group__1__Impl )
            // InternalFirstOrderLogic.g:1808:2: rule__Or__Group__1__Impl
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
    // InternalFirstOrderLogic.g:1814:1: rule__Or__Group__1__Impl : ( ( rule__Or__Group_1__0 )* ) ;
    public final void rule__Or__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1818:1: ( ( ( rule__Or__Group_1__0 )* ) )
            // InternalFirstOrderLogic.g:1819:1: ( ( rule__Or__Group_1__0 )* )
            {
            // InternalFirstOrderLogic.g:1819:1: ( ( rule__Or__Group_1__0 )* )
            // InternalFirstOrderLogic.g:1820:2: ( rule__Or__Group_1__0 )*
            {
             before(grammarAccess.getOrAccess().getGroup_1()); 
            // InternalFirstOrderLogic.g:1821:2: ( rule__Or__Group_1__0 )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==22) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalFirstOrderLogic.g:1821:3: rule__Or__Group_1__0
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
    // InternalFirstOrderLogic.g:1830:1: rule__Or__Group_1__0 : rule__Or__Group_1__0__Impl rule__Or__Group_1__1 ;
    public final void rule__Or__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1834:1: ( rule__Or__Group_1__0__Impl rule__Or__Group_1__1 )
            // InternalFirstOrderLogic.g:1835:2: rule__Or__Group_1__0__Impl rule__Or__Group_1__1
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
    // InternalFirstOrderLogic.g:1842:1: rule__Or__Group_1__0__Impl : ( () ) ;
    public final void rule__Or__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1846:1: ( ( () ) )
            // InternalFirstOrderLogic.g:1847:1: ( () )
            {
            // InternalFirstOrderLogic.g:1847:1: ( () )
            // InternalFirstOrderLogic.g:1848:2: ()
            {
             before(grammarAccess.getOrAccess().getOrLeftAction_1_0()); 
            // InternalFirstOrderLogic.g:1849:2: ()
            // InternalFirstOrderLogic.g:1849:3: 
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
    // InternalFirstOrderLogic.g:1857:1: rule__Or__Group_1__1 : rule__Or__Group_1__1__Impl rule__Or__Group_1__2 ;
    public final void rule__Or__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1861:1: ( rule__Or__Group_1__1__Impl rule__Or__Group_1__2 )
            // InternalFirstOrderLogic.g:1862:2: rule__Or__Group_1__1__Impl rule__Or__Group_1__2
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
    // InternalFirstOrderLogic.g:1869:1: rule__Or__Group_1__1__Impl : ( 'or' ) ;
    public final void rule__Or__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1873:1: ( ( 'or' ) )
            // InternalFirstOrderLogic.g:1874:1: ( 'or' )
            {
            // InternalFirstOrderLogic.g:1874:1: ( 'or' )
            // InternalFirstOrderLogic.g:1875:2: 'or'
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
    // InternalFirstOrderLogic.g:1884:1: rule__Or__Group_1__2 : rule__Or__Group_1__2__Impl ;
    public final void rule__Or__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1888:1: ( rule__Or__Group_1__2__Impl )
            // InternalFirstOrderLogic.g:1889:2: rule__Or__Group_1__2__Impl
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
    // InternalFirstOrderLogic.g:1895:1: rule__Or__Group_1__2__Impl : ( ( rule__Or__RightAssignment_1_2 ) ) ;
    public final void rule__Or__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1899:1: ( ( ( rule__Or__RightAssignment_1_2 ) ) )
            // InternalFirstOrderLogic.g:1900:1: ( ( rule__Or__RightAssignment_1_2 ) )
            {
            // InternalFirstOrderLogic.g:1900:1: ( ( rule__Or__RightAssignment_1_2 ) )
            // InternalFirstOrderLogic.g:1901:2: ( rule__Or__RightAssignment_1_2 )
            {
             before(grammarAccess.getOrAccess().getRightAssignment_1_2()); 
            // InternalFirstOrderLogic.g:1902:2: ( rule__Or__RightAssignment_1_2 )
            // InternalFirstOrderLogic.g:1902:3: rule__Or__RightAssignment_1_2
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
    // InternalFirstOrderLogic.g:1911:1: rule__And__Group__0 : rule__And__Group__0__Impl rule__And__Group__1 ;
    public final void rule__And__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1915:1: ( rule__And__Group__0__Impl rule__And__Group__1 )
            // InternalFirstOrderLogic.g:1916:2: rule__And__Group__0__Impl rule__And__Group__1
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
    // InternalFirstOrderLogic.g:1923:1: rule__And__Group__0__Impl : ( ruleBooleanExpression ) ;
    public final void rule__And__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1927:1: ( ( ruleBooleanExpression ) )
            // InternalFirstOrderLogic.g:1928:1: ( ruleBooleanExpression )
            {
            // InternalFirstOrderLogic.g:1928:1: ( ruleBooleanExpression )
            // InternalFirstOrderLogic.g:1929:2: ruleBooleanExpression
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
    // InternalFirstOrderLogic.g:1938:1: rule__And__Group__1 : rule__And__Group__1__Impl ;
    public final void rule__And__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1942:1: ( rule__And__Group__1__Impl )
            // InternalFirstOrderLogic.g:1943:2: rule__And__Group__1__Impl
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
    // InternalFirstOrderLogic.g:1949:1: rule__And__Group__1__Impl : ( ( rule__And__Group_1__0 )* ) ;
    public final void rule__And__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1953:1: ( ( ( rule__And__Group_1__0 )* ) )
            // InternalFirstOrderLogic.g:1954:1: ( ( rule__And__Group_1__0 )* )
            {
            // InternalFirstOrderLogic.g:1954:1: ( ( rule__And__Group_1__0 )* )
            // InternalFirstOrderLogic.g:1955:2: ( rule__And__Group_1__0 )*
            {
             before(grammarAccess.getAndAccess().getGroup_1()); 
            // InternalFirstOrderLogic.g:1956:2: ( rule__And__Group_1__0 )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==23) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalFirstOrderLogic.g:1956:3: rule__And__Group_1__0
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
    // InternalFirstOrderLogic.g:1965:1: rule__And__Group_1__0 : rule__And__Group_1__0__Impl rule__And__Group_1__1 ;
    public final void rule__And__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1969:1: ( rule__And__Group_1__0__Impl rule__And__Group_1__1 )
            // InternalFirstOrderLogic.g:1970:2: rule__And__Group_1__0__Impl rule__And__Group_1__1
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
    // InternalFirstOrderLogic.g:1977:1: rule__And__Group_1__0__Impl : ( () ) ;
    public final void rule__And__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1981:1: ( ( () ) )
            // InternalFirstOrderLogic.g:1982:1: ( () )
            {
            // InternalFirstOrderLogic.g:1982:1: ( () )
            // InternalFirstOrderLogic.g:1983:2: ()
            {
             before(grammarAccess.getAndAccess().getAndLeftAction_1_0()); 
            // InternalFirstOrderLogic.g:1984:2: ()
            // InternalFirstOrderLogic.g:1984:3: 
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
    // InternalFirstOrderLogic.g:1992:1: rule__And__Group_1__1 : rule__And__Group_1__1__Impl rule__And__Group_1__2 ;
    public final void rule__And__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1996:1: ( rule__And__Group_1__1__Impl rule__And__Group_1__2 )
            // InternalFirstOrderLogic.g:1997:2: rule__And__Group_1__1__Impl rule__And__Group_1__2
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
    // InternalFirstOrderLogic.g:2004:1: rule__And__Group_1__1__Impl : ( 'and' ) ;
    public final void rule__And__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2008:1: ( ( 'and' ) )
            // InternalFirstOrderLogic.g:2009:1: ( 'and' )
            {
            // InternalFirstOrderLogic.g:2009:1: ( 'and' )
            // InternalFirstOrderLogic.g:2010:2: 'and'
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
    // InternalFirstOrderLogic.g:2019:1: rule__And__Group_1__2 : rule__And__Group_1__2__Impl ;
    public final void rule__And__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2023:1: ( rule__And__Group_1__2__Impl )
            // InternalFirstOrderLogic.g:2024:2: rule__And__Group_1__2__Impl
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
    // InternalFirstOrderLogic.g:2030:1: rule__And__Group_1__2__Impl : ( ( rule__And__RightAssignment_1_2 ) ) ;
    public final void rule__And__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2034:1: ( ( ( rule__And__RightAssignment_1_2 ) ) )
            // InternalFirstOrderLogic.g:2035:1: ( ( rule__And__RightAssignment_1_2 ) )
            {
            // InternalFirstOrderLogic.g:2035:1: ( ( rule__And__RightAssignment_1_2 ) )
            // InternalFirstOrderLogic.g:2036:2: ( rule__And__RightAssignment_1_2 )
            {
             before(grammarAccess.getAndAccess().getRightAssignment_1_2()); 
            // InternalFirstOrderLogic.g:2037:2: ( rule__And__RightAssignment_1_2 )
            // InternalFirstOrderLogic.g:2037:3: rule__And__RightAssignment_1_2
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
    // InternalFirstOrderLogic.g:2046:1: rule__Not__Group__0 : rule__Not__Group__0__Impl rule__Not__Group__1 ;
    public final void rule__Not__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2050:1: ( rule__Not__Group__0__Impl rule__Not__Group__1 )
            // InternalFirstOrderLogic.g:2051:2: rule__Not__Group__0__Impl rule__Not__Group__1
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
    // InternalFirstOrderLogic.g:2058:1: rule__Not__Group__0__Impl : ( () ) ;
    public final void rule__Not__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2062:1: ( ( () ) )
            // InternalFirstOrderLogic.g:2063:1: ( () )
            {
            // InternalFirstOrderLogic.g:2063:1: ( () )
            // InternalFirstOrderLogic.g:2064:2: ()
            {
             before(grammarAccess.getNotAccess().getNotAction_0()); 
            // InternalFirstOrderLogic.g:2065:2: ()
            // InternalFirstOrderLogic.g:2065:3: 
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
    // InternalFirstOrderLogic.g:2073:1: rule__Not__Group__1 : rule__Not__Group__1__Impl rule__Not__Group__2 ;
    public final void rule__Not__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2077:1: ( rule__Not__Group__1__Impl rule__Not__Group__2 )
            // InternalFirstOrderLogic.g:2078:2: rule__Not__Group__1__Impl rule__Not__Group__2
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
    // InternalFirstOrderLogic.g:2085:1: rule__Not__Group__1__Impl : ( 'not(' ) ;
    public final void rule__Not__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2089:1: ( ( 'not(' ) )
            // InternalFirstOrderLogic.g:2090:1: ( 'not(' )
            {
            // InternalFirstOrderLogic.g:2090:1: ( 'not(' )
            // InternalFirstOrderLogic.g:2091:2: 'not('
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
    // InternalFirstOrderLogic.g:2100:1: rule__Not__Group__2 : rule__Not__Group__2__Impl rule__Not__Group__3 ;
    public final void rule__Not__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2104:1: ( rule__Not__Group__2__Impl rule__Not__Group__3 )
            // InternalFirstOrderLogic.g:2105:2: rule__Not__Group__2__Impl rule__Not__Group__3
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
    // InternalFirstOrderLogic.g:2112:1: rule__Not__Group__2__Impl : ( ( rule__Not__NotAssignment_2 ) ) ;
    public final void rule__Not__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2116:1: ( ( ( rule__Not__NotAssignment_2 ) ) )
            // InternalFirstOrderLogic.g:2117:1: ( ( rule__Not__NotAssignment_2 ) )
            {
            // InternalFirstOrderLogic.g:2117:1: ( ( rule__Not__NotAssignment_2 ) )
            // InternalFirstOrderLogic.g:2118:2: ( rule__Not__NotAssignment_2 )
            {
             before(grammarAccess.getNotAccess().getNotAssignment_2()); 
            // InternalFirstOrderLogic.g:2119:2: ( rule__Not__NotAssignment_2 )
            // InternalFirstOrderLogic.g:2119:3: rule__Not__NotAssignment_2
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
    // InternalFirstOrderLogic.g:2127:1: rule__Not__Group__3 : rule__Not__Group__3__Impl ;
    public final void rule__Not__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2131:1: ( rule__Not__Group__3__Impl )
            // InternalFirstOrderLogic.g:2132:2: rule__Not__Group__3__Impl
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
    // InternalFirstOrderLogic.g:2138:1: rule__Not__Group__3__Impl : ( ')' ) ;
    public final void rule__Not__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2142:1: ( ( ')' ) )
            // InternalFirstOrderLogic.g:2143:1: ( ')' )
            {
            // InternalFirstOrderLogic.g:2143:1: ( ')' )
            // InternalFirstOrderLogic.g:2144:2: ')'
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
    // InternalFirstOrderLogic.g:2154:1: rule__Equals__Group__0 : rule__Equals__Group__0__Impl rule__Equals__Group__1 ;
    public final void rule__Equals__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2158:1: ( rule__Equals__Group__0__Impl rule__Equals__Group__1 )
            // InternalFirstOrderLogic.g:2159:2: rule__Equals__Group__0__Impl rule__Equals__Group__1
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
    // InternalFirstOrderLogic.g:2166:1: rule__Equals__Group__0__Impl : ( 'equals(' ) ;
    public final void rule__Equals__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2170:1: ( ( 'equals(' ) )
            // InternalFirstOrderLogic.g:2171:1: ( 'equals(' )
            {
            // InternalFirstOrderLogic.g:2171:1: ( 'equals(' )
            // InternalFirstOrderLogic.g:2172:2: 'equals('
            {
             before(grammarAccess.getEqualsAccess().getEqualsKeyword_0()); 
            match(input,26,FOLLOW_2); 
             after(grammarAccess.getEqualsAccess().getEqualsKeyword_0()); 

            }


            }

        }
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
    // InternalFirstOrderLogic.g:2181:1: rule__Equals__Group__1 : rule__Equals__Group__1__Impl rule__Equals__Group__2 ;
    public final void rule__Equals__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2185:1: ( rule__Equals__Group__1__Impl rule__Equals__Group__2 )
            // InternalFirstOrderLogic.g:2186:2: rule__Equals__Group__1__Impl rule__Equals__Group__2
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
    // InternalFirstOrderLogic.g:2193:1: rule__Equals__Group__1__Impl : ( ( rule__Equals__LeftAssignment_1 ) ) ;
    public final void rule__Equals__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2197:1: ( ( ( rule__Equals__LeftAssignment_1 ) ) )
            // InternalFirstOrderLogic.g:2198:1: ( ( rule__Equals__LeftAssignment_1 ) )
            {
            // InternalFirstOrderLogic.g:2198:1: ( ( rule__Equals__LeftAssignment_1 ) )
            // InternalFirstOrderLogic.g:2199:2: ( rule__Equals__LeftAssignment_1 )
            {
             before(grammarAccess.getEqualsAccess().getLeftAssignment_1()); 
            // InternalFirstOrderLogic.g:2200:2: ( rule__Equals__LeftAssignment_1 )
            // InternalFirstOrderLogic.g:2200:3: rule__Equals__LeftAssignment_1
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
    // InternalFirstOrderLogic.g:2208:1: rule__Equals__Group__2 : rule__Equals__Group__2__Impl rule__Equals__Group__3 ;
    public final void rule__Equals__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2212:1: ( rule__Equals__Group__2__Impl rule__Equals__Group__3 )
            // InternalFirstOrderLogic.g:2213:2: rule__Equals__Group__2__Impl rule__Equals__Group__3
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
    // InternalFirstOrderLogic.g:2220:1: rule__Equals__Group__2__Impl : ( ',' ) ;
    public final void rule__Equals__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2224:1: ( ( ',' ) )
            // InternalFirstOrderLogic.g:2225:1: ( ',' )
            {
            // InternalFirstOrderLogic.g:2225:1: ( ',' )
            // InternalFirstOrderLogic.g:2226:2: ','
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
    // InternalFirstOrderLogic.g:2235:1: rule__Equals__Group__3 : rule__Equals__Group__3__Impl rule__Equals__Group__4 ;
    public final void rule__Equals__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2239:1: ( rule__Equals__Group__3__Impl rule__Equals__Group__4 )
            // InternalFirstOrderLogic.g:2240:2: rule__Equals__Group__3__Impl rule__Equals__Group__4
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
    // InternalFirstOrderLogic.g:2247:1: rule__Equals__Group__3__Impl : ( ( rule__Equals__RightAssignment_3 ) ) ;
    public final void rule__Equals__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2251:1: ( ( ( rule__Equals__RightAssignment_3 ) ) )
            // InternalFirstOrderLogic.g:2252:1: ( ( rule__Equals__RightAssignment_3 ) )
            {
            // InternalFirstOrderLogic.g:2252:1: ( ( rule__Equals__RightAssignment_3 ) )
            // InternalFirstOrderLogic.g:2253:2: ( rule__Equals__RightAssignment_3 )
            {
             before(grammarAccess.getEqualsAccess().getRightAssignment_3()); 
            // InternalFirstOrderLogic.g:2254:2: ( rule__Equals__RightAssignment_3 )
            // InternalFirstOrderLogic.g:2254:3: rule__Equals__RightAssignment_3
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
    // InternalFirstOrderLogic.g:2262:1: rule__Equals__Group__4 : rule__Equals__Group__4__Impl ;
    public final void rule__Equals__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2266:1: ( rule__Equals__Group__4__Impl )
            // InternalFirstOrderLogic.g:2267:2: rule__Equals__Group__4__Impl
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
    // InternalFirstOrderLogic.g:2273:1: rule__Equals__Group__4__Impl : ( ')' ) ;
    public final void rule__Equals__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2277:1: ( ( ')' ) )
            // InternalFirstOrderLogic.g:2278:1: ( ')' )
            {
            // InternalFirstOrderLogic.g:2278:1: ( ')' )
            // InternalFirstOrderLogic.g:2279:2: ')'
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
    // InternalFirstOrderLogic.g:2289:1: rule__Greater__Group__0 : rule__Greater__Group__0__Impl rule__Greater__Group__1 ;
    public final void rule__Greater__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2293:1: ( rule__Greater__Group__0__Impl rule__Greater__Group__1 )
            // InternalFirstOrderLogic.g:2294:2: rule__Greater__Group__0__Impl rule__Greater__Group__1
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
    // InternalFirstOrderLogic.g:2301:1: rule__Greater__Group__0__Impl : ( 'isGreater(' ) ;
    public final void rule__Greater__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2305:1: ( ( 'isGreater(' ) )
            // InternalFirstOrderLogic.g:2306:1: ( 'isGreater(' )
            {
            // InternalFirstOrderLogic.g:2306:1: ( 'isGreater(' )
            // InternalFirstOrderLogic.g:2307:2: 'isGreater('
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
    // InternalFirstOrderLogic.g:2316:1: rule__Greater__Group__1 : rule__Greater__Group__1__Impl rule__Greater__Group__2 ;
    public final void rule__Greater__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2320:1: ( rule__Greater__Group__1__Impl rule__Greater__Group__2 )
            // InternalFirstOrderLogic.g:2321:2: rule__Greater__Group__1__Impl rule__Greater__Group__2
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
    // InternalFirstOrderLogic.g:2328:1: rule__Greater__Group__1__Impl : ( ( rule__Greater__LeftAssignment_1 ) ) ;
    public final void rule__Greater__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2332:1: ( ( ( rule__Greater__LeftAssignment_1 ) ) )
            // InternalFirstOrderLogic.g:2333:1: ( ( rule__Greater__LeftAssignment_1 ) )
            {
            // InternalFirstOrderLogic.g:2333:1: ( ( rule__Greater__LeftAssignment_1 ) )
            // InternalFirstOrderLogic.g:2334:2: ( rule__Greater__LeftAssignment_1 )
            {
             before(grammarAccess.getGreaterAccess().getLeftAssignment_1()); 
            // InternalFirstOrderLogic.g:2335:2: ( rule__Greater__LeftAssignment_1 )
            // InternalFirstOrderLogic.g:2335:3: rule__Greater__LeftAssignment_1
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
    // InternalFirstOrderLogic.g:2343:1: rule__Greater__Group__2 : rule__Greater__Group__2__Impl rule__Greater__Group__3 ;
    public final void rule__Greater__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2347:1: ( rule__Greater__Group__2__Impl rule__Greater__Group__3 )
            // InternalFirstOrderLogic.g:2348:2: rule__Greater__Group__2__Impl rule__Greater__Group__3
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
    // InternalFirstOrderLogic.g:2355:1: rule__Greater__Group__2__Impl : ( ',' ) ;
    public final void rule__Greater__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2359:1: ( ( ',' ) )
            // InternalFirstOrderLogic.g:2360:1: ( ',' )
            {
            // InternalFirstOrderLogic.g:2360:1: ( ',' )
            // InternalFirstOrderLogic.g:2361:2: ','
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
    // InternalFirstOrderLogic.g:2370:1: rule__Greater__Group__3 : rule__Greater__Group__3__Impl rule__Greater__Group__4 ;
    public final void rule__Greater__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2374:1: ( rule__Greater__Group__3__Impl rule__Greater__Group__4 )
            // InternalFirstOrderLogic.g:2375:2: rule__Greater__Group__3__Impl rule__Greater__Group__4
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
    // InternalFirstOrderLogic.g:2382:1: rule__Greater__Group__3__Impl : ( ( rule__Greater__RightAssignment_3 ) ) ;
    public final void rule__Greater__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2386:1: ( ( ( rule__Greater__RightAssignment_3 ) ) )
            // InternalFirstOrderLogic.g:2387:1: ( ( rule__Greater__RightAssignment_3 ) )
            {
            // InternalFirstOrderLogic.g:2387:1: ( ( rule__Greater__RightAssignment_3 ) )
            // InternalFirstOrderLogic.g:2388:2: ( rule__Greater__RightAssignment_3 )
            {
             before(grammarAccess.getGreaterAccess().getRightAssignment_3()); 
            // InternalFirstOrderLogic.g:2389:2: ( rule__Greater__RightAssignment_3 )
            // InternalFirstOrderLogic.g:2389:3: rule__Greater__RightAssignment_3
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
    // InternalFirstOrderLogic.g:2397:1: rule__Greater__Group__4 : rule__Greater__Group__4__Impl ;
    public final void rule__Greater__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2401:1: ( rule__Greater__Group__4__Impl )
            // InternalFirstOrderLogic.g:2402:2: rule__Greater__Group__4__Impl
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
    // InternalFirstOrderLogic.g:2408:1: rule__Greater__Group__4__Impl : ( ')' ) ;
    public final void rule__Greater__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2412:1: ( ( ')' ) )
            // InternalFirstOrderLogic.g:2413:1: ( ')' )
            {
            // InternalFirstOrderLogic.g:2413:1: ( ')' )
            // InternalFirstOrderLogic.g:2414:2: ')'
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
    // InternalFirstOrderLogic.g:2424:1: rule__GreaterEqual__Group__0 : rule__GreaterEqual__Group__0__Impl rule__GreaterEqual__Group__1 ;
    public final void rule__GreaterEqual__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2428:1: ( rule__GreaterEqual__Group__0__Impl rule__GreaterEqual__Group__1 )
            // InternalFirstOrderLogic.g:2429:2: rule__GreaterEqual__Group__0__Impl rule__GreaterEqual__Group__1
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
    // InternalFirstOrderLogic.g:2436:1: rule__GreaterEqual__Group__0__Impl : ( 'isGreaterEqual(' ) ;
    public final void rule__GreaterEqual__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2440:1: ( ( 'isGreaterEqual(' ) )
            // InternalFirstOrderLogic.g:2441:1: ( 'isGreaterEqual(' )
            {
            // InternalFirstOrderLogic.g:2441:1: ( 'isGreaterEqual(' )
            // InternalFirstOrderLogic.g:2442:2: 'isGreaterEqual('
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
    // InternalFirstOrderLogic.g:2451:1: rule__GreaterEqual__Group__1 : rule__GreaterEqual__Group__1__Impl rule__GreaterEqual__Group__2 ;
    public final void rule__GreaterEqual__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2455:1: ( rule__GreaterEqual__Group__1__Impl rule__GreaterEqual__Group__2 )
            // InternalFirstOrderLogic.g:2456:2: rule__GreaterEqual__Group__1__Impl rule__GreaterEqual__Group__2
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
    // InternalFirstOrderLogic.g:2463:1: rule__GreaterEqual__Group__1__Impl : ( ( rule__GreaterEqual__LeftAssignment_1 ) ) ;
    public final void rule__GreaterEqual__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2467:1: ( ( ( rule__GreaterEqual__LeftAssignment_1 ) ) )
            // InternalFirstOrderLogic.g:2468:1: ( ( rule__GreaterEqual__LeftAssignment_1 ) )
            {
            // InternalFirstOrderLogic.g:2468:1: ( ( rule__GreaterEqual__LeftAssignment_1 ) )
            // InternalFirstOrderLogic.g:2469:2: ( rule__GreaterEqual__LeftAssignment_1 )
            {
             before(grammarAccess.getGreaterEqualAccess().getLeftAssignment_1()); 
            // InternalFirstOrderLogic.g:2470:2: ( rule__GreaterEqual__LeftAssignment_1 )
            // InternalFirstOrderLogic.g:2470:3: rule__GreaterEqual__LeftAssignment_1
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
    // InternalFirstOrderLogic.g:2478:1: rule__GreaterEqual__Group__2 : rule__GreaterEqual__Group__2__Impl rule__GreaterEqual__Group__3 ;
    public final void rule__GreaterEqual__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2482:1: ( rule__GreaterEqual__Group__2__Impl rule__GreaterEqual__Group__3 )
            // InternalFirstOrderLogic.g:2483:2: rule__GreaterEqual__Group__2__Impl rule__GreaterEqual__Group__3
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
    // InternalFirstOrderLogic.g:2490:1: rule__GreaterEqual__Group__2__Impl : ( ',' ) ;
    public final void rule__GreaterEqual__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2494:1: ( ( ',' ) )
            // InternalFirstOrderLogic.g:2495:1: ( ',' )
            {
            // InternalFirstOrderLogic.g:2495:1: ( ',' )
            // InternalFirstOrderLogic.g:2496:2: ','
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
    // InternalFirstOrderLogic.g:2505:1: rule__GreaterEqual__Group__3 : rule__GreaterEqual__Group__3__Impl rule__GreaterEqual__Group__4 ;
    public final void rule__GreaterEqual__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2509:1: ( rule__GreaterEqual__Group__3__Impl rule__GreaterEqual__Group__4 )
            // InternalFirstOrderLogic.g:2510:2: rule__GreaterEqual__Group__3__Impl rule__GreaterEqual__Group__4
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
    // InternalFirstOrderLogic.g:2517:1: rule__GreaterEqual__Group__3__Impl : ( ( rule__GreaterEqual__RightAssignment_3 ) ) ;
    public final void rule__GreaterEqual__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2521:1: ( ( ( rule__GreaterEqual__RightAssignment_3 ) ) )
            // InternalFirstOrderLogic.g:2522:1: ( ( rule__GreaterEqual__RightAssignment_3 ) )
            {
            // InternalFirstOrderLogic.g:2522:1: ( ( rule__GreaterEqual__RightAssignment_3 ) )
            // InternalFirstOrderLogic.g:2523:2: ( rule__GreaterEqual__RightAssignment_3 )
            {
             before(grammarAccess.getGreaterEqualAccess().getRightAssignment_3()); 
            // InternalFirstOrderLogic.g:2524:2: ( rule__GreaterEqual__RightAssignment_3 )
            // InternalFirstOrderLogic.g:2524:3: rule__GreaterEqual__RightAssignment_3
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
    // InternalFirstOrderLogic.g:2532:1: rule__GreaterEqual__Group__4 : rule__GreaterEqual__Group__4__Impl ;
    public final void rule__GreaterEqual__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2536:1: ( rule__GreaterEqual__Group__4__Impl )
            // InternalFirstOrderLogic.g:2537:2: rule__GreaterEqual__Group__4__Impl
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
    // InternalFirstOrderLogic.g:2543:1: rule__GreaterEqual__Group__4__Impl : ( ')' ) ;
    public final void rule__GreaterEqual__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2547:1: ( ( ')' ) )
            // InternalFirstOrderLogic.g:2548:1: ( ')' )
            {
            // InternalFirstOrderLogic.g:2548:1: ( ')' )
            // InternalFirstOrderLogic.g:2549:2: ')'
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
    // InternalFirstOrderLogic.g:2559:1: rule__Smaller__Group__0 : rule__Smaller__Group__0__Impl rule__Smaller__Group__1 ;
    public final void rule__Smaller__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2563:1: ( rule__Smaller__Group__0__Impl rule__Smaller__Group__1 )
            // InternalFirstOrderLogic.g:2564:2: rule__Smaller__Group__0__Impl rule__Smaller__Group__1
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
    // InternalFirstOrderLogic.g:2571:1: rule__Smaller__Group__0__Impl : ( 'isSmaller(' ) ;
    public final void rule__Smaller__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2575:1: ( ( 'isSmaller(' ) )
            // InternalFirstOrderLogic.g:2576:1: ( 'isSmaller(' )
            {
            // InternalFirstOrderLogic.g:2576:1: ( 'isSmaller(' )
            // InternalFirstOrderLogic.g:2577:2: 'isSmaller('
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
    // InternalFirstOrderLogic.g:2586:1: rule__Smaller__Group__1 : rule__Smaller__Group__1__Impl rule__Smaller__Group__2 ;
    public final void rule__Smaller__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2590:1: ( rule__Smaller__Group__1__Impl rule__Smaller__Group__2 )
            // InternalFirstOrderLogic.g:2591:2: rule__Smaller__Group__1__Impl rule__Smaller__Group__2
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
    // InternalFirstOrderLogic.g:2598:1: rule__Smaller__Group__1__Impl : ( ( rule__Smaller__LeftAssignment_1 ) ) ;
    public final void rule__Smaller__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2602:1: ( ( ( rule__Smaller__LeftAssignment_1 ) ) )
            // InternalFirstOrderLogic.g:2603:1: ( ( rule__Smaller__LeftAssignment_1 ) )
            {
            // InternalFirstOrderLogic.g:2603:1: ( ( rule__Smaller__LeftAssignment_1 ) )
            // InternalFirstOrderLogic.g:2604:2: ( rule__Smaller__LeftAssignment_1 )
            {
             before(grammarAccess.getSmallerAccess().getLeftAssignment_1()); 
            // InternalFirstOrderLogic.g:2605:2: ( rule__Smaller__LeftAssignment_1 )
            // InternalFirstOrderLogic.g:2605:3: rule__Smaller__LeftAssignment_1
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
    // InternalFirstOrderLogic.g:2613:1: rule__Smaller__Group__2 : rule__Smaller__Group__2__Impl rule__Smaller__Group__3 ;
    public final void rule__Smaller__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2617:1: ( rule__Smaller__Group__2__Impl rule__Smaller__Group__3 )
            // InternalFirstOrderLogic.g:2618:2: rule__Smaller__Group__2__Impl rule__Smaller__Group__3
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
    // InternalFirstOrderLogic.g:2625:1: rule__Smaller__Group__2__Impl : ( ',' ) ;
    public final void rule__Smaller__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2629:1: ( ( ',' ) )
            // InternalFirstOrderLogic.g:2630:1: ( ',' )
            {
            // InternalFirstOrderLogic.g:2630:1: ( ',' )
            // InternalFirstOrderLogic.g:2631:2: ','
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
    // InternalFirstOrderLogic.g:2640:1: rule__Smaller__Group__3 : rule__Smaller__Group__3__Impl rule__Smaller__Group__4 ;
    public final void rule__Smaller__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2644:1: ( rule__Smaller__Group__3__Impl rule__Smaller__Group__4 )
            // InternalFirstOrderLogic.g:2645:2: rule__Smaller__Group__3__Impl rule__Smaller__Group__4
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
    // InternalFirstOrderLogic.g:2652:1: rule__Smaller__Group__3__Impl : ( ( rule__Smaller__RightAssignment_3 ) ) ;
    public final void rule__Smaller__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2656:1: ( ( ( rule__Smaller__RightAssignment_3 ) ) )
            // InternalFirstOrderLogic.g:2657:1: ( ( rule__Smaller__RightAssignment_3 ) )
            {
            // InternalFirstOrderLogic.g:2657:1: ( ( rule__Smaller__RightAssignment_3 ) )
            // InternalFirstOrderLogic.g:2658:2: ( rule__Smaller__RightAssignment_3 )
            {
             before(grammarAccess.getSmallerAccess().getRightAssignment_3()); 
            // InternalFirstOrderLogic.g:2659:2: ( rule__Smaller__RightAssignment_3 )
            // InternalFirstOrderLogic.g:2659:3: rule__Smaller__RightAssignment_3
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
    // InternalFirstOrderLogic.g:2667:1: rule__Smaller__Group__4 : rule__Smaller__Group__4__Impl ;
    public final void rule__Smaller__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2671:1: ( rule__Smaller__Group__4__Impl )
            // InternalFirstOrderLogic.g:2672:2: rule__Smaller__Group__4__Impl
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
    // InternalFirstOrderLogic.g:2678:1: rule__Smaller__Group__4__Impl : ( ')' ) ;
    public final void rule__Smaller__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2682:1: ( ( ')' ) )
            // InternalFirstOrderLogic.g:2683:1: ( ')' )
            {
            // InternalFirstOrderLogic.g:2683:1: ( ')' )
            // InternalFirstOrderLogic.g:2684:2: ')'
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
    // InternalFirstOrderLogic.g:2694:1: rule__SmallerEqual__Group__0 : rule__SmallerEqual__Group__0__Impl rule__SmallerEqual__Group__1 ;
    public final void rule__SmallerEqual__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2698:1: ( rule__SmallerEqual__Group__0__Impl rule__SmallerEqual__Group__1 )
            // InternalFirstOrderLogic.g:2699:2: rule__SmallerEqual__Group__0__Impl rule__SmallerEqual__Group__1
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
    // InternalFirstOrderLogic.g:2706:1: rule__SmallerEqual__Group__0__Impl : ( 'isSmallerEqual(' ) ;
    public final void rule__SmallerEqual__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2710:1: ( ( 'isSmallerEqual(' ) )
            // InternalFirstOrderLogic.g:2711:1: ( 'isSmallerEqual(' )
            {
            // InternalFirstOrderLogic.g:2711:1: ( 'isSmallerEqual(' )
            // InternalFirstOrderLogic.g:2712:2: 'isSmallerEqual('
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
    // InternalFirstOrderLogic.g:2721:1: rule__SmallerEqual__Group__1 : rule__SmallerEqual__Group__1__Impl rule__SmallerEqual__Group__2 ;
    public final void rule__SmallerEqual__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2725:1: ( rule__SmallerEqual__Group__1__Impl rule__SmallerEqual__Group__2 )
            // InternalFirstOrderLogic.g:2726:2: rule__SmallerEqual__Group__1__Impl rule__SmallerEqual__Group__2
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
    // InternalFirstOrderLogic.g:2733:1: rule__SmallerEqual__Group__1__Impl : ( ( rule__SmallerEqual__LeftAssignment_1 ) ) ;
    public final void rule__SmallerEqual__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2737:1: ( ( ( rule__SmallerEqual__LeftAssignment_1 ) ) )
            // InternalFirstOrderLogic.g:2738:1: ( ( rule__SmallerEqual__LeftAssignment_1 ) )
            {
            // InternalFirstOrderLogic.g:2738:1: ( ( rule__SmallerEqual__LeftAssignment_1 ) )
            // InternalFirstOrderLogic.g:2739:2: ( rule__SmallerEqual__LeftAssignment_1 )
            {
             before(grammarAccess.getSmallerEqualAccess().getLeftAssignment_1()); 
            // InternalFirstOrderLogic.g:2740:2: ( rule__SmallerEqual__LeftAssignment_1 )
            // InternalFirstOrderLogic.g:2740:3: rule__SmallerEqual__LeftAssignment_1
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
    // InternalFirstOrderLogic.g:2748:1: rule__SmallerEqual__Group__2 : rule__SmallerEqual__Group__2__Impl rule__SmallerEqual__Group__3 ;
    public final void rule__SmallerEqual__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2752:1: ( rule__SmallerEqual__Group__2__Impl rule__SmallerEqual__Group__3 )
            // InternalFirstOrderLogic.g:2753:2: rule__SmallerEqual__Group__2__Impl rule__SmallerEqual__Group__3
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
    // InternalFirstOrderLogic.g:2760:1: rule__SmallerEqual__Group__2__Impl : ( ',' ) ;
    public final void rule__SmallerEqual__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2764:1: ( ( ',' ) )
            // InternalFirstOrderLogic.g:2765:1: ( ',' )
            {
            // InternalFirstOrderLogic.g:2765:1: ( ',' )
            // InternalFirstOrderLogic.g:2766:2: ','
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
    // InternalFirstOrderLogic.g:2775:1: rule__SmallerEqual__Group__3 : rule__SmallerEqual__Group__3__Impl rule__SmallerEqual__Group__4 ;
    public final void rule__SmallerEqual__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2779:1: ( rule__SmallerEqual__Group__3__Impl rule__SmallerEqual__Group__4 )
            // InternalFirstOrderLogic.g:2780:2: rule__SmallerEqual__Group__3__Impl rule__SmallerEqual__Group__4
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
    // InternalFirstOrderLogic.g:2787:1: rule__SmallerEqual__Group__3__Impl : ( ( rule__SmallerEqual__RightAssignment_3 ) ) ;
    public final void rule__SmallerEqual__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2791:1: ( ( ( rule__SmallerEqual__RightAssignment_3 ) ) )
            // InternalFirstOrderLogic.g:2792:1: ( ( rule__SmallerEqual__RightAssignment_3 ) )
            {
            // InternalFirstOrderLogic.g:2792:1: ( ( rule__SmallerEqual__RightAssignment_3 ) )
            // InternalFirstOrderLogic.g:2793:2: ( rule__SmallerEqual__RightAssignment_3 )
            {
             before(grammarAccess.getSmallerEqualAccess().getRightAssignment_3()); 
            // InternalFirstOrderLogic.g:2794:2: ( rule__SmallerEqual__RightAssignment_3 )
            // InternalFirstOrderLogic.g:2794:3: rule__SmallerEqual__RightAssignment_3
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
    // InternalFirstOrderLogic.g:2802:1: rule__SmallerEqual__Group__4 : rule__SmallerEqual__Group__4__Impl ;
    public final void rule__SmallerEqual__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2806:1: ( rule__SmallerEqual__Group__4__Impl )
            // InternalFirstOrderLogic.g:2807:2: rule__SmallerEqual__Group__4__Impl
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
    // InternalFirstOrderLogic.g:2813:1: rule__SmallerEqual__Group__4__Impl : ( ')' ) ;
    public final void rule__SmallerEqual__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2817:1: ( ( ')' ) )
            // InternalFirstOrderLogic.g:2818:1: ( ')' )
            {
            // InternalFirstOrderLogic.g:2818:1: ( ')' )
            // InternalFirstOrderLogic.g:2819:2: ')'
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
    // InternalFirstOrderLogic.g:2829:1: rule__IsEmpty__Group__0 : rule__IsEmpty__Group__0__Impl rule__IsEmpty__Group__1 ;
    public final void rule__IsEmpty__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2833:1: ( rule__IsEmpty__Group__0__Impl rule__IsEmpty__Group__1 )
            // InternalFirstOrderLogic.g:2834:2: rule__IsEmpty__Group__0__Impl rule__IsEmpty__Group__1
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
    // InternalFirstOrderLogic.g:2841:1: rule__IsEmpty__Group__0__Impl : ( 'isEmpty(' ) ;
    public final void rule__IsEmpty__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2845:1: ( ( 'isEmpty(' ) )
            // InternalFirstOrderLogic.g:2846:1: ( 'isEmpty(' )
            {
            // InternalFirstOrderLogic.g:2846:1: ( 'isEmpty(' )
            // InternalFirstOrderLogic.g:2847:2: 'isEmpty('
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
    // InternalFirstOrderLogic.g:2856:1: rule__IsEmpty__Group__1 : rule__IsEmpty__Group__1__Impl rule__IsEmpty__Group__2 ;
    public final void rule__IsEmpty__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2860:1: ( rule__IsEmpty__Group__1__Impl rule__IsEmpty__Group__2 )
            // InternalFirstOrderLogic.g:2861:2: rule__IsEmpty__Group__1__Impl rule__IsEmpty__Group__2
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
    // InternalFirstOrderLogic.g:2868:1: rule__IsEmpty__Group__1__Impl : ( ( rule__IsEmpty__TermAssignment_1 ) ) ;
    public final void rule__IsEmpty__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2872:1: ( ( ( rule__IsEmpty__TermAssignment_1 ) ) )
            // InternalFirstOrderLogic.g:2873:1: ( ( rule__IsEmpty__TermAssignment_1 ) )
            {
            // InternalFirstOrderLogic.g:2873:1: ( ( rule__IsEmpty__TermAssignment_1 ) )
            // InternalFirstOrderLogic.g:2874:2: ( rule__IsEmpty__TermAssignment_1 )
            {
             before(grammarAccess.getIsEmptyAccess().getTermAssignment_1()); 
            // InternalFirstOrderLogic.g:2875:2: ( rule__IsEmpty__TermAssignment_1 )
            // InternalFirstOrderLogic.g:2875:3: rule__IsEmpty__TermAssignment_1
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
    // InternalFirstOrderLogic.g:2883:1: rule__IsEmpty__Group__2 : rule__IsEmpty__Group__2__Impl ;
    public final void rule__IsEmpty__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2887:1: ( rule__IsEmpty__Group__2__Impl )
            // InternalFirstOrderLogic.g:2888:2: rule__IsEmpty__Group__2__Impl
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
    // InternalFirstOrderLogic.g:2894:1: rule__IsEmpty__Group__2__Impl : ( ')' ) ;
    public final void rule__IsEmpty__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2898:1: ( ( ')' ) )
            // InternalFirstOrderLogic.g:2899:1: ( ')' )
            {
            // InternalFirstOrderLogic.g:2899:1: ( ')' )
            // InternalFirstOrderLogic.g:2900:2: ')'
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
    // InternalFirstOrderLogic.g:2910:1: rule__ForAll__Group__0 : rule__ForAll__Group__0__Impl rule__ForAll__Group__1 ;
    public final void rule__ForAll__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2914:1: ( rule__ForAll__Group__0__Impl rule__ForAll__Group__1 )
            // InternalFirstOrderLogic.g:2915:2: rule__ForAll__Group__0__Impl rule__ForAll__Group__1
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
    // InternalFirstOrderLogic.g:2922:1: rule__ForAll__Group__0__Impl : ( () ) ;
    public final void rule__ForAll__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2926:1: ( ( () ) )
            // InternalFirstOrderLogic.g:2927:1: ( () )
            {
            // InternalFirstOrderLogic.g:2927:1: ( () )
            // InternalFirstOrderLogic.g:2928:2: ()
            {
             before(grammarAccess.getForAllAccess().getForAllAction_0()); 
            // InternalFirstOrderLogic.g:2929:2: ()
            // InternalFirstOrderLogic.g:2929:3: 
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
    // InternalFirstOrderLogic.g:2937:1: rule__ForAll__Group__1 : rule__ForAll__Group__1__Impl rule__ForAll__Group__2 ;
    public final void rule__ForAll__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2941:1: ( rule__ForAll__Group__1__Impl rule__ForAll__Group__2 )
            // InternalFirstOrderLogic.g:2942:2: rule__ForAll__Group__1__Impl rule__ForAll__Group__2
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
    // InternalFirstOrderLogic.g:2949:1: rule__ForAll__Group__1__Impl : ( 'forAll(' ) ;
    public final void rule__ForAll__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2953:1: ( ( 'forAll(' ) )
            // InternalFirstOrderLogic.g:2954:1: ( 'forAll(' )
            {
            // InternalFirstOrderLogic.g:2954:1: ( 'forAll(' )
            // InternalFirstOrderLogic.g:2955:2: 'forAll('
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
    // InternalFirstOrderLogic.g:2964:1: rule__ForAll__Group__2 : rule__ForAll__Group__2__Impl rule__ForAll__Group__3 ;
    public final void rule__ForAll__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2968:1: ( rule__ForAll__Group__2__Impl rule__ForAll__Group__3 )
            // InternalFirstOrderLogic.g:2969:2: rule__ForAll__Group__2__Impl rule__ForAll__Group__3
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
    // InternalFirstOrderLogic.g:2976:1: rule__ForAll__Group__2__Impl : ( ( rule__ForAll__NameAssignment_2 ) ) ;
    public final void rule__ForAll__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2980:1: ( ( ( rule__ForAll__NameAssignment_2 ) ) )
            // InternalFirstOrderLogic.g:2981:1: ( ( rule__ForAll__NameAssignment_2 ) )
            {
            // InternalFirstOrderLogic.g:2981:1: ( ( rule__ForAll__NameAssignment_2 ) )
            // InternalFirstOrderLogic.g:2982:2: ( rule__ForAll__NameAssignment_2 )
            {
             before(grammarAccess.getForAllAccess().getNameAssignment_2()); 
            // InternalFirstOrderLogic.g:2983:2: ( rule__ForAll__NameAssignment_2 )
            // InternalFirstOrderLogic.g:2983:3: rule__ForAll__NameAssignment_2
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
    // InternalFirstOrderLogic.g:2991:1: rule__ForAll__Group__3 : rule__ForAll__Group__3__Impl rule__ForAll__Group__4 ;
    public final void rule__ForAll__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2995:1: ( rule__ForAll__Group__3__Impl rule__ForAll__Group__4 )
            // InternalFirstOrderLogic.g:2996:2: rule__ForAll__Group__3__Impl rule__ForAll__Group__4
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
    // InternalFirstOrderLogic.g:3003:1: rule__ForAll__Group__3__Impl : ( 'in' ) ;
    public final void rule__ForAll__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3007:1: ( ( 'in' ) )
            // InternalFirstOrderLogic.g:3008:1: ( 'in' )
            {
            // InternalFirstOrderLogic.g:3008:1: ( 'in' )
            // InternalFirstOrderLogic.g:3009:2: 'in'
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
    // InternalFirstOrderLogic.g:3018:1: rule__ForAll__Group__4 : rule__ForAll__Group__4__Impl rule__ForAll__Group__5 ;
    public final void rule__ForAll__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3022:1: ( rule__ForAll__Group__4__Impl rule__ForAll__Group__5 )
            // InternalFirstOrderLogic.g:3023:2: rule__ForAll__Group__4__Impl rule__ForAll__Group__5
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
    // InternalFirstOrderLogic.g:3030:1: rule__ForAll__Group__4__Impl : ( ( rule__ForAll__IterationAssignment_4 ) ) ;
    public final void rule__ForAll__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3034:1: ( ( ( rule__ForAll__IterationAssignment_4 ) ) )
            // InternalFirstOrderLogic.g:3035:1: ( ( rule__ForAll__IterationAssignment_4 ) )
            {
            // InternalFirstOrderLogic.g:3035:1: ( ( rule__ForAll__IterationAssignment_4 ) )
            // InternalFirstOrderLogic.g:3036:2: ( rule__ForAll__IterationAssignment_4 )
            {
             before(grammarAccess.getForAllAccess().getIterationAssignment_4()); 
            // InternalFirstOrderLogic.g:3037:2: ( rule__ForAll__IterationAssignment_4 )
            // InternalFirstOrderLogic.g:3037:3: rule__ForAll__IterationAssignment_4
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
    // InternalFirstOrderLogic.g:3045:1: rule__ForAll__Group__5 : rule__ForAll__Group__5__Impl rule__ForAll__Group__6 ;
    public final void rule__ForAll__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3049:1: ( rule__ForAll__Group__5__Impl rule__ForAll__Group__6 )
            // InternalFirstOrderLogic.g:3050:2: rule__ForAll__Group__5__Impl rule__ForAll__Group__6
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
    // InternalFirstOrderLogic.g:3057:1: rule__ForAll__Group__5__Impl : ( ':' ) ;
    public final void rule__ForAll__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3061:1: ( ( ':' ) )
            // InternalFirstOrderLogic.g:3062:1: ( ':' )
            {
            // InternalFirstOrderLogic.g:3062:1: ( ':' )
            // InternalFirstOrderLogic.g:3063:2: ':'
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
    // InternalFirstOrderLogic.g:3072:1: rule__ForAll__Group__6 : rule__ForAll__Group__6__Impl rule__ForAll__Group__7 ;
    public final void rule__ForAll__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3076:1: ( rule__ForAll__Group__6__Impl rule__ForAll__Group__7 )
            // InternalFirstOrderLogic.g:3077:2: rule__ForAll__Group__6__Impl rule__ForAll__Group__7
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
    // InternalFirstOrderLogic.g:3084:1: rule__ForAll__Group__6__Impl : ( ( rule__ForAll__FormulaAssignment_6 ) ) ;
    public final void rule__ForAll__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3088:1: ( ( ( rule__ForAll__FormulaAssignment_6 ) ) )
            // InternalFirstOrderLogic.g:3089:1: ( ( rule__ForAll__FormulaAssignment_6 ) )
            {
            // InternalFirstOrderLogic.g:3089:1: ( ( rule__ForAll__FormulaAssignment_6 ) )
            // InternalFirstOrderLogic.g:3090:2: ( rule__ForAll__FormulaAssignment_6 )
            {
             before(grammarAccess.getForAllAccess().getFormulaAssignment_6()); 
            // InternalFirstOrderLogic.g:3091:2: ( rule__ForAll__FormulaAssignment_6 )
            // InternalFirstOrderLogic.g:3091:3: rule__ForAll__FormulaAssignment_6
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
    // InternalFirstOrderLogic.g:3099:1: rule__ForAll__Group__7 : rule__ForAll__Group__7__Impl ;
    public final void rule__ForAll__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3103:1: ( rule__ForAll__Group__7__Impl )
            // InternalFirstOrderLogic.g:3104:2: rule__ForAll__Group__7__Impl
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
    // InternalFirstOrderLogic.g:3110:1: rule__ForAll__Group__7__Impl : ( ')' ) ;
    public final void rule__ForAll__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3114:1: ( ( ')' ) )
            // InternalFirstOrderLogic.g:3115:1: ( ')' )
            {
            // InternalFirstOrderLogic.g:3115:1: ( ')' )
            // InternalFirstOrderLogic.g:3116:2: ')'
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
    // InternalFirstOrderLogic.g:3126:1: rule__Exists__Group__0 : rule__Exists__Group__0__Impl rule__Exists__Group__1 ;
    public final void rule__Exists__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3130:1: ( rule__Exists__Group__0__Impl rule__Exists__Group__1 )
            // InternalFirstOrderLogic.g:3131:2: rule__Exists__Group__0__Impl rule__Exists__Group__1
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
    // InternalFirstOrderLogic.g:3138:1: rule__Exists__Group__0__Impl : ( () ) ;
    public final void rule__Exists__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3142:1: ( ( () ) )
            // InternalFirstOrderLogic.g:3143:1: ( () )
            {
            // InternalFirstOrderLogic.g:3143:1: ( () )
            // InternalFirstOrderLogic.g:3144:2: ()
            {
             before(grammarAccess.getExistsAccess().getExistsAction_0()); 
            // InternalFirstOrderLogic.g:3145:2: ()
            // InternalFirstOrderLogic.g:3145:3: 
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
    // InternalFirstOrderLogic.g:3153:1: rule__Exists__Group__1 : rule__Exists__Group__1__Impl rule__Exists__Group__2 ;
    public final void rule__Exists__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3157:1: ( rule__Exists__Group__1__Impl rule__Exists__Group__2 )
            // InternalFirstOrderLogic.g:3158:2: rule__Exists__Group__1__Impl rule__Exists__Group__2
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
    // InternalFirstOrderLogic.g:3165:1: rule__Exists__Group__1__Impl : ( 'exists(' ) ;
    public final void rule__Exists__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3169:1: ( ( 'exists(' ) )
            // InternalFirstOrderLogic.g:3170:1: ( 'exists(' )
            {
            // InternalFirstOrderLogic.g:3170:1: ( 'exists(' )
            // InternalFirstOrderLogic.g:3171:2: 'exists('
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
    // InternalFirstOrderLogic.g:3180:1: rule__Exists__Group__2 : rule__Exists__Group__2__Impl rule__Exists__Group__3 ;
    public final void rule__Exists__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3184:1: ( rule__Exists__Group__2__Impl rule__Exists__Group__3 )
            // InternalFirstOrderLogic.g:3185:2: rule__Exists__Group__2__Impl rule__Exists__Group__3
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
    // InternalFirstOrderLogic.g:3192:1: rule__Exists__Group__2__Impl : ( ( rule__Exists__NameAssignment_2 ) ) ;
    public final void rule__Exists__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3196:1: ( ( ( rule__Exists__NameAssignment_2 ) ) )
            // InternalFirstOrderLogic.g:3197:1: ( ( rule__Exists__NameAssignment_2 ) )
            {
            // InternalFirstOrderLogic.g:3197:1: ( ( rule__Exists__NameAssignment_2 ) )
            // InternalFirstOrderLogic.g:3198:2: ( rule__Exists__NameAssignment_2 )
            {
             before(grammarAccess.getExistsAccess().getNameAssignment_2()); 
            // InternalFirstOrderLogic.g:3199:2: ( rule__Exists__NameAssignment_2 )
            // InternalFirstOrderLogic.g:3199:3: rule__Exists__NameAssignment_2
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
    // InternalFirstOrderLogic.g:3207:1: rule__Exists__Group__3 : rule__Exists__Group__3__Impl rule__Exists__Group__4 ;
    public final void rule__Exists__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3211:1: ( rule__Exists__Group__3__Impl rule__Exists__Group__4 )
            // InternalFirstOrderLogic.g:3212:2: rule__Exists__Group__3__Impl rule__Exists__Group__4
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
    // InternalFirstOrderLogic.g:3219:1: rule__Exists__Group__3__Impl : ( 'in' ) ;
    public final void rule__Exists__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3223:1: ( ( 'in' ) )
            // InternalFirstOrderLogic.g:3224:1: ( 'in' )
            {
            // InternalFirstOrderLogic.g:3224:1: ( 'in' )
            // InternalFirstOrderLogic.g:3225:2: 'in'
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
    // InternalFirstOrderLogic.g:3234:1: rule__Exists__Group__4 : rule__Exists__Group__4__Impl rule__Exists__Group__5 ;
    public final void rule__Exists__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3238:1: ( rule__Exists__Group__4__Impl rule__Exists__Group__5 )
            // InternalFirstOrderLogic.g:3239:2: rule__Exists__Group__4__Impl rule__Exists__Group__5
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
    // InternalFirstOrderLogic.g:3246:1: rule__Exists__Group__4__Impl : ( ( rule__Exists__IterationAssignment_4 ) ) ;
    public final void rule__Exists__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3250:1: ( ( ( rule__Exists__IterationAssignment_4 ) ) )
            // InternalFirstOrderLogic.g:3251:1: ( ( rule__Exists__IterationAssignment_4 ) )
            {
            // InternalFirstOrderLogic.g:3251:1: ( ( rule__Exists__IterationAssignment_4 ) )
            // InternalFirstOrderLogic.g:3252:2: ( rule__Exists__IterationAssignment_4 )
            {
             before(grammarAccess.getExistsAccess().getIterationAssignment_4()); 
            // InternalFirstOrderLogic.g:3253:2: ( rule__Exists__IterationAssignment_4 )
            // InternalFirstOrderLogic.g:3253:3: rule__Exists__IterationAssignment_4
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
    // InternalFirstOrderLogic.g:3261:1: rule__Exists__Group__5 : rule__Exists__Group__5__Impl rule__Exists__Group__6 ;
    public final void rule__Exists__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3265:1: ( rule__Exists__Group__5__Impl rule__Exists__Group__6 )
            // InternalFirstOrderLogic.g:3266:2: rule__Exists__Group__5__Impl rule__Exists__Group__6
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
    // InternalFirstOrderLogic.g:3273:1: rule__Exists__Group__5__Impl : ( ':' ) ;
    public final void rule__Exists__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3277:1: ( ( ':' ) )
            // InternalFirstOrderLogic.g:3278:1: ( ':' )
            {
            // InternalFirstOrderLogic.g:3278:1: ( ':' )
            // InternalFirstOrderLogic.g:3279:2: ':'
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
    // InternalFirstOrderLogic.g:3288:1: rule__Exists__Group__6 : rule__Exists__Group__6__Impl rule__Exists__Group__7 ;
    public final void rule__Exists__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3292:1: ( rule__Exists__Group__6__Impl rule__Exists__Group__7 )
            // InternalFirstOrderLogic.g:3293:2: rule__Exists__Group__6__Impl rule__Exists__Group__7
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
    // InternalFirstOrderLogic.g:3300:1: rule__Exists__Group__6__Impl : ( ( rule__Exists__FormulaAssignment_6 ) ) ;
    public final void rule__Exists__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3304:1: ( ( ( rule__Exists__FormulaAssignment_6 ) ) )
            // InternalFirstOrderLogic.g:3305:1: ( ( rule__Exists__FormulaAssignment_6 ) )
            {
            // InternalFirstOrderLogic.g:3305:1: ( ( rule__Exists__FormulaAssignment_6 ) )
            // InternalFirstOrderLogic.g:3306:2: ( rule__Exists__FormulaAssignment_6 )
            {
             before(grammarAccess.getExistsAccess().getFormulaAssignment_6()); 
            // InternalFirstOrderLogic.g:3307:2: ( rule__Exists__FormulaAssignment_6 )
            // InternalFirstOrderLogic.g:3307:3: rule__Exists__FormulaAssignment_6
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
    // InternalFirstOrderLogic.g:3315:1: rule__Exists__Group__7 : rule__Exists__Group__7__Impl ;
    public final void rule__Exists__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3319:1: ( rule__Exists__Group__7__Impl )
            // InternalFirstOrderLogic.g:3320:2: rule__Exists__Group__7__Impl
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
    // InternalFirstOrderLogic.g:3326:1: rule__Exists__Group__7__Impl : ( ')' ) ;
    public final void rule__Exists__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3330:1: ( ( ')' ) )
            // InternalFirstOrderLogic.g:3331:1: ( ')' )
            {
            // InternalFirstOrderLogic.g:3331:1: ( ')' )
            // InternalFirstOrderLogic.g:3332:2: ')'
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
    // InternalFirstOrderLogic.g:3342:1: rule__BooleanExpression__Group_0__0 : rule__BooleanExpression__Group_0__0__Impl rule__BooleanExpression__Group_0__1 ;
    public final void rule__BooleanExpression__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3346:1: ( rule__BooleanExpression__Group_0__0__Impl rule__BooleanExpression__Group_0__1 )
            // InternalFirstOrderLogic.g:3347:2: rule__BooleanExpression__Group_0__0__Impl rule__BooleanExpression__Group_0__1
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
    // InternalFirstOrderLogic.g:3354:1: rule__BooleanExpression__Group_0__0__Impl : ( '(' ) ;
    public final void rule__BooleanExpression__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3358:1: ( ( '(' ) )
            // InternalFirstOrderLogic.g:3359:1: ( '(' )
            {
            // InternalFirstOrderLogic.g:3359:1: ( '(' )
            // InternalFirstOrderLogic.g:3360:2: '('
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
    // InternalFirstOrderLogic.g:3369:1: rule__BooleanExpression__Group_0__1 : rule__BooleanExpression__Group_0__1__Impl rule__BooleanExpression__Group_0__2 ;
    public final void rule__BooleanExpression__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3373:1: ( rule__BooleanExpression__Group_0__1__Impl rule__BooleanExpression__Group_0__2 )
            // InternalFirstOrderLogic.g:3374:2: rule__BooleanExpression__Group_0__1__Impl rule__BooleanExpression__Group_0__2
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
    // InternalFirstOrderLogic.g:3381:1: rule__BooleanExpression__Group_0__1__Impl : ( ruleFormula ) ;
    public final void rule__BooleanExpression__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3385:1: ( ( ruleFormula ) )
            // InternalFirstOrderLogic.g:3386:1: ( ruleFormula )
            {
            // InternalFirstOrderLogic.g:3386:1: ( ruleFormula )
            // InternalFirstOrderLogic.g:3387:2: ruleFormula
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
    // InternalFirstOrderLogic.g:3396:1: rule__BooleanExpression__Group_0__2 : rule__BooleanExpression__Group_0__2__Impl ;
    public final void rule__BooleanExpression__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3400:1: ( rule__BooleanExpression__Group_0__2__Impl )
            // InternalFirstOrderLogic.g:3401:2: rule__BooleanExpression__Group_0__2__Impl
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
    // InternalFirstOrderLogic.g:3407:1: rule__BooleanExpression__Group_0__2__Impl : ( ')' ) ;
    public final void rule__BooleanExpression__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3411:1: ( ( ')' ) )
            // InternalFirstOrderLogic.g:3412:1: ( ')' )
            {
            // InternalFirstOrderLogic.g:3412:1: ( ')' )
            // InternalFirstOrderLogic.g:3413:2: ')'
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
    // InternalFirstOrderLogic.g:3423:1: rule__BoolConstant__Group__0 : rule__BoolConstant__Group__0__Impl rule__BoolConstant__Group__1 ;
    public final void rule__BoolConstant__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3427:1: ( rule__BoolConstant__Group__0__Impl rule__BoolConstant__Group__1 )
            // InternalFirstOrderLogic.g:3428:2: rule__BoolConstant__Group__0__Impl rule__BoolConstant__Group__1
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
    // InternalFirstOrderLogic.g:3435:1: rule__BoolConstant__Group__0__Impl : ( () ) ;
    public final void rule__BoolConstant__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3439:1: ( ( () ) )
            // InternalFirstOrderLogic.g:3440:1: ( () )
            {
            // InternalFirstOrderLogic.g:3440:1: ( () )
            // InternalFirstOrderLogic.g:3441:2: ()
            {
             before(grammarAccess.getBoolConstantAccess().getBoolConstantAction_0()); 
            // InternalFirstOrderLogic.g:3442:2: ()
            // InternalFirstOrderLogic.g:3442:3: 
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
    // InternalFirstOrderLogic.g:3450:1: rule__BoolConstant__Group__1 : rule__BoolConstant__Group__1__Impl ;
    public final void rule__BoolConstant__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3454:1: ( rule__BoolConstant__Group__1__Impl )
            // InternalFirstOrderLogic.g:3455:2: rule__BoolConstant__Group__1__Impl
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
    // InternalFirstOrderLogic.g:3461:1: rule__BoolConstant__Group__1__Impl : ( ( rule__BoolConstant__ValueAssignment_1 ) ) ;
    public final void rule__BoolConstant__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3465:1: ( ( ( rule__BoolConstant__ValueAssignment_1 ) ) )
            // InternalFirstOrderLogic.g:3466:1: ( ( rule__BoolConstant__ValueAssignment_1 ) )
            {
            // InternalFirstOrderLogic.g:3466:1: ( ( rule__BoolConstant__ValueAssignment_1 ) )
            // InternalFirstOrderLogic.g:3467:2: ( rule__BoolConstant__ValueAssignment_1 )
            {
             before(grammarAccess.getBoolConstantAccess().getValueAssignment_1()); 
            // InternalFirstOrderLogic.g:3468:2: ( rule__BoolConstant__ValueAssignment_1 )
            // InternalFirstOrderLogic.g:3468:3: rule__BoolConstant__ValueAssignment_1
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
    // InternalFirstOrderLogic.g:3477:1: rule__VariableRef__Group__0 : rule__VariableRef__Group__0__Impl rule__VariableRef__Group__1 ;
    public final void rule__VariableRef__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3481:1: ( rule__VariableRef__Group__0__Impl rule__VariableRef__Group__1 )
            // InternalFirstOrderLogic.g:3482:2: rule__VariableRef__Group__0__Impl rule__VariableRef__Group__1
            {
            pushFollow(FOLLOW_24);
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
    // InternalFirstOrderLogic.g:3489:1: rule__VariableRef__Group__0__Impl : ( () ) ;
    public final void rule__VariableRef__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3493:1: ( ( () ) )
            // InternalFirstOrderLogic.g:3494:1: ( () )
            {
            // InternalFirstOrderLogic.g:3494:1: ( () )
            // InternalFirstOrderLogic.g:3495:2: ()
            {
             before(grammarAccess.getVariableRefAccess().getVariableRefAction_0()); 
            // InternalFirstOrderLogic.g:3496:2: ()
            // InternalFirstOrderLogic.g:3496:3: 
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
    // InternalFirstOrderLogic.g:3504:1: rule__VariableRef__Group__1 : rule__VariableRef__Group__1__Impl rule__VariableRef__Group__2 ;
    public final void rule__VariableRef__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3508:1: ( rule__VariableRef__Group__1__Impl rule__VariableRef__Group__2 )
            // InternalFirstOrderLogic.g:3509:2: rule__VariableRef__Group__1__Impl rule__VariableRef__Group__2
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
    // InternalFirstOrderLogic.g:3516:1: rule__VariableRef__Group__1__Impl : ( ( rule__VariableRef__NameAssignment_1 ) ) ;
    public final void rule__VariableRef__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3520:1: ( ( ( rule__VariableRef__NameAssignment_1 ) ) )
            // InternalFirstOrderLogic.g:3521:1: ( ( rule__VariableRef__NameAssignment_1 ) )
            {
            // InternalFirstOrderLogic.g:3521:1: ( ( rule__VariableRef__NameAssignment_1 ) )
            // InternalFirstOrderLogic.g:3522:2: ( rule__VariableRef__NameAssignment_1 )
            {
             before(grammarAccess.getVariableRefAccess().getNameAssignment_1()); 
            // InternalFirstOrderLogic.g:3523:2: ( rule__VariableRef__NameAssignment_1 )
            // InternalFirstOrderLogic.g:3523:3: rule__VariableRef__NameAssignment_1
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
    // InternalFirstOrderLogic.g:3531:1: rule__VariableRef__Group__2 : rule__VariableRef__Group__2__Impl ;
    public final void rule__VariableRef__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3535:1: ( rule__VariableRef__Group__2__Impl )
            // InternalFirstOrderLogic.g:3536:2: rule__VariableRef__Group__2__Impl
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
    // InternalFirstOrderLogic.g:3542:1: rule__VariableRef__Group__2__Impl : ( ( rule__VariableRef__GetAssignment_2 )? ) ;
    public final void rule__VariableRef__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3546:1: ( ( ( rule__VariableRef__GetAssignment_2 )? ) )
            // InternalFirstOrderLogic.g:3547:1: ( ( rule__VariableRef__GetAssignment_2 )? )
            {
            // InternalFirstOrderLogic.g:3547:1: ( ( rule__VariableRef__GetAssignment_2 )? )
            // InternalFirstOrderLogic.g:3548:2: ( rule__VariableRef__GetAssignment_2 )?
            {
             before(grammarAccess.getVariableRefAccess().getGetAssignment_2()); 
            // InternalFirstOrderLogic.g:3549:2: ( rule__VariableRef__GetAssignment_2 )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==37) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalFirstOrderLogic.g:3549:3: rule__VariableRef__GetAssignment_2
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
    // InternalFirstOrderLogic.g:3558:1: rule__Get__Group__0 : rule__Get__Group__0__Impl rule__Get__Group__1 ;
    public final void rule__Get__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3562:1: ( rule__Get__Group__0__Impl rule__Get__Group__1 )
            // InternalFirstOrderLogic.g:3563:2: rule__Get__Group__0__Impl rule__Get__Group__1
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
    // InternalFirstOrderLogic.g:3570:1: rule__Get__Group__0__Impl : ( '.' ) ;
    public final void rule__Get__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3574:1: ( ( '.' ) )
            // InternalFirstOrderLogic.g:3575:1: ( '.' )
            {
            // InternalFirstOrderLogic.g:3575:1: ( '.' )
            // InternalFirstOrderLogic.g:3576:2: '.'
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
    // InternalFirstOrderLogic.g:3585:1: rule__Get__Group__1 : rule__Get__Group__1__Impl rule__Get__Group__2 ;
    public final void rule__Get__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3589:1: ( rule__Get__Group__1__Impl rule__Get__Group__2 )
            // InternalFirstOrderLogic.g:3590:2: rule__Get__Group__1__Impl rule__Get__Group__2
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
    // InternalFirstOrderLogic.g:3597:1: rule__Get__Group__1__Impl : ( ( rule__Get__Group_1__0 )? ) ;
    public final void rule__Get__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3601:1: ( ( ( rule__Get__Group_1__0 )? ) )
            // InternalFirstOrderLogic.g:3602:1: ( ( rule__Get__Group_1__0 )? )
            {
            // InternalFirstOrderLogic.g:3602:1: ( ( rule__Get__Group_1__0 )? )
            // InternalFirstOrderLogic.g:3603:2: ( rule__Get__Group_1__0 )?
            {
             before(grammarAccess.getGetAccess().getGroup_1()); 
            // InternalFirstOrderLogic.g:3604:2: ( rule__Get__Group_1__0 )?
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
                    // InternalFirstOrderLogic.g:3604:3: rule__Get__Group_1__0
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
    // InternalFirstOrderLogic.g:3612:1: rule__Get__Group__2 : rule__Get__Group__2__Impl rule__Get__Group__3 ;
    public final void rule__Get__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3616:1: ( rule__Get__Group__2__Impl rule__Get__Group__3 )
            // InternalFirstOrderLogic.g:3617:2: rule__Get__Group__2__Impl rule__Get__Group__3
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
    // InternalFirstOrderLogic.g:3624:1: rule__Get__Group__2__Impl : ( ( rule__Get__NameAssignment_2 ) ) ;
    public final void rule__Get__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3628:1: ( ( ( rule__Get__NameAssignment_2 ) ) )
            // InternalFirstOrderLogic.g:3629:1: ( ( rule__Get__NameAssignment_2 ) )
            {
            // InternalFirstOrderLogic.g:3629:1: ( ( rule__Get__NameAssignment_2 ) )
            // InternalFirstOrderLogic.g:3630:2: ( rule__Get__NameAssignment_2 )
            {
             before(grammarAccess.getGetAccess().getNameAssignment_2()); 
            // InternalFirstOrderLogic.g:3631:2: ( rule__Get__NameAssignment_2 )
            // InternalFirstOrderLogic.g:3631:3: rule__Get__NameAssignment_2
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
    // InternalFirstOrderLogic.g:3639:1: rule__Get__Group__3 : rule__Get__Group__3__Impl ;
    public final void rule__Get__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3643:1: ( rule__Get__Group__3__Impl )
            // InternalFirstOrderLogic.g:3644:2: rule__Get__Group__3__Impl
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
    // InternalFirstOrderLogic.g:3650:1: rule__Get__Group__3__Impl : ( ( rule__Get__NextAssignment_3 )? ) ;
    public final void rule__Get__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3654:1: ( ( ( rule__Get__NextAssignment_3 )? ) )
            // InternalFirstOrderLogic.g:3655:1: ( ( rule__Get__NextAssignment_3 )? )
            {
            // InternalFirstOrderLogic.g:3655:1: ( ( rule__Get__NextAssignment_3 )? )
            // InternalFirstOrderLogic.g:3656:2: ( rule__Get__NextAssignment_3 )?
            {
             before(grammarAccess.getGetAccess().getNextAssignment_3()); 
            // InternalFirstOrderLogic.g:3657:2: ( rule__Get__NextAssignment_3 )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==37) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalFirstOrderLogic.g:3657:3: rule__Get__NextAssignment_3
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
    // InternalFirstOrderLogic.g:3666:1: rule__Get__Group_1__0 : rule__Get__Group_1__0__Impl rule__Get__Group_1__1 ;
    public final void rule__Get__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3670:1: ( rule__Get__Group_1__0__Impl rule__Get__Group_1__1 )
            // InternalFirstOrderLogic.g:3671:2: rule__Get__Group_1__0__Impl rule__Get__Group_1__1
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
    // InternalFirstOrderLogic.g:3678:1: rule__Get__Group_1__0__Impl : ( ( rule__Get__TypeAssignment_1_0 ) ) ;
    public final void rule__Get__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3682:1: ( ( ( rule__Get__TypeAssignment_1_0 ) ) )
            // InternalFirstOrderLogic.g:3683:1: ( ( rule__Get__TypeAssignment_1_0 ) )
            {
            // InternalFirstOrderLogic.g:3683:1: ( ( rule__Get__TypeAssignment_1_0 ) )
            // InternalFirstOrderLogic.g:3684:2: ( rule__Get__TypeAssignment_1_0 )
            {
             before(grammarAccess.getGetAccess().getTypeAssignment_1_0()); 
            // InternalFirstOrderLogic.g:3685:2: ( rule__Get__TypeAssignment_1_0 )
            // InternalFirstOrderLogic.g:3685:3: rule__Get__TypeAssignment_1_0
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
    // InternalFirstOrderLogic.g:3693:1: rule__Get__Group_1__1 : rule__Get__Group_1__1__Impl ;
    public final void rule__Get__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3697:1: ( rule__Get__Group_1__1__Impl )
            // InternalFirstOrderLogic.g:3698:2: rule__Get__Group_1__1__Impl
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
    // InternalFirstOrderLogic.g:3704:1: rule__Get__Group_1__1__Impl : ( '::' ) ;
    public final void rule__Get__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3708:1: ( ( '::' ) )
            // InternalFirstOrderLogic.g:3709:1: ( '::' )
            {
            // InternalFirstOrderLogic.g:3709:1: ( '::' )
            // InternalFirstOrderLogic.g:3710:2: '::'
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


    // $ANTLR start "rule__Constant__Group_0__0"
    // InternalFirstOrderLogic.g:3720:1: rule__Constant__Group_0__0 : rule__Constant__Group_0__0__Impl rule__Constant__Group_0__1 ;
    public final void rule__Constant__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3724:1: ( rule__Constant__Group_0__0__Impl rule__Constant__Group_0__1 )
            // InternalFirstOrderLogic.g:3725:2: rule__Constant__Group_0__0__Impl rule__Constant__Group_0__1
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
    // InternalFirstOrderLogic.g:3732:1: rule__Constant__Group_0__0__Impl : ( () ) ;
    public final void rule__Constant__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3736:1: ( ( () ) )
            // InternalFirstOrderLogic.g:3737:1: ( () )
            {
            // InternalFirstOrderLogic.g:3737:1: ( () )
            // InternalFirstOrderLogic.g:3738:2: ()
            {
             before(grammarAccess.getConstantAccess().getIntConstantAction_0_0()); 
            // InternalFirstOrderLogic.g:3739:2: ()
            // InternalFirstOrderLogic.g:3739:3: 
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
    // InternalFirstOrderLogic.g:3747:1: rule__Constant__Group_0__1 : rule__Constant__Group_0__1__Impl ;
    public final void rule__Constant__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3751:1: ( rule__Constant__Group_0__1__Impl )
            // InternalFirstOrderLogic.g:3752:2: rule__Constant__Group_0__1__Impl
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
    // InternalFirstOrderLogic.g:3758:1: rule__Constant__Group_0__1__Impl : ( ( rule__Constant__ValueAssignment_0_1 ) ) ;
    public final void rule__Constant__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3762:1: ( ( ( rule__Constant__ValueAssignment_0_1 ) ) )
            // InternalFirstOrderLogic.g:3763:1: ( ( rule__Constant__ValueAssignment_0_1 ) )
            {
            // InternalFirstOrderLogic.g:3763:1: ( ( rule__Constant__ValueAssignment_0_1 ) )
            // InternalFirstOrderLogic.g:3764:2: ( rule__Constant__ValueAssignment_0_1 )
            {
             before(grammarAccess.getConstantAccess().getValueAssignment_0_1()); 
            // InternalFirstOrderLogic.g:3765:2: ( rule__Constant__ValueAssignment_0_1 )
            // InternalFirstOrderLogic.g:3765:3: rule__Constant__ValueAssignment_0_1
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
    // InternalFirstOrderLogic.g:3774:1: rule__Constant__Group_1__0 : rule__Constant__Group_1__0__Impl rule__Constant__Group_1__1 ;
    public final void rule__Constant__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3778:1: ( rule__Constant__Group_1__0__Impl rule__Constant__Group_1__1 )
            // InternalFirstOrderLogic.g:3779:2: rule__Constant__Group_1__0__Impl rule__Constant__Group_1__1
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
    // InternalFirstOrderLogic.g:3786:1: rule__Constant__Group_1__0__Impl : ( () ) ;
    public final void rule__Constant__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3790:1: ( ( () ) )
            // InternalFirstOrderLogic.g:3791:1: ( () )
            {
            // InternalFirstOrderLogic.g:3791:1: ( () )
            // InternalFirstOrderLogic.g:3792:2: ()
            {
             before(grammarAccess.getConstantAccess().getStringConstantAction_1_0()); 
            // InternalFirstOrderLogic.g:3793:2: ()
            // InternalFirstOrderLogic.g:3793:3: 
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
    // InternalFirstOrderLogic.g:3801:1: rule__Constant__Group_1__1 : rule__Constant__Group_1__1__Impl ;
    public final void rule__Constant__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3805:1: ( rule__Constant__Group_1__1__Impl )
            // InternalFirstOrderLogic.g:3806:2: rule__Constant__Group_1__1__Impl
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
    // InternalFirstOrderLogic.g:3812:1: rule__Constant__Group_1__1__Impl : ( ( rule__Constant__ValueAssignment_1_1 ) ) ;
    public final void rule__Constant__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3816:1: ( ( ( rule__Constant__ValueAssignment_1_1 ) ) )
            // InternalFirstOrderLogic.g:3817:1: ( ( rule__Constant__ValueAssignment_1_1 ) )
            {
            // InternalFirstOrderLogic.g:3817:1: ( ( rule__Constant__ValueAssignment_1_1 ) )
            // InternalFirstOrderLogic.g:3818:2: ( rule__Constant__ValueAssignment_1_1 )
            {
             before(grammarAccess.getConstantAccess().getValueAssignment_1_1()); 
            // InternalFirstOrderLogic.g:3819:2: ( rule__Constant__ValueAssignment_1_1 )
            // InternalFirstOrderLogic.g:3819:3: rule__Constant__ValueAssignment_1_1
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


    // $ANTLR start "rule__ConstraintRuleBase__DomainAssignment_1"
    // InternalFirstOrderLogic.g:3828:1: rule__ConstraintRuleBase__DomainAssignment_1 : ( RULE_STRING ) ;
    public final void rule__ConstraintRuleBase__DomainAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3832:1: ( ( RULE_STRING ) )
            // InternalFirstOrderLogic.g:3833:2: ( RULE_STRING )
            {
            // InternalFirstOrderLogic.g:3833:2: ( RULE_STRING )
            // InternalFirstOrderLogic.g:3834:3: RULE_STRING
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


    // $ANTLR start "rule__ConstraintRuleBase__PackageImportAssignment_3"
    // InternalFirstOrderLogic.g:3843:1: rule__ConstraintRuleBase__PackageImportAssignment_3 : ( RULE_STRING ) ;
    public final void rule__ConstraintRuleBase__PackageImportAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3847:1: ( ( RULE_STRING ) )
            // InternalFirstOrderLogic.g:3848:2: ( RULE_STRING )
            {
            // InternalFirstOrderLogic.g:3848:2: ( RULE_STRING )
            // InternalFirstOrderLogic.g:3849:3: RULE_STRING
            {
             before(grammarAccess.getConstraintRuleBaseAccess().getPackageImportSTRINGTerminalRuleCall_3_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getConstraintRuleBaseAccess().getPackageImportSTRINGTerminalRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintRuleBase__PackageImportAssignment_3"


    // $ANTLR start "rule__ConstraintRuleBase__ConstraintsAssignment_4"
    // InternalFirstOrderLogic.g:3858:1: rule__ConstraintRuleBase__ConstraintsAssignment_4 : ( ruleConstraint ) ;
    public final void rule__ConstraintRuleBase__ConstraintsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3862:1: ( ( ruleConstraint ) )
            // InternalFirstOrderLogic.g:3863:2: ( ruleConstraint )
            {
            // InternalFirstOrderLogic.g:3863:2: ( ruleConstraint )
            // InternalFirstOrderLogic.g:3864:3: ruleConstraint
            {
             before(grammarAccess.getConstraintRuleBaseAccess().getConstraintsConstraintParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleConstraint();

            state._fsp--;

             after(grammarAccess.getConstraintRuleBaseAccess().getConstraintsConstraintParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintRuleBase__ConstraintsAssignment_4"


    // $ANTLR start "rule__Constraint__NameAssignment_1"
    // InternalFirstOrderLogic.g:3873:1: rule__Constraint__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Constraint__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3877:1: ( ( RULE_ID ) )
            // InternalFirstOrderLogic.g:3878:2: ( RULE_ID )
            {
            // InternalFirstOrderLogic.g:3878:2: ( RULE_ID )
            // InternalFirstOrderLogic.g:3879:3: RULE_ID
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
    // InternalFirstOrderLogic.g:3888:1: rule__Constraint__MessageAssignment_3 : ( RULE_STRING ) ;
    public final void rule__Constraint__MessageAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3892:1: ( ( RULE_STRING ) )
            // InternalFirstOrderLogic.g:3893:2: ( RULE_STRING )
            {
            // InternalFirstOrderLogic.g:3893:2: ( RULE_STRING )
            // InternalFirstOrderLogic.g:3894:3: RULE_STRING
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
    // InternalFirstOrderLogic.g:3903:1: rule__Constraint__VariableAssignment_5 : ( ruleVariable ) ;
    public final void rule__Constraint__VariableAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3907:1: ( ( ruleVariable ) )
            // InternalFirstOrderLogic.g:3908:2: ( ruleVariable )
            {
            // InternalFirstOrderLogic.g:3908:2: ( ruleVariable )
            // InternalFirstOrderLogic.g:3909:3: ruleVariable
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
    // InternalFirstOrderLogic.g:3918:1: rule__Constraint__FormulaAssignment_7 : ( ruleFormula ) ;
    public final void rule__Constraint__FormulaAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3922:1: ( ( ruleFormula ) )
            // InternalFirstOrderLogic.g:3923:2: ( ruleFormula )
            {
            // InternalFirstOrderLogic.g:3923:2: ( ruleFormula )
            // InternalFirstOrderLogic.g:3924:3: ruleFormula
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
    // InternalFirstOrderLogic.g:3933:1: rule__Variable__TypeAssignment_0 : ( RULE_ID ) ;
    public final void rule__Variable__TypeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3937:1: ( ( RULE_ID ) )
            // InternalFirstOrderLogic.g:3938:2: ( RULE_ID )
            {
            // InternalFirstOrderLogic.g:3938:2: ( RULE_ID )
            // InternalFirstOrderLogic.g:3939:3: RULE_ID
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
    // InternalFirstOrderLogic.g:3948:1: rule__Variable__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Variable__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3952:1: ( ( RULE_ID ) )
            // InternalFirstOrderLogic.g:3953:2: ( RULE_ID )
            {
            // InternalFirstOrderLogic.g:3953:2: ( RULE_ID )
            // InternalFirstOrderLogic.g:3954:3: RULE_ID
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
    // InternalFirstOrderLogic.g:3963:1: rule__Iff__RightAssignment_1_2 : ( ruleBinaryFormula ) ;
    public final void rule__Iff__RightAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3967:1: ( ( ruleBinaryFormula ) )
            // InternalFirstOrderLogic.g:3968:2: ( ruleBinaryFormula )
            {
            // InternalFirstOrderLogic.g:3968:2: ( ruleBinaryFormula )
            // InternalFirstOrderLogic.g:3969:3: ruleBinaryFormula
            {
             before(grammarAccess.getIffAccess().getRightBinaryFormulaParserRuleCall_1_2_0()); 
            pushFollow(FOLLOW_2);
            ruleBinaryFormula();

            state._fsp--;

             after(grammarAccess.getIffAccess().getRightBinaryFormulaParserRuleCall_1_2_0()); 

            }


            }

        }
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
    // InternalFirstOrderLogic.g:3978:1: rule__If__RightAssignment_1_2 : ( ruleXor ) ;
    public final void rule__If__RightAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3982:1: ( ( ruleXor ) )
            // InternalFirstOrderLogic.g:3983:2: ( ruleXor )
            {
            // InternalFirstOrderLogic.g:3983:2: ( ruleXor )
            // InternalFirstOrderLogic.g:3984:3: ruleXor
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
    // InternalFirstOrderLogic.g:3993:1: rule__Xor__RightAssignment_1_2 : ( ruleOr ) ;
    public final void rule__Xor__RightAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3997:1: ( ( ruleOr ) )
            // InternalFirstOrderLogic.g:3998:2: ( ruleOr )
            {
            // InternalFirstOrderLogic.g:3998:2: ( ruleOr )
            // InternalFirstOrderLogic.g:3999:3: ruleOr
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
    // InternalFirstOrderLogic.g:4008:1: rule__Or__RightAssignment_1_2 : ( ruleAnd ) ;
    public final void rule__Or__RightAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4012:1: ( ( ruleAnd ) )
            // InternalFirstOrderLogic.g:4013:2: ( ruleAnd )
            {
            // InternalFirstOrderLogic.g:4013:2: ( ruleAnd )
            // InternalFirstOrderLogic.g:4014:3: ruleAnd
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
    // InternalFirstOrderLogic.g:4023:1: rule__And__RightAssignment_1_2 : ( ruleBooleanExpression ) ;
    public final void rule__And__RightAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4027:1: ( ( ruleBooleanExpression ) )
            // InternalFirstOrderLogic.g:4028:2: ( ruleBooleanExpression )
            {
            // InternalFirstOrderLogic.g:4028:2: ( ruleBooleanExpression )
            // InternalFirstOrderLogic.g:4029:3: ruleBooleanExpression
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
    // InternalFirstOrderLogic.g:4038:1: rule__Not__NotAssignment_2 : ( ruleFormula ) ;
    public final void rule__Not__NotAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4042:1: ( ( ruleFormula ) )
            // InternalFirstOrderLogic.g:4043:2: ( ruleFormula )
            {
            // InternalFirstOrderLogic.g:4043:2: ( ruleFormula )
            // InternalFirstOrderLogic.g:4044:3: ruleFormula
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
    // InternalFirstOrderLogic.g:4053:1: rule__Equals__LeftAssignment_1 : ( ruleTerm ) ;
    public final void rule__Equals__LeftAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4057:1: ( ( ruleTerm ) )
            // InternalFirstOrderLogic.g:4058:2: ( ruleTerm )
            {
            // InternalFirstOrderLogic.g:4058:2: ( ruleTerm )
            // InternalFirstOrderLogic.g:4059:3: ruleTerm
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
    // InternalFirstOrderLogic.g:4068:1: rule__Equals__RightAssignment_3 : ( ruleTerm ) ;
    public final void rule__Equals__RightAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4072:1: ( ( ruleTerm ) )
            // InternalFirstOrderLogic.g:4073:2: ( ruleTerm )
            {
            // InternalFirstOrderLogic.g:4073:2: ( ruleTerm )
            // InternalFirstOrderLogic.g:4074:3: ruleTerm
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
    // InternalFirstOrderLogic.g:4083:1: rule__Greater__LeftAssignment_1 : ( ruleTerm ) ;
    public final void rule__Greater__LeftAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4087:1: ( ( ruleTerm ) )
            // InternalFirstOrderLogic.g:4088:2: ( ruleTerm )
            {
            // InternalFirstOrderLogic.g:4088:2: ( ruleTerm )
            // InternalFirstOrderLogic.g:4089:3: ruleTerm
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
    // InternalFirstOrderLogic.g:4098:1: rule__Greater__RightAssignment_3 : ( ruleTerm ) ;
    public final void rule__Greater__RightAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4102:1: ( ( ruleTerm ) )
            // InternalFirstOrderLogic.g:4103:2: ( ruleTerm )
            {
            // InternalFirstOrderLogic.g:4103:2: ( ruleTerm )
            // InternalFirstOrderLogic.g:4104:3: ruleTerm
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
    // InternalFirstOrderLogic.g:4113:1: rule__GreaterEqual__LeftAssignment_1 : ( ruleTerm ) ;
    public final void rule__GreaterEqual__LeftAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4117:1: ( ( ruleTerm ) )
            // InternalFirstOrderLogic.g:4118:2: ( ruleTerm )
            {
            // InternalFirstOrderLogic.g:4118:2: ( ruleTerm )
            // InternalFirstOrderLogic.g:4119:3: ruleTerm
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
    // InternalFirstOrderLogic.g:4128:1: rule__GreaterEqual__RightAssignment_3 : ( ruleTerm ) ;
    public final void rule__GreaterEqual__RightAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4132:1: ( ( ruleTerm ) )
            // InternalFirstOrderLogic.g:4133:2: ( ruleTerm )
            {
            // InternalFirstOrderLogic.g:4133:2: ( ruleTerm )
            // InternalFirstOrderLogic.g:4134:3: ruleTerm
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
    // InternalFirstOrderLogic.g:4143:1: rule__Smaller__LeftAssignment_1 : ( ruleTerm ) ;
    public final void rule__Smaller__LeftAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4147:1: ( ( ruleTerm ) )
            // InternalFirstOrderLogic.g:4148:2: ( ruleTerm )
            {
            // InternalFirstOrderLogic.g:4148:2: ( ruleTerm )
            // InternalFirstOrderLogic.g:4149:3: ruleTerm
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
    // InternalFirstOrderLogic.g:4158:1: rule__Smaller__RightAssignment_3 : ( ruleTerm ) ;
    public final void rule__Smaller__RightAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4162:1: ( ( ruleTerm ) )
            // InternalFirstOrderLogic.g:4163:2: ( ruleTerm )
            {
            // InternalFirstOrderLogic.g:4163:2: ( ruleTerm )
            // InternalFirstOrderLogic.g:4164:3: ruleTerm
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
    // InternalFirstOrderLogic.g:4173:1: rule__SmallerEqual__LeftAssignment_1 : ( ruleTerm ) ;
    public final void rule__SmallerEqual__LeftAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4177:1: ( ( ruleTerm ) )
            // InternalFirstOrderLogic.g:4178:2: ( ruleTerm )
            {
            // InternalFirstOrderLogic.g:4178:2: ( ruleTerm )
            // InternalFirstOrderLogic.g:4179:3: ruleTerm
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
    // InternalFirstOrderLogic.g:4188:1: rule__SmallerEqual__RightAssignment_3 : ( ruleTerm ) ;
    public final void rule__SmallerEqual__RightAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4192:1: ( ( ruleTerm ) )
            // InternalFirstOrderLogic.g:4193:2: ( ruleTerm )
            {
            // InternalFirstOrderLogic.g:4193:2: ( ruleTerm )
            // InternalFirstOrderLogic.g:4194:3: ruleTerm
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
    // InternalFirstOrderLogic.g:4203:1: rule__IsEmpty__TermAssignment_1 : ( ruleTerm ) ;
    public final void rule__IsEmpty__TermAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4207:1: ( ( ruleTerm ) )
            // InternalFirstOrderLogic.g:4208:2: ( ruleTerm )
            {
            // InternalFirstOrderLogic.g:4208:2: ( ruleTerm )
            // InternalFirstOrderLogic.g:4209:3: ruleTerm
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
    // InternalFirstOrderLogic.g:4218:1: rule__ForAll__NameAssignment_2 : ( ruleVariable ) ;
    public final void rule__ForAll__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4222:1: ( ( ruleVariable ) )
            // InternalFirstOrderLogic.g:4223:2: ( ruleVariable )
            {
            // InternalFirstOrderLogic.g:4223:2: ( ruleVariable )
            // InternalFirstOrderLogic.g:4224:3: ruleVariable
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
    // InternalFirstOrderLogic.g:4233:1: rule__ForAll__IterationAssignment_4 : ( ruleTerm ) ;
    public final void rule__ForAll__IterationAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4237:1: ( ( ruleTerm ) )
            // InternalFirstOrderLogic.g:4238:2: ( ruleTerm )
            {
            // InternalFirstOrderLogic.g:4238:2: ( ruleTerm )
            // InternalFirstOrderLogic.g:4239:3: ruleTerm
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
    // InternalFirstOrderLogic.g:4248:1: rule__ForAll__FormulaAssignment_6 : ( ruleFormula ) ;
    public final void rule__ForAll__FormulaAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4252:1: ( ( ruleFormula ) )
            // InternalFirstOrderLogic.g:4253:2: ( ruleFormula )
            {
            // InternalFirstOrderLogic.g:4253:2: ( ruleFormula )
            // InternalFirstOrderLogic.g:4254:3: ruleFormula
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
    // InternalFirstOrderLogic.g:4263:1: rule__Exists__NameAssignment_2 : ( ruleVariable ) ;
    public final void rule__Exists__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4267:1: ( ( ruleVariable ) )
            // InternalFirstOrderLogic.g:4268:2: ( ruleVariable )
            {
            // InternalFirstOrderLogic.g:4268:2: ( ruleVariable )
            // InternalFirstOrderLogic.g:4269:3: ruleVariable
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
    // InternalFirstOrderLogic.g:4278:1: rule__Exists__IterationAssignment_4 : ( ruleTerm ) ;
    public final void rule__Exists__IterationAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4282:1: ( ( ruleTerm ) )
            // InternalFirstOrderLogic.g:4283:2: ( ruleTerm )
            {
            // InternalFirstOrderLogic.g:4283:2: ( ruleTerm )
            // InternalFirstOrderLogic.g:4284:3: ruleTerm
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
    // InternalFirstOrderLogic.g:4293:1: rule__Exists__FormulaAssignment_6 : ( ruleFormula ) ;
    public final void rule__Exists__FormulaAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4297:1: ( ( ruleFormula ) )
            // InternalFirstOrderLogic.g:4298:2: ( ruleFormula )
            {
            // InternalFirstOrderLogic.g:4298:2: ( ruleFormula )
            // InternalFirstOrderLogic.g:4299:3: ruleFormula
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
    // InternalFirstOrderLogic.g:4308:1: rule__BoolConstant__ValueAssignment_1 : ( ( rule__BoolConstant__ValueAlternatives_1_0 ) ) ;
    public final void rule__BoolConstant__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4312:1: ( ( ( rule__BoolConstant__ValueAlternatives_1_0 ) ) )
            // InternalFirstOrderLogic.g:4313:2: ( ( rule__BoolConstant__ValueAlternatives_1_0 ) )
            {
            // InternalFirstOrderLogic.g:4313:2: ( ( rule__BoolConstant__ValueAlternatives_1_0 ) )
            // InternalFirstOrderLogic.g:4314:3: ( rule__BoolConstant__ValueAlternatives_1_0 )
            {
             before(grammarAccess.getBoolConstantAccess().getValueAlternatives_1_0()); 
            // InternalFirstOrderLogic.g:4315:3: ( rule__BoolConstant__ValueAlternatives_1_0 )
            // InternalFirstOrderLogic.g:4315:4: rule__BoolConstant__ValueAlternatives_1_0
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
    // InternalFirstOrderLogic.g:4323:1: rule__VariableRef__NameAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__VariableRef__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4327:1: ( ( ( RULE_ID ) ) )
            // InternalFirstOrderLogic.g:4328:2: ( ( RULE_ID ) )
            {
            // InternalFirstOrderLogic.g:4328:2: ( ( RULE_ID ) )
            // InternalFirstOrderLogic.g:4329:3: ( RULE_ID )
            {
             before(grammarAccess.getVariableRefAccess().getNameVariableCrossReference_1_0()); 
            // InternalFirstOrderLogic.g:4330:3: ( RULE_ID )
            // InternalFirstOrderLogic.g:4331:4: RULE_ID
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
    // InternalFirstOrderLogic.g:4342:1: rule__VariableRef__GetAssignment_2 : ( ruleGet ) ;
    public final void rule__VariableRef__GetAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4346:1: ( ( ruleGet ) )
            // InternalFirstOrderLogic.g:4347:2: ( ruleGet )
            {
            // InternalFirstOrderLogic.g:4347:2: ( ruleGet )
            // InternalFirstOrderLogic.g:4348:3: ruleGet
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
    // InternalFirstOrderLogic.g:4357:1: rule__Get__TypeAssignment_1_0 : ( RULE_ID ) ;
    public final void rule__Get__TypeAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4361:1: ( ( RULE_ID ) )
            // InternalFirstOrderLogic.g:4362:2: ( RULE_ID )
            {
            // InternalFirstOrderLogic.g:4362:2: ( RULE_ID )
            // InternalFirstOrderLogic.g:4363:3: RULE_ID
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
    // InternalFirstOrderLogic.g:4372:1: rule__Get__NameAssignment_2 : ( ( RULE_ID ) ) ;
    public final void rule__Get__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4376:1: ( ( ( RULE_ID ) ) )
            // InternalFirstOrderLogic.g:4377:2: ( ( RULE_ID ) )
            {
            // InternalFirstOrderLogic.g:4377:2: ( ( RULE_ID ) )
            // InternalFirstOrderLogic.g:4378:3: ( RULE_ID )
            {
             before(grammarAccess.getGetAccess().getNameEStructuralFeatureCrossReference_2_0()); 
            // InternalFirstOrderLogic.g:4379:3: ( RULE_ID )
            // InternalFirstOrderLogic.g:4380:4: RULE_ID
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
    // InternalFirstOrderLogic.g:4391:1: rule__Get__NextAssignment_3 : ( ruleGet ) ;
    public final void rule__Get__NextAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4395:1: ( ( ruleGet ) )
            // InternalFirstOrderLogic.g:4396:2: ( ruleGet )
            {
            // InternalFirstOrderLogic.g:4396:2: ( ruleGet )
            // InternalFirstOrderLogic.g:4397:3: ruleGet
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


    // $ANTLR start "rule__Constant__ValueAssignment_0_1"
    // InternalFirstOrderLogic.g:4406:1: rule__Constant__ValueAssignment_0_1 : ( RULE_INT ) ;
    public final void rule__Constant__ValueAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4410:1: ( ( RULE_INT ) )
            // InternalFirstOrderLogic.g:4411:2: ( RULE_INT )
            {
            // InternalFirstOrderLogic.g:4411:2: ( RULE_INT )
            // InternalFirstOrderLogic.g:4412:3: RULE_INT
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
    // InternalFirstOrderLogic.g:4421:1: rule__Constant__ValueAssignment_1_1 : ( RULE_STRING ) ;
    public final void rule__Constant__ValueAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4425:1: ( ( RULE_STRING ) )
            // InternalFirstOrderLogic.g:4426:2: ( RULE_STRING )
            {
            // InternalFirstOrderLogic.g:4426:2: ( RULE_STRING )
            // InternalFirstOrderLogic.g:4427:3: RULE_STRING
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
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000001BF5001870L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000A00000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000000000040L});

}