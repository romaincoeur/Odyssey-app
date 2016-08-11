package fr.wildcodeschool.odyssey;

/**
 * Created by romain on 11/08/16.
 */
public class Quest {
    private long id;
    private String title;
    private String _abstract;
    private String objectives;
    private String challengeTitle;
    private String challengeBody;
    private String challengeCriteria;
    private String parcours;

    public Quest(long id, String title, String _abstract, String objectives, String challengeTitle, String challengeBody, String challengeCriteria, String parcours) {
        this.id = id;
        this.title = title;
        this._abstract = _abstract;
        this.objectives = objectives;
        this.challengeTitle = challengeTitle;
        this.challengeBody = challengeBody;
        this.challengeCriteria = challengeCriteria;
        this.parcours = parcours;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String get_abstract() {
        return _abstract;
    }

    public void set_abstract(String _abstract) {
        this._abstract = _abstract;
    }

    public String getObjectives() {
        return objectives;
    }

    public void setObjectives(String objectives) {
        this.objectives = objectives;
    }

    public String getChallengeTitle() {
        return challengeTitle;
    }

    public void setChallengeTitle(String challengeTitle) {
        this.challengeTitle = challengeTitle;
    }

    public String getChallengeBody() {
        return challengeBody;
    }

    public void setChallengeBody(String challengeBody) {
        this.challengeBody = challengeBody;
    }

    public String getChallengeCriteria() {
        return challengeCriteria;
    }

    public void setChallengeCriteria(String challengeCriteria) {
        this.challengeCriteria = challengeCriteria;
    }

    public String getParcours() {
        return parcours;
    }

    public void setParcours(String parcours) {
        this.parcours = parcours;
    }
}
