package com.vedantu.vedantu.DAO;

public class InventoryConfig {

    private boolean  sellable;
    private boolean canReturn;
    private boolean canReplace;
    private boolean repairInsurance;
    private boolean internationalAllowed;
    private boolean fragile;
    private boolean antique;
    private boolean premium;

    public InventoryConfig() {
    }

    public InventoryConfig(boolean sellable, boolean canReturn, boolean canReplace, boolean repairInsurance, boolean internationalAllowed, boolean fragile, boolean antique, boolean premium) {
       this.sellable = sellable;
        this.canReturn = canReturn;
        this.canReplace = canReplace;
        this.repairInsurance = repairInsurance;
        this.internationalAllowed = internationalAllowed;
       this.fragile =fragile;
       this.antique= antique;
       this. premium = premium;
    }

    public boolean isSellable() {
        return sellable;
    }

    public void setSellable(boolean sellable) {
        this.sellable = sellable;
    }

    public boolean isCanReturn() {
        return canReturn;
    }

    public void setCanReturn(boolean canReturn) {
        this.canReturn = canReturn;
    }

    public boolean isCanReplace() {
        return canReplace;
    }

    public void setCanReplace(boolean canReplace) {
        this.canReplace = canReplace;
    }

    public boolean isRepairInsurance() {
        return repairInsurance;
    }

    public void setRepairInsurance(boolean repairInsurance) {
        this.repairInsurance = repairInsurance;
    }

    public boolean isInternationalAllowed() {
        return internationalAllowed;
    }

    public void setInternationalAllowed(boolean internationalAllowed) {
        this.internationalAllowed = internationalAllowed;
    }

    public boolean isFragile() {
        return fragile;
    }

    public void setFragile(boolean fragile) {
        this.fragile = fragile;
    }

    public boolean isAntique() {
        return antique;
    }

    public void setAntique(boolean antique) {
        this.antique = antique;
    }

    public boolean isPremium() {
        return premium;
    }

    public void setPremium(boolean premium) {
        this.premium = premium;
    }
}
