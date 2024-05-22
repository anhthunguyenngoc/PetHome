package screen;

import java.util.Objects;

import entity.pet.Pet;
import handler.BaseHandler;

public class ItemPetInfoScreen extends BaseScreen{
	
	private Pet pet = new Pet();

	public ItemPetInfoScreen(BaseHandler controller, Pet pet) {
		super("item-pet-info", controller);
		this.pet = pet;
		// TODO Auto-generated constructor stub
	}

	public Pet getPet() {
		return pet;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemPetInfoScreen other = (ItemPetInfoScreen) obj;
		return Objects.equals(pet, other.pet);
	}

}
