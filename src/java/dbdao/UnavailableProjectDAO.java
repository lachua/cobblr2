/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbdao;

import dbdao.templates.KeyValuePair;
import dbdao.templates.QueryTemplate;
import dbentities.UnavailableProjectEntity;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Renliw
 */
public class UnavailableProjectDAO extends QueryTemplate {
    
    public static final int UNAPPROVED = 0;
    public static final int APPROVED = 1;

    //Get pending project and all other detail
    public List<UnavailableProjectEntity> getAllPendingProjects() {
        setQuery("select A.id, community_id, title, description, preparedby, objectives, scope, requirements, status, \n"
                + "	type, meetingdate, org_id, A.name as org_name, org_description, idno, firstname, lastname, org_position, \n"
                + "	A.email as org_email, homeno as org_homeno, mobileno as org_mobileno, community.name as \n"
                + "	community_name, address as community_address, phone as community_phone, mobile as \n"
                + "	community_mobile, community.email as community_email\n"
                + "from (select proj.id, proj.community_id, proj.title, proj.description, proj.preparedby, proj.objectives, proj.scope, proj.requirements, proj.status, proj.type, proj.meetingdate, org.org_id, org.name, org.description as org_description, org.idno, org.firstname, org.lastname, org.org_position, org.email, org.homeno, org.mobileno\n"
                + "		from\n"
                + "		(select * from project_charter pc left join org_projects op on pc.id = op.project_id) proj\n"
                + "		left join \n"
                + "		(select * from students s inner join studentorg so on s.org_id = so.id) org\n"
                + "		on proj.org_id = org.org_id and proj.student_idno = org.idno\n"
                + "		where status  = ?) A\n"
                + "join community ON A.community_id = community.id");

        KeyValuePair onePair;

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + 1);
        getParameters().add(onePair);

        List<UnavailableProjectEntity> results = executeQuery();

        if (results != null) {
            return results;
        } else {
            return null;
        }
    }
    
    //Get pending project and all other detail
    public List<UnavailableProjectEntity> getAllProjectsTypeOrg(int type, int org_id) {
        setQuery("select A.id, community_id, title, description, preparedby, objectives, scope, requirements, status,\n"
                + "	type, meetingdate, org_id, A.name as org_name, org_description, idno, firstname, lastname, org_position, \n"
                + "	A.email as org_email, homeno as org_homeno, mobileno as org_mobileno, community.name as \n"
                + "	community_name, address as community_address, phone as community_phone, mobile as \n"
                + "	community_mobile, community.email as community_email\n"
                + "from (select proj.id, proj.community_id, proj.title, proj.description, proj.preparedby, proj.objectives, proj.scope, proj.requirements, proj.status, proj.type, proj.meetingdate, org.org_id, org.name, org.description as org_description, org.idno, org.firstname, org.lastname, org.org_position, org.email, org.homeno, org.mobileno\n"
                + "		from\n"
                + "		(select * from project_charter pc left join org_projects op on pc.id = op.project_id) proj\n"
                + "		left join \n"
                + "		(select * from students s inner join studentorg so on s.org_id = so.id) org\n"
                + "		on proj.org_id = org.org_id and proj.student_idno = org.idno\n"
                + "		where status  = ? and org.org_id = ?) A\n"
                + "join community ON A.community_id = community.id");

        KeyValuePair onePair;

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + type);
        getParameters().add(onePair);
        
        
        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + org_id);
        getParameters().add(onePair);

        List<UnavailableProjectEntity> results = executeQuery();

        if (results != null) {
            return results;
        } else {
            return null;
        }
    }
    
    //Get pending project and all other detail
    public List<UnavailableProjectEntity> getAllProjectsTypeOrgCommunity(int type, int org_id) {
        setQuery("select A.id, community_id, title, description, preparedby, objectives, scope, requirements, status,\n"
                + "	type, meetingdate, org_id, A.name as org_name, org_description, idno, firstname, lastname, org_position, \n"
                + "	A.email as org_email, homeno as org_homeno, mobileno as org_mobileno, community.name as \n"
                + "	community_name, address as community_address, phone as community_phone, mobile as \n"
                + "	community_mobile, community.email as community_email\n"
                + "from (select proj.id, proj.community_id, proj.title, proj.description, proj.preparedby, proj.objectives, proj.scope, proj.requirements, proj.status, proj.type, proj.meetingdate, org.org_id, org.name, org.description as org_description, org.idno, org.firstname, org.lastname, org.org_position, org.email, org.homeno, org.mobileno\n"
                + "		from\n"
                + "		(select * from project_charter pc left join org_projects op on pc.id = op.project_id) proj\n"
                + "		left join \n"
                + "		(select * from students s inner join studentorg so on s.org_id = so.id) org\n"
                + "		on proj.org_id = org.org_id and proj.student_idno = org.idno\n"
                + "		where status  = ? and org.org_id = ?) A\n"
                + "join community ON A.community_id = community.id "
                + "group by community_id");

        KeyValuePair onePair;

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + type);
        getParameters().add(onePair);
        
        
        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + org_id);
        getParameters().add(onePair);

        List<UnavailableProjectEntity> results = executeQuery();

        if (results != null) {
            return results;
        } else {
            return null;
        }
    }
    
    //Get pending project and all other detail
    public List<UnavailableProjectEntity> getAllProjectsType(int type) {
        setQuery("select A.id, community_id, title, description, preparedby, objectives, scope, requirements, status,\n"
                + "	type, meetingdate, org_id, A.name as org_name, org_description, idno, firstname, lastname, org_position, \n"
                + "	A.email as org_email, homeno as org_homeno, mobileno as org_mobileno, community.name as \n"
                + "	community_name, address as community_address, phone as community_phone, mobile as \n"
                + "	community_mobile, community.email as community_email\n"
                + "from (select proj.id, proj.community_id, proj.title, proj.description, proj.preparedby, proj.objectives, proj.scope, proj.requirements, proj.status, proj.type, proj.meetingdate, org.org_id, org.name, org.description as org_description, org.idno, org.firstname, org.lastname, org.org_position, org.email, org.homeno, org.mobileno\n"
                + "		from\n"
                + "		(select * from project_charter pc left join org_projects op on pc.id = op.project_id) proj\n"
                + "		left join \n"
                + "		(select * from students s inner join studentorg so on s.org_id = so.id) org\n"
                + "		on proj.org_id = org.org_id and proj.student_idno = org.idno\n"
                + "		where status  = ?) A\n"
                + "join community ON A.community_id = community.id");

        KeyValuePair onePair;

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + type);
        getParameters().add(onePair);
        
        List<UnavailableProjectEntity> results = executeQuery();

        if (results != null) {
            return results;
        } else {
            return null;
        }
    }
    
    //Get pending project and all other detail
    public List<UnavailableProjectEntity> getAllProjectsTypeArraneDateDesc(int type) {
        setQuery("select A.id, community_id, title, description, preparedby, objectives, scope, requirements, status,\n"
                + "	type, meetingdate, org_id, A.name as org_name, org_description, idno, firstname, lastname, org_position, \n"
                + "	A.email as org_email, homeno as org_homeno, mobileno as org_mobileno, community.name as \n"
                + "	community_name, address as community_address, phone as community_phone, mobile as \n"
                + "	community_mobile, community.email as community_email\n"
                + "from (select proj.id, proj.community_id, proj.title, proj.description, proj.preparedby, proj.objectives, proj.scope, proj.requirements, proj.status, proj.type, proj.meetingdate, org.org_id, org.name, org.description as org_description, org.idno, org.firstname, org.lastname, org.org_position, org.email, org.homeno, org.mobileno\n"
                + "		from\n"
                + "		(select * from project_charter pc left join org_projects op on pc.id = op.project_id) proj\n"
                + "		left join \n"
                + "		(select * from students s inner join studentorg so on s.org_id = so.id) org\n"
                + "		on proj.org_id = org.org_id and proj.student_idno = org.idno\n"
                + "		where status  = ?) A\n"
                + "join community ON A.community_id = community.id "
                + "order by meetingdate desc");

        KeyValuePair onePair;

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + type);
        getParameters().add(onePair);
        
        List<UnavailableProjectEntity> results = executeQuery();

        if (results != null) {
            return results;
        } else {
            return null;
        }
    }
    
     //Get pending project and all other detail
    public List<UnavailableProjectEntity> getAllProjectsTypeCommunity(int type) {
        setQuery("select A.id, community_id, title, description, preparedby, objectives, scope, requirements, status,\n"
                + "	type, meetingdate, org_id, A.name as org_name, org_description, idno, firstname, lastname, org_position, \n"
                + "	A.email as org_email, homeno as org_homeno, mobileno as org_mobileno, community.name as \n"
                + "	community_name, address as community_address, phone as community_phone, mobile as \n"
                + "	community_mobile, community.email as community_email\n"
                + "from (select proj.id, proj.community_id, proj.title, proj.description, proj.preparedby, proj.objectives, proj.scope, proj.requirements, proj.status, proj.type, proj.meetingdate, org.org_id, org.name, org.description as org_description, org.idno, org.firstname, org.lastname, org.org_position, org.email, org.homeno, org.mobileno\n"
                + "		from\n"
                + "		(select * from project_charter pc left join org_projects op on pc.id = op.project_id) proj\n"
                + "		left join \n"
                + "		(select * from students s inner join studentorg so on s.org_id = so.id) org\n"
                + "		on proj.org_id = org.org_id and proj.student_idno = org.idno\n"
                + "		where status  = ?) A\n"
                + "join community ON A.community_id = community.id "
                + "group by community_id");

        KeyValuePair onePair;

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + type);
        getParameters().add(onePair);
        
        List<UnavailableProjectEntity> results = executeQuery();

        if (results != null) {
            return results;
        } else {
            return null;
        }
    }
    
    
    //Get pending project for project_id
    public UnavailableProjectEntity getPendingProjects(int project_id) {
        setQuery("select A.id, community_id, title, description, preparedby, objectives, scope, requirements, status, \n"
                + "	type, meetingdate, org_id, A.name as org_name, org_description, idno, firstname, lastname, org_position, \n"
                + "	A.email as org_email, homeno as org_homeno, mobileno as org_mobileno, community.name as \n"
                + "	community_name, address as community_address, phone as community_phone, mobile as \n"
                + "	community_mobile, community.email as community_email\n"
                + "from (select proj.id, proj.community_id, proj.title, proj.description, proj.preparedby, proj.objectives, proj.scope, proj.requirements, proj.status, proj.type, proj.meetingdate, org.org_id, org.name, org.description as org_description, org.idno, org.firstname, org.lastname, org.org_position, org.email, org.homeno, org.mobileno\n"
                + "		from\n"
                + "		(select * from project_charter pc left join org_projects op on pc.id = op.project_id) proj\n"
                + "		left join \n"
                + "		(select * from students s inner join studentorg so on s.org_id = so.id) org\n"
                + "		on proj.org_id = org.org_id and proj.student_idno = org.idno\n"
                + "		where status  = ? and  proj.id = ?) A\n"
                + "join community ON A.community_id = community.id");

        KeyValuePair onePair;

        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + 1);
        getParameters().add(onePair);
        
        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + project_id);
        getParameters().add(onePair);

        List<UnavailableProjectEntity> results = executeQuery();

        if (results != null) {
            return results.get(0);
        } else {
            return null;
        }
    }
    
    
    public UnavailableProjectEntity getUnavailableProject(int project_id) {
        setQuery("select A.id, community_id, title, description, preparedby, objectives, scope, requirements, status, \n"
                + "	type, meetingdate, org_id, A.name as org_name, org_description, idno, firstname, lastname, org_position, \n"
                + "	A.email as org_email, homeno as org_homeno, mobileno as org_mobileno, community.name as \n"
                + "	community_name, address as community_address, phone as community_phone, mobile as \n"
                + "	community_mobile, community.email as community_email\n"
                + "from (select proj.id, proj.community_id, proj.title, proj.description, proj.preparedby, proj.objectives, proj.scope, proj.requirements, proj.status, proj.type, proj.meetingdate, org.org_id, org.name, org.description as org_description, org.idno, org.firstname, org.lastname, org.org_position, org.email, org.homeno, org.mobileno\n"
                + "		from\n"
                + "		(select * from project_charter pc left join org_projects op on pc.id = op.project_id) proj\n"
                + "		left join \n"
                + "		(select * from students s inner join studentorg so on s.org_id = so.id) org\n"
                + "		on proj.org_id = org.org_id and proj.student_idno = org.idno\n"
                + "		where  proj.id = ?) A\n"
                + "join community ON A.community_id = community.id");

        KeyValuePair onePair;
        
        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + project_id);
        getParameters().add(onePair);

        List<UnavailableProjectEntity> results = executeQuery();

        if (results != null) {
            return results.get(0);
        } else {
            return null;
        }
    }
    
       public List<UnavailableProjectEntity>  getPreactsProjects(int approved) {
        setQuery("select A.id, community_id, A.title, description, preparedby, objectives, scope, requirements, status,\n" +
"	type, meetingdate, org_id, A.name as org_name, org_description, idno, firstname, lastname, org_position, \n" +
"	A.email as org_email, homeno as org_homeno, mobileno as org_mobileno, community.name as \n" +
"	community_name, address as community_address, phone as community_phone, mobile as \n" +
"	community_mobile, community.email as community_email\n" +
"from (select proj.id, proj.community_id, proj.title, proj.description, proj.preparedby, proj.objectives, proj.scope, proj.requirements, proj.status, proj.type, proj.meetingdate, org.org_id, org.name, org.description as org_description, org.idno, org.firstname, org.lastname, org.org_position, org.email, org.homeno, org.mobileno\n" +
"		from\n" +
"		(select * from project_charter pc left join org_projects op on pc.id = op.project_id) proj\n" +
"		left join \n" +
"		(select * from students s inner join studentorg so on s.org_id = so.id) org\n" +
"		on proj.org_id = org.org_id and proj.student_idno = org.idno\n" +
"		where status  = 2) A\n" +
"join community ON A.community_id = community.id \n" +
"				join (\n" +
"					select * from project_tasks where resource_type = \"pre-acts\"\n" +
"				) pt \n" +
"				ON A.id = pt.proj_id\n" +
"				where pt.completed = ?");

        KeyValuePair onePair;
        
        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + approved);
        getParameters().add(onePair);

        List<UnavailableProjectEntity> results = executeQuery();

        if (results != null) {
            return results;
        } else {
            return null;
        }
    }
       
       public List<UnavailableProjectEntity>  getPreactsProjectsCommunity(int approved) {
        setQuery("select A.id, community_id, A.title, description, preparedby, objectives, scope, requirements, status,\n" +
                "	type, meetingdate, org_id, A.name as org_name, org_description, idno, firstname, lastname, org_position, \n" +
                "	A.email as org_email, homeno as org_homeno, mobileno as org_mobileno, community.name as \n" +
                "	community_name, address as community_address, phone as community_phone, mobile as \n" +
                "	community_mobile, community.email as community_email\n" +
                "from (select proj.id, proj.community_id, proj.title, proj.description, proj.preparedby, proj.objectives, proj.scope, proj.requirements, proj.status, proj.type, proj.meetingdate, org.org_id, org.name, org.description as org_description, org.idno, org.firstname, org.lastname, org.org_position, org.email, org.homeno, org.mobileno\n" +
                "		from\n" +
                "		(select * from project_charter pc left join org_projects op on pc.id = op.project_id) proj\n" +
                "		left join \n" +
                "		(select * from students s inner join studentorg so on s.org_id = so.id) org\n" +
                "		on proj.org_id = org.org_id and proj.student_idno = org.idno\n" +
                "		where status  = 2) A\n" +
                "join community ON A.community_id = community.id \n" +
                "				join (\n" +
                "					select * from project_tasks where resource_type = \"pre-acts\"\n" +
                "				) pt \n" +
                "ON A.id = pt.proj_id\n" +
                "where pt.completed = ?\n"+
                "group by A.community_id");

        KeyValuePair onePair;
        
        onePair = new KeyValuePair();
        onePair.setKey(KeyValuePair.INT);
        onePair.setValue("" + approved);
        getParameters().add(onePair);

        List<UnavailableProjectEntity> results = executeQuery();

        if (results != null) {
            return results;
        } else {
            return null;
        }
    }

    @Override
    protected Object storeResults(ResultSet rs) {
        UnavailableProjectEntity entity = new UnavailableProjectEntity();
        try {
            entity.setProject_id(rs.getInt("id"));
        } catch (SQLException ex) {
            Logger.getLogger(UserEntityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setCommunity_id(rs.getInt("community_id"));
        } catch (SQLException ex) {
            Logger.getLogger(UserEntityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setTitle(rs.getString("title"));
        } catch (SQLException ex) {
            Logger.getLogger(UserEntityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setDescription(rs.getString("description"));
        } catch (SQLException ex) {
            Logger.getLogger(UserEntityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setPreparedby(rs.getString("preparedby"));
        } catch (SQLException ex) {
            Logger.getLogger(UserEntityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setObjectives(rs.getString("objectives"));
        } catch (SQLException ex) {
            Logger.getLogger(UserEntityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setScope(rs.getString("scope"));
        } catch (SQLException ex) {
            Logger.getLogger(UserEntityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setRequirements(rs.getString("requirements"));
        } catch (SQLException ex) {
            Logger.getLogger(UserEntityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setStatus(rs.getInt("status"));
        } catch (SQLException ex) {
            Logger.getLogger(UserEntityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setType(rs.getString("type"));
        } catch (SQLException ex) {
            Logger.getLogger(UserEntityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setMeetingdate(rs.getDate("meetingdate"));
        } catch (SQLException ex) {
            Logger.getLogger(UserEntityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setOrg_id(rs.getInt("org_id"));
        } catch (SQLException ex) {
            Logger.getLogger(UserEntityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setOrg_name(rs.getString("org_name"));
        } catch (SQLException ex) {
            Logger.getLogger(UserEntityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setStudent_idno(rs.getInt("idno"));
        } catch (SQLException ex) {
            Logger.getLogger(UserEntityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setStudent_firstname(rs.getString("firstname"));
        } catch (SQLException ex) {
            Logger.getLogger(UserEntityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setStudent_lastname(rs.getString("lastname"));
        } catch (SQLException ex) {
            Logger.getLogger(UserEntityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setStudent_position(rs.getString("org_position"));
        } catch (SQLException ex) {
            Logger.getLogger(UserEntityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setStudent_email(rs.getString("org_email"));
        } catch (SQLException ex) {
            Logger.getLogger(UserEntityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setStudent_homeno(rs.getString("org_homeno"));
        } catch (SQLException ex) {
            Logger.getLogger(UserEntityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setStudent_mobileno(rs.getString("org_mobileno"));
        } catch (SQLException ex) {
            Logger.getLogger(UserEntityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setCommunity_name(rs.getString("community_name"));
        } catch (SQLException ex) {
            Logger.getLogger(UserEntityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setCommunity_address(rs.getString("community_address"));
        } catch (SQLException ex) {
            Logger.getLogger(UserEntityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setCommunity_phone(rs.getString("community_phone"));
        } catch (SQLException ex) {
            Logger.getLogger(UserEntityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setCommunity_mobile(rs.getString("community_mobile"));
        } catch (SQLException ex) {
            Logger.getLogger(UserEntityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            entity.setCommunity_email(rs.getString("community_email"));
        } catch (SQLException ex) {
            Logger.getLogger(UserEntityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return entity;
    }

}
