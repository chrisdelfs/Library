/*     */ package library.daos;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import library.interfaces.daos.IMemberDAO;
/*     */ import library.interfaces.daos.IMemberHelper;
/*     */ import library.interfaces.entities.IMember;
/*     */ 
/*     */ public class MemberMapDAO implements IMemberDAO
/*     */ {
/*     */   private IMemberHelper helper;
/*     */   private Map<Integer, IMember> memberMap;
/*     */   private int nextID;
/*     */   
/*     */   public MemberMapDAO(IMemberHelper helper)
/*     */   {
/*  20 */     if (helper == null) {
/*  21 */       throw new IllegalArgumentException(
/*  22 */         String.format("MemberMapDAO : constructor : helper cannot be null.", new Object[0]));
/*     */     }
/*  24 */     this.helper = helper;
/*  25 */     this.memberMap = new HashMap();
/*  26 */     this.nextID = 1;
/*     */   }
/*     */   
/*     */   public MemberMapDAO(IMemberHelper helper, Map<Integer, IMember> memberMap) {
/*  30 */     this(helper);
/*  31 */     if (memberMap == null) {
/*  32 */       throw new IllegalArgumentException(
/*  33 */         String.format("MemberMapDAO : constructor : memberMap cannot be null.", new Object[0]));
/*     */     }
/*  35 */     this.memberMap = memberMap;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public IMember addMember(String firstName, String lastName, String contactPhone, String emailAddress)
/*     */   {
/*  42 */     int id = getNextId();
/*  43 */     IMember mem = this.helper.makeMember(firstName, lastName, contactPhone, emailAddress, id);
/*  44 */     this.memberMap.put(Integer.valueOf(id), mem);
/*  45 */     return mem;
/*     */   }
/*     */   
/*     */   public IMember getMemberByID(int id)
/*     */   {
/*  50 */     if (this.memberMap.keySet().contains(Integer.valueOf(id))) {
/*  51 */       return (IMember)this.memberMap.get(Integer.valueOf(id));
/*     */     }
/*  53 */     return null;
/*     */   }
/*     */   
/*     */   public List<IMember> listMembers()
/*     */   {
/*  58 */     List<IMember> list = new ArrayList(this.memberMap.values());
/*  59 */     return Collections.unmodifiableList(list);
/*     */   }
/*     */   
/*     */   public List<IMember> findMembersByLastName(String lastName)
/*     */   {
/*  64 */     if ((lastName == null) || (lastName.isEmpty())) {
/*  65 */       throw new IllegalArgumentException(
/*  66 */         String.format("MemberMapDAO : findMembersByLastName : lastName cannot be null or blank", new Object[0]));
/*     */     }
/*  68 */     List<IMember> list = new ArrayList();
/*  69 */     for (IMember m : this.memberMap.values()) {
/*  70 */       if (lastName.equals(m.getLastName())) {
/*  71 */         list.add(m);
/*     */       }
/*     */     }
/*  74 */     return Collections.unmodifiableList(list);
/*     */   }
/*     */   
/*     */   public List<IMember> findMembersByEmailAddress(String emailAddress)
/*     */   {
/*  79 */     if ((emailAddress == null) || (emailAddress.isEmpty())) {
/*  80 */       throw new IllegalArgumentException(
/*  81 */         String.format("MemberMapDAO : findMembersByEmailAddress : emailAddress cannot be null or blank", new Object[0]));
/*     */     }
/*  83 */     List<IMember> list = new ArrayList();
/*  84 */     for (IMember m : this.memberMap.values()) {
/*  85 */       if (emailAddress.equals(m.getEmailAddress())) {
/*  86 */         list.add(m);
/*     */       }
/*     */     }
/*  89 */     return Collections.unmodifiableList(list);
/*     */   }
/*     */   
/*     */   public List<IMember> findMembersByNames(String firstName, String lastName)
/*     */   {
/*  94 */     if ((firstName == null) || (firstName.isEmpty()) || (lastName == null) || (lastName.isEmpty())) {
/*  95 */       throw new IllegalArgumentException(
/*  96 */         String.format("MemberMapDAO : findMembersByNames : firstName and lastName cannot be null or blank", new Object[0]));
/*     */     }
/*  98 */     List<IMember> list = new ArrayList();
/*  99 */     for (IMember m : this.memberMap.values()) {
/* 100 */       if ((firstName.equals(m.getFirstName())) && (lastName.equals(m.getLastName()))) {
/* 101 */         list.add(m);
/*     */       }
/*     */     }
/* 104 */     return Collections.unmodifiableList(list);
/*     */   }
/*     */   
/*     */   private int getNextId() {
/* 108 */     return this.nextID++;
/*     */   }
/*     */ }


/* Location:              C:\Users\Chris\Documents\NetBeansProjects\Asg3\ITC515_NewLibrary_Java.jar!\library\daos\MemberMapDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */