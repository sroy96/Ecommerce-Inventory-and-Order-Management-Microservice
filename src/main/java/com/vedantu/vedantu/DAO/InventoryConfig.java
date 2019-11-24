package com.vedantu.vedantu.DAO;

public class InventoryConfig {

    private boolean isSellable;
    private boolean canReturn;
    private boolean canReplace;
    private boolean repairInsurance;
    private boolean internationalAllowed;
    private boolean isFragile;
    private boolean isAntique;
    private boolean isPremium;

    public InventoryConfig() {
    }

    public InventoryConfig(boolean isSellable, boolean canReturn, boolean canReplace, boolean repairInsurance, boolean internationalAllowed, boolean isFragile, boolean isAntique, boolean isPremium) {
        this.isSellable = isSellable;
        this.canReturn = canReturn;
        this.canReplace = canReplace;
        this.repairInsurance = repairInsurance;
        this.internationalAllowed = internationalAllowed;
        this.isFragile = isFragile;
        this.isAntique = isAntique;
        this.isPremium = isPremium;
    }

    public boolean isSellable() {
        return isSellable;
    }

    public void setSellable(boolean sellable) {
        isSellable = sellable;
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
        return isFragile;
    }

    public void setFragile(boolean fragile) {
        isFragile = fragile;
    }

    public boolean isAntique() {
        return isAntique;
    }

    public void setAntique(boolean antique) {
        isAntique = antique;
    }

    public boolean isPremium() {
        return isPremium;
    }

    public void setPremium(boolean premium) {
        isPremium = premium;
    }
}
