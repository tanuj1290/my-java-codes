# name = raw_input()
# name = "players:tom,dick,harry,john;self:john;trump:s;dick:s10;tom:s2;harry:ca;cards:s3,sk,ha"
name = "players:tom,dick,harry,jhon;self:jhon;trump:s;dick:s10;tom:s2;harry:ca;cards:s3,sk,ha"

def card_value(card):
    values = {'j':11, 'q':12, 'k':13, 'a':14}
    if card[1].isalpha():
        return values[card[1]]
    return int(card[1])

def is_highest_card(cards_played, card_to_check):
    suit_to_check = card_to_check[0]
    same_suit_cards = [card for card in cards_played if card[0] == suit_to_check]
    return all(card_value(card)<= card_value(card_to_check) for card in same_suit_cards)

def can_win_suit(cards_held, suit_of_round, cards_played):
    round_suit_cards = [card for card in cards_held if card[0]== suit_of_round]
    
    if not round_suit_cards:
        return False
    
    highest_round_suit_card = max((card for card in cards_played if card[0]== suit_of_round), key=card_value)
    lowest_winning_card = None
    for card in round_suit_cards:
        if card_value(card) > card_value(highest_round_suit_card):
            if lowest_winning_card is None or card_value(card)<card_value(lowest_winning_card):
                lowest_winning_card= card
    return lowest_winning_card is not None

def find_smallest_card(cards_held):
    sorted_cards = sorted(cards_held, key=card_value)
    return sorted_cards[0]

def find_smallest_winning_card(cards_held, suit_of_round, cards_played):
    round_suit_cards = [card for card in cards_held if card[0] == suit_of_round]
    
    highest_round_suit_card = max((card for card in cards_played if card[0]== suit_of_round), key=card_value)
    smallest_winning_card = None
    for card in round_suit_cards:
        if card_value(card) > card_value(highest_round_suit_card):
            if smallest_winning_card is None or card_value(card)<card_value(smallest_winning_card):
                smallest_winning_card= card
    return smallest_winning_card

def find_optimal_card(input_str):
    input_components = input_str.split(';')
    input_dict = {}
    
    for component in input_components:
        key,value = component.strip().split(":")
        input_dict[key.strip()] = value.strip()
        
    players = input_dict['players'].split(',')
    self_player= input_dict['self'].strip()
    other_players = [player for player in players if player != self_player]
    
    cards_held = input_dict.get('cards').strip().split(',')
    cards_held = [card.strip() for card in cards_held]
    
    cards_played = [input_dict[player] for player in other_players]
    
    suit_of_round = input_dict[players[0]][0]
    current_player_idx = players.index(self_player)
    teammate_idx = (current_player_idx+2)%4
    teammate_card = input_dict[players[teammate_idx]]
    
    if is_highest_card(cards_played, teammate_card):
        optimal_card = find_smallest_card(cards_held)
    else:
        if can_win_suit(cards_held, suit_of_round, cards_played):
            optimal_card = find_smallest_winning_card(cards_held, suit_of_round, cards_played)
        else:
            optimal_card = find_smallest_card(cards_held)
    return optimal_card

optimal_card_played = find_optimal_card(name)
print(optimal_card_played)


""" name = "players:tom,dick,harry,jhon;self:jhon;trump:s;dick:s10;tom:s2;harry:ca;cards:s3,sk,ha"
def card_values():
    values = {'j':11, 'q':12,'k':13,'a':14}
    if card[1].isalpha():
        return values[card[1]]
    return int(card[1])

def is_highest_card(cards_played, card_to_check):
    suit_to_check = card_to_check[0]
    same_suit = [card for card in cards_played if card[0] == suit_to_check]
    return all(card_values(card) <= card_values(card_to_check) for chard in same_suit)

def can_win_suit(cards_held, suit_of_round, cards_played):
    round_suit_cards = [card for card in cards_held if card[0] == suit_of_round]
    if not round_suit_cards:
        return False
    highest_round_suit = max((card for card in cards_played if card[0] == suit_of_round), key=card_values)
    lowest_winnig_card = None
    for card in round_suit_cards:
        if(card_values(card) > card_values(highest_round_suit)):
            if(lowest_winnig_card is None or card_values(card) < card_values(lowest_winnig_card)):
                lowest_winnig_card = card
    return lowest_winnig_card is not None
            
def find_smallest_card(cards_held):
    sorted_cards = sorted(cards_held, key=card_values)
    return sorted_cards[0]

def find_smallest_winning_card(cards_held, suit_of_round, cards_played):
    round_suit_cards = [card for caard in cards_held if card[0] == suit_of_round]
    highest_round_suited_card = max((card for card in cards_played if card[0] == suit_of_round), key=card_values)
    smallest_winnig_card = None
    for card in round_suit_cards:
        if card_values(card) > card_values(highest_round_suited_card):
            if smallest_winnig_card is None or card_values(card) < card_values(smallest_winnig_card):
                smallest_winnig_card = card
    return smallest_winnig_card
def find_optimal_card(input_str):
    input_components = input_str.split(';')
    input_dict = {}
    
    for component in input_components:
        key,value = component.strip().split(":")
        input_dict[key.strip()] = value.strip()
        
    players = input_dict['players'].split(',')
    self_player= input_dict['self'].strip()
    other_players = [player for player in players if player != self_player]
    
    cards_held = input_dict.get('cards').strip().split(',')
    cards_held = [card.strip() for card in cards_held]
    
    cards_played = [input_dict[player] for player in other_players]
    
    suit_of_round = input_dict[players[0]][0]
    current_player_idx = players.index(self_player)
    teammate_idx = (current_player_idx+2)%4
    teammate_card = input_dict[players[teammate_idx]]
    
    if is_highest_card(cards_played, teammate_card):
        optimal_card = find_smallest_card(cards_held)
    else:
        if can_win_suit(cards_held, suit_of_round, cards_played):
            optimal_card = find_smallest_winning_card(cards_held, suit_of_round, cards_played)
        else:
            optimal_card = find_smallest_card(cards_held)
    return optimal_card

optimal_card_played = find_optimal_card(name)
print(optimal_card_played) """

# def find_optimal_card(input_str):
#     input_components = input_str.split(';')
#     input_dict = {}
#     for component in input_components:
#         key,value = component.strip().split(":")
#         input_dict[key.strip()] = value.strip()
#     players = input_dict['players'].split(',')
#     self_player = input_dict['self'].strip()
#     other_players = [player for player in players if player != self_player]

#     cards_held = input_dict.get('cards').strip().split(',')
#     cards_held = [card.strip() for card in cards_held]
#     cards_played = [input_dict[player] for player in other_players]
#     suit_of_round = input_dict[players[0][0]]
#     curre
    