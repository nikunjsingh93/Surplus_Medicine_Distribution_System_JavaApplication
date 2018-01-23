/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Role;


import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import UserInterface.AdministrativeRole.AdminWorkAreaJPanel;
import UserInterface.Disposable.DisposableWorkAreaJPanel;
import UserInterface.NGORole.NgoWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author NIKUNJ
 */

public class DisposableRole extends Role {
    
     @Override
    public JPanel createWorkArea(JPanel container, UserAccount account, Organization organization, Enterprise enterprise, Network network, EcoSystem business) {
     return new DisposableWorkAreaJPanel(container, enterprise,network, account);
    }

    
}
