package ro.cineseuita.data.essentials.directcontract.entity.components;

import ro.cineseuita.data.shared.entityComponents.Participant;
import ro.cineseuita.data.shared.entityComponents.ParticipantType;

public class ParticipantMinimal {

    private Long id;
    private String name;
    private ParticipantType type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ParticipantType getType() {
        return type;
    }

    public void setType(ParticipantType type) {
        this.type = type;
    }

    public static ParticipantMinimal fromParticipant(Participant participant) {
        ParticipantMinimal participantMinimal = new ParticipantMinimal();
        participantMinimal.setId(participant.getId());
        participantMinimal.setName(participant.getName());
        participantMinimal.setType(participant.getType());
        return participantMinimal;
    }
}
